package org.assimbly.xmltojsonlegacy.transaction.textnode;

import com.fasterxml.jackson.databind.JsonNode;
import org.assimbly.xmltojsonlegacy.model.ElementMetadata;
import org.assimbly.xmltojsonlegacy.XmlToJsonConfiguration;

import java.util.Map;

public interface TextNodeTransaction {

    JsonNode process(Map<String, ElementMetadata> metadataMap, ElementMetadata metada, XmlToJsonConfiguration config);

}
