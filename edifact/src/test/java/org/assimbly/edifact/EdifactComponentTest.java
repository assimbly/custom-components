package org.assimbly.edifact;

import org.apache.camel.EndpointInject;
import org.apache.camel.Exchange;
import org.apache.camel.Produce;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit5.CamelTestSupport;
import org.junit.jupiter.api.Test;

import java.nio.charset.StandardCharsets;
import java.util.Objects;

import static org.xmlunit.assertj3.XmlAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

class EdifactComponentTest extends CamelTestSupport {

    @EndpointInject("mock:result")
    protected MockEndpoint resultEndpoint;

    @Produce
    protected ProducerTemplate template;

    @Test
    void convertsEdiToXmlWithinCamelRoute() throws Exception {
        resultEndpoint.expectedMessageCount(1);

        String expected = new String(this.getClass().getClassLoader().getResourceAsStream("iftmin.xml").readAllBytes(), StandardCharsets.UTF_8);

        // trigger exchange
        String edifact = new String(this.getClass().getClassLoader().getResourceAsStream("iftmin.edi").readAllBytes(), StandardCharsets.UTF_8);
        template.sendBody("direct:ediToXml", edifact);

        // verify exchange contents
        String actual = resultEndpoint.getExchanges().getFirst().getIn().getBody(String.class);

		assertThat(actual).and(expected).areIdentical();

        // wait for the expected exchange to conclude
        resultEndpoint.assertIsSatisfied();
    }

    @Test
    void convertsXmlToEdiWithinCamelRoute() throws Exception {

        String expectedEdi = new String(Objects.requireNonNull(this.getClass().getClassLoader().getResourceAsStream("iftmin-with-correct-unt.edi")).readAllBytes(), StandardCharsets.UTF_8).replace("\n", "");

        // one exchange is expected
        resultEndpoint.expectedMessageCount(1);

        // trigger exchange
        String xml =  new String(Objects.requireNonNull(this.getClass().getClassLoader().getResourceAsStream("iftmin.xml")).readAllBytes(), StandardCharsets.UTF_8);
        template.sendBody("direct:xmlToEdi", xml);

        // wait for the expected exchange to conclude
        resultEndpoint.assertIsSatisfied();

        // verify exchange contents
        String exchangeBody = getLastExchange(resultEndpoint).getIn().getBody(String.class);
        String normalizedExchangeBody = exchangeBody.replaceAll("\\r\\n?", "");
        assertEquals(expectedEdi, normalizedExchangeBody);
    }

    private Exchange getLastExchange(MockEndpoint endpoint) {
        int size = endpoint.getReceivedExchanges().size();
        return endpoint.getReceivedExchanges().get(size - 1);
    }

    @Override
    protected RouteBuilder[] createRouteBuilders() {
        return new RouteBuilder[] {
            new RouteBuilder() {
                public void configure() {
                    from("direct:ediToXml").to("dataformat:edifact:marshal?edifactType=d96a").to("mock:result");
                }
            },
            new RouteBuilder() {
                public void configure() {
                    from("direct:xmlToEdi").to("dataformat:edifact:unmarshal?edifactType=d96a").to("mock:result");
                }
            }
        };
    }
}
