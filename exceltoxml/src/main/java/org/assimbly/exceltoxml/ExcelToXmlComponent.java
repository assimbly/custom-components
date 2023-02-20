package org.assimbly.exceltoxml;

import org.apache.camel.Endpoint;
import org.apache.camel.support.DefaultComponent;


import java.util.Map;

public class ExcelToXmlComponent extends DefaultComponent {

    @Override
    protected Endpoint createEndpoint(String uri, String context, Map<String, Object> parameters) throws Exception {
        ExcelToXmlConfiguration configuration = new ExcelToXmlConfiguration();

        ExcelToXmlEndpoint endpoint = new ExcelToXmlEndpoint(uri, this, configuration);

        setProperties(endpoint.getConfiguration(), parameters);

        return endpoint;
    }
}
