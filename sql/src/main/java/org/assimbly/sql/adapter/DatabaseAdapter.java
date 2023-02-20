package org.assimbly.sql.adapter;

import org.assimbly.sql.domain.JDBCConnection;

import java.sql.Connection;
import java.sql.SQLException;

public interface DatabaseAdapter {

    Connection connect(JDBCConnection connection) throws SQLException;
}
