package org.assimbly.xmltocsv;

import org.apache.camel.Endpoint;
import org.apache.camel.support.DefaultComponent;

import java.util.Map;

public class XmlToCsvComponent extends DefaultComponent {

    @Override
    protected Endpoint createEndpoint(String uri, String context, Map<String, Object> parameters) throws Exception {
        XmlToCsvConfiguration configuration = new XmlToCsvConfiguration();

        XmlToCsvEndpoint endpoint = new XmlToCsvEndpoint(uri, this, configuration);

        setProperties(endpoint.getConfiguration(), parameters);

        return (Endpoint) endpoint;
    }
}
