package org.assimbly.sql;


import org.apache.camel.Endpoint;
import org.apache.camel.support.DefaultComponent;

import java.util.Map;

public class SqlComponent extends DefaultComponent {

    @Override
    protected Endpoint createEndpoint(String uri, String remaining, Map<String, Object> parameters) throws Exception {
        SqlConfiguration configuration = new SqlConfiguration();
        configuration.configure(uri);

        SqlEndpoint endpoint = new SqlEndpoint(uri, this, configuration);

        setProperties(endpoint.getConfiguration(), parameters);

        return (Endpoint) endpoint;
    }
}
