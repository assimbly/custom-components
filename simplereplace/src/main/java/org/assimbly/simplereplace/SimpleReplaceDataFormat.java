package org.assimbly.simplereplace;

import org.apache.camel.Exchange;
import org.apache.camel.model.language.SimpleExpression;
import org.apache.camel.spi.DataFormat;
import org.apache.commons.io.output.ByteArrayOutputStream;

import java.io.InputStream;
import java.io.OutputStream;

public class SimpleReplaceDataFormat implements DataFormat {

    @Override
    public void marshal(Exchange exchange, Object graph, OutputStream stream) {
    }

    @Override
    public Object unmarshal(Exchange exchange, InputStream body) throws Exception {

        try (OutputStream result = new ByteArrayOutputStream()) {

            boolean endsWithNewLine = exchange.getIn().getBody(String.class).endsWith("\n");

            SimpleExpression expression = new SimpleExpression(exchange.getIn().getBody(String.class));
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
