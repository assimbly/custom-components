package world.dovetail.formtoxml;

import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.test.junit5.CamelTestSupport;
import org.junit.jupiter.api.Test;


import static org.custommonkey.xmlunit.XMLAssert.assertXMLEqual;


public class FormToXmlComponentTest extends CamelTestSupport {

    private final String encoding = "utf-8";

    private final String expectedXml =
            "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
            "<items>\n" +
            "  <surname>Catalão</surname>\n" +
            "  <name>Pedro</name>\n" +
            "  <myage>36</myage>\n" +
            "</items>";

    private final String expectedXmlWithInvalidKeyNames =
            "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
            "<items>\n" +
            "  <city>Lisbon</city>\n" +
            "</items>";

    private final String expectedXmlWithEmptyKeyValues =
            "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                    "<items>\n" +
                    "  <surname>catalao</surname>\n" +
                    "  <name></name>\n" +
                    "</items>";

    @Override
    protected RouteBuilder createRouteBuilder() throws Exception {
        return new RouteBuilder() {
            @Override
            public void configure() throws Exception {
                from("direct:testRoute")
                        .to("formtoxml://?encoding=" + encoding)
                        .to("mock:testFormToXml");
            }
        };
    }

    @Test
    public void testFormDataValid() throws Exception {
        String validFormData = "name=Pedro&surname=Catalão&myage=36";
        template.sendBody("direct:testRoute", validFormData);

        Exchange result = getMockEndpoint("mock:testFormToXml").getExchanges().get(0);
        String body = result.getIn().getBody(String.class);

        assertXMLEqual(expectedXml, body);
    }

    @Test
    public void testFormDataWithInvalidCharacters() throws Exception {
        String formDataInvalidCharacters = "name=Pedro&sur$naãme=Catalão&my age=36";
        template.sendBody("direct:testRoute", formDataInvalidCharacters);

        Exchange result = getMockEndpoint("mock:testFormToXml").getExchanges().get(0);

        String body = result.getIn().getBody(String.class);

        assertXMLEqual(expectedXml, body);
    }

    @Test
    public void testFormDataWithInvalidKeyNames() throws Exception {
        String formDataWithInvalidKeyNames = "38=Pedro&city=Lisbon";
        template.sendBody("direct:testRoute", formDataWithInvalidKeyNames);

        Exchange result = getMockEndpoint("mock:testFormToXml").getExchanges().get(0);

        String body = result.getIn().getBody(String.class);

        assertXMLEqual(expectedXmlWithInvalidKeyNames, body);
    }

    @Test
    public void testFormDataWithEmptyKeyValues() throws Exception {
        String formDataEmptyKeyValues = "name=&surname=catalao=age&=";
        template.sendBody("direct:testRoute", formDataEmptyKeyValues);

        Exchange result = getMockEndpoint("mock:testFormToXml").getExchanges().get(0);

        String body = result.getIn().getBody(String.class);

        assertXMLEqual(expectedXmlWithEmptyKeyValues, body);
    }
}