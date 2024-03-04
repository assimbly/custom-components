package org.assimbly.xmltojsonlegacy.transaction.elementnode.types;

import com.fasterxml.jackson.databind.JsonNode;
import org.assimbly.xmltojsonlegacy.XmlToJsonConfiguration;
import org.assimbly.xmltojsonlegacy.transaction.elementnode.ElementNodeTransaction;
import org.assimbly.xmltojsonlegacy.utils.ElementUtils;
import org.assimbly.xmltojsonlegacy.utils.ExtractUtils;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class OtherTypeWithNamespace implements ElementNodeTransaction {

    @Override
    public JsonNode process(XmlToJsonConfiguration config, Node childNode) {
        if(config.getNumberOfChildren() == 1 || config.getNumberOfChildren() > 1 && !config.isAreChildrenNamesEqual()) {
            ExtractUtils.extractChildAsOtherInObjectNode(config, (Element) childNode);
        } else {
            ExtractUtils.extractChildAsOtherInArrayNode(config, (Element) childNode);
            config.getRootObjectNode().set(ElementUtils.getElementName(
                    (Element) childNode, config.isRemoveNamespacePrefixes()),
                    config.getRootArrayNode()
            );
        }
        return null;
    }
}
