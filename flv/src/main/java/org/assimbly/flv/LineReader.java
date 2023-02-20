package org.assimbly.flv;

import org.assimbly.smooksnoxml.XmlDocumentHandler;
import org.xml.sax.helpers.AttributesImpl;

import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LineReader {

    // inbound meta
    private static final String GROUP_PREFIX = "$group$";

    // outbound meta
    private static final String RULE_TAG = "rule";
    private static final String SEGMENT_TAG = "segment";

    private final String header;
    private final String fields;
    private final List<MappedField> mappedFields;
    private final boolean group;

    private LineReader(String header, String fields, List<MappedField> mappedFields, boolean group) {
        this.header = header;
        this.fields = fields;
        this.mappedFields = mappedFields;
        this.group = group;
    }

    protected boolean isGroup() {
        return group;
    }

    protected String getHeader() {
        return header;
    }

    public boolean supports(String line) {
        return line.startsWith(header);
    }

    public void sendLineNode(XmlDocumentHandler documentHandler, String line) {
        documentHandler.startElement(SEGMENT_TAG);

        int pos = 0;

        for(MappedField mappedField: mappedFields) {
            int rightBound = pos + mappedField.nrCharacters > line.length()
                    ? line.length()
                    : pos + mappedField.nrCharacters;

            String fieldValue = line.substring(pos, rightBound);

            documentHandler.startElement(mappedField.fieldName);
            documentHandler.sendCharacters(fieldValue.trim());
            documentHandler.endElement(mappedField.fieldName);

            pos += mappedField.nrCharacters;
        }

        documentHandler.endElement(SEGMENT_TAG);
    }

    public void sendRuleElement(XmlDocumentHandler documentHandler) {
        AttributesImpl attributes = new AttributesImpl();

        attributes.addAttribute("", "matchOn", "", "", header);
        attributes.addAttribute("", "fields", "", "", fields);

        documentHandler.startElement(RULE_TAG, attributes);
        documentHandler.endElement(RULE_TAG);
    }

    public static LineReader fromEncodedConfig(String key, String fields) {
        if(key.startsWith(GROUP_PREFIX))
            return new LineReader(key.substring(GROUP_PREFIX.length()), fields, parseFieldMappings(fields), true);
        else
            return new LineReader(key, fields, parseFieldMappings(fields), false);
    }

    private static List<MappedField> parseFieldMappings(String mappings) {
        // match against fieldName[characterCount]
        Pattern pattern = Pattern.compile("(\\w+)\\[(\\d+)]");
        Matcher matcher = pattern.matcher(mappings);

        List<MappedField> mappedFields = new LinkedList<MappedField>();

        while (matcher.find()) {
            String fieldName = matcher.group(1);
            int fieldLength = Integer.parseInt(matcher.group(2));

            mappedFields.add(new MappedField(fieldName, fieldLength));
        }

        return mappedFields;
    }

    private static class MappedField {

        private final String fieldName;
        private final int nrCharacters;

        private MappedField(String fieldName, int nrCharacters) {
            this.fieldName = fieldName;
            this.nrCharacters = nrCharacters;
        }
    }
}
