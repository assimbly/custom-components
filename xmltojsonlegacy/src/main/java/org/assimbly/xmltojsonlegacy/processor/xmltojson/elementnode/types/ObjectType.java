package org.assimbly.xmltojsonlegacy.processor.xmltojson.elementnode.types;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.assimbly.xmltojsonlegacy.Namespace;
import org.assimbly.xmltojsonlegacy.logs.Print;
import org.assimbly.xmltojsonlegacy.processor.xmltojson.elementnode.ElementNodeTransaction;
import org.assimbly.xmltojsonlegacy.utils.ExtractUtils;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import java.util.HashMap;

public class ObjectType implements ElementNodeTransaction {

    @Override
    public JsonNode process(
            Node childNode, ArrayNode rootArrayNode, ObjectNode rootObjectNode, int nodeCount, int level,
            int numberOfChildren, int numberOfSiblings, String parentClass, String classAttr, boolean isRootArray,
            boolean isObject, boolean isSingleChildren, boolean isFirstChild, boolean isFirstSibling, Element childElement,
            String namespace, HashMap<String, Namespace> xmlnsMap, boolean trimSpaces, boolean skipNamespaces,
            boolean removeNamespacePrefixes, boolean typeHints, boolean areSiblingsNamesEqual,
            boolean isParentSiblingsNamesEqual, boolean hasAttributes, boolean hasParentAttributes, boolean areChildrenNamesEqual,
            boolean isElementMustBeNull, boolean isElementOnNamespace
    ) {
        // extract child as an object
        Print.data(" 1. IS OBJECT", level);
        ExtractUtils.extractChildAsObject(
                level, rootObjectNode, numberOfSiblings, parentClass, classAttr, childElement, isFirstSibling, namespace,
                xmlnsMap, trimSpaces, skipNamespaces, removeNamespacePrefixes, typeHints, areSiblingsNamesEqual,
                isParentSiblingsNamesEqual, hasAttributes, hasParentAttributes, isElementMustBeNull
        );
        return null;
    }
}
