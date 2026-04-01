package org.assimbly.formtoxml;

import org.apache.camel.Processor;
import org.apache.camel.spi.UriEndpoint;
import org.apache.camel.spi.UriParam;
import org.apache.camel.support.ProcessorEndpoint;

import java.util.Objects;

@UriEndpoint(
        firstVersion = "3.0.1",
        scheme = "formtoxml",
        title = "Form To XML Component",
        syntax = "formtoxml:"
)
public class FormToXmlEndpoint extends ProcessorEndpoint {
    @UriParam
    private FormToXmlConfiguration configuration;
    private final FormToXmlComponent component;

    public FormToXmlEndpoint(String uri, FormToXmlComponent component, FormToXmlConfiguration configuration) {
        super(uri, component);

        this.component = component;
        this.configuration = configuration;
    }

    @Override
    protected Processor createProcessor() {
        return new FormToXmlProcessor(this);
    }

    public FormToXmlConfiguration getConfiguration() {
        return configuration;
    }

    @Override
    public FormToXmlComponent getComponent(){
        return component;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FormToXmlEndpoint that)) return false;
        if (!super.equals(o)) return false;
        return Objects.equals(component, that.component);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), component);
    }

}
