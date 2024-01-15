package org.assimbly.xmltojsonlegacy.processor.xmltojson.elementnode.types;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.apache.commons.lang3.StringUtils;
import org.assimbly.xmltojsonlegacy.Namespace;
import org.assimbly.xmltojsonlegacy.logs.Print;
import org.assimbly.xmltojsonlegacy.processor.XmlToJsonProcessor;
import org.assimbly.xmltojsonlegacy.processor.xmltojson.elementnode.ElementNodeTransaction;
import org.assimbly.xmltojsonlegacy.utils.ExtractUtils;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import java.util.HashMap;

public class RootArrayType implements ElementNodeTransaction {

    @Override
    public JsonNode process(
            Node childNode, ArrayNode rootArrayNode, ObjectNode rootObjectNode, int nodeCount, int level,
            int numberOfChildren, int numberOfSiblings, String parentClass, String classAttr, boolean isRootArray,
            boolean isObject, boolean isSingleChildren, boolean isFirstChild, boolean isFirstSibling, Element childElement,
            String namespace, HashMap<String, Namespace> xmlnsMap, boolean trimSpaces, boolean skipNamespaces,
            boolean removeNamespacePrefixes, boolean typeHints, boolean areSiblingsNamesEqual,
            boolean isParentSiblingsNamesEqual, boolean hasAttributes, boolean hasParentAttributes, boolean areChildrenNamesEqual
    ) {
        Print.data(" 1. IS ROOT ARRAY", level);
        if(isSingleChildren && isFirstChild && StringUtils.isNotEmpty(parentClass)) {
            // recursive call with child element
            return XmlToJsonProcessor.convertXmlToJson(
                    childElement, level +1, parentClass, classAttr, numberOfSiblings, isParentSiblingsNamesEqual,
                    areSiblingsNamesEqual, hasParentAttributes, hasAttributes, isFirstSibling, namespace, xmlnsMap);
        } else {
            // extract child as an array
            ExtractUtils.extractChildAsArray(
                    level, rootArrayNode, numberOfSiblings, parentClass, classAttr, childElement, isFirstSibling,
                    namespace, xmlnsMap, areSiblingsNamesEqual, isParentSiblingsNamesEqual, hasAttributes, hasParentAttributes);
        }
        return null;
    }
}
