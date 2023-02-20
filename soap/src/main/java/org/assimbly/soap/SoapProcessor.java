package org.assimbly.soap;

import com.ibm.wsdl.extensions.soap.SOAPBodyImpl;
import com.ibm.wsdl.extensions.soap12.SOAP12BodyImpl;
import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.support.EndpointHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.InputSource;
import org.assimbly.util.Pair;
import org.assimbly.util.helper.ExchangeHelper;
import org.assimbly.util.helper.XmlHelper;
import org.assimbly.soap.domain.SoapAttribute;
import org.assimbly.soap.domain.SoapHeader;
import org.assimbly.soap.util.helpers.*;

import javax.wsdl.*;
import javax.wsdl.extensions.schema.Schema;
import javax.wsdl.extensions.schema.SchemaImport;
import javax.xml.namespace.QName;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.soap.*;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SoapProcessor implements Processor {

    private static final Logger LOG = LoggerFactory.getLogger(SoapProcessor.class);

    private SoapEndpoint endpoint;
    private Definition definition;

    public SoapProcessor() {}

    public SoapProcessor(SoapEndpoint endpoint) {
        this.endpoint = endpoint;
    }

    public void process(Exchange exchange) throws Exception {
        org.apache.camel.Message in = exchange.getIn();

        SoapConfiguration config = endpoint.getConfiguration();

        applyOverrideHeaders(exchange.getContext(),exchange.getIn().getHeaders(), config);

        definition = WSDLHelper.retrieve(config.getParameters(), config.getWsdl(), config.getHttpHeaders());

        if (definition == null) {
            throw new WSDLException("002",
                    String.format("Could not fetch WSDL Definition from specified WSDL: %s?%s",
                            config.getWsdl(), config.getParameters()
                    )
            );
        }

        String destination = null;

        // Initiate SOAP Envelope
        MessageFactory messageFactory = MessageFactory.newInstance();
        SOAPMessage soapMessage = messageFactory.createMessage();
        SOAPPart soapPart = soapMessage.getSOAPPart();
        SOAPEnvelope envelope = soapPart.getEnvelope();

        // Initiate Input as XML Document
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        factory.setNamespaceAware(true);
        factory.setValidating(true);

        DocumentBuilder builder = factory.newDocumentBuilder();

        // Use default error handler
        builder.setErrorHandler(null);

        Document inputXml = builder.parse(new InputSource(in.getBody(InputStream.class)));

        // Determine whether we should search for namespaces
        if (config.isSmart()) {
            if (in.getHeader("AssimblySoapDestination") != null)
                destination = in.getHeader("AssimblySoapDestination", String.class);

            inputXml = transform(definition, config.getAction(), envelope, inputXml);
        }

        config.getHeaders().forEach(header -> {
            try {
                addSOAPHeaders(definition, envelope, exchange, header, config.getAction());
            } catch (SOAPException e) { LOG.error(e.getMessage()); }
        });

        SOAPBody body = envelope.getBody();
        body.addDocument(inputXml);

        Pair<Definition, Binding> lookup = DefinitionHelper.binding(definition, config.getAction());

        if(lookup == null)
            throw new RuntimeException("Could not find SOAP Binding associated with this action");

        if(destination == null)
            destination = DefinitionHelper.destination(lookup.getKey(), lookup.getValue());

        // Add MIME Headers
        MimeHeaders headers = soapMessage.getMimeHeaders();
        mimeHeaders(lookup.getValue(), config).forEach(headers::addHeader);

        // Save SOAP Messages
        soapMessage.saveChanges();

        Map<String, Object> response = WSDLHelper.execute(destination, soapMessage, exchange);

        /*
         * When the extract parameter is "true" remove the SOAP Envelope element
         * and the SOAP Body element from the response.
         *
         * Eg. get only the XML.
         */
        if (config.isExtract()) {
            SOAPMessage soapResponse = (SOAPMessage) response.get("ResponseMessage");
            Node element = soapResponse.getSOAPBody().getFirstChild();

            // When first node is actually a text() node, get the second one
            if (element.getNodeName().startsWith("#"))
                element = soapResponse.getSOAPBody().getChildNodes().item(1);

            response.put("ResponseBody", XmlHelper.prettyPrint(element));
        }

        exchange.getIn().setBody(response.get("ResponseBody"));
    }

    private Map<String, String> mimeHeaders(Binding binding, SoapConfiguration config) throws IOException {
        Map<String, String> headers = new HashMap<>();

        BindingOperation operation = BindingHelper.operation(binding, config.getAction());

        if(operation != null)
            headers.put("SOAPAction", BindingOperationHelper.getOperationAction(operation));

        config.getHttpHeaders().forEach(httpHeader -> headers.put(httpHeader.getName(), httpHeader.getValue()));

        if (config.getAuth() != null && !config.getAuth().isEmpty())
            headers.put("Authorization", "Basic " + config.getAuth());

        return headers;
    }

    void applyOverrideHeaders(CamelContext context, Map<String, Object> headers, SoapConfiguration configuration) {

        headers.entrySet().stream()
            .filter(header -> EndpointHelper.matchEndpoint(context,header.getKey(), "AssimblySoap*"))
            .forEach(header -> {
                String prop = header.getKey().replace("AssimblySoap", "");
                prop = prop.substring(0, 1).toLowerCase() + prop.substring(1);

                try {
                    configuration.dynamicApply(prop, header.getValue());
                } catch (URISyntaxException e) {
                    LOG.error(e.getMessage());
                }
            });
    }

    /**
     * Creates a SOAPMessage object that can be sent to an SOAP Endpoint/
     *
     * @param definition is the requested WSDL definition.
     * @return a new instance of a <code>XML Document</code>
     * @throws Exception if there was an error in creating the
     *                   default implementation of the
     *                   <code>SOAPMessage</code>.
     * @see SoapComponent
     */
    Document transform(Definition definition, String action, SOAPEnvelope envelope, Document inputXml) throws Exception {
        Pair<Definition, Binding> lookup = DefinitionHelper.binding(definition, action);

        if(lookup == null)
            throw new RuntimeException("Could not find SOAP Binding associated with this action");

        // Binding can have been found in a different / imported definition.
        definition = lookup.getKey();
        Binding binding = lookup.getValue();

        Input input = PortTypeHelper.input(binding.getPortType(), action);

        if(input == null)
            throw new RuntimeException("Could not find SOAP Input associated with this action");

        BindingOperation operation = BindingHelper.operation(binding, action);

        if(operation == null)
            throw new RuntimeException("Could not find SOAP Operation associated with this action");

        // Copy over namespaces from the original document
        for (int x = 0; x < inputXml.getDocumentElement().getAttributes().getLength(); x++) {
            Node attr = inputXml.getDocumentElement().getAttributes().item(x);

            if (attr.getNodeName().contains("xmlns")) {
                if (attr.getNodeName().contains(":")) {
                    envelope.addNamespaceDeclaration(attr.getNodeName().split(":")[1], attr.getNodeValue());
                } else {
                    envelope.addNamespaceDeclaration("", attr.getNodeValue());
                }
            }
        }

        if(PartHelper.containsTypes(input)) {
            String namespaceURI = null;

            SOAPBodyImpl soapBody = BindingInputHelper.getSoapBody(operation.getBindingInput());

            if(soapBody != null) {
                namespaceURI = soapBody.getNamespaceURI();

            } else {
                SOAP12BodyImpl soap12Body = BindingInputHelper.getSoap12Body(operation.getBindingInput());

                if(soap12Body != null)
                    namespaceURI = soap12Body.getNamespaceURI();
            }

            if(action.equals(inputXml.getDocumentElement().getTagName()) && namespaceURI != null) {
                Element newRoot = addNamespacesToNodes(inputXml, namespaceURI, inputXml.getDocumentElement());
                inputXml.getDocumentElement().getParentNode().replaceChild(newRoot, inputXml.getDocumentElement());
            }

            for (Part part : PartHelper.getTypes(input)) {
                QName reference = part.getTypeName();

                List<Element> elements = XmlHelper.getChildrenByTagName(inputXml.getDocumentElement(), part.getName());

                for (Element element : elements) {
                    element.setAttribute("xmlns:xsd", reference.getNamespaceURI());
                    element.setAttributeNS(
                            "http://www.w3.org/2001/XMLSchema-instance",
                            "xsi:type",
                            "xsd:" + reference.getLocalPart());
                }
            }
        }

        if(PartHelper.containsElements(input)) {
            for (Part part : PartHelper.getElements(input)) {
                QName reference = part.getElementName();

                Schema schema = TypesHelper.schema(definition.getTypes(), reference.getNamespaceURI());

                if(schema == null){
                    Definition imp = DefinitionHelper.getImport(definition, reference);
                    schema = TypesHelper.schema(imp.getTypes(), reference.getNamespaceURI());
                }

                if (schema == null)
                    throw new WSDLException("000", "Couldn't find XSD Schema for input message");

                // Declare Namespaces in the SOAP Envelope
                envelope.addNamespaceDeclaration("tns", reference.getNamespaceURI());

                // Add Namespace prefix for necessary nodes
                Node declarationNode = SchemaHelper.findElementByName(schema, reference.getLocalPart());

                Element context = inputXml.getDocumentElement();

                if(declarationNode != null)
                    addRecursiveNamespaces(declarationNode, inputXml, context, reference.getNamespaceURI(), schema);
            }
        }

        return inputXml;
    }

    public void addSOAPHeaders(Definition definition, SOAPEnvelope envelope, Exchange exchange, SoapHeader header, String action) throws SOAPException {
        // Declare SOAP Headers
        // hasAttributes only returns true if there are attributes with values defined
        if (header.hasAttributes()) {
            SOAPHeader soapHeader = envelope.getHeader();

            String namespace;
            String reference;

            Pair<Definition, Binding> lookup = DefinitionHelper.binding(definition, action);

            if(lookup == null)
                throw new RuntimeException("Could not get Soap Binding associated with this Soap Action");

            definition = lookup.getKey();

            BindingOperation operation = BindingHelper.operation(lookup.getValue(), action);

            BindingInput bindingInput = operation.getBindingInput();

            Part part = BindingInputHelper.getHeaderPart(bindingInput, definition.getMessages(), header.getName());

            if(part == null)
                throw new RuntimeException("Could not get Part associated with this Soap Header.");

            namespace = part.getElementName().getNamespaceURI();
            reference = part.getElementName().getLocalPart();

            if(namespace == null)
                throw new RuntimeException("Could not determine namespace of the Soap Header's message part");

            Schema headerSchema = TypesHelper.schema(definition.getTypes(), namespace);

            if(headerSchema == null)
                throw new RuntimeException("Could not find schema associated with the header's message part namespace");

            Node declaration = SchemaHelper.findElementByName(headerSchema, reference);

            if(declaration == null)
                throw new RuntimeException("Could not find node in referenced schema");


            QName headerQName = new QName(namespace, reference, "ns");
            SOAPHeaderElement el = soapHeader.addHeaderElement(headerQName);

            for (SoapAttribute attribute : header.getAttrs()) {
                if (attribute.getValue().isEmpty())
                    continue;

                QName headerQNameVal = new QName(attribute.getValue());

                if (shouldQualify(headerSchema, declaration))
                    headerQNameVal = new QName(namespace, attribute.getName(), "ns");

                SOAPElement elem = el.addChildElement(headerQNameVal);

                elem.addTextNode(
                        ExchangeHelper.interpolate(attribute.getValue(), exchange)
                );
            }
        }
    }

    /**
     * Adds the corresponding namespaces to the input XML nodes recursively.
     * Input XML comes from the <code>Camel Exchange</code>.
     *
     * @param node           declaration of the node that needs a namespace prefix.
     * @param context        the context within the node should be replaced.
     * @param namespaceUri   defines which namespace reference the node should get.
     * @param originalSchema where the declaration node was found in.
     * @see SoapComponent
     */
    private void addRecursiveNamespaces(Node node, Document document, Element context, String namespaceUri, Schema originalSchema) {
        if (node.getNodeName().startsWith("#")) {
            return;
        }

        Node name = NodeHelper.getNamedAttribute(node, "name");

        if (name != null && (!XmlHelper.getChildrenByTagName(context, name.getNodeValue()).isEmpty() || context.getNodeName().equals(name.getNodeValue()))) {
            List<Element> nodesToReplace = new ArrayList<>();

            if(XmlHelper.getChildrenByTagName(context, name.getNodeValue()).size() > 0)
                nodesToReplace.addAll(XmlHelper.getChildrenByTagName(context, name.getNodeValue()));

            if(context.getNodeName().equals(name.getNodeValue()))
                nodesToReplace.add(context);

            for (Element nodeToReplace : nodesToReplace) {

                Element replaced;
                if(shouldQualify(originalSchema, node)) {
                    Element newNode = addNamespacesToNodes(document, namespaceUri, nodeToReplace);
                    nodeToReplace.getParentNode().replaceChild(newNode, nodeToReplace);

                    replaced = newNode;
                }else{
                    replaced = nodeToReplace;
                }

                if (node.hasChildNodes())
                    addNamespacesToChildNodes(node, document, namespaceUri, originalSchema, replaced);

            }
        } else {
            if (node.hasChildNodes())
                addNamespacesToChildNodes(node, document, namespaceUri, originalSchema, context);

        }

        if (NodeHelper.isReference(node) || NodeHelper.isType(node) || NodeHelper.isExtension(node))
            runWithReferencedDeclarationNode(node, originalSchema, context, document);

    }

    private Element addNamespacesToNodes(Document document, String namespaceUri, Node nodeToReplace) {
        Element newNode = document.createElementNS(namespaceUri, "ns:" + nodeToReplace.getNodeName());

        for (int i = 0; i < nodeToReplace.getAttributes().getLength(); i++) {
            Node attr = nodeToReplace.getAttributes().item(i);

            newNode.getAttributes().setNamedItem(document.importNode(attr, true));
        }

        if (nodeToReplace.hasChildNodes()) {
            for (int c = 0; c < nodeToReplace.getChildNodes().getLength(); c++) {
                Node child = nodeToReplace.getChildNodes().item(c);

                newNode.appendChild(document.importNode(child, true));
            }
        }

        return newNode;
    }

    private void addNamespacesToChildNodes(Node node, Document document, String namespaceUri, Schema originalSchema, Element replaced) {
        for (int r = 0, len = node.getChildNodes().getLength(); r < len; r++) {
            Node child = node.getChildNodes().item(r);

            addRecursiveNamespaces(child, document, replaced, namespaceUri, originalSchema);
        }
    }

    public void runWithReferencedDeclarationNode(Node node, Schema originSchema, Element context, Document document) {
        // Here we determined that the node we are having is a declaration node of some sorts
        // 1. Find the according element(s) in the context given

        Node attr;

        if (NodeHelper.isReference(node))
            attr = NodeHelper.getNamedAttribute(node, "ref");

        else if (NodeHelper.isExtension(node))
            attr = NodeHelper.getNamedAttribute(node, "base");

        else
            attr = NodeHelper.getNamedAttribute(node, "type");

        Schema referredSchema;

        if(NodeHelper.hasInlineNamespace(node))
            referredSchema = getReferredSchema(definition, node, attr, originSchema);

        else
            referredSchema = getReferredSchema(definition, node, attr, originSchema);

        if (referredSchema != null) {
            Node match;

            if(NodeHelper.isType(node) || NodeHelper.isExtension(node))
                match = SchemaHelper.findTypeByName(referredSchema, NodeHelper.getName(attr));
            else
                match = SchemaHelper.findElementByName(referredSchema, NodeHelper.getName(attr));

            if (match != null) {
                List<Element> matches = new ArrayList<>();

                if (NodeHelper.isType(node))
                    matches = XmlHelper.getChildrenByTagName(context, "ns:" + NodeHelper.getNamedAttribute(node, "name").getNodeValue());

                String namespace = referredSchema.getElement().getAttribute("targetNamespace");

                if (matches.size() > 0)
                    matches.forEach(m -> addRecursiveNamespaces(match, document, m, namespace, referredSchema));
                else
                    addRecursiveNamespaces(match, document, context, namespace, referredSchema);
            }
        }
    }

    public Schema getReferredSchema(Definition definition, Node origin, Node attr, Schema originSchema){
        Element schema = originSchema.getElement();

        if(NodeHelper.hasPrefix(attr)) {
            String namespace = null;

            // See if it is defined in the node itself
            if(NodeHelper.hasNamedAttribute(origin, "xmlns:" + NodeHelper.getPrefix(attr)))
                namespace = NodeHelper.getNamedAttribute(origin,"xmlns:" + NodeHelper.getPrefix(attr)).getNodeValue();

            // Firs check if the namespace is declared in the current schema element
            if((namespace == null || namespace.isEmpty()) && NodeHelper.hasNamedAttribute(schema, "xmlns:" + NodeHelper.getPrefix(attr)))
                namespace = NodeHelper.getNamedAttribute(schema, "xmlns:" + NodeHelper.getPrefix(attr)).getNodeValue();

            // See if it is defined in the definition
            if((namespace == null || namespace.isEmpty()) && definition.getNamespaces().containsKey(NodeHelper.getPrefix(attr)))
                namespace = definition.getNamespace(NodeHelper.getPrefix(attr));

            // Namespace should now be found
            if(namespace != null && !namespace.isEmpty()) {
                Schema ref = TypesHelper.schema(definition.getTypes(), namespace);

                if (ref != null)
                    return ref;

                SchemaImport imp = SchemaHelper.findImport(originSchema, namespace);

                if (imp != null)
                    return imp.getReferencedSchema();

                if (namespace.equals(schema.getAttribute("targetNamespace")))
                    return originSchema;
            }
        }

        return null;
    }

    private boolean shouldQualify(Schema schema, Node node){
        boolean hasSchemaDefault = NodeHelper.hasNamedAttribute(schema.getElement(), "elementFormDefault");
        boolean hasNodeOverride = NodeHelper.hasNamedAttribute(node, "form");

        boolean qualified = (hasSchemaDefault && isQualified(schema.getElement(), "elementFormDefault"));

        if (hasNodeOverride)
            qualified = isQualified(node, "form");

        return qualified;
    }

    private boolean isQualified(Node node, String attr) {
        return NodeHelper.getNamedAttribute(node, attr).getNodeValue().equals("qualified");
    }

    // For test purposes only
    public void setDefinition(Definition definition) {
        this.definition = definition;
    }
}
