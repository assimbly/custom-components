package org.assimbly.tenantvariables;

import org.apache.camel.Processor;
import org.apache.camel.spi.UriEndpoint;
import org.apache.camel.spi.UriParam;
import org.apache.camel.support.ProcessorEndpoint;

@UriEndpoint(
        firstVersion = "2.7.1",
        scheme = "tenantvariables",
        title = "Tenant Variables",
        syntax = "tenantvariables:name")
public class TenantVariablesEndpoint extends ProcessorEndpoint {

    @UriParam
    private TenantVariablesConfiguration configuration;
    private TenantVariablesComponent component;

    public TenantVariablesEndpoint(String uri, TenantVariablesComponent component, TenantVariablesConfiguration configuration) {
        super(uri, component);

        this.component = component;
        this.configuration = configuration;
    }

    @Override
    protected Processor createProcessor() throws Exception {
        return new TenantVariablesProcessor(this);
    }

    public TenantVariablesConfiguration getConfiguration() {
        return configuration;
    }

    @Override
    public TenantVariablesComponent getComponent() {
        return component;
    }
}