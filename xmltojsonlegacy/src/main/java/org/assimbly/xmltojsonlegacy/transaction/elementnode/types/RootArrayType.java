package org.assimbly.xmltojsonlegacy.transaction.elementnode.types;

import com.fasterxml.jackson.databind.JsonNode;
import org.apache.commons.lang3.StringUtils;
import org.assimbly.xmltojsonlegacy.XmlToJsonConfiguration;
import org.assimbly.xmltojsonlegacy.XmlToJsonProcessor;
import org.assimbly.xmltojsonlegacy.logs.Print;
import org.assimbly.xmltojsonlegacy.transaction.elementnode.ElementNodeTransaction;
import org.assimbly.xmltojsonlegacy.utils.ExtractUtils;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class RootArrayType implements ElementNodeTransaction {

    @Override
    public JsonNode process(XmlToJsonConfiguration config, Node childNode) {
        Print.data(" 1. IS ROOT ARRAY", config.getLevel());
        if(config.isSingleChildren() && config.isFirstChild() && StringUtils.isNotEmpty(config.getParentClass())) {
            // recursive call with child element
            if(config.isElementMustBeNull()) {
                return ExtractUtils.createInternalNullObjectNode();
            }
            return XmlToJsonProcessor.convertXmlToJson(config.createSubLevelConfig((Element) childNode));
        } else {
            // extract child as an array
            ExtractUtils.extractChildAsArray(config, (Element) childNode);
        }
        return null;
    }
}
