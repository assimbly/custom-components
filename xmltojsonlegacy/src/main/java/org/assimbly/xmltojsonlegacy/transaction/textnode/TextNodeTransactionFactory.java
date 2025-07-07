package org.assimbly.xmltojsonlegacy.transaction.textnode;

import org.assimbly.xmltojsonlegacy.model.ElementMetadata;
import org.assimbly.xmltojsonlegacy.transaction.textnode.types.ObjectType;
import org.assimbly.xmltojsonlegacy.transaction.textnode.types.OneValueType;
import org.assimbly.xmltojsonlegacy.transaction.textnode.types.OtherType;
import org.assimbly.xmltojsonlegacy.transaction.textnode.types.RootNodeType;

import java.util.EnumMap;
import java.util.Map;

public class TextNodeTransactionFactory {

    enum TextNodeType {
        ROOT_NODE,
        ONE_VALUE,
        OBJECT,
        OTHER;
    }

    private static final Map<TextNodeType, TextNodeTransaction> processTextNodeMap = new EnumMap<>(TextNodeType.class);

    static {
        processTextNodeMap.put(TextNodeType.ROOT_NODE, new RootNodeType());
        processTextNodeMap.put(TextNodeType.ONE_VALUE, new OneValueType());
        processTextNodeMap.put(TextNodeType.OBJECT, new ObjectType());
        processTextNodeMap.put(TextNodeType.OTHER, new OtherType());
    }

    public static TextNodeTransaction getProcessorFor(ElementMetadata metadata) {
        TextNodeType type;

        if(metadata.isRootNode()) {
            type = TextNodeType.ROOT_NODE;
        } else if(metadata.isObject()) {
            type = TextNodeType.OBJECT;
        } else if(metadata.isOneValue()) {
            type = TextNodeType.ONE_VALUE;
        } else {
            type = TextNodeType.OTHER;
        }

        return processTextNodeMap.get(type);
    }

}
