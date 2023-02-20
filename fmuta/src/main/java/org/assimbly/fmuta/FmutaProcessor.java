package org.assimbly.fmuta;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

import java.util.List;

public class FmutaProcessor implements Processor {

    private FmutaEndpoint endpoint;

    public FmutaProcessor(FmutaEndpoint endpoint) {
        this.endpoint = endpoint;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void process(Exchange exchange) {
        FmutaConfiguration config = endpoint.getConfiguration();
        FmutaFeedEnricher enricher = new FmutaFeedEnricher(config.getDecimalSeparator());

        exchange.getIn().setBody(
                enricher.enrich(exchange.getIn().getBody(List.class))
        );
    }
}
