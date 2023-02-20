package world.dovetail.encoder;

import org.apache.camel.Processor;
import org.apache.camel.spi.UriEndpoint;
import org.apache.camel.spi.UriParam;
import org.apache.camel.support.ProcessorEndpoint;

@UriEndpoint(
        firstVersion = "4.2.0",
        scheme = "encoder",
        title = "Encoder Component",
        syntax = "encoder:"
)
public class EncoderEndpoint extends ProcessorEndpoint {

    @UriParam
    private EncoderConfiguration configuration;
    private EncoderComponent component;

    public EncoderEndpoint(String uri, EncoderComponent component, EncoderConfiguration configuration) {
        super(uri, component);

        this.component = component;
        this.configuration = configuration;
    }

    @Override
    protected Processor createProcessor() throws Exception {
        return new EncoderProcessor(this);
    }

    public EncoderConfiguration getConfiguration() {
        return configuration;
    }

    @Override
    public EncoderComponent getComponent() {
        return component;
    }
}