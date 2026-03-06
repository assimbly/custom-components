package org.assimbly.sql.adapter;

import com.informix.jdbc.IfxDriver;
import org.apache.hc.core5.net.URLEncodedUtils;
import org.apache.hc.core5.http.NameValuePair;
import org.apache.hc.core5.http.message.BasicNameValuePair;
import org.apache.hc.core5.net.WWWFormCodec;
import org.assimbly.sql.domain.JDBCConnection;

import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class InformixAdapter implements DatabaseAdapter {

    private static volatile boolean registered;

    @Override
    public Connection connect(JDBCConnection connection) throws SQLException {
        List<NameValuePair> parameters = new ArrayList<>();
        IfxDriver driver = new IfxDriver();

        if(connection.isSecure()) {
            parameters.add(
                    new BasicNameValuePair("sslConnection", "true")
            );
        }

        String query = WWWFormCodec.format(parameters, StandardCharsets.UTF_8);

        String url = "jdbc:informix-sqli://%s:%s/%s:%s".formatted(
                connection.getHost(), connection.getPort(), connection.getDatabase(), query);

        DriverManager.setLoginTimeout(5);
        if(!registered) {
            DriverManager.registerDriver(driver);
            registered = true;
        }

        return DriverManager.getConnection(url, connection.getUsername(), connection.getPassword());
    }
}
