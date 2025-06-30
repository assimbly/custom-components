package org.assimbly.xmltojsonlegacy.service;

import com.fasterxml.jackson.databind.JsonNode;
import org.assimbly.xmltojsonlegacy.XmlToJsonConfiguration;
import org.assimbly.xmltojsonlegacy.model.AttributeEntry;
import org.assimbly.xmltojsonlegacy.model.ElementMetadata;
import org.assimbly.xmltojsonlegacy.utils.Constants;
import org.assimbly.xmltojsonlegacy.utils.ElementMetadataUtils;

import java.util.Map;

public class MetadataAnalyzer {

    private MetadataAnalyzer() {}

    // check if it's a root array
    public static boolean isRootArray(Map<String, ElementMetadata> metadataMap, ElementMetadata metadata, XmlToJsonConfiguration config) {
        boolean isRootArray;
        if(metadata.isHasEmptyTextContent() && !metadata.containsClassAttributeValue(Constants.JSON_XML_ATTR_TYPE_ARRAY)) {
            return false;
        }
        if(config.isTypeHints()) {
            isRootArray = isRootArrayWithTypeHints(metadataMap, metadata);
        } else {
            isRootArray = isRootArrayWithoutTypeHints(metadataMap, metadata);
        }
        return isRootArray;
    }

    // check if it's a root array with type hints enabled
    private static boolean isRootArrayWithTypeHints(Map<String, ElementMetadata> metadataMap, ElementMetadata metadata) {
        ElementMetadata parentElementMetadata = metadataMap.getOrDefault(ElementMetadataUtils.getParentPath(metadata.getPath()), new ElementMetadata());
        ElementMetadata grandParentElementMetadata = metadataMap.getOrDefault(ElementMetadataUtils.getParentPath(parentElementMetadata.getPath()), new ElementMetadata());
        ElementMetadata greatGrandParentElementMetadata = metadataMap.getOrDefault(ElementMetadataUtils.getParentPath(grandParentElementMetadata.getPath()), new ElementMetadata());

        if (metadata.getLevel() == 0 && metadata.getChildrenCount() == 1 && !metadata.isDefinesNamespaces() && !metadata.isHasAttributes()) {
            return true;
        }
        if (metadata.getDeepestDepth() > 2 && !metadata.isDefinesNamespaces() && metadata.areChildrenNamesEqual()) {
            return true;
        }
        if (metadata.getDeepestDepth() == 2 && !metadata.isDefinesNamespaces() && metadata.areChildrenNamesEqual() &&
                (parentElementMetadata.areChildrenNamesEqual() || !metadata.containsClassAttributeValue(Constants.JSON_XML_ATTR_TYPE_OBJECT)) &&
                !metadata.isHasAttributes()
        ) {
            return true;
        }
        if (metadata.getDeepestDepth() == 1 && !ElementMetadataUtils.isElementOnNamespace(metadata) && // && parentElementMetadata.containsClassAttribute()
                (parentElementMetadata.containsClassAttributeValue("") || parentElementMetadata.containsClassAttributeValue(Constants.JSON_XML_ATTR_TYPE_ARRAY) ||
                        parentElementMetadata.containsClassAttributeValue(Constants.JSON_XML_ATTR_TYPE_OBJECT)) &&
                !metadata.isHasAttributes()
        ) {
            return true;
        }
        if (metadata.getDeepestDepth() == 1 && metadata.containsClassAttribute() && !ElementMetadataUtils.isElementOnNamespace(metadata) && (
                (metadata.containsClassAttributeValue("") && metadata.getChildrenCount() > 1) ||
                        metadata.containsClassAttributeValue(Constants.JSON_XML_ATTR_TYPE_OBJECT)
        )) {
            return true;
        }

        return (metadata.getDeepestDepth() == 0 && !parentElementMetadata.isHasEmptyTextContent() && !metadata.isHasAttributes() &&
                (parentElementMetadata.getChildrenCount() == 1 || parentElementMetadata.getChildrenCount() > 1 && parentElementMetadata.areChildrenNamesEqual()) &&
                (!parentElementMetadata.containsClassAttributeValue(Constants.JSON_XML_ATTR_TYPE_OBJECT) ||
                        parentElementMetadata.containsClassAttributeValue(Constants.JSON_XML_ATTR_TYPE_OBJECT) &&
                                grandParentElementMetadata.areChildrenNamesEqual()) &&
                (!grandParentElementMetadata.containsClassAttributeValue(Constants.JSON_XML_ATTR_TYPE_OBJECT) ||
                        grandParentElementMetadata.containsClassAttributeValue(Constants.JSON_XML_ATTR_TYPE_OBJECT) &&
                                greatGrandParentElementMetadata.areChildrenNamesEqual())
        );
    }

    // check if it's a root array without type hints enabled
    private static boolean isRootArrayWithoutTypeHints(Map<String, ElementMetadata> metadataMap, ElementMetadata metadata) {
        boolean isRootArray = false;

        ElementMetadata parentElementMetadata = metadataMap.getOrDefault(ElementMetadataUtils.getParentPath(metadata.getPath()), new ElementMetadata());
        ElementMetadata grandParentElementMetadata = metadataMap.getOrDefault(ElementMetadataUtils.getParentPath(parentElementMetadata.getPath()), new ElementMetadata());

        if(metadata.getLevel() == 0 && metadata.getChildrenCount() == 1 && !metadata.isDefinesNamespaces() && !metadata.isHasAttributes()) {
            isRootArray = true;
        }
        if (metadata.getDeepestDepth() > 2 && !metadata.isDefinesNamespaces() && metadata.areChildrenNamesEqual() && !metadata.isHasAttributes()) {
            isRootArray = true;
        }
        if (metadata.getDeepestDepth() == 2 && !metadata.isDefinesNamespaces() && metadata.areChildrenNamesEqual() && !metadata.isHasAttributes()) {
            isRootArray = true;
        }
        if(metadata.getDeepestDepth() == 1 && !metadata.isDefinesNamespaces() && metadata.areChildrenNamesEqual() && !metadata.isHasAttributes() &&
                !ElementMetadataUtils.isElementOnNamespace(metadata)
        ) {
            isRootArray = true;
        }
        if(metadata.getDeepestDepth() == 1 && metadata.containsClassAttribute() &&
                metadata.containsClassAttributeValue(Constants.JSON_XML_ATTR_TYPE_OBJECT)
        ) {
            isRootArray = grandParentElementMetadata.getChildrenCount() > 1;
        }
        if (metadata.getDeepestDepth() == 0 && !parentElementMetadata.isHasEmptyTextContent() && !metadata.isHasAttributes() && (
                parentElementMetadata.getChildrenCount() == 1 || parentElementMetadata.getChildrenCount() > 1 && parentElementMetadata.areChildrenNamesEqual()
        )) {
            isRootArray = true;
        }

        return isRootArray;
    }

    // check if it's an object
    public static boolean isObject(Map<String, ElementMetadata> metadataMap, ElementMetadata metadata, XmlToJsonConfiguration config) {

        ElementMetadata parentElementMetadata = metadataMap.getOrDefault(ElementMetadataUtils.getParentPath(metadata.getPath()), new ElementMetadata());
        ElementMetadata grandParentElementMetadata = metadataMap.getOrDefault(ElementMetadataUtils.getParentPath(parentElementMetadata.getPath()), new ElementMetadata());

        return (metadata.getDeepestDepth() == 1 &&
                (metadata.getChildrenCount() > 1  && (metadata.getLevel() == 0 || metadata.getLevel() > 0 && !metadata.areChildrenNamesEqual()) ||
                        metadata.getChildrenCount() == 1 && metadata.containsClassAttributeValue(Constants.JSON_XML_ATTR_TYPE_OBJECT) &&
                                (!config.isTypeHints() ||
                                        parentElementMetadata.getChildrenCount() > 1 && config.isTypeHints() &&
                                                !parentElementMetadata.containsClassAttributeValue(Constants.JSON_XML_ATTR_TYPE_ARRAY) ||
                                        config.isTypeHints() &&
                                                metadata.containsClassAttributeValue(Constants.JSON_XML_ATTR_TYPE_OBJECT) &&
                                                (!parentElementMetadata.isHasAttributes() && !grandParentElementMetadata.areChildrenNamesEqual())
                                )
                )
        );
    }

    // check if it's one value
    public static boolean isOneValue(Map<String, ElementMetadata> metadataMap, ElementMetadata metadata, XmlToJsonConfiguration config) {
        JsonNode valueAsJson = null;

        ElementMetadata parentElementMetadata = metadataMap.getOrDefault(ElementMetadataUtils.getParentPath(metadata.getPath()), new ElementMetadata());
        ElementMetadata grandParentElementMetadata = metadataMap.getOrDefault(ElementMetadataUtils.getParentPath(parentElementMetadata.getPath()), new ElementMetadata());
        ElementMetadata greatGrandParentElementMetadata = metadataMap.getOrDefault(ElementMetadataUtils.getParentPath(grandParentElementMetadata.getPath()), new ElementMetadata());

        if(metadata.getValueAsJson() != null) {
            valueAsJson = metadata.getValueAsJson();
        }

        return (metadata.getDeepestDepth() == 0 &&
                (!parentElementMetadata.isHasEmptyTextContent() || !metadata.isHasEmptyTextContent() && valueAsJson!=null) &&
                parentElementMetadata.areChildrenNamesEqual() &&
                metadata.areChildrenNamesEqual() &&
                (!config.isTypeHints() || (
                        !parentElementMetadata.containsClassAttribute() ||
                                !parentElementMetadata.containsClassAttributeValue(Constants.JSON_XML_ATTR_TYPE_OBJECT) ||
                                (greatGrandParentElementMetadata.areChildrenNamesEqual() && grandParentElementMetadata.areChildrenNamesEqual())
                ))
        );
    }

    // check if element should be null
    public static boolean isElementMustBeNull(Map<String, ElementMetadata> metadataMap, ElementMetadata metadata, ElementMetadata childMetadata, XmlToJsonConfiguration config) {
        if(!config.isSkipWhitespace()) {
            return false;
        }

        if(config.isSpecialCaseTTFTTF()) {
            return isSpecialCaseTTFTTFMustBeNull(metadataMap, metadata, childMetadata);
        }

        if(childMetadata == null) {
            return false;
        }

        AttributeEntry attribute = childMetadata.getAttributes().get(Constants.JSON_XML_ATTR_TYPE);
        if (config.isTypeHints() && attribute != null) {
            String attrValue = attribute.getValue();
            if (attrValue.equalsIgnoreCase(Constants.JSON_XML_ATTR_TYPE_NUMBER) ||
                    attrValue.equalsIgnoreCase(Constants.JSON_XML_ATTR_TYPE_BOOLEAN)) {
                return false;
            }
        }

        boolean isParentClassObject = hasAttribute(metadata, Constants.JSON_XML_ATTR_CLASS, Constants.JSON_XML_ATTR_TYPE_OBJECT);

        if(childMetadata.getDeepestDepth() == 0 && (!metadata.getNamespaces().isEmpty() || !childMetadata.getAttributes().isEmpty())) {
            return !(config.isTypeHints() && isParentClassObject && !metadata.areChildrenNamesEqual());
        }

        return false;
    }

    // check if element should be null - special case TTFTTF
    private static boolean isSpecialCaseTTFTTFMustBeNull(Map<String, ElementMetadata> metadataMap, ElementMetadata metadata, ElementMetadata childMetadata) {

        if(childMetadata == null) {
            return false;
        }

        if(childMetadata.getDeepestDepth() != 0) {
            return false;
        }

        if(childMetadata.getAttributes().isEmpty()) {
            return ElementMetadataUtils.isElementOnNamespace(metadata);
        }

        ElementMetadata parentMetada = ElementMetadataUtils.getParentMetadata(metadataMap, metadata);
        if(metadata.areChildrenNamesEqual() && parentMetada.areChildrenNamesEqual()) {
            return true;
        }

        for (Map.Entry<String, AttributeEntry> entry : childMetadata.getAttributes().entrySet()) {
            if (!entry.getKey().equals(Constants.JSON_XML_ATTR_TYPE)) {
                return true;
            }
        }

        return false;
    }

    // check if it's a single children
    public static boolean isSingleChildren(ElementMetadata metadata, XmlToJsonConfiguration config) {
        if(config.isTypeHints()) {
            return false;
        }
        return metadata.getDeepestDepth() == 1 && metadata.getChildrenCount() == 1 && (!metadata.containsClassAttribute() || !metadata.containsClassAttributeValue(Constants.JSON_XML_ATTR_TYPE_OBJECT));
    }

    // check if element have a specific attribute name and value
    public static boolean hasAttribute(ElementMetadata metadata, String attrName, String attrValue) {
        if(metadata == null || metadata.getAttributes().isEmpty()){
            return false;
        }
        AttributeEntry attribute = metadata.getAttributes().get(attrName);
        return attribute != null && attribute.getValue().equalsIgnoreCase(attrValue);
    }

    // check if it's the last element
    public static boolean isLastElement(ElementMetadata metadata) {
        return metadata.getChildrenCount() == 0;
    }

    // check if element node value is null
    public static boolean isElementNodeValueNull(ElementMetadata metadata) {
        return metadata.getTextContent() == null || metadata.getTextContent().isEmpty();
    }

    // check if element attribute is null
    public static boolean isElementAttributeNull(ElementMetadata metadata, String attrName) {
        return !metadata.getAttributes().containsKey(attrName);
    }

}
