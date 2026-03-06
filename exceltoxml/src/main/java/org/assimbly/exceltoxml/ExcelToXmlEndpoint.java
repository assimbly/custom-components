package org.assimbly.exceltoxml;

import org.apache.camel.Processor;
import org.apache.camel.support.ProcessorEndpoint;
import org.apache.camel.spi.UriEndpoint;
import org.apache.camel.spi.UriParam;

import java.util.Objects;

@UriEndpoint(
        firstVersion = "3.0.1",
        scheme = "exceltoxml",
        title = "Excel To XML Component",
        syntax = "exceltoxml:"
)
public class ExcelToXmlEndpoint extends ProcessorEndpoint {
    @UriParam
    private final ExcelToXmlConfiguration configuration;
    private final ExcelToXmlComponent component;

    public ExcelToXmlEndpoint(String uri, ExcelToXmlComponent component, ExcelToXmlConfiguration configuration) {
        super(uri, component);

        this.component = component;
        this.configuration = configuration;
    }

    @Override
    protected Processor createProcessor() {
        return new ExcelToXmlProcessor(this);
    }

    public ExcelToXmlConfiguration getConfiguration() {
        return configuration;
    }

    @Override
    public ExcelToXmlComponent getComponent(){
        return component;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ExcelToXmlEndpoint that)) return false;
        if (!super.equals(o)) return false;
        return Objects.equals(component, that.component);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), component);
    }

}
