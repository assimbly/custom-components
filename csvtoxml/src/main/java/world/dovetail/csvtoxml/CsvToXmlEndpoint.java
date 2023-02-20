package world.dovetail.csvtoxml;

import org.apache.camel.Component;
import org.apache.camel.Processor;
import org.apache.camel.spi.UriEndpoint;
import org.apache.camel.spi.UriParam;
import org.apache.camel.support.ProcessorEndpoint;

@UriEndpoint(
        firstVersion = "3.0.1",
        scheme = "csvtoxml",
        title = "CSV To XML Component",
        syntax = "csvtoxml:"
)
public class CsvToXmlEndpoint extends ProcessorEndpoint {

    @UriParam
    private CsvToXmlConfiguration configuration;
    private CsvToXmlComponent component;

    public CsvToXmlEndpoint(String uri, CsvToXmlComponent component, CsvToXmlConfiguration configuration) {
        super(uri, (Component) component);

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
        return (Component) component;
    }
}
