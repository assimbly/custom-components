package org.assimbly.xmltojsonlegacy.processor.jsontoxml.node.types;

import com.fasterxml.jackson.databind.JsonNode;
import org.assimbly.xmltojsonlegacy.Constants;
import org.assimbly.xmltojsonlegacy.processor.JsonToXmlProcessor;
import org.assimbly.xmltojsonlegacy.processor.jsontoxml.node.NodeTransaction;
import org.assimbly.xmltojsonlegacy.utils.JsonUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.XMLConstants;
import java.util.HashMap;

public class ObjectType implements NodeTransaction {

    @Override
    public Element process(
            JsonNode jsonNode, Document document, Element element, boolean isTypeHints, int level,
            HashMap<String, String> xmlnsMap
    ) {
        // extract child as an object
        jsonNode.fields().forEachRemaining(entry -> {
            String key = entry.getKey();
            JsonNode value = entry.getValue();

            if(key.indexOf(Constants.JSON_XML_ATTR_PREFIX)==0) {
                key = key.substring(1);
                if(key.equals(XMLConstants.XMLNS_ATTRIBUTE) || key.indexOf(XMLConstants.XMLNS_ATTRIBUTE+":")==0) {
                    // namespace
                    String namespace = JsonUtils.getAndSetNamespace(xmlnsMap, key, value.asText());
                    if(namespace != null) {
                        element.setAttribute(key, namespace);
                    }
                } else {
                    switch (key) {
                        case Constants.JSON_XML_ATTR_CONTEXT:
                            element.setAttribute(Constants.JSON_XML_ATTR_CONTEXT, value.toString());
                            break;
                        default:
                            element.setAttribute(key, value.asText());
                    }
                }
            } else if(key.equals(Constants.JSON_XML_TEXT_FIELD)){
                element.setTextContent(value.asText());
            } else {
                element.appendChild(JsonToXmlProcessor.convertEachJsonStepIntoXmlDocument(value, document, element, key,
                        level +1, xmlnsMap));
            }
        });
        if(!element.hasAttribute(Constants.JSON_XML_ATTR_CLASS) && isTypeHints && level!=0) {
            element.setAttribute(Constants.JSON_XML_ATTR_CLASS, Constants.JSON_XML_ATTR_TYPE_OBJECT);
        }
        return element;
    }
}
