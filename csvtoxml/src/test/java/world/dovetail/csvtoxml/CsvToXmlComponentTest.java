package world.dovetail.csvtoxml;

import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.dataformat.csv.CsvDataFormat;
import org.custommonkey.xmlunit.XMLUnit;
import org.apache.camel.test.junit5.CamelTestSupport;
import org.junit.jupiter.api.Test;

import org.xml.sax.SAXException;

import java.io.IOException;

import static org.custommonkey.xmlunit.XMLAssert.assertXMLEqual;

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
        assertXMLEqual(expected,actual);

    }



    /*
    @Test
    public void testCsvWithoutHeaders() throws IOException, SAXException {
        template.sendBody("direct:testWithoutHeader", csvWithoutHeader);

        Exchange result = getMockEndpoint("mock:testWithoutHeader").getExchanges().get(0);

        String expected = getExpectedXmlWithoutHeaders();
        String actual = result.getIn().getBody(String.class);

        XMLUnit.setIgnoreWhitespace(true);
        assertXMLEqual(expected,actual);

    }

    @Test
    public void testCsvWithHeadersIncludingInvalidCharacters() throws IOException, SAXException {
        template.sendBody("direct:testWithHeaders", csvWithHeaderIncludingInvalidCharacters);

        Exchange result = getMockEndpoint("mock:outWithHeaders").getExchanges().get(0);

        String expected = getExpectedXmlHeadersWithInvalidCharacters();
        String actual = result.getIn().getBody(String.class);

        XMLUnit.setIgnoreWhitespace(true);
        assertXMLEqual(expected,actual);

    }

     */

    private String getExpectedXml() {
        return "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<items>\n" +
                "  <item>\n" +
                "    <Leeftijd>21</Leeftijd>\n" +
                "    <Voornaam>Koen</Voornaam>\n" +
                "    <Achternaam>Castermans</Achternaam>\n" +
                "  </item>\n" +
                "  <item>\n" +
                "    <Leeftijd>30</Leeftijd>\n" +
                "    <Voornaam>Jaap</Voornaam>\n" +
                "    <Achternaam>Aap</Achternaam>\n" +
                "  </item>\n" +
                "</items>";
    }

    private String getExpectedXmlWithoutHeaders() {
        return "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<items>\n" +
                "  <item>\n" +
                "    <string>Koen</string>\n" +
                "    <string>Castermans</string>\n" +
                "    <string>21</string>\n" +
                "  </item>\n" +
                "  <item>\n" +
                "    <string>Jaap</string>\n" +
                "    <string>Aap</string>\n" +
                "    <string>30</string>\n" +
                "  </item>\n" +
                "</items>";
    }

    private String getExpectedXmlHeadersWithInvalidCharacters(){
        return "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<items>\n" +
                "  <item>\n" +
                "    <naam>iPhone</naam>\n" +
                "    <order1nummer>1</order1nummer>\n" +
                "    <prijs>800</prijs>\n" +
                "  </item>\n" +
                "</items>";
    }


}
