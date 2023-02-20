package world.dovetail.encoder;

import org.apache.camel.Endpoint;
import org.apache.camel.support.DefaultComponent;

import java.util.Map;

public class EncoderComponent extends DefaultComponent {

    @Override
    protected Endpoint createEndpoint(String uri, String remaining, Map<String, Object> parameters) throws Exception {
        EncoderConfiguration configuration = new EncoderConfiguration();
        configuration.setOriginCharset(remaining);

        EncoderEndpoint endpoint = new EncoderEndpoint(uri, this, configuration);

        setProperties(endpoint.getConfiguration(), parameters);

        return endpoint;
    }
}
