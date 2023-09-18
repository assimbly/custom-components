package org.assimbly.xmltojsonlegacy.processor.jsontoxml.node.types;

import com.fasterxml.jackson.databind.JsonNode;
import org.assimbly.xmltojsonlegacy.Constants;
import org.assimbly.xmltojsonlegacy.processor.jsontoxml.node.NodeTransaction;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

import java.util.HashMap;

public class TextType implements NodeTransaction {

    @Override
    public Element process(
            JsonNode jsonNode, Document document, Element element, boolean isTypeHints, int level,
            HashMap<String, String> xmlnsMap
    ) {
        // extract child as a text
        Text textNode = document.createTextNode(jsonNode.asText());
        element.appendChild(textNode);
        if(!element.hasAttribute(Constants.JSON_XML_ATTR_TYPE) && isTypeHints) {
            String type = Constants.JSON_XML_ATTR_TYPE_STRING; // string by default
            if(jsonNode.isNumber()) {
                type = Constants.JSON_XML_ATTR_TYPE_NUMBER;
            } else if(jsonNode.isBoolean()) {
                type = Constants.JSON_XML_ATTR_TYPE_BOOLEAN;
            }
            element.setAttribute(Constants.JSON_XML_ATTR_TYPE, type);
        }
        return element;
    }
}
