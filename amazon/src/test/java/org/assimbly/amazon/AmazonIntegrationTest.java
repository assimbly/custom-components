package org.assimbly.amazon;

import org.apache.camel.Exchange;
import org.apache.camel.Route;
import org.apache.camel.model.language.ConstantExpression;
import org.assimbly.amazon.domain.Operation;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.test.junit5.CamelTestSupport;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class AmazonIntegrationTest extends CamelTestSupport {

    private Operation operation;

    protected RouteBuilder createCustomRouteBuilder() throws Exception {
        return new RouteBuilder() {
            @Override
            public void configure() throws Exception {
                from("direct:start")
                        .setHeader("accessKeyHeader", new ConstantExpression("AKIAIDCWU7SMT3765MSQ"))
                        .to("amazon://" + operation + "?accessKey=${header.accessKeyHeader}&secretKey=RAW(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)&authToken=RAW()&sellerId=RAW(A286R55XIM629C)&marketplace=RAW(NA)")
                        .to("mock:out");
            }
        };
    }

    @Test
    public void connectToAmazonTest() throws Exception {
        operation = Operation.LIST_MARKETPLACE_PARTICIPATIONS;

        refreshRoutes();

        template.sendBody("direct:start", "random");

        Exchange result = getMockEndpoint("mock:out").getExchanges().get(0);

        assertEquals("200 - OK", result.getIn().getHeader("Amazon-ResponseCode"));
    }

    private void refreshRoutes() throws Exception {
        for(Route r: context.getRoutes()){
            context.removeRoute(r.getId());
        }

        context.addRoutes(createCustomRouteBuilder());
    }
}
