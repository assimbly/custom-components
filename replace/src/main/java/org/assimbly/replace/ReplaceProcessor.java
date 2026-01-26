package org.assimbly.replace;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.text.StringEscapeUtils;
import org.assimbly.util.helper.ExchangeHelper;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReplaceProcessor implements Processor {

    private final ReplaceEndpoint endpoint;

    public ReplaceProcessor(ReplaceEndpoint endpoint) {
        this.endpoint = endpoint;
    }

    @Override
    public void process(Exchange exchange) throws Exception {

        String body = exchange.getIn().getBody(String.class);

        ReplaceConfiguration config = endpoint.getConfiguration();

        String regex = config.getRegex();
        String replaceWith = Optional.ofNullable(config.getReplaceWith()).orElse("");
        replaceWith = ExchangeHelper.unescapeExceptionalCharacters(replaceWith);

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

        replaceWith = Matcher.quoteReplacement(replaceWith);
        String result;

        if(config.getGroup() > 0){
            result = replaceGroup(regex, body, config.getGroup(), replaceWith);
        }else{
            Pattern pattern = Pattern.compile(regex, config.getFlagsMagicConstant());
            result = pattern.matcher(body).replaceAll(replaceWith);
        }

        exchange.getIn().setBody(result);

    }

    public static String replaceGroup(String regex, String source, int groupToReplace, String replacement) {

        Matcher m = Pattern.compile(regex).matcher(source);
        StringBuilder result = new StringBuilder();

        while (m.find()) {
            // Append the part before the match
            m.appendReplacement(result, source.substring(m.start(), m.start(groupToReplace)));

            // Append the replacement for the group
            result.append(replacement);

            // Append the part after the group
            result.append(source, m.end(groupToReplace), m.end());
        }

        // Append the remaining part of the source string after the last match
        m.appendTail(result);

        return result.toString();

    }

}