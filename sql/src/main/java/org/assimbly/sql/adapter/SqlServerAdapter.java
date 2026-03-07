package org.assimbly.sql.adapter;

import com.microsoft.sqlserver.jdbc.SQLServerDriver;
import org.apache.commons.lang3.StringUtils;
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
import java.util.concurrent.atomic.AtomicBoolean;

public class SqlServerAdapter implements DatabaseAdapter {

    private static final AtomicBoolean registered = new AtomicBoolean(false);

    @Override
    public Connection connect(JDBCConnection connection) throws SQLException {
        List<NameValuePair> parameters = new ArrayList<>();
        SQLServerDriver driver = new SQLServerDriver();

        if(connection.isSecure()) {
            parameters.add(
                    new BasicNameValuePair("encrypt", "true")
            );
        } else {
            parameters.add(
                    new BasicNameValuePair("encrypt", "false")
            );
        }

        String query = WWWFormCodec.format(parameters, StandardCharsets.UTF_8);
        String instance = StringUtils.isNotEmpty(connection.getInstance()) ? "\\"+connection.getInstance() : "";
        String url = "jdbc:sqlserver://%s%s:%s;DatabaseName=%s;%s".formatted(
                connection.getHost(), instance, connection.getPort(), connection.getDatabase(), query);

        DriverManager.setLoginTimeout(5);
        if(registered.compareAndSet(false, true)) {
            DriverManager.registerDriver(driver);
        }

        return DriverManager.getConnection(url, connection.getUsername(), connection.getPassword());
    }
}
