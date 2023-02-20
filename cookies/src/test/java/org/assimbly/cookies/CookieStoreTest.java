package org.assimbly.cookies;

import org.apache.camel.Exchange;
import org.apache.camel.support.DefaultExchange;
import org.apache.http.cookie.Cookie;
import org.apache.camel.test.junit5.CamelTestSupport;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class CookieStoreTest extends CamelTestSupport {

    private CookieStore flowCookieStore;
    private Exchange exchange;

    @BeforeEach
    public void Setup(){
        flowCookieStore = new CookieStore();
        exchange = new DefaultExchange(context);
    }

    @Test
    public void addCookieAsStringTest(){
        flowCookieStore.addStringAsCookie(
                exchange,
                "Cookie 1",
                "Value 1",
                "org.assimbly",
                "",
                false
        );

        assertEquals(1, flowCookieStore.getCookies().size());

        Cookie actual = flowCookieStore.getCookies().get(0);

        assertEquals("Cookie 1", actual.getName());
        assertEquals("Value 1", actual.getValue());
        assertEquals("org.assimbly", actual.getDomain());
    }

    @Test
    public void replaceCookieOnExistingEntryTest(){
        flowCookieStore.addStringAsCookie(
                exchange,
                "Cookie 1",
                "Value 1",
                "org.assimbly",
                "",
                false
        );

        flowCookieStore.addStringAsCookie(
                exchange,
                "Cookie 1",
                "Value 2",
                "org.assimbly",
                "",
                false
        );

        assertEquals(1, flowCookieStore.getCookies().size());

        Cookie actual = flowCookieStore.getCookies().get(0);

        assertEquals("Value 2", actual.getValue());
    }

    @Test
    public void addCookieWithSameNameDifferentDomainTest(){
        flowCookieStore.addStringAsCookie(
                exchange,
                "Cookie 1",
                "Value 1",
                "org.assimbly",
                "",
                false
        );

        flowCookieStore.addStringAsCookie(
                exchange,
                "Cookie 1",
                "Value 2",
                "kabisa.nl",
                "",
                false
        );

        assertEquals(2, flowCookieStore.getCookies().size());
    }

    @Test
    public void removeCookieAsStringTest(){
        flowCookieStore.addStringAsCookie(
                exchange,
                "Cookie 1",
                "Value 1",
                "org.assimbly",
                "",
                false
        );

        assertEquals(1, flowCookieStore.getCookies().size());

        flowCookieStore.removeStringAsCookie(new DefaultExchange(context), "Cookie 1", "org.assimbly");

        assertEquals(0, flowCookieStore.getCookies().size());
    }

    @Test
    public void removeCookieWithoutDomainTest(){
        flowCookieStore.addStringAsCookie(
                exchange,
                "Cookie 1",
                "Value 1",
                "org.assimbly",
                "",
                false
        );

        flowCookieStore.addStringAsCookie(
                exchange,
                "Cookie 1",
                "Value 1",
                "",
                "",
                false
        );

        assertEquals(2, flowCookieStore.getCookies().size());

        flowCookieStore.removeStringAsCookie(new DefaultExchange(context), "Cookie 1");

        assertEquals(1, flowCookieStore.getCookies().size());
    }

    @Test
    public void AddCookieWithHeadersTest(){
        exchange.getIn().setHeader("key", "Cookie 1");
        exchange.getIn().setHeader("value", "Value 1");
        exchange.getIn().setHeader("domain", "org.assimbly");
        exchange.getIn().setHeader("path", "/flowmanager");

        flowCookieStore.addStringAsCookie(
                exchange,
                "${header.key}",
                "${header.value}",
                "${header.domain}",
                "${header.path}",
                false
        );

        assertEquals(1, flowCookieStore.getCookies().size());

        Cookie actual = flowCookieStore.getCookies().get(0);

        assertEquals("Cookie 1", actual.getName());
        assertEquals("Value 1", actual.getValue());
        assertEquals("org.assimbly", actual.getDomain());
        assertEquals("/flowmanager", actual.getPath());
    }

}
