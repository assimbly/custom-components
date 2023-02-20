package world.dovetail.xmltoexcel;

import org.apache.camel.Endpoint;
import org.apache.camel.support.DefaultComponent;


import java.util.Map;

public class XmlToExcelComponent extends DefaultComponent {

    @Override
    protected Endpoint createEndpoint(String uri, String context, Map<String, Object> parameters) throws Exception {
        XmlToExcelConfiguration configuration = new XmlToExcelConfiguration();

        XmlToExcelEndpoint endpoint = new XmlToExcelEndpoint(uri, this, configuration);

        setProperties(endpoint.getConfiguration(), parameters);

        return (Endpoint) endpoint;
    }
}
