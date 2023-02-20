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


public class SimpleReplaceDataFormatTest extends CamelTestSupport {

    @EndpointInject("mock:result")
    protected MockEndpoint resultEndpoint;

    @Produce
    protected ProducerTemplate template;

    private static final String title = "Lorem Ipsum";
    private static final String century = "45";
    private static final String age = "2000";

    @Test
    public void replacesSimpleExpressionsValueFound() throws InterruptedException {

        String body = "Contrary to popular belief,\n" +
                "${header.title} is not simply random text.\n" +
                "It has roots in a piece of classical Latin literature from ${header.century} BC,\n" +
                "making it over ${header.age} years old.";

        String expected = "Contrary to popular belief,\n" +
                title + " is not simply random text.\n" +
                "It has roots in a piece of classical Latin literature from " + century + " BC,\n" +
                "making it over " + age + " years old.";

        runTest(expected, body);
    }

    @Test
    public void ignoresSimpleExpressionsValueNotFound() throws InterruptedException {
        String body = "Contrary to popular belief,\n" +
                "this ${header.variable} is simply not found.";

        String expected = "Contrary to popular belief,\n" +
                "this  is simply not found.";

        runTest(expected, body);
    }

    @Test
    public void newLinesRemainsUnchangedAfterSimpleExpressionEvaluation() throws InterruptedException {
        String body = "Contrary to popular belief,\n" +
                "\n" +
                "\n" +
                "there is a two line break above.\n" +
                "and a new line in the end\n";

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
                                .setHeader("title", new ConstantExpression(title))
                                .setHeader("century", new ConstantExpression(century))
                                .setHeader("age", new ConstantExpression(age))
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