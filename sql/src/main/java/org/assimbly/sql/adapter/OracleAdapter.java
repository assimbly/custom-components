package org.assimbly.sql.adapter;

import oracle.jdbc.OracleDriver;
import org.assimbly.sql.domain.JDBCConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class OracleAdapter implements DatabaseAdapter {

    private static volatile boolean registered;

    @Override
    public Connection connect(JDBCConnection connection) throws SQLException {
        OracleDriver driver = new OracleDriver();

        String url = String.format("jdbc:oracle:thin:@%s:%s/%s",
                connection.getHost(), connection.getPort(), connection.getDatabase());

        //TODO: Figure out how SSL is configured in Oracle JDBC Connection String

        DriverManager.setLoginTimeout(5);
        if(!registered) {
            DriverManager.registerDriver(driver);
            registered = true;
        }

        return DriverManager.getConnection(url, connection.getUsername(), connection.getPassword());
    }
}
