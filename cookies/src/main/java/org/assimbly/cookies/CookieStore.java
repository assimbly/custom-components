package org.assimbly.cookies;

import org.apache.camel.spi.BeanProcessorFactory;
import org.apache.camel.spi.annotations.JdkService;
import org.assimbly.util.helper.ExchangeHelper;
import org.apache.camel.Exchange;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.cookie.BasicClientCookie;

import java.util.List;


@JdkService(BeanProcessorFactory.FACTORY)
public class CookieStore extends BasicCookieStore {

    public void addStringAsCookie(Exchange exchange, String key, String value, String domain, String path, Boolean isSecure){
        key = ExchangeHelper.interpolate(key, exchange);
        value = ExchangeHelper.interpolate(value, exchange);

        BasicClientCookie cookie = new BasicClientCookie(key, value);

        // Optional setting
        if(!domain.isEmpty()) {
            domain = ExchangeHelper.interpolate(domain, exchange);
            cookie.setDomain(domain);
        }

        // Optional setting
        if(!path.isEmpty()) {
            path = ExchangeHelper.interpolate(path, exchange);
            cookie.setPath(path);
        }

        // Secure is a boolean and therefor mandatory
        cookie.setSecure(isSecure);

        // Remove cookie if the name already exists
        if(domain.isEmpty())
            removeStringAsCookie(exchange, key);
        else
            removeStringAsCookie(exchange, key, domain);

        super.addCookie(cookie);
    }

    public void removeStringAsCookie(Exchange exchange, String key) {
        // Interpolate key
        key = ExchangeHelper.interpolate(key, exchange);

        List<Cookie> cookies = super.getCookies();

        for (Cookie cookie: super.getCookies()) {
            if (cookie.getName().equals(key) && cookie.getDomain() == null) {
                cookies.remove(cookie);
            }
        }

        super.clear();

        super.addCookies(cookies.toArray(new Cookie[cookies.size()]));
    }

    public void removeStringAsCookie(Exchange exchange, String key, String domain){
        // Interpolate key
        key = ExchangeHelper.interpolate(key, exchange);
        domain = ExchangeHelper.interpolate(domain, exchange);

        List<Cookie> cookies = super.getCookies();

        for (Cookie cookie: super.getCookies()) {
            if (cookie.getName().equals(key) && cookie.getDomain().equals(domain)) {
                cookies.remove(cookie);
            }
        }

        super.clear();

        super.addCookies(cookies.toArray(new Cookie[cookies.size()]));
    }

}
