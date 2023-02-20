package org.assimbly.edifactdotweb;

import org.apache.camel.Exchange;
import org.apache.camel.Route;
import org.apache.camel.builder.RouteBuilder;
import org.apache.commons.io.IOUtils;
import org.custommonkey.xmlunit.XMLUnit;
import org.apache.camel.test.junit5.CamelTestSupport;
import org.junit.jupiter.api.Test;
import org.assimbly.edifactdotweb.domain.Type;

import java.io.File;

import static org.custommonkey.xmlunit.XMLAssert.assertXMLEqual;

public class EdifactDotwebComponentTest extends CamelTestSupport {

    private Type type;

    protected RouteBuilder createCustomRouteBuilder() throws Exception {
        return new RouteBuilder() {
            @Override
            public void configure() throws Exception {
                from("direct:transform")
                        .to(String.format("edifact-dotweb://%s", type))
                        .to("mock:out");
            }
        };
    }

    @Test
    public void VRZUIM_1941Test() throws Exception {
        type = Type.VRZUIM_1941;

        refreshRoutes();

        template.sendBody("direct:transform", new File("src/test/resources/VRZUIM_1941.edi"));

        Exchange result = getMockEndpoint("mock:out").getExchanges().get(0);

        String actual = result.getIn().getBody(String.class);
        String expected = IOUtils.toString(
                this.getClass().getResourceAsStream("/expected/VRZUIM_1941.xml"),
                "UTF-8"
        );

        XMLUnit.setIgnoreWhitespace(true);

        assertXMLEqual(expected, actual);
    }

    private void refreshRoutes() throws Exception {
        for(Route r: context.getRoutes()){
            context.removeRoute(r.getId());
        }

            context.addRoutes(createCustomRouteBuilder());
    }
}
