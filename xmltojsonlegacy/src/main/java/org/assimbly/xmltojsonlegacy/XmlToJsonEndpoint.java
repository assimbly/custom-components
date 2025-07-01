package org.assimbly.xmltojsonlegacy;

import org.apache.camel.Processor;
import org.apache.camel.spi.UriEndpoint;
import org.apache.camel.spi.UriParam;
import org.apache.camel.support.ProcessorEndpoint;


@UriEndpoint(
        firstVersion = "4.0.0",
        scheme = "xmltojsonlegacy",
        title = "XML To Json Legacy Component",
        syntax = "xmltojsonlegacy:"
)
public class XmlToJsonEndpoint extends ProcessorEndpoint {

    @UriParam
    private final XmlToJsonConfiguration configuration;
    private final XmlToJsonComponent component;

    public XmlToJsonEndpoint(String uri, XmlToJsonComponent component, XmlToJsonConfiguration configuration) {
        super(uri, component);

        this.component = component;
        this.configuration = configuration;
    }

    @Override
    protected Processor createProcessor() {
        return new XmlToJsonProcessor(this);
    }

    public XmlToJsonConfiguration getConfiguration() {
        return configuration;
    }

    @Override
    public XmlToJsonComponent getComponent(){
        return component;
    }

    @Override
    public boolean equals(Object object) {
        return super.equals(object);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
