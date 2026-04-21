package org.assimbly.sandbox.executors;

import groovy.lang.Binding;
import groovy.lang.GroovyShell;
import groovy.lang.Script;
import org.apache.camel.Exchange;
import org.apache.camel.RuntimeCamelException;
import org.codehaus.groovy.control.CompilerConfiguration;
import org.kohsuke.groovy.sandbox.GroovyInterceptor;
import org.kohsuke.groovy.sandbox.SandboxTransformer;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.concurrent.ConcurrentHashMap;

public class GroovySandboxExecutor {

    private GroovySandboxExecutor() {
        // utility class
    }

    private static final CompilerConfiguration CONFIG;
    private static final GroovyShell           SHELL;

    // cache: script source - compiled Class (parse once, run many times)
    private static final ConcurrentHashMap<String, Class<Script>> SCRIPT_CACHE = new ConcurrentHashMap<>();

    static {
        CONFIG = new CompilerConfiguration();
        CONFIG.addCompilationCustomizers(new SandboxTransformer());
        SHELL = new GroovyShell(CONFIG);
    }

    // interceptor
    private static final GroovyInterceptor INTERCEPTOR = new GroovyInterceptor() {

        @Override
        public Object onStaticCall(Invoker invoker, Class receiver, String method, Object[] args) throws Throwable {
            if (receiver == System.class && method.equals("exit")) {
                throw new SecurityException("Sandbox Denial: System.exit() is not allowed.");
            }
            if (receiver == java.util.TimeZone.class && method.equals("setDefault")) {
                throw new SecurityException("Sandbox Denial: Cannot change global TimeZone.");
            }
            return invoker.call(receiver, method, args);
        }

        @Override
        public Object onMethodCall(Invoker invoker, Object receiver, String method, Object[] args) throws Throwable {
            if (method.equals("getClass") || method.equals("class")) {
                throw new SecurityException("Sandbox Denial: Reflection is forbidden.");
            }
            return invoker.call(receiver, method, args);
        }
    };

    public static void execute(String scriptSource, Exchange exchange) {

        // compile once, reuse on subsequent calls with the same source
        Class<Script> scriptClass = getOrCompile(scriptSource);

        // instantiate a fresh Script object — cheap, no classloading
        Script script;

        try {
            script = scriptClass.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            throw new RuntimeCamelException("Failed to instantiate Groovy script", e);
        }

        // bind exchange variables to this specific execution
        Binding binding = new Binding();
        binding.setVariable("exchange", exchange);
        binding.setVariable("body",     exchange.getIn().getBody());
        binding.setVariable("headers",  exchange.getIn().getHeaders());
        binding.setVariable("request",  exchange.getIn());
        binding.setVariable("message",  exchange.getIn());
        script.setBinding(binding);

        // run with sandbox interceptor active for this thread
        INTERCEPTOR.register();
        try {
            Object result = script.run();
            if (result != null) {
                exchange.getIn().setBody(result);
            }
        } catch (Throwable e) {
            throw new RuntimeCamelException("Groovy Sandbox violation: " + e.getMessage(), e);
        } finally {
            INTERCEPTOR.unregister();        // always clean up thread-local registration
        }
    }

    @SuppressWarnings("unchecked")
    private static Class<Script> getOrCompile(String source) {

        // 1. Generate a unique hash for the script source
        String scriptKey = hashScript(source);

        // 2. Use the hash as the cache key
        return SCRIPT_CACHE.computeIfAbsent(scriptKey, key -> {
            try {
                return (Class<Script>) SHELL.getClassLoader().parseClass(source);
            } catch (Exception e) {
                throw new RuntimeCamelException("Failed to compile Groovy script", e);
            }
        });
    }

    private static String hashScript(String source) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(source.getBytes(StandardCharsets.UTF_8));
            // Encode to Base64 to get a clean, short String key
            return Base64.getEncoder().encodeToString(hash);
        } catch (NoSuchAlgorithmException e) {
            // SHA-256 is a standard algorithm, this should never happen
            throw new RuntimeCamelException("SHA-256 algorithm not found", e);
        }
    }
}