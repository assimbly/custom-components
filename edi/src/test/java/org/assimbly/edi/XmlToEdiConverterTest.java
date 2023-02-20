package org.assimbly.edi;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class XmlToEdiConverterTest {

    private XmlToEdiConverter converter = new XmlToEdiConverter();

    @Test
    public void usesDelimitersSpecifiedInXml() throws Exception {
        String input = "<edi-message>" +
            "<delimiters segment=\"LB\" field=\"~\" component=\"^\" sub-component=\"!\"/>" +
            "<A/>" +
            "<B/>" +
            "</edi-message>";


        assertEquals("A\nB", convert(input));
    }

    @Test
    public void acceptsOtherCharactersAsSegmentDelimiter() throws Exception {
        String input = "<edi-message>" +
            "<delimiters segment=\"$\" field=\"~\" component=\"^\" sub-component=\"!\"/>" +
            "<A/>" +
            "<B/>" +
            "</edi-message>";

        assertEquals("A$B", convert(input));
    }

    @Test
    public void parsesFields() throws Exception {
        String input = "<edi-message>" +
            "<delimiters segment=\"LB\" field=\"~\" component=\"^\" sub-component=\"!\"/>" +
            "<A>" +
            "<field.1>B</field.1>" +
            "<field.2>C</field.2>" +
            "</A>" +
            "</edi-message>";

        assertEquals("A~B~C", convert(input));
    }

    @Test
    public void ignoresNonSignificantWhitespaceAndLineBreaks() throws Exception {
        String input = "<edi-message>" +
            "<delimiters segment=\"LB\" field=\"~\" component=\"^\" sub-component=\"!\"/>" +
            "<A>" +
            "\n\n\n\n\n\n\n       <field.1>B</field.1>" +   // non-relevant whitespace
            "\n\n\n\n\n\n\n       <field.2>C</field.2>" +   // and linebreaks
            "</A>" +
            "</edi-message>";

        assertEquals("A~B~C", convert(input));
    }

    @Test
    public void supportsMultipleLinesWithSameHeader() throws Exception {
        String input = "<edi-message>" +
            "<delimiters segment=\"LB\" field=\"~\" component=\"^\" sub-component=\"!\"/>" +
            "<A/>" +
            "<A>" +
            "<field.1>B</field.1>" +
            "</A>" +
            "</edi-message>";

        assertEquals("A\nA~B", convert(input));
    }

    @Test
    public void parsesComponents() throws Exception {
        String input = "<edi-message>" +
            "<delimiters segment=\"LB\" field=\"~\" component=\"^\" sub-component=\"!\"/>" +
            "<A>" +
            "<field.1>" +
            "<component.1>A 1</component.1>" +
            "<component.2>A 2</component.2>" +
            "</field.1>" +
            "</A>" +
            "</edi-message>";

        assertEquals("A~A 1^A 2", convert(input));
    }

    @Test
    public void parsesSubcomponents() throws Exception {
        String input = "<edi-message>" +
            "<delimiters segment=\"LB\" field=\"~\" component=\"^\" sub-component=\"!\"/>" +
            "<A>" +
            "<field.1>" +
            "<component.1>" +
            "<sub-component.1>A 11</sub-component.1>" +
            "<sub-component.2>A 12</sub-component.2>" +
            "</component.1>" +
            "<component.2>A 2</component.2>" +
            "</field.1>" +
            "</A>" +
            "</edi-message>";

        assertEquals("A~A 11!A 12^A 2", convert(input));
    }

    private String convert(String input) {
        InputStream stream = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
        return converter.convert(stream);
    }
}
