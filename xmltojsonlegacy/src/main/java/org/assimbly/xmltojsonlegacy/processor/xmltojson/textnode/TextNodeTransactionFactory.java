package org.assimbly.xmltojsonlegacy.processor.xmltojson.textnode;

import org.assimbly.xmltojsonlegacy.processor.xmltojson.textnode.types.ObjectType;
import org.assimbly.xmltojsonlegacy.processor.xmltojson.textnode.types.OneValueType;
import org.assimbly.xmltojsonlegacy.processor.xmltojson.textnode.types.OtherType;
import org.assimbly.xmltojsonlegacy.processor.xmltojson.textnode.types.RootNodeType;

import java.util.HashMap;
import java.util.Map;

public class TextNodeTransactionFactory {

    enum TextNodeType {
        ROOT_NODE,
        ONE_VALUE,
        OBJECT,
        OTHER;
    }

    private static Map<TextNodeType, TextNodeTransaction> processTextNodeMap = new HashMap<>() {{
        put(TextNodeType.ROOT_NODE, new RootNodeType());
        put(TextNodeType.ONE_VALUE, new OneValueType());
        put(TextNodeType.OBJECT, new ObjectType());
        put(TextNodeType.OTHER, new OtherType());
    }};

    public static TextNodeTransaction getProcessorFor(boolean isRootNode, boolean isObject, boolean isOneValue) {
        TextNodeType type;

        if(isRootNode) {
            type = TextNodeType.ROOT_NODE;
        } else if(isObject) {
            type = TextNodeType.OBJECT;
        } else if(isOneValue) {
            type = TextNodeType.ONE_VALUE;
        } else {
            type = TextNodeType.OTHER;
        }

        return processTextNodeMap.get(type);
    }

}
