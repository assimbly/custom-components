package org.assimbly.xmltojsonlegacy.processor.xmltojson.elementnode.types;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.assimbly.xmltojsonlegacy.Constants;
import org.assimbly.xmltojsonlegacy.Namespace;
import org.assimbly.xmltojsonlegacy.processor.xmltojson.elementnode.ElementNodeTransaction;
import org.assimbly.xmltojsonlegacy.utils.ElementChecker;
import org.assimbly.xmltojsonlegacy.utils.ElementUtils;
import org.assimbly.xmltojsonlegacy.utils.ExtractUtils;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import java.util.HashMap;

public class OtherTypeWithNamespace implements ElementNodeTransaction {

    @Override
    public JsonNode process(
            Node childNode, ArrayNode rootArrayNode, ObjectNode rootObjectNode, int nodeCount, int level,
            int numberOfChildren, int numberOfSiblings, String parentClass, String classAttr, boolean isRootArray,
            boolean isObject, boolean isSingleChildren, boolean isFirstChild, boolean isFirstSibling,
            Element childElement, String namespace, HashMap<String, Namespace> xmlnsMap, boolean trimSpaces,
            boolean skipNamespaces, boolean removeNamespacePrefixes, boolean typeHints, boolean areSiblingsNamesEqual,
            boolean isParentSiblingsNamesEqual, boolean hasAttributes, boolean hasParentAttributes,
            boolean areChildrenNamesEqual, boolean isElementMustBeNull, boolean isElementOnNamespace
    ) {
        if(numberOfChildren == 1 || numberOfChildren > 1 && !areChildrenNamesEqual) {
            ExtractUtils.extractChildAsOtherInObjectNode(
                    level, rootObjectNode, numberOfSiblings, parentClass, classAttr, (Element) childNode, childElement,
                    isFirstSibling, namespace, xmlnsMap, removeNamespacePrefixes, areSiblingsNamesEqual,
                    isParentSiblingsNamesEqual, hasAttributes, hasParentAttributes, trimSpaces, isElementMustBeNull,
                    isElementOnNamespace
            );
        } else {
            ExtractUtils.extractChildAsOtherInArrayNode(
                    level, rootArrayNode, numberOfSiblings, parentClass, classAttr, childElement, isFirstSibling,
                    namespace, xmlnsMap, areSiblingsNamesEqual, isParentSiblingsNamesEqual, hasAttributes,
                    hasParentAttributes
            );
            rootObjectNode.set(ElementUtils.getElementName((Element) childNode, removeNamespacePrefixes), rootArrayNode);
        }
        return null;
    }
}
