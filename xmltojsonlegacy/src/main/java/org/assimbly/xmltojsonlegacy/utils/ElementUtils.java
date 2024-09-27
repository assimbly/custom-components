package org.assimbly.xmltojsonlegacy.utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.assimbly.xmltojsonlegacy.Constants;
import org.assimbly.xmltojsonlegacy.Namespace;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.XMLConstants;
import java.util.HashMap;

public class ElementUtils {

    // get namespace node, if it's defined
    public static Node getNamespaceNode(Element nodeElement) {
        if(!nodeElement.hasAttributes()){
            return null;
        }

        NamedNodeMap attrMap = nodeElement.getAttributes();
        for (int j = 0; j < attrMap.getLength(); j++) {
            Node node = attrMap.item(j);
            String attributeName = node.getNodeName();
            if(attributeName.equals(XMLConstants.XMLNS_ATTRIBUTE) ||
                    attributeName.indexOf(XMLConstants.XMLNS_ATTRIBUTE+":")==0
            ) {
                return node;
            }
        }

        return null;
    }

    // get element name prefix
    public static String getElementNamePrefix(Element nodeElement) {
        if(nodeElement==null) {
            return null;
        }

        String name = nodeElement.getNodeName();
        if(name!=null && name.contains(":")) {
            return name.substring(0, name.indexOf(":"));
        }

        return null;
    }

    // get element namespace label
    public static String getElementNamespaceLabel(Element nodeElement) {
        String elementNamePrefix = getElementNamePrefix(nodeElement);
        String namespaceLabel = XMLConstants.XMLNS_ATTRIBUTE;
        if (elementNamePrefix != null) {
            namespaceLabel += ":" + elementNamePrefix;
        }
        return namespaceLabel;
    }

    // get namespaces on this node
    public static HashMap<String, Namespace> getNamespacesOnThisNode(
            Element nodeElement, HashMap<String, Namespace> xmlnsMap, int level
    ) {
        if(!nodeElement.hasAttributes()){
            return new HashMap<>(xmlnsMap);
        }

        HashMap<String, Namespace> xmlnsMapFromThisNode = new HashMap<>(xmlnsMap);
        NamedNodeMap attrMap = nodeElement.getAttributes();
        for (int j = 0; j < attrMap.getLength(); j++) {
            Node node = attrMap.item(j);
            String attributeName = node.getNodeName();
            if(attributeName.equals(XMLConstants.XMLNS_ATTRIBUTE) ||
                    attributeName.indexOf(XMLConstants.XMLNS_ATTRIBUTE+":")==0
            ) {
                Namespace namespace = new Namespace(node.getNodeValue(), level);
                xmlnsMapFromThisNode.put(attributeName, namespace);
            }
        }

        return xmlnsMapFromThisNode;
    }

    // get element name
    // removes namespace from element name when isRemoveNamespacePrefixes flag is enabled
    public static String getElementName(Element nodeElement, boolean removeNamespacePrefixes) {
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
        String textContent = node.getTextContent().replaceAll("\\r\\n|\\n", "");
        if(trimSpaces){
            textContent = textContent.trim();
        }
        return textContent;
    }


    public static JsonNode getValidJson(String value) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(value);
            if (jsonNode.isObject() || jsonNode.isArray()) {
                return jsonNode;
            } else {
                return null; // Not a valid JSON object or array
            }
        } catch (Exception e) {
            return null;
        }
    }

    // calculate number of siblings of an element
    public static int calculateNumberOfSiblings(Element element) {
        // Get the parent of the element
        Node parent = element.getParentNode();
        if (parent == null) {
            return 0;
        }

        int count = 0;
        NodeList siblings = parent.getChildNodes();
        for (int i = 0; i < siblings.getLength(); i++) {
            Node sibling = siblings.item(i);
            if (sibling.getNodeType() == Node.ELEMENT_NODE) {
                count++;
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

    // check if attribute is a special attribute
    public static boolean isAnSpecialAttribute(String attribute) {
        return Constants.SPECIAL_JSON_XML_ATTR_TYPES.contains(attribute);
    }

    // check if attribute is a xmlns
    public static boolean isAnXmlnsAttribute(String attribute) {
        return attribute.equals("xmlns") || attribute.indexOf("xmlns:") == 0;
    }

    // check if element defines namespaces
    public static boolean isElementDefiningNamespaces(Element element) {
        if(!element.hasAttributes()){
            return false;
        }

        NamedNodeMap attrMap = element.getAttributes();
        for (int j = 0; j < attrMap.getLength(); j++) {
            Node node = attrMap.item(j);
            String attributeName = node.getNodeName();
            if(attributeName.equals(XMLConstants.XMLNS_ATTRIBUTE) ||
                    attributeName.startsWith(XMLConstants.XMLNS_ATTRIBUTE+":")
            ){
                return true;
            }
        }

        return false;
    }

    // check if siblings have the same name
    public static boolean areSiblingsNamesEqual(Element element) {
        // Get the parent of the element
        Node parent = element.getParentNode();
        if (parent == null) {
            return true;
        }

        String name = null;
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
            if (childNode.getNodeType() != Node.ELEMENT_NODE) {
                continue;
            }

            if(name != null) {
                if(!name.equals(childNode.getNodeName())) {
                    return false;
                }
            } else {
                name = childNode.getNodeName();
            }
        }

        return true;
    }

    // check if node element is included on a namespace
    public static boolean isElementOnNamespace(Element nodeElement, HashMap<String, Namespace> xmlnsMap) {
        if(xmlnsMap == null || xmlnsMap.isEmpty()) {
            return false;
        }

        String namespaceLabel = ElementUtils.getElementNamespaceLabel(nodeElement);
        Namespace namespace = xmlnsMap.get(namespaceLabel);
        return namespace != null;
    }

    // check if node element have an empty text content
    public static boolean isElementWithEmptyTextContent(Element nodeElement) {
        if(!nodeElement.hasChildNodes()) {
            return true;
        }

        NodeList nodeList = nodeElement.getChildNodes();
        int nodeListSize = nodeList.getLength();
        for(int index = 0; index < nodeListSize; index++) {
            Node childNode = nodeList.item(index);
            boolean isTextNode = childNode.getNodeType() == Node.TEXT_NODE;
            boolean isTextNodeEmpty = (childNode.getTextContent() == null || childNode.getTextContent().replace("\n", "").isEmpty());
            if(isTextNode && !isTextNodeEmpty) {
                return false;
            }
        }

        return true;
    }

}
