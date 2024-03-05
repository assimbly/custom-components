package org.assimbly.jsontoxmllegacy.transaction.types;

import com.fasterxml.jackson.databind.JsonNode;
import org.assimbly.jsontoxmllegacy.Constants;
import org.assimbly.jsontoxmllegacy.JsonToXmlConfiguration;
import org.assimbly.jsontoxmllegacy.JsonToXmlProcessor;
import org.assimbly.jsontoxmllegacy.transaction.NodeTransaction;
import org.assimbly.jsontoxmllegacy.utils.JsonUtils;
import org.w3c.dom.Element;

import javax.xml.XMLConstants;

public class ObjectType implements NodeTransaction {

    @Override
    public Element process(JsonToXmlConfiguration config) {
        // extract child as an object
        config.getJsonNode().fields().forEachRemaining(entry -> {
            String key = entry.getKey();
            JsonNode value = entry.getValue();

            if(key.indexOf(Constants.JSON_XML_ATTR_PREFIX)==0) {
                key = key.substring(1);
                if(key.equals(XMLConstants.XMLNS_ATTRIBUTE) || key.indexOf(XMLConstants.XMLNS_ATTRIBUTE+":")==0) {
                    // namespace
                    String namespace = JsonUtils.getAndSetNamespace(config.getXmlnsMap(), key, value.asText());
                    if(namespace != null) {
                        config.getElement().setAttribute(key, namespace);
                    }
                } else {
                    switch (key) {
                        case Constants.JSON_XML_ATTR_CONTEXT:
                            config.getElement().setAttribute(Constants.JSON_XML_ATTR_CONTEXT, value.toString());
                            break;
                        default:
                            config.getElement().setAttribute(key, value.asText());
                    }
                }
            } else if(key.equals(Constants.JSON_XML_TEXT_FIELD)){
                config.getElement().setTextContent(value.asText());
            } else {
                config.getElement().appendChild(JsonToXmlProcessor.convertJsonToXml(config.createSubLevelConfig(value, key)));
            }
        });
        if(!config.getElement().hasAttribute(Constants.JSON_XML_ATTR_CLASS) && config.isTypeHints() && config.getLevel()!=0) {
            config.getElement().setAttribute(Constants.JSON_XML_ATTR_CLASS, Constants.JSON_XML_ATTR_TYPE_OBJECT);
        }
        return config.getElement();
    }
}
