package org.assimbly.flv;

import org.apache.camel.Endpoint;
import org.apache.camel.Exchange;
import org.apache.camel.support.DefaultProducer;
import org.milyn.Smooks;

import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.StringReader;
import java.io.StringWriter;

public class FLVProducer extends DefaultProducer {

    private final Smooks smooks;

    public FLVProducer(Endpoint endpoint, Smooks smooks) {
        super(endpoint);
        this.smooks = smooks;
    }

    @Override
    public void process(Exchange exchange) {
        StringReader flv = new StringReader(exchange.getIn().getBody(String.class));
        StringWriter xml = new StringWriter();

        smooks.filterSource(new StreamSource(flv), new StreamResult(xml));

        exchange.getIn().setBody(xml.toString());
    }
}

