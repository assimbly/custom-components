package org.assimbly.oriflame;

import org.apache.camel.Endpoint;
import org.apache.camel.support.DefaultComponent;
import org.assimbly.oriflame.details.EdiDetails;
import org.assimbly.oriflame.details.EdiType;
import org.milyn.Smooks;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class OriflameComponent extends DefaultComponent {

    @Override
    protected Endpoint createEndpoint(String uri, String remaining, Map<String, Object> parameters) throws Exception {
        Smooks smooks = new Smooks();
        List<OriflameLineReader> lineReaders = new ArrayList<>();

        String type = parameters.get("ediType").toString();
        EdiDetails details = EdiType.details(type);

        // manually handle parameters
        // the alternative would be having setters on the endpoint itself
        for(Map.Entry<String, String> entry : details.lineReaders.entrySet()) {
            lineReaders.add(OriflameLineReader.fromEncodedConfig(entry.getKey(), entry.getValue()));
        }

        // clear out parameters so that no setter inspection occurs
        parameters.clear();

        OriflameConfigurator config = new OriflameConfigurator(lineReaders, details);
        smooks.setReaderConfig(config);

        return new OriflameEndpoint(uri, this, smooks);
    }
}
