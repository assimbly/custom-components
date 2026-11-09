package org.assimbly.edi;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class XmlToEdiConverterTest {

    private XmlToEdiConverter converter = new XmlToEdiConverter();

    @Test
    void usesDelimitersSpecifiedInXml() {
        String input = "<edi-message>" +
            "<delimiters segment=\"LB\" field=\"~\" component=\"^\" sub-component=\"!\"/>" +
            "<A/>" +
            "<B/>" +
            "</edi-message>";


        assertEquals("A\nB", convert(input));
    }

    @Test
    void acceptsOtherCharactersAsSegmentDelimiter() {
        String input = "<edi-message>" +
            "<delimiters segment=\"$\" field=\"~\" component=\"^\" sub-component=\"!\"/>" +
            "<A/>" +
            "<B/>" +
            "</edi-message>";

        assertEquals("A$B", convert(input));
    }

    @Test
    void parsesFields() {
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
    void ignoresNonSignificantWhitespaceAndLineBreaks() {
        // non-relevant whitespace
        // and linebreaks
        String input = """
                <edi-message>\
                <delimiters segment="LB" field="~" component="^" sub-component="!"/>\
                <A>\
                
                
                
                
                
                
                
                       <field.1>B</field.1>\
                
                
                
                
                
                
                
                       <field.2>C</field.2>\
                </A>\
                </edi-message>""";

        assertEquals("A~B~C", convert(input));
    }

    @Test
    void supportsMultipleLinesWithSameHeader() {
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
    void parsesComponents() {
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
    void parsesSubcomponents() {
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
