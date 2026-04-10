package org.assimbly.cookies;

import org.apache.camel.spi.BeanProcessorFactory;
import org.apache.camel.spi.annotations.JdkService;
import org.apache.hc.client5.http.cookie.Cookie;
import org.apache.hc.client5.http.impl.cookie.BasicClientCookie;
import org.apache.camel.Exchange;
import org.apache.hc.client5.http.cookie.BasicCookieStore;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


@JdkService(BeanProcessorFactory.FACTORY)
public class CookieStore extends BasicCookieStore {

    private static final String HEADER_VARIABLE_REGEX = "\\$\\{headers?\\.(.+?)}";
    private static final String BODY_VARIABLE_REGEX = "\\$\\{body(As\\(String\\))?}";

    public void addStringAsCookie(Exchange exchange, String key, String value, String domain, String path, Boolean isSecure){
        key = interpolate(key, exchange);
        value = interpolate(value, exchange);

        BasicClientCookie cookie = new BasicClientCookie(key, value);

        // Optional setting
        if(!domain.isEmpty()) {
            domain = interpolate(domain, exchange);
            cookie.setDomain(domain);
        }

        // Optional setting
        if(!path.isEmpty()) {
            path = interpolate(path, exchange);
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
        key = interpolate(key, exchange);

        List<Cookie> cookies = super.getCookies();

        for (Cookie cookie: super.getCookies()) {
            if (cookie.getName().equals(key) && cookie.getDomain() == null) {
                cookies.remove(cookie);
            }
        }

        super.clear();

        super.addCookies(cookies.toArray(new Cookie[0]));
    }

    public void removeStringAsCookie(Exchange exchange, String key, String domain){
        // Interpolate key
        key = interpolate(key, exchange);
        domain = interpolate(domain, exchange);

        List<Cookie> cookies = super.getCookies();

        for (Cookie cookie: super.getCookies()) {
            if (cookie.getName().equals(key) && cookie.getDomain().equals(domain)) {
                cookies.remove(cookie);
            }
        }

        super.clear();

        super.addCookies(cookies.toArray(new Cookie[0]));
    }

    static String interpolate(String text, Exchange exchange){
        if(text == null)
            return null;

        for(String regex : Arrays.asList(HEADER_VARIABLE_REGEX, BODY_VARIABLE_REGEX)){
            text = replaceVariables(text, exchange, regex);
        }

        return text;
    }

    static String replaceVariables(String text, Exchange exchange, String regex) {
        StringBuilder stringBuilder = new StringBuilder();
        Matcher m = Pattern.compile(regex).matcher(text);
        while(m.find()) {
            String value;
            switch (regex) {
                case HEADER_VARIABLE_REGEX:
                    value = exchange.getIn().getHeader(m.group(1), String.class);
                    break;
                case BODY_VARIABLE_REGEX:
                    value = exchange.getIn().getBody(String.class);
                    break;
                default:
                    return stringBuilder.toString();
            }
            if(value != null) {
                value = escapeDollarSign(value);
                m.appendReplacement(stringBuilder, unescapeExceptionalCharacters(value));
            }
        }
        m.appendTail(stringBuilder);
        return stringBuilder.toString();
    }

    public static String unescapeExceptionalCharacters(String str) {
        return str.replace("\\n", "\n")
                .replace("\\t", "\t")
                .replace("\\r", "\r");
    }

    static String escapeDollarSign(String str) {
        return str.replace("$", "\\$");
    }


}
