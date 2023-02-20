package world.dovetail.csvtoxml;

import org.apache.camel.Endpoint;
import org.apache.camel.support.DefaultComponent;


import java.util.Map;

public class CsvToXmlComponent extends DefaultComponent {

    @Override
    protected Endpoint createEndpoint(String uri, String context, Map<String, Object> parameters) throws Exception {

        CsvToXmlConfiguration configuration = new CsvToXmlConfiguration();

        CsvToXmlEndpoint endpoint = new CsvToXmlEndpoint(uri, this, configuration);

        setProperties(endpoint.getConfiguration(), parameters);

        return endpoint;
    }
}
