package org.assimbly.globalvariables;

import org.apache.camel.Processor;
import org.apache.camel.spi.UriEndpoint;
import org.apache.camel.spi.UriParam;
import org.apache.camel.support.ProcessorEndpoint;

@UriEndpoint(
        firstVersion = "2.7.1",
        scheme = "globalvariables",
        title = "Global Environment Variables",
        syntax = "globalvariables:name")
public class GlobalVariablesEndpoint extends ProcessorEndpoint {

    @UriParam
    private GlobalVariablesConfiguration configuration;
    private GlobalVariablesComponent component;

    public GlobalVariablesEndpoint(String uri, GlobalVariablesComponent component, GlobalVariablesConfiguration configuration) {
        super(uri, component);

        this.component = component;
        this.configuration = configuration;
    }

    @Override
    protected Processor createProcessor() throws Exception {
        return new GlobalVariablesProcessor(this);
    }

    public GlobalVariablesConfiguration getConfiguration() {
        return configuration;
    }

    @Override
    public GlobalVariablesComponent getComponent() {
        return component;
    }
}