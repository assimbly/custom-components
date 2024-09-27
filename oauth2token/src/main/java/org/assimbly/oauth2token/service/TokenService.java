package org.assimbly.oauth2token.service;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.assimbly.tenantvariables.mongo.MongoDao;
import org.assimbly.util.exception.OAuth2TokenException;
import org.json.JSONObject;
import org.assimbly.auth.endpoint.annotation.Secured;
import org.assimbly.tenantvariables.TenantVariablesProcessor;

import jakarta.ws.rs.*;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;
import java.util.stream.Collectors;

@Path("/")
@Secured
public class TokenService {

    private static Logger logger = Logger.getLogger(TokenService.class);

    public static String OAUTH2_PREFIX = "oauth2_";
    public static String OAUTH2_URI_TOKEN_SUFFIX = "_uri_token";
    public static String OAUTH2_SCOPE_SUFFIX = "_scope";
    public static String OAUTH2_CLIENT_ID_SUFFIX = "_client_id";
    public static String OAUTH2_CLIENT_SECRET_SUFFIX = "_client_secret";
    public static String OAUTH2_EXPIRE_DATE_SUFFIX = "_expire_date";
    public static String OAUTH2_ACCESS_TOKEN_SUFFIX = "_access_token";
    public static String OAUTH2_REFRESH_TOKEN_SUFFIX = "_refresh_token";
    public static String OAUTH2_REFRESH_FLAG_SUFFIX = "_refresh_flag";
    public static String OAUTH2_REDIRECT_URI_SUFFIX = "_redirect_uri";
    public static String OAUTH2_CREDENTIALS_TYPE_URI_SUFFIX = "_credentials_type";
    public static String OAUTH2_TOKEN_TENANT_VAR_SUFFIX = "_token_global_var";

    private static String SERVICE_PARAM_EXPIRES_IN = "expires_in";
    private static String SERVICE_PARAM_ACCESS_TOKEN = "access_token";
    private static String SERVICE_PARAM_REFRESH_TOKEN = "refresh_token";
    private static String SERVICE_PARAM_ERROR = "error";
    private static String SERVICE_PARAM_ERROR_DESCRIPTION = "error_description";

    private static final String GOOGLE_CLIENT_ID = System.getenv("GOOGLE_CLIENT_ID");
    private static final String GOOGLE_CLIENT_SECRET = System.getenv("GOOGLE_CLIENT_SECRET");
    private static final String CREDENTIALS_TYPE_CUSTOM = "custom";

    // call service to get token information
    @GET
    @Consumes("application/json")
    @Produces("application/json")
    @Path("/info")
    public Map<String, String> tokenInfo(
            @QueryParam("id") String id,
            @QueryParam("tenant") String tenant,
            @QueryParam("code") String code
    ) {
        Map<String, String> tokenInfoMap = new HashMap<>();

        tenant = tenant.toLowerCase();
        String environment = TenantVariablesProcessor.getEnvironment();

        // specific tenant variables names
        String uriTokenVarName = OAUTH2_PREFIX + id + OAUTH2_URI_TOKEN_SUFFIX;
        String scopeVarName = OAUTH2_PREFIX + id + OAUTH2_SCOPE_SUFFIX;
        String clientIdVarName = OAUTH2_PREFIX + id + OAUTH2_CLIENT_ID_SUFFIX;
        String clientSecretVarName = OAUTH2_PREFIX + id + OAUTH2_CLIENT_SECRET_SUFFIX;
        String expireDateVarName = OAUTH2_PREFIX + id + OAUTH2_EXPIRE_DATE_SUFFIX;
        String accessTokenVarName = OAUTH2_PREFIX + id + OAUTH2_ACCESS_TOKEN_SUFFIX;
        String refreshTokenVarName = OAUTH2_PREFIX + id + OAUTH2_REFRESH_TOKEN_SUFFIX;
        String refreshFlagVarName = OAUTH2_PREFIX + id + OAUTH2_REFRESH_FLAG_SUFFIX;
        String redirectUriVarName = OAUTH2_PREFIX + id + OAUTH2_REDIRECT_URI_SUFFIX;
        String credentialsTypeVarName = OAUTH2_PREFIX + id + OAUTH2_CREDENTIALS_TYPE_URI_SUFFIX;
        String tokenTenantVarName = OAUTH2_PREFIX + id + OAUTH2_TOKEN_TENANT_VAR_SUFFIX;

        // check if there's a tenant variable inside tenantVar, and return real value
        String scope = MongoDao.getTenantVariableValue(scopeVarName, tenant, environment);
        String clientId = MongoDao.getTenantVariableValue(clientIdVarName, tenant, environment);
        String clientSecret = MongoDao.getTenantVariableValue(clientSecretVarName, tenant, environment);
        String redirectUri = MongoDao.getTenantVariableValue(redirectUriVarName, tenant, environment);
        String uriToken = MongoDao.getTenantVariableValue(uriTokenVarName, tenant, environment);
        String credentialsType = MongoDao.getTenantVariableValue(credentialsTypeVarName, tenant, environment);
        String tokenTenantVar = MongoDao.getTenantVariableValue(tokenTenantVarName, tenant, environment);

        boolean customCredentialsType = StringUtils.isEmpty(credentialsType) ||
                credentialsType.equals(CREDENTIALS_TYPE_CUSTOM);

        // prepare data to send
        String urlParameters  = "client_id="+(customCredentialsType ? clientId : GOOGLE_CLIENT_ID)+
                (scope!=null && !scope.trim().equals("") ? "&scope="+scope : "")+
                "&redirect_uri="+redirectUri+
                "&grant_type=authorization_code"+
                "&client_secret="+(customCredentialsType ? clientSecret : GOOGLE_CLIENT_SECRET)+
                "&code="+code;

        // call service
        callService(tokenInfoMap, uriToken, urlParameters);

        // save token info into tenant vars
        String expiresIn = tokenInfoMap.get(SERVICE_PARAM_EXPIRES_IN);
        if(expiresIn!=null && !expiresIn.isEmpty()) {
            MongoDao.saveTenantVariable(expireDateVarName, expiresIn, tenant, environment);
        }
        String accessToken = tokenInfoMap.get(SERVICE_PARAM_ACCESS_TOKEN);
        if(accessToken!=null && !accessToken.isEmpty()) {
            MongoDao.saveTenantVariable(accessTokenVarName, accessToken, tenant, environment);
            MongoDao.saveTenantVariable(tokenTenantVar, accessToken, tenant, environment);
        }
        String refreshToken = tokenInfoMap.get(SERVICE_PARAM_REFRESH_TOKEN);
        if(refreshToken!=null && !refreshToken.isEmpty()) {
            MongoDao.saveTenantVariable(refreshTokenVarName, refreshToken, tenant, environment);
        }

        // set refresh flag to inactive
        MongoDao.saveTenantVariable(refreshFlagVarName, "0", tenant, environment);

        // return token info hashmap
        return tokenInfoMap;
    }

    // call service to refresh token information
    public static String refreshTokenInfo(String id, String environment, String tenant) {
        Map<String, String> tokenInfoMap = new HashMap<>();
        String accessToken = null;

        // specific tenant variables names
        String uriTokenVarName = OAUTH2_PREFIX + id + OAUTH2_URI_TOKEN_SUFFIX;
        String scopeVarName = OAUTH2_PREFIX + id + OAUTH2_SCOPE_SUFFIX;
        String clientIdVarName = OAUTH2_PREFIX + id + OAUTH2_CLIENT_ID_SUFFIX;
        String clientSecretVarName = OAUTH2_PREFIX + id + OAUTH2_CLIENT_SECRET_SUFFIX;
        String expireDateVarName = OAUTH2_PREFIX + id + OAUTH2_EXPIRE_DATE_SUFFIX;
        String accessTokenVarName = OAUTH2_PREFIX + id + OAUTH2_ACCESS_TOKEN_SUFFIX;
        String refreshTokenVarName = OAUTH2_PREFIX + id + OAUTH2_REFRESH_TOKEN_SUFFIX;
        String refreshFlagVarName = OAUTH2_PREFIX + id + OAUTH2_REFRESH_FLAG_SUFFIX;
        String redirectUriVarName = OAUTH2_PREFIX + id + OAUTH2_REDIRECT_URI_SUFFIX;
        String credentialsTypeVarName = OAUTH2_PREFIX + id + OAUTH2_CREDENTIALS_TYPE_URI_SUFFIX;

        try {
            // set refresh flag to active
            MongoDao.saveTenantVariable(refreshFlagVarName, "1", tenant, environment);

            // check if there's a tenant variable inside tenantVar, and return real value
            String scope = MongoDao.getTenantVariableValue(scopeVarName, tenant, environment);
            String clientId = MongoDao.getTenantVariableValue(clientIdVarName, tenant, environment);
            String clientSecret = MongoDao.getTenantVariableValue(clientSecretVarName, tenant, environment);
            String redirectUri = MongoDao.getTenantVariableValue(redirectUriVarName, tenant, environment);
            String refreshToken = MongoDao.getTenantVariableValue(refreshTokenVarName, tenant, environment);
            String uriToken = MongoDao.getTenantVariableValue(uriTokenVarName, tenant, environment);
            String credentialsType = MongoDao.getTenantVariableValue(credentialsTypeVarName, tenant, environment);

            boolean customCredentialsType = StringUtils.isEmpty(credentialsType) ||
                    credentialsType.equals(CREDENTIALS_TYPE_CUSTOM);

            // prepare data to send
            String urlParameters  = "client_id="+(customCredentialsType ? clientId : GOOGLE_CLIENT_ID)+
                    (scope!=null && !scope.trim().equals("") ? "&scope="+scope : "")+
                    "&redirect_uri="+redirectUri+
                    "&grant_type=refresh_token"+
                    "&client_secret="+(customCredentialsType ? clientSecret : GOOGLE_CLIENT_SECRET)+
                    "&refresh_token="+refreshToken;

            // call service
            callService(tokenInfoMap, uriToken, urlParameters);

            // save token info into tenant vars
            String expiresInResp = tokenInfoMap.get(SERVICE_PARAM_EXPIRES_IN);
            if(expiresInResp!=null && !expiresInResp.isEmpty()) {
                MongoDao.saveTenantVariable(expireDateVarName, expiresInResp, tenant, environment);
            }
            String accessTokenResp = tokenInfoMap.get(SERVICE_PARAM_ACCESS_TOKEN);
            if(accessTokenResp!=null && !accessTokenResp.isEmpty()) {
                MongoDao.saveTenantVariable(accessTokenVarName, accessTokenResp, tenant, environment);
                accessToken = accessTokenResp;
            }
            String refreshTokenResp = tokenInfoMap.get(SERVICE_PARAM_REFRESH_TOKEN);
            if(refreshTokenResp!=null && !refreshTokenResp.isEmpty()) {
                MongoDao.saveTenantVariable(refreshTokenVarName, refreshTokenResp, tenant, environment);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // set refresh flag to inactive
            MongoDao.saveTenantVariable(refreshFlagVarName, "0", tenant, environment);
        }

        // return new access token
        return accessToken;
    }

    // call service
    private static void callService(
            Map<String, String> tokenInfoMap,
            String uriToken,
            String urlParameters
    ) {

        HttpURLConnection con = null;

        try {
            URL url = null;
            InputStream stream = null;
            String tokenInfoResp = null;

            // prepare connection
            url = new URL(uriToken);
            con = (HttpURLConnection) url.openConnection();
            con.setDoOutput(true);
            con.setInstanceFollowRedirects(false);
            con.setRequestMethod("POST");
            con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            con.setUseCaches(false);

            // get token info from uri_token service
            OutputStreamWriter wr = new OutputStreamWriter(con.getOutputStream());
            wr.write(urlParameters);
            wr.flush();

            int codeResp = con.getResponseCode();
            if (codeResp >= 200 && codeResp < 400) {
                stream = con.getInputStream();
            } else {
                stream = con.getErrorStream();
            }

            BufferedReader reader = new BufferedReader(new InputStreamReader(stream, "UTF-8"));
            tokenInfoResp = reader.lines().collect(Collectors.joining(System.lineSeparator()));

            if (tokenInfoResp != null) {
                JSONObject tokenInfoJson = new JSONObject(tokenInfoResp);
                if (!tokenInfoJson.isNull(SERVICE_PARAM_ERROR)) {
                    logger.info("tokenInfoResp > "+tokenInfoResp);
                    String error = (
                            tokenInfoJson.has(SERVICE_PARAM_ERROR) ? tokenInfoJson.getString(SERVICE_PARAM_ERROR) : ""
                    );
                    String errorDescription = (
                            tokenInfoJson.has(SERVICE_PARAM_ERROR_DESCRIPTION) ?
                                    tokenInfoJson.getString(SERVICE_PARAM_ERROR_DESCRIPTION) : ""
                    );
                    throw new OAuth2TokenException(error + " - " + errorDescription);
                } else {
                    // expire_date
                    Calendar nowCal = Calendar.getInstance();
                    int expiresIn = tokenInfoJson.getInt(SERVICE_PARAM_EXPIRES_IN);
                    nowCal.add(Calendar.SECOND, expiresIn);
                    // access_token
                    String accessToken = tokenInfoJson.getString(SERVICE_PARAM_ACCESS_TOKEN);
                    // refresh_token
                    String refreshToken = tokenInfoJson.optString(SERVICE_PARAM_REFRESH_TOKEN);
                    // add token info into hashmap
                    tokenInfoMap.put(SERVICE_PARAM_EXPIRES_IN, String.valueOf(nowCal.getTimeInMillis()));
                    tokenInfoMap.put(SERVICE_PARAM_ACCESS_TOKEN, accessToken);
                    tokenInfoMap.put(SERVICE_PARAM_REFRESH_TOKEN, refreshToken);
                }
            }

        } catch (IOException e) {
            logger.error("Error calling the service, with the following parameters: "+urlParameters, e);
        } finally {
            if (con != null) {
                con.disconnect();
            }
        }
    }

}
