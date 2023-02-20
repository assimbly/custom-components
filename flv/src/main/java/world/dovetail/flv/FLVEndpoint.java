package world.dovetail.flv;

import org.apache.camel.Consumer;
import org.apache.camel.Processor;
import org.apache.camel.Producer;
import org.apache.camel.support.DefaultEndpoint;
import org.milyn.Smooks;

public class FLVEndpoint extends DefaultEndpoint {

    private final Smooks smooks;

    public FLVEndpoint(String uri, FLVComponent fixedLengthValuesComponent, Smooks smooks) {
        super(uri, fixedLengthValuesComponent);
        this.smooks = smooks;
    }

    @Override
    public Producer createProducer() {
        return new FLVProducer(this, smooks);
    }

    @Override
    public Consumer createConsumer(Processor processor) {
        return null;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }
}
