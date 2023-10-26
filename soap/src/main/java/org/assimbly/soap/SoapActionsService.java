package org.assimbly.soap;

import com.ibm.wsdl.extensions.soap.SOAPHeaderImpl;
import com.ibm.wsdl.extensions.soap12.SOAP12HeaderImpl;
import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.assimbly.auth.endpoint.annotation.Secured;
import org.assimbly.soap.domain.SoapAction;
import org.assimbly.soap.domain.SoapAttribute;
import org.assimbly.soap.domain.SoapHeader;
import org.assimbly.soap.domain.SoapHttpHeader;
import org.assimbly.soap.util.helpers.*;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.core.MediaType;
import javax.wsdl.*;
import javax.wsdl.extensions.schema.Schema;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.*;

@Secured
@Consumes(MediaType.APPLICATION_JSON)
public class SoapActionsService {

    private static final Logger LOG = LoggerFactory.getLogger(SoapActionsService.class);

    public String getSoapActions(String url) throws WSDLException, IOException, URISyntaxException {

        System.out.println("x");
        List<SoapAction> list = getSoapActionsList(url);
        // add elements to the list

        JSONArray jsonArray = new JSONArray();
        for (Object obj : list) {
            JSONObject json = new JSONObject(obj);
            jsonArray.put(json);
        }

        return jsonArray.toString(4);
    }
    public List<SoapAction> getSoapActionsList(String wsdl) throws WSDLException, IOException, URISyntaxException {
        List<SoapAction> results = new ArrayList<>();
        List<String> added = new ArrayList<>();
        List<SoapHttpHeader> httpHeaders = new ArrayList<>();

        JSONObject jsonWsdl = new JSONObject(wsdl);

        if(jsonWsdl.has("token")) {
            httpHeaders.add(
                    new SoapHttpHeader("ApiToken", jsonWsdl.getString("token"))
            );
        }

        Definition definition = WSDLHelper.retrieve("", jsonWsdl.getString("url"), httpHeaders);

        findActionsByDefinition(definition, results, added);

        @SuppressWarnings("rawtypes")
        Map imports = definition.getImports();
        DefinitionHelper.getImportedDefinitions(imports).forEach(
                imported -> findActionsByDefinition(imported, results, added)
        );

        return results;
    }

    private List<SoapHeader> getHeadersByOperation(Definition definition, BindingOperation operation) {
        List<SoapHeader> result = new ArrayList<>();

        BindingInput input = operation.getBindingInput();

        List<SOAPHeaderImpl> soapHeaders = BindingInputHelper.getSoapHeaders(input);

        for (SOAPHeaderImpl soapHeader : soapHeaders) {
            Message message = (Message) definition.getMessages().get(soapHeader.getMessage());

            // message not found in main wsdl, check imports
            if(message == null){
                definition = DefinitionHelper.getImport(definition, soapHeader.getMessage());
                message = (Message) definition.getMessages().get(soapHeader.getMessage());
            }

            if(message == null)
                continue;

            Part part = message.getPart(soapHeader.getPart());

            String namespace = part.getElementName().getNamespaceURI();
            String reference = part.getElementName().getLocalPart();

            SoapHeader header = new SoapHeader(reference);

            Node declaration = getDeclaration(definition, namespace, reference);

            if (declaration == null)
                continue;

            header.setAttrs(getAttributesFromDeclaration(declaration));

            result.add(header);
        }

        List<SOAP12HeaderImpl> soap12Headers = BindingInputHelper.getSoap12Headers(input);

        for (SOAP12HeaderImpl soapHeader : soap12Headers) {
            Message message = (Message) definition.getMessages().get(soapHeader.getMessage());

            // message not found in main wsdl, check imports
            if(message == null){
                definition = DefinitionHelper.getImport(definition, soapHeader.getMessage());
                message = (Message) definition.getMessages().get(soapHeader.getMessage());
            }

            if(message == null)
                continue;

            Part part = message.getPart(soapHeader.getPart());

            String namespace = part.getElementName().getNamespaceURI();
            String reference = part.getElementName().getLocalPart();

            SoapHeader header = new SoapHeader(reference);

            Node declaration = getDeclaration(definition, namespace, reference);

            if (declaration == null)
                continue;

            header.setAttrs(getAttributesFromDeclaration(declaration));

            result.add(header);
        }

        return result;
    }

    private List<SoapAttribute> getAttributesFromDeclaration(Node declaration) {
        List<SoapAttribute> result = new ArrayList<>();
        NodeList childs = declaration.getChildNodes();

        for (int i = 0; i < childs.getLength(); i++) {
            Node child = childs.item(i);

            if (NodeHelper.hasNamedAttribute(child, "name")) {
                Node attr = NodeHelper.getNamedAttribute(child, "name");

                result.add(new SoapAttribute(attr.getNodeValue()));
            }

            if(child.hasChildNodes())
                result.addAll(getAttributesFromDeclaration(child));
        }

        return result;
    }

    private Node getDeclaration(Definition definition, String namespace, String reference) {
        Schema headerSchema = TypesHelper.schema(definition.getTypes(), namespace);

        if (headerSchema == null)
            return null;

        Node declaration = SchemaHelper.findElementByName(headerSchema, reference);

        if (declaration == null)
            return null;

        if (NodeHelper.isReference(declaration) || NodeHelper.isType(declaration)) {
            declaration = getReferencedDeclaration(definition, headerSchema, declaration);
        }

        return declaration;
    }

    private Node getReferencedDeclaration(Definition definition, Schema originSchema, Node declaration) {
        if (NodeHelper.isReference(declaration)) {
            Node attr = NodeHelper.getNamedAttribute(declaration, "ref");

            Schema referredSchema = new SoapProcessor().getReferredSchema(definition, declaration, attr, originSchema);

            if (referredSchema != null) {
                return SchemaHelper.findElementByName(referredSchema, NodeHelper.getName(attr));
            }
        } else {
            Node attr = NodeHelper.getNamedAttribute(declaration, "type");

            Schema referredSchema = new SoapProcessor().getReferredSchema(definition, declaration, attr, originSchema);

            if (referredSchema != null) {
                return SchemaHelper.findTypeByName(referredSchema, NodeHelper.getName(attr));
            }
        }

        return null;
    }

    private void findActionsByDefinition(Definition definition, List<SoapAction> actions, List<String> added) {
        for (Object key : definition.getBindings().keySet()) {
            Binding binding = (Binding) definition.getBindings().get(key);

            for (Object object : binding.getBindingOperations()) {
                BindingOperation operation = (BindingOperation) object;

                if(added.contains(operation.getName()))
                    continue;

                SoapAction action = new SoapAction(operation.getName());

                action.setHeaders(getHeadersByOperation(definition, operation));

                actions.add(action);
                added.add(action.getName());
            }
        }
    }
}