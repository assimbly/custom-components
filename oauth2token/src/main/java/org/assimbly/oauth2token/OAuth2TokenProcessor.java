package org.assimbly.oauth2token;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.commons.lang3.StringUtils;
import org.assimbly.oauth2token.service.TokenService;
import org.assimbly.oauth2token.tenant.TenantVariableManager;
import org.assimbly.tenantvariables.TenantVariablesProcessor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Instant;
import java.util.Arrays;
import java.util.List;

public class OAuth2TokenProcessor implements Processor {

    private static final Logger logger = LoggerFactory.getLogger(OAuth2TokenProcessor.class);

    public static final int EXPIRY_DELAY_DEFAULT = -25;

    private final OAuth2TokenEndpoint endpoint;

    public OAuth2TokenProcessor(OAuth2TokenEndpoint endpoint) {
        this.endpoint = endpoint;
    }

    @Override
    public void process(Exchange exchange) {
        String environment = TenantVariablesProcessor.getEnvironment();

        String id = endpoint.getConfiguration().getId();
        String tenant = endpoint.getConfiguration().getTenantDbName();
        String expiryDelay = endpoint.getConfiguration().getExpiryDelay();
        String tokenName = endpoint.getConfiguration().getTokenName();

        String expireDateVarName = TokenService.OAUTH2_PREFIX + id + TokenService.OAUTH2_EXPIRE_DATE_SUFFIX;
        String accessTokenVarName = TokenService.OAUTH2_PREFIX + id + TokenService.OAUTH2_ACCESS_TOKEN_SUFFIX;
        String refreshFlagVarName = TokenService.OAUTH2_PREFIX + id + TokenService.OAUTH2_REFRESH_FLAG_SUFFIX;

        // Check if there's a tenant variable inside tenantVar, and return real value
        String expireDate = TenantVariableManager.getTenantVariableValue(
                expireDateVarName, tenant, environment);
        String accessToken = TenantVariableManager.getTenantVariableValue(
                accessTokenVarName, tenant, environment);
        String refreshFlag = TenantVariableManager.getTenantVariableValue(
                refreshFlagVarName, tenant, environment);

        List<String> tokenNames = parseTokenNames(tokenName);
        boolean anyTokenMissing = tokenNames.stream()
                .map(name -> TenantVariableManager.discoverAndGetTenantVariableValue(
                        name, tenant, environment))
                .anyMatch(StringUtils::isEmpty);

        Instant expireTime = Instant.MAX;
        Instant expireDelayTime = Instant.MAX;
        Instant now = Instant.now();

        try {
            long expireDateLong = Long.parseLong(expireDate);
            int expiryDelayInt = getExpiryDelayAsInt(expiryDelay);

            expireTime = Instant.ofEpochMilli(expireDateLong);
            expireDelayTime = expireTime.plusSeconds(expiryDelayInt);

        } catch (Exception e) {
            logger.error("Error calculating expire date variables", e);
        }

        if (anyTokenMissing
                || now.isAfter(expireTime)
                || (now.isBefore(expireTime)
                && now.isAfter(expireDelayTime)
                && "0".equals(refreshFlag))) {

            accessToken = getAccessTokenFromService(
                    accessToken, id, environment, tenant, anyTokenMissing, tokenNames);
        }

        setHeaderWithToken(exchange, tokenNames, accessToken);
    }

    private int getExpiryDelayAsInt(String expiryDelay) {
        try {
            return Integer.parseInt(expiryDelay);
        } catch (Exception _) {
            logger.warn("Failed to parse expiryDelay value. Default value is {}", expiryDelay);
            return EXPIRY_DELAY_DEFAULT;
        }
    }

    private static String getAccessTokenFromService(
            String accessToken,
            String id,
            String environment,
            String tenant,
            boolean anyTokenMissing,
            List<String> tokenNames) {

        // Get new access token from service
        String accessTokenOld = accessToken;
        accessToken = TokenService.refreshTokenInfo(id, environment, tenant);

        if (accessToken != null && (!accessToken.equals(accessTokenOld) || anyTokenMissing)) {
            for (String name : tokenNames) {
                // Add token to tenant variable
                TenantVariableManager.discoverAndSaveTenantVariable(
                        name, accessToken, tenant, environment);
            }
        }

        return accessToken;
    }

    private static void setHeaderWithToken(
            Exchange exchange, List<String> tokenNames, String accessToken) {

        for (String name : tokenNames) {
            if (!TenantVariableManager.isStaticTenantVariable(name)) {
                exchange.getMessage().setHeader(name, accessToken);
            }
        }
    }

    private List<String> parseTokenNames(String tokenName) {
        return Arrays.stream(tokenName.split(","))
                .map(String::trim)
                .filter(StringUtils::isNotEmpty)
                .toList();
    }
}