package org.assimbly.xmltojsonlegacy.utils;

import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.XMLConstants;

public class ElementUtils {

    // get namespace node, if it's defined
    public static Node getNamespaceNode(Element nodeElement) {
        if(nodeElement.hasAttributes()){
            NamedNodeMap attrMap = nodeElement.getAttributes();
            for (int j = 0; j < attrMap.getLength(); j++) {
                Node node = attrMap.item(j);
                String attributeName = node.getNodeName();
                if(attributeName.startsWith(XMLConstants.XMLNS_ATTRIBUTE) && !attributeName.equals(XMLConstants.XMLNS_ATTRIBUTE)){
                    return node;
                }
            }
        }
        return null;
    }

    // get namespace
    public static String getNamespace(Element nodeElement) {
        Node namespaceNode = getNamespaceNode(nodeElement);
        if(namespaceNode!=null) {
            return namespaceNode.getNodeName().replaceFirst(XMLConstants.XMLNS_ATTRIBUTE+":", "");
        }
        return null;
    }

    // get element name
    // removes namespace from element name when isRemoveNamespacePrefixes flag is enabled
    public static String getElementName(Element nodeElement, String namespace, boolean removeNamespacePrefixes, boolean skipNamespaces) {
        if(!skipNamespaces && removeNamespacePrefixes && namespace!=null){
            String tagName = nodeElement.getTagName();
            return tagName.replaceFirst(namespace+":", "");
        } else {
            return nodeElement.getTagName();
        }
    }

    // get element value
    public static String getNodeValue(Node node, boolean trimSpaces) {
        if(trimSpaces){
            return node.getTextContent().trim();
        } else {
            return node.getTextContent();
        }
    }

    // calculate number of siblings of an element
    public static int calculateNumberOfSiblings(Element element) {
        int count = 0;
        // Get the parent of the element
        Node parent = element.getParentNode();
        if (parent != null) {
            NodeList siblings = parent.getChildNodes();
            for (int i = 0; i < siblings.getLength(); i++) {
                Node sibling = siblings.item(i);
                if (sibling.getNodeType() == Node.ELEMENT_NODE) {
                    count++;
                }
            }
        }
        return count;
    }

    // calculate number of children under an element
    public static int calculateNumberOfChildren(Element element) {
        int count = 0;
        // Get the direct child nodes of the parent element
        NodeList childNodes = element.getChildNodes();
        // Count the number of direct children elements
        for (int i = 0; i < childNodes.getLength(); i++) {
            Node childNode = childNodes.item(i);
            if (childNode.getNodeType() == Node.ELEMENT_NODE) {
                count++;
            }
        }
        return count;
    }

    // calculate element depth
    public static int calculateElementDeepestDepth(Element element) {
        int depth = 0;
        NodeList children = element.getChildNodes();
        for (int i = 0; i < children.getLength(); i++) {
            Node node = children.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                int childDepth = calculateElementDeepestDepth((Element) node);
                depth = Math.max(depth, childDepth + 1);
            }
        }
        return depth;
    }

}
