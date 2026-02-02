package org.assimbly.sandbox;

import org.apache.camel.Exchange;
import org.apache.camel.RuntimeCamelException;
import org.apache.camel.component.language.LanguageEndpoint;
import org.apache.camel.component.language.LanguageProducer;
import org.codehaus.groovy.ast.expr.MethodCallExpression;
import org.codehaus.groovy.control.CompilerConfiguration;
import org.codehaus.groovy.control.customizers.SecureASTCustomizer;
import groovy.lang.GroovyShell;

import java.net.URI;
import java.util.Arrays;

public class SandboxProducer extends LanguageProducer {

    public SandboxProducer(LanguageEndpoint endpoint) {
        super(endpoint);
    }

    @Override
    public void process(Exchange exchange) throws Exception {
        // Use the URI to determine the language (sandbox://groovy?...)
        String uriString = getEndpoint().getEndpointUri();
        URI javaUri = new URI(uriString);
        String language = javaUri.getHost();

        if ("groovy".equalsIgnoreCase(language)) {
            executeGroovy(exchange);
        } else {
            super.process(exchange);
        }
    }

    private void executeGroovy(Exchange exchange) {
        LanguageEndpoint endpoint = getEndpoint();

        // 1. Get the script from the URI (as defined in your XML)
        String script = endpoint.getScript();

        // If URI didn't have a script, fall back to the Body
        if (script == null || script.isEmpty()) {
            script = exchange.getIn().getBody(String.class);
        }

        // 2. Setup the "Guard" (Customizer)
        SecureASTCustomizer customizer = new SecureASTCustomizer();

        // This blocks TimeZone.setDefault() at the compiler level
        customizer.setDisallowedReceivers(Arrays.asList(
                "java.lang.System",
                "java.lang.Runtime",
                "java.util.TimeZone",
                "java.util.Locale",
                "java.lang.Class",               // Prevents class-loading attacks
                "java.lang.ClassLoader",         // Prevents loading external jars
                "java.lang.Thread",              // Prevents thread manipulation
                "java.lang.ThreadGroup",
                "java.lang.reflect.Method",      // Prevents Reflection escapes
                "java.lang.reflect.Field",
                "java.lang.reflect.Constructor"
        ));

        customizer.addExpressionCheckers(expression -> {
            if (expression instanceof MethodCallExpression) {
                String method = ((MethodCallExpression) expression).getMethodAsString();
                if (Arrays.asList("exit", "halt").contains(method)) {
                    throw new SecurityException("Method call forbidden: " + method);
                }
            }
            return true;
        });

        CompilerConfiguration config = new CompilerConfiguration();
        config.addCompilationCustomizers(customizer);

        // 3. Bind variables so your script works
        GroovyShell shell = new GroovyShell(config);

        // This maps your script's 'request' to the Camel Message
        shell.setProperty("request", exchange.getIn());
        shell.setProperty("exchange", exchange);
        shell.setProperty("headers", exchange.getIn().getHeaders());
        shell.setProperty("body", exchange.getIn().getBody());

        try {
            Object result = shell.evaluate(script);

            // 4. Handle results
            // If script uses 'result = ...', grab it. Otherwise use evaluation result.
            Object scriptResult = shell.getVariable("result");
            if (scriptResult != null) {
                exchange.getIn().setBody(scriptResult);
            } else if (result != null) {
                exchange.getIn().setBody(result);
            }
        } catch (Exception e) {
            throw new RuntimeCamelException("Groovy Sandbox Error: " + e.getMessage(), e);
        }
    }
}