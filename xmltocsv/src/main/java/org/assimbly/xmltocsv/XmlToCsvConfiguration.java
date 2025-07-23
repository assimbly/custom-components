package org.assimbly.xmltocsv;

import org.apache.camel.spi.Metadata;
import org.apache.camel.spi.UriParam;
import org.apache.camel.spi.UriParams;
import org.assimbly.xmltocsv.domain.OrderHeaders;
import org.assimbly.xmltocsv.domain.QuoteFields;

@UriParams
public class XmlToCsvConfiguration {

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
    private String delimiter;

    @UriParam
    @Metadata(required = true)
    private String lineSeparator;

    @UriParam
    @Metadata(required = true)
    private OrderHeaders orderHeaders;

    @UriParam
    @Metadata(required = true)
    private QuoteFields quoteFields;

    @UriParam
    private String xPathExpression;

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

    public String getDelimiter() {
        return delimiter;
    }

    public void setDelimiter(String encodedDelimiter) {
        this.delimiter = encodedDelimiter;
    }

    public String getLineSeparator() {
        return lineSeparator;
    }

    public void setLineSeparator(String encodedLineSeparator) {
        this.lineSeparator = convertLineSeparator(encodedLineSeparator);
    }

    public OrderHeaders getOrderHeaders() {
        return orderHeaders;
    }

    public void setOrderHeaders(String id) {
        this.orderHeaders = OrderHeaders.valueOf(id.trim().toUpperCase());
    }

    public QuoteFields getQuoteFields() {
        return quoteFields;
    }

    public void setQuoteFields(String id) {
        this.quoteFields = QuoteFields.valueOf(id.trim().toUpperCase());
    }

    public String getXPathExpression() {
        return xPathExpression;
    }

    public void setXPathExpression(String xPathExpression) {
        this.xPathExpression = xPathExpression;
    }

    public String convertLineSeparator(String lineSeparator) {

        // Handle unknown input, e.g., throw an IllegalArgumentException
        return switch (lineSeparator.toLowerCase()) {
            case "linefeed" -> "\n";
            case "carriagereturn" -> "\r";
            case "endofline" -> "\r\n";
            case null, default -> throw new IllegalArgumentException("Unknown line separator: " + lineSeparator);
        };

    }

}
