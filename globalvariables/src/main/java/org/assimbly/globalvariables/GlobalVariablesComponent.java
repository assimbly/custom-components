package org.assimbly.globalvariables;

import org.apache.camel.Endpoint;
import org.apache.camel.support.DefaultComponent;

import java.util.Map;

public class GlobalVariablesComponent extends DefaultComponent {

    @Override
    protected Endpoint createEndpoint(String uri, String remaining, Map<String, Object> parameters) throws Exception {
        GlobalVariablesConfiguration configuration = new GlobalVariablesConfiguration();

        configuration.setName(remaining);

        GlobalVariablesEndpoint endpoint = new GlobalVariablesEndpoint(uri, this, configuration);

        setProperties(endpoint.getConfiguration(), parameters);

        return endpoint;
    }
}
