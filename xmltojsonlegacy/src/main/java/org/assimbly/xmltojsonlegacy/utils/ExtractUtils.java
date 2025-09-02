package org.assimbly.xmltojsonlegacy.utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.TextNode;
import org.assimbly.xmltojsonlegacy.XmlToJsonConfiguration;
import org.assimbly.xmltojsonlegacy.model.AttributeEntry;
import org.assimbly.xmltojsonlegacy.model.ElementMetadata;
import org.assimbly.xmltojsonlegacy.model.Namespace;
import org.assimbly.xmltojsonlegacy.service.MetadataAnalyzer;

import javax.xml.XMLConstants;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

public class ExtractUtils {

    private ExtractUtils() {}

    // extract child as other type and add into the array node
    public static void extractChildAsOtherInArrayNode(ElementMetadata metadata, JsonNode childNode) {
        if(isInternalNullObjectNodePresent(childNode)) {
            metadata.getArrayNode().addNull();
            return;
        }
        if(childNode.isArray() && !childNode.get(0).isObject() && (metadata.getArrayNode().isEmpty() ||
                !metadata.containsClassAttributeValue(Constants.JSON_XML_ATTR_TYPE_ARRAY))
        ) {
            metadata.getArrayNode().add(childNode.get(0));
        } else {
            metadata.getArrayNode().add(childNode);
        }
    }

    // extract child as other type and add into the object node
    public static void extractChildAsOtherInObjectNode(ElementMetadata metadata, ElementMetadata childMetada, XmlToJsonConfiguration config, JsonNode childNode) {
        String propertyName = ElementMetadataUtils.getElementName(childMetada, config.isRemoveNamespacePrefixes());
        int childCount = childMetada.getChildrenCount();
        switch (childNode.size()) {
            case 0:
                ArrayNode newArrayNode = JsonNodeFactory.instance.arrayNode();
                if(isInternalNullObjectNodePresent(childNode)) {
                    newArrayNode.addNull();
                }
                metadata.getObjectNode().set(propertyName, newArrayNode);
                break;
            case 1:
                if(childNode.isArray() || (childCount > 0 && (metadata.getClassAttributeValue() !=null && metadata.getClassAttributeValue().isEmpty()))) {
                    if(ElementMetadataUtils.isElementOnNamespace(metadata) && childNode.isArray()) {
                        if(metadata.getObjectNode().has(propertyName)) {
                            addObjectToExistingFieldOnRootObjectNode(metadata, propertyName, childNode.get(0), JsonNode.class);
                        } else {
                            metadata.getObjectNode().set(propertyName, !metadata.isElementMustBeNull() ? childNode.get(0) : null);
                        }
                    } else {
                        boolean simpleValueToInclude = childNode.isArray() && childNode.size() == 1 && childNode.get(0).isValueNode() && metadata.getDeepestDepth() <= 1;
                        JsonNode nodeToInclude = simpleValueToInclude ? childNode.get(0) : childNode;
                        metadata.getObjectNode().set(propertyName, !metadata.isElementMustBeNull() ? nodeToInclude : null);
                    }
                } else {
                    if(childNode.get(propertyName) != null) {
                        metadata.getObjectNode().set(propertyName, !metadata.isElementMustBeNull() ? childNode.get(propertyName) : null);
                    } else {
                        metadata.getObjectNode().set(propertyName, childNode);
                    }
                }
                break;
            default:
                if(metadata.isElementMustBeNull()) {
                    metadata.getObjectNode().set(propertyName, null);
                    return;
                }
                if(JsonUtils.isJsonNodeInOneLevelAndWithNamespace(childNode)) {
                    childNode = transformJsonNodeWithNamespace(metadata, config, childNode, false);
                }
                metadata.getObjectNode().set(propertyName, childNode);
        }
    }

    // extract child as array type
    public static void extractChildAsArray(ElementMetadata metadata, ElementMetadata childMetadata, JsonNode childNode) {
        if(childNode.isArray() && MetadataAnalyzer.isLastElement(childMetadata)) {
            for (JsonNode subElement : childNode) {
                metadata.getArrayNode().add(!metadata.isElementMustBeNull() ? subElement.asText() : null);
            }
        } else {
            metadata.getArrayNode().add(!metadata.isElementMustBeNull() ? childNode : null);
        }
    }

    // extract child as object type
    public static void extractChildAsObject(ElementMetadata metadata, ElementMetadata childMetadata, XmlToJsonConfiguration config, JsonNode childNode) {
        if(config.isTypeHints()) {
            extractChildAsObjectWithTypeHints(metadata, childMetadata, config, childNode);
        } else {
            extractChildAsObjectWithoutTypeHints(metadata, childMetadata, config);
        }
    }

    // extract child as object type with type hints enabled
    private static void extractChildAsObjectWithTypeHints(ElementMetadata metadata, ElementMetadata childMetadata, XmlToJsonConfiguration config, JsonNode childNode) {
        if(childNode.isEmpty()) {
            if(MetadataAnalyzer.isElementAttributeNull(childMetadata, Constants.JSON_XML_ATTR_TYPE) && MetadataAnalyzer.isElementNodeValueNull(childMetadata)) {
                setEmptyArrayNodeInRootObjectNode(metadata.getObjectNode(), childMetadata.getName());
            }
        } else {
            if(JsonUtils.isJsonNodeInOneLevelAndWithNamespace(childNode)) {
                transformJsonNodeWithNamespace(metadata, config, childNode, true);
            } else {
                for (JsonNode subElement : childNode) {
                    if(childNode.fields().hasNext()) {
                        childNode.fields().forEachRemaining(entry -> {
                            String label = entry.getKey();
                            String childTypeAttr = childMetadata.getTypeAttributeValue();
                            setValueUsingAttributeType(metadata, config, metadata.getObjectNode(), subElement, label, null, childTypeAttr);
                        });
                    } else {
                        String fieldName = ElementMetadataUtils.getElementName(childMetadata, config.isRemoveNamespacePrefixes());
                        String fieldValue = ElementMetadataUtils.getNodeValue(childMetadata, config.isTrimSpaces());
                        if(metadata.getObjectNode().has(fieldName)) {
                            addObjectToExistingFieldOnRootObjectNode(metadata, fieldName, fieldValue, String.class);
                        } else {
                            if(fieldValue.equalsIgnoreCase("")) {
                                metadata.getObjectNode().set(fieldName, JsonNodeFactory.instance.arrayNode());
                            } else {
                                metadata.getObjectNode().put(fieldName, !metadata.isElementMustBeNull() ? fieldValue : null);
                            }
                        }
                    }
                }
            }
        }
    }

    // extract child as object type without type hints enabled
    private static void extractChildAsObjectWithoutTypeHints(ElementMetadata metadata, ElementMetadata childMetadata, XmlToJsonConfiguration config) {
        String type = childMetadata.getTypeAttributeValue();
        if(metadata.containsClassAttribute() && !metadata.containsClassAttributeValue("") && type!=null && !type.equals("") || type!=null &&
                !type.equals("")
        ) {
            metadata.getObjectNode().set(
                    ElementMetadataUtils.getElementName(childMetadata, config.isRemoveNamespacePrefixes()),
                    (!metadata.isElementMustBeNull() ?
                            addNodeWithAttributeInfo(childMetadata, ElementMetadataUtils.getNodeValue(childMetadata, config.isTrimSpaces())) :
                            null)
            );
        } else {
            String fieldName = ElementMetadataUtils.getElementName(childMetadata, config.isRemoveNamespacePrefixes());
            String fieldValue = ElementMetadataUtils.getNodeValue(childMetadata, config.isTrimSpaces());
            if(metadata.getObjectNode().has(fieldName)) {
                JsonNode nodeValues = metadata.getObjectNode().get(fieldName);
                if(nodeValues.isArray()) {
                    ObjectNode attrInfoObjectNode = JsonNodeFactory.instance.objectNode();
                    boolean isNamespaceAdded = addNamespaceAttributeInObjectNode(metadata, childMetadata, config, attrInfoObjectNode, metadata.getNamespacePrefix());
                    if(isNamespaceAdded) {
                        attrInfoObjectNode.put(Constants.JSON_XML_TEXT_FIELD, fieldValue);
                        ((ArrayNode)nodeValues).add(!metadata.isElementMustBeNull() ? attrInfoObjectNode : null);
                    } else {
                        ((ArrayNode)nodeValues).add(!metadata.isElementMustBeNull() ? fieldValue : null);
                    }
                } else {
                    ArrayNode arrayNode = JsonNodeFactory.instance.arrayNode();
                    arrayNode.add(nodeValues);
                    arrayNode.add(!metadata.isElementMustBeNull() ? fieldValue: null);
                    nodeValues = arrayNode;
                }
                metadata.getObjectNode().set(fieldName, nodeValues);
            } else {
                if(fieldValue.equalsIgnoreCase("")) {
                    metadata.getObjectNode().set(fieldName, JsonNodeFactory.instance.arrayNode());
                } else {
                    if(metadata.isElementMustBeNull()) {
                        metadata.getObjectNode().putNull(fieldName);
                    } else {
                        ObjectNode attrInfoObjectNode = JsonNodeFactory.instance.objectNode();
                        boolean isNamespaceAdded = addNamespaceAttributeInObjectNode(metadata, childMetadata, config, attrInfoObjectNode, metadata.getNamespacePrefix());
                        if(isNamespaceAdded) {
                            attrInfoObjectNode.put(Constants.JSON_XML_TEXT_FIELD, fieldValue);
                            metadata.getObjectNode().set(fieldName, attrInfoObjectNode);
                        } else {
                            metadata.getObjectNode().put(fieldName, fieldValue);
                        }
                    }
                }
            }
        }
    }

    // transform json node with namespace
    // when rootObjectNode is not null, it will put json node on it
    // otherwise, it will return the transformed json node
    private static ObjectNode transformJsonNodeWithNamespace(ElementMetadata metadata, XmlToJsonConfiguration config, JsonNode node, boolean useRootObjectNode) {
        AtomicReference<String> name = new AtomicReference<>("");
        ObjectNode objectNode = JsonNodeFactory.instance.objectNode();
        node.fields().forEachRemaining(entry -> {
            String label = entry.getKey();
            if(label.startsWith(Constants.JSON_XML_ATTR_PREFIX)) {
                objectNode.set(label, entry.getValue());
            } else {
                setValueUsingAttributeType(metadata, config, objectNode, entry.getValue(), Constants.JSON_XML_TEXT_FIELD, null, "");
                name.set(label);
            }
        });

        if(!useRootObjectNode || metadata.getObjectNode()==null) {
            return objectNode;
        }

        if(metadata.getObjectNode().has(name.get())) {
            addObjectToExistingFieldOnRootObjectNode(metadata, name.get(), objectNode, ObjectNode.class);
        } else {
            metadata.getObjectNode().set(name.get(), !metadata.isElementMustBeNull() ? objectNode : null);
        }

        return null;
    }

    // add node with attribute information
    private static JsonNode addNodeWithAttributeInfo(ElementMetadata metadata, String value) {
        ObjectNode attrInfoObjectNode = JsonNodeFactory.instance.objectNode();

        if(!metadata.getAttributes().isEmpty()){
            for (Map.Entry<String, AttributeEntry> entry : metadata.getAttributes().entrySet()) {
                String attrName = entry.getKey();
                AttributeEntry attribute = entry.getValue();
                attrInfoObjectNode.put(Constants.JSON_XML_ATTR_PREFIX + attrName, attribute.getValue());
            }
        }
        attrInfoObjectNode.put(Constants.JSON_XML_TEXT_FIELD, value.equalsIgnoreCase(Constants.NULL_VALUE) ? null : value);

        return attrInfoObjectNode;
    }

    // set value as specified in the attribute type
    public static void setValueUsingAttributeType(
            ElementMetadata metadata,
            XmlToJsonConfiguration config, ObjectNode rootObjectNode, JsonNode subElement,
            String label, String value, String childTypeAttr
    ) {
        if(rootObjectNode.has(label)) {
            JsonNode nodeValues = rootObjectNode.get(label);
            if(nodeValues.isArray()) {
                // ADD
                addValueIntoArrayNode(metadata, config, (ArrayNode)nodeValues, childTypeAttr, value, subElement);
            } else {
                ArrayNode arrayNode = JsonNodeFactory.instance.arrayNode();
                arrayNode.add(nodeValues);
                // ADD
                addValueIntoArrayNode(metadata, config, arrayNode, childTypeAttr, value, subElement);
                nodeValues = arrayNode;
            }
            rootObjectNode.set(label, nodeValues);
        } else {
            // PUT
            putValueOnObjectNode(metadata, config, rootObjectNode, childTypeAttr, label, value, subElement);
        }
    }

    // put value on ObjectNode
    public static void putValueOnObjectNode(
            ElementMetadata metadata, XmlToJsonConfiguration config, ObjectNode objectNode, String type, String label, String value, JsonNode subElement
    ){
        switch (type.toLowerCase()) {
            case Constants.JSON_XML_ATTR_TYPE_NUMBER:
                if (metadata.isElementMustBeNull()) {
                    objectNode.putNull(label);
                    break;
                }
                if (subElement == null) {
                    if(isInteger(value)) {
                        objectNode.put(label, Integer.parseInt(value));
                    } else if(isDouble(value)) {
                        objectNode.put(label, Double.parseDouble(value));
                    } else {
                        objectNode.putNull(label);
                    }
                    break;
                }
                if(isInteger(subElement.asText())) {
                    objectNode.put(label, subElement.asInt());
                } else if(isDouble(subElement.asText())) {
                    objectNode.put(label, subElement.asDouble());
                } else {
                    objectNode.putNull(label);
                }
                break;
            case Constants.JSON_XML_ATTR_TYPE_BOOLEAN:
                boolean bolValue;
                if(subElement!=null) {
                    bolValue = subElement.asBoolean();
                } else {
                    bolValue = Boolean.parseBoolean(value);
                }
                objectNode.put(label, !metadata.isElementMustBeNull() ? bolValue : null);
                break;
            case Constants.JSON_XML_ATTR_TYPE_ARRAY, Constants.JSON_XML_ATTR_TYPE_OBJECT:
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
                        !metadata.isElementMustBeNull() ? value : null
                );
                break;
        }
    }

    // add value into ArrayNode
    public static void addValueIntoArrayNode(
            ElementMetadata metadata, XmlToJsonConfiguration config, ArrayNode arrayNode, String type, String value, JsonNode subElement
    ){
        switch (type.toLowerCase()) {
            case Constants.JSON_XML_ATTR_TYPE_NUMBER:
                if (metadata.isElementMustBeNull()) {
                    arrayNode.addNull();
                    break;
                }
                if (subElement == null) {
                    if(isInteger(value)) {
                        arrayNode.add(Integer.parseInt(value));
                    } else if(isDouble(value)) {
                        arrayNode.add(Double.parseDouble(value));
                    } else {
                        arrayNode.addNull();
                    }
                    break;
                }
                if(isInteger(subElement.asText())) {
                    arrayNode.add(subElement.asInt());
                } else if(isDouble(subElement.asText())) {
                    arrayNode.add(subElement.asDouble());
                } else {
                    arrayNode.addNull();
                }
                break;
            case Constants.JSON_XML_ATTR_TYPE_BOOLEAN:
                boolean bolValue;
                if(subElement!=null) {
                    bolValue = subElement.asBoolean();
                } else {
                    bolValue = Boolean.parseBoolean(value);
                }
                arrayNode.add(!metadata.isElementMustBeNull() ? bolValue : null);
                break;
            case Constants.JSON_XML_ATTR_TYPE_ARRAY, Constants.JSON_XML_ATTR_TYPE_OBJECT:
                // do nothing
                break;
            default:
                value = (subElement!=null ? subElement.asText() : value);
                if(config.isTrimSpaces()){
                    value = (value.trim().equalsIgnoreCase(Constants.NULL_VALUE) ? null : value.trim());
                } else {
                    value = (value.equalsIgnoreCase(Constants.NULL_VALUE) ? null : value);
                }
                arrayNode.add(!metadata.isElementMustBeNull() ? value : null);
                break;
        }
    }

    // get attribute type value from a element
    public static String getAttributeTypeFromElement(ElementMetadata metadata) {
        if(metadata==null || metadata.getTypeAttributeValue() == null) {
            return "";
        }

        return metadata.getTypeAttributeValue();
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
            ElementMetadata metadata, String field, Object value, Class<?> valueType
    ) {
        JsonNode newValue = null;
        if(valueType == ObjectNode.class || valueType == JsonNode.class) {
            newValue = (JsonNode) value;
        } else if (valueType == String.class) {
            newValue = JsonNodeFactory.instance.textNode((String) value);
        } else {
            throw new IllegalArgumentException("Unsupported value type: " + valueType);
        }

        JsonNode nodeValues = metadata.getObjectNode().get(field);
        if(!nodeValues.isArray()) {
            ArrayNode arrayNode = JsonNodeFactory.instance.arrayNode();
            arrayNode.add(nodeValues);
            nodeValues = arrayNode;
        }

        ((ArrayNode)nodeValues).add(!metadata.isElementMustBeNull() ? newValue : null);
        metadata.getObjectNode().set(field, nodeValues);
    }

    public static void addValueOnRootArrayNode(ElementMetadata metadata, XmlToJsonConfiguration config) {
        JsonNode valueAsJson = JsonUtils.getValidJson(metadata.getTextContent());
        if(valueAsJson!=null) {
            if(valueAsJson.isArray()) {
                metadata.setArrayNode((ArrayNode) valueAsJson);
                metadata.setRootArray(true);
            } else {
                metadata.setObjectNode((ObjectNode) valueAsJson);
                metadata.setRootArray(false);
            }
        } else {
            String valueAsStr = ElementMetadataUtils.getNodeValue(metadata, config.isTrimSpaces());
            metadata.getArrayNode().add(valueAsStr);
        }
    }

    public static void putValueOnRootObjectNode(ElementMetadata metadata, XmlToJsonConfiguration config) {
        JsonNode valueAsJson = JsonUtils.getValidJson(metadata.getTextContent());
        if(valueAsJson!=null) {
            metadata.getObjectNode().set(Constants.JSON_XML_TEXT_FIELD, valueAsJson);
        } else {
            String valueAsStr = ElementMetadataUtils.getNodeValue(metadata, config.isTrimSpaces());
            metadata.getObjectNode().put(Constants.JSON_XML_TEXT_FIELD, valueAsStr);
        }
    }

    private static boolean isInteger(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static boolean isDouble(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    // add attributes in the object node
    public static void addAttributesInObjectNode(ElementMetadata metadata, XmlToJsonConfiguration config) {

        if(metadata.getAttributes().isEmpty() && !metadata.isDefinesNamespaces() ||
                config.isTypeHints() && metadata.isOneValue() && metadata.isHasTypeNumberOrBoolean()
        ){
            return;
        }

        if(!config.isSkipNamespaces() && metadata.isDefinesNamespaces()) {
            // include namespaces on objectNode
            Map<String, Namespace> namespaceMap = metadata.getDefinedNamespaces();
            for (Map.Entry<String, Namespace> entry : namespaceMap.entrySet()) {
                String prefix = entry.getKey();
                Namespace namespace = entry.getValue();
                metadata.getObjectNode().put(Constants.JSON_XML_ATTR_PREFIX+prefix, namespace.getNamespace());
            }
        }

        if(metadata.getAttributes().isEmpty()){
            return;
        }

        // include attributes on objectNode
        Map<String, AttributeEntry> attributeEntryMap = metadata.getAttributes();
        for (Map.Entry<String, AttributeEntry> entry : attributeEntryMap.entrySet()) {
            String attrName = entry.getKey();
            AttributeEntry attribute = entry.getValue();

            if(!config.isTypeHints() || config.isTypeHints() && !ElementMetadataUtils.isAnSpecialAttribute(attrName)) {
                metadata.getObjectNode().put(Constants.JSON_XML_ATTR_PREFIX+attrName, attribute.getValue());
            }
        }
    }

    // add attributes in the object node
    public static boolean addNamespaceAttributeInObjectNode(ElementMetadata metadata, ElementMetadata childMetadata, XmlToJsonConfiguration config, ObjectNode rootObjectNode, String parentNamespacePrefix) {
        if(config.isSkipNamespaces() || metadata.getNamespaces().isEmpty()) {
            return false;
        }

        if(childMetadata == null) {
            childMetadata = metadata;
        }

        if(Objects.equals(childMetadata.getNamespacePrefix(), parentNamespacePrefix)) {
            return false;
        }

        String namespaceLabel = XMLConstants.XMLNS_ATTRIBUTE;
        if(childMetadata.getNamespacePrefix() != null) {
            namespaceLabel += ":"+childMetadata.getNamespacePrefix();
        }
        Namespace namespace = metadata.getNamespaces().get(namespaceLabel);
        if(namespace!=null && namespace.getLevel()+1>=metadata.getLevel()) {
            return false;
        }

        rootObjectNode.put(
                Constants.JSON_XML_ATTR_PREFIX + namespaceLabel,
                metadata.getNamespaces().get(namespaceLabel).getNamespace()
        );
        return true;
    }
}
