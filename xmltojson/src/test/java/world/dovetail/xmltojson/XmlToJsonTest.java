package world.dovetail.xmltojson;

import org.apache.camel.CamelExecutionException;
import org.apache.camel.EndpointInject;
import org.apache.camel.Exchange;
import org.apache.camel.Produce;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit5.CamelTestSupport;
import org.junit.jupiter.api.Test;
import org.apache.commons.io.IOUtils;
import org.assimbly.util.exception.JsonTypeException;
import org.skyscreamer.jsonassert.JSONAssert;

import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.*;
import static org.apache.camel.test.junit5.TestSupport.assertIsInstanceOf;

public class XmlToJsonTest extends CamelTestSupport {

    private final ClassLoader classLoader = getClass().getClassLoader();

    @EndpointInject(uri = "mock:result")
    protected MockEndpoint resultEndpoint;

    @Produce
    protected ProducerTemplate template;

    @Test
    public void testXmlJson() throws Exception {
        String defaultXml = IOUtils.toString(classLoader.getResourceAsStream("xml-to-json/default-xml.xml"), StandardCharsets.UTF_8);
        String defaultJson = IOUtils.toString(classLoader.getResourceAsStream("xml-to-json/default-json.json"), StandardCharsets.UTF_8);

        resultEndpoint.expectedMessageCount(1);

        template.sendBody("direct:marshal", defaultXml);

        String exchangeBody = getLastExchange(resultEndpoint).getIn().getBody(String.class);
        JSONAssert.assertEquals("Expected the exchange body to equal the given json", defaultJson, exchangeBody, true);

        resultEndpoint.assertIsSatisfied();
    }

    @Test
    public void testExchangeHeaders() throws Exception {
        String defaultXml = IOUtils.toString(classLoader.getResourceAsStream("xml-to-json/default-xml.xml"), StandardCharsets.UTF_8);

        resultEndpoint.expectedMessageCount(1);

        template.sendBody("direct:marshal", defaultXml);

        // We only have an IN exchange
        String inContentTypeHeader = getLastExchange(resultEndpoint).getIn().getHeader("Content-Type", String.class);

        assertEquals("application/json", inContentTypeHeader);

        resultEndpoint.assertIsSatisfied();
    }

    @Test
    public void testTypedXmlToJson() throws Exception {
        String typedXml = IOUtils.toString(classLoader.getResourceAsStream("xml-to-json/typed-xml.xml"), StandardCharsets.UTF_8);
        String typedJson = IOUtils.toString(classLoader.getResourceAsStream("xml-to-json/typed-json.json"), StandardCharsets.UTF_8);

        resultEndpoint.expectedMessageCount(1);

        template.sendBody("direct:marshalWithTypes", typedXml);

        String exchangeBody = getLastExchange(resultEndpoint).getIn().getBody(String.class);
        JSONAssert.assertEquals(typedJson, exchangeBody, true);

        resultEndpoint.assertIsSatisfied();
    }

    @Test
    public void testTypedXmlToJsonWithSimpleXml() throws Exception {
        String xml = IOUtils.toString(classLoader.getResourceAsStream("xml-to-json/typed-xml-simple.xml"), StandardCharsets.UTF_8);
        String json = IOUtils.toString(classLoader.getResourceAsStream("xml-to-json/typed-json-simple.json"), StandardCharsets.UTF_8);

        resultEndpoint.expectedMessageCount(1);

        template.sendBody("direct:marshalWithTypes", xml);

        String exchangeBody = getLastExchange(resultEndpoint).getIn().getBody(String.class);
        JSONAssert.assertEquals(json, exchangeBody, true);

        resultEndpoint.assertIsSatisfied();
    }

    @Test
    public void testTypedXmlToJsonWithTypeArray() throws Exception {
        String xml = IOUtils.toString(classLoader.getResourceAsStream("xml-to-json/typed-xml-arrays.xml"), StandardCharsets.UTF_8);
        String json = IOUtils.toString(classLoader.getResourceAsStream("xml-to-json/typed-json-arrays.json"), StandardCharsets.UTF_8);

        resultEndpoint.expectedMessageCount(1);

        template.sendBody("direct:marshalWithTypeArray", xml);

        String exchangeBody = getLastExchange(resultEndpoint).getIn().getBody(String.class);
        JSONAssert.assertEquals(json, exchangeBody, true);

        resultEndpoint.assertIsSatisfied();
    }

    @Test
    public void testKeepStringsXmlToJson() throws Exception {
        String keepStringsXml = IOUtils.toString(classLoader.getResourceAsStream("xml-to-json/keep-strings-xml.xml"), StandardCharsets.UTF_8);
        String keepStringsJson = IOUtils.toString(classLoader.getResourceAsStream("xml-to-json/keep-strings-json.json"), StandardCharsets.UTF_8);

        resultEndpoint.expectedMessageCount(1);

        template.sendBody("direct:marshalWithKeepStrings", keepStringsXml);

        String exchangeBody = getLastExchange(resultEndpoint).getIn().getBody(String.class);
        JSONAssert.assertEquals(keepStringsJson, exchangeBody, true);

        resultEndpoint.assertIsSatisfied();
    }

    @Test
    public void testTypeValueMismatchOriginal() throws Exception {
        String xml = IOUtils.toString(classLoader.getResourceAsStream("xml-to-json/type-value-mismatch-xml.xml"), StandardCharsets.UTF_8);
        String json = IOUtils.toString(classLoader.getResourceAsStream("xml-to-json/type-value-mismatch-original-json.json"), StandardCharsets.UTF_8);

        resultEndpoint.expectedMessageCount(1);

        template.sendBody("direct:marshalWithTypeValueMismatchOriginal", xml);

        String exchangeBody = getLastExchange(resultEndpoint).getIn().getBody(String.class);
        JSONAssert.assertEquals(json, exchangeBody, true);

        resultEndpoint.assertIsSatisfied();
    }

    @Test
    public void testTypeValueMismatchNull() throws Exception {
        String xml = IOUtils.toString(classLoader.getResourceAsStream("xml-to-json/type-value-mismatch-xml.xml"), StandardCharsets.UTF_8);
        String json = IOUtils.toString(classLoader.getResourceAsStream("xml-to-json/type-value-mismatch-null-json.json"), StandardCharsets.UTF_8);

        resultEndpoint.expectedMessageCount(1);

        template.sendBody("direct:marshalWithTypeValueMismatchNull", xml);

        String exchangeBody = getLastExchange(resultEndpoint).getIn().getBody(String.class);
        JSONAssert.assertEquals(json, exchangeBody, true);

        resultEndpoint.assertIsSatisfied();
    }

    @Test
    public void testTypeValueMismatchError() throws Exception {
        String xml = IOUtils.toString(classLoader.getResourceAsStream("xml-to-json/type-value-mismatch-xml.xml"), StandardCharsets.UTF_8);

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
    public void testRemoveNamespaces() throws Exception {
        String xml = IOUtils.toString(classLoader.getResourceAsStream("xml-to-json/namespace-xml.xml"), StandardCharsets.UTF_8);
        String json = IOUtils.toString(classLoader.getResourceAsStream("xml-to-json/namespace-json.json"), StandardCharsets.UTF_8);

        resultEndpoint.expectedMessageCount(1);

        template.sendBody("direct:marshalWithRemoveNamespaces", xml);

        String exchangeBody = getLastExchange(resultEndpoint).getIn().getBody(String.class);
        JSONAssert.assertEquals(json, exchangeBody, true);

        resultEndpoint.assertIsSatisfied();
    }

    @Test
    public void testRemoveRoot() throws Exception {
        String xml = IOUtils.toString(classLoader.getResourceAsStream("xml-to-json/remove-root-xml.xml"), StandardCharsets.UTF_8);
        String json = IOUtils.toString(classLoader.getResourceAsStream("xml-to-json/remove-root-json.json"), StandardCharsets.UTF_8);

        resultEndpoint.expectedMessageCount(1);

        template.sendBody("direct:marshalWithRemoveRoot", xml);

        String exchangeBody = getLastExchange(resultEndpoint).getIn().getBody(String.class);
        JSONAssert.assertEquals(json, exchangeBody, true);

        resultEndpoint.assertIsSatisfied();
    }

    private Exchange getLastExchange(MockEndpoint endpoint) {
        int size = endpoint.getReceivedExchanges().size();
        return endpoint.getReceivedExchanges().get(size -1);
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
