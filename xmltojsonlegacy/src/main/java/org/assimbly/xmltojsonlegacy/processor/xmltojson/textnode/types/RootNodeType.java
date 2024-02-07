package org.assimbly.xmltojsonlegacy.processor.xmltojson.textnode.types;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.assimbly.xmltojsonlegacy.Constants;
import org.assimbly.xmltojsonlegacy.Namespace;
import org.assimbly.xmltojsonlegacy.logs.Print;
import org.assimbly.xmltojsonlegacy.processor.xmltojson.textnode.TextNodeTransaction;
import org.assimbly.xmltojsonlegacy.utils.ElementUtils;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import java.util.HashMap;

public class RootNodeType implements TextNodeTransaction {

    @Override
    public JsonNode process(
            Node childNode, Element element, ArrayNode rootArrayNode, ObjectNode rootObjectNode, int level, int index,
            int nodeListSize, String grandParentClass, String parentClass, boolean isRootArray, boolean isRootNode,
            boolean isObject, boolean isOneValue, String namespace, HashMap<String, Namespace> xmlnsMap,
            boolean forceTopLevelObject, boolean trimSpaces, boolean skipNamespaces, boolean removeNamespacePrefixes,
            boolean typeHints, boolean areSiblingsNamesEqual, boolean isParentSiblingsNamesEqual, boolean hasAttributes,
            boolean hasParentAttributes, boolean isElementMustBeNull
    ) {
        //process text node identified as a root node
        Print.data(" 2. ROOT", level);
        if(index+1 >= nodeListSize) {
            boolean isElementDefiningNamespaces = ElementUtils.isElementDefiningNamespaces(element);
            if(isElementDefiningNamespaces && !skipNamespaces) {
                Node namespaceNode = ElementUtils.getNamespaceNode(element);
                rootObjectNode.put(
                        Constants.JSON_XML_ATTR_PREFIX+namespaceNode.getNodeName(),
                        namespaceNode.getNodeValue()
                );
            }
            if(forceTopLevelObject) {
                ObjectNode parentNode =  JsonNodeFactory.instance.objectNode();
                parentNode.set(
                        ElementUtils.getElementName(element, removeNamespacePrefixes),
                        isRootArray ? rootArrayNode : rootObjectNode
                );
                return parentNode;
            }
        }
        return null;
    }
}
