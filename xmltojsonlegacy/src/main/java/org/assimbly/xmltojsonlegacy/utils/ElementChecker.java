package org.assimbly.xmltojsonlegacy.utils;

import org.apache.commons.lang3.StringUtils;
import org.assimbly.xmltojsonlegacy.Constants;
import org.assimbly.xmltojsonlegacy.Namespace;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

import javax.xml.XMLConstants;
import java.util.HashMap;
import java.util.Set;

public class ElementChecker {

    // check if it's a root array
    public static boolean isRootArray(
            int level, int numberOfChildren, int numberOfSiblings, int parentSiblings, String classAttr,
            String parentClass, String grandParentClass, int elementDeepestDepth, boolean isElementDefiningNamespaces,
            boolean isTypeHintsEnabled, boolean areChildrenNamesEqual, boolean areSiblingsNamesEqual,
            boolean isParentSiblingsNamesEqual, boolean isGrandParentSiblingsNamesEqual, boolean hasAttributes,
            boolean hasParentAttributes, boolean isElementOnNamespace
    ) {
        boolean isRootArray;
        if(isTypeHintsEnabled) {
            isRootArray = isRootArrayWithTypeHints(
                    level, numberOfChildren, numberOfSiblings, classAttr, parentClass, grandParentClass,
                    elementDeepestDepth, isElementDefiningNamespaces, areChildrenNamesEqual, areSiblingsNamesEqual,
                    isParentSiblingsNamesEqual, isGrandParentSiblingsNamesEqual, hasAttributes, hasParentAttributes,
                    isElementOnNamespace
            );
        } else {
            isRootArray = isRootArrayWithoutTypeHints(
                    level, numberOfChildren, numberOfSiblings, parentSiblings, classAttr, elementDeepestDepth,
                    isElementDefiningNamespaces, areChildrenNamesEqual, areSiblingsNamesEqual, hasAttributes,
                    isElementOnNamespace
            );
        }
        return isRootArray;
    }

    private static boolean isRootArrayWithTypeHints(
            int level, int numberOfChildren, int numberOfSiblings, String classAttr, String parentClass,
            String grandParentClass, int elementDeepestDepth, boolean isElementDefiningNamespaces,
            boolean areChildrenNamesEqual, boolean areSiblingsNamesEqual, boolean isParentSiblingsNamesEqual,
            boolean isGrandParentSiblingsNamesEqual, boolean hasAttributes, boolean hasParentAttributes,
            boolean isElementOnNamespace
    ) {
        boolean isRootArray = false;

        if (level == 0 && numberOfChildren == 1 && !isElementDefiningNamespaces) {
            isRootArray = true;
        }
        if (elementDeepestDepth > 2 && !isElementDefiningNamespaces && areChildrenNamesEqual) {
            isRootArray = true;
        }
        if (elementDeepestDepth == 2 && !isElementDefiningNamespaces && areChildrenNamesEqual &&
                (areSiblingsNamesEqual || !classAttr.equalsIgnoreCase(Constants.JSON_XML_ATTR_TYPE_OBJECT))
        ) {
            isRootArray = true;
        }
        if (elementDeepestDepth == 1 && parentClass != null &&  !isElementOnNamespace &&
                (parentClass.equals("") || parentClass.equalsIgnoreCase(Constants.JSON_XML_ATTR_TYPE_ARRAY))
        ) {
            isRootArray = true;
        }
        if (elementDeepestDepth == 1 && classAttr != null && !isElementOnNamespace && (
                (classAttr.equals("") && numberOfChildren > 1) ||
                        classAttr.equalsIgnoreCase(Constants.JSON_XML_ATTR_TYPE_OBJECT)
        )) {
            isRootArray = true;
        }
        if (elementDeepestDepth == 0 && !hasAttributes && !hasParentAttributes &&
                (numberOfSiblings == 1 || numberOfSiblings > 1 && areSiblingsNamesEqual) &&
                (!parentClass.equalsIgnoreCase(Constants.JSON_XML_ATTR_TYPE_OBJECT) ||
                        parentClass.equalsIgnoreCase(Constants.JSON_XML_ATTR_TYPE_OBJECT) &&
                                isParentSiblingsNamesEqual) &&
                (!grandParentClass.equalsIgnoreCase(Constants.JSON_XML_ATTR_TYPE_OBJECT) ||
                        grandParentClass.equalsIgnoreCase(Constants.JSON_XML_ATTR_TYPE_OBJECT) &&
                                isGrandParentSiblingsNamesEqual)
        ) {
            isRootArray = true;
        }

        return isRootArray;
    }

    private static boolean isRootArrayWithoutTypeHints(
            int level, int numberOfChildren, int numberOfSiblings, int parentSiblings, String classAttr,
            int elementDeepestDepth, boolean isElementDefiningNamespaces, boolean areChildrenNamesEqual,
            boolean areSiblingsNamesEqual, boolean hasAttributes, boolean isElementOnNamespace
    ) {
        boolean isRootArray = false;

        if(level == 0 && numberOfChildren == 1 && !isElementDefiningNamespaces && !hasAttributes) {
            isRootArray = true;
        }
        if (elementDeepestDepth > 2 && !isElementDefiningNamespaces && areChildrenNamesEqual && !hasAttributes) {
            isRootArray = true;
        }
        if (elementDeepestDepth == 2 && !isElementDefiningNamespaces && areChildrenNamesEqual && !hasAttributes) {
            isRootArray = true;
        }
        if(elementDeepestDepth == 1 && !isElementDefiningNamespaces && areChildrenNamesEqual && !hasAttributes &&
                !isElementOnNamespace
        ) {
            isRootArray = true;
        }
        if(elementDeepestDepth == 1 && classAttr !=null &&
                classAttr.equalsIgnoreCase(Constants.JSON_XML_ATTR_TYPE_OBJECT)
        ) {
            if(parentSiblings > 1) {
                isRootArray = true;
            } else {
                isRootArray = false;
            }
        }
        if (elementDeepestDepth == 0 && !hasAttributes && (
                numberOfSiblings == 1 || numberOfSiblings > 1 && areSiblingsNamesEqual
        )) {
            isRootArray = true;
        }

        return isRootArray;
    }

    // check if it's an object
    public static boolean isObject(
            int level, int elementDeepestDepth, int numberOfChildren, String classAttr, int numberOfSiblings,
            boolean isTypeHintsEnabled, boolean isParentSiblingsNamesEqual, boolean areChildrenNamesEqual,
            boolean hasParentAttributes, String parentClass
    ) {
        boolean isObject = false;
        if(elementDeepestDepth == 1 && classAttr!=null && (
                numberOfChildren > 1  && (level == 0 || level > 0 && !areChildrenNamesEqual) ||
                        numberOfChildren == 1 && classAttr.equalsIgnoreCase(Constants.JSON_XML_ATTR_TYPE_OBJECT) &&
                                (!isTypeHintsEnabled ||
                                        numberOfSiblings > 1 && isTypeHintsEnabled &&
                                                !parentClass.equalsIgnoreCase(Constants.JSON_XML_ATTR_TYPE_ARRAY) ||
                                        isTypeHintsEnabled &&
                                                classAttr.equalsIgnoreCase(Constants.JSON_XML_ATTR_TYPE_OBJECT) &&
                                                (!hasParentAttributes && !isParentSiblingsNamesEqual))
        )) {
                isObject = true;
        }
        return isObject;
    }

    // check if it's one value
    public static boolean isOneValue(
            String parentClass, int elementDeepestDepth, boolean isTypeHintsEnabled, boolean areSiblingsNamesEqual,
            boolean areChildrenNamesEqual, boolean isGrandParentSiblingsNamesEqual, boolean isParentSiblingsNamesEqual
    ) {
        boolean isOneValue = false;
        if(elementDeepestDepth == 0 && areSiblingsNamesEqual && areChildrenNamesEqual && (
                !isTypeHintsEnabled || (
                        parentClass == null ||
                                !parentClass.equalsIgnoreCase(Constants.JSON_XML_ATTR_TYPE_OBJECT) ||
                                (isGrandParentSiblingsNamesEqual && isParentSiblingsNamesEqual)
                )
        )) {
            isOneValue = true;

        }
        return isOneValue;
    }

    // check if element should be null
    public static boolean isElementMustBeNull(
            boolean skipWhitespace, Node node, HashMap<String, Namespace> xmlnsMap, boolean isTypeHintsEnabled,
            boolean isTTFTTF, boolean areParentSiblingsNamesEqual
    ) {
        if(!skipWhitespace) {
            return false;
        }

        if(isTTFTTF) {

            if(node.getNodeType() == Node.ELEMENT_NODE) {
                Element nodeElement = (Element)node;

                int elementDeepestDepth = ElementUtils.calculateElementDeepestDepth(nodeElement);
                if(elementDeepestDepth == 0) {
                    boolean isElementOnNamespace = ElementUtils.isElementOnNamespace(nodeElement, xmlnsMap);
                    if(!node.hasAttributes()) {
                        if(isElementOnNamespace) {
                            return true;
                        }
                        return false;
                    }

                    boolean areSiblingsNamesEqual = ElementUtils.areSiblingsNamesEqual(nodeElement);
                    if(areSiblingsNamesEqual && areParentSiblingsNamesEqual) {
                        return true;
                    }

                    NamedNodeMap attributes = node.getAttributes();
                    for (int i = 0; i < attributes.getLength(); i++) {
                        Node attribute = attributes.item(i);
                        String attrName = attribute.getNodeName();
                        if(!attrName.equalsIgnoreCase(Constants.JSON_XML_ATTR_TYPE)) {
                            return true;
                        }
                    }
                }
                return false;
            }

        } else {
            if(isTypeHintsEnabled && node.hasAttributes()) {
                NamedNodeMap attributes = node.getAttributes();
                for (int i = 0; i < attributes.getLength(); i++) {
                    Node attribute = attributes.item(i);
                    String attrName = attribute.getNodeName();
                    if(attrName.equalsIgnoreCase(Constants.JSON_XML_ATTR_TYPE)) {
                        String attrValue = attribute.getNodeValue();
                        if(attrValue.equalsIgnoreCase(Constants.JSON_XML_ATTR_TYPE_NUMBER) ||
                                attrValue.equalsIgnoreCase(Constants.JSON_XML_ATTR_TYPE_BOOLEAN)
                        ) {
                            return false;
                        }
                    }
                }
            }

            if(node.getNodeType() == Node.ELEMENT_NODE) {
                Element nodeElement = (Element)node;
                int elementDeepestDepth = ElementUtils.calculateElementDeepestDepth(nodeElement);

                String namespaceLabel = ElementUtils.getElementNamespaceLabel(nodeElement);
                Namespace namespace = xmlnsMap.get(namespaceLabel);

                if(elementDeepestDepth == 0 && (namespace!=null || nodeElement.hasAttributes())) {
                    return true;
                }
            } else {
                if(node.hasAttributes()) {
                    return true;
                }
            }
        }

        return false;
    }

    // check if it's a single children
    public static boolean isSingleChildren(
            int elementDeepestDepth, int numberOfChildren, String classAttr, boolean isTypeHintsEnabled
    ) {
        boolean isSingleChildren = false;
        if(!isTypeHintsEnabled) {
            if(elementDeepestDepth == 1 && numberOfChildren == 1
                    && (classAttr==null || !classAttr.equalsIgnoreCase(Constants.JSON_XML_ATTR_TYPE_OBJECT))
            ) {
                isSingleChildren = true;
            }
        }
        return isSingleChildren;
    }

    // check if there's other attributes except the specified attributes
    public static boolean hasOtherAttributes(Element element, Set<String> exceptAttr) {
        if(element == null || exceptAttr == null) {
            return false;
        }

        NamedNodeMap attributes = element.getAttributes();
        for (int i = 0; i < attributes.getLength(); i++) {
            Node attribute = attributes.item(i);
            if(!exceptAttr.contains(attribute.getNodeName())) {
                return true;
            }
        }

        return false;
    }

    // check if there's simple attributes
    public static boolean hasSimpleAttributes(Element element) {
        Set<String> complexAttr = Set.of(
                Constants.JSON_XML_ATTR_TYPE,
                Constants.JSON_XML_ATTR_CLASS
        );
        return hasOtherAttributes(element, complexAttr);
    }

    // check if it's the last element
    public static boolean isLastElement(Element nodeElement) {
        return ElementUtils.calculateNumberOfChildren(nodeElement) == 0;
    }

    // check if it's the first sibling regarding the numCounts
    public static boolean isFirstSiblingByNumCounts(int numCounts) {
        return numCounts == 1;
    }

    // check if element node value is null
    public static boolean isElementNodeValueNull(Element element) {
        return element.getNodeValue() == null;
    }

    // check if element attribute is null
    public static boolean isElementAttributeNull(Element element, String attribute) {
        return element.getAttributes().getNamedItem(attribute) == null;
    }
}
