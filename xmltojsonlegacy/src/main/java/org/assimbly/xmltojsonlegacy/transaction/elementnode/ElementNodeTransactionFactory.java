package org.assimbly.xmltojsonlegacy.transaction.elementnode;

import org.assimbly.xmltojsonlegacy.model.ElementMetadata;
import org.assimbly.xmltojsonlegacy.transaction.elementnode.types.ObjectType;
import org.assimbly.xmltojsonlegacy.transaction.elementnode.types.OtherTypeWithNamespace;
import org.assimbly.xmltojsonlegacy.transaction.elementnode.types.OtherTypeWithoutNamespace;
import org.assimbly.xmltojsonlegacy.transaction.elementnode.types.RootArrayType;

import java.util.EnumMap;
import java.util.Map;

public class ElementNodeTransactionFactory {

    enum ElementNodeType {
        OBJECT,
        ROOT_ARRAY,
        OTHER_WITH_NAMESPACE,
        OTHER_WITHOUT_NAMESPACE;
    }

    private static final Map<ElementNodeType, ElementNodeTransaction> processElementNodeMap = new EnumMap<>(ElementNodeType.class);

    static {
        processElementNodeMap.put(ElementNodeType.OBJECT, new ObjectType());
        processElementNodeMap.put(ElementNodeType.ROOT_ARRAY, new RootArrayType());
        processElementNodeMap.put(ElementNodeType.OTHER_WITH_NAMESPACE, new OtherTypeWithNamespace());
        processElementNodeMap.put(ElementNodeType.OTHER_WITHOUT_NAMESPACE, new OtherTypeWithoutNamespace());
    }

    public static ElementNodeTransaction getProcessorFor(ElementMetadata metadata) {
        ElementNodeType type;

        if(metadata.isObject()) {
            type = ElementNodeType.OBJECT;
        } else {
            if(metadata.isRootArray()) {
                type = ElementNodeType.ROOT_ARRAY;
            } else {
                if(metadata.isDefinesNamespaces()) {
                    type = ElementNodeType.OTHER_WITH_NAMESPACE;
                } else {
                    type = ElementNodeType.OTHER_WITHOUT_NAMESPACE;
                }
            }
        }

        return processElementNodeMap.get(type);
    }

}
