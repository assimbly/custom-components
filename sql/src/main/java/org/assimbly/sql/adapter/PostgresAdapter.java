package org.assimbly.sql.adapter;

import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.message.BasicNameValuePair;
import org.assimbly.sql.domain.JDBCConnection;

import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PostgresAdapter implements DatabaseAdapter {

    private static volatile boolean registered;

    @Override
    public Connection connect(JDBCConnection connection) throws SQLException {
        List<NameValuePair> parameters = new ArrayList<>();
        org.postgresql.Driver driver = new org.postgresql.Driver();

        if(connection.isSecure()) {
            parameters.add(
                    new BasicNameValuePair("ssl", "true")
            );

            parameters.add(
                    new BasicNameValuePair("sslmode", "require")
            );
        }

        String query = URLEncodedUtils.format(parameters, StandardCharsets.UTF_8);

        String url = String.format("jdbc:postgresql://%s:%s/%s?%s",
                connection.getHost(), connection.getPort(), connection.getDatabase(), query);

        DriverManager.setLoginTimeout(5);
        if(!registered) {
            DriverManager.registerDriver(driver);
            registered = true;
        }

        return DriverManager.getConnection(url, connection.getUsername(), connection.getPassword());
    }
}
