package org.assimbly.oriflame;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OriflameLineReader {

    // inbound meta
    private static final String GROUP_PREFIX = "$group$";

    private final String header;
    private final String fields;
    private final List<MappedField> mappedFields;
    private final String group;

    private OriflameLineReader(String header, String fields, List<MappedField> mappedFields, String group) {
        this.header = header;
        this.fields = fields;
        this.mappedFields = mappedFields;
        this.group = group;
    }

    public String getGroup() {
        return group;
    }

    protected boolean isGroup() {
        return group != null;
    }

    protected String getHeader() {
        return header;
    }

    public boolean supports(String line) {
        return line.startsWith(header);
    }

    public HashMap<String, String> parseLine(String line) {
        HashMap<String, String> entries = new HashMap<String, String>();
        int pos = 0;

        for(MappedField mappedField: mappedFields) {
            int rightBound = pos + mappedField.nrCharacters > line.length()
                    ? line.length()
                    : pos + mappedField.nrCharacters;

            String fieldValue = line.substring(pos, rightBound);
            entries.put(mappedField.fieldName, fieldValue.trim());

            pos += mappedField.nrCharacters;
        }

        return entries;
    }

    public static OriflameLineReader fromEncodedConfig(String key, String fields) {
        if(key.startsWith(GROUP_PREFIX)) {
            String group = key.substring(GROUP_PREFIX.length());
            return new OriflameLineReader(group, fields, parseFieldMappings(fields), group);
        }
        else
            return new OriflameLineReader(key, fields, parseFieldMappings(fields), null);
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
