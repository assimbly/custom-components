package org.assimbly.xmltojsonlegacy.processor.textnode.types;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.assimbly.xmltojsonlegacy.logs.Print;
import org.assimbly.xmltojsonlegacy.processor.textnode.TextNodeTransaction;
import org.assimbly.xmltojsonlegacy.utils.ElementChecker;
import org.assimbly.xmltojsonlegacy.utils.ElementUtils;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class OtherType implements TextNodeTransaction {

    @Override
    public JsonNode process(
            Node childNode, Element element, ArrayNode rootArrayNode, ObjectNode rootObjectNode, int level, int index,
            int nodeListSize, boolean isRootArray, boolean isRootNode, boolean isObject, boolean isOneValue,
            String namespace, boolean forceTopLevelObject, boolean trimSpaces, boolean skipNamespaces,
            boolean removeNamespacePrefixes, boolean typeHints
    ) {
        //process text node identified as other
        Print.data(" 2. OTHER", level);
        if(typeHints){
            rootObjectNode.put(
                    ElementUtils.getElementName(element, namespace, removeNamespacePrefixes, skipNamespaces),
                    ElementUtils.getNodeValue(childNode, trimSpaces));
        } else {
            if(ElementChecker.isLastElement(element)) {
                rootObjectNode.put(
                        ElementUtils.getElementName(element, namespace, removeNamespacePrefixes, skipNamespaces),
                        ElementUtils.getNodeValue(childNode, trimSpaces));
            }
        }
        return null;
    }
}