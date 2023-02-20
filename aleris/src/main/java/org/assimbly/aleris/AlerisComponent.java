package org.assimbly.aleris;

import org.apache.camel.Component;
import org.apache.camel.Endpoint;
import org.apache.camel.Processor;
import org.apache.camel.support.DefaultComponent;
import org.apache.camel.support.ProcessorEndpoint;

import java.util.Map;

public class AlerisComponent extends DefaultComponent {

    @Override
    protected Endpoint createEndpoint(String uri, String remaining, Map<String, Object> parameters) throws Exception {
        return new AlerisEndpoint(uri, this);
    }

    private class AlerisEndpoint extends ProcessorEndpoint {
        public AlerisEndpoint(String uri, Component component) {
            super(uri, component);
        }

        @Override
        protected Processor createProcessor() throws Exception {
            return new AlerisTxtToXmlProcessor();
        }
    }
}
