package world.dovetail.replace;

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
        ReplaceConfiguration config = endpoint.getConfiguration();

        String regex = config.getRegex();
        String replaceWith = config.getReplaceWith();

        if(ExchangeHelper.hasVariables(regex))
            regex = ExchangeHelper.interpolate(regex, exchange);


        if(ExchangeHelper.hasVariables(replaceWith))
            replaceWith = ExchangeHelper.interpolate(replaceWith, exchange);

        Pattern pattern = Pattern.compile(regex, config.getFlagsMagicConstant());

        try (InputStream body = exchange.getIn().getBody(InputStream.class);
             ByteArrayOutputStream result = new ByteArrayOutputStream()) {

            PushbackReader reader = new PushbackReader(new InputStreamReader(body));

            StringBuilder line;

            while ((line = nextLine(reader)) != null) {
                result.write(replace(line.toString(), pattern, replaceWith, config));
            }

            exchange.getIn().setBody(new ByteArrayInputStream(result.toByteArray()), String.class);
        }
    }

    private StringBuilder nextLine(PushbackReader reader) throws IOException {
        StringBuilder line = new StringBuilder();
        int nextChar;

        for(;;) {
            nextChar = reader.read();
            char c = (char) nextChar;

            if (nextChar == -1)
                return (line.length()==0) ? null : line;

            line.append(c);

            if(c == '\r') {
                char peek = (char) reader.read();

                if(peek == '\n')
                    line.append(peek);

                else
                    reader.unread(peek);

                return line;
            }

            if(c == '\n')
                return line;
        }
    }

    private byte[] replace(String line, Pattern pattern, String replaceWith, ReplaceConfiguration config) {
        StringBuilder sb = new StringBuilder(line.length());
        Matcher matcher = pattern.matcher(line);

        int prev = 0;
        while (matcher.find()) {
            sb.append(line, prev, matcher.start(config.getGroup()));
            sb.append(ExchangeHelper.unescapeExceptionalCharacters(replaceWith));
            prev = matcher.end(config.getGroup());
        }

        return sb.append(line, prev, line.length()).toString().getBytes();
    }
}
