package world.dovetail.formtoxml;

import org.apache.camel.spi.Metadata;
import org.apache.camel.spi.UriParam;

public class FormToXmlConfiguration {

    @UriParam
    @Metadata(required = true)
    private String encoding;

    public FormToXmlConfiguration() {}

    /**
     * Charset to use when converting Form Data to XML.
     */
    public void setEncoding(String encoding) {
        this.encoding = encoding;
    }

    public String getEncoding() {
        return encoding;
    }

}
