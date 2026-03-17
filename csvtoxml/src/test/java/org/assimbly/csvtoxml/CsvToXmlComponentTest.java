package org.assimbly.csvtoxml;

import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.dataformat.csv.CsvDataFormat;
import org.custommonkey.xmlunit.XMLUnit;
import org.apache.camel.test.junit5.CamelTestSupport;
import org.junit.jupiter.api.Test;

import org.xml.sax.SAXException;

import java.io.IOException;

import static org.xmlunit.assertj3.XmlAssert.assertThat;

class CsvToXmlComponentTest extends CamelTestSupport {

    private final String encoding = "UTF-8";

    @Override
    protected RouteBuilder createRouteBuilder() throws Exception {
        return new RouteBuilder() {
            @Override
            public void configure() throws Exception {
                from("direct:testWithHeaders")
                        .unmarshal(new CsvDataFormat().setDelimiter(';').setUseMaps(true))
                        .to("csvtoxml://?encoding=" + encoding)
                        .to("mock:outWithHeaders");

                from("direct:testWithoutHeader")
                        .unmarshal(new CsvDataFormat().setDelimiter(';').setHeaderDisabled(true))
                        .to("csvtoxml://?encoding=" + encoding)
                        .to("mock:testWithoutHeader");
            }
        };
    }

    @Test
    void testCsvWithHeaders() throws SAXException {

        String csvWithHeader = "Voornaam;Achternaam;Leeftijd\nKoen;Castermans;21\nJaap;Aap;30";
        template.sendBody("direct:testWithHeaders", csvWithHeader);

        Exchange result = getMockEndpoint("mock:outWithHeaders").getExchanges().getFirst();

        String expected = getExpectedXml();
        String actual = result.getIn().getBody(String.class);

        XMLUnit.setIgnoreWhitespace(true);

        assertThat(actual).and(expected).areIdentical();

    }

    private String getExpectedXml() {
        return """
                <?xml version="1.0" encoding="UTF-8"?>
                <items>
                  <item>
                    <Voornaam>Koen</Voornaam>
                    <Achternaam>Castermans</Achternaam>
                    <Leeftijd>21</Leeftijd>
                  </item>
                  <item>
                    <Voornaam>Jaap</Voornaam>
                    <Achternaam>Aap</Achternaam>
                    <Leeftijd>30</Leeftijd>
                  </item>
                </items>""";
    }

}

