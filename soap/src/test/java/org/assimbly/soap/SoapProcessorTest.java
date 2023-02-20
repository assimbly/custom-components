package org.assimbly.soap;

import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.camel.support.DefaultExchange;
import org.assimbly.util.helper.XmlHelper;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.w3c.dom.Document;
import org.assimbly.soap.domain.SoapAttribute;
import org.assimbly.soap.domain.SoapHeader;

import javax.wsdl.Definition;
import javax.wsdl.WSDLException;
import javax.wsdl.factory.WSDLFactory;
import javax.wsdl.xml.WSDLReader;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.soap.*;

import static org.junit.jupiter.api.Assertions.*;

public class SoapProcessorTest {

    private static SoapProcessor processor;
    private static Definition definition;

    private final ClassLoader classLoader = getClass().getClassLoader();
    private SOAPEnvelope envelope;
    private DocumentBuilder builder;

    @BeforeEach
    public void setup() throws WSDLException, ParserConfigurationException, SOAPException {
        WSDLFactory wsdlFactory = WSDLFactory.newInstance();
        WSDLReader reader = wsdlFactory.newWSDLReader();

        MessageFactory messageFactory = MessageFactory.newInstance();
        SOAPMessage soapMessage = messageFactory.createMessage();
        SOAPPart soapPart = soapMessage.getSOAPPart();
        envelope = soapPart.getEnvelope();

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        builder = factory.newDocumentBuilder();

        processor = new SoapProcessor(
                new SoapEndpoint(null,null, new SoapConfiguration())
        );

        definition = reader.readWSDL(classLoader.getResource("mock.wsdl").getFile());
        processor.setDefinition(definition);
    }

    @AfterEach
    public void reset() {
        processor = new SoapProcessor(
                new SoapEndpoint(null,null, new SoapConfiguration())
        );
    }

    @Test
    public void testOverrideHeader() throws Exception {
        CamelContext context = new DefaultCamelContext();
        Exchange exchange = new DefaultExchange(context);

        exchange.getIn().setHeader("AssimblySoapWsdl", "https://org.assimbly?wsdl&param=x");

        SoapConfiguration configuration = new SoapConfiguration();
        configuration.setWsdl("https://wsdl.com");
        configuration.setParams("wsdl");

        processor.applyOverrideHeaders(exchange.getContext(), exchange.getIn().getHeaders(), configuration);

        assertEquals("https://org.assimbly", configuration.getWsdl());
        assertEquals("wsdl&param=x", configuration.getParameters());
    }

    @Test
    public void testTransformPartStandardType() throws Exception {
        Document input = builder.parse(classLoader.getResourceAsStream("input-mocks/input-from-part-with-standard-type.xml"));

        Document actual = processor.transform(definition, "OperationWithStandardType", envelope, input);
        Document expected = builder.parse(classLoader.getResourceAsStream("output-mocks/output-from-part-with-standard-type.xml"));

        assertEquals(XmlHelper.prettyPrint(expected), XmlHelper.prettyPrint(actual));
    }

    @Test
    public void testTransformPartType() throws Exception {
        Document input = builder.parse(classLoader.getResourceAsStream("input-mocks/input-from-part-with-type.xml"));

        Document actual = processor.transform(definition, "OperationWithTypePart", envelope, input);
        Document expected = builder.parse(classLoader.getResourceAsStream("output-mocks/output-from-part-with-type.xml"));

        assertEquals(XmlHelper.prettyPrint(expected), XmlHelper.prettyPrint(actual));
    }

    @Test
    public void testTransformReferenceNode() throws Exception {
        Document input = builder.parse(classLoader.getResourceAsStream("input-mocks/input-with-reference.xml"));

        Document actual = processor.transform(definition, "OperationWithReference", envelope, input);
        Document expected = builder.parse(classLoader.getResourceAsStream("output-mocks/output-with-reference.xml"));

        assertEquals(XmlHelper.prettyPrint(expected), XmlHelper.prettyPrint(actual));
    }

    @Test
    public void testTransformTypeNode() throws Exception {
        Document input = builder.parse(classLoader.getResourceAsStream("input-mocks/input-with-type.xml"));

        Document actual = processor.transform(definition, "OperationWithType", envelope, input);
        Document expected = builder.parse(classLoader.getResourceAsStream("output-mocks/output-with-type.xml"));

        assertEquals(XmlHelper.prettyPrint(expected), XmlHelper.prettyPrint(actual));
    }

    @Test
    public void testTransformLocalTypeNode() throws Exception {
        Document input = builder.parse(classLoader.getResourceAsStream("input-mocks/input-with-local-type.xml"));

        Document actual = processor.transform(definition, "OperationWithLocalType", envelope, input);
        Document expected = builder.parse(classLoader.getResourceAsStream("output-mocks/output-with-local-type.xml"));

        assertEquals(XmlHelper.prettyPrint(expected), XmlHelper.prettyPrint(actual));
    }

    @Test
    public void testTransformExtensionNode() throws Exception {
        Document input = builder.parse(classLoader.getResourceAsStream("input-mocks/input-with-extension.xml"));

        Document actual = processor.transform(definition, "OperationWithExtension", envelope, input);
        Document expected = builder.parse(classLoader.getResourceAsStream("output-mocks/output-with-extension.xml"));

        assertEquals(XmlHelper.prettyPrint(expected), XmlHelper.prettyPrint(actual));
    }

    @Test
    public void testTransformSequenceNode() throws Exception {
        Document input = builder.parse(classLoader.getResourceAsStream("input-mocks/input-with-sequence.xml"));

        Document actual = processor.transform(definition, "OperationWithSequence", envelope, input);
        Document expected = builder.parse(classLoader.getResourceAsStream("output-mocks/output-with-sequence.xml"));

        assertEquals(XmlHelper.prettyPrint(expected), XmlHelper.prettyPrint(actual));
    }

    @Test
    public void testTransformFromExternalWsdlNode() throws Exception {
        Document input = builder.parse(classLoader.getResourceAsStream("input-mocks/input-from-external-wsdl.xml"));

        Document actual = processor.transform(definition, "OperationFromExternalWsdl", envelope, input);
        Document expected = builder.parse(classLoader.getResourceAsStream("output-mocks/output-from-external-wsdl.xml"));

        assertEquals(XmlHelper.prettyPrint(expected), XmlHelper.prettyPrint(actual));
    }

    @Test
    public void testTransformFromExternalBindingNode() throws Exception {
        Document input = builder.parse(classLoader.getResourceAsStream("input-mocks/input-from-external-binding.xml"));

        Document actual = processor.transform(definition, "OperationFromExternalBinding", envelope, input);
        Document expected = builder.parse(classLoader.getResourceAsStream("output-mocks/output-from-external-binding.xml"));

        assertEquals(XmlHelper.prettyPrint(expected), XmlHelper.prettyPrint(actual));
    }

    @Test
    public void testTransformWithUnqualifiedNode() throws Exception {
        Document input = builder.parse(classLoader.getResourceAsStream("input-mocks/input-with-unqualified.xml"));

        Document actual = processor.transform(definition, "OperationWithUnqualified", envelope, input);
        Document expected = builder.parse(classLoader.getResourceAsStream("output-mocks/output-with-unqualified.xml"));

        assertEquals(XmlHelper.prettyPrint(expected), XmlHelper.prettyPrint(actual));
    }

    @Test
    public void testTransformWithSchemaReferenceNode() throws Exception {
        Document input = builder.parse(classLoader.getResourceAsStream("input-mocks/input-with-schema-reference.xml"));

        Document actual = processor.transform(definition, "OperationWithSchemaReference", envelope, input);
        Document expected = builder.parse(classLoader.getResourceAsStream("output-mocks/output-with-schema-reference.xml"));

        assertEquals(XmlHelper.prettyPrint(expected), XmlHelper.prettyPrint(actual));
    }

    @Test
    public void testTransformWithImportNode() throws Exception {
        Document input = builder.parse(classLoader.getResourceAsStream("input-mocks/input-with-import.xml"));

        Document actual = processor.transform(definition, "OperationWithImport", envelope, input);
        Document expected = builder.parse(classLoader.getResourceAsStream("output-mocks/output-with-import.xml"));

        assertEquals(XmlHelper.prettyPrint(expected), XmlHelper.prettyPrint(actual));
    }

    @Test
    public void testAddSoapHeaderWithPartName() throws Exception {
        SoapHeader header = new SoapHeader("authHeader");
        header.getAttrs().add(new SoapAttribute("username", "admin"));
        header.getAttrs().add(new SoapAttribute("password", "admin"));

        processor.addSOAPHeaders(definition, envelope, null, header, "OperationWithHeader");

        Document expected = builder.parse(classLoader.getResourceAsStream("output-mocks/output-header-with-part-name.xml"));

        assertEquals(XmlHelper.prettyPrint(expected), XmlHelper.prettyPrint(envelope.getHeader().getOwnerDocument()));
    }

    @Test
    public void testAddMultipleSoapHeadersWithPartName() throws Exception {
        SoapHeader authHeader = new SoapHeader("authHeader");
        authHeader.getAttrs().add(new SoapAttribute("username", "admin"));
        authHeader.getAttrs().add(new SoapAttribute("password", "admin"));

        SoapHeader databaseHeader = new SoapHeader("databaseHeader");
        databaseHeader.getAttrs().add(new SoapAttribute("database", "users"));

        processor.addSOAPHeaders(definition, envelope, null, authHeader, "OperationWithHeaders");
        processor.addSOAPHeaders(definition, envelope, null, databaseHeader, "OperationWithHeaders");

        Document expected = builder.parse(classLoader.getResourceAsStream("output-mocks/output-headers-with-part-name.xml"));

        assertEquals(XmlHelper.prettyPrint(expected), XmlHelper.prettyPrint(envelope.getHeader().getOwnerDocument()));
    }

    @Test
    public void testNoDefaultElementFormDefinitionWithQualifiedElementOverride() throws Exception {
        WSDLFactory wsdlFactory = WSDLFactory.newInstance();
        WSDLReader reader = wsdlFactory.newWSDLReader();
        definition = reader.readWSDL(classLoader.getResource("mock-2.wsdl").getFile());
        processor.setDefinition(definition);

        Document input = builder.parse(classLoader.getResourceAsStream("input-mocks/input-with-qualified.xml"));

        Document actual = processor.transform(definition, "OperationWithQualified", envelope, input);
        Document expected = builder.parse(classLoader.getResourceAsStream("output-mocks/output-with-qualified.xml"));

        assertEquals(XmlHelper.prettyPrint(expected), XmlHelper.prettyPrint(actual));

    }
}
