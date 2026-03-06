package org.assimbly.soap;

import org.apache.camel.Processor;
import org.apache.camel.spi.UriEndpoint;
import org.apache.camel.spi.UriParam;
import org.apache.camel.support.ProcessorEndpoint;

import java.util.Objects;

@UriEndpoint(
        firstVersion = "2.4.0",
        scheme = "soap",
        title = "Soap Component",
        syntax = "soap:wsdl"
)
public class SoapEndpoint extends ProcessorEndpoint {

    @UriParam
    private SoapConfiguration configuration;
    private final SoapComponent component;

    public SoapEndpoint(String uri, SoapComponent component, SoapConfiguration configuration) {
        super(uri, component);

        this.component = component;
        this.configuration = configuration;
    }

    @Override
    protected Processor createProcessor() {
        return new SoapProcessor(this);
    }

    public SoapConfiguration getConfiguration() {
        return configuration;
    }

    @Override
    public SoapComponent getComponent() {
        return component;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SoapEndpoint that)) return false;
        if (!super.equals(o)) return false;
        return Objects.equals(component, that.component);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), component);
    }

}