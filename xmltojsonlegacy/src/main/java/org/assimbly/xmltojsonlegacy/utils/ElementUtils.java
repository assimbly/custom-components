package org.assimbly.xmltojsonlegacy.utils;

import org.assimbly.xmltojsonlegacy.Constants;
import org.assimbly.xmltojsonlegacy.Namespace;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.XMLConstants;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ElementUtils {

    // get namespace node, if it's defined
    public static Node getNamespaceNode(Element nodeElement) {
        if(nodeElement.hasAttributes()){
            NamedNodeMap attrMap = nodeElement.getAttributes();
            for (int j = 0; j < attrMap.getLength(); j++) {
                Node node = attrMap.item(j);
                String attributeName = node.getNodeName();
                if(attributeName.equals(XMLConstants.XMLNS_ATTRIBUTE) || attributeName.indexOf(XMLConstants.XMLNS_ATTRIBUTE+":")==0) {
                    return node;
                }
            }
        }
        return null;
    }

    // get element name prefix
    public static String getElementNamePrefix(Element nodeElement) {
        if(nodeElement!=null) {
            String name = nodeElement.getNodeName();
            if(name!=null && name.contains(":")) {
                return name.substring(0, name.indexOf(":"));
            }
        }
        return null;
    }

    // get namespaces on this node
    public static HashMap<String, Namespace> getNamespacesOnThisNode(Element nodeElement, HashMap<String, Namespace> xmlnsMap, int level) {
        HashMap<String, Namespace> xmlnsMapFromThisNode = new HashMap<>(xmlnsMap);
        if(nodeElement.hasAttributes()){
            NamedNodeMap attrMap = nodeElement.getAttributes();
            for (int j = 0; j < attrMap.getLength(); j++) {
                Node node = attrMap.item(j);
                String attributeName = node.getNodeName();
                if(attributeName.equals(XMLConstants.XMLNS_ATTRIBUTE) || attributeName.indexOf(XMLConstants.XMLNS_ATTRIBUTE+":")==0) {
                    Namespace namespace = new Namespace(node.getNodeValue(), level);
                    xmlnsMapFromThisNode.put(attributeName, namespace);
                }
            }
        }
        return xmlnsMapFromThisNode;
    }

    // get element name
    // removes namespace from element name when isRemoveNamespacePrefixes flag is enabled
    public static String getElementName(Element nodeElement, boolean removeNamespacePrefixes, boolean skipNamespaces) {
        String tagName = nodeElement.getTagName();
        if(removeNamespacePrefixes){
            if(tagName.contains(":")) {
                tagName = tagName.substring(tagName.indexOf(":")+1);
            }
        }
        return tagName;
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

    public static boolean isAnSpecialAttribute(String attribute) {
        return Constants.SPECIAL_JSON_XML_ATTR_TYPES.contains(attribute);
    }

    public static boolean isAnXmlnsAttribute(String attribute) {
        return attribute.equals("xmlns") || attribute.indexOf("xmlns:") == 0;
    }

    // check if element defines namespaces
    public static boolean isElementDefiningNamespaces(Element element, HashMap<String, Namespace> xmlnsMap) {
        if(element.hasAttributes()){
            NamedNodeMap attrMap = element.getAttributes();
            for (int j = 0; j < attrMap.getLength(); j++) {
                Node node = attrMap.item(j);
                String attributeName = node.getNodeName();
                if(attributeName.equals(XMLConstants.XMLNS_ATTRIBUTE) || attributeName.startsWith(XMLConstants.XMLNS_ATTRIBUTE+":")){
                    return true;
                }
            }
        }
        return false;
    }

    // check if siblings have the same name
    public static boolean areSiblingsNamesEqual(Element element) {
        String name = null;
        // Get the parent of the element
        Node parent = element.getParentNode();
        if (parent != null) {
            NodeList siblings = parent.getChildNodes();
            for (int i = 0; i < siblings.getLength(); i++) {
                Node sibling = siblings.item(i);
                if (sibling.getNodeType() == Node.ELEMENT_NODE) {
                    if(name != null) {
                        if(!name.equals(sibling.getNodeName())) {
                            return false;
                        }
                    } else {
                        name = sibling.getNodeName();
                    }
                }
            }
        }
        return true;
    }

    // check if children have the same name
    public static boolean areChildrenNamesEqual(Element element) {
        String name = null;
        // Get the direct child nodes of the parent element
        NodeList childNodes = element.getChildNodes();
        // Count the number of direct children elements
        for (int i = 0; i < childNodes.getLength(); i++) {
            Node childNode = childNodes.item(i);
            if (childNode.getNodeType() == Node.ELEMENT_NODE) {
                if(name != null) {
                    if(!name.equals(childNode.getNodeName())) {
                        return false;
                    }
                } else {
                    name = childNode.getNodeName();
                }
            }
        }
        return true;
    }

}
