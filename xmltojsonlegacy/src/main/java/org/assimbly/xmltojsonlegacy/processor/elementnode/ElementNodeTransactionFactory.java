package org.assimbly.xmltojsonlegacy.processor.elementnode;

import org.assimbly.xmltojsonlegacy.processor.elementnode.types.ObjectType;
import org.assimbly.xmltojsonlegacy.processor.elementnode.types.OtherTypeWithNamespace;
import org.assimbly.xmltojsonlegacy.processor.elementnode.types.OtherTypeWithoutNamespace;
import org.assimbly.xmltojsonlegacy.processor.elementnode.types.RootArrayType;

import java.util.HashMap;
import java.util.Map;

public class ElementNodeTransactionFactory {

    enum ElementNodeType {
        OBJECT,
        ROOT_ARRAY,
        OTHER_WITH_NAMESPACE,
        OTHER_WITHOUT_NAMESPACE;
    }

    private static Map<ElementNodeType, ElementNodeTransaction> processElementNodeMap = new HashMap<>() {{
        put(ElementNodeType.OBJECT, new ObjectType());
        put(ElementNodeType.ROOT_ARRAY, new RootArrayType());
        put(ElementNodeType.OTHER_WITH_NAMESPACE, new OtherTypeWithNamespace());
        put(ElementNodeType.OTHER_WITHOUT_NAMESPACE, new OtherTypeWithoutNamespace());
    }};

    public static ElementNodeTransaction getProcessorFor(boolean isObject, boolean isRootArray, String namespace) {
        ElementNodeType type;

        if(isObject) {
            type = ElementNodeType.OBJECT;
        } else {
            if(isRootArray) {
                type = ElementNodeType.ROOT_ARRAY;
            } else {
                if(namespace!=null) {
                    type = ElementNodeType.OTHER_WITH_NAMESPACE;
                } else {
                    type = ElementNodeType.OTHER_WITHOUT_NAMESPACE;
                }
            }
        }

        return processElementNodeMap.get(type);
    }

}
