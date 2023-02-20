package world.dovetail.edi;

import org.apache.camel.EndpointInject;
import org.apache.camel.Exchange;
import org.apache.camel.Produce;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit5.CamelTestSupport;
import org.junit.jupiter.api.Test;

import static org.custommonkey.xmlunit.XMLAssert.assertXMLEqual;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class EdiComponentTest extends CamelTestSupport {

    @EndpointInject(uri = "mock:result")
    protected MockEndpoint resultEndpoint;

    @Produce
    protected ProducerTemplate template;

    @Test
    public void convertsEdiToXmlWithinCamelRoute() throws Exception {
        resultEndpoint.expectedMessageCount(1);

        String expectedXml = "<edi-message>" +
            "<delimiters segment=\"LB\" field=\"~\" component=\"^\" sub-component=\"!\" />" +
            "<A />" +
            "<B />" +
            "</edi-message>";

        template.sendBody("direct:dataformatMarshal", "A\nB");

        String exchangeBody = getLastExchange(resultEndpoint).getIn().getBody(String.class);
        assertXMLEqual(expectedXml, exchangeBody);

        resultEndpoint.assertIsSatisfied();
    }

    @Test
    public void convertsXmlToEdiWithinCamelRoute() throws Exception {
        resultEndpoint.expectedMessageCount(1);

        String expectedEdi = "A~A 11!A 12^A 2";
        String inputXml = "<edi-message>" +
            "<delimiters segment=\"LB\" field=\"~\" component=\"^\" sub-component=\"!\"/>" +
            "<A>" +
            "<field.1>" +
            "<component.1>" +
            "<sub-component.1>A 11</sub-component.1>" +
            "<sub-component.2>A 12</sub-component.2>" +
            "</component.1>" +
            "<component.2>A 2</component.2>" +
            "</field.1>" +
            "</A>" +
            "</edi-message>";

        template.sendBody("direct:dataformatUnmarshal", inputXml);

        String exchangeBody = getLastExchange(resultEndpoint).getIn().getBody(String.class);
        assertEquals(expectedEdi, exchangeBody);

        resultEndpoint.assertIsSatisfied();
    }

    private Exchange getLastExchange(MockEndpoint endpoint) {
        int size = endpoint.getReceivedExchanges().size();
        return endpoint.getReceivedExchanges().get(size -1);
    }

    @Override
    protected RouteBuilder[] createRouteBuilders() {
        return new RouteBuilder[] {
            new RouteBuilder() {
                public void configure() {
                    from("direct:dataformatMarshal").to("dataformat:edi:marshal" +
                            "?segment=LB" +
                            "&field=~" +
                            "&component=^" +
                            "&subComponent=!"
                    ).to("mock:result");
                }
            },
            new RouteBuilder() {
                public void configure() {
                    from("direct:dataformatUnmarshal").to("dataformat:edi:unmarshal").to("mock:result");
                }
            }
        };
    }
}
