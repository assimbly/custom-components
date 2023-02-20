package org.assimbly.formtoxml;

import org.apache.camel.Endpoint;
import org.apache.camel.support.DefaultComponent;

import java.util.Map;

public class FormToXmlComponent extends DefaultComponent {

    @Override
    protected Endpoint createEndpoint(String uri, String context, Map<String, Object> parameters) throws Exception {
        FormToXmlConfiguration configuration = new FormToXmlConfiguration();

        FormToXmlEndpoint endpoint = new FormToXmlEndpoint(uri, this, configuration);

        setProperties(endpoint.getConfiguration(), parameters);

        return endpoint;
    }
}
