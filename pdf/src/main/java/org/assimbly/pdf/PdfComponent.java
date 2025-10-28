package org.assimbly.pdf;

import org.apache.camel.Endpoint;
import org.apache.camel.support.DefaultComponent;
import org.apache.camel.support.ResourceHelper;

import java.util.Map;

public class PdfComponent extends DefaultComponent {

    @Override
    protected Endpoint createEndpoint(String uri, String remaining, Map<String, Object> parameters) throws Exception {

        PdfEndpoint endpoint = new PdfEndpoint(uri, this, remaining);

        setProperties(endpoint, parameters);

        if (ResourceHelper.isHttpUri(remaining)) {
            // if its a http uri, then append additional parameters as they are part of the uri
            remaining = ResourceHelper.appendParameters(remaining, parameters);
            endpoint.setResourceUri(remaining);
        }

        return endpoint;
    }

}
