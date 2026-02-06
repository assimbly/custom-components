package org.assimbly.sandbox.executors;

import groovy.lang.Binding;
import groovy.lang.GroovyClassLoader;
import groovy.lang.GroovyShell;
import org.apache.camel.Exchange;
import org.apache.camel.RuntimeCamelException;
import org.assimbly.sandbox.SandboxSecurityManager;

import java.util.UUID;
import java.util.regex.Pattern;

public class GroovySandboxExecutor {

    private static final Pattern BLACKLIST_PATTERN = Pattern.compile(
            "(?:System|TimeZone|Locale|Authenticator|CookieHandler|ProxySelector)\\.setDefault\\s*\\(" +
                    "|System\\.exit" +
                    "|System\\.set(?:Property|Out|Err|In|SecurityManager)"
    );

    public static void execute(String script, Exchange exchange) throws Exception {

        // 1. Fail fast check
        if (script != null && BLACKLIST_PATTERN.matcher(script).find()) {
            throw new RuntimeCamelException("Security Violation: Script contains forbidden global state changes.");
        }

        // 2. Setup Isolated ClassLoader
        ClassLoader currentLoader = Thread.currentThread().getContextClassLoader();
        ClassLoader filteredParent = new ClassLoader(ClassLoader.getPlatformClassLoader()) {
            @Override
            protected Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException {
                if (name.startsWith("java.") || name.startsWith("javax.") ||
                        name.startsWith("groovy.") || name.startsWith("org.codehaus.groovy.")) {
                    return currentLoader.loadClass(name);
                }
                throw new ClassNotFoundException("Sandbox Access Denied: " + name);
            }
        };

        try (GroovyClassLoader isolatedLoader = new GroovyClassLoader(filteredParent)) {
            Binding binding = new Binding();
            binding.setVariable("request", exchange.getIn());
            binding.setVariable("exchange", exchange);

            GroovyShell shell = new GroovyShell(isolatedLoader, binding);
            UUID uuid = UUID.randomUUID();
            SandboxSecurityManager.getInstance().secure(uuid);

            try {
                // Execute and handle result with your validated logic
                Object result = shell.evaluate(script);

                if (result != null) {
                    exchange.getIn().setBody(result);
                } else if (binding.hasVariable("result")) {
                    exchange.getIn().setBody(binding.getVariable("result"));
                }
            } finally {
                SandboxSecurityManager.getInstance().unsecure(uuid);
            }
        }
    }
}