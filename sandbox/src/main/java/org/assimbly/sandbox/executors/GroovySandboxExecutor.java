package org.assimbly.sandbox.executors;

import groovy.lang.Binding;
import groovy.lang.GroovyShell;
import org.apache.camel.Exchange;
import org.apache.camel.RuntimeCamelException;
import org.codehaus.groovy.control.CompilerConfiguration;
import org.kohsuke.groovy.sandbox.GroovyInterceptor;
import org.kohsuke.groovy.sandbox.SandboxTransformer;

public class GroovySandboxExecutor {

    public static void execute(String script, Exchange exchange) {

        CompilerConfiguration config = new CompilerConfiguration();
        config.addCompilationCustomizers(new SandboxTransformer());

        GroovyInterceptor interceptor = new GroovyInterceptor() {
            @Override
            public Object onStaticCall(Invoker invoker, Class receiver, String method, Object[] args) throws Throwable {
                if (receiver == System.class && method.equals("exit")) {
                    throw new SecurityException("Sandbox Denial: System.exit() is not allowed.");
                }
                if (receiver == java.util.TimeZone.class && method.equals("setDefault")) {
                    throw new SecurityException("Sandbox Denial: Cannot change global TimeZone.");
                }
                // Use invoker.call instead of next.call
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

        interceptor.register();
        try {
            Binding binding = new Binding();
            binding.setVariable("exchange", exchange);
            binding.setVariable("body", exchange.getIn().getBody());
            binding.setVariable("headers", exchange.getIn().getHeaders());
            binding.setVariable("request", exchange.getIn());
            binding.setVariable("message", exchange.getIn());

            GroovyShell shell = new GroovyShell(binding, config);
            Object result = shell.evaluate(script);

            if (result != null) {
                exchange.getIn().setBody(result);
            }
        } catch (Throwable e) {
            throw new RuntimeCamelException("Groovy Sandbox violation: " + e.getMessage(), e);
        } finally {
            interceptor.unregister();
        }
    }
}