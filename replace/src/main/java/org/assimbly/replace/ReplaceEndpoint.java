package org.assimbly.replace;

import org.apache.camel.Processor;
import org.apache.camel.spi.UriEndpoint;
import org.apache.camel.spi.UriParam;
import org.apache.camel.support.ProcessorEndpoint;

import java.util.Objects;

@UriEndpoint(
        firstVersion = "3.0.3",
        scheme = "replace",
        title = "Replace Component",
        syntax = "replace:"
)
public class ReplaceEndpoint extends ProcessorEndpoint {

    @UriParam
    private ReplaceConfiguration configuration;
    private final ReplaceComponent component;

    public ReplaceEndpoint(String uri, ReplaceComponent component, ReplaceConfiguration configuration) {
        super(uri, component);

        this.component = component;
        this.configuration = configuration;
    }

    @Override
    protected Processor createProcessor() {
        return new ReplaceProcessor(this);
    }

    public ReplaceConfiguration getConfiguration() {
        return configuration;
    }

    @Override
    public ReplaceComponent getComponent() {
        return component;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ReplaceEndpoint that)) return false;
        if (!super.equals(o)) return false;
        return Objects.equals(component, that.component);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), component);
    }

}