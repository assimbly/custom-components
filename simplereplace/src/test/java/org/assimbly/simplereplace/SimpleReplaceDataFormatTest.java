package org.assimbly.simplereplace;

import org.apache.camel.EndpointInject;
import org.apache.camel.Exchange;
import org.apache.camel.Produce;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.model.language.ConstantExpression;
import org.apache.camel.test.junit5.CamelTestSupport;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class SimpleReplaceDataFormatTest extends CamelTestSupport {

    @EndpointInject("mock:result")
    protected MockEndpoint resultEndpoint;

    @Produce
    protected ProducerTemplate template;

    private static final String TITLE = "Lorem Ipsum";
    private static final String CENTURY = "45";
    private static final String AGE = "2000";

    @Test
    void replacesSimpleExpressionsValueFound() throws InterruptedException {

        String body = """
                Contrary to popular belief,
                ${header.TITLE} is not simply random text.
                It has roots in a piece of classical Latin literature from ${header.CENTURY} BC,
                making it over ${header.age} years old.""";

        String expected = "Contrary to popular belief,\n" +
                TITLE + " is not simply random text.\n" +
                "It has roots in a piece of classical Latin literature from " + CENTURY + " BC,\n" +
                "making it over " + AGE + " years old.";

        runTest(expected, body);
    }

    @Test
    void ignoresSimpleExpressionsValueNotFound() throws InterruptedException {
        String body = """
                Contrary to popular belief,
                this ${header.variable} is simply not found.""";

        String expected = """
                Contrary to popular belief,
                this  is simply not found.""";

        runTest(expected, body);
    }

    @Test
    void newLinesRemainsUnchangedAfterSimpleExpressionEvaluation() throws InterruptedException {
        String body = """
                Contrary to popular belief,
                
                
                there is a two line break above.
                and a new line in the end
                """;

        runTest(body, body);
    }

    protected void runTest(String expected, String body) throws InterruptedException {
        resultEndpoint.expectedMessageCount(1);
        template.sendBody("direct:unmarshal", body);
        String exchangeBody = getLastExchange(resultEndpoint).getIn().getBody(String.class);
        assertEquals(expected, exchangeBody);
        resultEndpoint.assertIsSatisfied();
    }

    @Override
    protected RouteBuilder[] createRouteBuilders() {
        return new RouteBuilder[] {
                new RouteBuilder() {
                    public void configure() {
                        from("direct:unmarshal")
                                .setHeader("title", new ConstantExpression(TITLE))
                                .setHeader("century", new ConstantExpression(CENTURY))
                                .setHeader("age", new ConstantExpression(AGE))
                                .to("dataformat:simple-replace:unmarshal")
                                .to("mock:result");
                    }
                }
        };
    }

    private Exchange getLastExchange(MockEndpoint endpoint) {
        int size = endpoint.getReceivedExchanges().size();
        return endpoint.getReceivedExchanges().get(size -1);
    }
}