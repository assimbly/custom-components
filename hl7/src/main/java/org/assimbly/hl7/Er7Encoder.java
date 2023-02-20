package org.assimbly.hl7;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.parser.PipeParser;

public class Er7Encoder {

    public String convertMessage(String message) throws HL7Exception {
        PipeParser pipeParser = new PipeParser();
        return pipeParser.parse(message).encode();
    }
}
