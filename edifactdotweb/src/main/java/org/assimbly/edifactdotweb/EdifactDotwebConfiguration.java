package org.assimbly.edifactdotweb;

import org.apache.camel.spi.Metadata;
import org.apache.camel.spi.UriParams;
import org.apache.camel.spi.UriPath;
import org.assimbly.edifactdotweb.domain.Type;

@UriParams
public class EdifactDotwebConfiguration {

    @UriPath
    @Metadata(required = true)
    private String type;

    public EdifactDotwebConfiguration() {}

    public void setType(String type) {
        this.type = type;
    }

    public Type getType() {
        return Type.valueOf(type);
    }
}
