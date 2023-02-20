package org.assimbly.soap.util.helpers;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.wsdl.extensions.schema.Schema;
import javax.wsdl.extensions.schema.SchemaImport;
import java.util.List;

public final class SchemaHelper {

    public static SchemaImport findImport(Schema schema, String namespace){
        for (Object key : schema.getImports().keySet()) {
            @SuppressWarnings("unchecked")
            SchemaImport im = ((List<SchemaImport>) schema.getImports().get(key)).get(0);

            if (im.getNamespaceURI() != null && im.getNamespaceURI().equals(namespace)) {
                return im;
            }
        }

        return null;
    }

    /**
     * Finds the declaration node by the name in a referenced schema.
     *
     * @param schema    is the corresponding schema
     * @param name      is the name as it is reffered in the schema
     *
     * @return null if not found otherwise a <code>org.w3c.dom.Node</code>
     */
    public static Node findElementByName(Schema schema, String name) {
        NodeList childs = schema.getElement().getChildNodes();

        for (int c = 0, length = childs.getLength(); c < length; c++) {
            Node match = childs.item(c);

            if (NodeHelper.hasNamedAttribute(match, "name")
                    && NodeHelper.getNamedAttribute(match, "name").getNodeValue().equals(name)
                    && (match.getLocalName().contains("element") || match.getLocalName().contains("Element"))) {
                return match;
            }
        }

        return null;
    }

    public static Node findTypeByName(Schema schema, String name) {
        NodeList childs = schema.getElement().getChildNodes();

        for (int c = 0, length = childs.getLength(); c < length; c++) {
            Node match = childs.item(c);

            if (NodeHelper.hasNamedAttribute(match, "name")
                    && NodeHelper.getNamedAttribute(match, "name").getNodeValue().equals(name)
                    && (match.getLocalName().contains("type") || match.getLocalName().contains("Type"))) {
                return match;
            }
        }

        return null;
    }
}
