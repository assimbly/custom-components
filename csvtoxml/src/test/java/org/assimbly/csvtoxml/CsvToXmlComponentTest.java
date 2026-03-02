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

public class CsvToXmlComponentTest extends CamelTestSupport {

    private final String csvWithoutHeader = "Koen;Castermans;21\nJaap;Aap;30";
    private final String csvWithHeader = "Voornaam;Achternaam;Leeftijd\nKoen;Castermans;21\nJaap;Aap;30";
    private final String csvWithHeaderIncludingInvalidCharacters = "xml1-.order   1num&mer;naam;prijs\n1;iPhone;800";
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
    public void testCsvWithHeaders() throws IOException, SAXException {
        template.sendBody("direct:testWithHeaders", csvWithHeader);

        Exchange result = getMockEndpoint("mock:outWithHeaders").getExchanges().get(0);

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
                    <Leeftijd>21</Leeftijd>
                    <Voornaam>Koen</Voornaam>
                    <Achternaam>Castermans</Achternaam>
                  </item>
                  <item>
                    <Leeftijd>30</Leeftijd>
                    <Voornaam>Jaap</Voornaam>
                    <Achternaam>Aap</Achternaam>
                  </item>
                </items>""";
    }

    private String getExpectedXmlWithoutHeaders() {
        return """
                <?xml version="1.0" encoding="UTF-8"?>
                <items>
                  <item>
                    <string>Koen</string>
                    <string>Castermans</string>
                    <string>21</string>
                  </item>
                  <item>
                    <string>Jaap</string>
                    <string>Aap</string>
                    <string>30</string>
                  </item>
                </items>""";
    }

    private String getExpectedXmlHeadersWithInvalidCharacters(){
        return """
                <?xml version="1.0" encoding="UTF-8"?>
                <items>
                  <item>
                    <naam>iPhone</naam>
                    <order1nummer>1</order1nummer>
                    <prijs>800</prijs>
                  </item>
                </items>""";
    }


}
