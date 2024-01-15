package org.assimbly.xmltojsonlegacy.logs;

import org.apache.log4j.Logger;
import org.assimbly.xmltojsonlegacy.utils.ElementUtils;
import org.w3c.dom.Element;

public class Print {

    static final Logger logger = Logger.getLogger(Print.class);

    // print some information about a specific tree level
    public static void elementDetails(
            Element element, int level, String grandParentClass, String parentClass, int parentSiblings, boolean isRootArray, boolean isOneValue,
            boolean isObject, boolean isFirstChild, int numberOfSiblings, int numberOfChildren, String classAttr,
            String typeAttr, String namespace, boolean removeNamespacePrefixes, boolean skipNamespaces,
            boolean isParentSiblingsNamesEqual, boolean areSiblingsNamesEqual, boolean areChildrenNamesEqual,
            boolean hasGrandParentAttributes, boolean hasParentAttributes, boolean hasSimpleAttributes,
            int elementDeepestDepth
    ) {
        if(logger.isDebugEnabled()) {
            data(" >> Element: " +
                    ElementUtils.getElementName(element, removeNamespacePrefixes, skipNamespaces),
                    level
            );
            data("    typeAttr: " + typeAttr, level);
            data("    classAttr: " + classAttr, level);
            data("    grandParentClass: " + grandParentClass, level);
            data("    parentClass: " + parentClass, level);
            data("    numberOfChildren: " + numberOfChildren, level);
            data("    numberOfSiblings: " + numberOfSiblings, level);
            data("    parentSiblings: " + parentSiblings, level);
            data("    isRootArray: " + isRootArray, level);
            data("    isOneValue: " + isOneValue, level);
            data("    isObject: " + isObject, level);
            data("    isFirstChild: " + isFirstChild, level);

            data("    isParentSiblingsNamesEqual: " + isParentSiblingsNamesEqual, level);
            data("    areSiblingsNamesEqual: " + areSiblingsNamesEqual, level);
            data("    areChildrenNamesEqual: " + areChildrenNamesEqual, level);

            data("    hasGrandParentAttributes: " + hasGrandParentAttributes, level);
            data("    hasParentAttributes: " + hasParentAttributes, level);
            data("    hasSimpleAttributes: " + hasSimpleAttributes, level);

            data("    elementDeepestDepth: " + elementDeepestDepth, level);
        }
    }

    // print data string with the tree level indentation
    public static void data(String data, int level) {
        String suffix = "---";
        for(int i=0; i<level; i++) {
            data = suffix + data;
        }
        logger.debug(data);
    }

}
