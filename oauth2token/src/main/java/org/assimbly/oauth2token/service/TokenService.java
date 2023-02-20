package org.assimbly.oauth2token.service;

import org.apache.log4j.Logger;
import org.assimbly.util.exception.OAuth2TokenException;
import org.json.JSONObject;
import org.assimbly.auth.endpoint.annotation.Secured;
import org.assimbly.globalvariables.GlobalVariablesProcessor;
import org.assimbly.globalvariables.domain.GlobalEnvironmentVariable;
import org.assimbly.globalvariables.mongo.MongoDaoImpl;
import org.assimbly.oauth2token.utils.GlobalEnvironmentUtils;

import javax.ws.rs.*;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;

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

    private static String SERVICE_PARAM_EXPIRES_IN = "expires_in";
    private static String SERVICE_PARAM_ACCESS_TOKEN = "access_token";
    private static String SERVICE_PARAM_REFRESH_TOKEN = "refresh_token";
    private static String SERVICE_PARAM_ERROR = "error";
    private static String SERVICE_PARAM_ERROR_DESCRIPTION = "error_description";

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

        MongoDaoImpl mongoDao = new MongoDaoImpl();
        Map<String, String> tokenInfoMap = new HashMap<>();

        tenant = tenant.toLowerCase();
        String environment = GlobalVariablesProcessor.getEnvironment();

        // specific global environment variables names
        String uriTokenVarName = OAUTH2_PREFIX + id + OAUTH2_URI_TOKEN_SUFFIX;
        String scopeVarName = OAUTH2_PREFIX + id + OAUTH2_SCOPE_SUFFIX;
        String clientIdVarName = OAUTH2_PREFIX + id + OAUTH2_CLIENT_ID_SUFFIX;
        String clientSecretVarName = OAUTH2_PREFIX + id + OAUTH2_CLIENT_SECRET_SUFFIX;
        String expireDateVarName = OAUTH2_PREFIX + id + OAUTH2_EXPIRE_DATE_SUFFIX;
        String accessTokenVarName = OAUTH2_PREFIX + id + OAUTH2_ACCESS_TOKEN_SUFFIX;
        String refreshTokenVarName = OAUTH2_PREFIX + id + OAUTH2_REFRESH_TOKEN_SUFFIX;
        String refreshFlagVarName = OAUTH2_PREFIX + id + OAUTH2_REFRESH_FLAG_SUFFIX;
        String redirectUriVarName = OAUTH2_PREFIX + id + OAUTH2_REDIRECT_URI_SUFFIX;

        // get global environment variables from a specific id
        GlobalEnvironmentVariable uriTokenGlobVar = mongoDao.findVariableByName(uriTokenVarName, tenant);
        GlobalEnvironmentVariable scopeGlobVar = mongoDao.findVariableByName(scopeVarName, tenant);
        GlobalEnvironmentVariable clientIdGlobVar = mongoDao.findVariableByName(clientIdVarName, tenant);
        GlobalEnvironmentVariable clientSecretGlobVar = mongoDao.findVariableByName(clientSecretVarName, tenant);
        GlobalEnvironmentVariable redirectUriGlobVar = mongoDao.findVariableByName(redirectUriVarName, tenant);

        // check if there's a global variable inside globalVar, and return real value
        String clientId = GlobalEnvironmentUtils.getGlobalEnvironmentValue(clientIdGlobVar, mongoDao, tenant, environment);
        String clientSecret = GlobalEnvironmentUtils.getGlobalEnvironmentValue(clientSecretGlobVar, mongoDao, tenant, environment);
        String scope = GlobalEnvironmentUtils.getGlobalEnvironmentValue(scopeGlobVar, mongoDao, tenant, environment);
        String redirectUri = GlobalEnvironmentUtils.getGlobalEnvironmentValue(redirectUriGlobVar, mongoDao, tenant, environment);
        String uriToken = GlobalEnvironmentUtils.getGlobalEnvironmentValue(uriTokenGlobVar, mongoDao, tenant, environment);

        // prepare data to send
        String urlParameters  = "client_id="+clientId+
                (scope!=null && !scope.trim().equals("") ? "&scope="+scope : "")+
                "&redirect_uri="+redirectUri+
                "&grant_type=authorization_code"+
                "&client_secret="+clientSecret+
                "&code="+code;

        // call service
        callService(tokenInfoMap, uriToken, urlParameters);

        // save token info into global vars
        GlobalEnvironmentUtils.saveGlobalEnvironmentVariable(
                expireDateVarName,
                mongoDao,
                tenant,
                environment,
                tokenInfoMap,
                SERVICE_PARAM_EXPIRES_IN
        );
        GlobalEnvironmentUtils.saveGlobalEnvironmentVariable(
                accessTokenVarName,
                mongoDao,
                tenant,
                environment,
                tokenInfoMap,
                SERVICE_PARAM_ACCESS_TOKEN
        );
        GlobalEnvironmentUtils.saveGlobalEnvironmentVariable(
                refreshTokenVarName,
                mongoDao,
                tenant,
                environment,
                tokenInfoMap,
                SERVICE_PARAM_REFRESH_TOKEN
        );

        // set refresh flag to inactive
        GlobalEnvironmentUtils.setRefreshFlagGlobalEnvironmentVariable(refreshFlagVarName, mongoDao, tenant, environment, "0");

        // return token info hashmap
        return tokenInfoMap;
    }

    // call service to refresh token information
    public static String refreshTokenInfo(String id, String environment, String tenant) {

        MongoDaoImpl mongoDao = new MongoDaoImpl();
        Map<String, String> tokenInfoMap = new HashMap<>();

        // specific global environment variables names
        String uriTokenVarName = OAUTH2_PREFIX + id + OAUTH2_URI_TOKEN_SUFFIX;
        String scopeVarName = OAUTH2_PREFIX + id + OAUTH2_SCOPE_SUFFIX;
        String clientIdVarName = OAUTH2_PREFIX + id + OAUTH2_CLIENT_ID_SUFFIX;
        String clientSecretVarName = OAUTH2_PREFIX + id + OAUTH2_CLIENT_SECRET_SUFFIX;
        String expireDateVarName = OAUTH2_PREFIX + id + OAUTH2_EXPIRE_DATE_SUFFIX;
        String accessTokenVarName = OAUTH2_PREFIX + id + OAUTH2_ACCESS_TOKEN_SUFFIX;
        String refreshTokenVarName = OAUTH2_PREFIX + id + OAUTH2_REFRESH_TOKEN_SUFFIX;
        String refreshFlagVarName = OAUTH2_PREFIX + id + OAUTH2_REFRESH_FLAG_SUFFIX;
        String redirectUriVarName = OAUTH2_PREFIX + id + OAUTH2_REDIRECT_URI_SUFFIX;

        try {
            // set refresh flag to active
            GlobalEnvironmentUtils.setRefreshFlagGlobalEnvironmentVariable(refreshFlagVarName, mongoDao, tenant, environment, "1");

            // get global environment variables from a specific clientId
            GlobalEnvironmentVariable uriTokenGlobVar = mongoDao.findVariableByName(uriTokenVarName, tenant);
            GlobalEnvironmentVariable scopeGlobVar = mongoDao.findVariableByName(scopeVarName, tenant);
            GlobalEnvironmentVariable clientIdGlobVar = mongoDao.findVariableByName(clientIdVarName, tenant);
            GlobalEnvironmentVariable clientSecretGlobVar = mongoDao.findVariableByName(clientSecretVarName, tenant);
            GlobalEnvironmentVariable refreshTokenGlobVar = mongoDao.findVariableByName(refreshTokenVarName, tenant);
            GlobalEnvironmentVariable redirectUriGlobVar = mongoDao.findVariableByName(redirectUriVarName, tenant);

            // check if there's a global variable inside globalVar, and return real value
            String clientId = GlobalEnvironmentUtils.getGlobalEnvironmentValue(clientIdGlobVar, mongoDao, tenant, environment);
            String clientSecret = GlobalEnvironmentUtils.getGlobalEnvironmentValue(clientSecretGlobVar, mongoDao, tenant, environment);
            String scope = GlobalEnvironmentUtils.getGlobalEnvironmentValue(scopeGlobVar, mongoDao, tenant, environment);
            String redirectUri = GlobalEnvironmentUtils.getGlobalEnvironmentValue(redirectUriGlobVar, mongoDao, tenant, environment);
            String refreshToken = GlobalEnvironmentUtils.getGlobalEnvironmentValue(refreshTokenGlobVar, mongoDao, tenant, environment);
            String uriToken = GlobalEnvironmentUtils.getGlobalEnvironmentValue(uriTokenGlobVar, mongoDao, tenant, environment);

            // prepare data to send
            String urlParameters  = "client_id="+clientId+
                    (scope!=null && !scope.trim().equals("") ? "&scope="+scope : "")+
                    "&redirect_uri="+redirectUri+
                    "&grant_type=refresh_token"+
                    "&client_secret="+clientSecret+
                    "&refresh_token="+refreshToken;

            // call service
            callService(tokenInfoMap, uriToken, urlParameters);

            // save token info into global vars
            GlobalEnvironmentUtils.saveGlobalEnvironmentVariable(
                    expireDateVarName,
                    mongoDao,
                    tenant,
                    environment,
                    tokenInfoMap,
                    SERVICE_PARAM_EXPIRES_IN
            );
            GlobalEnvironmentUtils.saveGlobalEnvironmentVariable(
                    accessTokenVarName,
                    mongoDao,
                    tenant,
                    environment,
                    tokenInfoMap,
                    SERVICE_PARAM_ACCESS_TOKEN
            );
            GlobalEnvironmentUtils.saveGlobalEnvironmentVariable(
                    refreshTokenVarName,
                    mongoDao,
                    tenant,
                    environment,
                    tokenInfoMap,
                    SERVICE_PARAM_REFRESH_TOKEN
            );

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // set refresh flag to inactive
            GlobalEnvironmentUtils.setRefreshFlagGlobalEnvironmentVariable(refreshFlagVarName, mongoDao, tenant, environment, "0");
        }

        // return new access token
        return tokenInfoMap.get(SERVICE_PARAM_ACCESS_TOKEN);
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

            BufferedReader reader = new BufferedReader(new InputStreamReader(stream, "UTF-8"), 8);
            tokenInfoResp = reader.readLine();

            if (tokenInfoResp != null) {
                JSONObject tokenInfoJson = new JSONObject(tokenInfoResp);
                if (!tokenInfoJson.isNull(SERVICE_PARAM_ERROR)) {
                    String error = tokenInfoJson.getString(SERVICE_PARAM_ERROR);
                    String errorDescription = tokenInfoJson.getString(SERVICE_PARAM_ERROR_DESCRIPTION);
                    throw new OAuth2TokenException(error + " - " + errorDescription);
                } else {
                    // expire_date
                    Calendar nowCal = Calendar.getInstance();
                    int expiresIn = tokenInfoJson.getInt(SERVICE_PARAM_EXPIRES_IN);
                    nowCal.add(Calendar.SECOND, expiresIn);
                    // access_token
                    String accessToken = tokenInfoJson.getString(SERVICE_PARAM_ACCESS_TOKEN);
                    // refresh_token
                    String refreshToken = tokenInfoJson.getString(SERVICE_PARAM_REFRESH_TOKEN);
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
