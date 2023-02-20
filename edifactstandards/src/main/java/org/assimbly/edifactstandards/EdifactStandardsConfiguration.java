package org.assimbly.edifactstandards;

import org.apache.camel.spi.Metadata;
import org.apache.camel.spi.UriParams;
import org.apache.camel.spi.UriPath;
import org.assimbly.edifactstandards.domain.Type;

@UriParams
public class EdifactStandardsConfiguration {

    @UriPath
    @Metadata(required = true)
    private String type;

    public EdifactStandardsConfiguration() {}

    public void setType(String type) {
        this.type = type;
    }

    public Type getType() {
        return Type.valueOf(type);
    }
}
