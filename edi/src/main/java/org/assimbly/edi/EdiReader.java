package org.assimbly.edi;

import org.assimbly.smooksnoxml.BaseXmlReader;
import org.milyn.cdr.annotation.ConfigParam;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.AttributesImpl;

import java.io.IOException;
import java.util.Scanner;

public class EdiReader extends BaseXmlReader {

    @ConfigParam
    private String segment;

    @ConfigParam
    private String field;

    @ConfigParam
    private String component;

    @ConfigParam
    private String subComponent;

    public void parse(InputSource inputSource) throws IOException, SAXException {
        Scanner scanner = createScanner(inputSource);

        // Send the start of message events to the handler
        documentHandler.startDocument();
        documentHandler.startElement("edi-message");

        sendDelimitersElement();

        while(scanner.hasNext()) {
            String record = scanner.next();
            String[] fields = record.split(quote(field));

            // Send the header event
            String header = fields[0];
            documentHandler.startElement(header);

            if(fields.length > 0) {
                for(int i = 1; i < fields.length; i++)
                    sendFieldNode("field." + i, fields[i]);
            }

            // send header event closure
            documentHandler.endElement(header);
        }

        // Send the "end of message" event to the handler
        documentHandler.endElement("edi-message");
        documentHandler.endDocument();
    }

    private void sendFieldNode(String fieldName, String fieldValue) throws SAXException {
        documentHandler.startElement(fieldName);

        if(fieldValue.contains(component)) {
            String[] componentValues = fieldValue.split(quote(component));
            for(int i=0; i<componentValues.length; i++) {
                sendComponentNode("component." + (i + 1), componentValues[i]);
            }
        } else {
            documentHandler.sendCharacters(fieldValue);
        }
        documentHandler.endElement(fieldName);
    }

    private void sendComponentNode(String fieldName, String fieldValue) throws SAXException {
        documentHandler.startElement(fieldName);

        if(fieldValue.contains(subComponent)) {
            String[] componentValues = fieldValue.split(quote(subComponent));
            for(int i=0; i<componentValues.length; i++) {
                sendSubComponentNode("sub-component." + (i + 1), componentValues[i]);
            }
        } else {
            documentHandler.sendCharacters(fieldValue);
        }
        documentHandler.endElement(fieldName);
    }

    private void sendSubComponentNode(String fieldName, String fieldValue) throws SAXException {
        documentHandler.startElement(fieldName);
        documentHandler.sendCharacters(fieldValue);
        documentHandler.endElement(fieldName);
    }

    private void sendDelimitersElement() throws SAXException {
        AttributesImpl attributes = new AttributesImpl();

        attributes.addAttribute("", "segment", "", "", segment);
        attributes.addAttribute("", "field", "", "", field);
        attributes.addAttribute("", "component", "", "", component);
        attributes.addAttribute("", "sub-component", "", "", subComponent);

        documentHandler.startElement("delimiters", attributes);
        documentHandler.endElement("delimiters");
    }

    private Scanner createScanner(InputSource inputSource) {
        Scanner scanner = new Scanner(inputSource.getCharacterStream());

        if(segment.equals(LINE_BREAK)) {
            scanner.useDelimiter("\n");
        } else {
            scanner.useDelimiter(quote(segment));
        }
        return scanner;
    }

}
