package org.assimbly.sql.adapter;

import java.util.*;
import org.apache.hc.core5.http.NameValuePair;
import org.apache.hc.core5.http.message.BasicNameValuePair;
import org.apache.hc.core5.net.WWWFormCodec;
import org.assimbly.sql.domain.JDBCConnection;

import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.concurrent.atomic.AtomicBoolean;

public class MysqlAdapter implements DatabaseAdapter {

    private static final AtomicBoolean registered = new AtomicBoolean(false);

    @Override
    public Connection connect(JDBCConnection connection) throws SQLException {
        com.mysql.cj.jdbc.Driver driver = new com.mysql.cj.jdbc.Driver();

        List<NameValuePair> parameters = new ArrayList<>(
                putParameters(
                    new BasicNameValuePair("useLegacyDatetimeCode", "false"),
                    new BasicNameValuePair("serverTimezone", "UTC")
                )
        );

        if(connection.isSecure()) {
            parameters.addAll(
                putParameters(
                    new BasicNameValuePair("verifyServerCertificate", "true"),
                    new BasicNameValuePair("useSSL", "true"),
                    new BasicNameValuePair("requireSSL", "true")
                )
            );

            if(!connection.getEnabledTLSProtocols().isEmpty())
                parameters.add(new BasicNameValuePair("enabledTLSProtocols", connection.getEnabledTLSProtocols()));

        }else{
            parameters.add(new BasicNameValuePair("useSSL", "false"));

            if(this instanceof Mysql8Adapter)
                parameters.add(new BasicNameValuePair("allowPublicKeyRetrieval", "true"));
        }

        String query = WWWFormCodec.format(parameters, StandardCharsets.UTF_8);

        String url = "jdbc:mysql://%s:%s/%s?%s".formatted(
                connection.getHost(), connection.getPort(), connection.getDatabase(), query);

        DriverManager.setLoginTimeout(5);
        if(registered.compareAndSet(false, true)) {
            DriverManager.registerDriver(driver);
        }

        return DriverManager.getConnection(url, connection.getUsername(), connection.getPassword());
    }

    private List<NameValuePair> putParameters(NameValuePair ... pairs) {
        return Arrays.stream(pairs)
                .toList();
    }
}
