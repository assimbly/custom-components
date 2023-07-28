package org.assimbly.xmltojsonlegacy;

import org.apache.camel.*;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit5.CamelTestSupport;
import org.apache.commons.io.IOUtils;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class XmlToJsonTest extends CamelTestSupport {

    private final ClassLoader classLoader = getClass().getClassLoader();

    @EndpointInject(uri = "mock:result")
    protected MockEndpoint resultEndpoint;

    @Produce
    protected ProducerTemplate template;

    /*****************************************
    ** Example 1
    *****************************************/

    @Test
    public void testXmlJson_1_FFFFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "marshalNone",
                "xml-to-json/example_1.xml",
                "xml-to-json/example_1_FFFFFF.json"
        );
    }

    @Test
    public void testXmlJson_1_FFFFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "marshalTypeHints",
                "xml-to-json/example_1.xml",
                "xml-to-json/example_1_FFFFFT.json"
        );
    }

    @Test
    public void testXmlJson_1_TFFFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "marshalForceTop",
                "xml-to-json/example_1.xml",
                "xml-to-json/example_1_TFFFFF.json"
        );
    }

    @Test
    public void testXmlJson_1_TFFFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "marshalTypeHintsForceTop",
                "xml-to-json/example_1.xml",
                "xml-to-json/example_1_TFFFFT.json"
        );
    }

    /*****************************************
     ** Example 2
     *****************************************/

    @Test
    public void testXmlJson_2_FFFFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "marshalNone",
                "xml-to-json/example_2.xml",
                "xml-to-json/example_2_FFFFFF.json"
        );
    }

    @Test
    public void testXmlJson_2_FFFFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "marshalTypeHints",
                "xml-to-json/example_2.xml",
                "xml-to-json/example_2_FFFFFT.json"
        );
    }

    @Test
    public void testXmlJson_2_TFFFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "marshalForceTop",
                "xml-to-json/example_2.xml",
                "xml-to-json/example_2_TFFFFF.json"
        );
    }

    @Test
    public void testXmlJson_2_TFFFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "marshalTypeHintsForceTop",
                "xml-to-json/example_2.xml",
                "xml-to-json/example_2_TFFFFT.json"
        );
    }

    /*****************************************
     ** Example 3
     *****************************************/

    @Test
    public void testXmlJson_3_FFFFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "marshalNone",
                "xml-to-json/example_3.xml",
                "xml-to-json/example_3_FFFFFF.json"
        );
    }

    @Test
    public void testXmlJson_3_FFFFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "marshalTypeHints",
                "xml-to-json/example_3.xml",
                "xml-to-json/example_3_FFFFFT.json"
        );
    }

    @Test
    public void testXmlJson_3_TFFFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "marshalForceTop",
                "xml-to-json/example_3.xml",
                "xml-to-json/example_3_TFFFFF.json"
        );
    }

    @Test
    public void testXmlJson_3_TFFFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "marshalTypeHintsForceTop",
                "xml-to-json/example_3.xml",
                "xml-to-json/example_3_TFFFFT.json"
        );
    }

    /*****************************************
     ** Example 4
     *****************************************/

    @Test
    public void testXmlJson_4_FFFFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "marshalNone",
                "xml-to-json/example_4.xml",
                "xml-to-json/example_4_FFFFFF.json"
        );
    }

    @Test
    public void testXmlJson_4_FFFFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "marshalTypeHints",
                "xml-to-json/example_4.xml",
                "xml-to-json/example_4_FFFFFT.json"
        );
    }

    @Test
    public void testXmlJson_4_TFFFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "marshalForceTop",
                "xml-to-json/example_4.xml",
                "xml-to-json/example_4_TFFFFF.json"
        );
    }

    @Test
    public void testXmlJson_4_TFFFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "marshalTypeHintsForceTop",
                "xml-to-json/example_4.xml",
                "xml-to-json/example_4_TFFFFT.json"
        );
    }

    /*****************************************
     ** Example 5
     *****************************************/

    @Test
    public void testXmlJson_5_FFFFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "marshalNone",
                "xml-to-json/example_5.xml",
                "xml-to-json/example_5_FFFFFF.json"
        );
    }

    @Test
    public void testXmlJson_5_FFFFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "marshalTypeHints",
                "xml-to-json/example_5.xml",
                "xml-to-json/example_5_FFFFFT.json"
        );
    }

    @Test
    public void testXmlJson_5_TFFFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "marshalForceTop",
                "xml-to-json/example_5.xml",
                "xml-to-json/example_5_TFFFFF.json"
        );
    }

    @Test
    public void testXmlJson_5_TFFFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "marshalTypeHintsForceTop",
                "xml-to-json/example_5.xml",
                "xml-to-json/example_5_TFFFFT.json"
        );
    }

    /*****************************************
     ** Example 6
     *****************************************/

    @Test
    public void testXmlJson_6_FFFFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "marshalNone",
                "xml-to-json/example_6.xml",
                "xml-to-json/example_6_FFFFFF.json"
        );
    }

    @Test
    public void testXmlJson_6_FFFFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "marshalTypeHints",
                "xml-to-json/example_6.xml",
                "xml-to-json/example_6_FFFFFT.json"
        );
    }

    @Test
    public void testXmlJson_6_TFFFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "marshalForceTop",
                "xml-to-json/example_6.xml",
                "xml-to-json/example_6_TFFFFF.json"
        );
    }

    @Test
    public void testXmlJson_6_TFFFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "marshalTypeHintsForceTop",
                "xml-to-json/example_6.xml",
                "xml-to-json/example_6_TFFFFT.json"
        );
    }

    /*****************************************
     ** Example 7
     *****************************************/

    @Test
    public void testXmlJson_7_FFFFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "marshalNone",
                "xml-to-json/example_7.xml",
                "xml-to-json/example_7_FFFFFF.json"
        );
    }

    @Test
    public void testXmlJson_7_FFFFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "marshalTypeHints",
                "xml-to-json/example_7.xml",
                "xml-to-json/example_7_FFFFFT.json"
        );
    }

    @Test
    public void testXmlJson_7_TFFFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "marshalForceTop",
                "xml-to-json/example_7.xml",
                "xml-to-json/example_7_TFFFFF.json"
        );
    }

    @Test
    public void testXmlJson_7_TFFFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "marshalTypeHintsForceTop",
                "xml-to-json/example_7.xml",
                "xml-to-json/example_7_TFFFFT.json"
        );
    }

    /*****************************************
     ** Example 8
     *****************************************/

    @Test
    public void testXmlJson_8_FFFFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "marshalNone",
                "xml-to-json/example_8.xml",
                "xml-to-json/example_8_FFFFFF.json"
        );
    }

    @Test
    public void testXmlJson_8_FFFFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "marshalTypeHints",
                "xml-to-json/example_8.xml",
                "xml-to-json/example_8_FFFFFT.json"
        );
    }

    @Test
    public void testXmlJson_8_TFFFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "marshalForceTop",
                "xml-to-json/example_8.xml",
                "xml-to-json/example_8_TFFFFF.json"
        );
    }

    @Test
    public void testXmlJson_8_TFFFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "marshalTypeHintsForceTop",
                "xml-to-json/example_8.xml",
                "xml-to-json/example_8_TFFFFT.json"
        );
    }

    /*****************************************
     ** Example 9
     *****************************************/

    @Test
    public void testXmlJson_9_FFFFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "marshalNone",
                "xml-to-json/example_9.xml",
                "xml-to-json/example_9_FFFFFF.json"
        );
    }

    @Test
    public void testXmlJson_9_FFFFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "marshalTypeHints",
                "xml-to-json/example_9.xml",
                "xml-to-json/example_9_FFFFFT.json"
        );
    }

    @Test
    public void testXmlJson_9_TFFFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "marshalForceTop",
                "xml-to-json/example_9.xml",
                "xml-to-json/example_9_TFFFFF.json"
        );
    }

    @Test
    public void testXmlJson_9_TFFFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "marshalTypeHintsForceTop",
                "xml-to-json/example_9.xml",
                "xml-to-json/example_9_TFFFFT.json"
        );
    }

    /*****************************************
     ** Example 10
     *****************************************/

    @Test
    public void testXmlJson_10_FFFFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "marshalNone",
                "xml-to-json/example_10.xml",
                "xml-to-json/example_10_FFFFFF.json"
        );
    }

    @Test
    public void testXmlJson_10_FFFFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "marshalTypeHints",
                "xml-to-json/example_10.xml",
                "xml-to-json/example_10_FFFFFT.json"
        );
    }

    @Test
    public void testXmlJson_10_TFFFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "marshalForceTop",
                "xml-to-json/example_10.xml",
                "xml-to-json/example_10_TFFFFF.json"
        );
    }

    @Test
    public void testXmlJson_10_TFFFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "marshalTypeHintsForceTop",
                "xml-to-json/example_10.xml",
                "xml-to-json/example_10_TFFFFT.json"
        );
    }

    /*****************************************
     ** Example 11
     *****************************************/

    @Test
    public void testXmlJson_11_FFFFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "marshalNone",
                "xml-to-json/example_11.xml",
                "xml-to-json/example_11_FFFFFF.json"
        );
    }

    @Test
    public void testXmlJson_11_FFFFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "marshalTypeHints",
                "xml-to-json/example_11.xml",
                "xml-to-json/example_11_FFFFFT.json"
        );
    }

    @Test
    public void testXmlJson_11_TFFFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "marshalForceTop",
                "xml-to-json/example_11.xml",
                "xml-to-json/example_11_TFFFFF.json"
        );
    }

    @Test
    public void testXmlJson_11_TFFFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "marshalTypeHintsForceTop",
                "xml-to-json/example_11.xml",
                "xml-to-json/example_11_TFFFFT.json"
        );
    }

    private void compareInputXmlFileWithOutputJsonFile(String routeName, String inputXmlFile, String outputJsonFile)
            throws IOException, InterruptedException {
        String defaultXml = IOUtils.toString(classLoader.getResourceAsStream(inputXmlFile), StandardCharsets.UTF_8);
        String defaultJson = IOUtils.toString(classLoader.getResourceAsStream(outputJsonFile), StandardCharsets.UTF_8);

        resultEndpoint.expectedMessageCount(1);
        template.sendBody("direct:"+routeName, defaultXml);
        String exchangeBody = getLastExchange(resultEndpoint).getIn().getBody(String.class);

        System.out.println("exchangeBody >>> "+exchangeBody);

        JSONAssert.assertEquals(
                "Expected the exchange body to equal the given json", defaultJson, exchangeBody, true
        );

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
                        from("direct:marshalNone")
                                .to("dataformat:custom-xmljsonlegacy:marshal?typeHints=false&forceTopLevelObject=false")
                                .to("mock:result");
                    }
                },
                new RouteBuilder() {
                    public void configure() {
                        from("direct:marshalTypeHints")
                                .to("dataformat:custom-xmljsonlegacy:marshal?typeHints=true&forceTopLevelObject=false")
                                .to("mock:result");
                    }
                },
                new RouteBuilder() {
                    public void configure() {
                        from("direct:marshalForceTop")
                                .to("dataformat:custom-xmljsonlegacy:marshal?typeHints=false&forceTopLevelObject=true")
                                .to("mock:result");
                    }
                },
                new RouteBuilder() {
                    public void configure() {
                        from("direct:marshalTypeHintsForceTop")
                                .to("dataformat:custom-xmljsonlegacy:marshal?typeHints=true&forceTopLevelObject=true")
                                .to("mock:result");
                    }
                },
        };
    }

}
