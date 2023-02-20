package org.assimbly.flv;

import org.apache.camel.Endpoint;
import org.apache.camel.support.DefaultComponent;
import org.milyn.Smooks;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FLVComponent extends DefaultComponent {

    @Override
    protected Endpoint createEndpoint(String uri, String remaining, Map<String, Object> parameters) {
        Smooks smooks = new Smooks();
        List<LineReader> lineReaders = new ArrayList<>();

        // manually handle parameters
        // the alternative would be having setters on the endpoint itself
        for(Map.Entry<String, Object> param: parameters.entrySet()) {
            lineReaders.add(LineReader.fromEncodedConfig(param.getKey(), param.getValue().toString()));
        }
        // clear out parameters so that no setter inspection occurs
        parameters.clear();

        FLVConfigurator config = new FLVConfigurator(lineReaders);
        smooks.setReaderConfig(config);

        return new FLVEndpoint(uri, this, smooks);
    }
}
