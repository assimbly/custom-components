package org.assimbly.xmltojsonlegacy.transaction.textnode.types;

import com.fasterxml.jackson.databind.JsonNode;
import org.assimbly.xmltojsonlegacy.Constants;
import org.assimbly.xmltojsonlegacy.XmlToJsonConfiguration;
import org.assimbly.xmltojsonlegacy.logs.Print;
import org.assimbly.xmltojsonlegacy.transaction.textnode.TextNodeTransaction;
import org.assimbly.xmltojsonlegacy.utils.ElementUtils;
import org.w3c.dom.Node;

public class RootNodeType implements TextNodeTransaction {

    @Override
    public JsonNode process(XmlToJsonConfiguration config, Node childNode, int index, int nodeListSize) {
        //process text node identified as a root node
        Print.data(" 2. ROOT", config.getLevel());
        if(index+1 < nodeListSize) {
            return null;
        }

        boolean isElementDefiningNamespaces = ElementUtils.isElementDefiningNamespaces(config.getElement());
        if(isElementDefiningNamespaces && !config.isSkipNamespaces()) {
            Node namespaceNode = ElementUtils.getNamespaceNode(config.getElement());
            config.getRootObjectNode().put(
                    Constants.JSON_XML_ATTR_PREFIX+namespaceNode.getNodeName(),
                    namespaceNode.getNodeValue()
            );
        }

        return null;
    }
}
