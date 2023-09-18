package org.assimbly.xmltojsonlegacy.processor.xmltojson.elementnode.types;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.assimbly.xmltojsonlegacy.logs.Print;
import org.assimbly.xmltojsonlegacy.processor.XmlToJsonProcessor;
import org.assimbly.xmltojsonlegacy.processor.xmltojson.elementnode.ElementNodeTransaction;
import org.assimbly.xmltojsonlegacy.utils.ExtractUtils;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class RootArrayType implements ElementNodeTransaction {

    @Override
    public JsonNode process(
            Node childNode, ArrayNode rootArrayNode, ObjectNode rootObjectNode, int nodeCount, int level,
            int numberOfChildren, int numberOfSiblings, String classAttr, boolean isRootArray, boolean isObject,
            boolean isSingleChildren, boolean isFirstChild, boolean isFirstSibling, Element childElement,
            String namespace, boolean trimSpaces, boolean skipNamespaces, boolean removeNamespacePrefixes, boolean typeHints
    ) {
        Print.data(" 1. IS ROOT ARRAY", level);
        if(isSingleChildren && isFirstChild) {
            // recursive call with child element
            return XmlToJsonProcessor.convertXmlToJson(childElement, level +1, classAttr, numberOfSiblings, isFirstSibling, namespace);
        } else {
            // extract child as an array
            ExtractUtils.extractChildAsArray(level, rootArrayNode, numberOfSiblings, classAttr, childElement, isFirstSibling, namespace);
        }
        return null;
    }
}
