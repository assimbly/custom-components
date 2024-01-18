package org.assimbly.xmltojsonlegacy.utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.apache.commons.lang3.StringUtils;
import org.apache.xerces.dom.DeferredElementImpl;
import org.assimbly.xmltojsonlegacy.Constants;
import org.assimbly.xmltojsonlegacy.Namespace;
import org.assimbly.xmltojsonlegacy.processor.XmlToJsonProcessor;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

import javax.xml.XMLConstants;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

public class ExtractUtils {

    // extract child as other type and add into the array node
    public static void extractChildAsOtherInArrayNode(
            int level, ArrayNode rootArrayNode, int numSiblings, String parentClass, String classAttr, Element childNode,
            Element childElement, boolean isFirstSibling, String namespace, HashMap<String, Namespace> xmlnsMap,
            boolean areSiblingsNamesEqual, boolean isParentSiblingsNamesEqual, boolean hasAttributes, boolean hasParentAttributes
    ) {
        JsonNode node = XmlToJsonProcessor.convertXmlToJson(
                childElement, level +1, parentClass, classAttr, numSiblings, isParentSiblingsNamesEqual,
                areSiblingsNamesEqual, hasParentAttributes, hasAttributes, isFirstSibling, namespace, xmlnsMap);
        if(node.isArray() && !node.get(0).isObject()) {
            rootArrayNode.add(node.get(0));
        } else {
            rootArrayNode.add(node);
        }
    }

    // extract child as other type and add into the object node
    public static void extractChildAsOtherInObjectNode(
            int level, ObjectNode rootObjectNode, int numSiblings, String parentClass, String classAttr, Element childNode,
            Element childElement, boolean isFirstSibling, String namespace, HashMap<String, Namespace> xmlnsMap,
            boolean skipNamespaces, boolean removeNamespacePrefixes, boolean areSiblingsNamesEqual,
            boolean isParentSiblingsNamesEqual, boolean hasAttributes, boolean hasParentAttributes, boolean trimSpaces
    ) {
        String propertyName = ElementUtils.getElementName(childNode, removeNamespacePrefixes, skipNamespaces);
        JsonNode node = XmlToJsonProcessor.convertXmlToJson(
                childElement, level +1, parentClass, classAttr, numSiblings, isParentSiblingsNamesEqual,
                areSiblingsNamesEqual, hasParentAttributes, hasAttributes, isFirstSibling, namespace, xmlnsMap);
        int childCount = ((DeferredElementImpl) childElement).getChildElementCount();
        switch (node.size()) {
            case 0:
                rootObjectNode.set(propertyName, JsonNodeFactory.instance.arrayNode());
                break;
            case 1:
                if(node.isArray() || (childCount > 0 && StringUtils.isEmpty(classAttr))) {
                    rootObjectNode.put(propertyName, node);
                } else {
                    if(node.get(propertyName) != null) {
                        rootObjectNode.put(propertyName, node.get(propertyName));
                    } else {
                        rootObjectNode.set(propertyName, node);
                    }
                }
                break;
            default:
                if(JsonUtils.isJsonNodeInOneLevelAndWithNamespace(node)) {
                    node = transformJsonNodeWithNamespace(null, node, trimSpaces);
                }
                rootObjectNode.set(propertyName, node);
        }
    }

    // extract child as array type
    public static void extractChildAsArray(
            int level, ArrayNode rootArrayNode, int numSiblings, String parentClass, String classAttr, Element childElement,
            boolean isFirstSibling, String namespace, HashMap<String, Namespace> xmlnsMap, boolean areSiblingsNamesEqual,
            boolean isParentSiblingsNamesEqual, boolean hasAttributes, boolean hasParentAttributes
    ) {
        JsonNode subNode = XmlToJsonProcessor.convertXmlToJson(
                childElement, level +1, parentClass, classAttr, numSiblings, isParentSiblingsNamesEqual,
                areSiblingsNamesEqual, hasParentAttributes, hasAttributes, isFirstSibling, namespace, xmlnsMap);

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
            boolean isFirstSibling, String namespace, HashMap<String, Namespace> xmlnsMap, boolean trimSpaces, boolean skipNamespaces,
            boolean removeNamespacePrefixes, boolean typeHints, boolean areSiblingsNamesEqual, boolean isParentSiblingsNamesEqual,
            boolean hasAttributes, boolean hasParentAttributes
    ) {
        if(typeHints) {
            JsonNode subNode = XmlToJsonProcessor.convertXmlToJson(
                    childElement, level +1, parentClass, classAttr, numSiblings, isParentSiblingsNamesEqual,
                    areSiblingsNamesEqual, hasParentAttributes, hasAttributes, isFirstSibling, namespace, xmlnsMap);
            if(subNode.isEmpty()) {
                if(ElementChecker.isElementAttributeNull(childElement, Constants.JSON_XML_ATTR_TYPE) &&
                        ElementChecker.isElementNodeValueNull(childElement)) {
                    setEmptyArrayNodeInRootObjectNode(rootObjectNode, childElement.getTagName());
                }
            } else {
                if(JsonUtils.isJsonNodeInOneLevelAndWithNamespace(subNode)) {
                    transformJsonNodeWithNamespace(rootObjectNode, subNode, trimSpaces);
                } else {
                    for (JsonNode subElement : subNode) {
                        if(subNode.fields().hasNext()) {
                            subNode.fields().forEachRemaining(entry -> {
                                String label = entry.getKey();
                                String childTypeAttr = childElement.getAttribute(Constants.JSON_XML_ATTR_TYPE);
                                setValueUsingAttributeType(rootObjectNode, subElement, label, null, childTypeAttr, trimSpaces);
                            });
                        } else {
                            String fieldName = ElementUtils.getElementName(childElement, removeNamespacePrefixes, skipNamespaces);
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
            }
        } else {
            String type = childElement.getAttribute(Constants.JSON_XML_ATTR_TYPE);
            if(classAttr!=null && !classAttr.equals("") && type!=null && !type.equals("") || type!=null && !type.equals("")) {
                rootObjectNode.set(
                        ElementUtils.getElementName(childElement, removeNamespacePrefixes, skipNamespaces),
                        addNodeWithAttributeInfo(childElement, ElementUtils.getNodeValue(childElement, trimSpaces))
                );
            } else {
                String fieldName = ElementUtils.getElementName(childElement, removeNamespacePrefixes, skipNamespaces);
                String fieldValue = ElementUtils.getNodeValue(childElement, trimSpaces);
                if(rootObjectNode.has(fieldName)) {
                    JsonNode nodeValues = rootObjectNode.get(fieldName);
                    if(nodeValues.isArray()) {
                        ObjectNode attrInfoObjectNode = JsonNodeFactory.instance.objectNode();
                        boolean isNamespaceAdded = addNamespaceAttributeInObjectNode(childElement, attrInfoObjectNode, xmlnsMap, namespace, level, skipNamespaces);
                        if(isNamespaceAdded) {
                            attrInfoObjectNode.put(Constants.JSON_XML_TEXT_FIELD, fieldValue);
                            ((ArrayNode)nodeValues).add(attrInfoObjectNode);
                        } else {
                            ((ArrayNode)nodeValues).add(fieldValue);
                        }
                    } else {
                        ArrayNode arrayNode = JsonNodeFactory.instance.arrayNode();
                        arrayNode.add(nodeValues);
                        arrayNode.add(fieldValue);
                        nodeValues = arrayNode;
                    }
                    rootObjectNode.set(fieldName, nodeValues);
                } else {
                    if(fieldValue.equalsIgnoreCase("")) {
                        rootObjectNode.set(fieldName, JsonNodeFactory.instance.arrayNode());
                    } else {
                        ObjectNode attrInfoObjectNode = JsonNodeFactory.instance.objectNode();
                        boolean isNamespaceAdded = addNamespaceAttributeInObjectNode(childElement, attrInfoObjectNode, xmlnsMap, namespace, level, skipNamespaces);
                        if(isNamespaceAdded) {
                            attrInfoObjectNode.put(Constants.JSON_XML_TEXT_FIELD, fieldValue);
                            rootObjectNode.put(fieldName, attrInfoObjectNode);
                        } else {
                            rootObjectNode.put(fieldName, fieldValue);
                        }
                    }
                }
            }
        }
    }

    // transform json node with namespace
    // when rootObjectNode is not null, it will put json node on it
    // otherwise, it will return the transformed json node
    private static ObjectNode transformJsonNodeWithNamespace(ObjectNode rootObjectNode, JsonNode node, boolean trimSpaces) {
        AtomicReference<String> name = new AtomicReference<>("");
        ObjectNode objectNode = JsonNodeFactory.instance.objectNode();
        node.fields().forEachRemaining(entry -> {
            String label = entry.getKey();
            if(label.startsWith(Constants.JSON_XML_ATTR_PREFIX)) {
                objectNode.put(label, entry.getValue());
            } else {
                setValueUsingAttributeType(objectNode, entry.getValue(), Constants.JSON_XML_TEXT_FIELD, null, "", trimSpaces);
                name.set(label);
            }
        });
        if(rootObjectNode!=null) {
            if(rootObjectNode.has(name.get())) {
                JsonNode nodeValues = rootObjectNode.get(name.get());
                if(nodeValues.isArray()) {
                    ((ArrayNode)nodeValues).add(objectNode);
                } else {
                    ArrayNode arrayNode = JsonNodeFactory.instance.arrayNode();
                    arrayNode.add(nodeValues);
                    arrayNode.add(objectNode);
                    nodeValues = arrayNode;
                }
                rootObjectNode.set(name.get(), nodeValues);
            } else {
                rootObjectNode.put(name.get(), objectNode);
            }
        } else {
            return objectNode;
        }
        return null;
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

    // add attributes in the object node
    public static void addAttributesInObjectNode(
            Element element, ObjectNode rootObjectNode, boolean typeHints, boolean skipNamespaces
    ) {
        if(element.hasAttributes()){
            NamedNodeMap attrMap = element.getAttributes();
            for (int j = 0; j < attrMap.getLength(); j++) {
                Node node = attrMap.item(j);
                String attr = node.getNodeName();
                if(ElementUtils.isAnXmlnsAttribute(attr) && skipNamespaces) {
                    continue;
                }
                if(!typeHints || typeHints && !ElementUtils.isAnSpecialAttribute(attr)) {
                    rootObjectNode.put(Constants.JSON_XML_ATTR_PREFIX+node.getNodeName(), node.getNodeValue());
                }
            }
        }
    }

    // add attributes in the object node
    public static boolean addNamespaceAttributeInObjectNode(
            Element element, ObjectNode rootObjectNode, HashMap<String, Namespace> xmlnsMapOnThisNode,
            String parentNamespace, int level, boolean skipNamespaces
    ) {
        if(!skipNamespaces && !xmlnsMapOnThisNode.isEmpty()) {
            String elementNamePrefix = ElementUtils.getElementNamePrefix(element);
            if(!Objects.equals(elementNamePrefix, parentNamespace)) {
                String namespaceLabel = XMLConstants.XMLNS_ATTRIBUTE;
                if(elementNamePrefix != null) {
                    namespaceLabel += ":"+elementNamePrefix;
                }
                Namespace namespace = xmlnsMapOnThisNode.get(namespaceLabel);
                if(namespace==null || namespace.getLevel()+1<level) {
                    rootObjectNode.put(Constants.JSON_XML_ATTR_PREFIX + namespaceLabel, xmlnsMapOnThisNode.get(namespaceLabel).getNamespace());
                    return true;
                }
            }
        }
        return false;
    }

    // set value as specified in the attribute type
    public static void setValueUsingAttributeType(
            ObjectNode rootObjectNode, JsonNode subElement, String label, String value, String childTypeAttr, boolean trimSpaces
    ) {
        if(rootObjectNode.has(label)) {
            JsonNode nodeValues = rootObjectNode.get(label);
            if(nodeValues.isArray()) {
                // ADD
                addValueIntoArrayNode((ArrayNode)nodeValues, childTypeAttr, label, value, subElement, trimSpaces);
            } else {
                ArrayNode arrayNode = JsonNodeFactory.instance.arrayNode();
                arrayNode.add(nodeValues);
                // ADD
                addValueIntoArrayNode(arrayNode, childTypeAttr, label, value, subElement, trimSpaces);
                nodeValues = arrayNode;
            }
            rootObjectNode.set(label, nodeValues);
        } else {
            // PUT
            putValueOnObjectNode(rootObjectNode, childTypeAttr, label, value, subElement, trimSpaces);
        }
    }

    // put value on ObjectNode
    public static void putValueOnObjectNode(ObjectNode objectNode, String type, String label, String value, JsonNode subElement, boolean trimSpaces){
        switch (type.toLowerCase()) {
            case Constants.JSON_XML_ATTR_TYPE_NUMBER:
                objectNode.put(label, (subElement!=null ? subElement.asInt() : Integer.parseInt(value)));
                break;
            case Constants.JSON_XML_ATTR_TYPE_BOOLEAN:
                objectNode.put(label, (subElement!=null ? subElement.asBoolean() : Boolean.valueOf(value).booleanValue()));
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
                objectNode.put(label, value);
                break;
        }
    }

    // add value into ArrayNode
    public static void addValueIntoArrayNode(ArrayNode arrayNode, String type, String label, String value, JsonNode subElement, boolean trimSpaces){
        switch (type.toLowerCase()) {
            case Constants.JSON_XML_ATTR_TYPE_NUMBER:
                arrayNode.add(subElement!=null ? subElement.asInt() : Integer.parseInt(value));
                break;
            case Constants.JSON_XML_ATTR_TYPE_BOOLEAN:
                arrayNode.add(subElement!=null ? subElement.asBoolean() : Boolean.valueOf(value).booleanValue());
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
                arrayNode.add(value);
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
