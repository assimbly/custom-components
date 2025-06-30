package org.assimbly.xmltojsonlegacy.transaction.elementnode;

import com.fasterxml.jackson.databind.JsonNode;
import org.assimbly.xmltojsonlegacy.model.ElementMetadata;
import org.assimbly.xmltojsonlegacy.XmlToJsonConfiguration;

import java.util.Map;

public interface ElementNodeTransaction {

    JsonNode process(Map<String, ElementMetadata> metadataMap, ElementMetadata metadata, ElementMetadata childMetadata, JsonNode childNode, XmlToJsonConfiguration config);

}
