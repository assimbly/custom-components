package org.assimbly.xmltojsonlegacy.processor.xmltojson.elementnode.types;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.assimbly.xmltojsonlegacy.logs.Print;
import org.assimbly.xmltojsonlegacy.processor.xmltojson.elementnode.ElementNodeTransaction;
import org.assimbly.xmltojsonlegacy.utils.ExtractUtils;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class ObjectType implements ElementNodeTransaction {

    @Override
    public JsonNode process(
            Node childNode, ArrayNode rootArrayNode, ObjectNode rootObjectNode, int nodeCount, int level,
            int numberOfChildren, int numberOfSiblings, String parentClass, String classAttr, boolean isRootArray,
            boolean isObject, boolean isSingleChildren, boolean isFirstChild, boolean isFirstSibling, Element childElement,
            String namespace, boolean trimSpaces, boolean skipNamespaces, boolean removeNamespacePrefixes, boolean typeHints
    ) {
        // extract child as an object
        Print.data(" 1. IS OBJECT", level);
        ExtractUtils.extractChildAsObject(
                level, rootObjectNode, numberOfSiblings, parentClass, classAttr, childElement, isFirstSibling, namespace,
                trimSpaces, skipNamespaces, removeNamespacePrefixes, typeHints
        );
        return null;
    }
}
