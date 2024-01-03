package org.assimbly.xmltojsonlegacy.processor.xmltojson.elementnode.types;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.apache.commons.lang3.StringUtils;
import org.assimbly.xmltojsonlegacy.Constants;
import org.assimbly.xmltojsonlegacy.processor.xmltojson.elementnode.ElementNodeTransaction;
import org.assimbly.xmltojsonlegacy.utils.ElementChecker;
import org.assimbly.xmltojsonlegacy.utils.ElementUtils;
import org.assimbly.xmltojsonlegacy.utils.ExtractUtils;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class OtherTypeWithoutNamespace implements ElementNodeTransaction {

    @Override
    public JsonNode process(
            Node childNode, ArrayNode rootArrayNode, ObjectNode rootObjectNode, int nodeCount, int level,
            int numberOfChildren, int numberOfSiblings, String parentClass, String classAttr, boolean isRootArray,
            boolean isObject, boolean isSingleChildren, boolean isFirstChild, boolean isFirstSibling, Element childElement,
            String namespace, boolean trimSpaces, boolean skipNamespaces, boolean removeNamespacePrefixes, boolean typeHints
    ) {
        if(!typeHints) {
            // extract child as other type and add into the array node
            int children = ElementUtils.calculateNumberOfChildren(childElement);
            boolean classAttrOnChildElementIsNUll = ElementChecker.isElementAttributeNull(childElement, Constants.JSON_XML_ATTR_CLASS);
            if((level == 0 && numberOfChildren > 1) ||
                    (numberOfChildren == 1 && children >= 1 && !classAttrOnChildElementIsNUll) ||
                    !ElementUtils.areSiblingsNamesEqual(childElement)
            ) {
                ExtractUtils.extractChildAsOtherInObjectNode(
                        level, rootObjectNode, numberOfSiblings, parentClass, classAttr, (Element) childNode, childElement,
                        isFirstSibling, namespace, skipNamespaces, removeNamespacePrefixes
                );
            } else {
                ExtractUtils.extractChildAsOtherInArrayNode(
                        level, rootArrayNode, numberOfSiblings, parentClass, classAttr, (Element) childNode, childElement,
                        isFirstSibling, namespace
                );
                rootObjectNode.set(
                        ElementUtils.getElementName((Element) childNode, namespace, removeNamespacePrefixes, skipNamespaces),
                        rootArrayNode
                );
            }
        } else {
            // extract child as other type and add into the object node
            ExtractUtils.extractChildAsOtherInObjectNode(
                    level, rootObjectNode, numberOfSiblings, parentClass, classAttr, (Element) childNode, childElement,
                    isFirstSibling, namespace, skipNamespaces, removeNamespacePrefixes
            );
        }
        return null;
    }
}
