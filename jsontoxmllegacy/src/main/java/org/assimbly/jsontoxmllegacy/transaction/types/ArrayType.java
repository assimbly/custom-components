package org.assimbly.jsontoxmllegacy.transaction.types;

import org.assimbly.jsontoxmllegacy.Constants;
import org.assimbly.jsontoxmllegacy.JsonToXmlConfiguration;
import org.assimbly.jsontoxmllegacy.JsonToXmlProcessor;
import org.assimbly.jsontoxmllegacy.transaction.NodeTransaction;
import org.w3c.dom.Element;

public class ArrayType implements NodeTransaction {

    @Override
    public Element process(JsonToXmlConfiguration config) {
        // extract child as an array
        config.getJsonNode().elements().forEachRemaining(elementJsonNode -> {
            if(config.isTypeHints() && config.getLevel()!=0) {
                config.getElement().setAttribute(Constants.JSON_XML_ATTR_CLASS, Constants.JSON_XML_ATTR_TYPE_ARRAY);
            }
            config.getElement().appendChild(JsonToXmlProcessor.convertJsonToXml(config.createSubLevelConfig(elementJsonNode, null)));
        });
        return config.getElement();
    }
}
