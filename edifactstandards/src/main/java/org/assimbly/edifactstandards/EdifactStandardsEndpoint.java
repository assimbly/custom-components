package org.assimbly.edifactstandards;

import org.apache.camel.Component;
import org.apache.camel.Processor;
import org.apache.camel.spi.UriEndpoint;
import org.apache.camel.spi.UriParam;
import org.apache.camel.support.ProcessorEndpoint;

@UriEndpoint(
        firstVersion = "",
        scheme = "edifact-standards",
        title = "Edifact Standards Component",
        syntax = "edifact-standards:type"
)
public class EdifactStandardsEndpoint extends ProcessorEndpoint {

    @UriParam
    private EdifactStandardsConfiguration configuration;
    private EdifactStandardsComponent component;

    public EdifactStandardsEndpoint(String uri, EdifactStandardsComponent component, EdifactStandardsConfiguration configuration) {
        super(uri, (Component) component);

        this.component = component;
        this.configuration = configuration;
    }

    @Override
    protected Processor createProcessor() throws Exception {
        return new EdifactStandardsProcessor(this);
    }

    public EdifactStandardsConfiguration getConfiguration() {
        return configuration;
    }

    @Override
    public Component getComponent() {
        return (Component) component;
    }
}
