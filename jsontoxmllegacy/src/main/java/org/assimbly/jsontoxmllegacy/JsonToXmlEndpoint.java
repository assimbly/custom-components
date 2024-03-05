package org.assimbly.jsontoxmllegacy;

import org.apache.camel.Processor;
import org.apache.camel.spi.UriEndpoint;
import org.apache.camel.spi.UriParam;
import org.apache.camel.support.ProcessorEndpoint;


@UriEndpoint(
        firstVersion = "4.0.0",
        scheme = "jsontoxmllegacy",
        title = "Json To XML Legacy Component",
        syntax = "jsontoxmllegacy:"
)
public class JsonToXmlEndpoint extends ProcessorEndpoint {

    @UriParam
    private final JsonToXmlConfiguration configuration;
    private final JsonToXmlComponent component;

    public JsonToXmlEndpoint(String uri, JsonToXmlComponent component, JsonToXmlConfiguration configuration) {
        super(uri, component);

        this.component = component;
        this.configuration = configuration;
    }

    @Override
    protected Processor createProcessor() {
        return new JsonToXmlProcessor(this);
    }

    public JsonToXmlConfiguration getConfiguration() {
        return configuration;
    }

    @Override
    public JsonToXmlComponent getComponent(){
        return component;
    }
}
