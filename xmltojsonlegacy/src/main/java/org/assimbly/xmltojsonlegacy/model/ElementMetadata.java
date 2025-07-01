package org.assimbly.xmltojsonlegacy.model;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.assimbly.xmltojsonlegacy.utils.Constants;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ElementMetadata {

    private String name;
    private String path;

    private int childrenCount;
    private int deepestDepth;

    private Map<String, Integer> childNameCounts = new HashMap<>();
    private List<String> childPaths = new ArrayList<>();

    private Map<String, AttributeEntry> attributes = new HashMap<>();
    private boolean hasAttributes;

    private String namespacePrefix;
    private Map<String, Namespace> namespaces;
    private Map<String, Namespace> definedNamespaces;
    private boolean definesNamespaces = false;

    private boolean hasEmptyTextContent = true;
    private boolean elementMustBeNull;

    private boolean isRootArray;
    private boolean isObject;
    private boolean isOneValue;

    private String textContent;
    private String normalizedTextContent;
    private String normalizedTrimmedTextContent;

    private ObjectNode objectNode;
    private ArrayNode arrayNode;
    private JsonNode valueAsJson;

    private int index = 0;

    public ElementMetadata() {
        // default constructor
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public int getChildrenCount() {
        return childrenCount;
    }

    public void setChildrenCount(int childrenCount) {
        this.childrenCount = childrenCount;
    }

    public int getDeepestDepth() {
        return deepestDepth;
    }

    public void setDeepestDepth(int deepestDepth) {
        this.deepestDepth = deepestDepth;
    }

    public Map<String, AttributeEntry> getAttributes() {
        return attributes;
    }

    public String getTypeAttributeValue() {
        AttributeEntry attr = attributes.get(Constants.JSON_XML_ATTR_TYPE);
        return attr != null ? attr.getValue() : "";
    }

    public String getClassAttributeValue() {
        AttributeEntry attr = attributes.get(Constants.JSON_XML_ATTR_CLASS);
        return attr != null ? attr.getValue() : "";
    }

    public boolean containsClassAttribute() {
        return attributes.containsKey(Constants.JSON_XML_ATTR_CLASS);
    }

    public boolean containsClassAttributeValue(String value) {
        AttributeEntry attribute = attributes.get(Constants.JSON_XML_ATTR_CLASS);
        return attribute != null && attribute.getValue().equals(value) || attribute == null && value.isEmpty();
    }

    public void setAttributes(Map<String, AttributeEntry> attributes) {
        this.attributes = attributes;
    }

    public boolean areChildrenNamesEqual() {
        return childNameCounts.size() <= 1;
    }

    public Map<String, Namespace> getNamespaces() {
        return namespaces;
    }

    public void setNamespaces(Map<String, Namespace> namespaces) {
        this.namespaces = namespaces;
    }

    public String getNamespacePrefix() {
        return namespacePrefix;
    }

    public void setNamespacePrefix(String namespacePrefix) {
        this.namespacePrefix = namespacePrefix;
    }

    public void addChildName(String childName) {
        this.childNameCounts.put(childName, childNameCounts.getOrDefault(childName, 0) + 1);
    }

    public void addChildPath(String path) {
        childPaths.add(path);
    }

    public List<String> getChildPaths() {
        return childPaths;
    }

    public boolean isDefinesNamespaces() {
        return definesNamespaces;
    }

    public void setDefinesNamespaces(boolean definesNamespaces) {
        this.definesNamespaces = definesNamespaces;
    }

    public Map<String, Namespace> getDefinedNamespaces() {
        return definedNamespaces;
    }

    public void setDefinedNamespaces(Map<String, Namespace> definedNamespaces) {
        this.definedNamespaces = definedNamespaces;
    }

    public boolean isHasEmptyTextContent() {
        return hasEmptyTextContent;
    }

    public void setHasEmptyTextContent(boolean hasEmptyTextContent) {
        this.hasEmptyTextContent = hasEmptyTextContent;
    }

    public boolean isHasAttributes() {
        return hasAttributes;
    }

    public void setHasAttributes(boolean hasAttributes) {
        this.hasAttributes = hasAttributes;
    }

    public boolean isRootArray() {
        return isRootArray;
    }

    public void setRootArray(boolean rootArray) {
        isRootArray = rootArray;
    }

    public boolean isObject() {
        return isObject;
    }

    public void setObject(boolean object) {
        isObject = object;
    }

    public boolean isOneValue() {
        return isOneValue;
    }

    public void setOneValue(boolean oneValue) {
        isOneValue = oneValue;
    }

    public JsonNode getValueAsJson() {
        return valueAsJson;
    }

    public void setValueAsJson(JsonNode valueAsJson) {
        this.valueAsJson = valueAsJson;
    }

    public boolean isElementMustBeNull() {
        return elementMustBeNull;
    }

    public void setElementMustBeNull(boolean elementMustBeNull) {
        this.elementMustBeNull = elementMustBeNull;
    }

    public String getTextContent() {
        return textContent;
    }

    public void setTextContent(String textContent) {
        this.textContent = textContent;
    }

    public String getNormalizedTextContent() {
        return normalizedTextContent;
    }

    public void setNormalizedTextContent(String normalizedTextContent) {
        this.normalizedTextContent = normalizedTextContent;
    }

    public String getNormalizedTrimmedTextContent() {
        return normalizedTrimmedTextContent;
    }

    public void setNormalizedTrimmedTextContent(String normalizedTrimmedTextContent) {
        this.normalizedTrimmedTextContent = normalizedTrimmedTextContent;
    }

    public ArrayNode getArrayNode() {
        return arrayNode;
    }

    public void setArrayNode(ArrayNode arrayNode) {
        this.arrayNode = arrayNode;
    }

    public ObjectNode getObjectNode() {
        return objectNode;
    }

    public void setObjectNode(ObjectNode objectNode) {
        this.objectNode = objectNode;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getLevel() {
        return path != null ? path.split("/").length -1 : 0;
    }

    public boolean isRootNode() {
        return !path.contains("/");
    }
}
