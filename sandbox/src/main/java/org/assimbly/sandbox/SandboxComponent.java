package org.assimbly.sandbox;

import org.apache.camel.component.language.LanguageComponent;
import org.apache.camel.component.language.LanguageEndpoint;
import org.apache.camel.support.ResourceHelper;
import org.apache.camel.Endpoint;
import org.apache.camel.spi.Language;
import org.apache.camel.util.ObjectHelper;
import org.apache.commons.codec.binary.Base64;

import java.util.Map;

import static java.nio.charset.StandardCharsets.UTF_8;

/**
 * Adds security options to the Apache Camel LanguageComponent which it extends.
 * The code executed by the LanguageComponent is run in an environment which employs a string SecurityManager
 * which disallows most of the vital JVM actions.
 */
public class SandboxComponent extends LanguageComponent {

    public static final String REF = "ref:";

    public SandboxComponent() {
        super();
    }

    /**
     * Override the createEndpoint method to return a custom SandboxEndpoint that extends the default LanguageEndpoint.
     */
    @Override
    protected Endpoint createEndpoint(String uri, String remaining, Map<String, Object> parameters) throws Exception {

        String script = (String) parameters.get("script");

        parameters.remove("script");

        if (ObjectHelper.isEmpty(remaining)) {
            throw new IllegalArgumentException("Illegal syntax. Name of language not given in uri: " + uri);
        }

        Language language = getCamelContext().resolveLanguage(remaining);

        if (script.startsWith(REF)) {
            String ref = script.substring(4);
            script = getCamelContext()
                    .getRegistry()
                    .lookupByNameAndType(ref, String.class);
        }

        LanguageEndpoint endpoint = new LanguageEndpoint(uri, this, language, null, null);
        endpoint.setScript(script);

        SandboxEndpoint sE = copy(endpoint);
        setProperties(sE, parameters);

        return sE;
    }

    /**
     * Create a SandboxEndpoint with the properties of the given Endpoint.
     *
     * @param endpoint to get the properties from.
     * @return a new SandboxComponent.
     */
    private static SandboxEndpoint copy(Endpoint endpoint) {
        LanguageEndpoint lE = (LanguageEndpoint) endpoint;
        SandboxEndpoint sE = new SandboxEndpoint(
                lE.getEndpointUri(),
                lE.getComponent(),
                lE.getLanguage(),
                lE.getExpression(),
                lE.getResourceUri());

        sE.setScript(lE.getScript());
        return sE;
    }
}