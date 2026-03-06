package org.assimbly.xmltoexcel;

import org.apache.camel.Processor;
import org.apache.camel.spi.UriEndpoint;
import org.apache.camel.spi.UriParam;
import org.apache.camel.support.ProcessorEndpoint;

import java.util.Objects;

@UriEndpoint(
        firstVersion = "3.0.1",
        scheme = "xmltoexcel",
        title = "XML To CSV Component",
        syntax = "xmltoexcel:"
)
public class XmlToExcelEndpoint extends ProcessorEndpoint {

    @UriParam
    private final XmlToExcelConfiguration configuration;
    private final XmlToExcelComponent component;

    public XmlToExcelEndpoint(String uri, XmlToExcelComponent component, XmlToExcelConfiguration configuration) {
        super(uri, component);

        this.component = component;
        this.configuration = configuration;
    }

    @Override
    protected Processor createProcessor() {
        return new XmlToExcelProcessor(this);
    }

    public XmlToExcelConfiguration getConfiguration() {
        return configuration;
    }

    @Override
    public XmlToExcelComponent getComponent(){
        return component;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof XmlToExcelEndpoint that)) return false;
        if (!super.equals(o)) return false;
        return Objects.equals(component, that.component);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), component);
    }

}
