package org.assimbly.xmltoexcel;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.camel.spi.Metadata;
import org.apache.camel.spi.UriParam;
import org.apache.camel.spi.UriParams;
import org.assimbly.util.helper.Base64Helper;
import org.assimbly.xmltoexcel.domain.CustomWorksheet;
import org.assimbly.xmltoexcel.domain.ExcelFormat;
import org.assimbly.xmltoexcel.domain.OrderHeaders;
import org.assimbly.xmltoexcel.exception.XmlToExcelException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@UriParams
public class XmlToExcelConfiguration {

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
    private ExcelFormat excelFormat;

    @UriParam
    private List<CustomWorksheet> worksheets;

    public XmlToExcelConfiguration() { }

    public XmlToExcelConfiguration(boolean includeHeader, boolean includeIndexColumn, String indexColumnName,
                                   OrderHeaders orderHeaders, ExcelFormat excelFormat) {
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

    public void setOrderHeaders(String id) {
        this.orderHeaders = OrderHeaders.valueOf(id.trim().toUpperCase());
    }

    public void setOrderHeaders(OrderHeaders orderHeaders) {
        this.orderHeaders = orderHeaders;
    }

    public ExcelFormat getExcelFormat() {
        return excelFormat;
    }

    public void setExcelFormat(String id) {
        this.excelFormat = ExcelFormat.valueOf(id.trim().toUpperCase());
    }

    public void setExcelFormat(ExcelFormat excelFormat) {
        this.excelFormat = excelFormat;
    }

    public List<CustomWorksheet> getWorksheets() {
        return worksheets;
    }

    public void setWorksheets(List<CustomWorksheet> worksheets) {
        this.worksheets = worksheets;
    }

    public void setWorksheets(String worksheets) {
        String json = new String(Base64Helper.unmarshal(worksheets));
        this.worksheets = JsonToWorksheets(json);
    }

    public List<CustomWorksheet> JsonToWorksheets(String json) {
        ObjectMapper mapper = new ObjectMapper();
        List<CustomWorksheet> worksheets = new ArrayList<>();

        try {
            @SuppressWarnings("unchecked")
            List<String> worksheetsJson = mapper.readValue(json, List.class);

            for (String rule : worksheetsJson) {
                worksheets.add(mapper.readValue(rule, CustomWorksheet.class));
            }
        } catch (IOException e) {
            throw new XmlToExcelException("Unable to deserialize worksheets: " + e.getMessage());
        }

        return worksheets;
    }
}
