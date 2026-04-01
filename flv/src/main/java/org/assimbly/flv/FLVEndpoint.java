package org.assimbly.flv;

import org.apache.camel.Consumer;
import org.apache.camel.Processor;
import org.apache.camel.Producer;
import org.apache.camel.support.DefaultEndpoint;
import org.milyn.Smooks;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FLVEndpoint that)) return false;
        if (!super.equals(o)) return false;
        return Objects.equals(smooks, that.smooks);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), smooks);
    }

}
