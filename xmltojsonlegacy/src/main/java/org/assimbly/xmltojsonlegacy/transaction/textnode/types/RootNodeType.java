package org.assimbly.xmltojsonlegacy.transaction.textnode.types;

import com.fasterxml.jackson.databind.JsonNode;
import org.assimbly.xmltojsonlegacy.XmlToJsonConfiguration;
import org.assimbly.xmltojsonlegacy.model.ElementMetadata;
import org.assimbly.xmltojsonlegacy.transaction.textnode.TextNodeTransaction;
import org.assimbly.xmltojsonlegacy.utils.Constants;
import org.assimbly.xmltojsonlegacy.utils.ElementMetadataUtils;
import org.assimbly.xmltojsonlegacy.utils.ExtractUtils;

import java.util.Map;

public class RootNodeType implements TextNodeTransaction {

    @Override
    public JsonNode process(Map<String, ElementMetadata> metadataMap, ElementMetadata metadata, XmlToJsonConfiguration config) {
        //process text node identified as a root node1
        if(metadata.getChildrenCount() == 0 && !metadata.isHasEmptyTextContent()) {
            if (config.isTypeHints()) {
                processWithTypeHints(metadata, config);
            } else {
                processWithoutTypeHints(metadata, config);
            }
        }
        return null;
    }

    private static void processWithTypeHints(ElementMetadata metadata, XmlToJsonConfiguration config) {
        if(ExtractUtils.rootObjectNodeContainsAttributes(metadata.getObjectNode())) {
            metadata.getObjectNode().put(Constants.JSON_XML_TEXT_FIELD, ElementMetadataUtils.getNodeValue(metadata, config.isTrimSpaces()));
        } else {
            ExtractUtils.addValueOnRootArrayNode(metadata, config);
        }
    }

    private static void processWithoutTypeHints(ElementMetadata metadata, XmlToJsonConfiguration config) {
        if(!metadata.getAttributes().isEmpty()) {
            ExtractUtils.putValueOnRootObjectNode(metadata, config);
        } else {
            metadata.getArrayNode().add(ElementMetadataUtils.getNodeValue(metadata, config.isTrimSpaces()));
        }
    }
}
