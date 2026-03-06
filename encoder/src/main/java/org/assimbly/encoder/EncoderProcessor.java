package org.assimbly.encoder;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class EncoderProcessor implements Processor {

    private final EncoderEndpoint endpoint;

    public EncoderProcessor(EncoderEndpoint endpoint) {
        this.endpoint = endpoint;
    }

    @Override
    public void process(Exchange exchange) throws Exception {

        EncoderConfiguration config = endpoint.getConfiguration();

        byte[] bytes = exchange.getIn().getBody(byte[].class);

        String original = new String(bytes, config.getOriginCharset());
        String result = new String(original.getBytes(), config.getTargetCharset());

        exchange.getIn().setBody(result);

    }

}
