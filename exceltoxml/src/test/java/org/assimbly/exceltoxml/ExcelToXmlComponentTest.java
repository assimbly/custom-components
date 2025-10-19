package org.assimbly.exceltoxml;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.custommonkey.xmlunit.XMLUnit;
import org.apache.camel.test.junit5.CamelTestSupport;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.assimbly.exceltoxml.domain.ExcelRule;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

import static org.custommonkey.xmlunit.XMLAssert.assertXMLEqual;

public class ExcelToXmlComponentTest extends CamelTestSupport {

    private static final ExcelRule simpleData = new ExcelRule("Simple", "A1:D13", false, false, false, "simple data");
    private static final ExcelRule useHeaderRow = new ExcelRule("Smaller", "A1:B3", false, true, false, "simple data");
    private static final ExcelRule transposesData = new ExcelRule("Transposed", "A1:B3", true, false, false,"simple data");
    private static final ExcelRule useHeaderRowAndTransposesData = new ExcelRule("Transposed", "A1:B3", true, true, false,"simple data");
    private static final ExcelRule invalidHeaderNames = new ExcelRule("InvalidHeaders", "B2:C5", false, true, false,"simple data");
    private static final ExcelRule withFormulas = new ExcelRule("Formulas", "A1:D13", false, false, false, "with formulas");
    private static final ExcelRule withEmptyCells = new ExcelRule("EmptyCells", "A1:E13", false, false, false, "with empty cells");
    private static final ExcelRule multipleRanges1 = new ExcelRule("Range1", "A1:D13", false, false, false, "multiple ranges");
    private static final ExcelRule multipleRanges2 = new ExcelRule("Range2", "F4:G7", false, false, false, "multiple ranges");
    private static final ExcelRule emptySheet = new ExcelRule("EmptySheet", "A1:E13", false, false, false, "empty sheet");
    private static final ExcelRule invalidChars = new ExcelRule("InvalidChars", "A1:E13", false, false, true, "invalid chars");

    private final Map<String, List<ExcelRule>> allRoutes = new HashMap<String, List<ExcelRule>>() {{
            put("simpleData", Collections.singletonList(simpleData));
            put("useHeaderRow", Collections.singletonList(useHeaderRow));
            put("transposesData", Collections.singletonList(transposesData));
            put("useHeaderRowAndTransposesData", Collections.singletonList(useHeaderRowAndTransposesData));
            put("invalidHeaderNames", Collections.singletonList(invalidHeaderNames));
            put("withFormulas", Collections.singletonList(withFormulas));
            put("withEmptyCells", Collections.singletonList(withEmptyCells));
            put("multipleRanges", Arrays.asList(multipleRanges1, multipleRanges2));
            put("emptySheet", Collections.singletonList(emptySheet));
            put("invalidChars", Collections.singletonList(invalidChars));
        }};

    private InputStream input;

    @BeforeEach
    public void before() throws Exception {
        input = new FileInputStream("src/test/resources/spreadsheet.xlsx");
    }

    @Override
    protected RouteBuilder[] createRouteBuilders() {
        List<RouteBuilder> routeBuilders = new ArrayList<>();

        for (String route : allRoutes.keySet()) {
            routeBuilders.add(
                new RouteBuilder() {
                    public void configure() throws JsonProcessingException {
                        from("direct:" + route)
                            .to(createUri(allRoutes.get(route)))
                            .to("mock:result");
                    }
                }
            );
        }

        return routeBuilders.toArray(new RouteBuilder[0]);
    }

    @Test
    public void supports_converting_simple_well_formatted_data() throws Exception {
        runTest("simpleData");
    }

    @Test
    public void optionally_use_first_row_of_data_to_name_xml_elements() throws Exception {
        runTest("useHeaderRow");
    }

    @Test
    public void supports_transposing_data_from_a_range() throws Exception {
        runTest("transposesData");
    }

    @Test
    public void supports_transposing_data_while_using_header_row_from_a_range() throws Exception {
        runTest("useHeaderRowAndTransposesData");
    }

    @Test
    public void supports_evaluating_formulas() throws Exception {
        runTest("withFormulas");
    }

    @Test
    public void ignores_empty_cells_in_the_specified_range() throws Exception {
        runTest("withEmptyCells");
    }

    @Test
    public void supports_converting_multiple_ranges_within_the_same_workbook() throws Exception {
        runTest("multipleRanges");
    }

    @Test
    public void will_continue_gracefully_if_the_sheet_is_empty() throws Exception {
        runTest("emptySheet");
    }

    @Test
    public void escapes_invalid_xml() throws Exception {
        runTest("invalidChars");
    }

    @Test
    public void fixes_invalid_xml_in_header_names() throws Exception {
        runTest("invalidHeaderNames");
    }

    private void runTest(String rule) throws Exception {
        template.sendBody("direct:" + rule, input);
        Exchange result = getMockEndpoint("mock:result").getExchanges().get(0);
        String actual = result.getIn().getBody(String.class);

        String expected = readFile("src/test/resources/" + rule + ".xml", Charset.defaultCharset());

        XMLUnit.setIgnoreWhitespace(true);
        assertXMLEqual(expected,actual);

    }

    private String readFile(String path, Charset encoding) throws IOException {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded, encoding);
    }

    private String createUri(List<ExcelRule> rules) {
        return "exceltoxml://?rules=RAW(" + rulesToJson(rules) + ")";
    }

    private String rulesToJson(List<ExcelRule> rules) {

        ObjectMapper objectMapper = new ObjectMapper();

        try {
            String jsonArrayString = objectMapper.writeValueAsString(rules);
            return Base64.getEncoder().encodeToString(jsonArrayString.getBytes());
        } catch (com.fasterxml.jackson.core.JsonProcessingException e) {
            throw new RuntimeException("Error serializing rules to JSON", e);
        }

    }

}