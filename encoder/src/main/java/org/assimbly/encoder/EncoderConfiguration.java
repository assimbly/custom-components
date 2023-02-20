package org.assimbly.encoder;

import org.apache.camel.spi.Metadata;
import org.apache.camel.spi.UriParam;
import org.apache.camel.spi.UriParams;
import org.apache.camel.spi.UriPath;

@UriParams
public class EncoderConfiguration {

    @UriPath(name = "originCharset")
    @Metadata(required = true)
    private String originCharset;

    @UriParam
    @Metadata(required = true)
    private String targetCharset;

    public EncoderConfiguration() { }

    /**
     * Charset of the origin file.
     */
    public void setOriginCharset(String charset) {
        this.originCharset = charset;
    }

    /**
     * Charset of the target file.
     */
    public void setTargetCharset(String charset) {
        this.targetCharset= charset;
    }

    public String getOriginCharset() {
        return originCharset;
    }

    public String getTargetCharset() {
        return targetCharset;
    }
}
