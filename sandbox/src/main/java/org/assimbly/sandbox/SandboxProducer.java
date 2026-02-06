package org.assimbly.sandbox;

import org.apache.camel.Exchange;
import org.apache.camel.RuntimeCamelException;
import org.apache.camel.component.language.LanguageEndpoint;
import org.apache.camel.component.language.LanguageProducer;

import java.util.UUID;

/**
 * Extends the LanguageProducer to enable the stricter SecurityManager.
 */
public class SandboxProducer extends LanguageProducer {

    public SandboxProducer(LanguageEndpoint endpoint) {
        super(endpoint);
    }

    /**
     * Overrides the process method to enable and disable the custom SecurityManager.
     */
    @Override
    public void process(Exchange exchange) throws Exception {
        UUID uuid = UUID.randomUUID();

        SandboxSecurityManager.getInstance().secure(uuid);

        /*
         * Comment out setting the security manager as it causes the whole JVM to be in a Sandbox
         * and since we run asynchronous flows we do not want that.
         *
         * if(System.getSecurityManager() == null)
         *   System.setSecurityManager(SandboxSecurityManager.getInstance());
         *
         */

        boolean failed = false;

        try {
            super.process(exchange);
        } catch (SecurityException e) {
            failed = true;
        } finally {
            SandboxSecurityManager.getInstance().unsecure(uuid);

            System.setSecurityManager(null);

            if (failed) {
                throw new RuntimeCamelException("Security breach");
            }
        }
    }
}