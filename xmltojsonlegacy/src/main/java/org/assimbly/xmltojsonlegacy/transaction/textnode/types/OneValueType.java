package org.assimbly.xmltojsonlegacy.transaction.textnode.types;

import com.fasterxml.jackson.databind.JsonNode;
import org.assimbly.xmltojsonlegacy.XmlToJsonConfiguration;
import org.assimbly.xmltojsonlegacy.model.ElementMetadata;
import org.assimbly.xmltojsonlegacy.transaction.textnode.TextNodeTransaction;
import org.assimbly.xmltojsonlegacy.utils.Constants;
import org.assimbly.xmltojsonlegacy.utils.ElementMetadataUtils;
import org.assimbly.xmltojsonlegacy.utils.ExtractUtils;

import java.util.Map;

public class OneValueType implements TextNodeTransaction {

    @Override
    public JsonNode process(Map<String, ElementMetadata> metadataMap, ElementMetadata metadata, XmlToJsonConfiguration config) {
        //process text node identified as one value
        JsonNode resp;
        if(config.isTypeHints()) {
            resp = processWithTypeHints(metadata, config);
        } else {
            resp = processWithoutTypeHints(metadata, config);
        }
        return metadata.getLevel() == 1 ? resp : null;
    }

    private static JsonNode processWithTypeHints(ElementMetadata metadata, XmlToJsonConfiguration config) {
        if(ExtractUtils.rootObjectNodeContainsAttributes(metadata.getObjectNode())) {
            metadata.getObjectNode().put(Constants.JSON_XML_TEXT_FIELD, ElementMetadataUtils.getNodeValue(metadata, config.isTrimSpaces()));
            return metadata.getObjectNode();
        } else {
            ExtractUtils.addValueOnRootArrayNode(metadata, config);
            return metadata.getArrayNode();
        }
    }

    private static JsonNode processWithoutTypeHints(ElementMetadata metadata, XmlToJsonConfiguration config) {
        if(!metadata.getAttributes().isEmpty()) {
            ExtractUtils.putValueOnRootObjectNode(metadata, config);
            return metadata.getObjectNode();
        } else {
            metadata.getArrayNode().add(ElementMetadataUtils.getNodeValue(metadata, config.isTrimSpaces()));
            return metadata.getArrayNode();
        }
    }
}
