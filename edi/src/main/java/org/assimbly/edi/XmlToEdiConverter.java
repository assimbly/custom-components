package org.assimbly.edi;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class XmlToEdiConverter extends DefaultHandler {

    private static final String ELEMENT_TYPE_ROOT         = "edi-message";
    private static final String ELEMENT_TYPE_DELIMITERS   = "delimiters";
    private static final String ELEMENT_TYPE_FIELD        = "field";
    private static final String ELEMENT_TYPE_COMPONENT    = "component";
    private static final String ELEMENT_TYPE_SUBCOMPONENT = "sub-component";

    private String segmentSeparator;
    private String fieldSeparator;
    private String componentSeparator;
    private String subComponentSeparator;

    private String currentElement;

    private List<Segment> parsedSegments;
    private Segment currentSegment;
    private Field currentField;
    private Component currentComponent;
    private Subcomponent currentSubcomponent;

    public String convert(InputStream inputStream) {
        SAXParserFactory spf = SAXParserFactory.newInstance();
        spf.setNamespaceAware(true);

        try {
            SAXParser saxParser = spf.newSAXParser();
            saxParser.parse(inputStream, this);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return new EdiWriter(parsedSegments).write();
    }

    @Override
    public void startDocument () throws SAXException {
        parsedSegments = new ArrayList<>();
    }

    @Override
    public void startElement(String uri, String localName,
                             String qName, Attributes attributes) throws SAXException {
        if (localName.equals(ELEMENT_TYPE_ROOT)) {
            return;
        }

        if (localName.equals(ELEMENT_TYPE_DELIMITERS)) {
            this.segmentSeparator      = attributes.getValue("segment");
            this.fieldSeparator        = attributes.getValue("field");
            this.componentSeparator    = attributes.getValue("component");
            this.subComponentSeparator = attributes.getValue("sub-component");
            return;
        }

        if (localName.startsWith(ELEMENT_TYPE_FIELD)) {
            currentField = new Field();
            currentSegment.fields.add(currentField);

            currentElement = ELEMENT_TYPE_FIELD;
            return;
        }

        if (localName.startsWith(ELEMENT_TYPE_COMPONENT)) {
            currentComponent = new Component();
            currentField.components.add(currentComponent);

            currentElement = ELEMENT_TYPE_COMPONENT;
            return;
        }

        if (localName.startsWith(ELEMENT_TYPE_SUBCOMPONENT)) {
            currentSubcomponent = new Subcomponent();
            currentComponent.subcomponents.add(currentSubcomponent);

            currentElement = ELEMENT_TYPE_SUBCOMPONENT;
            return;
        }

        // segment names are not fixed. If it's not any of the other fields we know about,
        // assume it's a segment
        currentSegment = new Segment(localName);
        parsedSegments.add(currentSegment);
    }

    @Override
    @SuppressWarnings("StringEquality")
    public void characters(char ch[], int start, int length) throws SAXException {
        if (currentElement == ELEMENT_TYPE_FIELD && currentField.data == null) {
            currentField.data = Arrays.copyOfRange(ch, start, start + length);
            return;
        }

        if (currentElement == ELEMENT_TYPE_COMPONENT && currentComponent.data == null) {
            currentComponent.data = Arrays.copyOfRange(ch, start, start + length);
            return;
        }

        if (currentElement == ELEMENT_TYPE_SUBCOMPONENT && currentSubcomponent.data == null) {
            currentSubcomponent.data = Arrays.copyOfRange(ch, start, start + length);
        }
    }

    /**
     * Writes the EDI object graph represented in XML to an EDI String.
     */
    private class EdiWriter {

        private static final String LINE_BREAK = "LB";
        private List<Segment> segments;

        EdiWriter(List<Segment> segments) {
            this.segments = segments;
        }

        String write() {
            StringBuilder builder = new StringBuilder();

            for(int i = 0 ; i < segments.size(); i++) {
                Segment segment = segments.get(i);

                if (i > 0) appendSeparator(builder, segmentSeparator);
                builder.append(segment.name);

                writeFields(builder, segment.fields);
            }

            return builder.toString();
        }

        private void writeFields(StringBuilder builder, List<Field> fields) {
            for(Field field : fields) {
                appendSeparator(builder, fieldSeparator);

                if (!field.components.isEmpty()) {
                    writeComponents(builder, field.components);
                } else {
                    builder.append(field.data);
                }
            }
        }

        private void writeComponents(StringBuilder builder, List<Component> components) {
            for(int i = 0 ; i < components.size() ; i++) {
                Component component = components.get(i);

                if (i > 0) appendSeparator(builder, componentSeparator);

                if (!component.subcomponents.isEmpty()) {
                    writeSubcomponents(builder, component.subcomponents);
                } else {
                    builder.append(component.data);
                }
            }
        }

        private void writeSubcomponents(StringBuilder builder, List<Subcomponent> subcomponents) {
            for(int l = 0 ; l < subcomponents.size() ; l++) {
                Subcomponent subcomponent = subcomponents.get(l);

                if(l > 0) appendSeparator(builder, subComponentSeparator);
                builder.append(subcomponent.data);
            }
        }


        private void appendSeparator(StringBuilder builder, String separator) {
            if (separator.equals(LINE_BREAK)) {
                builder.append("\n");
            } else {
                builder.append(separator);
            }
        }
    }

    // Data structure of EDI represented in XML

    private class Segment {
        private String name;
        private List<Field> fields = new ArrayList<>();

        Segment(String name) {
            this.name = name;
        }
    }

    private class Field {
        private char[] data;
        private List<Component> components = new ArrayList<>();
    }

    private class Component {
        private char[] data;
        private List<Subcomponent> subcomponents = new ArrayList<>();
    }

    private class Subcomponent {
        private char[] data;
    }
}
