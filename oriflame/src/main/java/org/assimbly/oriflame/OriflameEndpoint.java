package org.assimbly.oriflame;

import org.apache.camel.Consumer;
import org.apache.camel.Processor;
import org.apache.camel.Producer;
import org.apache.camel.support.DefaultEndpoint;
import org.milyn.Smooks;

public class OriflameEndpoint extends DefaultEndpoint {

    private final Smooks smooks;

    public OriflameEndpoint(String uri, OriflameComponent oriflameComponent, Smooks smooks) {
        super(uri, oriflameComponent);
        this.smooks = smooks;
    }

    @Override
    public Producer createProducer() {
        return new OriflameProducer(this, smooks);
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
