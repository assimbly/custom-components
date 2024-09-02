package org.assimbly.edifact;

import org.apache.camel.EndpointInject;
import org.apache.camel.Exchange;
import org.apache.camel.Produce;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.commons.io.IOUtils;
import org.apache.camel.test.junit5.CamelTestSupport;
import org.junit.jupiter.api.Test;

import static org.custommonkey.xmlunit.XMLAssert.assertXMLEqual;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class EdifactComponentTest extends CamelTestSupport {

    @EndpointInject("mock:result")
    protected MockEndpoint resultEndpoint;

    @Produce
    protected ProducerTemplate template;

    @Test
    public void convertsEdiToXmlWithinCamelRoute() throws Exception {
        resultEndpoint.expectedMessageCount(1);

        String expectedXml = IOUtils.toString(this.getClass().getClassLoader().getResourceAsStream("iftmin.xml"));

        // trigger exchange
        String edifact = IOUtils.toString(this.getClass().getClassLoader().getResourceAsStream("iftmin.edi"));
        template.sendBody("direct:ediToXml", edifact);

        // verify exchange contents
        String exchangeBody = resultEndpoint.getExchanges().get(0).getIn().getBody(String.class);
        assertXMLEqual(expectedXml, exchangeBody);

        // wait for the expected exchange to conclude
        resultEndpoint.assertIsSatisfied();
    }

    @Test
    public void convertsXmlToEdiWithinCamelRoute() throws Exception {
        String expectedEdi = IOUtils.toString(this.getClass().getClassLoader().getResourceAsStream("iftmin-with-correct-unt.edi")).replace("\n", "");

        // one exchange is expected
        resultEndpoint.expectedMessageCount(1);

        // trigger exchange
        String xml = IOUtils.toString(this.getClass().getClassLoader().getResourceAsStream("iftmin.xml"));
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
