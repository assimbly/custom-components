package org.assimbly.xmltojsonlegacy.processor.jsontoxml.node;

import org.assimbly.xmltojsonlegacy.processor.jsontoxml.node.types.ArrayType;
import org.assimbly.xmltojsonlegacy.processor.jsontoxml.node.types.ObjectType;
import org.assimbly.xmltojsonlegacy.processor.jsontoxml.node.types.TextType;

import java.util.HashMap;
import java.util.Map;

public class NodeTransactionFactory {

    enum JsonNodeType {
        ARRAY,
        OBJECT,
        TEXT
    }

    private static Map<JsonNodeType, NodeTransaction> processElementNodeMap = new HashMap<>() {{
        put(JsonNodeType.ARRAY, new ArrayType());
        put(JsonNodeType.OBJECT, new ObjectType());
        put(JsonNodeType.TEXT, new TextType());
    }};

    public static NodeTransaction getProcessorFor(boolean isArray, boolean isObject) {
        JsonNodeType type;

        if(isArray) {
            type = JsonNodeType.ARRAY;
        } else if(isObject) {
            type = JsonNodeType.OBJECT;
        } else {
            type = JsonNodeType.TEXT;
        }

        return processElementNodeMap.get(type);
    }

}
