package org.assimbly.xmltoexcel;

import com.google.gson.Gson;
import org.apache.camel.EndpointInject;
import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.commons.text.StringEscapeUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.assimbly.util.helper.Base64Helper;
import org.junit.jupiter.api.BeforeAll;
import org.apache.camel.test.junit5.CamelTestSupport;
import org.junit.jupiter.api.Test;
import org.assimbly.xmltoexcel.domain.CustomWorksheet;
import org.assimbly.xmltoexcel.helpers.AssertExcel;
import org.assimbly.xmltoexcel.helpers.DataProvider;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class XmlToExcelComponentTest extends CamelTestSupport {

    private static final String STANDARD_SETTINGS_ROUTE = "standardSettings";
    private static final String INDEX_COLUMN_ON_ROUTE = "indexColumnOn";
    private static final String INDEX_COLUMN_OFF_ROUTE = "indexColumnOff";
    private static final String INCLUDE_HEADER_ON_ROUTE = "includeHeaderOn";
    private static final String INCLUDE_HEADER_OFF_ROUTE = "includeHeaderOff";
    private static final String CUSTOM_INDEX_COLUMN_NAME_ROUTE = "customIndexColumnName";
    private static final String ORDERING_ASCENDING_ROUTE = "orderingAscending";
    private static final String ORDERING_DESCENDING_ROUTE = "orderingDescending";
    private static final String ORDERING_UNORDERED_ROUTE = "orderingUnordered";
    private static final String XLS_FORMAT_ROUTE = "xlsFormat";
    private static final String CUSTOM_SHEETS_FOR_STANDARD_SETTINGS_ROUTE = "customSheetsForStandardSettings";
    private static final String CUSTOM_SHEETS_EXAMPLE_USE_CASE_ROUTE = "customSheetsUseCase";

    private static final String STANDARD_XML_FILE_NAME = "standard.xml";
    private static Map<String, XmlToExcelConfiguration> routes;

    @BeforeAll
    public static void setup() {
        routes = Collections.unmodifiableMap(new HashMap<String, XmlToExcelConfiguration>() {{
            put(STANDARD_SETTINGS_ROUTE, DataProvider.getStandardConfig());
            put(INDEX_COLUMN_ON_ROUTE, DataProvider.getIndexColumnOnConfig());
            put(INDEX_COLUMN_OFF_ROUTE, DataProvider.getIndexColumnOffConfig());
            put(INCLUDE_HEADER_ON_ROUTE, DataProvider.getIncludeHeaderOnConfig());
            put(INCLUDE_HEADER_OFF_ROUTE, DataProvider.getIncludeHeaderOffConfig());
            put(CUSTOM_INDEX_COLUMN_NAME_ROUTE, DataProvider.getCustomIndexColumnNameConfig());
            put(ORDERING_ASCENDING_ROUTE, DataProvider.getOrderingAscendingConfig());
            put(ORDERING_DESCENDING_ROUTE, DataProvider.getOrderingDescendingConfig());
            put(ORDERING_UNORDERED_ROUTE, DataProvider.getOrderingUnorderedConfig());
            put(XLS_FORMAT_ROUTE, DataProvider.getXLSFormatConfig());
            put(CUSTOM_SHEETS_FOR_STANDARD_SETTINGS_ROUTE, DataProvider.getCustomSheetsForStandardSettingsConfig());
            put(CUSTOM_SHEETS_EXAMPLE_USE_CASE_ROUTE, DataProvider.getCustomSheetsExampleUseCaseConfig());
        }});
    }

    @EndpointInject("mock:result")
    protected MockEndpoint resultEndpoint;

    @Test
    public void testStandardSettings() throws Exception {
        testTransformation(STANDARD_XML_FILE_NAME, "standardSettings.xlsx", STANDARD_SETTINGS_ROUTE);
    }

    @Test
    public void testStandardDepth() throws Exception {
        testTransformation("depth.xml", "standardDepth.xlsx", STANDARD_SETTINGS_ROUTE);
    }

    @Test
    public void testDepthWithDoubleTags() throws Exception {
        testTransformation("depthWithDoubleTags.xml", "depthWithDoubleTags.xlsx", STANDARD_SETTINGS_ROUTE);
    }

    @Test
    public void testDepthWithShuffledTags() throws Exception {
        testTransformation("depthWithShuffledTags.xml", "depthWithShuffledTags.xlsx", STANDARD_SETTINGS_ROUTE);
    }

    @Test
    public void testDepthWithSixLayers() throws Exception {
        testTransformation("depthWithSixLayers.xml", "depthWithSixLayers.xlsx", STANDARD_SETTINGS_ROUTE);
    }

    @Test
    public void testIndexColumnOn() throws Exception {
        testTransformation(STANDARD_XML_FILE_NAME, "indexColumnOn.xlsx", INDEX_COLUMN_ON_ROUTE);
    }

    @Test
    public void testIndexColumnOff() throws Exception {
        testTransformation(STANDARD_XML_FILE_NAME, "indexColumnOff.xlsx", INDEX_COLUMN_OFF_ROUTE);
    }

    @Test
    public void testIncludeHeaderOn() throws Exception {
        testTransformation(STANDARD_XML_FILE_NAME, "includeHeaderOn.xlsx", INCLUDE_HEADER_ON_ROUTE);
    }

    @Test
    public void testIncludeHeaderOff() throws Exception {
        testTransformation(STANDARD_XML_FILE_NAME, "includeHeaderOff.xlsx", INCLUDE_HEADER_OFF_ROUTE);
    }

    @Test
    public void testCustomIndexColumnName() throws Exception {
        testTransformation(STANDARD_XML_FILE_NAME, "customIndexColumnName.xlsx", CUSTOM_INDEX_COLUMN_NAME_ROUTE);
    }

    @Test
    public void testOrderingAscending() throws Exception {
        testTransformation(STANDARD_XML_FILE_NAME, "orderingAscending.xlsx", ORDERING_ASCENDING_ROUTE);
    }

    @Test
    public void testOrderingDescending() throws Exception {
        testTransformation(STANDARD_XML_FILE_NAME, "orderingDescending.xlsx", ORDERING_DESCENDING_ROUTE);
    }

    @Test
    public void testOrderingUnordered() throws Exception {
        testTransformation(STANDARD_XML_FILE_NAME, "orderingUnordered.xlsx", ORDERING_UNORDERED_ROUTE);
    }

    @Test
    public void testXLSFormat() throws Exception {
        testTransformation(STANDARD_XML_FILE_NAME, "xlsFormatWithStandardSettings.xls", XLS_FORMAT_ROUTE);
    }

    @Test
    public void testCustomWorksheetsForStandardSettings() throws Exception {
        testTransformation(STANDARD_XML_FILE_NAME, "customSheetsForStandardSettings.xlsx", CUSTOM_SHEETS_FOR_STANDARD_SETTINGS_ROUTE);
    }

    @Test
    public void testCustomWorksheetsExampleUseCase() throws Exception {
        testTransformation("customWorksheets.xml", "customSheetsExampleUseCase.xlsx", CUSTOM_SHEETS_EXAMPLE_USE_CASE_ROUTE);
    }

    @Override
    protected RouteBuilder[] createRouteBuilders() {
        RouteBuilder[] routeBuilders = new RouteBuilder[routes.size()];
        String[] stringRoutes = routes.keySet().toArray(new String[0]);

        for (int i = 0; i < routes.size(); i++) {
            String route = stringRoutes[i];
            routeBuilders[i] = new RouteBuilder() {
                @Override
                public void configure() {
                    from("direct:" + route)
                            .to(createUri(routes.get(route)))
                            .to("mock:result");
                }
            };
        }

        return routeBuilders;
    }

    private void testTransformation(String inputFileName, String expectedOutputFileName, String route) throws Exception {
        String inputPath = "src/test/resources/input/" + inputFileName;
        String expectedOutputPath = "src/test/resources/expected-output/" + expectedOutputFileName;
        String actualOutputPath = "src/test/resources/actual-output/" + expectedOutputFileName;

        String input = new String(Files.readAllBytes(Paths.get(inputPath)));
        template.sendBody("direct:" + route, input);
        byte[] actualOutputBytes = getLastExchange(resultEndpoint).getIn().getBody(byte[].class);
        Files.write(Paths.get(actualOutputPath), actualOutputBytes);

        Workbook actualOutput = getWorkbook(expectedOutputFileName, actualOutputPath);
        Workbook expectedOutput = getWorkbook(expectedOutputFileName, expectedOutputPath);
        AssertExcel.assertWorkbooksAreEqual(actualOutput, expectedOutput);
    }

    private String createUri(XmlToExcelConfiguration config) {
        String uri = "xmltoexcel://?includeHeader=" + config.hasHeader() +
                "&includeIndexColumn=" + config.hasIndexColumn() +
                "&indexColumnName=" + config.getIndexColumnName() +
                "&orderHeaders=" + config.getOrderHeaders() +
                "&excelFormat=" + config.getExcelFormat();

        List<CustomWorksheet> worksheets = config.getWorksheets();
        if (worksheets != null && !worksheets.isEmpty()) {
            uri += "&worksheets=RAW(" + worksheetsToEncodedJson(worksheets) + ")";
        }

        return uri;
    }

    private Workbook getWorkbook(String outputFileName, String outputPath) throws IOException {
        FileInputStream outputFile = new FileInputStream(outputPath);
        if (outputFileName.endsWith(".xls")) {
            return new HSSFWorkbook(outputFile);
        }
        else {
            return new XSSFWorkbook(outputFile);
        }
    }

    private String worksheetsToEncodedJson(List<CustomWorksheet> worksheets) {
        List<String> jsonWorksheets = new ArrayList<>();
        Gson gson = new Gson();

        for (CustomWorksheet worksheet : worksheets) {
            jsonWorksheets.add('"' + StringEscapeUtils.escapeJava(gson.toJson(worksheet)) + '"');
        }

        return Base64Helper.marshal(jsonWorksheets.toString());
    }

    private Exchange getLastExchange(MockEndpoint endpoint) {
        int size = endpoint.getReceivedExchanges().size();
        return endpoint.getReceivedExchanges().get(size -1);
    }
}
