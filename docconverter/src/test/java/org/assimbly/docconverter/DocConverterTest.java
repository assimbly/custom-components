package org.assimbly.docconverter;

import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.test.junit5.CamelTestSupport;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.xml.sax.SAXException;

import java.io.IOException;


public class DocConverterTest extends CamelTestSupport {

    private final String xml = "<persons>\n" +
            "\t\t\t  <person>\n" +
            "\t\t\t\t<name>John Doe</name>\n" +
            "\t\t\t  </person>\n" +
            "\t\t\t  <person>\n" +
            "\t\t\t\t<name>Jane Doe</name>\n" +
            "\t\t\t  </person>\n" +
            "\t\t\t</persons>";

    @Override
    protected RouteBuilder createRouteBuilder() throws Exception {
        return new RouteBuilder() {
            @Override
            public void configure() throws Exception {
                from("direct:in")
                        .to("docconverter:xml2json")
                        .to("mock:out");

            }
        };
    }


    @Test
    public void testCsvWithHeaders() throws IOException, SAXException {
        template.sendBody("direct:in", xml);

        Exchange result = getMockEndpoint("mock:out").getExchanges().get(0);

        String expected = getExpected();
        String actual = result.getIn().getBody(String.class);

        JSONAssert.assertEquals(expected, actual, false);

    }




    private String getExpected() {
        return "{\"persons\": {\"person\": [\n" +
                "    {\"name\": \"John Doe\"},\n" +
                "    {\"name\": \"Jane Doe\"}\n" +
                "]}}";
    }


}
