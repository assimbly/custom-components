package org.assimbly.xmltocsv;

import org.apache.camel.Processor;
import org.apache.camel.support.ProcessorEndpoint;
import org.apache.camel.spi.UriEndpoint;
import org.apache.camel.spi.UriParam;

import java.util.Objects;


@UriEndpoint(
        firstVersion = "3.0.1",
        scheme = "xmltocsv",
        title = "XML To CSV Component",
        syntax = "xmltocsv:"
)
public class XmlToCsvEndpoint extends ProcessorEndpoint {

    @UriParam
    private final XmlToCsvConfiguration configuration;
    private final XmlToCsvComponent component;

    public XmlToCsvEndpoint(String uri, XmlToCsvComponent component, XmlToCsvConfiguration configuration) {
        super(uri, component);

        this.component = component;
        this.configuration = configuration;
    }

    @Override
    protected Processor createProcessor() {
        return new XmlToCsvProcessor(this);
    }

    public XmlToCsvConfiguration getConfiguration() {
        return configuration;
    }

    @Override
    public XmlToCsvComponent getComponent(){
        return component;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof XmlToCsvEndpoint that)) return false;
        if (!super.equals(o)) return false;
        return Objects.equals(component, that.component);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), component);
    }

}
