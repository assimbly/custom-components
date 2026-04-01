package org.assimbly.csvtoxml;

import org.apache.camel.Component;
import org.apache.camel.Processor;
import org.apache.camel.spi.UriEndpoint;
import org.apache.camel.spi.UriParam;
import org.apache.camel.support.ProcessorEndpoint;

import java.util.Objects;

@UriEndpoint(
        firstVersion = "3.0.1",
        scheme = "csvtoxml",
        title = "CSV To XML Component",
        syntax = "csvtoxml:"
)
public class CsvToXmlEndpoint extends ProcessorEndpoint {

    @UriParam
    private CsvToXmlConfiguration configuration;
    private final CsvToXmlComponent component;

    public CsvToXmlEndpoint(String uri, CsvToXmlComponent component, CsvToXmlConfiguration configuration) {
        super(uri, component);

        this.component = component;
        this.configuration = configuration;
    }

    @Override
    protected Processor createProcessor() {
        return new CsvToXmlProcessor(this);
    }

    public CsvToXmlConfiguration getConfiguration() {
        return configuration;
    }

    @Override
    public Component getComponent(){
        return component;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CsvToXmlEndpoint that)) return false;
        if (!super.equals(o)) return false;
        return Objects.equals(configuration, that.configuration)
                && Objects.equals(component, that.component);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), configuration, component);
    }

}
