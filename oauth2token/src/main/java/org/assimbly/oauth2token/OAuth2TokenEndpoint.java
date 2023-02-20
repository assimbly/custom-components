package org.assimbly.oauth2token;

import org.apache.camel.Processor;
import org.apache.camel.spi.UriEndpoint;
import org.apache.camel.spi.UriParam;
import org.apache.camel.support.ProcessorEndpoint;

@UriEndpoint(
        firstVersion = "2.7.1",
        scheme = "oauth2token",
        title = "OAuth2 Token",
        syntax = "oauth2token:name")
public class OAuth2TokenEndpoint extends ProcessorEndpoint {

    @UriParam
    private OAuth2TokenConfiguration configuration;
    private OAuth2TokenComponent component;

    public OAuth2TokenEndpoint(String uri, OAuth2TokenComponent component, OAuth2TokenConfiguration configuration) {
        super(uri, component);

        this.component = component;
        this.configuration = configuration;
    }

    @Override
    protected Processor createProcessor() throws Exception {
        return new OAuth2TokenProcessor(this);
    }

    public OAuth2TokenConfiguration getConfiguration() {
        return configuration;
    }

    @Override
    public OAuth2TokenComponent getComponent() {
        return component;
    }
}