package org.assimbly.fmuta;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class FmutaFeedEnricherTest {
    private static final String BYTE_ORDER_MARK = "\uFEFF";
    private static final String LINE_NUMBER_HEADER = BYTE_ORDER_MARK + "Regelnr";
    private static final String DESCRIPTION_HEADER = "Omschrijving";
    private static final String DESCRIPTION_HEADER_FOR_HEADERS = "HeaderOmschrijving";
    private static final String DESCRIPTION_HEADER_FOR_LINES = "RegelOmschrijving";
    private static final String AMOUNT_HEADER = "Bedrag";
    private static final String VAT_AMOUNT_HEADER = "BTWBedrag";
    private static final String INCL_EXCL_HEADER = "Incl_Excl";

    private FmutaFeedEnricher enricher = new FmutaFeedEnricher('.');

    private List<Map<String, Object>> minimalFeed(int numberOfLines) {
        List<Map<String, Object>> result = new ArrayList<>(numberOfLines);
        for (int i = 0; i < numberOfLines; ++i) {
            Map<String, Object> line = new HashMap<>();
            line.put(LINE_NUMBER_HEADER, "");
            line.put(DESCRIPTION_HEADER_FOR_HEADERS, "HeaderDescription");
            line.put(DESCRIPTION_HEADER_FOR_LINES, "LineDescription");
            line.put(AMOUNT_HEADER, "0,00");
            line.put(VAT_AMOUNT_HEADER, "0,00");
            line.put(INCL_EXCL_HEADER, "Incl");
            result.add(line);
        }
        return result;
    }

    @Test
    public void cloneAndRenumber() {
        List<Map<String, Object>> lines = minimalFeed(2);
        lines.get(0).put(LINE_NUMBER_HEADER, "1");
        lines.get(1).put(LINE_NUMBER_HEADER, "1");

        List<Map<String, Object>> output = enricher.enrich(lines);

        assertEquals(4, output.size());
        assertEquals("0", output.get(0).get(LINE_NUMBER_HEADER));
        assertEquals("1", output.get(1).get(LINE_NUMBER_HEADER));
        assertEquals("0", output.get(2).get(LINE_NUMBER_HEADER));
        assertEquals("1", output.get(3).get(LINE_NUMBER_HEADER));
    }

    @Test
    public void cloneIfRowNumberOneOnly() {
        List<Map<String, Object>> lines = minimalFeed(2);
        lines.get(0).put(LINE_NUMBER_HEADER, "1");
        lines.get(1).put(LINE_NUMBER_HEADER, "2");

        List<Map<String, Object>> output = enricher.enrich(lines);

        assertEquals(3, output.size());
        assertEquals("0", output.get(0).get(LINE_NUMBER_HEADER));
        assertEquals("1", output.get(1).get(LINE_NUMBER_HEADER));
        assertEquals("2", output.get(2).get(LINE_NUMBER_HEADER));
    }

    @Test
    public void dropAuxiliaryColumns() {
        List<Map<String, Object>> lines = minimalFeed(1);
        lines.get(0).put(LINE_NUMBER_HEADER, "1");

        List<Map<String, Object>> output = enricher.enrich(lines);

        assertEquals(2, output.size());
        assertNull(output.get(0).get(DESCRIPTION_HEADER_FOR_HEADERS));
        assertNull(output.get(1).get(DESCRIPTION_HEADER_FOR_LINES));
        assertNull(output.get(0).get(INCL_EXCL_HEADER));
        assertNull(output.get(1).get(INCL_EXCL_HEADER));
    }

    @Test
    public void splitDescriptions() {
        List<Map<String, Object>> lines = minimalFeed(1);
        Map<String, Object> line = lines.get(0);
        line.put(LINE_NUMBER_HEADER, "1");
        line.put(DESCRIPTION_HEADER_FOR_HEADERS, "Header");
        line.put(DESCRIPTION_HEADER_FOR_LINES, "Line");

        List<Map<String, Object>> output = enricher.enrich(lines);

        assertEquals(2, output.size());

        Map<String, Object> actualLine1 = output.get(0);
        Map<String, Object> actualLine2 = output.get(1);

        assertEquals("0",        actualLine1.get(LINE_NUMBER_HEADER));
        assertEquals("Header",   actualLine1.get(DESCRIPTION_HEADER));
        assertEquals("1",        actualLine2.get(LINE_NUMBER_HEADER));
        assertEquals("Line",     actualLine2.get(DESCRIPTION_HEADER));
    }

    @Test
    public void blankColumns() {
        List<Map<String, Object>> lines = minimalFeed(1);
        Map<String, Object> line = lines.get(0);
        line.put(LINE_NUMBER_HEADER,                "1");
        line.put(INCL_EXCL_HEADER,                  "Veld1");
        line.put("BoekstukNr",                      "Veld2");
        line.put("Tegenrekening",                   "Veld4");
        line.put("Factuurnr",                       "Veld5");
        line.put("Koers",                           "Veld6");
        line.put("Vervaldatum_Factuur",             "Veld7");
        line.put("Vervaldatum_Bedrag_Krediet_bep",  "Veld8");
        line.put("BTWCode",                         "Veld9");
        line.put(VAT_AMOUNT_HEADER,                 "0,00");
        line.put("Referentie",                      "Veld11");
        line.put("Betalingswijze",                  "Veld12");

        List<Map<String, Object>> output = enricher.enrich(lines);

        assertEquals(2, output.size());

        Map<String, Object> actualLine1 = output.get(0);
        Map<String, Object> actualLine2 = output.get(1);

        assertEquals("0",        actualLine1.get(LINE_NUMBER_HEADER));
        assertNull(actualLine1.get(INCL_EXCL_HEADER));
        assertEquals("Veld2",    actualLine1.get("BoekstukNr"));
        assertEquals("",         actualLine1.get("Tegenrekening"));
        assertEquals("",         actualLine1.get("Factuurnr"));
        assertEquals("",         actualLine1.get("Koers"));
        assertEquals("Veld7",    actualLine1.get("Vervaldatum_Factuur"));
        assertEquals("Veld8",    actualLine1.get("Vervaldatum_Bedrag_Krediet_bep"));
        assertEquals("",         actualLine1.get("BTWCode"));
        assertEquals("",         actualLine1.get(VAT_AMOUNT_HEADER));
        assertEquals("Veld11",   actualLine1.get("Referentie"));
        assertEquals("Veld12",   actualLine1.get("Betalingswijze"));

        assertEquals("1",        actualLine2.get(LINE_NUMBER_HEADER));
        assertNull(actualLine2.get(INCL_EXCL_HEADER));
        assertEquals("",         actualLine2.get("BoekstukNr"));
        assertEquals("Veld4",    actualLine2.get("Tegenrekening"));
        assertEquals("Veld5",    actualLine2.get("Factuurnr"));
        assertEquals("Veld6",    actualLine2.get("Koers"));
        assertEquals("",         actualLine2.get("Vervaldatum_Factuur"));
        assertEquals("",         actualLine2.get("Vervaldatum_Bedrag_Krediet_bep"));
        assertEquals("Veld9",    actualLine2.get("BTWCode"));
        assertEquals("0.00",     actualLine2.get(VAT_AMOUNT_HEADER));
        assertEquals("",         actualLine2.get("Referentie"));
        assertEquals("",         actualLine2.get("Betalingswijze"));
    }

    @Test
    public void addAmountsExcludingTax() {
        List<Map<String, Object>> lines = minimalFeed(3);
        lines.get(0).put(LINE_NUMBER_HEADER,    "1");
        lines.get(0).put(AMOUNT_HEADER,         "10,00");
        lines.get(0).put(INCL_EXCL_HEADER,      "Excl");
        lines.get(0).put(VAT_AMOUNT_HEADER,     "2,10");
        lines.get(1).put(LINE_NUMBER_HEADER,    "1");
        lines.get(1).put(AMOUNT_HEADER,         "10,00");
        lines.get(1).put(INCL_EXCL_HEADER,      "Excl");
        lines.get(1).put(VAT_AMOUNT_HEADER,     "2,10");
        lines.get(2).put(LINE_NUMBER_HEADER,    "2");
        lines.get(2).put(AMOUNT_HEADER,         "100,00");
        lines.get(2).put(INCL_EXCL_HEADER,      "Excl");
        lines.get(2).put(VAT_AMOUNT_HEADER,     "21,00");

        List<Map<String, Object>> output = enricher.enrich(lines);

        assertEquals(5,          output.size());
        assertEquals("12.10",    output.get(0).get(AMOUNT_HEADER));
        assertEquals("",         output.get(0).get(VAT_AMOUNT_HEADER));
        assertEquals("10.00",    output.get(1).get(AMOUNT_HEADER));
        assertEquals("2.10",     output.get(1).get(VAT_AMOUNT_HEADER));
        assertEquals("133.10",   output.get(2).get(AMOUNT_HEADER));
        assertEquals("",         output.get(2).get(VAT_AMOUNT_HEADER));
        assertEquals("10.00",    output.get(3).get(AMOUNT_HEADER));
        assertEquals("2.10",     output.get(3).get(VAT_AMOUNT_HEADER));
        assertEquals("100.00",   output.get(4).get(AMOUNT_HEADER));
        assertEquals("21.00",    output.get(4).get(VAT_AMOUNT_HEADER));
    }

    @Test
    public void addAmountsIncludingTax() {
        List<Map<String, Object>> lines = minimalFeed(3);
        lines.get(0).put(LINE_NUMBER_HEADER,    "1");
        lines.get(0).put(AMOUNT_HEADER,         "12,10");
        lines.get(0).put(INCL_EXCL_HEADER,      "Incl");
        lines.get(0).put(VAT_AMOUNT_HEADER,     "2,10");
        lines.get(1).put(LINE_NUMBER_HEADER,    "1");
        lines.get(1).put(AMOUNT_HEADER,         "12,10");
        lines.get(1).put(INCL_EXCL_HEADER,      "Incl");
        lines.get(1).put(VAT_AMOUNT_HEADER,     "2,10");
        lines.get(2).put(LINE_NUMBER_HEADER,    "2");
        lines.get(2).put(AMOUNT_HEADER,         "121,00");
        lines.get(2).put(INCL_EXCL_HEADER,      "Incl");
        lines.get(2).put(VAT_AMOUNT_HEADER,     "21,00");

        List<Map<String, Object>> output = enricher.enrich(lines);

        assertEquals(5,          output.size());
        assertEquals("12.10",    output.get(0).get(AMOUNT_HEADER));
        assertEquals("",         output.get(0).get(VAT_AMOUNT_HEADER));
        assertEquals("12.10",    output.get(1).get(AMOUNT_HEADER));
        assertEquals("2.10",     output.get(1).get(VAT_AMOUNT_HEADER));
        assertEquals("133.10",   output.get(2).get(AMOUNT_HEADER));
        assertEquals("",         output.get(2).get(VAT_AMOUNT_HEADER));
        assertEquals("12.10",    output.get(3).get(AMOUNT_HEADER));
        assertEquals("2.10",     output.get(3).get(VAT_AMOUNT_HEADER));
        assertEquals("121.00",   output.get(4).get(AMOUNT_HEADER));
        assertEquals("21.00",    output.get(4).get(VAT_AMOUNT_HEADER));
    }

    @Test
    public void addAmounts() {
        List<Map<String, Object>> lines = minimalFeed(4);
        lines.get(0).put(LINE_NUMBER_HEADER,    "1");
        lines.get(0).put(AMOUNT_HEADER,         "12,10");
        lines.get(0).put(INCL_EXCL_HEADER,      "Incl");
        lines.get(0).put(VAT_AMOUNT_HEADER,     "2,10");
        lines.get(1).put(LINE_NUMBER_HEADER,    "2");
        lines.get(1).put(AMOUNT_HEADER,         "20,00");
        lines.get(1).put(INCL_EXCL_HEADER,      "Excl");
        lines.get(1).put(VAT_AMOUNT_HEADER,     "4,20");
        lines.get(2).put(LINE_NUMBER_HEADER,    "1");
        lines.get(2).put(AMOUNT_HEADER,         "10,00");
        lines.get(2).put(INCL_EXCL_HEADER,      "Excl");
        lines.get(2).put(VAT_AMOUNT_HEADER,     "2,10");
        lines.get(3).put(LINE_NUMBER_HEADER,    "2");
        lines.get(3).put(AMOUNT_HEADER,         "12,10");
        lines.get(3).put(INCL_EXCL_HEADER,      "Incl");
        lines.get(3).put(VAT_AMOUNT_HEADER,     "2,10");

        List<Map<String, Object>> output = enricher.enrich(lines);

        assertEquals(6,          output.size());
        assertEquals("36.30",    output.get(0).get(AMOUNT_HEADER));
        assertEquals("",         output.get(0).get(VAT_AMOUNT_HEADER));
        assertEquals("12.10",    output.get(1).get(AMOUNT_HEADER));
        assertEquals("2.10",     output.get(1).get(VAT_AMOUNT_HEADER));
        assertEquals("20.00",    output.get(2).get(AMOUNT_HEADER));
        assertEquals("4.20",     output.get(2).get(VAT_AMOUNT_HEADER));
        assertEquals("24.20",    output.get(3).get(AMOUNT_HEADER));
        assertEquals("",         output.get(3).get(VAT_AMOUNT_HEADER));
        assertEquals("10.00",    output.get(4).get(AMOUNT_HEADER));
        assertEquals("2.10",     output.get(4).get(VAT_AMOUNT_HEADER));
        assertEquals("12.10",    output.get(5).get(AMOUNT_HEADER));
        assertEquals("2.10",     output.get(5).get(VAT_AMOUNT_HEADER));
    }
}
