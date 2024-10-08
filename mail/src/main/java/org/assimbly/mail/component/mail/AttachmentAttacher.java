package org.assimbly.mail.component.mail;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.attachment.AttachmentMessage;
import org.apache.commons.io.IOUtils;
import org.assimbly.util.helper.MimeTypeHelper;

import jakarta.activation.DataHandler;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AttachmentAttacher implements Processor {

    @Override
    public void process(Exchange exchange) throws Exception {
        AttachmentMessage in = exchange.getIn(AttachmentMessage.class);

        String fileName = in.getHeader(Exchange.FILE_NAME, String.class);
        String mimeType = in.getHeader(Exchange.CONTENT_TYPE, String.class);
        InputStream is = in.getBody(InputStream.class);

        if (mimeType == null)
            mimeType = MimeTypeHelper.detectMimeType(is).toString();

        if (fileName == null)
            in.setHeader(Exchange.FILE_NAME,
                    fileName = new SimpleDateFormat("'Dovetail'-yyyy-MM-dd-HH-mm-ss-SSS")
                    .format(new Date()) + MimeTypeHelper.findFileExtension(mimeType));

        String emailBody = in.getHeader("EmailBody", String.class);

        if (emailBody == null)
            emailBody = "";

        AttachmentMessage attMsg = exchange.getIn(AttachmentMessage.class);
        attMsg.addAttachment(fileName, new DataHandler(IOUtils.toByteArray(is), mimeType));

        in.setHeader(Exchange.CONTENT_TYPE, "text/plain");
        in.setBody(emailBody);

    }

}
