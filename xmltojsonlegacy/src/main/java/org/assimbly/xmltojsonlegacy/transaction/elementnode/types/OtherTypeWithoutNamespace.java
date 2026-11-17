package org.assimbly.xmltojsonlegacy.transaction.elementnode.types;

import tools.jackson.databind.JsonNode;
import org.assimbly.xmltojsonlegacy.XmlToJsonConfiguration;
import org.assimbly.xmltojsonlegacy.model.ElementMetadata;
import org.assimbly.xmltojsonlegacy.service.MetadataAnalyzer;
import org.assimbly.xmltojsonlegacy.transaction.elementnode.ElementNodeTransaction;
import org.assimbly.xmltojsonlegacy.utils.Constants;
import org.assimbly.xmltojsonlegacy.utils.ElementMetadataUtils;
import org.assimbly.xmltojsonlegacy.utils.ExtractUtils;

import java.util.Map;

public class OtherTypeWithoutNamespace implements ElementNodeTransaction {

    @Override
    public JsonNode process(Map<String, ElementMetadata> metadataMap, ElementMetadata metadata, ElementMetadata childMetadata, JsonNode childNode, XmlToJsonConfiguration config) {
        if(config.isTypeHints()) {
            processWithTypeHints(metadata, childMetadata, childNode, config);
        } else {
            processWithoutTypeHints(metadata, childMetadata, childNode, config);
        }
        return null;
    }

    private void processWithoutTypeHints(ElementMetadata metadata, ElementMetadata childMetadata, JsonNode childNode, XmlToJsonConfiguration config) {
        // extract child as other type and add into the array node
        if(isChildExtractedInObjectNode(metadata, childMetadata)) {
            ExtractUtils.extractChildAsOtherInObjectNode(metadata, childMetadata, config, childNode);
        } else {
            ExtractUtils.extractChildAsOtherInArrayNode(metadata, childNode);
            metadata.getObjectNode().set(ElementMetadataUtils.getElementName(childMetadata, config.isRemoveNamespacePrefixes()), metadata.getArrayNode());
        }
    }

    private void processWithTypeHints(ElementMetadata metadata, ElementMetadata childMetadata, JsonNode childNode, XmlToJsonConfiguration config) {
        if(metadata.hasMultipleChildrenNamed(childMetadata.getName()) && childMetadata.isObject()) {
            ExtractUtils.extractChildAsOtherInArrayNode(metadata, childNode);
            metadata.getObjectNode().set(ElementMetadataUtils.getElementName(childMetadata, config.isRemoveNamespacePrefixes()), metadata.getArrayNode());
        } else {
            // extract child as other type and add into the object node
            ExtractUtils.extractChildAsOtherInObjectNode(metadata, childMetadata, config, childNode);
        }
    }

    private boolean isChildExtractedInObjectNode(ElementMetadata metadata, ElementMetadata childMetadata) {
        int children = childMetadata.getChildrenCount();
        boolean classAttrOnChildElementIsNUll = MetadataAnalyzer.isElementAttributeNull(childMetadata, Constants.JSON_XML_ATTR_CLASS);
        return childMetadata.isHasEmptyTextContent() ||
                (metadata.getLevel() == 0 && metadata.getChildrenCount() == 1 && !metadata.getAttributes().isEmpty()) ||
                (metadata.getChildrenCount() == 1 && (
                        !childMetadata.areChildrenNamesEqual() ||
                                children == 0 ||
                                children >= 1 && (!classAttrOnChildElementIsNUll || !childMetadata.getAttributes().isEmpty())
                )) ||
                !metadata.areChildrenNamesEqual() && !metadata.hasMultipleChildrenNamed(childMetadata.getName()) ||
                ElementMetadataUtils.isElementOnNamespace(metadata);
    }
}
