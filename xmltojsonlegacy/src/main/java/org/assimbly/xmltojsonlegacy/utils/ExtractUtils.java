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
import org.assimbly.xmltojsonlegacy.XmlToJsonConfiguration;
import org.assimbly.xmltojsonlegacy.XmlToJsonProcessor;
import org.assimbly.xmltojsonlegacy.checker.ElementChecker;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

import javax.xml.XMLConstants;
import java.util.Iterator;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

public class ExtractUtils {

    // extract child as other type and add into the array node
    public static void extractChildAsOtherInArrayNode(XmlToJsonConfiguration config, Element childElement) {
        JsonNode node = XmlToJsonProcessor.convertXmlToJson(config.createSubLevelConfig(childElement));
        if(isInternalNullObjectNodePresent(node)) {
            config.getRootArrayNode().addNull();
            return;
        }
        if(node.isArray() && !node.get(0).isObject() && (config.getRootArrayNode().isEmpty() ||
                !config.getClassAttr().equals(Constants.JSON_XML_ATTR_TYPE_ARRAY))
        ) {
            config.getRootArrayNode().add(node.get(0));
        } else {
            config.getRootArrayNode().add(node);
        }
    }

    // extract child as other type and add into the object node
    public static void extractChildAsOtherInObjectNode(XmlToJsonConfiguration config, Element childElement) {
        String propertyName = ElementUtils.getElementName(childElement, config.isRemoveNamespacePrefixes());
        JsonNode node = XmlToJsonProcessor.convertXmlToJson(config.createSubLevelConfig(childElement));
        int childCount = ((DeferredElementImpl) childElement).getChildElementCount();
        switch (node.size()) {
            case 0:
                config.getRootObjectNode().set(propertyName, JsonNodeFactory.instance.arrayNode());
                break;
            case 1:
                if(node.isArray() || (childCount > 0 && StringUtils.isEmpty(config.getClassAttr()))) {
                    if(config.isElementOnNamespace() && node.isArray()) {
                        if(config.getRootObjectNode().has(propertyName)) {
                            addObjectToExistingFieldOnRootObjectNode(config, propertyName, node.get(0), JsonNode.class);
                        } else {
                            config.getRootObjectNode().put(propertyName, !config.isElementMustBeNull() ? node.get(0) : null);
                        }
                    } else {
                        config.getRootObjectNode().put(propertyName, !config.isElementMustBeNull() ? node : null);
                    }
                } else {
                    if(node.get(propertyName) != null) {
                        config.getRootObjectNode().put(propertyName, !config.isElementMustBeNull() ? node.get(propertyName) : null);
                    } else {
                        config.getRootObjectNode().set(propertyName, node);
                    }
                }
                break;
            default:
                if(config.isElementMustBeNull()) {
                    config.getRootObjectNode().set(propertyName, null);
                    return;
                }
                if(JsonUtils.isJsonNodeInOneLevelAndWithNamespace(node)) {
                    node = transformJsonNodeWithNamespace(config, node, false);
                }
                config.getRootObjectNode().set(propertyName, node);
        }
    }

    // extract child as array type
    public static void extractChildAsArray(XmlToJsonConfiguration config, Element childElement) {
        JsonNode subNode = XmlToJsonProcessor.convertXmlToJson(config.createSubLevelConfig(childElement));

        if(subNode.isArray() && ElementChecker.isLastElement(childElement)) {
            for (JsonNode subElement : subNode) {
                config.getRootArrayNode().add(!config.isElementMustBeNull() ? subElement.asText() : null);
            }
        } else {
            config.getRootArrayNode().add(!config.isElementMustBeNull() ? subNode : null);
        }
    }

    // extract child as object type
    public static void extractChildAsObject(XmlToJsonConfiguration config, Element childNode) {
        if(config.isTypeHints()) {
            extractChildAsObjectWithTypeHints(config, childNode);
        } else {
            extractChildAsObjectWithoutTypeHints(config, childNode);
        }
    }

    // extract child as object type with type hints enabled
    private static void extractChildAsObjectWithTypeHints(XmlToJsonConfiguration config, Element childElement) {
        JsonNode subNode = XmlToJsonProcessor.convertXmlToJson(config.createSubLevelConfig(childElement));
        if(subNode.isEmpty()) {
            if(ElementChecker.isElementAttributeNull(childElement, Constants.JSON_XML_ATTR_TYPE) &&
                    ElementChecker.isElementNodeValueNull(childElement)) {
                setEmptyArrayNodeInRootObjectNode(config.getRootObjectNode(), childElement.getTagName());
            }
        } else {
            if(JsonUtils.isJsonNodeInOneLevelAndWithNamespace(subNode)) {
                transformJsonNodeWithNamespace(config, subNode, true);
            } else {
                for (JsonNode subElement : subNode) {
                    if(subNode.fields().hasNext()) {
                        subNode.fields().forEachRemaining(entry -> {
                            String label = entry.getKey();
                            String childTypeAttr = childElement.getAttribute(Constants.JSON_XML_ATTR_TYPE);
                            setValueUsingAttributeType(config, config.getRootObjectNode(), subElement, label, null, childTypeAttr);
                        });
                    } else {
                        String fieldName = ElementUtils.getElementName(childElement, config.isRemoveNamespacePrefixes());
                        String fieldValue = ElementUtils.getNodeValue(childElement, config.isTrimSpaces());
                        if(config.getRootObjectNode().has(fieldName)) {
                            addObjectToExistingFieldOnRootObjectNode(config, fieldName, fieldValue, String.class);
                        } else {
                            if(fieldValue.equalsIgnoreCase("")) {
                                config.getRootObjectNode().set(fieldName, JsonNodeFactory.instance.arrayNode());
                            } else {
                                config.getRootObjectNode().put(fieldName, !config.isElementMustBeNull() ? fieldValue : null);
                            }
                        }
                    }
                }
            }
        }
    }

    // extract child as object type without type hints enabled
    private static void extractChildAsObjectWithoutTypeHints(XmlToJsonConfiguration config, Element childElement) {
        String type = childElement.getAttribute(Constants.JSON_XML_ATTR_TYPE);
        if(config.getClassAttr() !=null && !config.getClassAttr().equals("") && type!=null && !type.equals("") || type!=null &&
                !type.equals("")
        ) {
            config.getRootObjectNode().set(
                    ElementUtils.getElementName(childElement, config.isRemoveNamespacePrefixes()),
                    (!config.isElementMustBeNull() ?
                            addNodeWithAttributeInfo(childElement, ElementUtils.getNodeValue(childElement, config.isTrimSpaces())) :
                            null)
            );
        } else {
            String fieldName = ElementUtils.getElementName(childElement, config.isRemoveNamespacePrefixes());
            String fieldValue = ElementUtils.getNodeValue(childElement, config.isTrimSpaces());
            if(config.getRootObjectNode().has(fieldName)) {
                JsonNode nodeValues = config.getRootObjectNode().get(fieldName);
                if(nodeValues.isArray()) {
                    ObjectNode attrInfoObjectNode = JsonNodeFactory.instance.objectNode();
                    boolean isNamespaceAdded = addNamespaceAttributeInObjectNode(config, attrInfoObjectNode, childElement, config.getNamespace());
                    if(isNamespaceAdded) {
                        attrInfoObjectNode.put(Constants.JSON_XML_TEXT_FIELD, fieldValue);
                        ((ArrayNode)nodeValues).add(!config.isElementMustBeNull() ? attrInfoObjectNode : null);
                    } else {
                        ((ArrayNode)nodeValues).add(!config.isElementMustBeNull() ? fieldValue : null);
                    }
                } else {
                    ArrayNode arrayNode = JsonNodeFactory.instance.arrayNode();
                    arrayNode.add(nodeValues);
                    arrayNode.add(!config.isElementMustBeNull() ? fieldValue: null);
                    nodeValues = arrayNode;
                }
                config.getRootObjectNode().set(fieldName, nodeValues);
            } else {
                if(fieldValue.equalsIgnoreCase("")) {
                    config.getRootObjectNode().set(fieldName, JsonNodeFactory.instance.arrayNode());
                } else {
                    if(config.isElementMustBeNull()) {
                        config.getRootObjectNode().putNull(fieldName);
                    } else {
                        ObjectNode attrInfoObjectNode = JsonNodeFactory.instance.objectNode();
                        boolean isNamespaceAdded = addNamespaceAttributeInObjectNode(config, attrInfoObjectNode, childElement, config.getNamespace());
                        if(isNamespaceAdded) {
                            attrInfoObjectNode.put(Constants.JSON_XML_TEXT_FIELD, fieldValue);
                            config.getRootObjectNode().put(fieldName, attrInfoObjectNode);
                        } else {
                            config.getRootObjectNode().put(fieldName, fieldValue);
                        }
                    }
                }
            }
        }
    }

    // transform json node with namespace
    // when rootObjectNode is not null, it will put json node on it
    // otherwise, it will return the transformed json node
    private static ObjectNode transformJsonNodeWithNamespace(XmlToJsonConfiguration config, JsonNode node, boolean useRootObjectNode) {
        AtomicReference<String> name = new AtomicReference<>("");
        ObjectNode objectNode = JsonNodeFactory.instance.objectNode();
        node.fields().forEachRemaining(entry -> {
            String label = entry.getKey();
            if(label.startsWith(Constants.JSON_XML_ATTR_PREFIX)) {
                objectNode.put(label, entry.getValue());
            } else {
                setValueUsingAttributeType(config, objectNode, entry.getValue(), Constants.JSON_XML_TEXT_FIELD, null, "");
                name.set(label);
            }
        });

        if(!useRootObjectNode || config.getRootObjectNode()==null) {
            return objectNode;
        }

        if(config.getRootObjectNode().has(name.get())) {
            addObjectToExistingFieldOnRootObjectNode(config, name.get(), objectNode, ObjectNode.class);
        } else {
            config.getRootObjectNode().put(name.get(), !config.isElementMustBeNull() ? objectNode : null);
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
    public static void addAttributesInObjectNode(XmlToJsonConfiguration config) {
        if(!config.getElement().hasAttributes()){
            return;
        }

        NamedNodeMap attrMap = config.getElement().getAttributes();
        for (int j = 0; j < attrMap.getLength(); j++) {
            Node node = attrMap.item(j);
            String attr = node.getNodeName();
            if(ElementUtils.isAnXmlnsAttribute(attr) && config.isSkipNamespaces()) {
                continue;
            }
            if(!config.isTypeHints() || config.isTypeHints() && !ElementUtils.isAnSpecialAttribute(attr)) {
                config.getRootObjectNode().put(Constants.JSON_XML_ATTR_PREFIX+node.getNodeName(), node.getNodeValue());
            }
        }
    }

    // add attributes in the object node
    public static boolean addNamespaceAttributeInObjectNode(XmlToJsonConfiguration config, ObjectNode rootObjectNode, Element childElement, String parentNamespace) {
        if(config.isSkipNamespaces() || config.getXmlnsMapOnThisNode().isEmpty()) {
            return false;
        }

        String elementNamePrefix = ElementUtils.getElementNamePrefix(childElement);
        if(Objects.equals(elementNamePrefix, parentNamespace)) {
           return false;
        }

        String namespaceLabel = XMLConstants.XMLNS_ATTRIBUTE;
        if(elementNamePrefix != null) {
            namespaceLabel += ":"+elementNamePrefix;
        }
        Namespace namespace = config.getXmlnsMapOnThisNode().get(namespaceLabel);
        if(namespace!=null && namespace.getLevel()+1>=config.getLevel()) {
            return false;
        }

        rootObjectNode.put(
                Constants.JSON_XML_ATTR_PREFIX + namespaceLabel,
                config.getXmlnsMapOnThisNode().get(namespaceLabel).getNamespace()
        );
        return true;
    }

    // set value as specified in the attribute type
    public static void setValueUsingAttributeType(
            XmlToJsonConfiguration config, ObjectNode rootObjectNode, JsonNode subElement, String label, String value, String childTypeAttr
    ) {
        if(rootObjectNode.has(label)) {
            JsonNode nodeValues = rootObjectNode.get(label);
            if(nodeValues.isArray()) {
                // ADD
                addValueIntoArrayNode(config, (ArrayNode)nodeValues, childTypeAttr, label, value, subElement);
            } else {
                ArrayNode arrayNode = JsonNodeFactory.instance.arrayNode();
                arrayNode.add(nodeValues);
                // ADD
                addValueIntoArrayNode(config, arrayNode, childTypeAttr, label, value, subElement);
                nodeValues = arrayNode;
            }
            rootObjectNode.set(label, nodeValues);
        } else {
            // PUT
            putValueOnObjectNode(config, rootObjectNode, childTypeAttr, label, value, subElement);
        }
    }

    // put value on ObjectNode
    public static void putValueOnObjectNode(
            XmlToJsonConfiguration config, ObjectNode objectNode, String type, String label, String value, JsonNode subElement
    ){
        switch (type.toLowerCase()) {
            case Constants.JSON_XML_ATTR_TYPE_NUMBER:
                objectNode.put(
                        label,
                        !config.isElementMustBeNull() ? (subElement!=null ? subElement.asInt() : Integer.parseInt(value)) : null
                );
                break;
            case Constants.JSON_XML_ATTR_TYPE_BOOLEAN:
                objectNode.put(
                        label,
                        !config.isElementMustBeNull() ?
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
                if(config.isTrimSpaces()){
                    value = (value.trim().equalsIgnoreCase(Constants.NULL_VALUE) ? null : value.trim());
                } else {
                    value = (value.equalsIgnoreCase(Constants.NULL_VALUE) ? null : value);
                }
                objectNode.put(
                        label,
                        !config.isElementMustBeNull() ? value : null
                );
                break;
        }
    }

    // add value into ArrayNode
    public static void addValueIntoArrayNode(
            XmlToJsonConfiguration config, ArrayNode arrayNode, String type, String label, String value, JsonNode subElement
    ){
        switch (type.toLowerCase()) {
            case Constants.JSON_XML_ATTR_TYPE_NUMBER:
                arrayNode.add(
                        !config.isElementMustBeNull() ?
                                subElement!=null ? subElement.asInt() : Integer.parseInt(value) :
                                null
                );
                break;
            case Constants.JSON_XML_ATTR_TYPE_BOOLEAN:
                arrayNode.add(
                        !config.isElementMustBeNull() ?
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
                if(config.isTrimSpaces()){
                    value = (value.trim().equalsIgnoreCase(Constants.NULL_VALUE) ? null : value.trim());
                } else {
                    value = (value.equalsIgnoreCase(Constants.NULL_VALUE) ? null : value);
                }
                arrayNode.add(!config.isElementMustBeNull() ? value : null);
                break;
        }
    }

    // get attribute type value from a element
    public static String getAttributeTypeFromElement(Element nodeElement) {
        if(nodeElement==null || nodeElement.getAttributes() == null) {
            return "";
        }

        NamedNodeMap attributeMap = nodeElement.getAttributes();
        for (int i = 0; i < attributeMap.getLength(); i++) {
            Node attribute = attributeMap.item(i);
            if (attribute.getNodeName().equals(Constants.JSON_XML_ATTR_TYPE)) {
                return attribute.getNodeValue();
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
            XmlToJsonConfiguration config, String field, Object value, Class<?> valueType
    ) {
        JsonNode newValue = null;
        if(valueType == ObjectNode.class || valueType == JsonNode.class) {
            newValue = (JsonNode) value;
        } else if (valueType == String.class) {
            newValue = JsonNodeFactory.instance.textNode((String) value);
        } else {
            throw new IllegalArgumentException("Unsupported value type: " + valueType);
        }

        JsonNode nodeValues = config.getRootObjectNode().get(field);
        if(!nodeValues.isArray()) {
            ArrayNode arrayNode = JsonNodeFactory.instance.arrayNode();
            arrayNode.add(nodeValues);
            nodeValues = arrayNode;
        }

        ((ArrayNode)nodeValues).add(!config.isElementMustBeNull() ? newValue : null);
        config.getRootObjectNode().set(field, nodeValues);
    }

}
