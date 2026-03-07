package org.assimbly.soap;

import org.assimbly.soap.util.helpers.*;
import jakarta.xml.soap.*;
import javax.wsdl.*;

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

import javax.wsdl.extensions.schema.Schema;
import javax.wsdl.extensions.schema.SchemaImport;
import javax.xml.namespace.QName;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
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

    // -------------------------------------------------------------------------
    // Main entry point
    // -------------------------------------------------------------------------

    public void process(Exchange exchange) throws Exception {
        SoapConfiguration config = endpoint.getConfiguration();

        applyOverrideHeaders(exchange.getContext(), exchange.getIn().getHeaders(), config);

        definition = fetchDefinition(config);

        SOAPMessage soapMessage = buildSoapMessage(exchange, config);

        Pair<Definition, Binding> lookup = requireBinding(definition, config.getAction());
        String destination = resolveDestination(exchange, lookup, config);

        applyMimeHeaders(soapMessage, lookup.getValue(), config);

        soapMessage.saveChanges();

        Map<String, Object> response = WSDLHelper.execute(destination, soapMessage, exchange);

        byte[] responseBytes = extractResponse((SOAPMessage) response.get("ResponseMessage"), config);
        exchange.getIn().setBody(responseBytes);
    }

    // -------------------------------------------------------------------------
    // process() helpers
    // -------------------------------------------------------------------------

    private Definition fetchDefinition(SoapConfiguration config) throws WSDLException, IOException {
        Definition def = WSDLHelper.retrieve(config.getParameters(), config.getWsdl(), config.getHttpHeaders());

        if (def == null) {
            throw new WSDLException("002",
                    "Could not fetch WSDL Definition from specified WSDL: %s?%s".formatted(
                            config.getWsdl(), config.getParameters()));
        }

        return def;
    }

    private SOAPMessage buildSoapMessage(Exchange exchange, SoapConfiguration config) throws Exception {
        MessageFactory messageFactory = MessageFactory.newInstance();
        SOAPMessage soapMessage = messageFactory.createMessage();
        SOAPEnvelope envelope = soapMessage.getSOAPPart().getEnvelope();

        Document inputXml = parseInputXml(exchange.getIn().getBody(InputStream.class));

        if (config.isSmart())
            inputXml = transform(definition, config.getAction(), envelope, inputXml);

        addConfiguredSoapHeaders(definition, envelope, exchange, config);

        envelope.getBody().addDocument(inputXml);

        return soapMessage;
    }

    private Document parseInputXml(InputStream inputStream) throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        factory.setValidating(true);

        DocumentBuilder builder = factory.newDocumentBuilder();
        builder.setErrorHandler(null);

        return builder.parse(new InputSource(inputStream));
    }

    private void addConfiguredSoapHeaders(Definition def, SOAPEnvelope envelope, Exchange exchange, SoapConfiguration config) {
        config.getHeaders().forEach(header -> {
            try {
                addSOAPHeaders(def, envelope, exchange, header, config.getAction());
            } catch (SOAPException e) {
                LOG.error(e.getMessage());
            }
        });
    }

    private String resolveDestination(Exchange exchange, Pair<Definition, Binding> lookup, SoapConfiguration config) {
        String destination = exchange.getIn().getHeader("AssimblySoapDestination", String.class);

        return destination != null
                ? destination
                : DefinitionHelper.destination(lookup.getKey(), lookup.getValue());
    }

    private void applyMimeHeaders(SOAPMessage soapMessage, Binding binding, SoapConfiguration config) {
        MimeHeaders headers = soapMessage.getMimeHeaders();
        mimeHeaders(binding, config).forEach(headers::addHeader);
    }

    private byte[] extractResponse(SOAPMessage soapResponse, SoapConfiguration config) throws Exception {
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        if (config.isExtract()) {
            Node element = firstMeaningfulChild(soapResponse.getSOAPBody());
            out.write(XmlHelper.prettyPrint(element).getBytes(StandardCharsets.UTF_8));
        } else {
            soapResponse.writeTo(out);
        }

        return out.toByteArray();
    }

    private Node firstMeaningfulChild(SOAPBody body) {
        Node element = body.getFirstChild();

        if (element.getNodeName().startsWith("#"))
            element = body.getChildNodes().item(1);

        return element;
    }

    // -------------------------------------------------------------------------
    // MIME headers
    // -------------------------------------------------------------------------

    private Map<String, String> mimeHeaders(Binding binding, SoapConfiguration config) {
        Map<String, String> headers = new HashMap<>();

        addSoapActionHeader(headers, binding, config);
        addHttpHeaders(headers, config);
        addAuthHeader(headers, config);

        return headers;
    }

    private void addSoapActionHeader(Map<String, String> headers, Binding binding, SoapConfiguration config) {
        BindingOperation operation = BindingHelper.operation(binding, config.getAction());

        if (operation != null)
            headers.put("SOAPAction", BindingOperationHelper.getOperationAction(operation));
    }

    private void addHttpHeaders(Map<String, String> headers, SoapConfiguration config) {
        config.getHttpHeaders().forEach(h -> headers.put(h.getName(), h.getValue()));
    }

    private void addAuthHeader(Map<String, String> headers, SoapConfiguration config) {
        if (config.getAuth() != null && !config.getAuth().isEmpty())
            headers.put("Authorization", "Basic " + config.getAuth());
    }

    // -------------------------------------------------------------------------
    // Override headers
    // -------------------------------------------------------------------------

    void applyOverrideHeaders(CamelContext context, Map<String, Object> headers, SoapConfiguration configuration) {
        headers.entrySet().stream()
                .filter(header -> EndpointHelper.matchEndpoint(context, header.getKey(), "AssimblySoap*"))
                .forEach(header -> applyOverrideHeader(header, configuration));
    }

    private void applyOverrideHeader(Map.Entry<String, Object> header, SoapConfiguration configuration) {
        String prop = toCamelCase(header.getKey().replace("AssimblySoap", ""));

        try {
            configuration.dynamicApply(prop, header.getValue());
        } catch (URISyntaxException e) {
            LOG.error(e.getMessage());
        }
    }

    private String toCamelCase(String value) {
        return value.substring(0, 1).toLowerCase() + value.substring(1);
    }

    // -------------------------------------------------------------------------
    // Transform
    // -------------------------------------------------------------------------

    Document transform(Definition definition, String action, SOAPEnvelope envelope, Document inputXml) throws Exception {
        Pair<Definition, Binding> lookup = requireBinding(definition, action);

        definition = lookup.getKey();
        Binding binding = lookup.getValue();

        Input input = requireInput(binding.getPortType(), action);
        requireOperation(binding, action);

        copyNamespaceDeclarations(inputXml, envelope);

        if (PartHelper.containsTypes(input))
            inputXml = applyTypeParts(inputXml, input, action, BindingHelper.operation(binding, action));

        if (PartHelper.containsElements(input))
            applyElementParts(inputXml, input, definition, envelope);

        return inputXml;
    }

    private void copyNamespaceDeclarations(Document inputXml, SOAPEnvelope envelope) throws SOAPException {
        for (int i = 0; i < inputXml.getDocumentElement().getAttributes().getLength(); i++) {
            Node attr = inputXml.getDocumentElement().getAttributes().item(i);

            if (!attr.getNodeName().contains("xmlns"))
                continue;

            if (attr.getNodeName().contains(":"))
                envelope.addNamespaceDeclaration(attr.getNodeName().split(":")[1], attr.getNodeValue());
            else
                envelope.addNamespaceDeclaration("", attr.getNodeValue());
        }
    }

    private Document applyTypeParts(Document inputXml, Input input, String action, BindingOperation operation) {
        String namespaceURI = resolveSoapBodyNamespace(operation);

        if (namespaceURI != null && action.equals(inputXml.getDocumentElement().getTagName())) {
            Element newRoot = addNamespacesToNodes(inputXml, namespaceURI, inputXml.getDocumentElement());
            inputXml.getDocumentElement().getParentNode().replaceChild(newRoot, inputXml.getDocumentElement());
        }

        for (Part part : PartHelper.getTypes(input))
            applyTypeAnnotations(inputXml, part);

        return inputXml;
    }

    private String resolveSoapBodyNamespace(BindingOperation operation) {
        SOAPBodyImpl soapBody = BindingInputHelper.getSoapBody(operation.getBindingInput());

        if (soapBody != null)
            return soapBody.getNamespaceURI();

        SOAP12BodyImpl soap12Body = BindingInputHelper.getSoap12Body(operation.getBindingInput());

        return soap12Body != null ? soap12Body.getNamespaceURI() : null;
    }

    private void applyTypeAnnotations(Document inputXml, Part part) {
        QName reference = part.getTypeName();

        for (Element element : XmlHelper.getChildrenByTagName(inputXml.getDocumentElement(), part.getName())) {
            element.setAttribute("xmlns:xsd", reference.getNamespaceURI());
            element.setAttributeNS(
                    "http://www.w3.org/2001/XMLSchema-instance",
                    "xsi:type",
                    "xsd:" + reference.getLocalPart());
        }
    }

    private void applyElementParts(Document inputXml, Input input, Definition definition, SOAPEnvelope envelope) throws Exception {
        for (Part part : PartHelper.getElements(input)) {
            QName reference = part.getElementName();
            Schema schema = resolveSchema(definition, reference);

            envelope.addNamespaceDeclaration("tns", reference.getNamespaceURI());

            Node declarationNode = SchemaHelper.findElementByName(schema, reference.getLocalPart());

            if (declarationNode != null)
                addRecursiveNamespaces(declarationNode, inputXml, inputXml.getDocumentElement(), reference.getNamespaceURI(), schema);
        }
    }

    private Schema resolveSchema(Definition definition, QName reference) throws WSDLException {
        Schema schema = TypesHelper.schema(definition.getTypes(), reference.getNamespaceURI());

        if (schema == null) {
            Definition imported = DefinitionHelper.getImport(definition, reference);
            schema = TypesHelper.schema(imported.getTypes(), reference.getNamespaceURI());
        }

        if (schema == null)
            throw new WSDLException("000", "Couldn't find XSD Schema for input message");

        return schema;
    }

    // -------------------------------------------------------------------------
    // SOAP Headers
    // -------------------------------------------------------------------------

    public void addSOAPHeaders(Definition definition, SOAPEnvelope envelope, Exchange exchange, SoapHeader header, String action) throws SOAPException {
        if (!header.hasAttributes())
            return;

        Pair<Definition, Binding> lookup = requireBinding(definition, action);
        definition = lookup.getKey();

        Part part = resolveHeaderPart(definition, lookup.getValue(), header, action);
        String namespace = requireNamespace(part);

        Schema headerSchema = requireHeaderSchema(definition, namespace);
        Node declaration = requireDeclaration(headerSchema, part.getElementName().getLocalPart());

        SOAPHeaderElement el = envelope.getHeader().addHeaderElement(
                new QName(namespace, part.getElementName().getLocalPart(), "ns"));

        addHeaderAttributes(el, header, exchange, headerSchema, declaration, namespace);
    }

    private Part resolveHeaderPart(Definition definition, Binding binding, SoapHeader header, String action) {
        BindingOperation operation = BindingHelper.operation(binding, action);
        Part part = BindingInputHelper.getHeaderPart(operation.getBindingInput(), definition.getMessages(), header.getName());

        if (part == null)
            throw new RuntimeException("Could not get Part associated with this Soap Header.");

        return part;
    }

    private String requireNamespace(Part part) {
        String namespace = part.getElementName().getNamespaceURI();

        if (namespace == null)
            throw new RuntimeException("Could not determine namespace of the Soap Header's message part");

        return namespace;
    }

    private Schema requireHeaderSchema(Definition definition, String namespace) {
        Schema schema = TypesHelper.schema(definition.getTypes(), namespace);

        if (schema == null)
            throw new RuntimeException("Could not find schema associated with the header's message part namespace");

        return schema;
    }

    private Node requireDeclaration(Schema schema, String reference) {
        Node declaration = SchemaHelper.findElementByName(schema, reference);

        if (declaration == null)
            throw new RuntimeException("Could not find node in referenced schema");

        return declaration;
    }

    private void addHeaderAttributes(SOAPHeaderElement el, SoapHeader header, Exchange exchange, Schema schema, Node declaration, String namespace) throws SOAPException {
        for (SoapAttribute attribute : header.getAttrs()) {
            if (attribute.getValue().isEmpty())
                continue;

            QName qName = shouldQualify(schema, declaration)
                    ? new QName(namespace, attribute.getName(), "ns")
                    : new QName(attribute.getValue());

            el.addChildElement(qName)
                    .addTextNode(ExchangeHelper.interpolate(attribute.getValue(), exchange));
        }
    }

    // -------------------------------------------------------------------------
    // Recursive namespace application
    // -------------------------------------------------------------------------

    private void addRecursiveNamespaces(Node node, Document document, Element context, String namespaceUri, Schema originalSchema) {
        if (node.getNodeName().startsWith("#"))
            return;

        Node nameAttr = NodeHelper.getNamedAttribute(node, "name");

        if (nameAttr != null && matchesContext(nameAttr.getNodeValue(), context)) {
            processMatchingNodes(node, document, context, namespaceUri, originalSchema, nameAttr.getNodeValue());
        } else if (node.hasChildNodes()) {
            addNamespacesToChildNodes(node, document, namespaceUri, originalSchema, context);
        }

        if (NodeHelper.isReference(node) || NodeHelper.isType(node) || NodeHelper.isExtension(node))
            runWithReferencedDeclarationNode(node, originalSchema, context, document);
    }

    private boolean matchesContext(String name, Element context) {
        return !XmlHelper.getChildrenByTagName(context, name).isEmpty()
                || context.getNodeName().equals(name);
    }

    private void processMatchingNodes(Node node, Document document, Element context, String namespaceUri, Schema originalSchema, String name) {
        List<Element> nodesToReplace = collectMatchingElements(context, name);

        for (Element nodeToReplace : nodesToReplace) {
            Element replaced = replaceWithNamespacedNode(node, document, nodeToReplace, namespaceUri, originalSchema);

            if (node.hasChildNodes())
                addNamespacesToChildNodes(node, document, namespaceUri, originalSchema, replaced);
        }
    }

    private List<Element> collectMatchingElements(Element context, String name) {

        List<Element> elements = new ArrayList<>(XmlHelper.getChildrenByTagName(context, name));

        if (context.getNodeName().equals(name))
            elements.add(context);

        return elements;
    }

    private Element replaceWithNamespacedNode(Node node, Document document, Element nodeToReplace, String namespaceUri, Schema originalSchema) {
        if (!shouldQualify(originalSchema, node))
            return nodeToReplace;

        Element newNode = addNamespacesToNodes(document, namespaceUri, nodeToReplace);
        nodeToReplace.getParentNode().replaceChild(newNode, nodeToReplace);

        return newNode;
    }

    private Element addNamespacesToNodes(Document document, String namespaceUri, Node nodeToReplace) {
        Element newNode = document.createElementNS(namespaceUri, "ns:" + nodeToReplace.getNodeName());

        copyAttributes(document, nodeToReplace, newNode);
        copyChildren(document, nodeToReplace, newNode);

        return newNode;
    }

    private void copyAttributes(Document document, Node source, Element target) {
        for (int i = 0; i < source.getAttributes().getLength(); i++) {
            Node attr = source.getAttributes().item(i);
            target.getAttributes().setNamedItem(document.importNode(attr, true));
        }
    }

    private void copyChildren(Document document, Node source, Element target) {
        for (int i = 0; i < source.getChildNodes().getLength(); i++) {
            target.appendChild(document.importNode(source.getChildNodes().item(i), true));
        }
    }

    private void addNamespacesToChildNodes(Node node, Document document, String namespaceUri, Schema originalSchema, Element context) {
        for (int i = 0, len = node.getChildNodes().getLength(); i < len; i++) {
            addRecursiveNamespaces(node.getChildNodes().item(i), document, context, namespaceUri, originalSchema);
        }
    }

    // -------------------------------------------------------------------------
    // Referenced declaration node resolution
    // -------------------------------------------------------------------------

    public void runWithReferencedDeclarationNode(Node node, Schema originSchema, Element context, Document document) {
        Node attr = resolveReferenceAttribute(node);
        Schema referredSchema = getReferredSchema(definition, node, attr, originSchema);

        if (referredSchema == null)
            return;

        Node match = findMatchInSchema(node, attr, referredSchema);

        if (match == null)
            return;

        String namespace = referredSchema.getElement().getAttribute("targetNamespace");
        List<Element> matches = collectTypeMatches(node, context);

        if (!matches.isEmpty())
            matches.forEach(m -> addRecursiveNamespaces(match, document, m, namespace, referredSchema));
        else
            addRecursiveNamespaces(match, document, context, namespace, referredSchema);
    }

    private Node resolveReferenceAttribute(Node node) {
        if (NodeHelper.isReference(node)) return NodeHelper.getNamedAttribute(node, "ref");
        if (NodeHelper.isExtension(node))  return NodeHelper.getNamedAttribute(node, "base");
        return NodeHelper.getNamedAttribute(node, "type");
    }

    private Node findMatchInSchema(Node node, Node attr, Schema schema) {
        return (NodeHelper.isType(node) || NodeHelper.isExtension(node))
                ? SchemaHelper.findTypeByName(schema, NodeHelper.getName(attr))
                : SchemaHelper.findElementByName(schema, NodeHelper.getName(attr));
    }

    private List<Element> collectTypeMatches(Node node, Element context) {
        if (!NodeHelper.isType(node))
            return new ArrayList<>();

        return XmlHelper.getChildrenByTagName(context, "ns:" + NodeHelper.getNamedAttribute(node, "name").getNodeValue());
    }

    // -------------------------------------------------------------------------
    // Schema resolution
    // -------------------------------------------------------------------------

    public Schema getReferredSchema(Definition definition, Node origin, Node attr, Schema originSchema) {
        if (!NodeHelper.hasPrefix(attr))
            return null;

        String namespace = resolveNamespaceForPrefix(definition, origin, attr, originSchema.getElement());

        if (namespace == null || namespace.isEmpty())
            return null;

        return findSchemaByNamespace(definition, originSchema, namespace);
    }

    private String resolveNamespaceForPrefix(Definition definition, Node origin, Node attr, Element schema) {
        String prefix = NodeHelper.getPrefix(attr);
        String namespace = null;

        if (NodeHelper.hasNamedAttribute(origin, "xmlns:" + prefix))
            namespace = NodeHelper.getNamedAttribute(origin, "xmlns:" + prefix).getNodeValue();

        if (isEmpty(namespace) && NodeHelper.hasNamedAttribute(schema, "xmlns:" + prefix))
            namespace = NodeHelper.getNamedAttribute(schema, "xmlns:" + prefix).getNodeValue();

        if (isEmpty(namespace) && definition.getNamespaces().containsKey(prefix))
            namespace = definition.getNamespace(prefix);

        return namespace;
    }

    private Schema findSchemaByNamespace(Definition definition, Schema originSchema, String namespace) {
        Schema ref = TypesHelper.schema(definition.getTypes(), namespace);
        if (ref != null) return ref;

        SchemaImport imp = SchemaHelper.findImport(originSchema, namespace);
        if (imp != null) return imp.getReferencedSchema();

        if (namespace.equals(originSchema.getElement().getAttribute("targetNamespace")))
            return originSchema;

        return null;
    }

    private boolean isEmpty(String value) {
        return value == null || value.isEmpty();
    }

    // -------------------------------------------------------------------------
    // Qualification helpers
    // -------------------------------------------------------------------------

    private boolean shouldQualify(Schema schema, Node node) {
        boolean qualified = NodeHelper.hasNamedAttribute(schema.getElement(), "elementFormDefault")
                && isQualified(schema.getElement(), "elementFormDefault");

        if (NodeHelper.hasNamedAttribute(node, "form"))
            qualified = isQualified(node, "form");

        return qualified;
    }

    private boolean isQualified(Node node, String attr) {
        return NodeHelper.getNamedAttribute(node, attr).getNodeValue().equals("qualified");
    }

    // -------------------------------------------------------------------------
    // Guard / require helpers
    // -------------------------------------------------------------------------

    private Pair<Definition, Binding> requireBinding(Definition definition, String action) {
        Pair<Definition, Binding> lookup = DefinitionHelper.binding(definition, action);

        if (lookup == null)
            throw new RuntimeException("Could not find SOAP Binding associated with this action");

        return lookup;
    }

    private Input requireInput(PortType portType, String action) {
        Input input = PortTypeHelper.input(portType, action);

        if (input == null)
            throw new RuntimeException("Could not find SOAP Input associated with this action");

        return input;
    }

    private void requireOperation(Binding binding, String action) {
        if (BindingHelper.operation(binding, action) == null)
            throw new RuntimeException("Could not find SOAP Operation associated with this action");
    }

    // -------------------------------------------------------------------------
    // Test support
    // -------------------------------------------------------------------------

    public void setDefinition(Definition definition) {
        this.definition = definition;
    }
}