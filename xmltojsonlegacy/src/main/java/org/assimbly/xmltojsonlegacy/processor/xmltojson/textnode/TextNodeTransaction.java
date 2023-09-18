package org.assimbly.xmltojsonlegacy.processor.xmltojson.textnode;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public interface TextNodeTransaction {

    JsonNode process(
            Node childNode, Element element, ArrayNode rootArrayNode, ObjectNode rootObjectNode, int level, int index,
            int nodeListSize, boolean isRootArray, boolean isRootNode, boolean isObject, boolean isOneValue,
            String namespace, boolean forceTopLevelObject, boolean trimSpaces, boolean skipNamespaces,
            boolean removeNamespacePrefixes, boolean typeHints
    );

}
