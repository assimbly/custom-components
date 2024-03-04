package org.assimbly.jsontoxmllegacy;

import org.apache.camel.Endpoint;
import org.apache.camel.support.DefaultComponent;

import java.util.Map;

public class JsonToXmlComponent extends DefaultComponent {

    @Override
    protected Endpoint createEndpoint(String uri, String context, Map<String, Object> parameters) throws Exception {
        JsonToXmlConfiguration configuration = new JsonToXmlConfiguration();

        JsonToXmlEndpoint endpoint = new JsonToXmlEndpoint(uri, this, configuration);

        setProperties(endpoint.getConfiguration(), parameters);

        return (Endpoint) endpoint;
    }
}
