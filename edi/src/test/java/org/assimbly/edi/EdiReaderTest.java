package org.assimbly.edi;

import org.apache.camel.test.junit5.params.Test;
import org.junit.jupiter.api.BeforeEach;
import org.milyn.Smooks;

import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.StringReader;
import java.io.StringWriter;

import static org.xmlunit.assertj3.XmlAssert.assertThat;

public class EdiReaderTest {

    public static final String SEGMENT = "LB";
    public static final String FIELD = "~";
    public static final String COMPONENT = "^";
    public static final String SUB_COMPONENT = "!";

    private Smooks smooks;
    private EdiReaderConfigurator config;

    @BeforeEach
    public void setUp() {
        smooks = new Smooks();
        config = new EdiReaderConfigurator(SEGMENT, FIELD, COMPONENT, SUB_COMPONENT);
        smooks.setReaderConfig(config);
    }

    @Test
    public void listsDelimitersUsed() throws Exception {
        String expected = "<edi-message>" +
                "<delimiters segment=\"LB\" field=\"~\" component=\"^\" sub-component=\"!\"/>" +
                "</edi-message>";

        String actual = processEdi("");
        
        assertThat(actual).and(expected).areIdentical();
    }

    @Test
    public void acceptsNewlineAsSegmentDelimiter() throws Exception {
        String expected = "<edi-message>" +
                "<delimiters segment=\"LB\" field=\"~\" component=\"^\" sub-component=\"!\"/>" +
                "<A/>" +
                "<B/>" +
                "</edi-message>";

        String actual = processEdi("A\nB");

        assertThat(actual).and(expected).areIdentical();
    }

    @Test
    public void acceptsOtherCharactersAsSegmentDelimiter() throws Exception {
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
    public void breaksDownSegmentIntoFieldsAndUses1stFieldAsHeader() throws Exception {
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
    public void supportsMultipleLinesWithSameHeader() throws Exception {
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
    public void breaksDownFieldsIntoComponents() throws Exception {
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
    public void breaksDownComponentsIntoSubComponents() throws Exception {
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
