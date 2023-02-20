package org.assimbly.fmuta;

import org.apache.camel.Processor;
import org.apache.camel.spi.UriParam;
import org.apache.camel.support.ProcessorEndpoint;

public class FmutaEndpoint extends ProcessorEndpoint {

    @UriParam
    private FmutaConfiguration configuration;
    private FmutaComponent component;

    public FmutaEndpoint(String uri, FmutaComponent component, FmutaConfiguration configuration) {
        super(uri, component);

        this.component = component;
        this.configuration = configuration;
    }

    @Override
    protected Processor createProcessor() {
        return new FmutaProcessor(this);
    }

    public FmutaConfiguration getConfiguration() {
        return configuration;
    }

    @Override
    public FmutaComponent getComponent() {
        return component;
    }
}