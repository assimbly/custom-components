package org.assimbly.xmltojsonlegacy.processor;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.apache.log4j.Logger;
import org.assimbly.xmltojsonlegacy.Constants;
import org.assimbly.xmltojsonlegacy.CustomXmlJsonDataFormat;
import org.assimbly.xmltojsonlegacy.Namespace;
import org.assimbly.xmltojsonlegacy.logs.Print;
import org.assimbly.xmltojsonlegacy.processor.xmltojson.elementnode.ElementNodeTransaction;
import org.assimbly.xmltojsonlegacy.processor.xmltojson.elementnode.ElementNodeTransactionFactory;
import org.assimbly.xmltojsonlegacy.processor.xmltojson.textnode.TextNodeTransaction;
import org.assimbly.xmltojsonlegacy.processor.xmltojson.textnode.TextNodeTransactionFactory;
import org.assimbly.xmltojsonlegacy.utils.ElementUtils;
import org.assimbly.xmltojsonlegacy.utils.ElementChecker;
import org.assimbly.xmltojsonlegacy.utils.ExtractUtils;
import org.w3c.dom.*;

import java.util.HashMap;

public class XmlToJsonProcessor {

    static final Logger logger = Logger.getLogger(XmlToJsonProcessor.class);

    private static CustomXmlJsonDataFormat xmlJsonDataFormat;

    public XmlToJsonProcessor(CustomXmlJsonDataFormat xmlJsonDataFormat) {
        this.xmlJsonDataFormat = xmlJsonDataFormat;
    }

    // convert xml to json
    public static JsonNode convertXmlToJson(
            Element element, int level, String grandParentClass, String parentClass, int parentSiblings,
            boolean isGrandParentSiblingsNamesEqual, boolean isParentSiblingsNamesEqual, boolean hasGrandParentAttributes,
            boolean hasParentAttributes, boolean isFirstChild, String parentNamespace, HashMap<String, Namespace> xmlnsMap,
            boolean isParentWithEmptyTextContent
    ) {

        ObjectNode rootObjectNode = JsonNodeFactory.instance.objectNode();
        ArrayNode rootArrayNode = JsonNodeFactory.instance.arrayNode();

        int numberOfSiblings = ElementUtils.calculateNumberOfSiblings(element);
        int numberOfChildren = ElementUtils.calculateNumberOfChildren(element);
        int elementDeepestDepth = ElementUtils.calculateElementDeepestDepth(element);

        String classAttr = element.getAttribute(Constants.JSON_XML_ATTR_CLASS);
        String typeAttr = element.getAttribute(Constants.JSON_XML_ATTR_TYPE);

        boolean hasAttributes = (
                xmlJsonDataFormat.isTypeHints() ? ElementChecker.hasSimpleAttributes(element) : element.hasAttributes()
        );
        boolean isRootNode = (level == 0);
        boolean areSiblingsNamesEqual = ElementUtils.areSiblingsNamesEqual(element);
        boolean areChildrenNamesEqual = ElementUtils.areChildrenNamesEqual(element);

        HashMap<String, Namespace> xmlnsMapOnThisNode = ElementUtils.getNamespacesOnThisNode(element, xmlnsMap, level);

        // add attributes in the object node
        ExtractUtils.addAttributesInObjectNode(
                element, rootObjectNode, xmlJsonDataFormat.isTypeHints(), xmlJsonDataFormat.isSkipNamespaces()
        );
        // add namespace attribute
        ExtractUtils.addNamespaceAttributeInObjectNode(
                element, rootObjectNode, xmlnsMapOnThisNode, parentNamespace, level, xmlJsonDataFormat.isSkipNamespaces()
        );

        boolean isElementDefiningNamespaces = ElementUtils.isElementDefiningNamespaces(element);
        boolean isElementOnNamespace = ElementUtils.isElementOnNamespace(element, xmlnsMapOnThisNode);
        String namespace = ElementUtils.getElementNamePrefix(element);
        boolean isElementWithEmptyTextContent = (
                !xmlJsonDataFormat.isSkipWhitespace() && ElementUtils.isElementWithEmptyTextContent(element, elementDeepestDepth)
        );

        boolean isRootArray = ElementChecker.isRootArray(
                level, numberOfChildren, numberOfSiblings, parentSiblings, classAttr, parentClass, grandParentClass,
                elementDeepestDepth, isElementDefiningNamespaces, xmlJsonDataFormat.isTypeHints(), areChildrenNamesEqual,
                areSiblingsNamesEqual, isParentSiblingsNamesEqual, isGrandParentSiblingsNamesEqual, hasAttributes,
                hasParentAttributes, isElementOnNamespace, isElementWithEmptyTextContent, isParentWithEmptyTextContent
        );
        boolean isObject = ElementChecker.isObject(
                level, elementDeepestDepth, numberOfChildren, classAttr, numberOfSiblings, xmlJsonDataFormat.isTypeHints(),
                isParentSiblingsNamesEqual, areChildrenNamesEqual, hasParentAttributes, parentClass
        );
        boolean isOneValue = ElementChecker.isOneValue(
                parentClass, elementDeepestDepth, xmlJsonDataFormat.isTypeHints(), areSiblingsNamesEqual,
                areChildrenNamesEqual, isGrandParentSiblingsNamesEqual, isParentSiblingsNamesEqual,
                isParentWithEmptyTextContent
        );
        boolean isSingleChildren = ElementChecker.isSingleChildren(
                elementDeepestDepth, numberOfChildren, classAttr, xmlJsonDataFormat.isTypeHints()
        );

        Print.elementDetails(
                element, level, grandParentClass, parentClass, parentSiblings, isRootArray, isOneValue, isObject,
                isFirstChild, numberOfSiblings, numberOfChildren, classAttr, typeAttr, namespace,
                xmlJsonDataFormat.isRemoveNamespacePrefixes(), xmlJsonDataFormat.isSkipNamespaces(),
                isParentSiblingsNamesEqual, areSiblingsNamesEqual, areChildrenNamesEqual, hasGrandParentAttributes,
                hasParentAttributes, hasAttributes, elementDeepestDepth, isElementWithEmptyTextContent
        );

        // Check if the current element has child nodes
        if (element.hasChildNodes()) {
            NodeList nodeList = element.getChildNodes();
            int nodeListSize = nodeList.getLength();
            int nodeCount = 0;
            for (int index = 0; index < nodeListSize; index++) {
                Node childNode = nodeList.item(index);
                boolean isElementMustBeNull = ElementChecker.isElementMustBeNull(
                        xmlJsonDataFormat.isSkipWhitespace(), element, childNode, xmlnsMapOnThisNode,
                        xmlJsonDataFormat.isTypeHints(), xmlJsonDataFormat.isSpecialCaseTTFTTF(), areSiblingsNamesEqual,
                        areChildrenNamesEqual
                );

                switch (childNode.getNodeType()) {
                    case Node.ELEMENT_NODE:
                        // process element as node
                        nodeCount++;
                        JsonNode processNodeResp = processElementNode(
                                childNode, rootArrayNode, rootObjectNode, nodeCount, level, numberOfChildren,
                                numberOfSiblings, parentClass, classAttr, isRootArray, isObject, isSingleChildren,
                                isFirstChild, namespace, xmlnsMapOnThisNode, areSiblingsNamesEqual,
                                isParentSiblingsNamesEqual, hasAttributes, hasParentAttributes, isElementDefiningNamespaces,
                                areChildrenNamesEqual, isElementMustBeNull, isElementOnNamespace, isElementWithEmptyTextContent
                        );
                        if (processNodeResp != null)
                            return processNodeResp;
                        break;

                    case Node.TEXT_NODE:
                        // process element as text
                        if (isObject && isRootArray) {
                            Print.data(" 2. OBJECT && ARRAY", level);
                            if (rootObjectNode.size() > 0)
                                isRootArray = false;
                        } else {
                            JsonNode processTextResp = processTextNode(
                                    childNode, element, rootArrayNode, rootObjectNode, level, index, nodeListSize,
                                    grandParentClass, parentClass, isRootArray, isRootNode, isObject, isOneValue,
                                    namespace, xmlnsMapOnThisNode, areSiblingsNamesEqual, isParentSiblingsNamesEqual,
                                    hasAttributes, hasParentAttributes, isElementMustBeNull, isElementWithEmptyTextContent
                            );
                            if(ExtractUtils.rootObjectNodeContainsTextAttribute(rootObjectNode)) {
                                isRootArray = false;
                            }
                            if (processTextResp != null)
                                return processTextResp;
                        }
                        break;

                    default:
                        // do nothing
                }
            }
        }

        if(isRootNode && xmlJsonDataFormat.isForceTopLevelObject()) {
            return buildParentNode(element, rootObjectNode, rootArrayNode, isRootArray);
        } else {
            return isRootArray ? rootArrayNode : rootObjectNode;
        }
    }

    private static ObjectNode buildParentNode(
            Element element, ObjectNode rootObjectNode, ArrayNode rootArrayNode, boolean isRootArray
    ) {
        ObjectNode parentNode =  JsonNodeFactory.instance.objectNode();
        parentNode.set(
                ElementUtils.getElementName(element, xmlJsonDataFormat.isRemoveNamespacePrefixes()),
                isRootArray ? rootArrayNode : rootObjectNode
        );
        return parentNode;
    }

    // process an element node of type Node
    private static JsonNode processElementNode(
            Node childNode, ArrayNode rootArrayNode, ObjectNode rootObjectNode, int nodeCount, int level,
            int numberOfChildren, int numberOfSiblings, String parentClass, String classAttr, boolean isRootArray,
            boolean isObject, boolean isSingleChildren, boolean isFirstChild, String namespace,
            HashMap<String, Namespace> xmlnsMap, boolean areSiblingsNamesEqual, boolean isParentSiblingsNamesEqual,
            boolean hasAttributes, boolean hasParentAttributes, boolean isElementDefiningNamespaces,
            boolean areChildrenNamesEqual, boolean isElementMustBeNull, boolean isElementOnNamespace,
            boolean isElementWithEmptyContent
    ) {
        boolean isFirstSibling = ElementChecker.isFirstSiblingByNumCounts(nodeCount);
        Element childElement = (Element) childNode;

        ElementNodeTransaction transactionProcessor = ElementNodeTransactionFactory.getProcessorFor(
                isObject, isRootArray, isElementDefiningNamespaces
        );
        return transactionProcessor.process(
                childNode, rootArrayNode, rootObjectNode, nodeCount, level, numberOfChildren, numberOfSiblings,
                parentClass, classAttr, isRootArray, isObject, isSingleChildren, isFirstChild, isFirstSibling,
                childElement, namespace, xmlnsMap, xmlJsonDataFormat.isTrimSpaces(), xmlJsonDataFormat.isSkipNamespaces(),
                xmlJsonDataFormat.isRemoveNamespacePrefixes(), xmlJsonDataFormat.isTypeHints(), areSiblingsNamesEqual,
                isParentSiblingsNamesEqual, hasAttributes, hasParentAttributes, areChildrenNamesEqual, isElementMustBeNull,
                isElementOnNamespace, isElementWithEmptyContent
        );
    }

    // process an element node of type Text
    private static JsonNode processTextNode(
            Node childNode, Element element, ArrayNode rootArrayNode, ObjectNode rootObjectNode, int level, int index,
            int nodeListSize, String grandParentClass, String parentClass, boolean isRootArray, boolean isRootNode,
            boolean isObject, boolean isOneValue, String namespace, HashMap<String, Namespace> xmlnsMap,
            boolean areSiblingsNamesEqual, boolean isParentSiblingsNamesEqual, boolean hasAttributes,
            boolean hasParentAttributes, boolean isElementMustBeNull, boolean isElementWithEmptyContent
    ) {
        TextNodeTransaction transactionProcessor = TextNodeTransactionFactory.getProcessorFor(
                isRootNode, isObject, isOneValue
        );
        return transactionProcessor.process(childNode, element, rootArrayNode, rootObjectNode, level, index, nodeListSize,
                grandParentClass, parentClass, isRootArray, isRootNode, isObject, isOneValue, namespace, xmlnsMap,
                xmlJsonDataFormat.isForceTopLevelObject(), xmlJsonDataFormat.isTrimSpaces(),
                xmlJsonDataFormat.isSkipNamespaces(), xmlJsonDataFormat.isRemoveNamespacePrefixes(),
                xmlJsonDataFormat.isTypeHints(), areSiblingsNamesEqual, isParentSiblingsNamesEqual, hasAttributes,
                hasParentAttributes, isElementMustBeNull, isElementWithEmptyContent
        );
    }

}
