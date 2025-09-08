package org.assimbly.xmltojsonlegacy.transaction.textnode.types;

import com.fasterxml.jackson.databind.JsonNode;
import org.assimbly.xmltojsonlegacy.XmlToJsonConfiguration;
import org.assimbly.xmltojsonlegacy.model.ElementMetadata;
import org.assimbly.xmltojsonlegacy.service.MetadataAnalyzer;
import org.assimbly.xmltojsonlegacy.transaction.textnode.TextNodeTransaction;
import org.assimbly.xmltojsonlegacy.utils.Constants;
import org.assimbly.xmltojsonlegacy.utils.ElementMetadataUtils;
import org.assimbly.xmltojsonlegacy.utils.ExtractUtils;

import java.util.Map;

public class OtherType implements TextNodeTransaction {

    @Override
    public JsonNode process(Map<String, ElementMetadata> metadataMap, ElementMetadata metadata, XmlToJsonConfiguration config) {
        //process text node identified as other
        if(config.isTypeHints()){
            processWithTypeHints(metadataMap, metadata, config);
        } else {
            processWithoutTypeHints(metadata, config);
        }
        return null;
    }

    private static void processWithTypeHints(Map<String, ElementMetadata> metadataMap, ElementMetadata metadata, XmlToJsonConfiguration config) {
        ElementMetadata parentMetadata = ElementMetadataUtils.getParentMetadata(metadataMap, metadata);
        ElementMetadata grandParentMetadata = ElementMetadataUtils.getGrandParentMetadata(metadataMap, metadata);
        if(!parentMetadata.areChildrenNamesEqual() ||
                ((!grandParentMetadata.containsClassAttribute() || !grandParentMetadata.containsClassAttributeValue(Constants.JSON_XML_ATTR_TYPE_ARRAY)) &&
                        (!parentMetadata.containsClassAttribute() || !parentMetadata.containsClassAttributeValue(Constants.JSON_XML_ATTR_TYPE_ARRAY)))
        ) {
            String value = ElementMetadataUtils.getNodeValue(metadata, config.isTrimSpaces());
            String trimmedValue = ElementMetadataUtils.getNodeValue(metadata, true);
            if(value != null && !trimmedValue.isEmpty()) {
                ExtractUtils.setValueUsingAttributeType(metadata, config, metadata.getObjectNode(), null,
                        ElementMetadataUtils.getElementName(metadata, config.isRemoveNamespacePrefixes()),
                        value,
                        ExtractUtils.getAttributeTypeFromElement(metadata));
            }
        }
    }

    private static void processWithoutTypeHints(ElementMetadata metadata, XmlToJsonConfiguration config) {
        if(MetadataAnalyzer.isLastElement(metadata)) {
            String name = ElementMetadataUtils.getElementName(metadata, config.isRemoveNamespacePrefixes());
            if(!MetadataAnalyzer.isElementAttributeNull(metadata, Constants.JSON_XML_ATTR_TYPE)) {
                name = Constants.JSON_XML_TEXT_FIELD;
            }
            if(!metadata.getObjectNode().isEmpty()) {
                metadata.getObjectNode().put(Constants.JSON_XML_TEXT_FIELD, ElementMetadataUtils.getNodeValue(metadata, config.isTrimSpaces()));
            } else {
                metadata.getObjectNode().put(name, ElementMetadataUtils.getNodeValue(metadata, config.isTrimSpaces()));
            }
        }
    }

}
