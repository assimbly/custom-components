package org.assimbly.xmltojsonlegacy.utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.assimbly.xmltojsonlegacy.Constants;
import org.assimbly.xmltojsonlegacy.processor.XmlToJsonProcessor;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

import java.util.Iterator;

public class ExtractUtils {

    // extract child as other type and add into the array node
    public static void extractChildAsOtherInArrayNode(
            int level, ArrayNode rootArrayNode, int numSiblings, String classAttr, Element childNode,
            Element childElement, boolean isFirstSibling, String namespace
    ) {
        rootArrayNode.add(XmlToJsonProcessor.convertXmlToJson(childElement, level +1, classAttr, numSiblings, isFirstSibling, namespace));
    }

    // extract child as other type and add into the object node
    public static void extractChildAsOtherInObjectNode(
            int level, ObjectNode rootObjectNode, int numSiblings, String classAttr, Element childNode,
            Element childElement, boolean isFirstSibling, String namespace, boolean skipNamespaces,
            boolean removeNamespacePrefixes
    ) {
        String propertyName = ElementUtils.getElementName(childNode, namespace, removeNamespacePrefixes, skipNamespaces);
        JsonNode node = XmlToJsonProcessor.convertXmlToJson(childElement, level +1, classAttr, numSiblings, isFirstSibling, namespace);
        switch (node.size()) {
            case 0:
                rootObjectNode.set(propertyName, JsonNodeFactory.instance.arrayNode());
                break;
            case 1:
                rootObjectNode.put(propertyName, node.get(propertyName).asText());
                break;
            default:
                rootObjectNode.set(propertyName, node);
        }
    }

    // extract child as array type
    public static void extractChildAsArray(
            int level, ArrayNode rootArrayNode, int numSiblings, String classAttr, Element childElement,
            boolean isFirstSibling, String namespace
    ) {
        JsonNode subNode = XmlToJsonProcessor.convertXmlToJson(childElement, level +1, classAttr, numSiblings, isFirstSibling, namespace);

        if(subNode.isArray() && ElementChecker.isLastElement(childElement)) {
            for (JsonNode subElement : subNode) {
                rootArrayNode.add(subElement.asText());
            }
        } else {
            rootArrayNode.add(subNode);
        }
    }

    // extract child as object type
    public static void extractChildAsObject(
            int level, ObjectNode rootObjectNode, int numSiblings, String classAttr, Element childElement,
            boolean isFirstSibling, String namespace, boolean trimSpaces, boolean skipNamespaces,
            boolean removeNamespacePrefixes, boolean typeHints
    ) {
        if(typeHints) {
            JsonNode subNode = XmlToJsonProcessor.convertXmlToJson(childElement, level +1, classAttr, numSiblings, isFirstSibling, namespace);
            if(subNode.isEmpty()) {
                setEmptyArrayNodeInRootObjectNode(rootObjectNode, childElement.getTagName());
            } else {
                for (JsonNode subElement : subNode) {
                    subNode.fields().forEachRemaining(entry -> {
                        String label = entry.getKey();
                        String childTypeAttr = childElement.getAttribute(Constants.JSON_XML_ATTR_TYPE);
                        setValueUsingAttributeType(rootObjectNode, subElement, label, childTypeAttr, trimSpaces);
                    });
                }
            }
        } else {
            if(classAttr!=null && !classAttr.equals("")) {
                rootObjectNode.set(
                        ElementUtils.getElementName(childElement, namespace, removeNamespacePrefixes, skipNamespaces),
                        addNodeWithAttributeInfo(childElement, ElementUtils.getNodeValue(childElement, trimSpaces))
                );
            } else {
                String fieldName = ElementUtils.getElementName(childElement, namespace, removeNamespacePrefixes, skipNamespaces);
                String fieldValue = ElementUtils.getNodeValue(childElement, trimSpaces);
                if(rootObjectNode.has(fieldName)) {
                    JsonNode nodeValues = rootObjectNode.get(fieldName);
                    if(nodeValues.isArray()) {
                        ((ArrayNode)nodeValues).add(fieldValue);
                    } else {
                        ArrayNode arrayNode = JsonNodeFactory.instance.arrayNode();
                        arrayNode.add(nodeValues.asText());
                        arrayNode.add(fieldValue);
                        nodeValues = arrayNode;
                    }
                    rootObjectNode.set(fieldName, nodeValues);
                } else {
                    rootObjectNode.put(fieldName, fieldValue);
                }
            }
        }
    }

    // add node with attribute information
    private static JsonNode addNodeWithAttributeInfo(Element element, String value) {
        ObjectNode attrInfoObjectNode = JsonNodeFactory.instance.objectNode();

        if(element.hasAttributes()){
            NamedNodeMap attrMap = element.getAttributes();
            for (int j = 0; j < attrMap.getLength(); j++) {
                Node node = attrMap.item(j);
                attrInfoObjectNode.put(Constants.JSON_XML_ATTR_PREFIX+node.getNodeName(), node.getNodeValue());
            }
        }
        attrInfoObjectNode.put(Constants.JSON_XML_TEXT_FIELD, value);

        return attrInfoObjectNode;
    }


    // set value as specified in the attribute type
    private static void setValueUsingAttributeType(
            ObjectNode rootObjectNode, JsonNode subElement, String label, String childTypeAttr, boolean trimSpaces
    ) {
        switch (childTypeAttr.toLowerCase()) {
            case Constants.JSON_XML_ATTR_TYPE_NUMBER:
                rootObjectNode.put(label, subElement.asInt());
                break;
            case Constants.JSON_XML_ATTR_TYPE_BOOLEAN:
                rootObjectNode.put(label, subElement.asBoolean());
                break;
            case Constants.JSON_XML_ATTR_TYPE_STRING:
            case "":
                String value = subElement.asText();
                if(trimSpaces){
                    value = (value.trim().equalsIgnoreCase("null") ? null : value.trim());
                } else {
                    value = (value.equalsIgnoreCase("null") ? null : value);
                }
                rootObjectNode.put(label, value);
                break;
            default:
                // do nothing
        }
    }

    // set empty array node in rootObjectNode
    private static void setEmptyArrayNodeInRootObjectNode(ObjectNode rootObjectNode, String label) {
        rootObjectNode.set(label, JsonNodeFactory.instance.arrayNode());
    }

    // check if rootObjectNode contains attributes
    public static boolean rootObjectNodeContainsAttributes(ObjectNode rootObjectNode) {
        Iterator<String> fieldNamesIterator = rootObjectNode.fieldNames();
        while (fieldNamesIterator.hasNext()) {
            String fieldName = fieldNamesIterator.next();
            if (fieldName.startsWith(Constants.JSON_XML_ATTR_PREFIX)) {
                return true;
            }
        }
        return false;
    }

    // check if rootObjectNode contains text attributes
    public static boolean rootObjectNodeContainsTextAttribute(ObjectNode rootObjectNode) {
        return rootObjectNode!=null && rootObjectNode.has(Constants.JSON_XML_TEXT_FIELD);
    }

}
