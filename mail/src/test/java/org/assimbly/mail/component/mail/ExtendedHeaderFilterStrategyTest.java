package org.assimbly.mail.component.mail;

import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.camel.spi.HeaderFilterStrategy;
import org.apache.camel.support.DefaultExchange;
import org.apache.camel.test.junit5.CamelTestSupport;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class ExtendedHeaderFilterStrategyTest extends CamelTestSupport {

    private static final String singleLine = "this is a single line string";
    private static final String multiLine = "this string\nhas multiple\nlines!";

    private static final CamelContext context = new DefaultCamelContext();
    private static final ExtendedHeaderFilterStrategy strategy = new ExtendedHeaderFilterStrategy();

    @Test
    public void allowsAllHeadersForInboundEmail() {
        Assertions.assertFalse(strategy.extendedFilter(HeaderFilterStrategy.Direction.IN, "key", singleLine, new DefaultExchange(context)));
        Assertions.assertFalse(strategy.extendedFilter(HeaderFilterStrategy.Direction.IN, "key", multiLine, new DefaultExchange(context)));
    }

    @Test
    public void disregardsOnlyMultilineHeadersForOutboundEmail() {
        Assertions.assertFalse(strategy.extendedFilter(HeaderFilterStrategy.Direction.OUT, "key", singleLine, new DefaultExchange(context)));
        Assertions.assertTrue(strategy.extendedFilter(HeaderFilterStrategy.Direction.OUT, "key", multiLine, new DefaultExchange(context)));
    }
}