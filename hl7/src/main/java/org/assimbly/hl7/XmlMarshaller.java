package org.assimbly.hl7;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.parser.DefaultXMLParser;
import ca.uhn.hl7v2.parser.XMLParser;

public class XmlMarshaller {

    public String convertMessage(Message message) throws HL7Exception {
        XMLParser parser = new DefaultXMLParser();
        return parser.encode(message);
    }
}
