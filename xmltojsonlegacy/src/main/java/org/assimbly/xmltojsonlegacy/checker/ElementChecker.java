package org.assimbly.xmltojsonlegacy.checker;

import org.assimbly.xmltojsonlegacy.Constants;
import org.assimbly.xmltojsonlegacy.Namespace;
import org.assimbly.xmltojsonlegacy.XmlToJsonConfiguration;
import org.assimbly.xmltojsonlegacy.utils.ElementUtils;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

import java.util.Set;

public class ElementChecker {

    // check if it's a root array
    public static boolean isRootArray(XmlToJsonConfiguration config) {
        boolean isRootArray;
        if(config.isElementWithEmptyTextContent()) {
            return false;
        }
        if(config.isTypeHints()) {
            isRootArray = isRootArrayWithTypeHints(config);
        } else {
            isRootArray = isRootArrayWithoutTypeHints(config);
        }
        return isRootArray;
    }

    // check if it's a root array with type hints enabled
    private static boolean isRootArrayWithTypeHints(XmlToJsonConfiguration config) {
        boolean isRootArray = false;

        if (config.getLevel() == 0 && config.getNumberOfChildren() == 1 && !config.isElementDefiningNamespaces()) {
            isRootArray = true;
        }
        if (config.getElementDeepestDepth() > 2 && !config.isElementDefiningNamespaces() && config.isAreChildrenNamesEqual()) {
            isRootArray = true;
        }
        if (config.getElementDeepestDepth() == 2 && !config.isElementDefiningNamespaces() && config.isAreChildrenNamesEqual() &&
                (config.isAreSiblingsNamesEqual() || !config.getClassAttr().equalsIgnoreCase(Constants.JSON_XML_ATTR_TYPE_OBJECT))
        ) {
            isRootArray = true;
        }
        if (config.getElementDeepestDepth() == 1 && config.getParentClass() != null && !config.isElementOnNamespace() &&
                (config.getParentClass().equals("") || config.getParentClass().equalsIgnoreCase(Constants.JSON_XML_ATTR_TYPE_ARRAY) ||
                        config.getParentClass().equalsIgnoreCase(Constants.JSON_XML_ATTR_TYPE_OBJECT))
        ) {
            isRootArray = true;
        }
        if (config.getElementDeepestDepth() == 1 && config.getClassAttr() != null && !config.isElementOnNamespace() && (
                (config.getClassAttr().equals("") && config.getNumberOfChildren() > 1) ||
                        config.getClassAttr().equalsIgnoreCase(Constants.JSON_XML_ATTR_TYPE_OBJECT)
        )) {
            isRootArray = true;
        }
        if (config.getElementDeepestDepth() == 0 && !config.isParentWithEmptyTextContent() && !config.isHasAttributes() && !config.isHasParentAttributes() &&
                (config.getNumberOfSiblings() == 1 || config.getNumberOfSiblings() > 1 && config.isAreSiblingsNamesEqual()) &&
                (!config.getParentClass().equalsIgnoreCase(Constants.JSON_XML_ATTR_TYPE_OBJECT) ||
                        config.getParentClass().equalsIgnoreCase(Constants.JSON_XML_ATTR_TYPE_OBJECT) &&
                                config.isParentSiblingsNamesEqual()) &&
                (!config.getGrandParentClass().equalsIgnoreCase(Constants.JSON_XML_ATTR_TYPE_OBJECT) ||
                        config.getGrandParentClass().equalsIgnoreCase(Constants.JSON_XML_ATTR_TYPE_OBJECT) &&
                                config.isGrandParentSiblingsNamesEqual())
        ) {
            isRootArray = true;
        }

        return isRootArray;
    }

    // check if it's a root array without type hints enabled
    private static boolean isRootArrayWithoutTypeHints(XmlToJsonConfiguration config) {
        boolean isRootArray = false;

        if(config.getLevel() == 0 && config.getNumberOfChildren() == 1 && !config.isElementDefiningNamespaces() && !config.isHasAttributes()) {
            isRootArray = true;
        }
        if (config.getElementDeepestDepth() > 2 && !config.isElementDefiningNamespaces() && config.isAreChildrenNamesEqual() && !config.isHasAttributes()) {
            isRootArray = true;
        }
        if (config.getElementDeepestDepth() == 2 && !config.isElementDefiningNamespaces() && config.isAreChildrenNamesEqual() && !config.isHasAttributes()) {
            isRootArray = true;
        }
        if(config.getElementDeepestDepth() == 1 && !config.isElementDefiningNamespaces() && config.isAreChildrenNamesEqual() && !config.isHasAttributes() &&
                !config.isElementOnNamespace()
        ) {
            isRootArray = true;
        }
        if(config.getElementDeepestDepth() == 1 && config.getClassAttr() !=null &&
                config.getClassAttr().equalsIgnoreCase(Constants.JSON_XML_ATTR_TYPE_OBJECT)
        ) {
            if(config.getParentSiblings() > 1) {
                isRootArray = true;
            } else {
                isRootArray = false;
            }
        }
        if (config.getElementDeepestDepth() == 0 && !config.isParentWithEmptyTextContent() && !config.isHasAttributes() && (
                config.getNumberOfSiblings() == 1 || config.getNumberOfSiblings() > 1 && config.isAreSiblingsNamesEqual()
        )) {
            isRootArray = true;
        }

        return isRootArray;
    }

    // check if it's an object
    public static boolean isObject(XmlToJsonConfiguration config) {
        if(config.getElementDeepestDepth() == 1 && config.getClassAttr()!=null && (
                config.getNumberOfChildren() > 1  && (config.getLevel() == 0 || config.getLevel() > 0 && !config.isAreChildrenNamesEqual()) ||
                        config.getNumberOfChildren() == 1 && config.getClassAttr().equalsIgnoreCase(Constants.JSON_XML_ATTR_TYPE_OBJECT) &&
                                (!config.isTypeHints() ||
                                        config.getNumberOfSiblings() > 1 && config.isTypeHints() &&
                                                !config.getParentClass().equalsIgnoreCase(Constants.JSON_XML_ATTR_TYPE_ARRAY) ||
                                        config.isTypeHints() &&
                                                config.getClassAttr().equalsIgnoreCase(Constants.JSON_XML_ATTR_TYPE_OBJECT) &&
                                                (!config.isHasParentAttributes() && !config.isParentSiblingsNamesEqual()))
        )) {
                return true;
        }

        return false;
    }

    // check if it's one value
    public static boolean isOneValue(XmlToJsonConfiguration config) {
        if(config.getElementDeepestDepth() == 0 && !config.isParentWithEmptyTextContent() && config.isAreSiblingsNamesEqual() && config.isAreChildrenNamesEqual() && (
                !config.isTypeHints() || (
                        config.getParentClass() == null ||
                                !config.getParentClass().equalsIgnoreCase(Constants.JSON_XML_ATTR_TYPE_OBJECT) ||
                                (config.isGrandParentSiblingsNamesEqual() && config.isParentSiblingsNamesEqual())
                )
        )) {
            return true;
        }

        return false;
    }

    // check if element should be null
    public static boolean isElementMustBeNull(XmlToJsonConfiguration config, Node childNode) {
        if(!config.isSkipWhitespace()) {
            return false;
        }

        if(config.isSpecialCaseTTFTTF()) {
            return isSpecialCaseTTFTTFMustBeNull(config, childNode);
        }

        if(config.isTypeHints() && childNode.hasAttributes()) {
            NamedNodeMap attributes = childNode.getAttributes();
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

        if(childNode.getNodeType() != Node.ELEMENT_NODE) {
            if(childNode.hasAttributes()) {
                return true;
            }
            return false;
        }

        Element nodeElement = (Element)childNode;
        int elementDeepestDepth = ElementUtils.calculateElementDeepestDepth(nodeElement);
        String namespaceLabel = ElementUtils.getElementNamespaceLabel(nodeElement);
        Namespace namespace = config.getXmlnsMapOnThisNode().get(namespaceLabel);
        boolean isParentClassObject = hasAttribute(
                config.getElement(), Constants.JSON_XML_ATTR_CLASS, Constants.JSON_XML_ATTR_TYPE_OBJECT
        );

        if(elementDeepestDepth == 0 && (namespace!=null || nodeElement.hasAttributes())) {
            if(config.isTypeHints() && isParentClassObject && !config.isAreChildrenNamesEqual()) {
                return false;
            }
            return true;
        }

        return false;
    }

    // check if element should be null - special case TTFTTF
    private static boolean isSpecialCaseTTFTTFMustBeNull(XmlToJsonConfiguration config, Node childNode) {
        if(childNode.getNodeType() != Node.ELEMENT_NODE) {
            return false;
        }

        Element nodeElement = (Element) childNode;
        int elementDeepestDepth = ElementUtils.calculateElementDeepestDepth(nodeElement);

        if(elementDeepestDepth != 0) {
            return false;
        }

        boolean isElementOnNamespace = ElementUtils.isElementOnNamespace(nodeElement, config.getXmlnsMapOnThisNode());

        if(!childNode.hasAttributes()) {
            if(isElementOnNamespace) {
                return true;
            }
            return false;
        }

        if(ElementUtils.areSiblingsNamesEqual(nodeElement) && config.isAreSiblingsNamesEqual()) {
            return true;
        }

        NamedNodeMap attributes = childNode.getAttributes();
        for (int i = 0; i < attributes.getLength(); i++) {
            Node attribute = attributes.item(i);
            String attrName = attribute.getNodeName();
            if(!attrName.equalsIgnoreCase(Constants.JSON_XML_ATTR_TYPE)) {
                return true;
            }
        }

        return false;
    }

    // check if it's a single children
    public static boolean isSingleChildren(XmlToJsonConfiguration config) {
        if(config.isTypeHints()) {
           return false;
        }

        if(config.getElementDeepestDepth() == 1 && config.getNumberOfChildren() == 1
                && (config.getClassAttr()==null || !config.getClassAttr().equalsIgnoreCase(Constants.JSON_XML_ATTR_TYPE_OBJECT))
        ) {
            return true;
        }

        return false;
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

    // check if element have a specific attribute name and value
    public static boolean hasAttribute(Element element, String attrName, String attrValue) {
        if(element == null || !element.hasAttributes()){
            return false;
        }

        NamedNodeMap attrMap = element.getAttributes();
        for (int j = 0; j < attrMap.getLength(); j++) {
            Node node = attrMap.item(j);
            String attributeName = node.getNodeName();
            String attributeValue = node.getNodeValue();
            if(attributeName.equals(attrName) && attributeValue.equals(attrValue)){
                return true;
            }
        }

        return false;
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
