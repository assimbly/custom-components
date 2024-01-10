package org.assimbly.xmltojsonlegacy.utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.apache.commons.lang3.StringUtils;
import org.apache.xerces.dom.DeferredElementImpl;
import org.assimbly.xmltojsonlegacy.Constants;
import org.assimbly.xmltojsonlegacy.processor.XmlToJsonProcessor;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

import java.util.Iterator;

public class ExtractUtils {

    // extract child as other type and add into the array node
    public static void extractChildAsOtherInArrayNode(
            int level, ArrayNode rootArrayNode, int numSiblings, String parentClass, String classAttr, Element childNode,
            Element childElement, boolean isFirstSibling, String namespace, boolean areSiblingsNamesEqual,
            boolean isParentSiblingsNamesEqual, boolean hasAttributes, boolean hasParentAttributes
    ) {
        rootArrayNode.add(XmlToJsonProcessor.convertXmlToJson(childElement, level +1, parentClass, classAttr, numSiblings, isParentSiblingsNamesEqual, areSiblingsNamesEqual, hasParentAttributes, hasAttributes, isFirstSibling, namespace));
    }

    // extract child as other type and add into the object node
    public static void extractChildAsOtherInObjectNode(
            int level, ObjectNode rootObjectNode, int numSiblings, String parentClass, String classAttr, Element childNode,
            Element childElement, boolean isFirstSibling, String namespace, boolean skipNamespaces,
            boolean removeNamespacePrefixes, boolean areSiblingsNamesEqual, boolean isParentSiblingsNamesEqual,
            boolean hasAttributes, boolean hasParentAttributes
    ) {
        String propertyName = ElementUtils.getElementName(childNode, namespace, removeNamespacePrefixes, skipNamespaces);
        JsonNode node = XmlToJsonProcessor.convertXmlToJson(childElement, level +1, parentClass, classAttr, numSiblings, isParentSiblingsNamesEqual, areSiblingsNamesEqual, hasParentAttributes, hasAttributes, isFirstSibling, namespace);
        int childCount = ((DeferredElementImpl) childElement).getChildElementCount();
        switch (node.size()) {
            case 0:
                rootObjectNode.set(propertyName, JsonNodeFactory.instance.arrayNode());
                break;
            case 1:
                if(node.isArray() || (childCount > 0 && StringUtils.isEmpty(classAttr))) {
                    rootObjectNode.put(propertyName, node);
                } else {
                    if(classAttr==null || !classAttr.equals(Constants.JSON_XML_ATTR_TYPE_OBJECT)) {
                        if(node.get(propertyName) != null) {
                            rootObjectNode.put(propertyName, node.get(propertyName));
                        } else {
                            rootObjectNode.set(propertyName, node);
                        }
                    } else {
                        rootObjectNode.set(propertyName, node);
                    }
                }
                break;
            default:
                rootObjectNode.set(propertyName, node);
        }
    }

    // extract child as array type
    public static void extractChildAsArray(
            int level, ArrayNode rootArrayNode, int numSiblings, String parentClass, String classAttr, Element childElement,
            boolean isFirstSibling, String namespace, boolean areSiblingsNamesEqual, boolean isParentSiblingsNamesEqual,
            boolean hasAttributes, boolean hasParentAttributes
    ) {
        JsonNode subNode = XmlToJsonProcessor.convertXmlToJson(childElement, level +1, parentClass, classAttr, numSiblings, isParentSiblingsNamesEqual, areSiblingsNamesEqual, hasParentAttributes, hasAttributes, isFirstSibling, namespace);

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
            int level, ObjectNode rootObjectNode, int numSiblings, String parentClass, String classAttr, Element childElement,
            boolean isFirstSibling, String namespace, boolean trimSpaces, boolean skipNamespaces,
            boolean removeNamespacePrefixes, boolean typeHints, boolean areSiblingsNamesEqual, boolean isParentSiblingsNamesEqual,
            boolean hasAttributes, boolean hasParentAttributes
    ) {
        if(typeHints) {
            JsonNode subNode = XmlToJsonProcessor.convertXmlToJson(childElement, level +1, parentClass, classAttr, numSiblings, isParentSiblingsNamesEqual, areSiblingsNamesEqual, hasParentAttributes, hasAttributes, isFirstSibling, namespace);
            if(subNode.isEmpty()) {
                if(ElementChecker.isElementAttributeNull(childElement, Constants.JSON_XML_ATTR_TYPE) &&
                        ElementChecker.isElementNodeValueNull(childElement)) {
                    setEmptyArrayNodeInRootObjectNode(rootObjectNode, childElement.getTagName());
                }
            } else {
                for (JsonNode subElement : subNode) {
                    if(subNode.fields().hasNext()) {
                        subNode.fields().forEachRemaining(entry -> {
                            String label = entry.getKey();
                            String childTypeAttr = childElement.getAttribute(Constants.JSON_XML_ATTR_TYPE);
                            setValueUsingAttributeType(rootObjectNode, subElement, label, null, childTypeAttr, trimSpaces);
                        });
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
                            if(fieldValue.equalsIgnoreCase("")) {
                                rootObjectNode.set(fieldName, JsonNodeFactory.instance.arrayNode());
                            } else {
                                rootObjectNode.put(fieldName, fieldValue);
                            }
                        }
                    }
                }
            }
        } else {
            String type = childElement.getAttribute(Constants.JSON_XML_ATTR_TYPE);
            if(classAttr!=null && !classAttr.equals("") && type!=null && !type.equals("") || type!=null && !type.equals("")) {
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
                    if(fieldValue.equalsIgnoreCase("")) {
                        rootObjectNode.set(fieldName, JsonNodeFactory.instance.arrayNode());
                    } else {
                        rootObjectNode.put(fieldName, fieldValue);
                    }
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
        attrInfoObjectNode.put(Constants.JSON_XML_TEXT_FIELD, value.equalsIgnoreCase("null") ? null : value);

        return attrInfoObjectNode;
    }


    // set value as specified in the attribute type
    public static void setValueUsingAttributeType(
            ObjectNode rootObjectNode, JsonNode subElement, String label, String value, String childTypeAttr, boolean trimSpaces
    ) {
        switch (childTypeAttr.toLowerCase()) {
            case Constants.JSON_XML_ATTR_TYPE_NUMBER:
                rootObjectNode.put(label, (subElement!=null ? subElement.asInt() : Integer.parseInt(value)));
                break;
            case Constants.JSON_XML_ATTR_TYPE_BOOLEAN:
                rootObjectNode.put(label, (subElement!=null ? subElement.asBoolean() : Boolean.valueOf(value).booleanValue()));
                break;
            case Constants.JSON_XML_ATTR_TYPE_ARRAY:
            case Constants.JSON_XML_ATTR_TYPE_OBJECT:
                // do nothing
                break;
            default:
                value = (subElement!=null ? subElement.asText() : value);
                if(trimSpaces){
                    value = (value.trim().equalsIgnoreCase("null") ? null : value.trim());
                } else {
                    value = (value.equalsIgnoreCase("null") ? null : value);
                }
                if(rootObjectNode.has(label)) {
                    JsonNode nodeValues = rootObjectNode.get(label);
                    if(nodeValues.isArray()) {
                        ((ArrayNode)nodeValues).add(value);
                    } else {
                        ArrayNode arrayNode = JsonNodeFactory.instance.arrayNode();
                        arrayNode.add(nodeValues.asText());
                        arrayNode.add(value);
                        nodeValues = arrayNode;
                    }
                    rootObjectNode.set(label, nodeValues);
                } else {
                    rootObjectNode.put(label, value);
                }
                break;
        }
    }

    public static String getAttributeTypeFromElement(Element nodeElement) {
        if(nodeElement!=null && nodeElement.getAttributes() != null) {
            NamedNodeMap attributeMap = nodeElement.getAttributes();
            for (int i = 0; i < attributeMap.getLength(); i++) {
                Node attribute = attributeMap.item(i);
                if (attribute.getNodeName().equals(Constants.JSON_XML_ATTR_TYPE)) {
                    return attribute.getNodeValue();
                }
            }
        }
        return "";
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
