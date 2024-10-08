package org.assimbly.oauth2token;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.commons.lang3.StringUtils;
import org.assimbly.oauth2token.tenant.TenantVariableManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.assimbly.tenantvariables.TenantVariablesProcessor;
import org.assimbly.oauth2token.service.TokenService;

import java.util.Calendar;

public class OAuth2TokenProcessor implements Processor {

    private static final Logger logger = LoggerFactory.getLogger(OAuth2TokenProcessor.class);

    private OAuth2TokenEndpoint endpoint;

    public static int EXPIRY_DELAY_DEFAULT = -25;

    public OAuth2TokenProcessor() {}

    public OAuth2TokenProcessor(OAuth2TokenEndpoint endpoint) {
        this.endpoint = endpoint;
    }

    @Override
    public void process(Exchange exchange) {
        String environment = TenantVariablesProcessor.getEnvironment();

        String id = endpoint.getConfiguration().getId();
        String tenant = endpoint.getConfiguration().getTenant();
        String expiryDelay = endpoint.getConfiguration().getExpiryDelay();
        String tokenName = endpoint.getConfiguration().getTokenName();

        String expireDateVarName = TokenService.OAUTH2_PREFIX + id + TokenService.OAUTH2_EXPIRE_DATE_SUFFIX;
        String accessTokenVarName = TokenService.OAUTH2_PREFIX + id + TokenService.OAUTH2_ACCESS_TOKEN_SUFFIX;
        String refreshFlagVarName = TokenService.OAUTH2_PREFIX + id + TokenService.OAUTH2_REFRESH_FLAG_SUFFIX;

        // check if there's a tenant variable inside tenantVar, and return real value
        String expireDate = TenantVariableManager.getTenantVariableValue(expireDateVarName, tenant, environment);
        String accessToken = TenantVariableManager.getTenantVariableValue(accessTokenVarName, tenant, environment);
        String refreshFlag = TenantVariableManager.getTenantVariableValue(refreshFlagVarName, tenant, environment);
        String tokenTenantVarValue = TenantVariableManager.discoverAndGetTenantVariableValue(tokenName, tenant, environment);

        Calendar expireCal = Calendar.getInstance();
        Calendar expireDelayCal = Calendar.getInstance();
        Calendar nowCal = Calendar.getInstance();

        try {
            // expire date vars
            long expireDateLong = Long.parseLong(expireDate);
            expireCal.setTimeInMillis(expireDateLong);
            expireDelayCal = (Calendar) expireCal.clone();
            int expiryDelayInt = EXPIRY_DELAY_DEFAULT;
            try {
                expiryDelayInt = - Integer.parseInt(expiryDelay);
            } catch (Exception e) {
                logger.warn("Failed to parse expiryDelay value. Default value is "+expiryDelayInt);
            }
            expireDelayCal.add(Calendar.SECOND, expiryDelayInt);
        } catch (Exception e) {
            logger.error("ERROR to calculate/set expire date vars", e);
        }

        if(StringUtils.isEmpty(tokenTenantVarValue) ||
                nowCal.after(expireCal) || (
                nowCal.before(expireCal) && nowCal.after(expireDelayCal) && refreshFlag.equals("0"))
        ) {
            // get new access token from service
            String accessTokenOld = accessToken;
            accessToken = TokenService.refreshTokenInfo(id, environment, tenant);
            if(accessToken!=null && (!accessToken.equals(accessTokenOld) || StringUtils.isEmpty(tokenTenantVarValue))) {
                // add token to tenant variable
                TenantVariableManager.discoverAndSaveTenantVariable(tokenName, accessToken, tenant, environment);
            }
        }

        if(!TenantVariableManager.isStaticTenantVariable(tokenName)) {
            // add token to the header
            exchange.getOut().setHeader(tokenName, accessToken);
        }
    }

}
