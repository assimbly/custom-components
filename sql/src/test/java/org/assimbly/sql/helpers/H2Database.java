package org.assimbly.sql.helpers;

import java.sql.*;

public class H2Database {

    public static final String DB_URL = "jdbc:h2:mem:mysql_test;MODE=MySQL;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE";
    public static final String USER   = "sa";
    public static final String PASS   = "";

    /**
     * Explicitly registers the H2 driver with DriverManager.
     * Called at the start of every public method because service-loader
     * auto-registration is not reliable when H2 is on the test classpath only.
     */
    private static void loadDriver() {
        try {
            Class.forName("org.h2.Driver");
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException("H2 driver not found on classpath", e);
        }
    }

    public void create() {
        loadDriver();
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             Statement stmt = conn.createStatement()) {

            // Use fully qualified name just in case
            stmt.executeUpdate("""
                CREATE TABLE IF NOT EXISTS PUBLIC.products (
                    id          INT          NOT NULL AUTO_INCREMENT,
                    name        VARCHAR(255),
                    description VARCHAR(255),
                    price       DECIMAL(7,2),
                    created_at  DATETIME     DEFAULT CURRENT_TIMESTAMP,
                    PRIMARY KEY (id)
                )
                """);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void drop() {
        loadDriver();
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             Statement stmt = conn.createStatement()) {

            stmt.executeUpdate("DROP TABLE IF EXISTS products");
            stmt.executeUpdate("DROP ALIAS IF EXISTS GetAllProducts");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertMockData() {
        loadDriver();
        String sql = """
                INSERT INTO products (id, name, description, price) VALUES
                    (1, 'Product Name 1', 'Description 1', 19.99),
                    (2, 'Product Name 2', 'Description 2', 29.99),
                    (3, 'Product Name 3', 'Description 3', 39.99)
                """;

        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * H2 does not support the MySQL stored-procedure syntax (BEGIN/END).
     * Instead we register a CALL-able alias backed by a Java method.
     * The alias returns a ResultSet of all products, matching the original
     * {@code call GetAllProducts()} behaviour.
     */
    public void createStoredProcedure() {
        loadDriver();
        String sql = """
                CREATE ALIAS IF NOT EXISTS GetAllProducts FOR
                    "org.assimbly.sql.helpers.H2Database.getAllProducts"
                """;

        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             Statement stmt = conn.createStatement()) {

            stmt.executeUpdate(sql);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Static method referenced by the H2 ALIAS above.
     * H2 calls this and wraps the returned ResultSet transparently.
     */
    public static ResultSet getAllProducts(Connection conn) throws SQLException {
        // H2 keeps the ResultSet open as long as the statement is alive;
        // do NOT close the statement here.
        PreparedStatement ps = conn.prepareStatement("SELECT * FROM products");
        return ps.executeQuery();
    }

    public void clearData() {
        loadDriver();
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             Statement stmt = conn.createStatement()) {
            // Delete data and reset the auto-increment counter
            stmt.execute("DELETE FROM products");
            stmt.execute("ALTER TABLE products ALTER COLUMN id RESTART WITH 1");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
