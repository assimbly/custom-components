package world.dovetail.edifactstandards;

import org.apache.camel.Exchange;
import org.apache.camel.Route;
import org.apache.camel.builder.RouteBuilder;
import org.apache.commons.io.IOUtils;
import org.custommonkey.xmlunit.XMLUnit;
import org.apache.camel.test.junit5.CamelTestSupport;
import org.junit.jupiter.api.Test;
import world.dovetail.edifactstandards.domain.Type;

import java.io.File;

import static org.custommonkey.xmlunit.XMLAssert.assertXMLEqual;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class EdifactStandardsComponentTest extends CamelTestSupport {

    private Type type;

    protected RouteBuilder createCustomRouteBuilder() throws Exception {
        return new RouteBuilder() {
            @Override
            public void configure() throws Exception {
                from("direct:transform")
                        .to(String.format("edifact-standards://%s", type))
                        .to("mock:out");
            }
        };
    }

    @Test
    public void IFTMBCD96BTest() throws Exception {
        type = Type.IFTMBC_D96B;

        refreshRoutes();

        template.sendBody("direct:transform", new File("src/test/resources/IFTMBC_D96B.edi"));

        Exchange result = getMockEndpoint("mock:out").getExchanges().get(0);

        String actual = result.getIn().getBody(String.class);
        String expected = IOUtils.toString(
                this.getClass().getResourceAsStream("/expected/IFTMBC_D96B.xml"),
                "UTF-8"
        );

        XMLUnit.setIgnoreWhitespace(true);

        assertXMLEqual(expected, actual);
    }

    @Test
    public void IFTMBCD98ATest() throws Exception {
        type = Type.IFTMBC_D96B;

        refreshRoutes();

        template.sendBody("direct:transform", new File("src/test/resources/IFTMBC_D98A.edi"));

        Exchange result = getMockEndpoint("mock:out").getExchanges().get(0);

        String actual = result.getIn().getBody(String.class);

        String expected = IOUtils.toString(
                this.getClass().getResourceAsStream("/expected/IFTMBC_D98A.xml"),
                "UTF-8"
        );

        XMLUnit.setIgnoreWhitespace(true);

        assertXMLEqual(expected, actual);
    }

    @Test
    public void IFTMIND96ATest() throws Exception {
        type = Type.IFTMIN_D96A;

        refreshRoutes();

        template.sendBody("direct:transform", new File("src/test/resources/IFTMIN_D96A.edi"));

        Exchange result = getMockEndpoint("mock:out").getExchanges().get(0);

        String actual = result.getIn().getBody(String.class);
        String expected = IOUtils.toString(
                this.getClass().getResourceAsStream("/expected/IFTMIN_D96A.xml"),
                "UTF-8"
        );

        XMLUnit.setIgnoreWhitespace(true);

        assertXMLEqual(expected, actual);
    }

    @Test
    public void DESADVD96ATest() throws Exception {
        type = Type.DESADV_D96A;

        refreshRoutes();

        template.sendBody("direct:transform", new File("src/test/resources/DESADV_D96A.edi"));

        Exchange result = getMockEndpoint("mock:out").getExchanges().get(0);

        String actual = result.getIn().getBody(String.class);
        String expected = IOUtils.toString(
                this.getClass().getResourceAsStream("/expected/DESADV_D96A.xml"),
                "UTF-8"
        );

        XMLUnit.setIgnoreWhitespace(true);

        assertXMLEqual(expected, actual);
    }

    @Test
    public void ORDERSD93ATest() throws Exception {
        type = Type.ORDERS_D93A;

        refreshRoutes();

        template.sendBody("direct:transform", new File("src/test/resources/ORDERS_D93A.edi"));

        Exchange result = getMockEndpoint("mock:out").getExchanges().get(0);

        String actual = result.getIn().getBody(String.class);
        String expected = IOUtils.toString(
                this.getClass().getResourceAsStream("/expected/ORDERS_D93A.xml"),
                "UTF-8"
        );

        XMLUnit.setIgnoreWhitespace(true);

        assertXMLEqual(expected, actual);
    }

    @Test
    public void IFCSUMD08ATest() throws Exception {
        type = Type.IFCSUM_D08A;

        refreshRoutes();

        template.sendBody("direct:transform", new File("src/test/resources/IFCSUM_D08A.edi"));

        Exchange result = getMockEndpoint("mock:out").getExchanges().get(0);

        String actual = result.getIn().getBody(String.class);
        String expected = IOUtils.toString(
                this.getClass().getResourceAsStream("/expected/IFCSUM_D08A.xml"),
                "UTF-8"
        );

        XMLUnit.setIgnoreWhitespace(true);

        assertXMLEqual(expected, actual);
    }

    @Test
    public void IFTMIND99ATest() throws Exception {
        type = Type.IFTMIN_D99A;

        refreshRoutes();

        template.sendBody("direct:transform", new File("src/test/resources/IFTMIN_D99A.edi"));

        Exchange result = getMockEndpoint("mock:out").getExchanges().get(0);

        String actual = result.getIn().getBody(String.class);
        String expected = IOUtils.toString(
                this.getClass().getResourceAsStream("/expected/IFTMIN_D99A.xml"),
                "UTF-8"
        );

        XMLUnit.setIgnoreWhitespace(true);

        assertXMLEqual(expected, actual);
    }

    @Test
    public void XML_TO_IFTMIND99B_TEST() throws Exception {
        type = Type.XML_TO_IFTMIN_D99B;

        refreshRoutes();

        template.sendBody("direct:transform", new File("src/test/resources/IFTMIN_D99B.xml"));

        Exchange result = getMockEndpoint("mock:out").getExchanges().get(0);

        String actual = result.getIn().getBody(String.class);
        String expected = IOUtils.toString(
                this.getClass().getResourceAsStream("/expected/IFTMIN_D99B.edi"),
                "UTF-8"
        );

        //use replace, because line endings can be different for each OS
        expected = expected.replace("\n", "").replace("\r", "");
        actual = actual.replace("\n", "").replace("\r", "");

        assertEquals(expected, actual);
    }

    @Test
    public void XML_TO_IFTFCCD00B_TEST() throws Exception {
        type = Type.XML_TO_IFTFCC_D00B;

        refreshRoutes();

        template.sendBody("direct:transform", new File("src/test/resources/IFTFCC_D00B.xml"));

        Exchange result = getMockEndpoint("mock:out").getExchanges().get(0);

        String actual = result.getIn().getBody(String.class);
        String expected = IOUtils.toString(
                this.getClass().getResourceAsStream("/expected/IFTFCC_D00B.edi"),
                "UTF-8"
        );

        //use replace, because line endings can be different for each OS
        expected = expected.replace("\n", "").replace("\r", "");
        actual = actual.replace("\n", "").replace("\r", "");

        assertEquals(expected, actual);
    }

    private void refreshRoutes() throws Exception {
        for(Route r: context.getRoutes()){
            context.removeRoute(r.getId());
        }

        context.addRoutes(createCustomRouteBuilder());
    }
}
