package org.assimbly.oauth2token;

import org.apache.camel.Processor;
import org.apache.camel.spi.UriEndpoint;
import org.apache.camel.spi.UriParam;
import org.apache.camel.support.ProcessorEndpoint;

import java.util.Objects;

@UriEndpoint(
        firstVersion = "2.7.1",
        scheme = "oauth2token",
        title = "OAuth2 Token",
        syntax = "oauth2token:name")
public class OAuth2TokenEndpoint extends ProcessorEndpoint {

    @UriParam
    private OAuth2TokenConfiguration configuration;
    private final OAuth2TokenComponent component;

    public OAuth2TokenEndpoint(String uri, OAuth2TokenComponent component, OAuth2TokenConfiguration configuration) {
        super(uri, component);

        this.component = component;
        this.configuration = configuration;
    }

    @Override
    protected Processor createProcessor() {
        return new OAuth2TokenProcessor(this);
    }

    public OAuth2TokenConfiguration getConfiguration() {
        return configuration;
    }

    @Override
    public OAuth2TokenComponent getComponent() {
        return component;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OAuth2TokenEndpoint that)) return false;
        if (!super.equals(o)) return false;
        return Objects.equals(component, that.component);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), component);
    }

}