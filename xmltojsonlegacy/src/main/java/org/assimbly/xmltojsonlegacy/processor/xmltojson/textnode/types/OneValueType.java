package org.assimbly.xmltojsonlegacy.processor.xmltojson.textnode.types;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.assimbly.xmltojsonlegacy.Constants;
import org.assimbly.xmltojsonlegacy.logs.Print;
import org.assimbly.xmltojsonlegacy.processor.xmltojson.textnode.TextNodeTransaction;
import org.assimbly.xmltojsonlegacy.utils.ElementUtils;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class OneValueType implements TextNodeTransaction {

    @Override
    public JsonNode process(
            Node childNode, Element element, ArrayNode rootArrayNode, ObjectNode rootObjectNode, int level, int index,
            int nodeListSize, boolean isRootArray, boolean isRootNode, boolean isObject, boolean isOneValue,
            String namespace, boolean forceTopLevelObject, boolean trimSpaces, boolean skipNamespaces,
            boolean removeNamespacePrefixes, boolean typeHints
    ) {
        //process text node identified as one value
        Print.data(" 2. ONE VALUE", level);
        if(typeHints) {
            rootArrayNode.add(ElementUtils.getNodeValue(childNode, trimSpaces));
        } else {
            if(element.hasAttributes()) {
                rootObjectNode.put(Constants.JSON_XML_TEXT_FIELD, ElementUtils.getNodeValue(childNode, trimSpaces));
            } else {
                rootArrayNode.add(ElementUtils.getNodeValue(childNode, trimSpaces));
            }
        }
        return null;
    }
}
