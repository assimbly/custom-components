package org.assimbly.xmltojsonlegacy.processor.xmltojson.elementnode.types;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.assimbly.xmltojsonlegacy.processor.xmltojson.elementnode.ElementNodeTransaction;
import org.assimbly.xmltojsonlegacy.utils.ElementUtils;
import org.assimbly.xmltojsonlegacy.utils.ExtractUtils;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class OtherTypeWithNamespace implements ElementNodeTransaction {

    @Override
    public JsonNode process(
            Node childNode, ArrayNode rootArrayNode, ObjectNode rootObjectNode, int nodeCount, int level,
            int numberOfChildren, int numberOfSiblings, String parentClass, String classAttr, boolean isRootArray,
            boolean isObject, boolean isSingleChildren, boolean isFirstChild, boolean isFirstSibling, Element childElement,
            String namespace, boolean trimSpaces, boolean skipNamespaces, boolean removeNamespacePrefixes, boolean typeHints,
            boolean areSiblingsNamesEqual, boolean isParentSiblingsNamesEqual,
            boolean hasAttributes, boolean hasParentAttributes
    ) {
        ExtractUtils.extractChildAsOtherInArrayNode(
                level, rootArrayNode, numberOfSiblings, parentClass, classAttr, (Element) childNode, childElement,
                isFirstSibling, namespace, areSiblingsNamesEqual, isParentSiblingsNamesEqual, hasAttributes, hasParentAttributes
        );
        rootObjectNode.set(
                ElementUtils.getElementName((Element) childNode, namespace, removeNamespacePrefixes, skipNamespaces),
                rootArrayNode
        );
        return null;
    }
}
