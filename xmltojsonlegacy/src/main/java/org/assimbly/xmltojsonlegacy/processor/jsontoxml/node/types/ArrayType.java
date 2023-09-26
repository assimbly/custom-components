package org.assimbly.xmltojsonlegacy.processor.jsontoxml.node.types;

import com.fasterxml.jackson.databind.JsonNode;
import org.assimbly.xmltojsonlegacy.Constants;
import org.assimbly.xmltojsonlegacy.processor.JsonToXmlProcessor;
import org.assimbly.xmltojsonlegacy.processor.jsontoxml.node.NodeTransaction;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import java.util.HashMap;

public class ArrayType implements NodeTransaction {

    @Override
    public Element process(
            JsonNode jsonNode, Document document, Element element, boolean isTypeHints, int level, HashMap<String,
            String> xmlnsMap
    ) {
        // extract child as an array
        jsonNode.elements().forEachRemaining(elementJsonNode -> {
            if(isTypeHints && level!=0) {
                element.setAttribute(Constants.JSON_XML_ATTR_CLASS, Constants.JSON_XML_ATTR_TYPE_ARRAY);
            }
            element.appendChild(JsonToXmlProcessor.convertEachJsonStepIntoXmlDocument(elementJsonNode, document,
                    element, null, level +1, xmlnsMap));
        });
        return element;
    }
}
