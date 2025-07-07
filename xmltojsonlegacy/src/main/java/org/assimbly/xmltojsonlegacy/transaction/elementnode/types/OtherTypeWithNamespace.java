package org.assimbly.xmltojsonlegacy.transaction.elementnode.types;

import com.fasterxml.jackson.databind.JsonNode;
import org.assimbly.xmltojsonlegacy.XmlToJsonConfiguration;
import org.assimbly.xmltojsonlegacy.model.ElementMetadata;
import org.assimbly.xmltojsonlegacy.transaction.elementnode.ElementNodeTransaction;
import org.assimbly.xmltojsonlegacy.utils.ElementMetadataUtils;
import org.assimbly.xmltojsonlegacy.utils.ExtractUtils;

import java.util.Map;

public class OtherTypeWithNamespace implements ElementNodeTransaction {

    @Override
    public JsonNode process(Map<String, ElementMetadata> metadataMap, ElementMetadata metadata, ElementMetadata childMetadata, JsonNode childNode, XmlToJsonConfiguration config) {
        if(metadata.getChildrenCount() == 1 || metadata.getChildrenCount() > 1 && !metadata.areChildrenNamesEqual()) {
            ExtractUtils.extractChildAsOtherInObjectNode(metadata, childMetadata, config, childNode);
        } else {
            ExtractUtils.extractChildAsOtherInArrayNode(metadata, childNode);
            metadata.getObjectNode().set(ElementMetadataUtils.getElementName(childMetadata, config.isRemoveNamespacePrefixes()), metadata.getArrayNode());
        }
        return null;
    }
}
