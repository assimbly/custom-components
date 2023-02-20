package org.assimbly.soap.util.helpers;

import org.assimbly.util.Pair;

import javax.wsdl.*;
import javax.wsdl.extensions.ExtensibilityElement;
import javax.wsdl.extensions.soap.SOAPAddress;
import javax.wsdl.extensions.soap12.SOAP12Address;
import javax.xml.namespace.QName;
import java.util.*;

public final class DefinitionHelper {

    public static Definition getImport(Definition definition, QName toImport){
        // Get First
        Import imp = (Import) definition.getImports(toImport.getNamespaceURI()).get(0);

        return imp.getDefinition();
    }

    @SuppressWarnings("rawtypes")
    public static List<Definition> getImportedDefinitions(Map imports) {
        List<Definition> definitions = new ArrayList<>();

        for (Object o : imports.values()) {
            Vector importDefs = (Vector) o;

            for (Object importDef1 : importDefs) {
                Import importDef = (Import) importDef1;
                definitions.add(
                        importDef.getDefinition()
                );
            }
        }

        return definitions;
    }

    /**
     * Determine the url it needs to post the SOAP Reqest to.
     * This is get from the <service> element of the WSDL.
     *
     * @param definition is the target's WSDL Definition object.
     * @return destination url used to call the webservice, in type: String.
     */
    public static String destination(Definition definition, Binding binding) {
        for (Object s : definition.getAllServices().keySet()) {
            Service service = (Service) definition.getAllServices().get(s);

            Port port = ServiceHelper.portByBinding(service, binding);

            if(port != null){
                ExtensibilityElement el = PortHelper.address(port);

                if(el instanceof SOAP12Address)
                    return ((SOAP12Address) el).getLocationURI();

                if(el instanceof SOAPAddress)
                    return ((SOAPAddress) el).getLocationURI();
            }
        }

        return "";
    }

    public static Pair<Definition, Binding> binding(Definition definition, String action) {
        for (Object key : definition.getBindings().keySet()) {
            Binding binding = (Binding) definition.getBindings().get(key);

            BindingOperation operation = BindingHelper.operation(binding, action);

            if (operation != null) {
                return new Pair<>(definition, binding);
            }
        }

        List<Definition> imports = DefinitionHelper.getImportedDefinitions(definition.getImports());

        for (Definition imported : imports) {
            Pair<Definition, Binding> binding = binding(imported, action);

            if(binding != null) {
                return binding;
            }
        }

        return null;
    }
}
