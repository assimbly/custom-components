package org.assimbly.simplereplace;

import org.apache.camel.Exchange;
import org.apache.camel.model.language.SimpleExpression;
import org.apache.camel.spi.DataFormat;
import org.apache.commons.io.output.ByteArrayOutputStream;

import java.io.InputStream;
import java.io.OutputStream;

public class SimpleReplaceDataFormat implements DataFormat {

    @Override
    public void marshal(Exchange exchange, Object graph, OutputStream stream) throws Exception {
    }

    @Override
    public Object unmarshal(Exchange exchange, InputStream body) throws Exception {

        String inputBody = exchange.getIn().getBody(String.class);

        try (OutputStream result = new ByteArrayOutputStream()) {

            boolean endsWithNewLine = inputBody.endsWith("\n");

            SimpleExpression expression = new SimpleExpression(inputBody);
            result.write(expression.evaluate(exchange, byte[].class));

            if (endsWithNewLine)
                result.write('\n');

            return result;
        }
    }

    @Override
    public void start() {

    }

    @Override
    public void stop() {

    }
}
