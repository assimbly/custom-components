/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.assimbly.mail.dataformat.mime.multipart;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.regex.Pattern;

import jakarta.activation.DataHandler;
import jakarta.activation.DataSource;
import jakarta.mail.BodyPart;
import jakarta.mail.Header;
import jakarta.mail.MessagingException;
import jakarta.mail.Part;
import jakarta.mail.Session;
import jakarta.mail.internet.ContentType;
import jakarta.mail.internet.InternetHeaders;
import jakarta.mail.internet.MimeBodyPart;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.internet.MimeMultipart;
import jakarta.mail.internet.MimeUtility;
import jakarta.mail.internet.ParseException;
import jakarta.mail.util.ByteArrayDataSource;

import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.NoTypeConversionAvailableException;
import org.apache.camel.attachment.Attachment;
import org.apache.camel.attachment.AttachmentMessage;
import org.apache.camel.attachment.DefaultAttachment;
import org.apache.camel.spi.annotations.Dataformat;
import org.apache.camel.support.DefaultDataFormat;
import org.apache.camel.support.ExchangeHelper;
import org.apache.camel.support.MessageHelper;
import org.apache.camel.util.IOHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Dataformat("mimeMultipart")
public class MimeMultipartDataFormat extends DefaultDataFormat {
    private static final Logger LOG = LoggerFactory.getLogger(MimeMultipartDataFormat.class);
    private static final String MIME_VERSION = "MIME-Version";
    private static final String CONTENT_TYPE = "Content-Type";
    private static final String CONTENT_TRANSFER_ENCODING = "Content-Transfer-Encoding";
    private static final String DEFAULT_CONTENT_TYPE = "application/octet-stream";
    private static final String[] STANDARD_HEADERS = { "Message-ID", "MIME-Version", "Content-Type" };
    private String multipartSubType = "mixed";
    private boolean multipartWithoutAttachment;
    private boolean headersInline;
    private String includeHeaders;
    private Pattern includeHeadersPattern;
    private boolean binaryContent;

    public void setBinaryContent(boolean binaryContent) {
        this.binaryContent = binaryContent;
    }

    public void setHeadersInline(boolean headersInline) {
        this.headersInline = headersInline;
    }

    public void setIncludeHeaders(String includeHeaders) {
        this.includeHeaders = includeHeaders;
    }

    public void setMultipartWithoutAttachment(boolean multipartWithoutAttachment) {
        this.multipartWithoutAttachment = multipartWithoutAttachment;
    }

    public void setMultipartSubType(String multipartSubType) {
        this.multipartSubType = multipartSubType;
    }

    @Override
    public void marshal(Exchange exchange, Object graph, OutputStream stream)
            throws NoTypeConversionAvailableException, MessagingException, IOException {
        if (multipartWithoutAttachment || headersInline || exchange.getIn(AttachmentMessage.class).hasAttachments()) {
            ContentType contentType = getContentType(exchange);
            // remove the Content-Type header. This will be wrong afterwards...
            exchange.getMessage().removeHeader(Exchange.CONTENT_TYPE);
            byte[] bodyContent = ExchangeHelper.convertToMandatoryType(exchange, byte[].class, graph);
            Session session = Session.getInstance(System.getProperties());
            MimeMessage mm = new MimeMessage(session);
            MimeMultipart mp = new MimeMultipart(multipartSubType);
            BodyPart part = new MimeBodyPart();
            writeBodyPart(bodyContent, part, contentType);
            mp.addBodyPart(part);
            if (exchange.getIn(AttachmentMessage.class).hasAttachments()) {
                List<String> idsToRemove = new ArrayList<>();
                for (Map.Entry<String, Attachment> entry : exchange.getIn(AttachmentMessage.class).getAttachmentObjects()
                        .entrySet()) {
                    String attachmentFilename = entry.getKey();
                    Attachment attachment = entry.getValue();
                    part = new MimeBodyPart();
                    part.setDataHandler(attachment.getDataHandler());
                    part.setFileName(MimeUtility.encodeText(attachmentFilename, "UTF-8", null));
                    String ct = attachment.getDataHandler().getContentType();
                    contentType = new ContentType(ct);
                    part.setHeader(CONTENT_TYPE, ct);
                    if (!contentType.match("text/*") && binaryContent) {
                        part.setHeader(CONTENT_TRANSFER_ENCODING, "binary");
                    } else {
                        //Comment code to keep it consistent with camel2/Dovetail
                        //setContentTransferEncoding(part, contentType);
                    }
                    // Set headers to the attachment
                    for (String headerName : attachment.getHeaderNames()) {
                        List<String> values = attachment.getHeaderAsList(headerName);
                        for (String value : values) {
                            part.setHeader(headerName, value);
                        }
                    }
                    mp.addBodyPart(part);
                    idsToRemove.add(attachmentFilename);
                }
                for (String id : idsToRemove) {
                    exchange.getMessage(AttachmentMessage.class).removeAttachment(id);
                }
            }
            mm.setContent(mp);
            // copy headers if required and if the content can be converted into
            // a String
            if (headersInline && includeHeadersPattern != null) {
                for (Map.Entry<String, Object> entry : exchange.getIn().getHeaders().entrySet()) {
                    if (includeHeadersPattern.matcher(entry.getKey()).matches()) {
                        String headerStr = ExchangeHelper.convertToType(exchange, String.class, entry.getValue());
                        if (headerStr != null) {
                            mm.setHeader(entry.getKey(), headerStr);
                        }
                    }
                }
            }
            mm.saveChanges();
            Enumeration<?> hl = mm.getAllHeaders();
            List<String> headers = new ArrayList<>();
            if (!headersInline) {
                while (hl.hasMoreElements()) {
                    Object ho = hl.nextElement();
                    if (ho instanceof Header) {
                        Header h = (Header) ho;
                        exchange.getMessage().setHeader(h.getName(), h.getValue());
                        headers.add(h.getName());
                    }
                }
            }
            //mm.writeTo(stream, headers.toArray(new String[0]));
            //Workaround to apply the body also for InOut exchanges
            ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
            mm.writeTo(byteStream, headers.toArray(new String[0]));
            exchange.getIn().setBody(byteStream.toString());
        } else {
            // keep the original data
            InputStream is = ExchangeHelper.convertToMandatoryType(exchange, InputStream.class, graph);
            IOHelper.copyAndCloseInput(is, stream);
        }
    }

    private ContentType getContentType(Exchange exchange) throws ParseException {
        String contentTypeStr = ExchangeHelper.getContentType(exchange);
        if (contentTypeStr == null) {
            contentTypeStr = DEFAULT_CONTENT_TYPE;
        }
        ContentType contentType = new ContentType(contentTypeStr);
        String contentEncoding = ExchangeHelper.getContentEncoding(exchange);
        // add a charset parameter for text subtypes
        if (contentEncoding != null && contentType.match("text/*")) {
            contentType.setParameter("charset", MimeUtility.mimeCharset(contentEncoding));
        }
        return contentType;
    }

    private void writeBodyPart(byte[] bodyContent, Part part, ContentType contentType) throws MessagingException {
        DataSource ds = new ByteArrayDataSource(bodyContent, contentType.toString());
        part.setDataHandler(new DataHandler(ds));
        setContentTransferEncoding(part, contentType);
    }

    private void setContentTransferEncoding(Part part, ContentType contentType) throws MessagingException {
        part.setHeader(CONTENT_TYPE, contentType.toString());
        if (contentType.match("text/*")) {
            part.setHeader(CONTENT_TRANSFER_ENCODING, "8bit");
        } else if (binaryContent) {
            part.setHeader(CONTENT_TRANSFER_ENCODING, "binary");
        } else {
            part.setHeader(CONTENT_TRANSFER_ENCODING, "base64");
        }
    }

    @Override
    public Object unmarshal(Exchange exchange, InputStream stream) throws IOException, MessagingException {
        MimeBodyPart mimeMessage;
        String contentType;
        Message camelMessage;
        Object content = null;
        if (headersInline) {
            mimeMessage = new MimeBodyPart(stream);
            camelMessage = exchange.getMessage();
            MessageHelper.copyHeaders(exchange.getIn(), camelMessage, true);
            // write the MIME headers not generated by javamail as Camel headers
            Enumeration<?> headersEnum = mimeMessage.getNonMatchingHeaders(STANDARD_HEADERS);
            while (headersEnum.hasMoreElements()) {
                Object ho = headersEnum.nextElement();
                if (ho instanceof Header) {
                    Header header = (Header) ho;
                    camelMessage.setHeader(header.getName(), header.getValue());
                }
            }
        } else {
            // check if this a multipart at all. Otherwise do nothing
            contentType = exchange.getIn().getHeader(CONTENT_TYPE, String.class);
            if (contentType == null) {
                return stream;
            }
            try {
                ContentType ct = new ContentType(contentType);
                if (!ct.match("multipart/*")) {
                    return stream;
                }
            } catch (ParseException e) {
                LOG.warn("Invalid Content-Type {} ignored", contentType);
                return stream;
            }
            camelMessage = exchange.getMessage();
            MessageHelper.copyHeaders(exchange.getIn(), camelMessage, true);
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            IOHelper.copyAndCloseInput(stream, bos);
            InternetHeaders headers = new InternetHeaders();
            extractHeader(CONTENT_TYPE, camelMessage, headers);
            extractHeader(MIME_VERSION, camelMessage, headers);
            mimeMessage = new MimeBodyPart(headers, bos.toByteArray());
            bos.close();
        }
        DataHandler dh;
        try {
            dh = mimeMessage.getDataHandler();
            if (dh != null) {
                content = dh.getContent();
            }
        } catch (MessagingException e) {
            LOG.warn("cannot parse message, no unmarshalling done");
        }
        if (content instanceof MimeMultipart) {
            MimeMultipart mp = (MimeMultipart) content;
            content = mp.getBodyPart(0);
            for (int i = 1; i < mp.getCount(); i++) {
                BodyPart bp = mp.getBodyPart(i);
                DefaultAttachment camelAttachment = new DefaultAttachment(bp.getDataHandler());
                @SuppressWarnings("unchecked")
                Enumeration<Header> headers = bp.getAllHeaders();
                while (headers.hasMoreElements()) {
                    Header header = headers.nextElement();
                    camelAttachment.addHeader(header.getName(), header.getValue());
                }
                camelMessage.getExchange().getMessage(AttachmentMessage.class).addAttachmentObject(getAttachmentKey(bp),
                        camelAttachment);
            }
        }
        if (content instanceof BodyPart) {
            BodyPart bp = (BodyPart) content;
            camelMessage.setBody(bp.getInputStream());
            contentType = bp.getContentType();
            if (contentType != null && !DEFAULT_CONTENT_TYPE.equals(contentType)) {
                camelMessage.setHeader(CONTENT_TYPE, contentType);
                ContentType ct = new ContentType(contentType);
                String charset = ct.getParameter("charset");
                if (charset != null) {
                    camelMessage.setHeader(Exchange.CONTENT_ENCODING, MimeUtility.javaCharset(charset));
                }
            }
        } else {
            // If we find no body part, try to leave the message alone
            LOG.info("no MIME part found");
        }
        return camelMessage;
    }

    private void extractHeader(String headerMame, Message camelMessage, InternetHeaders headers) {
        String h = camelMessage.getHeader(headerMame, String.class);
        if (h != null) {
            headers.addHeader(headerMame, h);
            camelMessage.removeHeader(headerMame);
        }
    }

    private String getAttachmentKey(BodyPart bp) throws MessagingException, UnsupportedEncodingException {
        // use the filename as key for the map
        String key = bp.getFileName();
        // if there is no file name we use the Content-ID header
        if (key == null && bp instanceof MimeBodyPart) {
            key = ((MimeBodyPart) bp).getContentID();
            if (key != null && key.startsWith("<") && key.length() > 2) {
                // strip <>
                key = key.substring(1, key.length() - 1);
            }
        }
        // or a generated content id
        if (key == null) {
            key = UUID.randomUUID() + "@camel.apache.org";
        }
        return MimeUtility.decodeText(key);
    }

    @Override
    protected void doInit() throws Exception {
        if (includeHeaders != null) {
            this.includeHeadersPattern = Pattern.compile(includeHeaders, Pattern.CASE_INSENSITIVE);
        }
    }

}
