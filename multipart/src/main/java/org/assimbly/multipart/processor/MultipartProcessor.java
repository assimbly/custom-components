package org.assimbly.multipart.processor;

import org.apache.http.entity.ContentType;
import org.assimbly.util.exception.InvalidFileException;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.ByteArrayBody;
import org.apache.log4j.Logger;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;

public class MultipartProcessor implements Processor {

    final static Logger logger = Logger.getLogger(MultipartProcessor.class);

    @Override
    public void process(Exchange exchange) throws Exception {

        // Read the incoming message…
        byte[] file = exchange.getIn().getBody(byte[].class);
        String fname = exchange.getIn().getHeader(Exchange.FILE_NAME, String.class);
        String ftype = exchange.getIn().getHeader(Exchange.CONTENT_TYPE, String.class);
        String field = exchange.getIn().getHeader("MultipartFieldName", String.class);

        // Remove header the ruby component made
        exchange.getIn().removeHeader("MultipartFieldName");

        if (file == null)
            throw new InvalidFileException("The body could not be parsed to a file and can't be added to the multipart body.");

        if (ftype == null)
            throw new NullPointerException("There was no Content-Type header found to define the binary file in the Multipart body.");

        if (field == null)
            throw new NullPointerException("There was no field name set.");

        if (fname == null) {
            fname = "UndefinedFileName";
            logger.error("Multipart Processor Error: No file name found for binary body we gave it a static file name.");
        }

        // Encode the file as a multipart entity…
        MultipartEntityBuilder entity = MultipartEntityBuilder.create();
        entity.addPart(field, new ByteArrayBody(file, ContentType.create(ftype), fname));
        entity.setBoundary("--------------------------Assimbly");

        if (entity.build() == null)
            logger.error("Multipart Processor Error: Entity build returns null.");

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        entity.build().writeTo(out);
        InputStream inputStream = new ByteArrayInputStream(out.toByteArray());

        // Set multipart entity as the outgoing message’s body and set content type
        exchange.getIn().setHeader("Content-Type", "multipart/form-data; boundary=--------------------------Assimbly");
        exchange.getIn().setBody(inputStream);

    }

}
