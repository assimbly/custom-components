package org.assimbly.soap;

import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.test.junit5.CamelTestSupport;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;


public class SoapIntegrationTest extends CamelTestSupport {

    @Override
    protected RouteBuilder createRouteBuilder() throws Exception {
        return new RouteBuilder() {
            @Override
            public void configure() throws Exception {
                from("direct:reproduce")
                        .to("soap://<settings>")
                        .to("mock:out");
            }
        };
    }

    @Test
    @Disabled
    public void reproduce() {
        template.sendBody(
                "direct:reproduce",
                "<Input/>");

        getMockEndpoint("mock:out").expectedMessageCount(1);

        Exchange result = getMockEndpoint("mock:out").getExchanges().get(0);
    }
}
