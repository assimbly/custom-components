package org.assimbly.xmltojsonlegacy.utils;

import org.w3c.dom.Element;

public class ElementChecker {

    private static final String JSON_XML_ATTR_CLASS_ARRAY = "array";
    private static final String JSON_XML_ATTR_CLASS_OBJECT = "object";

    // check if it's a root array
    public static boolean isRootArray(
            int level, int numberOfChildren, int numberOfSiblings, int parentSiblings, String classAttr,
            String parentClass, boolean hasAttributes, int elementDeepestDepth, String namespace,
            boolean isTypeHintsEnabled
    ) {
        boolean isRootArray = false;
        if(isTypeHintsEnabled) {
            if (level == 0 && numberOfChildren == 1 && namespace==null) {
                isRootArray = true;
            }
            if (elementDeepestDepth == 2 && namespace==null) {
                isRootArray = true;
            }
            if (elementDeepestDepth == 1 && parentClass != null &&
                    (parentClass.equals("") || parentClass.equalsIgnoreCase(JSON_XML_ATTR_CLASS_ARRAY))
            ) {
                isRootArray = true;
            }
            if (elementDeepestDepth == 1 && classAttr != null &&
                    ((classAttr.equals("") && numberOfChildren > 1) || classAttr.equalsIgnoreCase(JSON_XML_ATTR_CLASS_OBJECT))
            ) {
                if (parentSiblings > 1) {
                    isRootArray = true;
                } else {
                    isRootArray = false;
                }
            }
            if (elementDeepestDepth == 0 && numberOfSiblings == 1 &&
                    (parentClass == null || !parentClass.equalsIgnoreCase(JSON_XML_ATTR_CLASS_OBJECT))
            ) {
                isRootArray = true;
            }
        } else {
            if(level == 0 && numberOfChildren == 1 && namespace==null) {
                isRootArray = true;
            }
            if (elementDeepestDepth == 2 && classAttr!=null && classAttr.equals("") && namespace==null) {
                isRootArray = true;
            }
            if(elementDeepestDepth == 1 && parentClass!=null &&
                    (parentClass.equals("") || parentClass.equalsIgnoreCase(JSON_XML_ATTR_CLASS_ARRAY))
            ) {
                isRootArray = true;
            }
            if(elementDeepestDepth == 1 && classAttr!=null && classAttr.equalsIgnoreCase(JSON_XML_ATTR_CLASS_OBJECT)) {
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
    public static boolean isObject(int elementDeepestDepth, int numberOfChildren, String classAttr) {
        boolean isObject = false;
        if(elementDeepestDepth == 1 && classAttr!=null &&
                ((classAttr.equals("") && numberOfChildren > 1) || classAttr.equalsIgnoreCase(JSON_XML_ATTR_CLASS_OBJECT))
        ) {
            isObject = true;
        }
        return isObject;
    }

    // check if it's one value
    public static boolean isOneValue(int level, int numberOfSiblings, String parentClass, int elementDeepestDepth) {
        boolean isOneValue = false;
        if(elementDeepestDepth == 0 && numberOfSiblings == 1 &&
                (parentClass==null || !parentClass.equalsIgnoreCase(JSON_XML_ATTR_CLASS_OBJECT))
        ) {
            isOneValue = true;
        }
        return isOneValue;
    }

    // check if it's a single children
    public static boolean isSingleChildren(int elementDeepestDepth, int numberOfChildren, String classAttr, boolean isTypeHintsEnabled) {
        boolean isSingleChildren = false;
        if(!isTypeHintsEnabled) {
            if(elementDeepestDepth == 1 && numberOfChildren == 1
                    && (classAttr==null || !classAttr.equalsIgnoreCase(JSON_XML_ATTR_CLASS_OBJECT))
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
            if(elementDeepestDepth == 0 && parentClass!=null && parentClass.equalsIgnoreCase(JSON_XML_ATTR_CLASS_OBJECT)) {
                isAttributeObject = true;
            }
        }
        return isAttributeObject;
    }

    // check if it's the last element
    public static boolean isLastElement(Element nodeElement) {
        return ElementUtils.calculateNumberOfChildren(nodeElement) == 0;
    }

    // check if it's the first sibling regarding the numCounts
    public static boolean isFirstSiblingByNumCounts(int numCounts) {
        return numCounts == 1;
    }
}