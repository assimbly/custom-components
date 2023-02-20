package world.dovetail.soap.util.helpers;

import javax.wsdl.Types;
import javax.wsdl.extensions.schema.Schema;
import javax.wsdl.extensions.schema.SchemaImport;

public class TypesHelper {

    /*
     * Get the main schema from the target namespace.
     * This is get from the Types element in the WSDL.
     */
    public static Schema schema(Types types, String namespace){
        for(Object o : types.getExtensibilityElements()) {

            if (o instanceof Schema) {
                Schema sc = (Schema) o;

                if(sc.getElement().getAttribute("targetNamespace").equals(namespace)) {
                    return sc;
                }

                // When the schema has imports, search in the imports as well
                if(sc.getImports().size() > 0){
                    SchemaImport imp = SchemaHelper.findImport(sc, namespace);

                    if(imp != null && imp.getReferencedSchema() != null)
                        return imp.getReferencedSchema();
                }
            }
        }

        return null;
    }
}
