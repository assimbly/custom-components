package org.assimbly.xmltojsonlegacy.utils;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class ElementUtils {

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
