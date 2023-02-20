package org.assimbly.amazon;

import org.apache.camel.Processor;
import org.apache.camel.spi.UriEndpoint;
import org.apache.camel.spi.UriParam;
import org.apache.camel.support.ProcessorEndpoint;

@UriEndpoint(
        firstVersion = "4.0.1",
        scheme = "amazon",
        title = "Amazon MWS Component",
        syntax = "amazon:operation")
public class AmazonEndpoint extends ProcessorEndpoint {

    @UriParam
    private AmazonConfiguration configuration;
    private AmazonComponent component;

    public AmazonEndpoint(String uri, AmazonComponent component, AmazonConfiguration configuration) {
        super(uri, component);

        this.component = component;
        this.configuration = configuration;
    }

    @Override
    protected Processor createProcessor() throws Exception {
        return new AmazonProcessor(this);
    }

    public AmazonConfiguration getConfiguration() {
        return configuration;
    }

    @Override
    public AmazonComponent getComponent() {
        return component;
    }
}
