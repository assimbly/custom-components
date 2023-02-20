package org.assimbly.oauth2token;

import org.apache.camel.spi.UriParam;
import org.apache.camel.spi.UriParams;
import org.apache.camel.spi.UriPath;

@UriParams
public class OAuth2TokenConfiguration implements Cloneable {

    @UriPath
    private String name;

    @UriParam
    private String id;

    @UriParam
    private String tenant;

    @UriParam
    private String expiryDelay;

    @UriParam
    private String tokenName;


    public OAuth2TokenConfiguration() { }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTenant() {
        return tenant;
    }

    public void setTenant(String tenant) {
        this.tenant = tenant;
    }

    public String getExpiryDelay() {
        return expiryDelay;
    }

    public void setExpiryDelay(String expiryDelay) {
        this.expiryDelay = expiryDelay;
    }

    public String getTokenName() {
        return tokenName;
    }

    public void setTokenName(String tokenName) {
        this.tokenName = tokenName;
    }
}
