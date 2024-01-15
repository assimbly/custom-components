package org.assimbly.xmltojsonlegacy.utils;

import org.apache.commons.lang3.StringUtils;
import org.assimbly.xmltojsonlegacy.Constants;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

import java.util.Set;

public class ElementChecker {

    // check if it's a root array
    public static boolean isRootArray(
            int level, int numberOfChildren, int numberOfSiblings, int parentSiblings, String classAttr,
            String parentClass, int elementDeepestDepth, boolean isElementDefiningNamespaces, boolean isTypeHintsEnabled,
            boolean areChildrenNamesEqual, boolean isParentSiblingsNamesEqual, boolean isGrandParentSiblingsNamesEqual,
            boolean hasAttributes,  boolean hasParentAttributes, boolean hasGrandParentAttributes
    ) {
        boolean isRootArray = false;
        if(isTypeHintsEnabled) {
            if (level == 0 && numberOfChildren == 1 && !isElementDefiningNamespaces) {
                isRootArray = true;
            }
            if (elementDeepestDepth > 2 && !isElementDefiningNamespaces && areChildrenNamesEqual) {
                isRootArray = true;
            }
            if (elementDeepestDepth == 2 && !isElementDefiningNamespaces && areChildrenNamesEqual && (StringUtils.isEmpty(classAttr) || !classAttr.equalsIgnoreCase(Constants.JSON_XML_ATTR_TYPE_OBJECT))) {
                isRootArray = true;
            }
            if (elementDeepestDepth == 1 && parentClass != null &&
                    (parentClass.equals("") || parentClass.equalsIgnoreCase(Constants.JSON_XML_ATTR_TYPE_ARRAY))
            ) {
                isRootArray = true;
            }
            if (elementDeepestDepth == 1 && classAttr != null &&
                    ((classAttr.equals("") && numberOfChildren > 1) || classAttr.equalsIgnoreCase(Constants.JSON_XML_ATTR_TYPE_OBJECT))
            ) {
                isRootArray = true;
            }
            if (elementDeepestDepth == 0 && numberOfSiblings == 1 &&
                    isGrandParentSiblingsNamesEqual && isParentSiblingsNamesEqual && !hasAttributes && !hasParentAttributes && !hasGrandParentAttributes
            ) {
                isRootArray = true;
            }
        } else {
            if(level == 0 && numberOfChildren == 1 && !isElementDefiningNamespaces) {
                isRootArray = true;
            }
            if (elementDeepestDepth > 2 && !isElementDefiningNamespaces && areChildrenNamesEqual) {
                isRootArray = true;
            }
            if (elementDeepestDepth == 2 && !isElementDefiningNamespaces && areChildrenNamesEqual && classAttr!=null && classAttr.equals("")) {
                isRootArray = true;
            }
            if(elementDeepestDepth == 1 && parentClass!=null &&
                    (parentClass.equals("") || parentClass.equalsIgnoreCase(Constants.JSON_XML_ATTR_TYPE_ARRAY))
            ) {
                isRootArray = true;
            }
            if(elementDeepestDepth == 1 && classAttr!=null && classAttr.equalsIgnoreCase(Constants.JSON_XML_ATTR_TYPE_OBJECT)) {
                if(parentSiblings > 1) {
                    isRootArray = true;
                } else {
                    isRootArray = false;
                }
            }
            if (elementDeepestDepth == 0 && numberOfSiblings == 1 && !hasAttributes) {
                isRootArray = true;
            }
        }
        return isRootArray;
    }

    // check if it's an object
    public static boolean isObject(
            int elementDeepestDepth, int numberOfChildren, String classAttr, int numberOfSiblings, boolean isTypeHintsEnabled,
            boolean isParentSiblingsNamesEqual, boolean hasParentAttributes, String parentClass
    ) {
        boolean isObject = false;
        if(elementDeepestDepth == 1 && classAttr!=null && (
                numberOfChildren > 1 ||
                        numberOfChildren == 1 && classAttr.equalsIgnoreCase(Constants.JSON_XML_ATTR_TYPE_OBJECT) &&
                                (!isTypeHintsEnabled || numberOfSiblings > 1 && isTypeHintsEnabled && !parentClass.equalsIgnoreCase(Constants.JSON_XML_ATTR_TYPE_ARRAY) ||
                        isTypeHintsEnabled && classAttr.equalsIgnoreCase(Constants.JSON_XML_ATTR_TYPE_OBJECT) &&
                                (!hasParentAttributes && !isParentSiblingsNamesEqual))
        )) {
                isObject = true;
        }
        return isObject;
    }

    // check if it's one value
    public static boolean isOneValue(String parentClass, int elementDeepestDepth,
                                     boolean isTypeHintsEnabled, boolean topTreeSiblingsNamesEqual,
                                     boolean areSiblingsNamesEqual, boolean areChildrenNamesEqual, int parentSiblings,
                                     boolean isGrandParentSiblingsNamesEqual, boolean isParentSiblingsNamesEqual) {
        boolean isOneValue = false;
        if(elementDeepestDepth == 0 && topTreeSiblingsNamesEqual && areSiblingsNamesEqual && areChildrenNamesEqual && (
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

    // check if it's a single children
    public static boolean isSingleChildren(int elementDeepestDepth, int numberOfChildren, String classAttr, boolean isTypeHintsEnabled) {
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

    // check if it's an attribute object
    public static boolean isAttributeObject(int level, String parentClass, int elementDeepestDepth, boolean isTypeHintsEnabled) {
        boolean isAttributeObject = false;
        if(!isTypeHintsEnabled) {
            if(elementDeepestDepth == 0 && parentClass!=null && parentClass.equalsIgnoreCase(Constants.JSON_XML_ATTR_TYPE_OBJECT)) {
                isAttributeObject = true;
            }
        }
        return isAttributeObject;
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
