package org.assimbly.xmltojsonlegacy.transaction.elementnode.types;

import com.fasterxml.jackson.databind.JsonNode;
import org.assimbly.xmltojsonlegacy.XmlToJsonConfiguration;
import org.assimbly.xmltojsonlegacy.model.ElementMetadata;
import org.assimbly.xmltojsonlegacy.transaction.elementnode.ElementNodeTransaction;
import org.assimbly.xmltojsonlegacy.utils.ExtractUtils;

import java.util.Map;

public class ObjectType implements ElementNodeTransaction {

    @Override
    public JsonNode process(Map<String, ElementMetadata> metadataMap, ElementMetadata metadata, ElementMetadata childMetadata, JsonNode childNode, XmlToJsonConfiguration config) {
        // extract child as an object
        ExtractUtils.extractChildAsObject(metadata, childMetadata, config, childNode);
        return null;
    }
}
