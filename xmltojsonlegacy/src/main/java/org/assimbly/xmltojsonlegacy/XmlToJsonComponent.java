package org.assimbly.xmltojsonlegacy;

import org.apache.camel.Endpoint;
import org.apache.camel.support.DefaultComponent;

import java.util.Map;

public class XmlToJsonComponent extends DefaultComponent {

    @Override
    protected Endpoint createEndpoint(String uri, String context, Map<String, Object> parameters) throws Exception {
        XmlToJsonConfiguration configuration = new XmlToJsonConfiguration();

        XmlToJsonEndpoint endpoint = new XmlToJsonEndpoint(uri, this, configuration);

        setProperties(endpoint.getConfiguration(), parameters);

        return (Endpoint) endpoint;
    }
}
