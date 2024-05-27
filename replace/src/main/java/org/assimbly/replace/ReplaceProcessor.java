package org.assimbly.replace;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.assimbly.util.helper.ExchangeHelper;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReplaceProcessor implements Processor {

    private ReplaceEndpoint endpoint;

    public ReplaceProcessor(ReplaceEndpoint endpoint) {
        this.endpoint = endpoint;
    }

    @Override
    public void process(Exchange exchange) throws Exception {

        String body = exchange.getIn().getBody(String.class);


        ReplaceConfiguration config = endpoint.getConfiguration();

        String regex = config.getRegex();
        String replaceWith = config.getReplaceWith();

        if(ExchangeHelper.hasVariables(regex))
            regex = ExchangeHelper.interpolate(regex, exchange);

        if(ExchangeHelper.hasVariables(replaceWith))
            replaceWith = ExchangeHelper.interpolate(replaceWith, exchange);

        Pattern pattern = Pattern.compile(regex, config.getFlagsMagicConstant());
        String result = pattern.matcher(body).replaceAll(replaceWith);

        exchange.getIn().setBody(result);

    }

}