package org.assimbly.edi;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.milyn.Smooks;

import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.StringReader;
import java.io.StringWriter;

import static org.xmlunit.assertj3.XmlAssert.assertThat;

class EdiReaderTest {

    public static final String SEGMENT = "LB";
    public static final String FIELD = "~";
    public static final String COMPONENT = "^";
    public static final String SUB_COMPONENT = "!";

    private Smooks smooks;
    private EdiReaderConfigurator config;

    @BeforeEach
    void setUp() {
        smooks = new Smooks();
        config = new EdiReaderConfigurator(SEGMENT, FIELD, COMPONENT, SUB_COMPONENT);
        smooks.setReaderConfig(config);
    }

    @Test
    void listsDelimitersUsed() {
        String expected = "<edi-message>" +
                "<delimiters segment=\"LB\" field=\"~\" component=\"^\" sub-component=\"!\"/>" +
                "</edi-message>";

        String actual = processEdi("");
        
        assertThat(actual).and(expected).areIdentical();
    }

    @Test
    void acceptsNewlineAsSegmentDelimiter() {
        String expected = "<edi-message>" +
                "<delimiters segment=\"LB\" field=\"~\" component=\"^\" sub-component=\"!\"/>" +
                "<A/>" +
                "<B/>" +
                "</edi-message>";

        String actual = processEdi("A\nB");

        assertThat(actual).and(expected).areIdentical();
    }

    @Test
    void acceptsOtherCharactersAsSegmentDelimiter() {
        smooks = new Smooks();
        config = new EdiReaderConfigurator("$", FIELD, COMPONENT, SUB_COMPONENT);
        smooks.setReaderConfig(config);

        String expected = "<edi-message>" +
                "<delimiters segment=\"$\" field=\"~\" component=\"^\" sub-component=\"!\"/>" +
                "<A/>" +
                "<B/>" +
                "</edi-message>";


        String actual = processEdi("A$B");

        assertThat(actual).and(expected).areIdentical();
        
    }

    @Test
    void breaksDownSegmentIntoFieldsAndUses1stFieldAsHeader() {
        String expected = "<edi-message>" +
                "<delimiters segment=\"LB\" field=\"~\" component=\"^\" sub-component=\"!\"/>" +
                "<A>" +
                "<field.1>B</field.1>" +
                "<field.2>C</field.2>" +
                "</A>" +
                "</edi-message>";

        String actual = processEdi("A~B~C");

        assertThat(actual).and(expected).areIdentical();
    }

    @Test
    void supportsMultipleLinesWithSameHeader() {
        String expected = "<edi-message>" +
                "<delimiters segment=\"LB\" field=\"~\" component=\"^\" sub-component=\"!\"/>" +
                "<A/>" +
                "<A>" +
                "<field.1>B</field.1>" +
                "</A>" +
                "</edi-message>";

        String actual = processEdi("A\nA~B");

        assertThat(actual).and(expected).areIdentical();

    }

    @Test
    void breaksDownFieldsIntoComponents() {
        String expected = "<edi-message>" +
                "<delimiters segment=\"LB\" field=\"~\" component=\"^\" sub-component=\"!\"/>" +
                "<A>" +
                "<field.1>" +
                "<component.1>A 1</component.1>" +
                "<component.2>A 2</component.2>" +
                "</field.1>" +
                "</A>" +
                "</edi-message>";

        final String actual = processEdi("A~A 1^A 2");

        assertThat(actual).and(expected).areIdentical();

    }

    @Test
    void breaksDownComponentsIntoSubComponents() {
        String expected = "<edi-message>" +
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

        String actual = processEdi("A~A 11!A 12^A 2");

        assertThat(actual).and(expected).areIdentical();


    }

    private String processEdi(String edi) {
        StringWriter xmlStr = new StringWriter();
        smooks.filterSource(new StreamSource(new StringReader(edi)), new StreamResult(xmlStr));

        return xmlStr.toString();
    }

}
