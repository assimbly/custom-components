package org.assimbly.xmltojsonlegacy.transaction.elementnode.types;

import com.fasterxml.jackson.databind.JsonNode;
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
        if(!config.isTypeHints()) {
            // extract child as other type and add into the array node
            int children = childMetadata.getChildrenCount();
            boolean childrenHasEmptyTextContent = childMetadata.isHasEmptyTextContent();
            boolean classAttrOnChildElementIsNUll = MetadataAnalyzer.isElementAttributeNull(childMetadata, Constants.JSON_XML_ATTR_CLASS);
            if(childrenHasEmptyTextContent ||
                    (metadata.getLevel() == 0 && metadata.getChildrenCount() > 1) ||
                    (metadata.getChildrenCount() == 1 && (
                            !childMetadata.areChildrenNamesEqual() ||
                            children == 0 ||
                            children >= 1 && (!classAttrOnChildElementIsNUll || !childMetadata.getAttributes().isEmpty())
                    )) ||
                    !metadata.areChildrenNamesEqual() ||
                    ElementMetadataUtils.isElementOnNamespace(metadata)
            ) {
                ExtractUtils.extractChildAsOtherInObjectNode(metadata, childMetadata, config, childNode);
            } else {
                ExtractUtils.extractChildAsOtherInArrayNode(metadata, childNode);
                metadata.getObjectNode().set(ElementMetadataUtils.getElementName(childMetadata, config.isRemoveNamespacePrefixes()), metadata.getArrayNode());
            }
        } else {
            // extract child as other type and add into the object node
            ExtractUtils.extractChildAsOtherInObjectNode(metadata, childMetadata, config, childNode);
        }
        return null;
    }
}
