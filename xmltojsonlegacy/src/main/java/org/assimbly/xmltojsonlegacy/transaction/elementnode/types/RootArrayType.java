package org.assimbly.xmltojsonlegacy.transaction.elementnode.types;

import com.fasterxml.jackson.databind.JsonNode;
import org.assimbly.xmltojsonlegacy.XmlToJsonConfiguration;
import org.assimbly.xmltojsonlegacy.model.ElementMetadata;
import org.assimbly.xmltojsonlegacy.service.MetadataAnalyzer;
import org.assimbly.xmltojsonlegacy.transaction.elementnode.ElementNodeTransaction;
import org.assimbly.xmltojsonlegacy.utils.ElementMetadataUtils;
import org.assimbly.xmltojsonlegacy.utils.ExtractUtils;

import java.util.Map;

public class RootArrayType implements ElementNodeTransaction {

    @Override
    public JsonNode process(Map<String, ElementMetadata> metadataMap, ElementMetadata metadata, ElementMetadata childMetadata, JsonNode childNode, XmlToJsonConfiguration config) {
        ElementMetadata parentMetadata = ElementMetadataUtils.getParentMetadata(metadataMap, metadata);
        if(MetadataAnalyzer.isSingleChildren(metadata, config) && metadata.getIndex() == 0 && parentMetadata.containsClassAttribute()) {
            // recursive call with child element
            if(metadata.isElementMustBeNull()) {
                return ExtractUtils.createInternalNullObjectNode();
            }
            return childNode;
        } else {
            // extract child as an array
            ExtractUtils.extractChildAsArray(metadata, childMetadata, childNode);
        }
        return null;
    }
}
