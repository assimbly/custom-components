package world.dovetail.sql.adapter;

import world.dovetail.sql.domain.JDBCConnection;

import java.sql.Connection;
import java.sql.SQLException;

public interface DatabaseAdapter {

    Connection connect(JDBCConnection connection) throws SQLException;
}
