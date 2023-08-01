package org.assimbly.xmltojsonlegacy.processor;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.apache.log4j.Logger;
import org.assimbly.xmltojsonlegacy.CustomXmlJsonDataFormat;
import org.assimbly.xmltojsonlegacy.logs.Print;
import org.assimbly.xmltojsonlegacy.utils.ElementUtils;
import org.assimbly.xmltojsonlegacy.utils.ElementChecker;
import org.w3c.dom.*;

public class XmlToJsonProcessor {

    static final Logger logger = Logger.getLogger(XmlToJsonProcessor.class);

    private final CustomXmlJsonDataFormat xmlJsonDataFormat;

    private static final String JSON_XML_ATTR_PREFIX = "@";
    private static final String JSON_XML_TEXT_FIELD = "#text";

    private static final String JSON_XML_ATTR_CLASS = "class";

    private static final String JSON_XML_ATTR_TYPE = "type";
    private static final String JSON_XML_ATTR_TYPE_NUMBER = "number";
    private static final String JSON_XML_ATTR_TYPE_BOOLEAN = "boolean";

    public XmlToJsonProcessor(CustomXmlJsonDataFormat xmlJsonDataFormat) {
        this.xmlJsonDataFormat = xmlJsonDataFormat;
    }

    // convert xml to json
    public JsonNode convertXmlToJson(
            Element element, int level, String parentClass, int parentSiblings, boolean isFirstChild, String namespace
    ) {
        ObjectNode rootObjectNode = JsonNodeFactory.instance.objectNode();
        ArrayNode rootArrayNode = JsonNodeFactory.instance.arrayNode();

        int numberOfSiblings = ElementUtils.calculateNumberOfSiblings(element);
        int numberOfChildren = ElementUtils.calculateNumberOfChildren(element);
        int elementDeepestDepth = ElementUtils.calculateElementDeepestDepth(element);

        String classAttr = element.getAttribute(JSON_XML_ATTR_CLASS);
        String typeAttr = element.getAttribute(JSON_XML_ATTR_TYPE);

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

                if (childNode.getNodeType() == Node.ELEMENT_NODE) {
                    // process element as node
                    nodeCount++;
                    JsonNode processNodeResp = processElementNode(
                            childNode, rootArrayNode, rootObjectNode, nodeCount, level, numberOfChildren, numberOfSiblings,
                            classAttr, isRootArray, isObject, isSingleChildren, isFirstChild, namespace
                    );
                    if(processNodeResp!=null)
                        return processNodeResp;

                } else if(childNode.getNodeType() == Node.TEXT_NODE){
                    // process element as text
                    if(isObject && isRootArray) {
                        Print.data(" 2. OBJECT && ARRAY", level);
                        if(rootObjectNode.size()>0)
                            isRootArray = false;
                    } else {
                        JsonNode processTextResp = processTextNode(
                                childNode, element, rootArrayNode, rootObjectNode, level, index, nodeListSize,
                                isRootArray, isRootNode, isObject, isOneValue, namespace
                        );
                        if(processTextResp!=null)
                            return processTextResp;
                    }
                }
            }
        }

        return isRootArray ? rootArrayNode : rootObjectNode;
    }

    // process an element node of type Node
    private JsonNode processElementNode(
            Node childNode, ArrayNode rootArrayNode, ObjectNode rootObjectNode, int nodeCount, int level,
            int numberOfChildren, int numberOfSiblings, String classAttr, boolean isRootArray, boolean isObject,
            boolean isSingleChildren, boolean isFirstChild, String namespace
    ) {

        boolean isFirstSibling = ElementChecker.isFirstSiblingByNumCounts(nodeCount);
        Element childElement = (Element) childNode;

        if(isObject) {
            Print.data(" 1. IS OBJECT", level);
            // extract child as an object
            extractChildAsObject(level, rootObjectNode, numberOfSiblings, classAttr, childElement, isFirstSibling, namespace);
        } else {
            if(isRootArray) {
                Print.data(" 1. IS ROOT ARRAY", level);
                if(isSingleChildren && isFirstChild) {
                    // recursive call with child element
                    return convertXmlToJson(childElement, level +1, classAttr, numberOfSiblings, isFirstSibling, namespace);
                } else {
                    // extract child as an array
                    extractChildAsArray(level, rootArrayNode, numberOfSiblings, classAttr, childElement, isFirstSibling, namespace);
                }
            } else {
                Print.data(" 1. IS OTHER", level);
                if(namespace!=null) {
                    extractChildAsOtherInArrayNode(
                            level, rootArrayNode, numberOfSiblings, classAttr, (Element) childNode, childElement,
                            isFirstSibling, namespace
                    );
                    rootObjectNode.set(
                            ElementUtils.getElementName((Element) childNode, namespace,
                                    xmlJsonDataFormat.isRemoveNamespacePrefixes(), xmlJsonDataFormat.isSkipNamespaces()),
                            rootArrayNode
                    );
                } else {
                    if(!xmlJsonDataFormat.isTypeHints()) {
                        // extract child as other type and add into the array node
                        if((level == 0 && numberOfChildren > 1) ||
                                (numberOfChildren == 1 && ElementUtils.calculateNumberOfChildren(childElement) > 1)
                        ) {
                            extractChildAsOtherInObjectNode(
                                    level, rootObjectNode, numberOfSiblings, classAttr, (Element) childNode, childElement,
                                    isFirstSibling, namespace
                            );
                        } else {
                            extractChildAsOtherInArrayNode(
                                    level, rootArrayNode, numberOfSiblings, classAttr, (Element) childNode, childElement,
                                    isFirstSibling, namespace
                            );
                            rootObjectNode.set(
                                    ElementUtils.getElementName((Element) childNode, namespace,
                                            xmlJsonDataFormat.isRemoveNamespacePrefixes(), xmlJsonDataFormat.isSkipNamespaces()),
                                    rootArrayNode
                            );
                        }
                    } else {
                        // extract child as other type and add into the object node
                        extractChildAsOtherInObjectNode(
                                level, rootObjectNode, numberOfSiblings, classAttr, (Element) childNode, childElement,
                                isFirstSibling, namespace
                        );
                    }
                }
            }
        }

        return null;
    }

    // process an element node of type Text
    private JsonNode processTextNode(
            Node childNode, Element element, ArrayNode rootArrayNode, ObjectNode rootObjectNode, int level, int index,
            int nodeListSize, boolean isRootArray, boolean isRootNode, boolean isObject, boolean isOneValue, String namespace
    ) {
        if(isRootNode) {
            //process text node identified as a root node
            Print.data(" 2. ROOT", level);
            if(index+1 >= nodeListSize) {
                if(namespace!=null && !xmlJsonDataFormat.isSkipNamespaces()) {
                    Node namespaceNode = ElementUtils.getNamespaceNode(element);
                    rootObjectNode.put(JSON_XML_ATTR_PREFIX+namespaceNode.getNodeName(), namespaceNode.getNodeValue());
                }
                if(xmlJsonDataFormat.isForceTopLevelObject()) {
                    ObjectNode parentNode =  JsonNodeFactory.instance.objectNode();
                    parentNode.set(
                            ElementUtils.getElementName(element, namespace,
                                    xmlJsonDataFormat.isRemoveNamespacePrefixes(), xmlJsonDataFormat.isSkipNamespaces()),
                            isRootArray ? rootArrayNode : rootObjectNode
                    );
                    return parentNode;
                }
            }
        } else if(isObject) {
            Print.data(" 2. OBJECT", level);
        } else if(isOneValue) {
            //process text node identified as one value
            Print.data(" 2. ONE VALUE", level);
            if(xmlJsonDataFormat.isTypeHints()) {
                rootArrayNode.add(ElementUtils.getNodeValue(childNode, xmlJsonDataFormat.isTrimSpaces()));
            } else {
                if(element.hasAttributes()) {
                    rootObjectNode.put(JSON_XML_TEXT_FIELD, ElementUtils.getNodeValue(childNode, xmlJsonDataFormat.isTrimSpaces()));
                } else {
                    rootArrayNode.add(ElementUtils.getNodeValue(childNode, xmlJsonDataFormat.isTrimSpaces()));
                }
            }
        } else {
            //process text node identified as other
            Print.data(" 2. OTHER", level);
            if(xmlJsonDataFormat.isTypeHints()){
                rootObjectNode.put(
                        ElementUtils.getElementName(element, namespace, xmlJsonDataFormat.isRemoveNamespacePrefixes(),
                                xmlJsonDataFormat.isSkipNamespaces()),
                        ElementUtils.getNodeValue(childNode, xmlJsonDataFormat.isTrimSpaces()));
            } else {
                if(ElementChecker.isLastElement(element)) {
                    rootObjectNode.put(
                            ElementUtils.getElementName(element, namespace, xmlJsonDataFormat.isRemoveNamespacePrefixes(),
                                    xmlJsonDataFormat.isSkipNamespaces()),
                            ElementUtils.getNodeValue(childNode, xmlJsonDataFormat.isTrimSpaces()));
                }
            }
        }

        return null;
    }

    // add attributes in the object node
    private void addAttributesInObjectNode(Element element, ObjectNode rootObjectNode, boolean isAttributeObject) {
        if(!xmlJsonDataFormat.isTypeHints() && !isAttributeObject && element.hasAttributes()){
            NamedNodeMap attrMap = element.getAttributes();
            for (int j = 0; j < attrMap.getLength(); j++) {
                Node node = attrMap.item(j);
                rootObjectNode.put(JSON_XML_ATTR_PREFIX+node.getNodeName(), node.getNodeValue());
            }
        }
    }

    // extract child as other type and add into the array node
    private void extractChildAsOtherInArrayNode(
            int level, ArrayNode rootArrayNode, int numSiblings, String classAttr, Element childNode,
            Element childElement, boolean isFirstSibling, String namespace
    ) {
        rootArrayNode.add(convertXmlToJson(childElement, level +1, classAttr, numSiblings, isFirstSibling, namespace));
    }

    // extract child as other type and add into the object node
    private void extractChildAsOtherInObjectNode(
            int level, ObjectNode rootObjectNode, int numSiblings, String classAttr, Element childNode,
            Element childElement, boolean isFirstSibling, String namespace
    ) {
        rootObjectNode.set(
                ElementUtils.getElementName(childNode, namespace, xmlJsonDataFormat.isRemoveNamespacePrefixes(),
                        xmlJsonDataFormat.isSkipNamespaces()),
                convertXmlToJson(childElement, level +1, classAttr, numSiblings, isFirstSibling, namespace)
        );
    }

    // extract child as array type
    private void extractChildAsArray(
            int level, ArrayNode rootArrayNode, int numSiblings, String classAttr, Element childElement,
            boolean isFirstSibling, String namespace
    ) {
        JsonNode subNode = convertXmlToJson(childElement, level +1, classAttr, numSiblings, isFirstSibling, namespace);

        if(subNode.isArray() && ElementChecker.isLastElement(childElement)) {
            for (JsonNode subElement : subNode) {
                rootArrayNode.add(subElement.asText());
            }
        } else {
            rootArrayNode.add(subNode);
        }
    }

    // extract child as object type
    private void extractChildAsObject(
            int level, ObjectNode rootObjectNode, int numSiblings, String classAttr, Element childElement,
            boolean isFirstSibling, String namespace
    ) {
        if(xmlJsonDataFormat.isTypeHints()) {
            JsonNode subNode = convertXmlToJson(childElement, level +1, classAttr, numSiblings, isFirstSibling, namespace);
            for (JsonNode subElement : subNode) {
                subNode.fields().forEachRemaining(entry -> {
                    String label = entry.getKey();
                    String childTypeAttr = childElement.getAttribute(JSON_XML_ATTR_TYPE);
                    setValueUsingAttributeType(rootObjectNode, subElement, label, childTypeAttr);
                });
            }
        } else {
            if(classAttr!=null && !classAttr.equals("")) {
                rootObjectNode.set(
                        ElementUtils.getElementName(childElement, namespace, xmlJsonDataFormat.isRemoveNamespacePrefixes(),
                                xmlJsonDataFormat.isSkipNamespaces()),
                        addNodeWithAttributeInfo(childElement, ElementUtils.getNodeValue(childElement, xmlJsonDataFormat.isTrimSpaces()))
                );
            } else {
                rootObjectNode.put(ElementUtils.getElementName(childElement, namespace, xmlJsonDataFormat.isRemoveNamespacePrefixes(),
                        xmlJsonDataFormat.isSkipNamespaces()),
                        ElementUtils.getNodeValue(childElement, xmlJsonDataFormat.isTrimSpaces()));
            }
        }
    }

    // set value as specified in the attribute type
    private void setValueUsingAttributeType(
            ObjectNode rootObjectNode, JsonNode subElement, String label, String childTypeAttr
    ) {
        switch (childTypeAttr) {
            case JSON_XML_ATTR_TYPE_NUMBER:
                rootObjectNode.put(label, subElement.asInt());
                break;
            case JSON_XML_ATTR_TYPE_BOOLEAN:
                rootObjectNode.put(label, subElement.asBoolean());
                break;
            default:
                if(xmlJsonDataFormat.isTrimSpaces()){
                    rootObjectNode.put(label, subElement.asText().trim());
                } else {
                    rootObjectNode.put(label, subElement.asText());
                }
        }
    }

    // add node with attribute information
    private JsonNode addNodeWithAttributeInfo(Element element, String value) {
        ObjectNode attrInfoObjectNode =  JsonNodeFactory.instance.objectNode();

        if(element.hasAttributes()){
            NamedNodeMap attrMap = element.getAttributes();
            for (int j = 0; j < attrMap.getLength(); j++) {
                Node node = attrMap.item(j);
                attrInfoObjectNode.put(JSON_XML_ATTR_PREFIX+node.getNodeName(), node.getNodeValue());
            }
        }
        attrInfoObjectNode.put(JSON_XML_TEXT_FIELD, value);

        return attrInfoObjectNode;
    }

}
