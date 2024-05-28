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
package org.assimbly.mail.component.mail;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.RuntimeCamelException;
import org.apache.camel.attachment.Attachment;
import org.apache.camel.attachment.AttachmentMessage;
import org.apache.camel.attachment.DefaultAttachment;
import org.apache.camel.support.DefaultMessage;
import org.apache.camel.support.ExpressionAdapter;
import org.apache.camel.util.IOHelper;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jakarta.activation.DataHandler;
import jakarta.mail.Header;
import jakarta.mail.MessagingException;
import jakarta.mail.Multipart;
import jakarta.mail.Part;

/**
 * A {@link org.apache.camel.Expression} which can be used to split a {@link MailMessage} per attachment. For example if
 * a mail message has 5 attachments, then this expression will return a <tt>List&lt;Message&gt;</tt> that contains 5
 * {@link Message}. The message is split:
 * <table>
 * <tr>
 * <td>As a byte[] or String</td>
 * <td>The attachments are split into new messages as the body. This allows the split messages to be easily used by
 * other processors / routes, as many other camel components can work on the byte[] or String, e.g. it can be written to
 * disk using camel-file.</td>
 * </tr>
 * </table>
 *
 * In both cases the attachment name is written to a the camel header &quot;CamelSplitAttachmentId&quot;
 */
public class SplitAttachmentsExpression extends ExpressionAdapter {

    final static Logger LOG = LoggerFactory.getLogger(SplitAttachmentsExpression.class);

    public static final String HEADER_NAME = "CamelSplitAttachmentId";

    private boolean extractAttachments;

    public SplitAttachmentsExpression() { }

    public SplitAttachmentsExpression(boolean extractAttachments) {
        this.extractAttachments = extractAttachments;
    }

    @Override
    public Object evaluate(Exchange exchange) {
        Map<String, Attachment> attachments = new HashMap<>();

        if(!(exchange.getIn() instanceof MailMessage)) {
            return null;
        }

        /*
         * Check to make sure attachments get unique filename.
         * https://assimblyworld.atlassian.net/browse/DOV-220
         */
        MailMessage inMessage = (MailMessage) exchange.getIn();
        jakarta.mail.Message message = inMessage.getOriginalMessage();

        try {
            extractAttachmentsFromMail(message, attachments);
            AttachmentMessage attMsg = exchange.getIn(AttachmentMessage.class);
            attMsg.setAttachmentObjects(attachments);

        } catch (MessagingException | IOException e) {
            LOG.error(e.getMessage());
            return null;
        }

        // must use getAttachments to ensure attachments is initial populated
        if (!exchange.getIn(AttachmentMessage.class).hasAttachments()) {
            return null;
        }

        try {
            List<Message> answer = new ArrayList<>();
            AttachmentMessage inAttachMessage = exchange.getIn(AttachmentMessage.class);
            for (Map.Entry<String, Attachment> entry : inAttachMessage.getAttachmentObjects().entrySet()) {
                Message attachmentMessage;
                if (extractAttachments) {
                    attachmentMessage = extractAttachment(entry.getValue(), entry.getKey(), exchange.getContext());
                } else {
                    attachmentMessage = splitAttachment(exchange, entry.getKey(), entry.getValue().getDataHandler());
                }

                if (attachmentMessage != null) {
                    answer.add(attachmentMessage);
                }
            }

            for(Message m : answer){
                for(String hKey : exchange.getIn().getHeaders().keySet()) {
                    Object header = exchange.getIn().getHeader(hKey);
                    if(m.getHeader(hKey) == null)
                        m.setHeader(hKey, header);
                }

                if(m.getHeader("From") != null) {
                    String email = m.getHeader("From").toString();
                    m.setHeader("Source-Email", StringUtils.substringBetween(email, "<", ">"));
                }
            }

            return answer;
        } catch (Exception e) {
            throw new RuntimeCamelException("Unable to split attachments from MimeMultipart message", e);
        }
    }

    private Message splitAttachment(Exchange exchange, String attachmentName, DataHandler attachmentHandler) {
        final Exchange exchangeCopy = exchange.copy();
        Map<String, DataHandler> attachments = exchangeCopy.getIn(AttachmentMessage.class).getAttachments();
        attachments.clear();
        attachments.put(attachmentName, attachmentHandler);
        exchangeCopy.getIn().setHeader(HEADER_NAME, attachmentName);
        return exchangeCopy.getIn();
    }

    private Message extractAttachment(Attachment attachment, String attachmentName, CamelContext camelContext)
            throws Exception {
        final Message outMessage = new DefaultMessage(camelContext);
        outMessage.setHeader(HEADER_NAME, attachmentName);
        Object obj = attachment.getDataHandler().getContent();
        if (obj instanceof InputStream) {
            outMessage.setBody(readMimePart((InputStream) obj));
            return outMessage;
        } else if (obj instanceof String || obj instanceof byte[]) {
            outMessage.setBody(obj);
            return outMessage;
        } else {
            return null;
        }
    }

    /**
     * Parses the attachments of the given mail message and adds them to the map
     *
     * @param message the mail message with attachments
     * @param map     the map to add found attachments (attachmentFilename is the key)
     *
     * Assimbly Edit: Copied from org.apache.camel.component.mail.MailBinding (2.20.1)
     */
    private void extractAttachmentsFromMail(jakarta.mail.Message message, Map<String, Attachment> map)
            throws MessagingException, IOException {

        LOG.trace("Extracting attachments +++ start +++");

        Object content = message.getContent();
        if (content instanceof Multipart) {
            extractAttachmentsFromMultipart((Multipart) content, map);
        } else if (content != null) {
            LOG.trace("No attachments to extract as content is not Multipart: " + content.getClass().getName());
        }

        LOG.trace("Extracting attachments +++ done +++");
    }

    /**
     * Assimbly Edit: Copied from org.apache.camel.component.mail.MailBinding (2.20.1)
     */
    private void extractAttachmentsFromMultipart(Multipart mp, Map<String, Attachment> map)
            throws MessagingException, IOException {

        for (int i = 0; i < mp.getCount(); i++) {
            Part part = mp.getBodyPart(i);
            LOG.trace("Part #" + i + ": " + part);

            if (part.isMimeType("multipart/*")) {
                LOG.trace("Part #" + i + ": is mimetype: multipart/*");
                extractAttachmentsFromMultipart((Multipart) part.getContent(), map);
            } else {
                String disposition = part.getDisposition();
                String fileName = part.getFileName();

                if (LOG.isTraceEnabled()) {
                    LOG.trace("Part #{}: Disposition: {}", i, disposition);
                    LOG.trace("Part #{}: Description: {}", i, part.getDescription());
                    LOG.trace("Part #{}: ContentType: {}", i, part.getContentType());
                    LOG.trace("Part #{}: FileName: {}", i, fileName);
                    LOG.trace("Part #{}: Size: {}", i, part.getSize());
                    LOG.trace("Part #{}: LineCount: {}", i, part.getLineCount());
                }

                if (validDisposition(disposition, fileName)
                        || fileName != null) {
                    LOG.debug("Mail contains file attachment: {}", fileName);
                    if (map.containsKey(fileName)) {
                        fileName = createUniqueFileName(fileName, 1, map);
                    }

                    // Parts marked with a disposition of Part.ATTACHMENT are clearly attachments
                    DefaultAttachment camelAttachment = new DefaultAttachment(part.getDataHandler());
                    @SuppressWarnings("unchecked")
                    Enumeration<Header> headers = part.getAllHeaders();
                    while (headers.hasMoreElements()) {
                        jakarta.mail.Header header = headers.nextElement();
                        camelAttachment.addHeader(header.getName(), header.getValue());
                    }
                    map.put(fileName, camelAttachment);
                }
            }
        }
    }

    private byte[] readMimePart(InputStream mimePartStream) throws Exception {
        // mimePartStream could be base64 encoded, or not, but we don't need to worry about it as
        // Camel is smart enough to wrap it in a decoder stream (eg Base64DecoderStream) when required
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        IOHelper.copyAndCloseInput(mimePartStream, bos);
        return bos.toByteArray();
    }

    /**
     * Assimbly Edit: Custom method to force unique filenames that will be stored in the Attachments Map as
     * duplicated filenames will cause the first file to be overwritten.
     *
     * https://assimblyworld.atlassian.net/browse/DOV-220
     */
    private String createUniqueFileName(String fileName, int occurrence, Map<String, Attachment> attachmentMap) {
        String ext = FilenameUtils.getExtension(fileName);
        String name = FilenameUtils.getBaseName(fileName);

        String newFileName = String.format("%s (%s).%s", name, occurrence, ext);

        if (attachmentMap.containsKey(newFileName)) {
            return createUniqueFileName(fileName, occurrence + 1, attachmentMap);
        }

        return newFileName;
    }

    /**
     * Assimbly Edit: Copied from org.apache.camel.component.mail.MailBinding (2.20.1)
     */
    private boolean validDisposition(String disposition, String fileName) {
        return disposition != null
                && fileName != null
                && (disposition.equalsIgnoreCase(Part.ATTACHMENT) || disposition.equalsIgnoreCase(Part.INLINE));
    }


    public boolean isExtractAttachments() {
        return extractAttachments;
    }

    public void setExtractAttachments(boolean extractAttachments) {
        this.extractAttachments = extractAttachments;
    }

    public boolean hasAttachments(Exchange exchange) {
        return exchange.getIn(AttachmentMessage.class).hasAttachments();
    }

}
