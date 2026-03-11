package org.assimbly.tenantvariables;

import org.apache.camel.Processor;
import org.apache.camel.spi.UriEndpoint;
import org.apache.camel.spi.UriParam;
import org.apache.camel.support.ProcessorEndpoint;

import java.util.Objects;

@UriEndpoint(
        firstVersion = "2.7.1",
        scheme = "tenantvariables",
        title = "Tenant Variables",
        syntax = "tenantvariables:name")
public class TenantVariablesEndpoint extends ProcessorEndpoint {

    @UriParam
    private TenantVariablesConfiguration configuration;
    private final TenantVariablesComponent component;

    public TenantVariablesEndpoint(String uri, TenantVariablesComponent component, TenantVariablesConfiguration configuration) {
        super(uri, component);

        this.component = component;
        this.configuration = configuration;
    }

    @Override
    protected Processor createProcessor() {
        return new TenantVariablesProcessor(this);
    }

    public TenantVariablesConfiguration getConfiguration() {
        return configuration;
    }

    @Override
    public TenantVariablesComponent getComponent() {
        return component;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TenantVariablesEndpoint that)) return false;
        if (!super.equals(o)) return false;
        return Objects.equals(component, that.component);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), component);
    }

}