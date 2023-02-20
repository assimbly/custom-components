package org.assimbly.pdf;

import org.apache.camel.Endpoint;
import org.apache.camel.support.DefaultComponent;
import org.apache.camel.support.ResourceHelper;

import java.util.Map;

public class PdfComponent extends DefaultComponent {

    @Override
    protected Endpoint createEndpoint(String uri, String remaining, Map<String, Object> parameters) throws Exception {
        PdfConfiguration configuration = new PdfConfiguration();

        PdfEndpoint endpoint = new PdfEndpoint(uri, this, configuration);

        setProperties(endpoint.getConfiguration(), parameters);

        String url = remaining;

        if (ResourceHelper.isHttpUri(url)) {
            // if its a http uri, then append additional parameters as they are part of the uri
            url = ResourceHelper.appendParameters(url, parameters);
        }

        configuration.setUrl(url);

        return endpoint;
    }
}
