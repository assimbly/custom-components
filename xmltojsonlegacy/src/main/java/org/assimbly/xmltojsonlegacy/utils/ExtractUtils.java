package org.assimbly.xmltojsonlegacy.utils;

import tools.jackson.databind.JsonNode;
import tools.jackson.databind.node.*;
import org.assimbly.xmltojsonlegacy.XmlToJsonConfiguration;
import org.assimbly.xmltojsonlegacy.model.AttributeEntry;
import org.assimbly.xmltojsonlegacy.model.ElementMetadata;
import org.assimbly.xmltojsonlegacy.model.Namespace;
import org.assimbly.xmltojsonlegacy.service.MetadataAnalyzer;

import javax.xml.XMLConstants;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

public class ExtractUtils {

    private ExtractUtils() {}

    // -------------------------------------------------------------------------
    // Public extract methods
    // -------------------------------------------------------------------------

    public static void extractChildAsOtherInArrayNode(ElementMetadata metadata, JsonNode childNode) {
        if (isInternalNullObjectNodePresent(childNode)) {
            metadata.getArrayNode().addNull();
            return;
        }
        boolean isUnwrappableArray = childNode.isArray() && !childNode.get(0).isObject()
                && (metadata.getArrayNode().isEmpty() || !metadata.containsClassAttributeValue(Constants.JSON_XML_ATTR_TYPE_ARRAY));
        metadata.getArrayNode().add(isUnwrappableArray ? childNode.get(0) : childNode);
    }

    public static void extractChildAsOtherInObjectNode(ElementMetadata metadata, ElementMetadata childMetadata, XmlToJsonConfiguration config, JsonNode childNode) {
        String propertyName = ElementMetadataUtils.getElementName(childMetadata, config.isRemoveNamespacePrefixes());
        switch (childNode.size()) {
            case 0  -> extractChildAsOtherSize0(metadata, propertyName, childNode);
            case 1  -> extractChildAsOtherSize1(metadata, childMetadata, childNode, propertyName);
            default -> extractChildAsOtherSizeN(metadata, config, childNode, propertyName);
        }
    }

    public static void extractChildAsArray(ElementMetadata metadata, ElementMetadata childMetadata, JsonNode childNode) {
        if (childNode.isArray() && MetadataAnalyzer.isLastElement(childMetadata)) {
            for (JsonNode subElement : childNode)
                metadata.getArrayNode().add(!metadata.isElementMustBeNull() ? subElement.asString() : null);
        } else {
            metadata.getArrayNode().add(!metadata.isElementMustBeNull() ? childNode : null);
        }
    }

    public static void extractChildAsObject(ElementMetadata metadata, ElementMetadata childMetadata, XmlToJsonConfiguration config, JsonNode childNode) {
        if (config.isTypeHints())
            extractChildAsObjectWithTypeHints(metadata, childMetadata, config, childNode);
        else
            extractChildAsObjectWithoutTypeHints(metadata, childMetadata, config);
    }

    // -------------------------------------------------------------------------
    // extractChildAsOtherInObjectNode helpers (by childNode size)
    // -------------------------------------------------------------------------

    private static void extractChildAsOtherSize0(ElementMetadata metadata, String propertyName, JsonNode childNode) {
        ArrayNode newArrayNode = JsonNodeFactory.instance.arrayNode();
        if (isInternalNullObjectNodePresent(childNode))
            newArrayNode.addNull();
        metadata.getObjectNode().set(propertyName, newArrayNode);
    }

    private static void extractChildAsOtherSize1(ElementMetadata metadata, ElementMetadata childMetadata, JsonNode childNode, String propertyName) {
        int childCount = childMetadata.getChildrenCount();
        if (childNode.isArray() || (childCount > 0 && isEmptyClassAttribute(metadata))) {
            extractChildAsOtherSize1Array(metadata, childNode, propertyName);
        } else {
            extractChildAsOtherSize1Object(metadata, childNode, propertyName);
        }
    }

    private static void extractChildAsOtherSize1Array(ElementMetadata metadata, JsonNode childNode, String propertyName) {
        if (ElementMetadataUtils.isElementOnNamespace(metadata) && childNode.isArray()) {
            if (metadata.getObjectNode().has(propertyName))
                addObjectToExistingFieldOnRootObjectNode(metadata, propertyName, childNode.get(0));
            else
                metadata.getObjectNode().set(propertyName, !metadata.isElementMustBeNull() ? childNode.get(0) : null);
        } else {
            boolean simpleValue = childNode.isArray() && childNode.size() == 1 && childNode.get(0).isValueNode() && metadata.getDeepestDepth() <= 1;
            JsonNode nodeToSet = simpleValue ? childNode.get(0) : childNode;
            metadata.getObjectNode().set(propertyName, !metadata.isElementMustBeNull() ? nodeToSet : null);
        }
    }

    private static void extractChildAsOtherSize1Object(ElementMetadata metadata, JsonNode childNode, String propertyName) {
        JsonNode valueNode = childNode.get(propertyName);
        JsonNode existingNode = metadata.getObjectNode().get(propertyName);
        if (valueNode != null && !valueNode.isMissingNode()) {
            if (existingNode != null && !existingNode.isMissingNode()) {
                // merge into array
                ArrayNode arrayNode = JsonNodeFactory.instance.arrayNode();
                arrayNode.add(existingNode);
                arrayNode.add(valueNode);
                metadata.getObjectNode().set(propertyName, arrayNode);
            } else {
                metadata.getObjectNode().set(propertyName, metadata.isElementMustBeNull() ? NullNode.instance : valueNode);
            }
        } else {
            metadata.getObjectNode().set(propertyName, childNode);
        }
    }

    private static void extractChildAsOtherSizeN(ElementMetadata metadata, XmlToJsonConfiguration config, JsonNode childNode, String propertyName) {
        if (metadata.isElementMustBeNull()) {
            metadata.getObjectNode().putNull(propertyName);
            return;
        }
        if (JsonUtils.isJsonNodeInOneLevelAndWithNamespace(childNode))
            childNode = transformJsonNodeWithNamespace(metadata, config, childNode, false);
        metadata.getObjectNode().set(propertyName, childNode);
    }

    private static boolean isEmptyClassAttribute(ElementMetadata metadata) {
        return metadata.getClassAttributeValue() != null && metadata.getClassAttributeValue().isEmpty();
    }

    // -------------------------------------------------------------------------
    // extractChildAsObject helpers
    // -------------------------------------------------------------------------

    private static void extractChildAsObjectWithTypeHints(ElementMetadata metadata, ElementMetadata childMetadata, XmlToJsonConfiguration config, JsonNode childNode) {
        if (childNode.isEmpty()) {
            handleEmptyChildNodeWithTypeHints(metadata, childMetadata);
        } else if (JsonUtils.isJsonNodeInOneLevelAndWithNamespace(childNode)) {
            transformJsonNodeWithNamespace(metadata, config, childNode, true);
        } else {
            iterateChildNodeWithTypeHints(metadata, childMetadata, config, childNode);
        }
    }

    private static void handleEmptyChildNodeWithTypeHints(ElementMetadata metadata, ElementMetadata childMetadata) {
        if (MetadataAnalyzer.isElementAttributeNull(childMetadata, Constants.JSON_XML_ATTR_TYPE)
                && MetadataAnalyzer.isElementNodeValueNull(childMetadata))
            setEmptyArrayNodeInRootObjectNode(metadata.getObjectNode(), childMetadata.getName());
    }

    private static void iterateChildNodeWithTypeHints(ElementMetadata metadata, ElementMetadata childMetadata, XmlToJsonConfiguration config, JsonNode childNode) {
        for (JsonNode subElement : childNode) {
            if (childNode.properties().iterator().hasNext()) {
                childNode.properties().iterator().forEachRemaining(entry ->
                        setValueUsingAttributeType(metadata, config, metadata.getObjectNode(), subElement, entry.getKey(), null, childMetadata.getTypeAttributeValue())
                );
            } else {
                setFieldFromChildMetadata(metadata, childMetadata, config);
            }
        }
    }

    private static void setFieldFromChildMetadata(ElementMetadata metadata, ElementMetadata childMetadata, XmlToJsonConfiguration config) {
        String fieldName = ElementMetadataUtils.getElementName(childMetadata, config.isRemoveNamespacePrefixes());
        String fieldValue = ElementMetadataUtils.getNodeValue(childMetadata, config.isTrimSpaces());
        if (metadata.getObjectNode().has(fieldName)) {
            addObjectToExistingFieldOnRootObjectNode(metadata, fieldName, fieldValue);
        } else if (fieldValue == null || fieldValue.isEmpty()) {
            metadata.getObjectNode().putNull(fieldName);
        } else {
            metadata.getObjectNode().put(fieldName, !metadata.isElementMustBeNull() ? fieldValue : null);
        }
    }

    private static void extractChildAsObjectWithoutTypeHints(ElementMetadata metadata, ElementMetadata childMetadata, XmlToJsonConfiguration config) {
        String type = childMetadata.getTypeAttributeValue();
        if (hasNonEmptyType(metadata, type))
            setFieldWithAttributeInfo(metadata, childMetadata, config);
        else
            setFieldWithoutAttributeInfo(metadata, childMetadata, config);
    }

    private static boolean hasNonEmptyType(ElementMetadata metadata, String type) {
        return type != null && !type.isEmpty();
    }

    private static void setFieldWithAttributeInfo(ElementMetadata metadata, ElementMetadata childMetadata, XmlToJsonConfiguration config) {
        metadata.getObjectNode().set(
                ElementMetadataUtils.getElementName(childMetadata, config.isRemoveNamespacePrefixes()),
                !metadata.isElementMustBeNull() ? addNodeWithAttributeInfo(childMetadata, ElementMetadataUtils.getNodeValue(childMetadata, config.isTrimSpaces())) : null
        );
    }

    private static void setFieldWithoutAttributeInfo(ElementMetadata metadata, ElementMetadata childMetadata, XmlToJsonConfiguration config) {
        String fieldName = ElementMetadataUtils.getElementName(childMetadata, config.isRemoveNamespacePrefixes());
        String fieldValue = ElementMetadataUtils.getNodeValue(childMetadata, config.isTrimSpaces());

        if (fieldValue.isEmpty()) {
            metadata.getObjectNode().set(fieldName, JsonNodeFactory.instance.arrayNode());
            return;
        }

        if (metadata.getObjectNode().has(fieldName))
            mergeFieldIntoArray(metadata, childMetadata, config, fieldName, fieldValue);
        else
            putNewField(metadata, childMetadata, config, fieldName, fieldValue);
    }

    private static void mergeFieldIntoArray(ElementMetadata metadata, ElementMetadata childMetadata, XmlToJsonConfiguration config, String fieldName, String fieldValue) {
        JsonNode nodeValues = metadata.getObjectNode().get(fieldName);
        if (nodeValues.isArray()) {
            ObjectNode attrNode = JsonNodeFactory.instance.objectNode();
            boolean nsAdded = addNamespaceAttributeInObjectNode(metadata, childMetadata, config, attrNode, metadata.getNamespacePrefix());
            if (nsAdded) {
                if(fieldValue == null || fieldValue.isEmpty()) attrNode.putNull(Constants.JSON_XML_TEXT_FIELD);
                else attrNode.put(Constants.JSON_XML_TEXT_FIELD, fieldValue);
                ((ArrayNode) nodeValues).add(!metadata.isElementMustBeNull() ? attrNode : null);
            }
            else {
                if(fieldValue == null || fieldValue.isEmpty()) ((ArrayNode) nodeValues).addNull();
                else ((ArrayNode) nodeValues).add(!metadata.isElementMustBeNull() ? fieldValue : null);
            }
        } else {
            ArrayNode arrayNode = JsonNodeFactory.instance.arrayNode();
            arrayNode.add(nodeValues);
            if(fieldValue == null || fieldValue.isEmpty()) arrayNode.addNull();
            else arrayNode.add(!metadata.isElementMustBeNull() ? fieldValue : null);
            nodeValues = arrayNode;
        }
        metadata.getObjectNode().set(fieldName, nodeValues);
    }

    private static void putNewField(ElementMetadata metadata, ElementMetadata childMetadata, XmlToJsonConfiguration config, String fieldName, String fieldValue) {
        if (metadata.getObjectNode().has(fieldName)) return;
        if (fieldValue == null || fieldValue.isEmpty()) {
            metadata.getObjectNode().putNull(fieldName);
        } else if (metadata.isElementMustBeNull()) {
            metadata.getObjectNode().putNull(fieldName);
        } else {
            ObjectNode attrNode = JsonNodeFactory.instance.objectNode();
            boolean nsAdded = addNamespaceAttributeInObjectNode(metadata, childMetadata, config, attrNode, metadata.getNamespacePrefix());
            if (nsAdded) {
                attrNode.put(Constants.JSON_XML_TEXT_FIELD, fieldValue);
                metadata.getObjectNode().set(fieldName, attrNode);
            }
            else {
                metadata.getObjectNode().put(fieldName, fieldValue);
            }
        }
    }

    // -------------------------------------------------------------------------
    // Namespace / transform helpers
    // -------------------------------------------------------------------------

    private static ObjectNode transformJsonNodeWithNamespace(ElementMetadata metadata, XmlToJsonConfiguration config, JsonNode node, boolean useRootObjectNode) {
        AtomicReference<String> name = new AtomicReference<>("");
        ObjectNode objectNode = JsonNodeFactory.instance.objectNode();
        node.properties().iterator().forEachRemaining(entry -> populateTransformedNode(metadata, config, objectNode, entry, name));
        if (!useRootObjectNode || metadata.getObjectNode() == null) return objectNode;
        placeTransformedNodeOnRoot(metadata, name.get(), objectNode);
        return null;
    }

    private static void populateTransformedNode(ElementMetadata metadata, XmlToJsonConfiguration config, ObjectNode objectNode, Map.Entry<String, JsonNode> entry, AtomicReference<String> name) {
        String label = entry.getKey();
        if (label.startsWith(Constants.JSON_XML_ATTR_PREFIX))
            objectNode.set(label, entry.getValue());
        else {
            setValueUsingAttributeType(metadata, config, objectNode, entry.getValue(), Constants.JSON_XML_TEXT_FIELD, null, "");
            name.set(label);
        }
    }

    private static void placeTransformedNodeOnRoot(ElementMetadata metadata, String name, ObjectNode objectNode) {
        if (metadata.getObjectNode().has(name))
            addObjectToExistingFieldOnRootObjectNode(metadata, name, objectNode);
        else
            metadata.getObjectNode().set(name, !metadata.isElementMustBeNull() ? objectNode : null);
    }

    // -------------------------------------------------------------------------
    // setValueUsingAttributeType / put+add value helpers
    // -------------------------------------------------------------------------

    // Logic to determine how to set the value based on type hints and presence of attributes
    public static void setValueUsingAttributeType(ElementMetadata metadata, XmlToJsonConfiguration config, ObjectNode rootObjectNode, JsonNode subElement, String label, String value, String childTypeAttr) {
        if (rootObjectNode.has(label)) {
            JsonNode nodeValues = rootObjectNode.get(label);
            ArrayNode arrayNode = nodeValues.isArray() ? (ArrayNode) nodeValues : wrapInArray(nodeValues);
            addValueIntoArrayNode(metadata, config, arrayNode, childTypeAttr, value, subElement);
            rootObjectNode.set(label, arrayNode);
        } else {
            putValueOnObjectNode(metadata, config, rootObjectNode, childTypeAttr, label, value, subElement);
        }
    }

    private static ArrayNode wrapInArray(JsonNode node) {
        ArrayNode arrayNode = JsonNodeFactory.instance.arrayNode();
        arrayNode.add(node);
        return arrayNode;
    }

    public static void putValueOnObjectNode(ElementMetadata metadata, XmlToJsonConfiguration config, ObjectNode objectNode, String type, String label, String value, JsonNode subElement) {
        if(type == null) type = "";
        switch (type.toLowerCase()) {
            case Constants.JSON_XML_ATTR_TYPE_NUMBER  -> putNumberOnObjectNode(metadata, objectNode, label, value, subElement);
            case Constants.JSON_XML_ATTR_TYPE_BOOLEAN -> {
                if (metadata.isElementMustBeNull()) objectNode.putNull(label);
                else objectNode.put(label, resolveBoolean(subElement, value));
            }
            case Constants.JSON_XML_ATTR_TYPE_ARRAY, Constants.JSON_XML_ATTR_TYPE_OBJECT -> { /* do nothing */ }
            default -> {
                String resolved = !metadata.isElementMustBeNull() ? resolveStringValue(config, subElement, value) : null;
                if (resolved == null) {
                    objectNode.putNull(label);
                } else {
                    objectNode.put(label, resolved);
                }
            }
        }
    }

    public static void addValueIntoArrayNode(ElementMetadata metadata, XmlToJsonConfiguration config, ArrayNode arrayNode, String type, String value, JsonNode subElement) {
        if(type == null) type = "";
        switch (type.toLowerCase()) {
            case Constants.JSON_XML_ATTR_TYPE_NUMBER  -> addNumberIntoArrayNode(metadata, arrayNode, value, subElement);
            case Constants.JSON_XML_ATTR_TYPE_BOOLEAN -> {
                if (metadata.isElementMustBeNull()) arrayNode.addNull();
                else arrayNode.add(resolveBoolean(subElement, value));
            }
            case Constants.JSON_XML_ATTR_TYPE_ARRAY, Constants.JSON_XML_ATTR_TYPE_OBJECT -> { /* do nothing */ }
            default -> {
                String resolved = !metadata.isElementMustBeNull() ? resolveStringValue(config, subElement, value) : null;
                if (resolved == null) arrayNode.addNull();
                else arrayNode.add(resolved);
            }
        }
    }

    private static void putNumberOnObjectNode(ElementMetadata metadata, ObjectNode objectNode, String label, String value, JsonNode subElement) {
        if (metadata.isElementMustBeNull()) { objectNode.putNull(label); return; }
        String raw = subElement != null ? subElement.asString() : value;
        if (raw == null || raw.isEmpty()) { objectNode.putNull(label); return; }
        if      (isInteger(raw)) objectNode.put(label, subElement != null ? subElement.asInt()    : Integer.parseInt(raw));
        else if (isDouble(raw))  objectNode.put(label, subElement != null ? subElement.asDouble() : Double.parseDouble(raw));
        else                     objectNode.putNull(label);
    }

    private static void addNumberIntoArrayNode(ElementMetadata metadata, ArrayNode arrayNode, String value, JsonNode subElement) {
        if (metadata.isElementMustBeNull()) { arrayNode.addNull(); return; }
        String raw = subElement != null ? subElement.asString() : value;
        if (raw == null || raw.isEmpty()) { arrayNode.addNull(); return; }
        if      (isInteger(raw)) arrayNode.add(subElement != null ? subElement.asInt()    : Integer.parseInt(raw));
        else if (isDouble(raw))  arrayNode.add(subElement != null ? subElement.asDouble() : Double.parseDouble(raw));
        else                     arrayNode.addNull();
    }

    private static boolean resolveBoolean(JsonNode subElement, String value) {
        return subElement != null ? subElement.asBoolean() : Boolean.parseBoolean(value);
    }

    private static String resolveStringValue(XmlToJsonConfiguration config, JsonNode subElement, String value) {
        String raw = subElement != null ? subElement.asString() : value;
        if (raw == null || raw.isEmpty()) return null;

        if (config.isTrimSpaces()) {
            String trimmed = raw.trim();
            if (trimmed.isEmpty() || trimmed.equalsIgnoreCase(Constants.NULL_VALUE)) return null;
            return trimmed;
        }
        return raw.equalsIgnoreCase(Constants.NULL_VALUE) ? null : raw;
    }

    // -------------------------------------------------------------------------
    // Attribute / namespace helpers
    // -------------------------------------------------------------------------

    public static void addAttributesInObjectNode(ElementMetadata metadata, XmlToJsonConfiguration config) {
        if (metadata.getAttributes().isEmpty() && !metadata.isDefinesNamespaces()) return;
        if (!config.isSkipNamespaces() && metadata.isDefinesNamespaces())
            addNamespacesToObjectNode(metadata);
        if (!metadata.getAttributes().isEmpty() &&
                (!config.isTypeHints() || !metadata.containsClassAttributeValue(Constants.JSON_XML_ATTR_TYPE_ARRAY))
        ) {
            addAttributeEntriesToObjectNode(metadata, config);
        }
    }

    private static void addNamespacesToObjectNode(ElementMetadata metadata) {
        for (Map.Entry<String, Namespace> entry : metadata.getDefinedNamespaces().entrySet())
            metadata.getObjectNode().put(Constants.JSON_XML_ATTR_PREFIX + entry.getKey(), entry.getValue().getNamespace());
    }

    private static void addAttributeEntriesToObjectNode(ElementMetadata metadata, XmlToJsonConfiguration config) {
        for (Map.Entry<String, AttributeEntry> entry : metadata.getAttributes().entrySet()) {
            String attrName = entry.getKey();
            if (!config.isTypeHints() || !ElementMetadataUtils.isAnSpecialAttribute(attrName))
                metadata.getObjectNode().put(Constants.JSON_XML_ATTR_PREFIX + attrName, entry.getValue().value());
        }
    }

    public static boolean addNamespaceAttributeInObjectNode(ElementMetadata metadata, ElementMetadata childMetadata, XmlToJsonConfiguration config, ObjectNode rootObjectNode, String parentNamespacePrefix) {
        if (config.isSkipNamespaces() || metadata.getNamespaces() == null || metadata.getNamespaces().isEmpty()) return false;
        if (childMetadata == null) childMetadata = metadata;
        if (Objects.equals(childMetadata.getNamespacePrefix(), parentNamespacePrefix)) return false;
        String namespaceLabel = buildNamespaceLabel(childMetadata);
        Namespace namespace = metadata.getNamespaces().get(namespaceLabel);
        if (namespace != null && namespace.getLevel() + 1 >= metadata.getLevel()) return false;
        rootObjectNode.put(Constants.JSON_XML_ATTR_PREFIX + namespaceLabel, metadata.getNamespaces().get(namespaceLabel).getNamespace());
        return true;
    }

    private static String buildNamespaceLabel(ElementMetadata childMetadata) {
        String label = XMLConstants.XMLNS_ATTRIBUTE;
        if (childMetadata.getNamespacePrefix() != null)
            label += ":" + childMetadata.getNamespacePrefix();
        return label;
    }

    // -------------------------------------------------------------------------
    // Root node value helpers
    // -------------------------------------------------------------------------

    public static void addValueOnRootArrayNode(ElementMetadata metadata, XmlToJsonConfiguration config) {
        JsonNode valueAsJson = JsonUtils.getValidJson(metadata.getTextContent());
        if (valueAsJson != null) {
            if (valueAsJson.isArray()) { metadata.setArrayNode((ArrayNode) valueAsJson); metadata.setRootArray(true); }
            else                      { metadata.setObjectNode((ObjectNode) valueAsJson); metadata.setRootArray(false); }
        } else {
            String val = ElementMetadataUtils.getNodeValue(metadata, config.isTrimSpaces());
            if(val == null || val.isEmpty()) metadata.getArrayNode().addNull();
            else metadata.getArrayNode().add(val);
        }
    }

    public static void putValueOnRootObjectNode(ElementMetadata metadata, XmlToJsonConfiguration config) {
        JsonNode valueAsJson = JsonUtils.getValidJson(metadata.getTextContent());
        if (valueAsJson != null)
            metadata.getObjectNode().set(Constants.JSON_XML_TEXT_FIELD, valueAsJson);
        else {
            String val = ElementMetadataUtils.getNodeValue(metadata, config.isTrimSpaces());
            if (val == null || val.isEmpty()) metadata.getObjectNode().putNull(Constants.JSON_XML_TEXT_FIELD);
            else metadata.getObjectNode().put(Constants.JSON_XML_TEXT_FIELD, val);
        }
    }

    // -------------------------------------------------------------------------
    // Misc helpers
    // -------------------------------------------------------------------------

    public static String getAttributeTypeFromElement(ElementMetadata metadata) {
        if (metadata == null || metadata.getTypeAttributeValue() == null) return "";
        return metadata.getTypeAttributeValue();
    }

    public static boolean rootObjectNodeContainsAttributes(ObjectNode rootObjectNode) {
        for (String fieldName : rootObjectNode.propertyNames())
            if (fieldName.startsWith(Constants.JSON_XML_ATTR_PREFIX)) return true;
        return false;
    }

    public static boolean rootObjectNodeContainsTextAttribute(ObjectNode rootObjectNode) {
        return rootObjectNode != null && rootObjectNode.has(Constants.JSON_XML_TEXT_FIELD);
    }

    public static JsonNode createInternalNullObjectNode() {
        return new StringNode(Constants.INTERNAL_NULL_OBJECT_NODE_VALUE);
    }

    public static boolean isInternalNullObjectNodePresent(JsonNode node) {
        return node.isString() && node.asString().equals(Constants.INTERNAL_NULL_OBJECT_NODE_VALUE);
    }

    private static void addObjectToExistingFieldOnRootObjectNode(ElementMetadata metadata, String field, Object value) {
        JsonNode newValue;
        if(value instanceof JsonNode jn) {
            newValue = jn;
        } else if (value instanceof String s) {
            if(s.isEmpty()) newValue = JsonNodeFactory.instance.nullNode();
            else newValue = new StringNode(s);
        } else {
            throw new IllegalArgumentException("Unsupported value type: " + value.getClass());
        }

        JsonNode nodeValues = metadata.getObjectNode().get(field);
        if (!nodeValues.isArray()) nodeValues = wrapInArray(nodeValues);
        ((ArrayNode) nodeValues).add(!metadata.isElementMustBeNull() ? newValue : null);
        metadata.getObjectNode().set(field, nodeValues);
    }

    private static JsonNode addNodeWithAttributeInfo(ElementMetadata metadata, String value) {
        ObjectNode attrInfoObjectNode = JsonNodeFactory.instance.objectNode();
        for (Map.Entry<String, AttributeEntry> entry : metadata.getAttributes().entrySet())
            attrInfoObjectNode.put(Constants.JSON_XML_ATTR_PREFIX + entry.getKey(), entry.getValue().value());

        if (value == null || value.isEmpty() || value.equalsIgnoreCase(Constants.NULL_VALUE)) {
            attrInfoObjectNode.putNull(Constants.JSON_XML_TEXT_FIELD);
        } else {
            attrInfoObjectNode.put(Constants.JSON_XML_TEXT_FIELD, value);
        }
        return attrInfoObjectNode;
    }

    private static void setEmptyArrayNodeInRootObjectNode(ObjectNode rootObjectNode, String label) {
        rootObjectNode.set(label, JsonNodeFactory.instance.arrayNode());
    }

    private static boolean isInteger(String str) {
        if (str == null || str.isEmpty()) return false;
        try { Integer.parseInt(str); return true; } catch (NumberFormatException e) { return false; }
    }

    private static boolean isDouble(String str) {
        if (str == null || str.isEmpty()) return false;
        try { Double.parseDouble(str); return true; } catch (NumberFormatException e) { return false; }
    }
}