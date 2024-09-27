package org.assimbly.xmltojsonlegacy.transaction.textnode;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.assimbly.xmltojsonlegacy.Namespace;
import org.assimbly.xmltojsonlegacy.XmlToJsonConfiguration;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import java.util.HashMap;

public interface TextNodeTransaction {

    JsonNode process(XmlToJsonConfiguration config, Node childNode, int index, int nodeListSize);

}
