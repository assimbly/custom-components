package org.assimbly.docconverter;

import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.test.junit5.CamelTestSupport;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

class DocConverterTest extends CamelTestSupport {

    @Override
    protected RouteBuilder createRouteBuilder() {
        return new RouteBuilder() {
            @Override
            public void configure() {
                from("direct:in")
                        .to("docconverter:xml2json")
                        .to("mock:out");

            }
        };
    }


    @Test
    void testCsvWithHeaders() throws JSONException {
        String xml = """
                <persons>
                			  <person>
                				<name>John Doe</name>
                			  </person>
                			  <person>
                				<name>Jane Doe</name>
                			  </person>
                			</persons>""";
        template.sendBody("direct:in", xml);

        Exchange result = getMockEndpoint("mock:out").getExchanges().getFirst();

        String expected = getExpected();
        String actual = result.getIn().getBody(String.class);

        JSONAssert.assertEquals(expected, actual, false);

    }




    private String getExpected() {
        return """
                {"persons": {"person": [
                    {"name": "John Doe"},
                    {"name": "Jane Doe"}
                ]}}\
                """;
    }


}
