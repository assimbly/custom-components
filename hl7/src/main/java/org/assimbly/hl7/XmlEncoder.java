package org.assimbly.hl7;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.parser.DefaultXMLParser;
import ca.uhn.hl7v2.parser.XMLParser;

public class XmlEncoder {

    public String convertMessage(String message) throws HL7Exception {
        XMLParser xmlParser = new DefaultXMLParser();
        return xmlParser.parse(message).encode();
    }
}
