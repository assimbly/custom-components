package world.dovetail.xmltojson;

import org.apache.camel.*;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.mock.MockEndpoint;

import org.apache.commons.io.IOUtils;
import org.assimbly.util.exception.XmlRootException;
import org.json.JSONException;
import org.apache.camel.test.junit5.CamelTestSupport;
import org.junit.jupiter.api.Test;
import org.xml.sax.SAXException;
import org.xmlunit.builder.DiffBuilder;
import org.xmlunit.builder.Input;
import org.xmlunit.diff.Diff;

import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.*;
import static org.apache.camel.test.junit5.TestSupport.assertIsInstanceOf;

public class JsonToXmlTest extends CamelTestSupport {
    private final ClassLoader classLoader = getClass().getClassLoader();

    @EndpointInject("mock:result")
    protected MockEndpoint resultEndpoint;

    @Produce
    protected ProducerTemplate template;

    @Test
    public void testJsonXml() throws Exception {
        String defaultJson = IOUtils.toString(classLoader.getResourceAsStream("json-to-xml/default-json.json"), StandardCharsets.UTF_8);
        String defaultXml = IOUtils.toString(classLoader.getResourceAsStream("json-to-xml/default-xml.xml"), StandardCharsets.UTF_8);

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
    public void testExchangeHeaders() throws Exception {
        String defaultJson = IOUtils.toString(classLoader.getResourceAsStream("json-to-xml/default-json.json"), StandardCharsets.UTF_8);

        resultEndpoint.expectedMessageCount(1);

        template.sendBody("direct:unmarshal", defaultJson);

        // We only have an IN exchange
        String inContentTypeHeader = getLastExchange(resultEndpoint).getIn().getHeader("Content-Type", String.class);

        assertEquals("application/xml", inContentTypeHeader);

        resultEndpoint.assertIsSatisfied();
    }

    @Test
    public void testJsonXmlWithAddRoot() throws Exception {
        String json = IOUtils.toString(
            classLoader.getResourceAsStream("json-to-xml/root-json.json"),
            StandardCharsets.UTF_8
        );
        String xml = IOUtils.toString(
            classLoader.getResourceAsStream("json-to-xml/root-xml.xml"),
            StandardCharsets.UTF_8
        );

        resultEndpoint.expectedMessageCount(1);

        template.sendBody("direct:unmarshalWithAddRoot", json);

        String exchangeBody = getLastExchange(resultEndpoint)
                                .getIn()
                                .getBody(String.class);

        Diff xmlDiff = DiffBuilder
                .compare(Input.fromString(xml))
                .withTest(Input.fromString(exchangeBody))
                .ignoreWhitespace()
                .build();

        assertFalse(xmlDiff.hasDifferences());

        resultEndpoint.assertIsSatisfied();
    }

    @Test
    public void testJsonXmlWithCheck() throws Exception {
        String json = IOUtils.toString(
            classLoader.getResourceAsStream("json-to-xml/check-json.json"),
            StandardCharsets.UTF_8
        );
        String xml = IOUtils.toString(
            classLoader.getResourceAsStream("json-to-xml/check-xml.xml"),
            StandardCharsets.UTF_8
        );

        resultEndpoint.expectedMessageCount(1);

        template.sendBody("direct:unmarshalWithCheckJsonKeys", json);

        String exchangeBody = getLastExchange(resultEndpoint)
                                .getIn()
                                .getBody(String.class);

        Diff xmlDiff = DiffBuilder
                .compare(Input.fromString(xml))
                .withTest(Input.fromString(exchangeBody))
                .ignoreWhitespace()
                .build();

        assertFalse(xmlDiff.hasDifferences());

        resultEndpoint.assertIsSatisfied();
    }

    @Test
    public void testJsonXmlWithCheckThatThrowsError() throws Exception {
        String json = IOUtils.toString(
            classLoader.getResourceAsStream("json-to-xml/check-json.json"),
            StandardCharsets.UTF_8
        );

        try {
            template.sendBody("direct:unmarshalWithCheckJsonKeysFalse", json);
            fail("The provided JSON should generate an error, because the keys contain invalid XML characters.");
        } catch (CamelExecutionException ex) {
            assertEquals(
                "The content of elements must consist of well-formed character data or markup.",
                ex.getCause().getMessage()
            );

            assertIsInstanceOf(SAXException.class, ex.getCause());
        }
    }

    @Test
    public void testJsonXmlWithJsonArrayAsRootAndDefaultArrayElementNameAndCheckJsonKeys() throws Exception {
        String json = IOUtils.toString(
            classLoader.getResourceAsStream("json-to-xml/array-root-json-default.json"),
            StandardCharsets.UTF_8
        );
        String xml = IOUtils.toString(
            classLoader.getResourceAsStream("json-to-xml/array-root-default-arrays-xml.xml"),
            StandardCharsets.UTF_8
        );

        resultEndpoint.expectedMessageCount(1);

        template.sendBody("direct:unmarshalWithRootArrayAndDefaultArrayElementsAndCheckJsonKeys", json);

        String exchangeBody = getLastExchange(resultEndpoint)
                                .getIn()
                                .getBody(String.class);

        Diff xmlDiff = DiffBuilder
                .compare(Input.fromString(xml))
                .withTest(Input.fromString(exchangeBody))
                .ignoreWhitespace()
                .build();

        assertFalse(xmlDiff.hasDifferences());

        resultEndpoint.assertIsSatisfied();
    }


    @Test
    public void testJsonXmlWithJsonArrayAsRootAndCustomArrayElementNameAndCheckJsonKeys() throws Exception {
        String json = IOUtils.toString(
            classLoader.getResourceAsStream("json-to-xml/array-root-json-custom.json"),
            StandardCharsets.UTF_8
        );
        String xml = IOUtils.toString(
            classLoader.getResourceAsStream("json-to-xml/array-root-custom-arrays-xml.xml"),
            StandardCharsets.UTF_8
        );

        resultEndpoint.expectedMessageCount(1);

        template.sendBody("direct:unmarshalWithRootArrayAndCustomArrayElementsAndCheckJsonKeys", json);

        String exchangeBody = getLastExchange(resultEndpoint)
                                .getIn()
                                .getBody(String.class);

        Diff xmlDiff = DiffBuilder
                .compare(Input.fromString(xml))
                .withTest(Input.fromString(exchangeBody))
                .ignoreWhitespace()
                .build();

        assertFalse(xmlDiff.hasDifferences());

        resultEndpoint.assertIsSatisfied();
    }

    @Test
    public void testJsonXmlWithJsonArrayAsRootAndCustomArrayElementNameAndCheckJsonKeysAdvanced() throws Exception {
        String json = IOUtils.toString(
                classLoader.getResourceAsStream("json-to-xml/advanced-custom-arrays-json.json"),
                StandardCharsets.UTF_8
        );
        String xml = IOUtils.toString(
                classLoader.getResourceAsStream("json-to-xml/advanced-custom-arrays-xml.xml"),
                StandardCharsets.UTF_8
        );

        resultEndpoint.expectedMessageCount(1);

        template.sendBody("direct:unmarshalWithRootArrayAndCustomArrayElementsAndCheckJsonKeysAdvanced", json);

        String exchangeBody = getLastExchange(resultEndpoint)
                .getIn()
                .getBody(String.class);

        Diff xmlDiff = DiffBuilder
                .compare(Input.fromString(xml))
                .withTest(Input.fromString(exchangeBody))
                .ignoreWhitespace()
                .build();

        assertFalse(xmlDiff.hasDifferences());

        resultEndpoint.assertIsSatisfied();
    }

    @Test
    public void testWrongJsonError() throws Exception {
        String json = "test";

        try {
            template.sendBody("direct:unmarshal", json);
            fail("The provided JSON is wrong and should generate an error when parsed.");
        } catch (CamelExecutionException ex) {
            assertEquals(
                "The provided JSON could not be parsed to either a JSON object or a JSON array.",
                ex.getCause().getMessage()
            );

            assertIsInstanceOf(JSONException.class, ex.getCause());
        }
    }

    @Test
    public void testJsonXmlWithAddRootAndSimpleHeaderAsRoot() throws Exception {
        String json = IOUtils.toString(
            classLoader.getResourceAsStream("json-to-xml/root-json.json"),
            StandardCharsets.UTF_8
        );
        String xml = IOUtils.toString(
            classLoader.getResourceAsStream("json-to-xml/root-xml.xml"),
            StandardCharsets.UTF_8
        );

        resultEndpoint.expectedMessageCount(1);

        template.sendBodyAndHeader("direct:unmarshalWithAddRootAndSimpleHeaderAsRoot", json, "dynamicRoot", "myRoot");

        String exchangeBody = getLastExchange(resultEndpoint)
                                .getIn()
                                .getBody(String.class);

        Diff xmlDiff = DiffBuilder
                .compare(Input.fromString(xml))
                .withTest(Input.fromString(exchangeBody))
                .ignoreWhitespace()
                .build();

        assertFalse(xmlDiff.hasDifferences());

        resultEndpoint.assertIsSatisfied();
    }

    @Test
    public void testJsonXmlWithAddRootAndSimpleHeaderAsRootErrors() throws Exception {
        String json = IOUtils.toString(
            classLoader.getResourceAsStream("json-to-xml/root-json.json"),
            StandardCharsets.UTF_8
        );

        try {
            template.sendBodyAndHeader("direct:unmarshalWithAddRootAndSimpleHeaderAsRoot", json, "dynamicRoot", "");
            fail("An empty root tag should not be allowed");
        } catch (CamelExecutionException ex) {
            assertEquals(
                "The header in the root tag has an empty value. A XML root tag can't be empty.",
                ex.getCause().getMessage()
            );

            assertIsInstanceOf(XmlRootException.class, ex.getCause());
        }

        String[] invalidRootTags = new String[]{"1myRoot", "-myRoot", ".myRoot", "xmlmyRoot", "my;root", "my/root", "my<root", "my>root"};

        for (String invalidRootTag : invalidRootTags) {
            try {
                template.sendBodyAndHeader("direct:unmarshalWithAddRootAndSimpleHeaderAsRoot", json, "dynamicRoot", invalidRootTag);
                fail(invalidRootTag + " should be an invalid root tag.");
            } catch (CamelExecutionException ex) {
                assertEquals(
                    "The value of the header in the root tag has invalid XML characters. It can't be used as an XML root tag.",
                    ex.getCause().getMessage()
                );

                assertIsInstanceOf(XmlRootException.class, ex.getCause());
            }
        }
    }

    @Test
    public void testJsonXmlWithCustomArraysAndOtherOptions() throws Exception {
        String json = IOUtils.toString(
            classLoader.getResourceAsStream("json-to-xml/custom-arrays-json.json"),
            StandardCharsets.UTF_8
        );
        String xml = IOUtils.toString(
            classLoader.getResourceAsStream("json-to-xml/custom-arrays-xml.xml"),
            StandardCharsets.UTF_8
        );

        resultEndpoint.expectedMessageCount(1);

        template.sendBodyAndHeader("direct:unmarshalWithCustomArraysAndOtherOptions", json, "myArray", "customElement");

        String exchangeBody = getLastExchange(resultEndpoint)
                                .getIn()
                                .getBody(String.class);

        Diff xmlDiff = DiffBuilder
                .compare(Input.fromString(xml))
                .withTest(Input.fromString(exchangeBody))
                .ignoreWhitespace()
                .build();

        assertFalse(xmlDiff.hasDifferences());

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
