package org.assimbly.oauth2token;

import org.apache.camel.spi.UriParam;
import org.apache.camel.spi.UriParams;
import org.apache.camel.spi.UriPath;

@UriParams
public class OAuth2TokenConfiguration {

    @UriPath
    private String id;

    @UriParam
    private String tenantDbName;

    @UriParam
    private String expiryDelay;

    @UriParam
    private String tokenName;

    public OAuth2TokenConfiguration() {
        // Used for serialization or reflection
    }

    public OAuth2TokenConfiguration(OAuth2TokenConfiguration source) {
        this.id           = source.id;
        this.tenantDbName = source.tenantDbName;
        this.expiryDelay  = source.expiryDelay;
        this.tokenName    = source.tokenName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTenantDbName() {
        return tenantDbName;
    }

    public void setTenantDbName(String tenantDbName) {
        this.tenantDbName = tenantDbName;
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