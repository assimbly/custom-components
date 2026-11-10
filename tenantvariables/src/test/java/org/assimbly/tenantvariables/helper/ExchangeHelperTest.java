package org.assimbly.tenantvariables.helper;

import org.apache.camel.Exchange;
import org.apache.camel.support.DefaultExchange;
import org.apache.camel.impl.DefaultCamelContext;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ExchangeHelperTest {

    private final Exchange exchange = new DefaultExchange(new DefaultCamelContext());

    @Test
    void detectsHeaderAndBodyVariables() {
        assertTrue(ExchangeHelper.hasVariables("a ${header.x} b"));
        assertTrue(ExchangeHelper.hasVariables("a ${headers.x} b"));
        assertTrue(ExchangeHelper.hasVariables("${body}"));
        assertTrue(ExchangeHelper.hasVariables("${bodyAs(String)}"));
        assertFalse(ExchangeHelper.hasVariables("plain text"));
    }

    @Test
    void interpolatesHeaderAndBody() {
        exchange.getIn().setHeader("name", "John");
        exchange.getIn().setBody("Hello");

        assertEquals("Hello John!", ExchangeHelper.interpolate("${body} ${header.name}!", exchange));
    }

    @Test
    void leavesUnknownHeaderUntouched() {
        assertEquals("${header.missing}", ExchangeHelper.interpolate("${header.missing}", exchange));
    }

    @Test
    void keepsDollarSignInReplacedValue() {
        exchange.getIn().setBody("Thi$ body has dollar");

        assertEquals("Thi$ body has dollar", ExchangeHelper.interpolate("${body}", exchange));
    }

    @Test
    void unescapesNewlinesAndTabsInReplacedValue() {
        exchange.getIn().setBody("a\\nb\\tc");

        assertEquals("a\nb\tc", ExchangeHelper.interpolate("${body}", exchange));
    }

    @Test
    void returnsNullForNullText() {
        assertNull(ExchangeHelper.interpolate(null, exchange));
    }
}
