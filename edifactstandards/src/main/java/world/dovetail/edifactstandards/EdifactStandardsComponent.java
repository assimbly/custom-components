package world.dovetail.edifactstandards;

import org.apache.camel.Endpoint;
import org.apache.camel.support.DefaultComponent;

import java.util.Map;

public class EdifactStandardsComponent extends DefaultComponent {

    @Override
    protected Endpoint createEndpoint(String uri, String remaining, Map<String, Object> parameters) throws Exception {
        EdifactStandardsConfiguration configuration = new EdifactStandardsConfiguration();
        configuration.setType(remaining);

        EdifactStandardsEndpoint endpoint = new EdifactStandardsEndpoint(uri, this, configuration);

        setProperties(endpoint.getConfiguration(), parameters);

        return endpoint;
    }
}
