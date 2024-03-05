package org.assimbly.xmltojsonlegacy.transaction.elementnode;

import org.assimbly.xmltojsonlegacy.XmlToJsonConfiguration;
import org.assimbly.xmltojsonlegacy.transaction.elementnode.types.ObjectType;
import org.assimbly.xmltojsonlegacy.transaction.elementnode.types.OtherTypeWithNamespace;
import org.assimbly.xmltojsonlegacy.transaction.elementnode.types.OtherTypeWithoutNamespace;
import org.assimbly.xmltojsonlegacy.transaction.elementnode.types.RootArrayType;

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

    public static ElementNodeTransaction getProcessorFor(XmlToJsonConfiguration config) {
        ElementNodeType type;

        if(config.isObject()) {
            type = ElementNodeType.OBJECT;
        } else {
            if(config.isRootArray()) {
                type = ElementNodeType.ROOT_ARRAY;
            } else {
                if(config.isElementDefiningNamespaces()) {
                    type = ElementNodeType.OTHER_WITH_NAMESPACE;
                } else {
                    type = ElementNodeType.OTHER_WITHOUT_NAMESPACE;
                }
            }
        }

        return processElementNodeMap.get(type);
    }

}
