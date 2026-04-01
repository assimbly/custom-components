package org.assimbly.sql.adapter;

import oracle.jdbc.OracleDriver;
import org.assimbly.sql.domain.JDBCConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.concurrent.atomic.AtomicBoolean;

public class OracleAdapter implements DatabaseAdapter {

    private static final AtomicBoolean registered = new AtomicBoolean(false);

    @Override
    public Connection connect(JDBCConnection connection) throws SQLException {
        OracleDriver driver = new OracleDriver();

        String url = "jdbc:oracle:thin:@%s:%s/%s".formatted(
                connection.getHost(), connection.getPort(), connection.getDatabase());

        DriverManager.setLoginTimeout(5);
        if(registered.compareAndSet(false, true)) {
            DriverManager.registerDriver(driver);
        }

        return DriverManager.getConnection(url, connection.getUsername(), connection.getPassword());
    }
}
