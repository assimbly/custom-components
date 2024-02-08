package org.assimbly.xmltojsonlegacy.utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.TextNode;
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
            int level, ArrayNode rootArrayNode, int numSiblings, String parentClass, String classAttr, Element childElement,
            boolean isFirstSibling, String namespace, HashMap<String, Namespace> xmlnsMap, boolean areSiblingsNamesEqual,
            boolean isParentSiblingsNamesEqual, boolean hasAttributes, boolean hasParentAttributes
    ) {
        JsonNode node = XmlToJsonProcessor.convertXmlToJson(
                childElement, level +1, parentClass, classAttr, numSiblings, isParentSiblingsNamesEqual,
                areSiblingsNamesEqual, hasParentAttributes, hasAttributes, isFirstSibling, namespace, xmlnsMap);
        if(isInternalNullObjectNodePresent(node)) {
            rootArrayNode.addNull();
            return;
        }
        if(node.isArray() && !node.get(0).isObject() && (rootArrayNode.isEmpty() ||
                !classAttr.equals(Constants.JSON_XML_ATTR_TYPE_ARRAY))
        ) {
            rootArrayNode.add(node.get(0));
        } else {
            rootArrayNode.add(node);
        }
    }

    // extract child as other type and add into the object node
    public static void extractChildAsOtherInObjectNode(
            int level, ObjectNode rootObjectNode, int numSiblings, String parentClass, String classAttr, Element childNode,
            Element childElement, boolean isFirstSibling, String namespace, HashMap<String, Namespace> xmlnsMap,
            boolean removeNamespacePrefixes, boolean areSiblingsNamesEqual, boolean isParentSiblingsNamesEqual,
            boolean hasAttributes, boolean hasParentAttributes, boolean trimSpaces, boolean isElementMustBeNull,
            boolean isElementOnNamespace
    ) {
        String propertyName = ElementUtils.getElementName(childNode, removeNamespacePrefixes);
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
                    if(isElementOnNamespace && node.isArray()) {
                        if(rootObjectNode.has(propertyName)) {
                            addObjectToExistingFieldOnRootObjectNode(
                                    rootObjectNode, propertyName, node.get(0), JsonNode.class, isElementMustBeNull
                            );
                        } else {
                            rootObjectNode.put(propertyName, !isElementMustBeNull ? node.get(0) : null);
                        }
                    } else {
                        rootObjectNode.put(propertyName, !isElementMustBeNull ? node : null);
                    }
                } else {
                    if(node.get(propertyName) != null) {
                        rootObjectNode.put(propertyName, !isElementMustBeNull ? node.get(propertyName) : null);
                    } else {
                        rootObjectNode.set(propertyName, node);
                    }
                }
                break;
            default:
                if(isElementMustBeNull) {
                    rootObjectNode.set(propertyName, null);
                    return;
                }
                if(JsonUtils.isJsonNodeInOneLevelAndWithNamespace(node)) {
                    node = transformJsonNodeWithNamespace(null, node, trimSpaces, isElementMustBeNull);
                }
                rootObjectNode.set(propertyName, node);
        }
    }

    // extract child as array type
    public static void extractChildAsArray(
            int level, ArrayNode rootArrayNode, int numSiblings, String parentClass, String classAttr, Element childElement,
            boolean isFirstSibling, String namespace, HashMap<String, Namespace> xmlnsMap, boolean areSiblingsNamesEqual,
            boolean isParentSiblingsNamesEqual, boolean hasAttributes, boolean hasParentAttributes,
            boolean isElementMustBeNull
    ) {
        JsonNode subNode = XmlToJsonProcessor.convertXmlToJson(
                childElement, level +1, parentClass, classAttr, numSiblings, isParentSiblingsNamesEqual,
                areSiblingsNamesEqual, hasParentAttributes, hasAttributes, isFirstSibling, namespace, xmlnsMap);

        if(subNode.isArray() && ElementChecker.isLastElement(childElement)) {
            for (JsonNode subElement : subNode) {
                rootArrayNode.add(!isElementMustBeNull ? subElement.asText() : null);
            }
        } else {
            rootArrayNode.add(!isElementMustBeNull ? subNode : null);
        }
    }

    // extract child as object type
    public static void extractChildAsObject(
            int level, ObjectNode rootObjectNode, int numSiblings, String parentClass, String classAttr,
            Element childElement, boolean isFirstSibling, String namespace, HashMap<String, Namespace> xmlnsMap,
            boolean trimSpaces, boolean skipNamespaces, boolean removeNamespacePrefixes, boolean typeHints,
            boolean areSiblingsNamesEqual, boolean isParentSiblingsNamesEqual, boolean hasAttributes,
            boolean hasParentAttributes, boolean isElementMustBeNull
    ) {
        if(typeHints) {
            extractChildAsObjectWithTypeHints(
                    level, rootObjectNode, numSiblings, parentClass, classAttr, childElement, isFirstSibling, namespace,
                    xmlnsMap, trimSpaces, removeNamespacePrefixes, areSiblingsNamesEqual, isParentSiblingsNamesEqual,
                    hasAttributes, hasParentAttributes, isElementMustBeNull
            );
        } else {
            extractChildAsObjectWithoutTypeHints(
                    level, rootObjectNode, classAttr, childElement, namespace, xmlnsMap, trimSpaces, skipNamespaces,
                    removeNamespacePrefixes, isElementMustBeNull
            );
        }
    }

    // extract child as object type with type hints enabled
    private static void extractChildAsObjectWithTypeHints(
            int level, ObjectNode rootObjectNode, int numSiblings, String parentClass, String classAttr,
            Element childElement, boolean isFirstSibling, String namespace, HashMap<String, Namespace> xmlnsMap,
            boolean trimSpaces, boolean removeNamespacePrefixes, boolean areSiblingsNamesEqual,
            boolean isParentSiblingsNamesEqual, boolean hasAttributes, boolean hasParentAttributes,
            boolean isElementMustBeNull
    ) {
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
                transformJsonNodeWithNamespace(rootObjectNode, subNode, trimSpaces, isElementMustBeNull);
            } else {
                for (JsonNode subElement : subNode) {
                    if(subNode.fields().hasNext()) {
                        subNode.fields().forEachRemaining(entry -> {
                            String label = entry.getKey();
                            String childTypeAttr = childElement.getAttribute(Constants.JSON_XML_ATTR_TYPE);
                            setValueUsingAttributeType(
                                    rootObjectNode, subElement, label, null, childTypeAttr, trimSpaces,
                                    isElementMustBeNull
                            );
                        });
                    } else {
                        String fieldName = ElementUtils.getElementName(childElement, removeNamespacePrefixes);
                        String fieldValue = ElementUtils.getNodeValue(childElement, trimSpaces);
                        if(rootObjectNode.has(fieldName)) {
                            addObjectToExistingFieldOnRootObjectNode(
                                    rootObjectNode, fieldName, fieldValue, String.class, isElementMustBeNull
                            );
                        } else {
                            if(fieldValue.equalsIgnoreCase("")) {
                                rootObjectNode.set(fieldName, JsonNodeFactory.instance.arrayNode());
                            } else {
                                rootObjectNode.put(fieldName, !isElementMustBeNull ? fieldValue : null);
                            }
                        }
                    }
                }
            }
        }
    }

    // extract child as object type without type hints enabled
    private static void extractChildAsObjectWithoutTypeHints(
            int level, ObjectNode rootObjectNode, String classAttr, Element childElement, String namespace,
            HashMap<String, Namespace> xmlnsMap, boolean trimSpaces, boolean skipNamespaces,
            boolean removeNamespacePrefixes, boolean isElementMustBeNull)
    {
        String type = childElement.getAttribute(Constants.JSON_XML_ATTR_TYPE);
        if(classAttr !=null && !classAttr.equals("") && type!=null && !type.equals("") || type!=null &&
                !type.equals("")
        ) {
            rootObjectNode.set(
                    ElementUtils.getElementName(childElement, removeNamespacePrefixes),
                    (!isElementMustBeNull ?
                            addNodeWithAttributeInfo(childElement, ElementUtils.getNodeValue(childElement, trimSpaces)) :
                            null)
            );
        } else {
            String fieldName = ElementUtils.getElementName(childElement, removeNamespacePrefixes);
            String fieldValue = ElementUtils.getNodeValue(childElement, trimSpaces);
            if(rootObjectNode.has(fieldName)) {
                JsonNode nodeValues = rootObjectNode.get(fieldName);
                if(nodeValues.isArray()) {
                    ObjectNode attrInfoObjectNode = JsonNodeFactory.instance.objectNode();
                    boolean isNamespaceAdded = addNamespaceAttributeInObjectNode(
                            childElement, attrInfoObjectNode, xmlnsMap, namespace, level, skipNamespaces
                    );
                    if(isNamespaceAdded) {
                        attrInfoObjectNode.put(Constants.JSON_XML_TEXT_FIELD, fieldValue);
                        ((ArrayNode)nodeValues).add(!isElementMustBeNull ? attrInfoObjectNode : null);
                    } else {
                        ((ArrayNode)nodeValues).add(!isElementMustBeNull ? fieldValue : null);
                    }
                } else {
                    ArrayNode arrayNode = JsonNodeFactory.instance.arrayNode();
                    arrayNode.add(nodeValues);
                    arrayNode.add(!isElementMustBeNull ? fieldValue: null);
                    nodeValues = arrayNode;
                }
                rootObjectNode.set(fieldName, nodeValues);
            } else {
                if(fieldValue.equalsIgnoreCase("")) {
                    rootObjectNode.set(fieldName, JsonNodeFactory.instance.arrayNode());
                } else {
                    if(isElementMustBeNull) {
                        rootObjectNode.putNull(fieldName);
                    } else {
                        ObjectNode attrInfoObjectNode = JsonNodeFactory.instance.objectNode();
                        boolean isNamespaceAdded = addNamespaceAttributeInObjectNode(
                                childElement, attrInfoObjectNode, xmlnsMap, namespace, level, skipNamespaces
                        );
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
    private static ObjectNode transformJsonNodeWithNamespace(
            ObjectNode rootObjectNode, JsonNode node, boolean trimSpaces, boolean isElementMustBeNull
    ) {
        AtomicReference<String> name = new AtomicReference<>("");
        ObjectNode objectNode = JsonNodeFactory.instance.objectNode();
        node.fields().forEachRemaining(entry -> {
            String label = entry.getKey();
            if(label.startsWith(Constants.JSON_XML_ATTR_PREFIX)) {
                objectNode.put(label, entry.getValue());
            } else {
                setValueUsingAttributeType(
                        objectNode, entry.getValue(), Constants.JSON_XML_TEXT_FIELD, null, "",
                        trimSpaces, isElementMustBeNull
                );
                name.set(label);
            }
        });

        if(rootObjectNode!=null) {
            if(rootObjectNode.has(name.get())) {
                addObjectToExistingFieldOnRootObjectNode(
                        rootObjectNode, name.get(), objectNode, ObjectNode.class, isElementMustBeNull
                );
            } else {
                rootObjectNode.put(name.get(), !isElementMustBeNull ? objectNode : null);
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
        attrInfoObjectNode.put(Constants.JSON_XML_TEXT_FIELD, value.equalsIgnoreCase(Constants.NULL_VALUE) ? null : value);

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
                    rootObjectNode.put(
                            Constants.JSON_XML_ATTR_PREFIX + namespaceLabel,
                            xmlnsMapOnThisNode.get(namespaceLabel).getNamespace()
                    );
                    return true;
                }
            }
        }
        return false;
    }

    // set value as specified in the attribute type
    public static void setValueUsingAttributeType(
            ObjectNode rootObjectNode, JsonNode subElement, String label, String value, String childTypeAttr,
            boolean trimSpaces, boolean isElementMustBeNull
    ) {
        if(rootObjectNode.has(label)) {
            JsonNode nodeValues = rootObjectNode.get(label);
            if(nodeValues.isArray()) {
                // ADD
                addValueIntoArrayNode(
                        (ArrayNode)nodeValues, childTypeAttr, label, value, subElement, trimSpaces, isElementMustBeNull
                );
            } else {
                ArrayNode arrayNode = JsonNodeFactory.instance.arrayNode();
                arrayNode.add(nodeValues);
                // ADD
                addValueIntoArrayNode(arrayNode, childTypeAttr, label, value, subElement, trimSpaces, isElementMustBeNull);
                nodeValues = arrayNode;
            }
            rootObjectNode.set(label, nodeValues);
        } else {
            // PUT
            putValueOnObjectNode(rootObjectNode, childTypeAttr, label, value, subElement, trimSpaces, isElementMustBeNull);
        }
    }

    // put value on ObjectNode
    public static void putValueOnObjectNode(
            ObjectNode objectNode, String type, String label, String value, JsonNode subElement, boolean trimSpaces,
            boolean isElementMustBeNull
    ){
        switch (type.toLowerCase()) {
            case Constants.JSON_XML_ATTR_TYPE_NUMBER:
                objectNode.put(
                        label,
                        !isElementMustBeNull ? (subElement!=null ? subElement.asInt() : Integer.parseInt(value)) : null
                );
                break;
            case Constants.JSON_XML_ATTR_TYPE_BOOLEAN:
                objectNode.put(
                        label,
                        !isElementMustBeNull ?
                                (subElement!=null ? subElement.asBoolean() : Boolean.valueOf(value).booleanValue()) :
                                null
                );
                break;
            case Constants.JSON_XML_ATTR_TYPE_ARRAY:
            case Constants.JSON_XML_ATTR_TYPE_OBJECT:
                // do nothing
                break;
            default:
                value = (subElement!=null ? subElement.asText() : value);
                if(trimSpaces){
                    value = (value.trim().equalsIgnoreCase(Constants.NULL_VALUE) ? null : value.trim());
                } else {
                    value = (value.equalsIgnoreCase(Constants.NULL_VALUE) ? null : value);
                }
                objectNode.put(
                        label,
                        !isElementMustBeNull ? value : null
                );
                break;
        }
    }

    // add value into ArrayNode
    public static void addValueIntoArrayNode(
            ArrayNode arrayNode, String type, String label, String value, JsonNode subElement, boolean trimSpaces,
            boolean isElementMustBeNull
    ){
        switch (type.toLowerCase()) {
            case Constants.JSON_XML_ATTR_TYPE_NUMBER:
                arrayNode.add(
                        !isElementMustBeNull ?
                                subElement!=null ? subElement.asInt() : Integer.parseInt(value) :
                                null
                );
                break;
            case Constants.JSON_XML_ATTR_TYPE_BOOLEAN:
                arrayNode.add(
                        !isElementMustBeNull ?
                                subElement!=null ? subElement.asBoolean() : Boolean.valueOf(value).booleanValue() :
                                null
                );
                break;
            case Constants.JSON_XML_ATTR_TYPE_ARRAY:
            case Constants.JSON_XML_ATTR_TYPE_OBJECT:
                // do nothing
                break;
            default:
                value = (subElement!=null ? subElement.asText() : value);
                if(trimSpaces){
                    value = (value.trim().equalsIgnoreCase(Constants.NULL_VALUE) ? null : value.trim());
                } else {
                    value = (value.equalsIgnoreCase(Constants.NULL_VALUE) ? null : value);
                }
                arrayNode.add(!isElementMustBeNull ? value : null);
                break;
        }
    }

    // get attribute type value from a element
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

    // create a JsonNode with internal null value
    public static JsonNode createInternalNullObjectNode() {
        return new TextNode(Constants.INTERNAL_NULL_OBJECT_NODE_VALUE);
    }

    // checks if node contains an internal null value
    public static boolean isInternalNullObjectNodePresent(JsonNode node) {
        return node.isTextual() && node.asText().equals(Constants.INTERNAL_NULL_OBJECT_NODE_VALUE);
    }

    // add object to existing field on rootObjectNode
    private static void addObjectToExistingFieldOnRootObjectNode(
            ObjectNode rootObjectNode, String field, Object value, Class<?> valueType, boolean isElementMustBeNull
    ) {
        JsonNode newValue = null;
        if(valueType == ObjectNode.class || valueType == JsonNode.class) {
            newValue = (JsonNode) value;
        } else if (valueType == String.class) {
            newValue = JsonNodeFactory.instance.textNode((String) value);
        } else {
            throw new IllegalArgumentException("Unsupported value type: " + valueType);
        }

        JsonNode nodeValues = rootObjectNode.get(field);
        if(!nodeValues.isArray()) {
            ArrayNode arrayNode = JsonNodeFactory.instance.arrayNode();
            arrayNode.add(nodeValues);
            nodeValues = arrayNode;
        }

        ((ArrayNode)nodeValues).add(!isElementMustBeNull ? newValue : null);
        rootObjectNode.set(field, nodeValues);
    }

}
