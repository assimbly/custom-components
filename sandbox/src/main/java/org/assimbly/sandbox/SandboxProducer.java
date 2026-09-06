package org.assimbly.sandbox;

import org.apache.camel.Exchange;
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

    @Override
    public void process(Exchange exchange) throws Exception {
        UUID uuid = UUID.randomUUID();
        SandboxSecurityManager.getInstance().secure(uuid);
        try {
            super.process(exchange);
        } finally {
            SandboxSecurityManager.getInstance().unsecure(uuid);
        }
    }
}