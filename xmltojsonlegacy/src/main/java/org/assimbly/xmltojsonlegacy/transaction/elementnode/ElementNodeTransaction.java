package org.assimbly.xmltojsonlegacy.transaction.elementnode;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.assimbly.xmltojsonlegacy.Namespace;
import org.assimbly.xmltojsonlegacy.XmlToJsonConfiguration;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import java.util.HashMap;

public interface ElementNodeTransaction {

    JsonNode process(XmlToJsonConfiguration config, Node childNode);

}
