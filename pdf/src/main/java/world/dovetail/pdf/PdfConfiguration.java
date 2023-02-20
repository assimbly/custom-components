package world.dovetail.pdf;

import org.apache.camel.spi.Metadata;
import org.apache.camel.spi.UriParam;
import org.apache.camel.spi.UriParams;

@UriParams
public class PdfConfiguration {

    @UriParam
    @Metadata(required = true)
    private String url;

    public PdfConfiguration() { }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
