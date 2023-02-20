package world.dovetail.replace;

import org.apache.camel.Processor;
import org.apache.camel.spi.UriEndpoint;
import org.apache.camel.spi.UriParam;
import org.apache.camel.support.ProcessorEndpoint;

@UriEndpoint(
        firstVersion = "3.0.3",
        scheme = "replace",
        title = "Replace Component",
        syntax = "replace:"
)
public class ReplaceEndpoint extends ProcessorEndpoint {

    @UriParam
    private ReplaceConfiguration configuration;
    private ReplaceComponent component;

    public ReplaceEndpoint(String uri, ReplaceComponent component, ReplaceConfiguration configuration) {
        super(uri, component);

        this.component = component;
        this.configuration = configuration;
    }

    @Override
    protected Processor createProcessor() throws Exception {
        return new ReplaceProcessor(this);
    }

    public ReplaceConfiguration getConfiguration() {
        return configuration;
    }

    @Override
    public ReplaceComponent getComponent() {
        return component;
    }
}