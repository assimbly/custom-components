package org.assimbly.xmltojsonlegacy.processor;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.apache.log4j.Logger;
import org.assimbly.xmltojsonlegacy.Constants;
import org.assimbly.xmltojsonlegacy.CustomXmlJsonDataFormat;
import org.assimbly.xmltojsonlegacy.logs.Print;
import org.assimbly.xmltojsonlegacy.processor.xmltojson.elementnode.ElementNodeTransaction;
import org.assimbly.xmltojsonlegacy.processor.xmltojson.elementnode.ElementNodeTransactionFactory;
import org.assimbly.xmltojsonlegacy.processor.xmltojson.textnode.TextNodeTransaction;
import org.assimbly.xmltojsonlegacy.processor.xmltojson.textnode.TextNodeTransactionFactory;
import org.assimbly.xmltojsonlegacy.utils.ElementUtils;
import org.assimbly.xmltojsonlegacy.utils.ElementChecker;
import org.assimbly.xmltojsonlegacy.utils.ExtractUtils;
import org.w3c.dom.*;

public class XmlToJsonProcessor {

    static final Logger logger = Logger.getLogger(XmlToJsonProcessor.class);

    private static CustomXmlJsonDataFormat xmlJsonDataFormat;

    public XmlToJsonProcessor(CustomXmlJsonDataFormat xmlJsonDataFormat) {
        this.xmlJsonDataFormat = xmlJsonDataFormat;
    }

    // convert xml to json
    public static JsonNode convertXmlToJson(
            Element element, int level, String parentClass, int parentSiblings, boolean isFirstChild, String namespace
    ) {
        ObjectNode rootObjectNode = JsonNodeFactory.instance.objectNode();
        ArrayNode rootArrayNode = JsonNodeFactory.instance.arrayNode();

        int numberOfSiblings = ElementUtils.calculateNumberOfSiblings(element);
        int numberOfChildren = ElementUtils.calculateNumberOfChildren(element);
        int elementDeepestDepth = ElementUtils.calculateElementDeepestDepth(element);

        String classAttr = element.getAttribute(Constants.JSON_XML_ATTR_CLASS);
        String typeAttr = element.getAttribute(Constants.JSON_XML_ATTR_TYPE);

        boolean hasAttributes = element.hasAttributes();
        boolean isRootNode = (level == 0);
        namespace = (isRootNode ? ElementUtils.getNamespace(element) : namespace);
        boolean isRootArray = ElementChecker.isRootArray(
                level, numberOfChildren, numberOfSiblings, parentSiblings, classAttr, parentClass, hasAttributes,
                elementDeepestDepth, namespace, xmlJsonDataFormat.isTypeHints()
        );
        boolean isObject = ElementChecker.isObject(elementDeepestDepth, numberOfChildren, classAttr);
        boolean isOneValue = ElementChecker.isOneValue(level, numberOfSiblings, parentClass, elementDeepestDepth);
        boolean isSingleChildren = ElementChecker.isSingleChildren(
                elementDeepestDepth, numberOfChildren, classAttr, xmlJsonDataFormat.isTypeHints()
        );
        boolean isAttributeObject = ElementChecker.isAttributeObject(
                level, parentClass, elementDeepestDepth, xmlJsonDataFormat.isTypeHints()
        );

        Print.elementDetails(
                element, level, parentClass, parentSiblings, isRootArray, isOneValue, isObject, isFirstChild,
                numberOfSiblings, numberOfChildren, classAttr, typeAttr, namespace,
                xmlJsonDataFormat.isRemoveNamespacePrefixes(), xmlJsonDataFormat.isSkipNamespaces()
        );

        // add attributes in the object node
        addAttributesInObjectNode(element, rootObjectNode, isAttributeObject);

        // Check if the current element has child nodes
        if (element.hasChildNodes()) {
            NodeList nodeList = element.getChildNodes();
            int nodeListSize = nodeList.getLength();
            int nodeCount = 0;
            for (int index = 0; index < nodeListSize; index++) {
                Node childNode = nodeList.item(index);

                switch (childNode.getNodeType()) {
                    case Node.ELEMENT_NODE:
                        // process element as node
                        nodeCount++;
                        JsonNode processNodeResp = processElementNode(
                                childNode, rootArrayNode, rootObjectNode, nodeCount, level, numberOfChildren, numberOfSiblings,
                                classAttr, isRootArray, isObject, isSingleChildren, isFirstChild, namespace
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
                                    isRootArray, isRootNode, isObject, isOneValue, namespace
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

        return isRootArray ? rootArrayNode : rootObjectNode;
    }

    // process an element node of type Node
    private static JsonNode processElementNode(
            Node childNode, ArrayNode rootArrayNode, ObjectNode rootObjectNode, int nodeCount, int level,
            int numberOfChildren, int numberOfSiblings, String classAttr, boolean isRootArray, boolean isObject,
            boolean isSingleChildren, boolean isFirstChild, String namespace
    ) {
        boolean isFirstSibling = ElementChecker.isFirstSiblingByNumCounts(nodeCount);
        Element childElement = (Element) childNode;

        ElementNodeTransaction transactionProcessor = ElementNodeTransactionFactory.getProcessorFor(isObject, isRootArray, namespace);
        return transactionProcessor.process(
                childNode, rootArrayNode, rootObjectNode, nodeCount, level, numberOfChildren, numberOfSiblings,
                classAttr, isRootArray, isObject, isSingleChildren, isFirstChild, isFirstSibling, childElement,
                namespace, xmlJsonDataFormat.isTrimSpaces(), xmlJsonDataFormat.isSkipNamespaces(),
                xmlJsonDataFormat.isRemoveNamespacePrefixes(), xmlJsonDataFormat.isTypeHints()
        );
    }

    // process an element node of type Text
    private static JsonNode processTextNode(
            Node childNode, Element element, ArrayNode rootArrayNode, ObjectNode rootObjectNode, int level, int index,
            int nodeListSize, boolean isRootArray, boolean isRootNode, boolean isObject, boolean isOneValue, String namespace
    ) {
        TextNodeTransaction transactionProcessor = TextNodeTransactionFactory.getProcessorFor(isRootNode, isObject, isOneValue);
        return transactionProcessor.process(childNode, element, rootArrayNode, rootObjectNode, level, index, nodeListSize,
                isRootArray, isRootNode, isObject, isOneValue, namespace, xmlJsonDataFormat.isForceTopLevelObject(),
                xmlJsonDataFormat.isTrimSpaces(), xmlJsonDataFormat.isSkipNamespaces(),
                xmlJsonDataFormat.isRemoveNamespacePrefixes(), xmlJsonDataFormat.isTypeHints()
        );
    }

    // add attributes in the object node
    private static void addAttributesInObjectNode(Element element, ObjectNode rootObjectNode, boolean isAttributeObject) {
        if(!isAttributeObject && element.hasAttributes()){
            NamedNodeMap attrMap = element.getAttributes();
            for (int j = 0; j < attrMap.getLength(); j++) {
                Node node = attrMap.item(j);
                String attr = node.getNodeName();
                if((!xmlJsonDataFormat.isTypeHints() && !ElementUtils.isAnXmlnsAttribute(attr)) ||
                        xmlJsonDataFormat.isTypeHints() && !ElementUtils.isAnSpecialAttribute(attr) &&
                                !ElementUtils.isAnXmlnsAttribute(attr)
                ) {
                    rootObjectNode.put(Constants.JSON_XML_ATTR_PREFIX+node.getNodeName(), node.getNodeValue());
                }
            }
        }
    }

}
