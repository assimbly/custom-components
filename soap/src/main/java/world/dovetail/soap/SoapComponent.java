package world.dovetail.soap;

import org.apache.camel.Endpoint;
import org.apache.camel.support.DefaultComponent;

import java.util.Map;

public class SoapComponent extends DefaultComponent {

    @Override
    protected Endpoint createEndpoint(String uri, String remaining, Map<String, Object> parameters) throws Exception {
        SoapConfiguration configuration = new SoapConfiguration();
        configuration.setWsdl(remaining);

        SoapEndpoint endpoint = new SoapEndpoint(uri, this, configuration);

        setProperties(endpoint.getConfiguration(), parameters);

        return (Endpoint) endpoint;
    }

}
