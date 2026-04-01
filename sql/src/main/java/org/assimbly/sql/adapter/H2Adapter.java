package org.assimbly.sql.adapter;

import org.assimbly.sql.domain.JDBCConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.concurrent.atomic.AtomicBoolean;

public class H2Adapter implements DatabaseAdapter {

    private static final AtomicBoolean registered = new AtomicBoolean(false);

    @Override
    public Connection connect(JDBCConnection connection) throws SQLException {

        // H2 JDBC URL patterns:
        // In-memory: jdbc:h2:mem:testdb
        // File-based: jdbc:h2:file:/data/testdb
        // TCP: jdbc:h2:tcp://localhost/~/test

        String url = buildUrl(connection);
        String user = (connection.getUsername() == null) ? "sa" : connection.getUsername();
        String pass = (connection.getPassword() == null) ? "" : connection.getPassword();

        DriverManager.setLoginTimeout(5);

        if (registered.compareAndSet(false, true)) {
            try {
                DriverManager.registerDriver(new org.h2.Driver());
            } catch (SQLException e) {
                throw new IllegalStateException("Failed to register H2 driver", e);
            }
        }

        return DriverManager.getConnection(
                url,
                user,
                pass
        );
    }

    private String buildUrl(JDBCConnection connection) {

        String host = connection.getHost();

        // If the host is already a full JDBC URL, use it as-is.
        if (host != null && host.startsWith("jdbc:")) {
            return host;
        }

        if (host == null || host.isEmpty()) {
            return "jdbc:h2:mem:" + connection.getDatabase()
                    + ";MODE=MySQL;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE";
        }

        return "jdbc:h2:tcp://%s:%s/%s".formatted(host, connection.getPort(), connection.getDatabase());

    }

    /*
    private String buildUrl(JDBCConnection connection) {
        // Keep it simple and flexible based on your existing model

        // Default to in-memory if no host is provided
        if (connection.getHost() == null || connection.getHost().isEmpty()) {
            return "jdbc:h2:mem:" + connection.getDatabase();
        }

        // TCP mode
        return "jdbc:h2:tcp://%s:%s/%s".formatted(
                connection.getHost(),
                connection.getPort(),
                connection.getDatabase()
        );
    }*/
}