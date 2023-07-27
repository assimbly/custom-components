package org.assimbly.xmltojsonlegacy.processor;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.apache.log4j.Logger;
import org.assimbly.xmltojsonlegacy.CustomXmlJsonDataFormat;
import org.w3c.dom.*;

public class XmlToJsonProcessor {

    static final Logger logger = Logger.getLogger(XmlToJsonProcessor.class);

    private final CustomXmlJsonDataFormat xmlJsonDataFormat;

    private static final String JSON_XML_ATTR_PREFIX = "@";
    private static final String JSON_XML_TEXT_FIELD = "#text";

    private static final String JSON_XML_ATTR_CLASS = "class";
    private static final String JSON_XML_ATTR_CLASS_ARRAY = "array";
    private static final String JSON_XML_ATTR_CLASS_OBJECT = "object";

    private static final String JSON_XML_ATTR_TYPE = "type";
    private static final String JSON_XML_ATTR_TYPE_NUMBER = "number";
    private static final String JSON_XML_ATTR_TYPE_BOOLEAN = "boolean";

    public XmlToJsonProcessor(CustomXmlJsonDataFormat xmlJsonDataFormat) {
        this.xmlJsonDataFormat = xmlJsonDataFormat;
    }

    // convert xml to json
    public JsonNode convertXmlToJson(
            Element element, int level, String parentClass, int parentSiblings, boolean isFirstChild
    ) {
        ObjectNode rootObjectNode = JsonNodeFactory.instance.objectNode();
        ArrayNode rootArrayNode = JsonNodeFactory.instance.arrayNode();

        int numberOfSiblings = calculateNumberOfSiblings(element);
        int numberOfChildren = calculateNumberOfChildren(element);

        String classAttr = element.getAttribute(JSON_XML_ATTR_CLASS);
        String typeAttr = element.getAttribute(JSON_XML_ATTR_TYPE);

        boolean hasAttributes = element.hasAttributes();
        boolean isRootNode = (level == 0);
        boolean isRootArray = isRootArray(level, numberOfChildren, numberOfSiblings, parentSiblings, classAttr, parentClass, hasAttributes);
        boolean isObject = isObject(level, numberOfChildren, classAttr);
        boolean isOneValue = isOneValue(level, numberOfSiblings, parentClass);
        boolean isSingleChildren = isSingleChildren(level, numberOfChildren, classAttr);
        boolean isAttributeObject = isAttributeObject(level, parentClass);

        printElementDetails(
                element, level, parentClass, parentSiblings, isRootArray, isOneValue, isObject, isFirstChild,
                numberOfSiblings, numberOfChildren, classAttr, typeAttr
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
                            childNode, rootArrayNode, rootObjectNode, nodeCount, level, numberOfChildren,
                            numberOfSiblings, classAttr, isRootArray, isObject, isSingleChildren, isFirstChild
                    );
                    if(processNodeResp!=null)
                        return processNodeResp;

                } else if(childNode.getNodeType() == Node.TEXT_NODE){
                    // process element as text
                    if(isObject && isRootArray) {
                        printData(" 2. OBJECT && ARRAY", level);
                        if(rootObjectNode.size()>0)
                            isRootArray = false;
                    } else {
                        JsonNode processTextResp = processTextNode(
                                childNode, element, rootArrayNode, rootObjectNode, level, index, nodeListSize,
                                isRootArray, isRootNode, isObject, isOneValue
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
            boolean isSingleChildren, boolean isFirstChild
    ) {

        boolean isFirstSibling = isFirstSiblingByNumCounts(nodeCount);
        Element childElement = (Element) childNode;

        if(isObject) {
            printData(" 1. IS OBJECT", level);
            // extract child as an object
            extractChildAsObject(level, rootObjectNode, numberOfSiblings, classAttr, childElement, isFirstSibling);
        } else {
            if(isRootArray) {
                printData(" 1. IS ROOT ARRAY", level);
                if(isSingleChildren && isFirstChild) {
                    // recursive call with child element
                    return convertXmlToJson(childElement, level +1, classAttr, numberOfSiblings, isFirstSibling);
                } else {
                    // extract child as an array
                    extractChildAsArray(level, rootArrayNode, numberOfSiblings, classAttr, childElement, isFirstSibling);
                }
            } else {
                printData(" 1. IS OTHER", level);
                if(!xmlJsonDataFormat.isTypeHints()) {
                    // extract child as other type and add into the array node
                    if(level == 0 && numberOfChildren > 1) {
                        extractChildAsOtherInObjectNode(
                                level, rootObjectNode, numberOfSiblings, classAttr, (Element) childNode, childElement,
                                isFirstSibling
                        );
                    } else {
                        if(numberOfChildren == 1) {
                            extractChildAsOtherInObjectNode(
                                    level, rootObjectNode, numberOfSiblings, classAttr, (Element) childNode, childElement,
                                    isFirstSibling
                            );
                        } else {
                            extractChildAsOtherInArrayNode(
                                    level, rootArrayNode, numberOfSiblings, classAttr, (Element) childNode, childElement,
                                    isFirstSibling
                            );
                            rootObjectNode.set(((Element) childNode).getTagName(), rootArrayNode);
                        }
                    }
                } else {
                    // extract child as other type and add into the object node
                    extractChildAsOtherInObjectNode(
                            level, rootObjectNode, numberOfSiblings, classAttr, (Element) childNode, childElement,
                            isFirstSibling
                    );
                }
            }
        }

        return null;
    }

    // process an element node of type Text
    private JsonNode processTextNode(
            Node childNode, Element element, ArrayNode rootArrayNode, ObjectNode rootObjectNode, int level, int index,
            int nodeListSize, boolean isRootArray, boolean isRootNode, boolean isObject, boolean isOneValue
    ) {
        Text textNode = (Text) childNode;

        if(isRootNode) {
            //process text node identified as a root node
            printData(" 2. ROOT", level);
            if(index+1 >= nodeListSize && xmlJsonDataFormat.isForceTopLevelObject()) {
                ObjectNode parentNode =  JsonNodeFactory.instance.objectNode();
                parentNode.set(element.getTagName(), isRootArray ? rootArrayNode : rootObjectNode);
                return parentNode;
            }
        } else if(isObject) {
            printData(" 2. OBJECT", level);
        } else if(isOneValue) {
            //process text node identified as one value
            printData(" 2. ONE VALUE", level);
            if(xmlJsonDataFormat.isTypeHints()) {
                rootArrayNode.add(textNode.getTextContent());
            } else {
                if(element.hasAttributes()) {
                    rootObjectNode.put(JSON_XML_TEXT_FIELD, childNode.getTextContent());
                } else {
                    rootArrayNode.add(textNode.getTextContent());
                }
            }
        } else {
            //process text node identified as other
            printData(" 2. OTHER", level);
            if(xmlJsonDataFormat.isTypeHints()){
                rootObjectNode.put(element.getTagName(), textNode.getTextContent());
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

    // check if it's a root array
    private boolean isRootArray(
            int level, int numberOfChildren, int numberOfSiblings, int parentSiblings, String classAttr,
            String parentClass, boolean hasAttributes
    ) {
        boolean isRootArray = false;
        if(xmlJsonDataFormat.isTypeHints()) {
            if (level == 0 && numberOfChildren == 1) {
                isRootArray = true;
            }
            if (level == 1) {
                isRootArray = true;
            }
            if (level == 2 && parentClass != null &&
                    (parentClass.equals("") || parentClass.equalsIgnoreCase(JSON_XML_ATTR_CLASS_ARRAY))
            ) {
                isRootArray = true;
            }
            if (level == 2 && classAttr != null &&
                    ((classAttr.equals("") && numberOfChildren > 1) || classAttr.equalsIgnoreCase(JSON_XML_ATTR_CLASS_OBJECT))
            ) {
                if (parentSiblings > 1) {
                    isRootArray = true;
                } else {
                    isRootArray = false;
                }
            }
            if (level == 3 && numberOfSiblings == 1 &&
                    (parentClass == null || !parentClass.equalsIgnoreCase(JSON_XML_ATTR_CLASS_OBJECT))
            ) {
                isRootArray = true;
            }
        } else {
            if(level == 0 && numberOfChildren == 1) {
                isRootArray = true;
            }
            if (level == 1 && classAttr!=null && classAttr.equals("")) {
                isRootArray = true;
            }
            if(level == 2 && parentClass!=null &&
                    (parentClass.equals("") || parentClass.equalsIgnoreCase(JSON_XML_ATTR_CLASS_ARRAY))
            ) {
                isRootArray = true;
            }
            if(level == 2 && classAttr!=null && classAttr.equalsIgnoreCase(JSON_XML_ATTR_CLASS_OBJECT)) {
                if(parentSiblings > 1) {
                    isRootArray = true;
                } else {
                    isRootArray = false;
                }
            }
            if (level == 3 && numberOfSiblings == 1 && !hasAttributes) {
                isRootArray = true;
            }
        }
        return isRootArray;
    }

    // check if it's an object
    private boolean isObject(int level, int numberOfChildren, String classAttr) {
        boolean isObject = false;
        if(level == 2 && classAttr!=null &&
                ((classAttr.equals("") && numberOfChildren > 1) || classAttr.equalsIgnoreCase(JSON_XML_ATTR_CLASS_OBJECT))
        ) {
            isObject = true;
        }
        return isObject;
    }

    // check if it's one value
    private boolean isOneValue(int level, int numberOfSiblings, String parentClass) {
        boolean isOneValue = false;
        if(level == 3 && numberOfSiblings == 1 &&
                (parentClass==null || !parentClass.equalsIgnoreCase(JSON_XML_ATTR_CLASS_OBJECT))
        ) {
            isOneValue = true;
        }
        return isOneValue;
    }

    // check if it's a single children
    private boolean isSingleChildren(int level, int numberOfChildren, String classAttr) {
        boolean isSingleChildren = false;
        if(!xmlJsonDataFormat.isTypeHints()) {
            if(level == 2 && numberOfChildren == 1
                    && (classAttr==null || !classAttr.equalsIgnoreCase(JSON_XML_ATTR_CLASS_OBJECT))
            ) {
                isSingleChildren = true;
            }
        }
        return isSingleChildren;
    }

    // check if it's an attribute object
    private boolean isAttributeObject(int level, String parentClass) {
        boolean isAttributeObject = false;
        if(!xmlJsonDataFormat.isTypeHints()) {
            if(level == 3 && parentClass!=null && parentClass.equalsIgnoreCase(JSON_XML_ATTR_CLASS_OBJECT)) {
                isAttributeObject = true;
            }
        }
        return isAttributeObject;
    }

    // check if it's the first sibling regarding the numCounts
    private boolean isFirstSiblingByNumCounts(int numCounts) {
        return numCounts == 1;
    }

    // extract child as other type and add into the array node
    private void extractChildAsOtherInArrayNode(
            int level, ArrayNode rootArrayNode, int numSiblings, String classAttr, Element childNode,
            Element childElement, boolean isFirstSibling
    ) {
        rootArrayNode.add(convertXmlToJson(childElement, level +1, classAttr, numSiblings, isFirstSibling));
    }

    // extract child as other type and add into the object node
    private void extractChildAsOtherInObjectNode(
            int level, ObjectNode rootObjectNode, int numSiblings, String classAttr, Element childNode,
            Element childElement, boolean isFirstSibling
    ) {
        rootObjectNode.set(
                childNode.getTagName(),
                convertXmlToJson(childElement, level +1, classAttr, numSiblings, isFirstSibling)
        );
    }

    // extract child as array type
    private void extractChildAsArray(
            int level, ArrayNode rootArrayNode, int numSiblings, String classAttr, Element childElement,
            boolean isFirstSibling
    ) {
        int subLevel = level +1;
        JsonNode subNode = convertXmlToJson(childElement, subLevel, classAttr, numSiblings, isFirstSibling);

        if(subNode.isArray() && subLevel == 3) {
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
            boolean isFirstSibling
    ) {
        if(xmlJsonDataFormat.isTypeHints()) {
            JsonNode subNode = convertXmlToJson(childElement, level +1, classAttr, numSiblings, isFirstSibling);
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
                        childElement.getTagName(), addNodeWithAttributeInfo(childElement, childElement.getTextContent())
                );
            } else {
                rootObjectNode.put(childElement.getTagName(), childElement.getTextContent());
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
                rootObjectNode.put(label, subElement.asText());
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

    // print some information about a specific tree level
    private void printElementDetails(
            Element element, int level, String parentClass, int parentSiblings, boolean isRootArray, boolean isOneValue,
            boolean isObject, boolean isFirstChild, int numberOfSiblings, int numberOfChildren, String classAttr,
            String typeAttr
    ) {
        if(logger.isDebugEnabled()) {
            printData(" >> Element: " + element.getTagName(), level);
            printData("    typeAttr: " + typeAttr, level);
            printData("    classAttr: " + classAttr, level);
            printData("    parentClass: " + parentClass, level);
            printData("    numberOfChildren: " + numberOfChildren, level);
            printData("    numberOfSiblings: " + numberOfSiblings, level);
            printData("    parentSiblings: " + parentSiblings, level);
            printData("    isRootArray: " + isRootArray, level);
            printData("    isOneValue: " + isOneValue, level);
            printData("    isObject: " + isObject, level);
            printData("    isFirstChild: " + isFirstChild, level);
        }
    }

    // print data string with the tree level indentation
    private void printData(String data, int level) {
        String suffix = "---";
        for(int i=0; i<level; i++) {
            data = suffix + data;
        }
        logger.debug(data);
    }

    // calculate number of siblings of an element
    private int calculateNumberOfSiblings(Element element) {
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
    private int calculateNumberOfChildren(Element element) {
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

}
