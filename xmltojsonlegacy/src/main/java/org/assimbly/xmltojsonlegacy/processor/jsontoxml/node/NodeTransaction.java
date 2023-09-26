package org.assimbly.xmltojsonlegacy.processor.jsontoxml.node;

import com.fasterxml.jackson.databind.JsonNode;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import java.util.HashMap;

public interface NodeTransaction {

    Element process(JsonNode jsonNode, Document document, Element element, boolean isTypeHints, int level, HashMap<String, String> xmlnsMap);

}
