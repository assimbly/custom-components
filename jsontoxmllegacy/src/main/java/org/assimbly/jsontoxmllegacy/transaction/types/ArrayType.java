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

        boolean isArray = config.getJsonNode().isArray();
        boolean isEmptyArray = isArray && !config.getJsonNode().iterator().hasNext();

        // If it's an array (even empty) and type hints are enabled, set attribute
        if (config.isTypeHints() && isArray && config.getLevel() != 0) {
            config.getElement().setAttribute(Constants.JSON_XML_ATTR_CLASS, Constants.JSON_XML_ATTR_TYPE_ARRAY);
        }

        // If empty array, nothing more to process
        if (isEmptyArray) {
            return config.getElement();
        }

        config.getJsonNode().values().iterator().forEachRemaining(elementJsonNode -> {
            config.getElement().appendChild(
                    JsonToXmlProcessor.convertJsonToXml(
                            config.createSubLevelConfig(elementJsonNode, null)
                    )
            );
        });

        return config.getElement();
    }
}
