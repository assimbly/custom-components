package org.assimbly.aleris;

import org.apache.camel.EndpointInject;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit5.CamelTestSupport;
import org.junit.jupiter.api.Test;

public class AlerisComponentIntegrationTest extends CamelTestSupport {

    @EndpointInject("mock:out")
    private MockEndpoint resultEndpoint;

    @Override
    protected RouteBuilder createRouteBuilder() throws Exception {
        return new RouteBuilder() {
            @Override
            public void configure() throws Exception {
                from("direct:in")
                        .to("aleris:convert")
                        .to("mock:out");
            }
        };
    }

    @Test
    public void canBeInstantiated() throws Exception {
        resultEndpoint.expectedMessageCount(1);
        template.sendBody("direct:in", getClass().getResource("/converter/corby.cert"));
        resultEndpoint.assertIsSatisfied();
    }
}
