package org.assimbly.csvtoxml;

import org.apache.camel.spi.Metadata;
import org.apache.camel.spi.UriParam;
import org.apache.camel.spi.UriParams;

@UriParams
public class CsvToXmlConfiguration {

    @UriParam
    @Metadata(required = true)
    private String encoding;

    @UriParam(defaultValue = "false")
    private boolean useHeaders;

    public CsvToXmlConfiguration() {
        // used for serialization
    }

    /**
     * Charset to use when converting CSV to XML.
     */
    public void setEncoding(String encoding) {
        this.encoding = encoding;
    }

    public String getEncoding() {
        return encoding;
    }

    /**
     * Whether the CSV input has a header line. When true and the body has no
     * data rows, the processor still emits a single &lt;item&gt; element with
     * empty child elements named after the header columns (if the header is
     * known), or a self-closing &lt;items/&gt; if not.
     */
    public void setUseHeaders(boolean useHeaders) {
        this.useHeaders = useHeaders;
    }

    public boolean isUseHeaders() {
        return useHeaders;
    }

}