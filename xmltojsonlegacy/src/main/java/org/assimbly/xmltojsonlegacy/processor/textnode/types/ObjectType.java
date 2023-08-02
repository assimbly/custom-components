package org.assimbly.xmltojsonlegacy.processor.textnode.types;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.assimbly.xmltojsonlegacy.logs.Print;
import org.assimbly.xmltojsonlegacy.processor.textnode.TextNodeTransaction;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class ObjectType implements TextNodeTransaction {

    @Override
    public JsonNode process(
            Node childNode, Element element, ArrayNode rootArrayNode, ObjectNode rootObjectNode, int level, int index,
            int nodeListSize, boolean isRootArray, boolean isRootNode, boolean isObject, boolean isOneValue,
            String namespace, boolean forceTopLevelObject, boolean trimSpaces, boolean skipNamespaces,
            boolean removeNamespacePrefixes, boolean typeHints
    ) {
        //process text node identified as an object
        Print.data(" 2. OBJECT", level);
        return null;
    }
}
