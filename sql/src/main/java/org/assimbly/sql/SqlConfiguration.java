package org.assimbly.sql;

import org.apache.camel.spi.Metadata;
import org.apache.camel.spi.UriParam;
import org.apache.camel.spi.UriParams;
import org.apache.camel.spi.UriPath;
import org.assimbly.util.helper.Base64Helper;
import org.assimbly.sql.domain.ConnectionType;

import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;

@UriParams
public class SqlConfiguration {

    @UriPath(name = "username")
    @Metadata(required = true)
    private String username;

    @UriPath(name = "host")
    @Metadata(required = true)
    private String host;

    @UriPath(name = "port", defaultValue = "3306")
    private int port;

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
        setPort(3306);
        setUseSSL(false);

        setPort(connection.getPort());
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
     * Optional: Port to use to connect to the Database JDBC Connection.
     * Default: 3306
     */
    public void setPort(int port) {
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

    public String getUsername() {
        return username;
    }

    public String getHost() {
        return host;
    }

    public int getPort() {
        return port;
    }

    public String getPassword() {
        return Base64Helper.unmarshal(password, StandardCharsets.UTF_8);
    }

    public String getDatabase() {
        return database;
    }

    public String getQuery() {
        return Base64Helper.unmarshal(query, StandardCharsets.UTF_8);
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
}
