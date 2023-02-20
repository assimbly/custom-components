package org.assimbly.csvtoxml;

import org.apache.camel.spi.Metadata;
import org.apache.camel.spi.UriParam;
import org.apache.camel.spi.UriParams;

@UriParams
public class CsvToXmlConfiguration {

    @UriParam
    @Metadata(required = true)
    private String encoding;

    public CsvToXmlConfiguration() {}

    /**
     * Charset to use when converting CSV to XML.
     */
    public void setEncoding(String encoding) {
        this.encoding = encoding;
    }

    public String getEncoding() {
        return encoding;
    }
}
