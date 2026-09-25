package org.assimbly.multipart.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.hc.client5.http.entity.mime.ByteArrayBody;
import org.apache.hc.client5.http.entity.mime.FormBodyPart;
import org.apache.hc.client5.http.entity.mime.FormBodyPartBuilder;
import org.apache.hc.client5.http.entity.mime.MultipartEntityBuilder;
import org.apache.hc.core5.http.ContentType;
import org.apache.hc.core5.http.HttpEntity;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;

public class MultipartProcessor implements Processor {

    public static final String MULTIPART_FIELD_NAME = "MultipartFieldName";
    public static final String MULTIPART_FORM_FIELDS = "MultipartFormFields";

    @Override
    public void process(Exchange exchange) throws Exception {
        byte[] file = exchange.getIn().getBody(byte[].class);
        String fileName = exchange.getIn().getHeader(Exchange.FILE_NAME, String.class);
        String ftype = exchange.getIn().getHeader(Exchange.CONTENT_TYPE, String.class);
        String field = exchange.getIn().getHeader(MULTIPART_FIELD_NAME, String.class);
        String formFieldsJson = exchange.getIn().getHeader(MULTIPART_FORM_FIELDS, String.class);
        exchange.getIn().removeHeader(MULTIPART_FIELD_NAME);
        exchange.getIn().removeHeader(MULTIPART_FORM_FIELDS);

        if (file == null)
            throw new RuntimeException("The body could not be parsed to a file and can't be added to the multipart body.");
        if (ftype == null)
            throw new NullPointerException("There was no Content-Type header found to define the binary file in the Multipart body.");
        if (field == null)
            throw new NullPointerException("There was no field name set.");
        if (fileName == null) {
            fileName = "UndefinedFileName";
            System.out.println("Multipart Processor Error: No file name found for binary body we gave it a static file name.");
        }

        ByteArrayBody bodyPartContent = new ByteArrayBody(file, ContentType.create(ftype), fileName);

        // Build first so Content-Disposition and Content-Type are already populated,
        // then append Content-Transfer-Encoding so it lands last in the header order.
        // "binary" is correct regardless of ftype/content: it describes the encoding
        // applied to the octets (none — used as-is), not the kind of data they represent.
        // It would only need to change if this processor started base64/quoted-printable
        // encoding the payload before adding it.
        FormBodyPart part = FormBodyPartBuilder.create(field, bodyPartContent).build();
        part.addField("Content-Transfer-Encoding", "binary");

        MultipartEntityBuilder builder = MultipartEntityBuilder.create();
        builder.addPart(part);
        addTextFormFields(builder, formFieldsJson);
        builder.setBoundary("--------------------------Assimbly");

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        try (HttpEntity entity = builder.build()) {
            entity.writeTo(out);
        }

        exchange.getIn().setHeader("Content-Type", "multipart/form-data; boundary=--------------------------Assimbly");
        exchange.getIn().setBody(out.toByteArray());
    }

    private void addTextFormFields(MultipartEntityBuilder builder, String formFieldsJson) {
        if (formFieldsJson == null || formFieldsJson.isBlank()) {
            return;
        }

        JSONObject fields = new JSONObject(formFieldsJson.trim());
        for (String key : fields.keySet()) {
            if (key == null || key.isBlank()) {
                continue;
            }
            Object raw = fields.get(key);
            String value = toFormFieldValue(raw);
            builder.addTextBody(key, value, ContentType.TEXT_PLAIN);
        }
    }

    private static String toFormFieldValue(Object raw) {
        if (raw == null || JSONObject.NULL.equals(raw)) {
            return "";
        }
        if (raw instanceof String stringValue) {
            return stringValue;
        }
        return JSONObject.valueToString(raw);
    }
}
