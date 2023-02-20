package org.assimbly.amazon;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.camel.spi.Metadata;
import org.apache.camel.spi.UriParam;
import org.apache.camel.spi.UriParams;
import org.apache.camel.spi.UriPath;
import org.assimbly.amazon.domain.Amazon;
import org.assimbly.amazon.domain.Marketplace;
import org.assimbly.amazon.domain.Operation;
import org.assimbly.amazon.domain.Region;
import org.assimbly.amazon.exception.MarketplaceNotFoundException;
import org.assimbly.util.helper.Base64Helper;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

@UriParams
public class AmazonConfiguration {

    @UriPath
    @Metadata(required = true)
    private Operation operation;

    @UriParam
    @Metadata(required = true)
    private String accessKey;

    @UriParam
    @Metadata(required = true)
    private String secretKey;

    @UriParam
    private String authToken;

    @UriParam
    @Metadata(required = true)
    private String sellerId;

    @UriParam
    @Metadata(required = true)
    private Marketplace marketplace;

    @UriParam
    private String parameters;

    @UriParam
    private String settings;

    public AmazonConfiguration() { }

    /**
     * Operation to preform on the Amazon Marketplace API.
     */
    public void setOperation(String operation) {
        this.operation = Operation.valueOf(operation);
    }

    /**
     * Access key to use to authenticate on the Amazon Marketplace API.
     */
    public void setAccessKey(String accessKey) {
        this.accessKey = accessKey;
    }

    /**
     * Secret key to use to authenticate on the Amazon Marketplace API.
     */
    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    /**
     * Auth token to use to authenticate on the Amazon Marketplace API.
     */
    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }

    /**
     * Seller id to use to authenticate on the Amazon Marketplace API.
     */
    public void setSellerId(String sellerId) {
        this.sellerId = sellerId;
    }

    /**
     * Region in which the request should be executed.
     */
    public void setMarketplace(String id) throws MarketplaceNotFoundException {
        if(id.equals(Region.NA.toString())) {
            this.marketplace = Amazon.INSTANCE.findMarketPlace(Region.NA);
        } else if(id.equals(Region.EU.toString())) {
            this.marketplace = Amazon.INSTANCE.findMarketPlace(Region.EU);
        } else {
            this.marketplace = Amazon.INSTANCE.findMarketPlace(id);
        }
    }

    /**
     * Parameters to send with the API call.
     */
    public void setParameters(String parameters) {
        this.parameters = parameters;
    }

    /**
     * Additional settings to how the component should interact with Amazon
     */
    public void setSettings(String settings) {
        this.settings = settings;
    }

    public Operation getOperation() {
        return operation;
    }

    public String getAccessKey() {
        return accessKey;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public String getAuthToken() {
        return authToken;
    }

    public String getSellerId() {
        return sellerId;
    }

    public Marketplace getMarketplace() {
        return marketplace;
    }

    public Map<String, String> getParameters() throws IOException {
        if (parameters == null) {
            return new HashMap<>();
        }

        String json = Base64Helper.unmarshal(parameters, StandardCharsets.UTF_8);
        return new ObjectMapper().readValue(json, new TypeReference<HashMap<String, String>>() {});
    }

    public Map<String, String> getSettings() throws IOException {
        if (settings == null) {
            return new HashMap<>();
        }

        String json = Base64Helper.unmarshal(settings, StandardCharsets.UTF_8);
        return new ObjectMapper().readValue(json, new TypeReference<HashMap<String, String>>() {});
    }

    public boolean hasParameters() {
        return this.parameters != null;
    }

    public boolean hasSettings() {
        return this.settings != null;
    }


}
