package org.assimbly.edifactdotweb;

import org.apache.camel.Processor;
import org.apache.camel.support.ProcessorEndpoint;
import org.apache.camel.spi.UriEndpoint;
import org.apache.camel.spi.UriParam;

@UriEndpoint(
        firstVersion = "",
        scheme = "edifact-dotweb",
        title = "Edifact Dotweb Component",
        syntax = "edifact-dotweb:type"
)
public class EdifactDotwebEndpoint extends ProcessorEndpoint {

    @UriParam
    private EdifactDotwebConfiguration configuration;
    private EdifactDotwebComponent component;

    public EdifactDotwebEndpoint(String uri, EdifactDotwebComponent component, EdifactDotwebConfiguration configuration) {
        super(uri, component);

        this.component = component;
        this.configuration = configuration;
    }

    @Override
    protected Processor createProcessor() throws Exception {
        return new EdifactDotwebProcessor(this);
    }

    public EdifactDotwebConfiguration getConfiguration() {
        return configuration;
    }

    @Override
    public EdifactDotwebComponent getComponent() {
        return component;
    }
}
