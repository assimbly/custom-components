package org.assimbly.formtoxml;

import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.test.junit5.CamelTestSupport;
import org.junit.jupiter.api.Test;

import static org.xmlunit.assertj3.XmlAssert.assertThat;

public class FormToXmlComponentTest extends CamelTestSupport {

    private final String encoding = "utf-8";

    private final String expected =
            """
            <?xml version="1.0" encoding="utf-8"?>
            <items>
              <surname>Catalão</surname>
              <name>Pedro</name>
              <myage>36</myage>
            </items>""";

    private final String expectedXmlWithInvalidKeyNames =
            """
            <?xml version="1.0" encoding="utf-8"?>
            <items>
              <city>Lisbon</city>
            </items>""";

    private final String expectedXmlWithEmptyKeyValues =
            """
            <?xml version="1.0" encoding="utf-8"?>
            <items>
              <surname>catalao</surname>
              <name></name>
            </items>""";

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

        Exchange result = getMockEndpoint("mock:testFormToXml").getExchanges().getFirst();
        String actual = result.getIn().getBody(String.class);

        assertThat(actual).and(expected).areIdentical();

    }

    @Test
    public void testFormDataWithInvalidCharacters() throws Exception {
        String formDataInvalidCharacters = "name=Pedro&sur$naãme=Catalão&my age=36";
        template.sendBody("direct:testRoute", formDataInvalidCharacters);

        Exchange result = getMockEndpoint("mock:testFormToXml").getExchanges().getFirst();

        String actual = result.getIn().getBody(String.class);

        assertThat(actual).and(expected).areIdentical();

    }

    @Test
    public void testFormDataWithInvalidKeyNames() throws Exception {
        String formDataWithInvalidKeyNames = "38=Pedro&city=Lisbon";
        template.sendBody("direct:testRoute", formDataWithInvalidKeyNames);

        Exchange result = getMockEndpoint("mock:testFormToXml").getExchanges().getFirst();

        String actual = result.getIn().getBody(String.class);

        assertThat(actual).and(expectedXmlWithInvalidKeyNames).areIdentical();

    }

    @Test
    public void testFormDataWithEmptyKeyValues() throws Exception {
        String formDataEmptyKeyValues = "name=&surname=catalao=age&=";
        template.sendBody("direct:testRoute", formDataEmptyKeyValues);

        Exchange result = getMockEndpoint("mock:testFormToXml").getExchanges().getFirst();

        String actual = result.getIn().getBody(String.class);

        assertThat(actual).and(expectedXmlWithEmptyKeyValues).areIdentical();

    }

}