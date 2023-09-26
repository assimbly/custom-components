package org.assimbly.tenantvariables;

import org.apache.camel.Endpoint;
import org.apache.camel.support.DefaultComponent;

import java.util.Map;

public class TenantVariablesComponent extends DefaultComponent {

    @Override
    protected Endpoint createEndpoint(String uri, String remaining, Map<String, Object> parameters) throws Exception {
        TenantVariablesConfiguration configuration = new TenantVariablesConfiguration();

        configuration.setName(remaining);

        TenantVariablesEndpoint endpoint = new TenantVariablesEndpoint(uri, this, configuration);

        setProperties(endpoint.getConfiguration(), parameters);

        return endpoint;
    }
}
