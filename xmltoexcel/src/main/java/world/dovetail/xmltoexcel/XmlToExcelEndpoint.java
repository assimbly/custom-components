package world.dovetail.xmltoexcel;

import org.apache.camel.Processor;
import org.apache.camel.spi.UriEndpoint;
import org.apache.camel.spi.UriParam;
import org.apache.camel.support.ProcessorEndpoint;

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
}
