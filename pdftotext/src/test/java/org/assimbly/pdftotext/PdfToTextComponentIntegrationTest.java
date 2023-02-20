package org.assimbly.pdftotext;

import org.apache.camel.EndpointInject;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit5.CamelTestSupport;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PdfToTextComponentIntegrationTest extends CamelTestSupport {

    @EndpointInject("mock:out")
    private MockEndpoint resultEndpoint;

    @Override
    protected RouteBuilder createRouteBuilder() {
        return new RouteBuilder() {
            @Override
            public void configure() throws Exception {
                from("direct:in")
                        .to("pdftotext:x")
                        .to("mock:out");
            }
        };
    }

    @Test
    public void loadFile() throws Exception {
        resultEndpoint.expectedMessageCount(1);

        template.sendBody("direct:in", getClass().getResource("/test.pdf"));
        resultEndpoint.assertIsSatisfied();

        String expected = "Test";
        String actual = resultEndpoint.getExchanges().get(0).getIn().getBody(String.class);
        actual = actual.replace("\n", "").replace("\r", "");
        assertEquals(expected, actual);
    }
}
