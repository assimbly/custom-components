package org.assimbly.soap;

import org.apache.camel.Processor;
import org.apache.camel.spi.UriEndpoint;
import org.apache.camel.spi.UriParam;
import org.apache.camel.support.ProcessorEndpoint;

@UriEndpoint(
        firstVersion = "2.4.0",
        scheme = "soap",
        title = "Soap Component",
        syntax = "soap:wsdl"
)
public class SoapEndpoint extends ProcessorEndpoint {

    @UriParam
    private SoapConfiguration configuration;
    private SoapComponent component;

    public SoapEndpoint(String uri, SoapComponent component, SoapConfiguration configuration) {
        super(uri, component);

        this.component = component;
        this.configuration = configuration;
    }

    @Override
    protected Processor createProcessor() throws Exception {
        return new SoapProcessor(this);
    }

    public SoapConfiguration getConfiguration() {
        return configuration;
    }

    @Override
    public SoapComponent getComponent() {
        return component;
    }
}