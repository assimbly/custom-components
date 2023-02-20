package org.assimbly.oauth2token;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.assimbly.globalvariables.GlobalVariablesProcessor;
import org.assimbly.globalvariables.domain.GlobalEnvironmentVariable;
import org.assimbly.globalvariables.mongo.MongoDaoImpl;
import org.assimbly.oauth2token.service.TokenService;
import org.assimbly.oauth2token.utils.GlobalEnvironmentUtils;

import java.util.Calendar;

public class OAuth2TokenProcessor implements Processor {

    protected Logger logger = LoggerFactory.getLogger(getClass());

    private OAuth2TokenEndpoint endpoint;

    public static int EXPIRY_DELAY_DEFAULT = -25;

    public OAuth2TokenProcessor() {}

    public OAuth2TokenProcessor(OAuth2TokenEndpoint endpoint) {
        this.endpoint = endpoint;
    }

    @Override
    public void process(Exchange exchange) {

        MongoDaoImpl mongoDao = new MongoDaoImpl();

        String environment = GlobalVariablesProcessor.getEnvironment();

        String id = endpoint.getConfiguration().getId();
        String tenant = endpoint.getConfiguration().getTenant();
        String expiryDelay = endpoint.getConfiguration().getExpiryDelay();
        String tokenName = endpoint.getConfiguration().getTokenName();

        String expireDateVarName = TokenService.OAUTH2_PREFIX + id + TokenService.OAUTH2_EXPIRE_DATE_SUFFIX;
        String accessTokenVarName = TokenService.OAUTH2_PREFIX + id + TokenService.OAUTH2_ACCESS_TOKEN_SUFFIX;
        String refreshFlagVarName = TokenService.OAUTH2_PREFIX + id + TokenService.OAUTH2_REFRESH_FLAG_SUFFIX;

        // get global environment variables from a specific id
        GlobalEnvironmentVariable expireDateGlobVar = mongoDao.findVariableByName(expireDateVarName, tenant);
        GlobalEnvironmentVariable accessTokenGlobVar = mongoDao.findVariableByName(accessTokenVarName, tenant);
        GlobalEnvironmentVariable refreshFlagGlobVar = mongoDao.findVariableByName(refreshFlagVarName, tenant);

        // check if there's a global variable inside globalVar, and return real value
        String expireDate = GlobalEnvironmentUtils.getGlobalEnvironmentValue(expireDateGlobVar, mongoDao, tenant, environment);
        String accessToken = GlobalEnvironmentUtils.getGlobalEnvironmentValue(accessTokenGlobVar, mongoDao, tenant, environment);
        String refreshFlag = GlobalEnvironmentUtils.getGlobalEnvironmentValue(refreshFlagGlobVar, mongoDao, tenant, environment);

        // expire date vars
        long expireDateLong = Long.parseLong(expireDate);
        Calendar expireCal = Calendar.getInstance();
        expireCal.setTimeInMillis(expireDateLong);
        Calendar expireDelayCal = (Calendar) expireCal.clone();
        int expiryDelayInt = EXPIRY_DELAY_DEFAULT;
        try {
            expiryDelayInt = - Integer.parseInt(expiryDelay);
        } catch (Exception e) {
            logger.error("ERROR to parse expiryDelay value. Default value is "+expiryDelayInt);
        }
        expireDelayCal.add(Calendar.SECOND, expiryDelayInt);
        Calendar nowCal = Calendar.getInstance();

        // validate expire date
        if(nowCal.after(expireCal) || (
                nowCal.before(expireCal) && nowCal.after(expireDelayCal) && refreshFlag.equals("0"))
        ) {
            // get new access token from service
            accessToken = TokenService.refreshTokenInfo(id, environment, tenant);
        }

        // add token to the header
        exchange.getOut().setHeader(tokenName, accessToken);
        // add token to global-variables
        GlobalEnvironmentUtils.saveGlobalEnvironmentVariable(tokenName, mongoDao, tenant, environment, null, accessToken);

    }
}
