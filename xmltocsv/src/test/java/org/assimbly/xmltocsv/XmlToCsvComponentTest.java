package org.assimbly.xmltocsv;

import org.apache.camel.EndpointInject;
import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit5.CamelTestSupport;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class XmlToCsvComponentTest extends CamelTestSupport {

    private final String standardSettingsRoute = "standardSettings";

    private final String simpleXml = "simple.xml";

    @EndpointInject("mock:result")
    protected MockEndpoint resultEndpoint;

    @Test
    public void testStandardSettings() throws Exception {
        testTransformation(simpleXml, "standardSettings.csv", standardSettingsRoute);
    }

    @Test
    public void testStandardDepth() throws Exception {
        testTransformation("depth.xml", "standardDepth.csv", standardSettingsRoute);
    }

    @Test
    public void testDepthWithDoubleTags() throws Exception {
        testTransformation("depthWithDoubleTags.xml", "depthWithDoubleTags.csv", standardSettingsRoute);
    }

    @Test
    public void testDepthWithShuffledTags() throws Exception {
        testTransformation("depthWithShuffledTags.xml", "depthWithShuffledTags.csv", standardSettingsRoute);
    }

    @Test
    public void testDepthWithFiveLayers() throws Exception {
        testTransformation("depthWithFiveLayers.xml", "standardDepth.csv", standardSettingsRoute);
    }

    @Test
    public void testCustomDelimiter() throws Exception {
        testTransformation(simpleXml, "customDelimiter.csv", "customDelimiter");
    }

    @Test
    public void testCarriageReturn() throws Exception {
        testTransformation(simpleXml, "carriageReturn.csv", "carriageReturn");
    }

    @Test
    public void testIndexColumnOn() throws Exception {
        testTransformation(simpleXml, "indexColumnOn.csv", "indexColumnOn");
    }

    @Test
    public void testIndexColumnOff() throws Exception {
        testTransformation(simpleXml, "indexColumnOff.csv", "indexColumnOff");
    }

    @Test
    public void testIncludeHeaderOn() throws Exception {
        testTransformation(simpleXml, "includeHeaderOn.csv", "includeHeaderOn");
    }

    @Test
    public void testIncludeHeaderOff() throws Exception {
        testTransformation(simpleXml, "includeHeaderOff.csv", "includeHeaderOff");
    }

    @Test
    public void testCustomIndexColumnName() throws Exception {
        testTransformation(simpleXml, "customIndexColumnName.csv", "customIndexColumnName");
    }

    @Test
    public void testQuoteAllFieldsOption() throws Exception {
        testTransformation(simpleXml, "quoteAllFieldsOption.csv", "quoteAllFieldsOption");
    }

    @Test
    public void testQuoteNonIntegerFieldsOption() throws Exception {
        // Note: Test applies for both positive and negative integers
        testTransformation(simpleXml, "quoteNonIntegerFieldsOption.csv", "quoteNonIntegerFieldsOption");
    }

    @Test
    public void testQuoteNoFieldsOption() throws Exception {
        testTransformation(simpleXml, "quoteNoFieldsOption.csv", "quoteNoFieldsOption");
    }

    @Test
    public void testOrderingAscending() throws Exception {
        testTransformation(simpleXml, "orderingAscending.csv", "orderingAscending");
    }

    @Test
    public void testOrderingDescending() throws Exception {
        testTransformation(simpleXml, "orderingDescending.csv", "orderingDescending");
    }

    @Test
    public void testOrderingUnordered() throws Exception {
        testTransformation(simpleXml, "orderingUnordered.csv", "orderingUnordered");
    }

    @Test
    public void testSelectByXPathExpression() throws Exception {
        testTransformation("xPathExpression.xml", "selectByXPathExpression.csv", "selectByXPathExpression");
    }

    @Override
    protected RouteBuilder[] createRouteBuilders() {
        return new RouteBuilder[] {
                new RouteBuilder() {
                    public void configure() {
                        from("direct:standardSettings")
                                .to("xmltocsv://?includeHeader=true&includeIndexColumn=false&indexColumnName=line&delimiter=(LA==)&lineSeparator=RAW(XG4=)&orderHeaders=UNORDERED&quoteFields=ALL_FIELDS")
                                .to("mock:result");
                    }
                },
                new RouteBuilder() {
                    public void configure() {
                        from("direct:customDelimiter")
                                .to("xmltocsv://?includeHeader=true&includeIndexColumn=false&indexColumnName=line&delimiter=(fA==)&lineSeparator=RAW(XG4=)&orderHeaders=UNORDERED&quoteFields=ALL_FIELDS")
                                .to("mock:result");
                    }
                },
                new RouteBuilder() {
                    public void configure() {
                        from("direct:carriageReturn")
                                .to("xmltocsv://?includeHeader=true&includeIndexColumn=false&indexColumnName=line&delimiter=(LA==)&lineSeparator=RAW(XHI=)&orderHeaders=UNORDERED&quoteFields=ALL_FIELDS")
                                .to("mock:result");
                    }
                },
                new RouteBuilder() {
                    public void configure() {
                        from("direct:indexColumnOn")
                                .to("xmltocsv://?includeHeader=true&includeIndexColumn=true&indexColumnName=line&delimiter=(LA==)&lineSeparator=RAW(XG4=)&orderHeaders=UNORDERED&quoteFields=ALL_FIELDS")
                                .to("mock:result");
                    }
                },
                new RouteBuilder() {
                    public void configure() {
                        from("direct:indexColumnOff")
                                .to("xmltocsv://?includeHeader=true&includeIndexColumn=false&indexColumnName=line&delimiter=(LA==)&lineSeparator=RAW(XG4=)&orderHeaders=UNORDERED&quoteFields=ALL_FIELDS")
                                .to("mock:result");
                    }
                },
                new RouteBuilder() {
                    public void configure() {
                        from("direct:includeHeaderOn")
                                .to("xmltocsv://?includeHeader=true&includeIndexColumn=false&indexColumnName=line&delimiter=(LA==)&lineSeparator=RAW(XG4=)&orderHeaders=UNORDERED&quoteFields=ALL_FIELDS")
                                .to("mock:result");
                    }
                },
                new RouteBuilder() {
                    public void configure() {
                        from("direct:includeHeaderOff")
                                .to("xmltocsv://?includeHeader=false&includeIndexColumn=false&indexColumnName=line&delimiter=(LA==)&lineSeparator=RAW(XG4=)&orderHeaders=UNORDERED&quoteFields=ALL_FIELDS")
                                .to("mock:result");
                    }
                },
                new RouteBuilder() {
                    public void configure() {
                        from("direct:customIndexColumnName")
                                .to("xmltocsv://?includeHeader=true&includeIndexColumn=true&indexColumnName=index&delimiter=(LA==)&lineSeparator=RAW(XG4=)&orderHeaders=UNORDERED&quoteFields=ALL_FIELDS")
                                .to("mock:result");
                    }
                },
                new RouteBuilder() {
                    public void configure() {
                        from("direct:quoteAllFieldsOption")
                                .to("xmltocsv://?includeHeader=true&includeIndexColumn=false&indexColumnName=line&delimiter=(LA==)&lineSeparator=RAW(XG4=)&orderHeaders=UNORDERED&quoteFields=ALL_FIELDS")
                                .to("mock:result");
                    }
                },
                new RouteBuilder() {
                    public void configure() {
                        from("direct:quoteNonIntegerFieldsOption")
                                .to("xmltocsv://?includeHeader=true&includeIndexColumn=false&indexColumnName=line&delimiter=(LA==)&lineSeparator=RAW(XG4=)&orderHeaders=UNORDERED&quoteFields=NON_INTEGER_FIELDS")
                                .to("mock:result");
                    }
                },
                new RouteBuilder() {
                    public void configure() {
                        from("direct:quoteNoFieldsOption")
                                .to("xmltocsv://?includeHeader=true&includeIndexColumn=false&indexColumnName=line&delimiter=(LA==)&lineSeparator=RAW(XG4=)&orderHeaders=UNORDERED&quoteFields=NO_FIELDS")
                                .to("mock:result");
                    }
                },
                new RouteBuilder() {
                    public void configure() {
                        from("direct:orderingAscending")
                                .to("xmltocsv://?includeHeader=true&includeIndexColumn=false&indexColumnName=line&delimiter=(LA==)&lineSeparator=RAW(XG4=)&orderHeaders=ASCENDING&quoteFields=ALL_FIELDS")
                                .to("mock:result");
                    }
                },
                new RouteBuilder() {
                    public void configure() {
                        from("direct:orderingDescending")
                                .to("xmltocsv://?includeHeader=true&includeIndexColumn=false&indexColumnName=line&delimiter=(LA==)&lineSeparator=RAW(XG4=)&orderHeaders=DESCENDING&quoteFields=ALL_FIELDS")
                                .to("mock:result");
                    }
                },
                new RouteBuilder() {
                    public void configure() {
                        from("direct:orderingUnordered")
                                .to("xmltocsv://?includeHeader=true&includeIndexColumn=false&indexColumnName=line&delimiter=(LA==)&lineSeparator=RAW(XG4=)&orderHeaders=UNORDERED&quoteFields=ALL_FIELDS")
                                .to("mock:result");
                    }
                },
                new RouteBuilder() {
                    public void configure() {
                        from("direct:selectByXPathExpression")
                                .to("xmltocsv://?includeHeader=true&includeIndexColumn=false&indexColumnName=line&delimiter=(LA==)&lineSeparator=RAW(XG4=)&orderHeaders=UNORDERED&quoteFields=ALL_FIELDS&xPathExpression=//drink")
                                .to("mock:result");
                    }
                },
        };
    }

    private void testTransformation(String inputFile, String expectedOutputFile, String route) throws Exception {
        String inputPath = "src/test/resources/input/" + inputFile;
        String expectedOutputPath = "src/test/resources/expected-output/" + expectedOutputFile;
        String input = readFileToString(inputPath);
        String expectedOutput = readFileToString(expectedOutputPath);

        template.sendBody("direct:" + route, input);
        String actualOutput = getLastExchange(resultEndpoint).getIn().getBody(String.class);

        assertEquals(expectedOutput, actualOutput);
    }

    private String readFileToString(String path) throws IOException {
        return new String(Files.readAllBytes(Paths.get(path)));
    }

    private Exchange getLastExchange(MockEndpoint endpoint) {
        int size = endpoint.getReceivedExchanges().size();
        return endpoint.getReceivedExchanges().get(size -1);
    }
}
