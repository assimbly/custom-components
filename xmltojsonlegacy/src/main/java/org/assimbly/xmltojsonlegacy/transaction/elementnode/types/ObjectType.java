package org.assimbly.xmltojsonlegacy.transaction.elementnode.types;

import com.fasterxml.jackson.databind.JsonNode;
import org.assimbly.xmltojsonlegacy.XmlToJsonConfiguration;
import org.assimbly.xmltojsonlegacy.logs.Print;
import org.assimbly.xmltojsonlegacy.transaction.elementnode.ElementNodeTransaction;
import org.assimbly.xmltojsonlegacy.utils.ExtractUtils;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class ObjectType implements ElementNodeTransaction {

    @Override
    public JsonNode process(XmlToJsonConfiguration config, Node childNode) {
        // extract child as an object
        Print.data(" 1. IS OBJECT", config.getLevel());
        ExtractUtils.extractChildAsObject(config, (Element) childNode);
        return null;
    }
}
