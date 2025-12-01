package org.assimbly.xmltoexcel;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
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
        this.worksheets = jsonToWorksheets(worksheets);
    }

    public List<CustomWorksheet> jsonToWorksheets(String json) {

        ObjectMapper mapper = new ObjectMapper();
        List<CustomWorksheet> worksheetsList = new ArrayList<>();

        try {
            worksheetsList = mapper.readValue(
                    json,
                    new TypeReference<List<CustomWorksheet>>() {}
            );
        } catch (JsonProcessingException e) {
            throw new XmlToExcelException("Unable to deserialize worksheets: " + e.getMessage());
        }

        return worksheetsList;
    }

}
