package org.assimbly.xmltojson;

import org.apache.camel.*;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.mock.MockEndpoint;

import org.assimbly.xmltojson.exception.XmlRootException;
import org.json.JSONException;
import org.apache.camel.test.junit5.CamelTestSupport;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.xml.sax.SAXException;
import org.xmlunit.builder.DiffBuilder;
import org.xmlunit.builder.Input;
import org.xmlunit.diff.Diff;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;
import static org.apache.camel.test.junit5.TestSupport.assertIsInstanceOf;

class JsonToXmlTest extends CamelTestSupport {

    @EndpointInject("mock:result")
    protected MockEndpoint resultEndpoint;

    @Produce
    protected ProducerTemplate template;

    @Test
    void testJsonXml() throws Exception {
        String defaultJson = readResource("json-to-xml/default-json.json");
        String defaultXml = readResource("json-to-xml/default-xml.xml");

        resultEndpoint.expectedMessageCount(1);

        template.sendBody("direct:unmarshal", defaultJson);

        String exchangeBody = getLastExchange(resultEndpoint).getIn().getBody(String.class);

        Diff xmlDiff = DiffBuilder
                .compare(Input.fromString(defaultXml))
                .withTest(Input.fromString(exchangeBody))
                .ignoreWhitespace()
                .build();

        assertFalse(xmlDiff.hasDifferences());

        resultEndpoint.assertIsSatisfied();
    }

    @Test
    void testExchangeHeaders() throws Exception {
        String defaultJson = readResource("json-to-xml/default-json.json");

        resultEndpoint.expectedMessageCount(1);

        template.sendBody("direct:unmarshal", defaultJson);

        // We only have an IN exchange
        String inContentTypeHeader = getLastExchange(resultEndpoint).getIn().getHeader("Content-Type", String.class);

        assertEquals("application/xml", inContentTypeHeader);

        resultEndpoint.assertIsSatisfied();
    }

    @ParameterizedTest(name = "{2}")
    @CsvSource({
            "json-to-xml/root-json.json, json-to-xml/root-xml.xml, direct:unmarshalWithAddRoot",
            "json-to-xml/array-root-json-default.json, json-to-xml/array-root-default-arrays-xml.xml, direct:unmarshalWithRootArrayAndDefaultArrayElementsAndCheckJsonKeys",
            "json-to-xml/array-root-json-custom.json, json-to-xml/array-root-custom-arrays-xml.xml, direct:unmarshalWithRootArrayAndCustomArrayElementsAndCheckJsonKeys",
            "json-to-xml/advanced-custom-arrays-json.json, json-to-xml/advanced-custom-arrays-xml.xml, direct:unmarshalWithRootArrayAndCustomArrayElementsAndCheckJsonKeysAdvanced"
    })
    void testJsonXmlWithRootOptions(String jsonPath, String xmlPath, String route) throws Exception {
        String json = readResource(jsonPath);
        String xml = readResource(xmlPath);

        resultEndpoint.expectedMessageCount(1);

        template.sendBody(route, json);

        String exchangeBody = getLastExchange(resultEndpoint).getIn().getBody(String.class);

        Diff xmlDiff = DiffBuilder
                .compare(Input.fromString(xml))
                .withTest(Input.fromString(exchangeBody))
                .ignoreWhitespace()
                .build();

        assertFalse(xmlDiff.hasDifferences());

        resultEndpoint.assertIsSatisfied();
    }

    @Test
    void testJsonXmlWithCheck() throws Exception {
        String input = readResource("json-to-xml/check-json.json");
        String expected = readResource("json-to-xml/check-xml.xml");

        resultEndpoint.expectedMessageCount(1);

        template.sendBody("direct:unmarshalWithCheckJsonKeys", input);

        String actual = getLastExchange(resultEndpoint).getIn().getBody(String.class);

        Diff xmlDiff = DiffBuilder
                .compare(Input.fromString(expected))
                .withTest(Input.fromString(actual))
                .ignoreWhitespace()
                .build();

        assertFalse(xmlDiff.hasDifferences());

        resultEndpoint.assertIsSatisfied();
    }

    @Test
    void testJsonXmlWithCheckThatThrowsError() throws Exception {
        String json = readResource("json-to-xml/check-json.json");

        CamelExecutionException ex = assertThrows(
                CamelExecutionException.class,
                () -> template.sendBody("direct:unmarshalWithCheckJsonKeysFalse", json),
                "The provided JSON should generate an error, because the keys contain invalid XML characters."
        );

        assertEquals(
                "The content of elements must consist of well-formed character data or markup.",
                ex.getCause().getMessage()
        );
        assertIsInstanceOf(SAXException.class, ex.getCause());
    }

    @Test
    void testWrongJsonError() {
        String json = "test";

        CamelExecutionException ex = assertThrows(
                CamelExecutionException.class,
                () -> template.sendBody("direct:unmarshal", json),
                "The provided JSON is wrong and should generate an error when parsed."
        );

        assertEquals(
                "The provided JSON could not be parsed to either a JSON object or a JSON array.",
                ex.getCause().getMessage()
        );
        assertIsInstanceOf(JSONException.class, ex.getCause());
    }

    @Test
    void testJsonXmlWithAddRootAndSimpleHeaderAsRoot() throws Exception {
        String json = readResource("json-to-xml/root-json.json");
        String xml = readResource("json-to-xml/root-xml.xml");

        resultEndpoint.expectedMessageCount(1);

        template.sendBodyAndHeader("direct:unmarshalWithAddRootAndSimpleHeaderAsRoot", json, "dynamicRoot", "myRoot");

        String exchangeBody = getLastExchange(resultEndpoint).getIn().getBody(String.class);

        Diff xmlDiff = DiffBuilder
                .compare(Input.fromString(xml))
                .withTest(Input.fromString(exchangeBody))
                .ignoreWhitespace()
                .build();

        assertFalse(xmlDiff.hasDifferences());

        resultEndpoint.assertIsSatisfied();
    }

    @Test
    void testJsonXmlWithAddRootAndSimpleHeaderAsRootErrors() throws Exception {
        String json = readResource("json-to-xml/root-json.json");

        CamelExecutionException emptyRootException = assertThrows(
                CamelExecutionException.class,
                () -> template.sendBodyAndHeader("direct:unmarshalWithAddRootAndSimpleHeaderAsRoot", json, "dynamicRoot", ""),
                "An empty root tag should not be allowed"
        );

        assertEquals(
                "The header in the root tag has an empty value. A XML root tag can't be empty.",
                emptyRootException.getCause().getMessage()
        );
        assertIsInstanceOf(XmlRootException.class, emptyRootException.getCause());

        String[] invalidRootTags = {"1myRoot", "-myRoot", ".myRoot", "xmlmyRoot", "my;root", "my/root", "my<root", "my>root"};

        for (String invalidRootTag : invalidRootTags) {
            CamelExecutionException ex = assertThrows(
                    CamelExecutionException.class,
                    () -> template.sendBodyAndHeader("direct:unmarshalWithAddRootAndSimpleHeaderAsRoot", json, "dynamicRoot", invalidRootTag),
                    invalidRootTag + " should be an invalid root tag."
            );

            assertEquals(
                    "The value of the header in the root tag has invalid XML characters. It can't be used as an XML root tag.",
                    ex.getCause().getMessage()
            );
            assertIsInstanceOf(XmlRootException.class, ex.getCause());
        }
    }

    @Test
    void testJsonXmlWithCustomArraysAndOtherOptions() throws Exception {
        String json = readResource("json-to-xml/custom-arrays-json.json");
        String xml = readResource("json-to-xml/custom-arrays-xml.xml");

        resultEndpoint.expectedMessageCount(1);

        template.sendBodyAndHeader("direct:unmarshalWithCustomArraysAndOtherOptions", json, "myArray", "customElement");

        String exchangeBody = getLastExchange(resultEndpoint).getIn().getBody(String.class);

        Diff xmlDiff = DiffBuilder
                .compare(Input.fromString(xml))
                .withTest(Input.fromString(exchangeBody))
                .ignoreWhitespace()
                .build();

        assertFalse(xmlDiff.hasDifferences());

        resultEndpoint.assertIsSatisfied();
    }

    // -- Helpers --

    private String readResource(String resourcePath) throws IOException, URISyntaxException {
        URL url = Objects.requireNonNull(
                getClass().getClassLoader().getResource(resourcePath),
                "Test resource not found: " + resourcePath
        );
        return Files.readString(Paths.get(url.toURI()), StandardCharsets.UTF_8);
    }

    private Exchange getLastExchange(MockEndpoint endpoint) {
        int size = endpoint.getReceivedExchanges().size();
        return endpoint.getReceivedExchanges().get(size - 1);
    }

    @Override
    protected RouteBuilder[] createRouteBuilders() {
        return new RouteBuilder[] {
                new RouteBuilder() {
                    public void configure() {
                        from("direct:unmarshal")
                                .to("dataformat:custom-xmljson:unmarshal")
                                .to("mock:result");
                    }
                },
                new RouteBuilder() {
                    public void configure() {
                        from("direct:unmarshalWithAddRoot")
                                .to("dataformat:custom-xmljson:unmarshal?addRoot=true&rootTag=RAW(myRoot)")
                                .to("mock:result");
                    }
                },
                new RouteBuilder() {
                    public void configure() {
                        from("direct:unmarshalWithCheckJsonKeys")
                                .to("dataformat:custom-xmljson:unmarshal?checkJsonKeys=true")
                                .to("mock:result");
                    }
                },
                new RouteBuilder() {
                    public void configure() {
                        from("direct:unmarshalWithCheckJsonKeysFalse")
                                .to("dataformat:custom-xmljson:unmarshal?checkJsonKeys=false")
                                .to("mock:result");
                    }
                },
                new RouteBuilder() {
                    public void configure() {
                        from("direct:unmarshalWithRootArrayAndDefaultArrayElementsAndCheckJsonKeys")
                                .to("dataformat:custom-xmljson:unmarshal?addRoot=true&rootTag=RAW(root)&checkJsonKeys=true")
                                .to("mock:result");
                    }
                },
                new RouteBuilder() {
                    public void configure() {
                        from("direct:unmarshalWithRootArrayAndCustomArrayElementsAndCheckJsonKeys")
                                .to("dataformat:custom-xmljson:unmarshal?addRoot=true&rootTag=RAW(root)&changeArrayElements=true&arrayElementName=RAW(customElement)&checkJsonKeys=true")
                                .to("mock:result");
                    }
                },
                new RouteBuilder() {
                    public void configure() {
                        from("direct:unmarshalWithRootArrayAndCustomArrayElementsAndCheckJsonKeysAdvanced")
                                .to("dataformat:custom-xmljson:unmarshal?addRoot=true&rootTag=RAW(root)&changeArrayElements=true&arrayElementName=RAW(customElement)&checkJsonKeys=true")
                                .to("mock:result");
                    }
                },
                new RouteBuilder() {
                    public void configure() {
                        from("direct:unmarshalWithAddRootAndSimpleHeaderAsRoot")
                                .to("dataformat:custom-xmljson:unmarshal?addRoot=true&rootTag=RAW(${header.dynamicRoot})")
                                .to("mock:result");
                    }
                },
                new RouteBuilder() {
                    public void configure() {
                        from("direct:unmarshalWithCustomArraysAndOtherOptions")
                                .to("dataformat:custom-xmljson:unmarshal?addRoot=true&rootTag=RAW(root)&checkJsonKeys=true&changeArrayElements=true&arrayElementName=RAW(${header.myArray})")
                                .to("mock:result");
                    }
                }
        };
    }
}