package org.assimbly.xmltojsonlegacy.transaction.elementnode.types;

import com.fasterxml.jackson.databind.JsonNode;
import org.assimbly.xmltojsonlegacy.Constants;
import org.assimbly.xmltojsonlegacy.XmlToJsonConfiguration;
import org.assimbly.xmltojsonlegacy.transaction.elementnode.ElementNodeTransaction;
import org.assimbly.xmltojsonlegacy.checker.ElementChecker;
import org.assimbly.xmltojsonlegacy.utils.ElementUtils;
import org.assimbly.xmltojsonlegacy.utils.ExtractUtils;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class OtherTypeWithoutNamespace implements ElementNodeTransaction {

    @Override
    public JsonNode process(XmlToJsonConfiguration config, Node childNode) {
        if(!config.isTypeHints()) {
            // extract child as other type and add into the array node
            int children = ElementUtils.calculateNumberOfChildren((Element) childNode);
            boolean childrenHasEmptyTextContent = ElementUtils.isElementWithEmptyTextContent((Element) childNode);
            boolean classAttrOnChildElementIsNUll = ElementChecker.isElementAttributeNull(
                    (Element) childNode, Constants.JSON_XML_ATTR_CLASS
            );
            if(config.isElementWithEmptyTextContent() ||
                    childrenHasEmptyTextContent ||
                    (config.getLevel() == 0 && config.getNumberOfChildren() > 1) ||
                    (config.getNumberOfChildren() == 1 && children >= 1 && !classAttrOnChildElementIsNUll) ||
                    !ElementUtils.areSiblingsNamesEqual((Element) childNode) ||
                    config.isElementOnNamespace()
            ) {
                ExtractUtils.extractChildAsOtherInObjectNode(config, (Element) childNode);
            } else {
                ExtractUtils.extractChildAsOtherInArrayNode(config, (Element) childNode);
                config.getRootObjectNode().set(
                        ElementUtils.getElementName((Element) childNode, config.isRemoveNamespacePrefixes()),
                        config.getRootArrayNode()
                );
            }
        } else {
            // extract child as other type and add into the object node
            ExtractUtils.extractChildAsOtherInObjectNode(config, (Element) childNode);
        }
        return null;
    }
}
