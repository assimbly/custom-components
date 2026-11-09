package org.assimbly.soap;

import jakarta.xml.soap.*;

import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.camel.support.DefaultExchange;

import org.assimbly.soap.util.helpers.XmlHelper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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

import static org.junit.jupiter.api.Assertions.*;

class SoapProcessorTest {

    private static SoapProcessor processor;
    private static Definition definition;

    private final ClassLoader classLoader = getClass().getClassLoader();
    private SOAPEnvelope envelope;
    private DocumentBuilder builder;

    @BeforeEach
    void setup() throws WSDLException, ParserConfigurationException, SOAPException {
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
    void reset() {
        processor = new SoapProcessor(
                new SoapEndpoint(null,null, new SoapConfiguration())
        );
    }

    @Test
    void testOverrideHeader() {
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

    @ParameterizedTest(name = "{0}")
    @CsvSource({
            "OperationWithStandardType,input-from-part-with-standard-type.xml,output-from-part-with-standard-type.xml",
            "OperationWithTypePart,input-from-part-with-type.xml,output-from-part-with-type.xml",
            "OperationWithReference,input-with-reference.xml,output-with-reference.xml",
            "OperationWithType,input-with-type.xml,output-with-type.xml",
            "OperationWithLocalType,input-with-local-type.xml,output-with-local-type.xml",
            "OperationWithExtension,input-with-extension.xml,output-with-extension.xml",
            "OperationWithSequence,input-with-sequence.xml,output-with-sequence.xml",
            "OperationFromExternalWsdl,input-from-external-wsdl.xml,output-from-external-wsdl.xml",
            "OperationFromExternalBinding,input-from-external-binding.xml,output-from-external-binding.xml",
            "OperationWithUnqualified,input-with-unqualified.xml,output-with-unqualified.xml",
            "OperationWithSchemaReference,input-with-schema-reference.xml,output-with-schema-reference.xml",
            "OperationWithImport,input-with-import.xml,output-with-import.xml"
    })
    void testTransform(String operation, String inputFile, String outputFile) throws Exception {
        Document input = builder.parse(classLoader.getResourceAsStream("input-mocks/" + inputFile));

        Document actual = processor.transform(definition, operation, envelope, input);
        Document expected = builder.parse(classLoader.getResourceAsStream("output-mocks/" + outputFile));

        assertEquals(XmlHelper.prettyPrint(expected), XmlHelper.prettyPrint(actual));
    }

    @Test
    void testAddSoapHeaderWithPartName() throws Exception {
        SoapHeader header = new SoapHeader("authHeader");
        header.getAttrs().add(new SoapAttribute("username", "admin"));
        header.getAttrs().add(new SoapAttribute("password", "admin"));

        processor.addSOAPHeaders(definition, envelope, null, header, "OperationWithHeader");

        Document expected = builder.parse(classLoader.getResourceAsStream("output-mocks/output-header-with-part-name.xml"));

        assertEquals(XmlHelper.prettyPrint(expected), XmlHelper.prettyPrint(envelope.getHeader().getOwnerDocument()));

    }

    @Test
    void testAddMultipleSoapHeadersWithPartName() throws Exception {
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
    void testNoDefaultElementFormDefinitionWithQualifiedElementOverride() throws Exception {
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
