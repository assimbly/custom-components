package org.assimbly.xmltoexcel;

import org.apache.camel.spi.Metadata;
import org.apache.camel.spi.UriParam;
import org.apache.camel.spi.UriParams;
import org.assimbly.xmltoexcel.domain.CustomWorksheet;
import org.assimbly.xmltoexcel.domain.ExcelFormat;
import org.assimbly.xmltoexcel.domain.OrderHeaders;
import org.assimbly.xmltoexcel.exception.XmlToExcelException;
import tools.jackson.core.JacksonException;
import tools.jackson.core.type.TypeReference;
import tools.jackson.databind.ObjectMapper;
import tools.jackson.databind.json.JsonMapper;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.List;

@UriParams
public class XmlToExcelConfiguration {

    private static final ObjectMapper MAPPER = JsonMapper.builder().build();

    private static final TypeReference<List<CustomWorksheet>> WORKSHEET_LIST_TYPE =
            new TypeReference<>() {};
    private static final TypeReference<List<String>> STRING_LIST_TYPE =
            new TypeReference<>() {};

    @UriParam
    @Metadata(required = true)
    private boolean includeHeader;

    @UriParam
    @Metadata(required = true)
    private boolean includeIndexColumn;

    @UriParam
    @Metadata(required = true)
    private String indexColumnName;

    @UriParam
    @Metadata(required = true)
    private OrderHeaders orderHeaders;

    @UriParam
    @Metadata(required = true)
    private boolean useCustomWorksheets;

    @UriParam
    @Metadata(required = true)
    private ExcelFormat excelFormat;

    @UriParam
    private List<CustomWorksheet> worksheets;

    public XmlToExcelConfiguration() { }

    public XmlToExcelConfiguration(boolean includeHeader, boolean includeIndexColumn, String indexColumnName, OrderHeaders orderHeaders, ExcelFormat excelFormat) {
        this.includeHeader = includeHeader;
        this.includeIndexColumn = includeIndexColumn;
        this.indexColumnName = indexColumnName;
        this.orderHeaders = orderHeaders;
        this.excelFormat = excelFormat;
    }

    public boolean hasHeader() {
        return includeHeader;
    }

    public void setIncludeHeader(boolean includeHeader) {
        this.includeHeader = includeHeader;
    }

    public boolean hasIndexColumn() {
        return includeIndexColumn;
    }

    public void setIncludeIndexColumn(boolean includeIndexColumn) {
        this.includeIndexColumn = includeIndexColumn;
    }

    public String getIndexColumnName() {
        return indexColumnName;
    }

    public void setIndexColumnName(String indexColumnName) {
        this.indexColumnName = indexColumnName;
    }

    public OrderHeaders getOrderHeaders() {
        return orderHeaders;
    }

    public void setOrderHeaders(String orderHeaders) {
        this.orderHeaders = OrderHeaders.fromString(orderHeaders);
    }

    public ExcelFormat getExcelFormat() {
        return excelFormat;
    }

    public void setExcelFormat(String excelFormat) {
        this.excelFormat = ExcelFormat.fromString(excelFormat);
    }

    public void setUseCustomWorksheets(boolean useCustomWorksheets) {
        this.useCustomWorksheets = useCustomWorksheets;
    }

    public boolean getUseCustomWorksheets() {
        return useCustomWorksheets;
    }

    public List<CustomWorksheet> getWorksheets() {
        return worksheets;
    }

    public void setWorksheets(List<CustomWorksheet> worksheets) {
        this.worksheets = worksheets;
    }

    public void setWorksheets(String worksheets) {
        byte[] decoded = Base64.getDecoder().decode(worksheets);
        String json = new String(decoded, StandardCharsets.UTF_8);

        this.worksheets = jsonToWorksheets(json);
    }

    public List<CustomWorksheet> jsonToWorksheets(String json) {
        if (json == null || json.isBlank()) {
            return List.of();
        }

        try {
            return MAPPER.readValue(json, WORKSHEET_LIST_TYPE);
        } catch (JacksonException _) {
            // Fallback: handle a double-encoded array (each element is itself a JSON string)
            try {
                return MAPPER.readValue(json, STRING_LIST_TYPE).stream()
                        .map(s -> MAPPER.readValue(s, CustomWorksheet.class))
                        .toList();
            } catch (JacksonException e2) {
                throw new XmlToExcelException("Deserialization failed: " + e2.getMessage());
            }
        }
    }

}