package world.dovetail.amazon;

import org.apache.camel.Endpoint;
import org.apache.camel.support.DefaultComponent;

import java.util.Map;

public class AmazonComponent extends DefaultComponent {

    @Override
    protected Endpoint createEndpoint(String uri, String remaining, Map<String, Object> parameters) throws Exception {
        AmazonConfiguration configuration = new AmazonConfiguration();

        configuration.setOperation(remaining);

        AmazonEndpoint endpoint = new AmazonEndpoint(uri, this, configuration);

        setProperties(endpoint.getConfiguration(), parameters);

        return endpoint;
    }
}
