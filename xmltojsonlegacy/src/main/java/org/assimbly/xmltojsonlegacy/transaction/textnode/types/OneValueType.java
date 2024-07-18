package org.assimbly.xmltojsonlegacy.transaction.textnode.types;

import com.fasterxml.jackson.databind.JsonNode;
import org.assimbly.xmltojsonlegacy.Constants;
import org.assimbly.xmltojsonlegacy.XmlToJsonConfiguration;
import org.assimbly.xmltojsonlegacy.logs.Print;
import org.assimbly.xmltojsonlegacy.transaction.textnode.TextNodeTransaction;
import org.assimbly.xmltojsonlegacy.utils.ElementUtils;
import org.assimbly.xmltojsonlegacy.utils.ExtractUtils;
import org.w3c.dom.Node;

public class OneValueType implements TextNodeTransaction {

    @Override
    public JsonNode process(XmlToJsonConfiguration config, Node childNode, int index, int nodeListSize) {
        //process text node identified as one value
        Print.data(" 2. ONE VALUE", config.getLevel());
        boolean isFirstLevel = config.getLevel() == 1;
        if(isFirstLevel) {
            childNode = config.getElement();
        }
        if(config.isTypeHints()) {
            if(ExtractUtils.rootObjectNodeContainsAttributes(config.getRootObjectNode())) {
                config.getRootObjectNode().put(Constants.JSON_XML_TEXT_FIELD, ElementUtils.getNodeValue(childNode, config.isTrimSpaces()));
                if(isFirstLevel) return config.getRootObjectNode();
            } else {
                ExtractUtils.addValueOnRootArrayNode(config, childNode);
                if(isFirstLevel) return config.getRootArrayNode();
            }
        } else {
            if(config.getElement().hasAttributes()) {
                ExtractUtils.putValueOnRootObjectNode(config, childNode);
                if(isFirstLevel) return config.getRootObjectNode();
            } else {
                config.getRootArrayNode().add(ElementUtils.getNodeValue(childNode, config.isTrimSpaces()));
                if(isFirstLevel) return config.getRootArrayNode();
            }
        }
        return null;
    }
}
