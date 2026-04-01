package org.assimbly.multipart.processor;

import org.assimbly.util.exception.InvalidFileException;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.hc.client5.http.entity.mime.MultipartEntityBuilder;
import org.apache.hc.core5.http.ContentType;
import org.apache.hc.client5.http.entity.mime.ByteArrayBody;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.log4j.Logger;

import java.io.ByteArrayOutputStream;

public class MultipartProcessor implements Processor {

    private static final Logger logger = Logger.getLogger(MultipartProcessor.class);

    @Override
    public void process(Exchange exchange) throws Exception {

        byte[] file = exchange.getIn().getBody(byte[].class);
        String fileName = exchange.getIn().getHeader(Exchange.FILE_NAME, String.class);
        String ftype = exchange.getIn().getHeader(Exchange.CONTENT_TYPE, String.class);
        String field = exchange.getIn().getHeader("MultipartFieldName", String.class);

        exchange.getIn().removeHeader("MultipartFieldName");

        if (file == null)
            throw new InvalidFileException("The body could not be parsed to a file and can't be added to the multipart body.");
        if (ftype == null)
            throw new NullPointerException("There was no Content-Type header found to define the binary file in the Multipart body.");
        if (field == null)
            throw new NullPointerException("There was no field name set.");

        if (fileName == null) {
            fileName = "UndefinedFileName";
            logger.error("Multipart Processor Error: No file name found for binary body we gave it a static file name.");
        }

        MultipartEntityBuilder builder = MultipartEntityBuilder.create();
        builder.addPart(field, new ByteArrayBody(file, ContentType.create(ftype), fileName));
        builder.setBoundary("--------------------------Assimbly");

        ByteArrayOutputStream out = new ByteArrayOutputStream();

        try (HttpEntity entity = builder.build()) {
            entity.writeTo(out);
        }

        exchange.getIn().setHeader("Content-Type", "multipart/form-data; boundary=--------------------------Assimbly");
        exchange.getIn().setBody(out.toByteArray());
    }

}