package org.assimbly.edifactdotweb;

import org.apache.camel.Endpoint;
import org.apache.camel.support.DefaultComponent;

import java.util.Map;

public class EdifactDotwebComponent extends DefaultComponent {

    @Override
    protected Endpoint createEndpoint(String uri, String remaining, Map<String, Object> parameters) throws Exception {
        EdifactDotwebConfiguration configuration = new EdifactDotwebConfiguration();
        configuration.setType(remaining);

        EdifactDotwebEndpoint endpoint = new EdifactDotwebEndpoint(uri, this, configuration);

        setProperties(endpoint.getConfiguration(), parameters);

        return (Endpoint) endpoint;
    }
}
