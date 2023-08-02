package org.assimbly.xmltojsonlegacy.processor.elementnode;

import org.assimbly.xmltojsonlegacy.processor.elementnode.types.*;

import java.util.HashMap;
import java.util.Map;

public class ElementNodeTransactionFactory {

    enum ElementNodeType {
        OBJECT,
        ROOT_ARRAY,
        OTHER_WITH_NAMESPACE,
        OTHER_WITH_TYPEHINTS,
        OTHER_WITHOUT_NAMESPACE_AND_TYPEHINTS;
    }

    private static Map<ElementNodeType, ElementNodeTransaction> processElementNodeMap = new HashMap<>() {{
        put(ElementNodeType.OBJECT, new ObjectType());
        put(ElementNodeType.ROOT_ARRAY, new RootArrayType());
        put(ElementNodeType.OTHER_WITH_NAMESPACE, new OtherTypeWithNamespace());
        put(ElementNodeType.OTHER_WITH_TYPEHINTS, new OtherTypeWithTypeHints());
        put(ElementNodeType.OTHER_WITHOUT_NAMESPACE_AND_TYPEHINTS, new OtherTypeWithoutNamespaceAndTypeHints());
    }};

    public static ElementNodeTransaction getProcessorFor(
            boolean isObject, boolean isRootArray, String namespace, boolean typeHints
    ) {
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
                    if(typeHints) {
                        type = ElementNodeType.OTHER_WITH_TYPEHINTS;
                    } else {
                        type = ElementNodeType.OTHER_WITHOUT_NAMESPACE_AND_TYPEHINTS;
                    }
                }
            }
        }

        return processElementNodeMap.get(type);
    }

}
