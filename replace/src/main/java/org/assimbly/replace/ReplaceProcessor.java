package org.assimbly.replace;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.commons.lang3.StringUtils;
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
        String replaceWith = ExchangeHelper.unescapeExceptionalCharacters(config.getReplaceWith());

        if(regex.contains("${header.")) {
            String[] headerNames = StringUtils.substringsBetween(regex, "${header.", "}");
            for(String headerName: headerNames){
                String headerValue = exchange.getIn().getHeader(headerName, String.class);
                regex = StringUtils.replaceOnce(regex,"${header." + headerName + "}",headerValue);
            }

        }

        if(replaceWith.contains("${header.")) {
            String[] headerNames = StringUtils.substringsBetween(replaceWith, "${header.", "}");
            for(String headerName: headerNames){
                String headerValue = exchange.getIn().getHeader(headerName, String.class);
                replaceWith = StringUtils.replaceOnce(replaceWith,"${header." + headerName + "}",headerValue);
            }
        }

        Pattern pattern = Pattern.compile(regex, config.getFlagsMagicConstant());

        String result = "";
        if(config.getGroup() > 0){
            result = replaceGroup(regex,body,config.getGroup(),replaceWith);
        }else{
            result = pattern.matcher(body).replaceAll(replaceWith);
        }

        exchange.getIn().setBody(result);

    }

    public static String replaceGroup(String regex, String source, int groupToReplace, String replacement) {
        return replaceGroup(regex, source, groupToReplace, 1, replacement);
    }

    public static String replaceGroup(String regex, String source, int groupToReplace, int groupOccurrence, String replacement) {
        Matcher m = Pattern.compile(regex).matcher(source);
        for (int i = 0; i < groupOccurrence; i++)
            if (!m.find()) return source; // pattern not met, may also throw an exception here
        return new StringBuilder(source).replace(m.start(groupToReplace), m.end(groupToReplace), replacement).toString();
    }

}