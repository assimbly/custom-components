package org.assimbly.jsontoxmllegacy.transaction.types;

import org.assimbly.jsontoxmllegacy.Constants;
import org.assimbly.jsontoxmllegacy.JsonToXmlConfiguration;
import org.assimbly.jsontoxmllegacy.transaction.NodeTransaction;
import org.w3c.dom.Element;
import org.w3c.dom.Text;


public class TextType implements NodeTransaction {

    @Override
    public Element process(JsonToXmlConfiguration config) {
        // extract child as a text

        if(config.getJsonNode().isNull()) {
            if(config.isTypeHints()) {
                config.getElement().setAttribute(Constants.JSON_XML_ATTR_CLASS, Constants.JSON_XML_ATTR_TYPE_OBJECT);
                config.getElement().setAttribute(Constants.NULL_VALUE, "true");
            } else {
                config.getElement().setAttribute(Constants.JSON_NULL_VALUE, "true");
            }
            return config.getElement();
        }

        Text textNode = config.getDocument().createTextNode(config.getJsonNode().asText());
        config.getElement().appendChild(textNode);
        if(config.getElement().hasAttribute(Constants.JSON_XML_ATTR_TYPE) || !config.isTypeHints()) {
            return config.getElement();
        }

        String type = Constants.JSON_XML_ATTR_TYPE_STRING; // string by default
        if(config.getJsonNode().isNumber()) {
            type = Constants.JSON_XML_ATTR_TYPE_NUMBER;
        } else if(config.getJsonNode().isBoolean()) {
            type = Constants.JSON_XML_ATTR_TYPE_BOOLEAN;
        }
        config.getElement().setAttribute(Constants.JSON_XML_ATTR_TYPE, type);
        return config.getElement();
    }
}
