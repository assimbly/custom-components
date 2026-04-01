package org.assimbly.formtoxml;

import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.test.junit5.CamelTestSupport;
import org.junit.jupiter.api.Test;

import static org.xmlunit.assertj3.XmlAssert.assertThat;

class FormToXmlComponentTest extends CamelTestSupport {

    private final String encoding = "utf-8";

    private static final String EXPECTED =
            """
            <?xml version="1.0" encoding="utf-8"?>
            <items>
              <name>Pedro</name>
              <surname>Catalão</surname>
              <myage>36</myage>
            </items>""";

    private static final String EXPECTED_XML_WITH_INVALID_KEY_VALUES =
            """
            <?xml version="1.0" encoding="utf-8"?>
            <items>
              <city>Lisbon</city>
            </items>""";

    private static final String EXPECTED_XML_WITH_EMPTY_KEY_VALUES =
            """
            <?xml version="1.0" encoding="utf-8"?>
            <items>
              <name></name>
              <surname>catalao</surname>
            </items>""";

    @Override
    protected RouteBuilder createRouteBuilder() {
        return new RouteBuilder() {
            @Override
            public void configure() {
                from("direct:testRoute")
                        .to("formtoxml://?encoding=" + encoding)
                        .to("mock:testFormToXml");
            }
        };
    }

    @Test
    void testFormDataValid() {
        String validFormData = "name=Pedro&surname=Catalão&myage=36";
        template.sendBody("direct:testRoute", validFormData);

        Exchange result = getMockEndpoint("mock:testFormToXml").getExchanges().getFirst();
        String actual = result.getIn().getBody(String.class);

        assertThat(actual).and(EXPECTED).areIdentical();

    }

    @Test
    void testFormDataWithInvalidCharacters() {
        String formDataInvalidCharacters = "name=Pedro&sur$naãme=Catalão&my age=36";
        template.sendBody("direct:testRoute", formDataInvalidCharacters);

        Exchange result = getMockEndpoint("mock:testFormToXml").getExchanges().getFirst();

        String actual = result.getIn().getBody(String.class);

        assertThat(actual).and(EXPECTED).areIdentical();

    }

    @Test
    void testFormDataWithInvalidKeyNames() {
        String formDataWithInvalidKeyNames = "38=Pedro&city=Lisbon";
        template.sendBody("direct:testRoute", formDataWithInvalidKeyNames);

        Exchange result = getMockEndpoint("mock:testFormToXml").getExchanges().getFirst();

        String actual = result.getIn().getBody(String.class);

        assertThat(actual).and(EXPECTED_XML_WITH_INVALID_KEY_VALUES).areIdentical();

    }

    @Test
    void testFormDataWithEmptyKeyValues() {
        String formDataEmptyKeyValues = "name=&surname=catalao=age&=";
        template.sendBody("direct:testRoute", formDataEmptyKeyValues);

        Exchange result = getMockEndpoint("mock:testFormToXml").getExchanges().getFirst();

        String actual = result.getIn().getBody(String.class);

        assertThat(actual).and(EXPECTED_XML_WITH_EMPTY_KEY_VALUES).areIdentical();

    }

}