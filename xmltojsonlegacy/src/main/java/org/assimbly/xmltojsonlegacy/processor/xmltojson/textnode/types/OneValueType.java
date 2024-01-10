package org.assimbly.xmltojsonlegacy.processor.xmltojson.textnode.types;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.assimbly.xmltojsonlegacy.Constants;
import org.assimbly.xmltojsonlegacy.logs.Print;
import org.assimbly.xmltojsonlegacy.processor.xmltojson.textnode.TextNodeTransaction;
import org.assimbly.xmltojsonlegacy.utils.ElementUtils;
import org.assimbly.xmltojsonlegacy.utils.ExtractUtils;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class OneValueType implements TextNodeTransaction {

    @Override
    public JsonNode process(
            Node childNode, Element element, ArrayNode rootArrayNode, ObjectNode rootObjectNode, int level, int index,
            int nodeListSize, String grandParentClass, String parentClass, boolean isRootArray, boolean isRootNode,
            boolean isObject, boolean isOneValue, String namespace, boolean forceTopLevelObject, boolean trimSpaces,
            boolean skipNamespaces, boolean removeNamespacePrefixes, boolean typeHints, boolean areSiblingsNamesEqual,
            boolean isParentSiblingsNamesEqual, boolean hasAttributes, boolean hasParentAttributes
    ) {
        //process text node identified as one value
        Print.data(" 2. ONE VALUE", level);
        boolean isFirstLevel = level == 1;
        if(isFirstLevel) {
            childNode = element;
        }
        if(typeHints) {
            if(ExtractUtils.rootObjectNodeContainsAttributes(rootObjectNode)) {
                rootObjectNode.put(Constants.JSON_XML_TEXT_FIELD, ElementUtils.getNodeValue(childNode, trimSpaces));
                if(isFirstLevel) return rootObjectNode;
            } else {
                rootArrayNode.add(ElementUtils.getNodeValue(childNode, trimSpaces));
                if(isFirstLevel) return rootArrayNode;
            }
        } else {
            if(element.hasAttributes()) {
                rootObjectNode.put(Constants.JSON_XML_TEXT_FIELD, ElementUtils.getNodeValue(childNode, trimSpaces));
                if(isFirstLevel) return rootObjectNode;
            } else {
                rootArrayNode.add(ElementUtils.getNodeValue(childNode, trimSpaces));
                if(isFirstLevel) return rootArrayNode;
            }
        }
        return null;
    }
}
