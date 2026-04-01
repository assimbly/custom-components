package org.assimbly.xmltojson;

import org.apache.camel.CamelExecutionException;
import org.apache.camel.EndpointInject;
import org.apache.camel.Exchange;
import org.apache.camel.Produce;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit5.CamelTestSupport;
import org.junit.jupiter.api.Test;
import org.assimbly.util.exception.JsonTypeException;
import org.skyscreamer.jsonassert.JSONAssert;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;
import static org.apache.camel.test.junit5.TestSupport.assertIsInstanceOf;

class XmlToJsonTest extends CamelTestSupport {

    @EndpointInject("mock:result")
    protected MockEndpoint resultEndpoint;

    @Produce
    protected ProducerTemplate template;

    @Test
    void testXmlJson() throws Exception {
        String defaultXml = readResource("xml-to-json/default-xml.xml");
        String defaultJson = readResource("xml-to-json/default-json.json");

        resultEndpoint.expectedMessageCount(1);

        template.sendBody("direct:marshal", defaultXml);

        String exchangeBody = getLastExchange(resultEndpoint).getIn().getBody(String.class);
        JSONAssert.assertEquals("Expected the exchange body to equal the given json", defaultJson, exchangeBody, true);

        resultEndpoint.assertIsSatisfied();
    }

    @Test
    void testExchangeHeaders() throws Exception {
        String defaultXml = readResource("xml-to-json/default-xml.xml");

        resultEndpoint.expectedMessageCount(1);

        template.sendBody("direct:marshal", defaultXml);

        // We only have an IN exchange
        String inContentTypeHeader = getLastExchange(resultEndpoint).getIn().getHeader("Content-Type", String.class);

        assertEquals("application/json", inContentTypeHeader);

        resultEndpoint.assertIsSatisfied();
    }

    @Test
    void testTypedXmlToJson() throws Exception {
        String typedXml = readResource("xml-to-json/typed-xml.xml");
        String typedJson = readResource("xml-to-json/typed-json.json");

        resultEndpoint.expectedMessageCount(1);

        template.sendBody("direct:marshalWithTypes", typedXml);

        String exchangeBody = getLastExchange(resultEndpoint).getIn().getBody(String.class);
        JSONAssert.assertEquals(typedJson, exchangeBody, true);

        resultEndpoint.assertIsSatisfied();
    }

    @Test
    void testTypedXmlToJsonWithSimpleXml() throws Exception {
        String xml = readResource("xml-to-json/typed-xml-simple.xml");
        String json = readResource("xml-to-json/typed-json-simple.json");

        resultEndpoint.expectedMessageCount(1);

        template.sendBody("direct:marshalWithTypes", xml);

        String exchangeBody = getLastExchange(resultEndpoint).getIn().getBody(String.class);
        JSONAssert.assertEquals(json, exchangeBody, true);

        resultEndpoint.assertIsSatisfied();
    }

    @Test
    void testTypedXmlToJsonWithTypeArray() throws Exception {
        String xml = readResource("xml-to-json/typed-xml-arrays.xml");
        String expected = readResource("xml-to-json/typed-json-arrays.json");

        resultEndpoint.expectedMessageCount(1);

        template.sendBody("direct:marshalWithTypeArray", xml);

        String actual = getLastExchange(resultEndpoint).getIn().getBody(String.class);

        JSONAssert.assertEquals(expected, actual, true);

        resultEndpoint.assertIsSatisfied();
    }

    @Test
    void testKeepStringsXmlToJson() throws Exception {
        String keepStringsXml = readResource("xml-to-json/keep-strings-xml.xml");
        String keepStringsJson = readResource("xml-to-json/keep-strings-json.json");

        resultEndpoint.expectedMessageCount(1);

        template.sendBody("direct:marshalWithKeepStrings", keepStringsXml);

        String exchangeBody = getLastExchange(resultEndpoint).getIn().getBody(String.class);
        JSONAssert.assertEquals(keepStringsJson, exchangeBody, true);

        resultEndpoint.assertIsSatisfied();
    }

    @Test
    void testTypeValueMismatchOriginal() throws Exception {
        String xml = readResource("xml-to-json/type-value-mismatch-xml.xml");
        String json = readResource("xml-to-json/type-value-mismatch-original-json.json");

        resultEndpoint.expectedMessageCount(1);

        template.sendBody("direct:marshalWithTypeValueMismatchOriginal", xml);

        String exchangeBody = getLastExchange(resultEndpoint).getIn().getBody(String.class);
        JSONAssert.assertEquals(json, exchangeBody, true);

        resultEndpoint.assertIsSatisfied();
    }

    @Test
    void testTypeValueMismatchNull() throws Exception {
        String xml = readResource("xml-to-json/type-value-mismatch-xml.xml");
        String json = readResource("xml-to-json/type-value-mismatch-null-json.json");

        resultEndpoint.expectedMessageCount(1);

        template.sendBody("direct:marshalWithTypeValueMismatchNull", xml);

        String exchangeBody = getLastExchange(resultEndpoint).getIn().getBody(String.class);
        JSONAssert.assertEquals(json, exchangeBody, true);

        resultEndpoint.assertIsSatisfied();
    }

    @Test
    void testTypeValueMismatchError() throws Exception {
        String xml = readResource("xml-to-json/type-value-mismatch-xml.xml");

        try {
            template.sendBody("direct:marshalWithTypeValueMismatchError", xml);
        } catch (CamelExecutionException ex) {
            assertEquals(
                    "There was a mismatch between a specified type and the value. Type is 'number' and the value is 'test'.",
                    ex.getCause().getMessage()
            );

            assertIsInstanceOf(JsonTypeException.class, ex.getCause());
        }
    }

    @Test
    void testRemoveNamespaces() throws Exception {
        String xml = readResource("xml-to-json/namespace-xml.xml");
        String json = readResource("xml-to-json/namespace-json.json");

        resultEndpoint.expectedMessageCount(1);

        template.sendBody("direct:marshalWithRemoveNamespaces", xml);

        String exchangeBody = getLastExchange(resultEndpoint).getIn().getBody(String.class);
        JSONAssert.assertEquals(json, exchangeBody, true);

        resultEndpoint.assertIsSatisfied();
    }

    @Test
    void testRemoveRoot() throws Exception {
        String xml = readResource("xml-to-json/remove-root-xml.xml");
        String json = readResource("xml-to-json/remove-root-json.json");

        resultEndpoint.expectedMessageCount(1);

        template.sendBody("direct:marshalWithRemoveRoot", xml);

        String exchangeBody = getLastExchange(resultEndpoint).getIn().getBody(String.class);
        JSONAssert.assertEquals(json, exchangeBody, true);

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
                        from("direct:marshal")
                                .to("dataformat:custom-xmljson:marshal")
                                .to("mock:result");
                    }
                },
                new RouteBuilder() {
                    public void configure() {
                        from("direct:marshalWithTypes")
                                .to("dataformat:custom-xmljson:marshal?hasTypes=true")
                                .to("mock:result");
                    }
                },
                new RouteBuilder() {
                    public void configure() {
                        from("direct:marshalWithTypeArray")
                                .to("dataformat:custom-xmljson:marshal?hasTypes=true")
                                .to("mock:result");
                    }
                },
                new RouteBuilder() {
                    public void configure() {
                        from("direct:marshalWithKeepStrings")
                                .to("dataformat:custom-xmljson:marshal?hasTypes=false&keepStrings=true")
                                .to("mock:result");
                    }
                },
                new RouteBuilder() {
                    public void configure() {
                        from("direct:marshalWithTypeValueMismatchOriginal")
                                .to("dataformat:custom-xmljson:marshal?hasTypes=true&typeValueMismatch=ORIGINAL")
                                .to("mock:result");
                    }
                },
                new RouteBuilder() {
                    public void configure() {
                        from("direct:marshalWithTypeValueMismatchNull")
                                .to("dataformat:custom-xmljson:marshal?hasTypes=true&typeValueMismatch=NULL")
                                .to("mock:result");
                    }
                },
                new RouteBuilder() {
                    public void configure() {
                        from("direct:marshalWithTypeValueMismatchError")
                                .to("dataformat:custom-xmljson:marshal?hasTypes=true&typeValueMismatch=ERROR")
                                .to("mock:result");
                    }
                },
                new RouteBuilder() {
                    public void configure() {
                        from("direct:marshalWithRemoveNamespaces")
                                .to("dataformat:custom-xmljson:marshal?removeNamespaces=true")
                                .to("mock:result");
                    }
                },
                new RouteBuilder() {
                    public void configure() {
                        from("direct:marshalWithRemoveRoot")
                                .to("dataformat:custom-xmljson:marshal?hasTypes=true&typeValueMismatch=ORIGINAL&removeRoot=true")
                                .to("mock:result");
                    }
                },
        };
    }

}