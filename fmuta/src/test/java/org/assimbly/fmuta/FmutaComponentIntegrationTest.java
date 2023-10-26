package org.assimbly.fmuta;

import org.apache.camel.EndpointInject;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.dataformat.univocity.UniVocityCsvDataFormat;
import org.apache.camel.model.dataformat.UniVocityHeader;
import org.apache.camel.test.junit5.CamelTestSupport;
import org.junit.jupiter.api.Test;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FmutaComponentIntegrationTest extends CamelTestSupport {

    private String BYTE_ORDER_MARK = "\uFEFF";

    @EndpointInject("mock:out")
    private MockEndpoint resultEndpoint;

    @Override
    protected RouteBuilder createRouteBuilder() throws Exception {
        return new RouteBuilder() {
            @Override
            public void configure() throws Exception {
                UniVocityCsvDataFormat inputDataFormat = new UniVocityCsvDataFormat();

                char char1=';';

                inputDataFormat.setHeaderExtractionEnabled(true);
                inputDataFormat.setDelimiter(char1);
                inputDataFormat.setAsMap(true);

                UniVocityCsvDataFormat outputDataFormat = new UniVocityCsvDataFormat();
                String[] outputHeaders = getOutputHeaders();
                outputDataFormat.setHeaders(outputHeaders);
                outputDataFormat.setDelimiter(char1);
                outputDataFormat.setLineSeparator("\r\n");

                from("direct:in")
                        .unmarshal(inputDataFormat)
                        .to("fmuta:enrich?decimalSeparator=.")
                        .marshal(outputDataFormat)
                        .to("mock:out");
            }
        };
    }

    /**
     * For customers, the FMUTA component is a single component. Under the hood, this component consists of a
     * custom Camel component combined with an unmarshalling and a marshalling step. The order of the columns
     * in the output file is specified in the marshalling step.
     */
    private String[] getOutputHeaders() {
        List<String> headerNames = Arrays.asList("Regelnr", "DagboekType", "Dagboeknr", "Periode", "BoekJaar",
                "BoekstukNr", "Omschrijving", "Datum", "Tegenrekening", "Debnr", "Crednr", "Factuurnr", "Bedrag",
                "Journaliseren", "Valutacode", "Koers", "Krediet_bep", "Bedrag_Krediet_bep", "Vervaldatum_Factuur",
                "Vervaldatum_Bedrag_Krediet_bep", "BTWCode", "BTWBedrag", "Weeknr", "Referentie", "Betalingswijze",
                "BedragRekening", "Kostenplaats", "Kostendrager", "AantalKostendrager", "Verschilcode", "kolom30",
                "Stornoboeking");
        return headerNames.toArray(new String[0]);
    }

    private UniVocityHeader createHeader(String name) {
        UniVocityHeader header = new UniVocityHeader();
        header.setName(name);
        return header;
    }

    @Test
    public void canBeInstantiated() throws Exception {
        resultEndpoint.expectedMessageCount(1);
        template.sendBody("direct:in", BYTE_ORDER_MARK+"Regelnr;Bedrag;BTWBedrag;Incl_Excl\n1;0,00;0,00;Incl\n");
        resultEndpoint.assertIsSatisfied();
    }

    @Test
    public void runningTotal() throws Exception {
        resultEndpoint.expectedMessageCount(1);

        String input =
                BYTE_ORDER_MARK+"Regelnr;Datum;DagboekType;Dagboeknr;Periode;BoekJaar;BoekstukNr;HeaderOmschrijving;RegelOmschrijving;Tegenrekening;Debnr;Crednr;Factuurnr;Bedrag;Incl_Excl;Journaliseren;Valutacode;Koers;Krediet_bep;Bedrag_Krediet_bep;Vervaldatum_Factuur;Vervaldatum_Bedrag_Krediet_bep;BTWCode;BTWBedrag;Weeknr;Referentie;Betalingswijze;BedragRekening;Kostenplaats;Kostendrager;AantalKostendrager;Verschilcode;kolom30;Stornoboeking\n" +
                "1;12042016;V;;4;2016;29320160410;Omzet week 14;Omzet week 14;80555;293;;29320160410;107056,40;Excl;;EUR;1;;0;19042016;19042016;21;22481,85;14;Omzet;B;;;;;;;\n" +
                "2;12042016;V;;4;2016;29320160410;Omzet week 14;Omzet week 14;80555;293;;29320160410;33,63;Excl;;EUR;1;;0;19042016;19042016;6;2,02;14;Omzet;B;;;;;;;\n" +
                "1;12042016;V;;4;2016;19320160410;Omzet week 14;Omzet week 14;80555;193;;19320160410;43262,48;Excl;;EUR;1;;0;19042016;19042016;21;9085,12;14;Omzet;B;;;;;;;\n";

        template.sendBody("direct:in", input);
        resultEndpoint.assertIsSatisfied();

        String actual = resultEndpoint.getExchanges().get(0).getIn().getBody(String.class);

        String expected =
                "0;V;;4;2016;29320160410;Omzet week 14;12042016;;293;;;129573.90;;EUR;;;0;19042016;19042016;;;14;Omzet;B;;;;;;;\r\n" +
                "1;V;;4;2016;;Omzet week 14;12042016;80555;293;;29320160410;107056.40;;EUR;1;;0;;;21;22481.85;14;;;;;;;;;\r\n" +
                "2;V;;4;2016;;Omzet week 14;12042016;80555;293;;29320160410;33.63;;EUR;1;;0;;;6;2.02;14;;;;;;;;;\r\n" +
                "0;V;;4;2016;19320160410;Omzet week 14;12042016;;193;;;52347.60;;EUR;;;0;19042016;19042016;;;14;Omzet;B;;;;;;;\r\n" +
                "1;V;;4;2016;;Omzet week 14;12042016;80555;193;;19320160410;43262.48;;EUR;1;;0;;;21;9085.12;14;;;;;;;;;\r\n";

        /*
        String expected =
                        "2;V;;4;2016;;Omzet week 14;12042016;80555;293;;29320160410;33.63;;EUR;1;;0;;;6;2.02;14;;;;;;;;;\r\n" +
                        "0;V;;4;2016;19320160410;Omzet week 14;12042016;;193;;;52347.60;;EUR;;;0;19042016;19042016;;;14;Omzet;B;;;;;;;\r\n" +
                        "1;V;;4;2016;;Omzet week 14;12042016;80555;193;;19320160410;43262.48;;EUR;1;;0;;;21;9085.12;14;;;;;;;;;\r\n";
        */

        assertEquals(expected, actual);
    }


    @Test
    public void exampleFeedFromFile() throws Exception {
        resultEndpoint.expectedMessageCount(1);

        template.sendBody("direct:in", getClass().getResource("/FMUTAFeed-in.csv"));
        resultEndpoint.assertIsSatisfied();

        String actual = resultEndpoint.getExchanges().get(0).getIn().getBody(String.class);

        String expected = new String(getClass().getClassLoader().getResourceAsStream("FMUTAFeed-out.csv").readAllBytes());
        assertEquals(expected, actual);
    }



}
