package org.assimbly.sandbox;

import org.apache.camel.Component;
import org.apache.camel.Expression;
import org.apache.camel.Producer;
import org.apache.camel.component.language.LanguageEndpoint;
import org.apache.camel.component.language.LanguageProducer;
import org.apache.camel.spi.Language;

/**
 * Extends the LanguageEndpoint to supply a SandboxProducer instead of the default LanguageEndpoint.
 */
public class SandboxEndpoint extends LanguageEndpoint {

    private boolean strictSecureMode = true;

    public SandboxEndpoint() {
        super();
    }

    public SandboxEndpoint(String endpointUri, Component component, Language language, Expression expression, String resourceUri) {
        super(endpointUri, component, language, expression, resourceUri);
    }

    public boolean isStrictSecureMode() {
        return strictSecureMode;
    }

    public void setStrictSecureMode(boolean strictSecureMode) {
        this.strictSecureMode = strictSecureMode;
    }

    /**
     * Overrides the createProducer method to supply the SandboxProducer.=
     */
    @Override
    public Producer createProducer() throws Exception {
        LanguageProducer lP = (LanguageProducer) super.createProducer();
        return new SandboxProducer(lP.getEndpoint());
    }

}
