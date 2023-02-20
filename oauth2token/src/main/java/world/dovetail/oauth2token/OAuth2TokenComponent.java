package world.dovetail.oauth2token;

import org.apache.camel.Endpoint;
import org.apache.camel.support.DefaultComponent;


import java.util.Map;

public class OAuth2TokenComponent extends DefaultComponent {

    @Override
    protected Endpoint createEndpoint(String uri, String remaining, Map<String, Object> parameters) throws Exception {
        OAuth2TokenConfiguration configuration = new OAuth2TokenConfiguration();

        configuration.setName(remaining);

        OAuth2TokenEndpoint endpoint = new OAuth2TokenEndpoint(uri, this, configuration);

        setProperties(endpoint.getConfiguration(), parameters);

        return endpoint;
    }
}
