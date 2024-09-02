package org.assimbly.sql;

import org.apache.camel.Exchange;
import org.apache.camel.language.simple.SimpleLanguage;
import org.apache.camel.model.language.SimpleExpression;
import org.apache.camel.spi.Metadata;
import org.apache.camel.spi.UriParam;
import org.apache.camel.spi.UriParams;
import org.apache.camel.spi.UriPath;
import org.apache.commons.lang3.StringUtils;
import org.assimbly.util.helper.Base64Helper;
import org.assimbly.sql.domain.ConnectionType;
import org.assimbly.util.helper.ExchangeHelper;

import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;

@UriParams
public class SqlConfiguration {

    @UriParam
    @Metadata(required = true)
    private String username;

    @UriParam
    @Metadata(required = true)
    private String host;

    @UriParam
    private String instance;

    @UriParam(defaultValue = "3306")
    private String port;

    @UriParam
    @Metadata(required = true, secret = true)
    private String password;

    @UriParam
    @Metadata(required = true)
    private String database;

    @UriParam
    @Metadata(required = true)
    private String query;

    @UriParam
    @Metadata(required = true)
    private String connectionType;

    @UriParam
    @Metadata(required = true,defaultValue = "false")
    private boolean useSSL;

    @UriParam
    @Metadata(required = false)
    private String tlsVersion;

    @UriParam
    @Metadata(required = false,defaultValue = "false")
    private boolean escapeChars;

    public SqlConfiguration() { }

    public void configure(String uri) throws URISyntaxException {
        URI connection = new URI(uri);

        setUsername(connection.getUserInfo());
        setHost(connection.getHost());

        // Set Default
        setPort("3306");
        setUseSSL(false);

        setPort(String.valueOf(connection.getPort()));
    }

    /**
     * Username to login with on the JDBC Connection.
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Host of the Database JDBC Connection.
     */
    public void setHost(String host) {
        this.host = host;
    }

    /**
     * Instance of the Database JDBC Connection.
     */
    public void setInstance(String instance) {
        this.instance = instance;
    }

    /**
     * Optional: Port to use to connect to the Database JDBC Connection.
     * Default: 3306
     */
    public void setPort(String port) {
        this.port = port;
    }

    /**
     * Password with which to login on the JDBC Connection.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Database to logon to.
     */
    public void setDatabase(String database) {
        this.database = database;
    }

    /**
     * Query to execute on the target Database.
     */
    public void setQuery(String query) {
        this.query = query;
    }

    /**
     * Target Connection Type of the JDBC Connection.
     */
    public void setConnectionType(String connectionType) {
        this.connectionType = connectionType;
    }

    /**
     * Target Connection Type of the JDBC Connection.
     */
    public void setEscapeChars(boolean escapeChars) {
        this.escapeChars = escapeChars;
    }

    /**
     * Whether or not the target JDBC Connection uses SSL
     */
    public void setUseSSL(boolean useSSL){
        this.useSSL = useSSL;
    }

    /**
     * TLS Version to use when useSSL is true
     */
    public void setTlsVersion(String tlsVersion){
        this.tlsVersion = tlsVersion;
    }

    public String getUsername(Exchange exchange) {
        return interpolateVar(username, exchange);
    }

    public String getHost(Exchange exchange) {
        return interpolateVar(host, exchange);
    }

    public String getInstance(Exchange exchange) {
        return interpolateVar(instance, exchange);
    }

    public String getPort(Exchange exchange) {
        return interpolateVar(port, exchange);
    }

    public String getPassword(Exchange exchange) {
        String password = Base64Helper.unmarshal(this.password, StandardCharsets.UTF_8);
        return interpolateVar(password, exchange);
    }

    public String getDatabase(Exchange exchange) {
        return interpolateVar(database, exchange);
    }

    public String getQuery() {
        return Base64Helper.unmarshal(this.query, StandardCharsets.UTF_8);
    }

    public ConnectionType getConnectionType() {
        return ConnectionType.valueOf(connectionType.toUpperCase());
    }

    public boolean getUseSSL() {
        return useSSL;
    }

    public String getTlsVersion() {
        return tlsVersion;
    }

    public boolean getEscapeChars() {
        return escapeChars;
    }

    public int escapesNeeded() {

        if (!escapeChars)
            return 0;

        if (connectionType.toLowerCase().contains("mysql"))
            return 2;

        return 1;
    }

    private String interpolateVar(String fieldValue, Exchange exchange) {

        if(StringUtils.isEmpty(fieldValue)) {
            return fieldValue;
        }

        if(SimpleLanguage.hasSimpleFunction(fieldValue)) {
            SimpleExpression simpleExpression = new SimpleExpression(fieldValue);
            fieldValue = simpleExpression.evaluate(exchange, String.class);
        }

        return fieldValue;
    }
}
