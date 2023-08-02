package org.assimbly.xmltojsonlegacy.processor.elementnode.types;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.assimbly.xmltojsonlegacy.processor.elementnode.ElementNodeTransaction;
import org.assimbly.xmltojsonlegacy.utils.ElementUtils;
import org.assimbly.xmltojsonlegacy.utils.ExtractUtils;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class OtherTypeWithoutNamespaceAndTypeHints implements ElementNodeTransaction {

    @Override
    public JsonNode process(
            Node childNode, ArrayNode rootArrayNode, ObjectNode rootObjectNode, int nodeCount, int level,
            int numberOfChildren, int numberOfSiblings, String classAttr, boolean isRootArray, boolean isObject,
            boolean isSingleChildren, boolean isFirstChild, boolean isFirstSibling, Element childElement,
            String namespace, boolean trimSpaces, boolean skipNamespaces, boolean removeNamespacePrefixes, boolean typeHints
    ) {
        // extract child as other type and add into the array node
        if((level == 0 && numberOfChildren > 1) ||
                (numberOfChildren == 1 && ElementUtils.calculateNumberOfChildren(childElement) > 1)
        ) {
            ExtractUtils.extractChildAsOtherInObjectNode(
                    level, rootObjectNode, numberOfSiblings, classAttr, (Element) childNode, childElement,
                    isFirstSibling, namespace, skipNamespaces, removeNamespacePrefixes
            );
        } else {
            ExtractUtils.extractChildAsOtherInArrayNode(
                    level, rootArrayNode, numberOfSiblings, classAttr, (Element) childNode, childElement,
                    isFirstSibling, namespace
            );
            rootObjectNode.set(
                    ElementUtils.getElementName((Element) childNode, namespace, removeNamespacePrefixes, skipNamespaces),
                    rootArrayNode
            );
        }
        return null;
    }
}
