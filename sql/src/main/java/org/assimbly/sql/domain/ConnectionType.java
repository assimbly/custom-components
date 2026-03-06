package org.assimbly.sql.domain;

import org.assimbly.sql.adapter.DatabaseAdapter;

public enum ConnectionType {
    DB2("DB2Adapter"),
    INFORMIX("InformixAdapter"),
    MYSQL("MysqlAdapter"),
    MYSQL8("Mysql8Adapter"),
    SQL_SERVER("SqlServerAdapter"),
    ORACLE("OracleAdapter"),
    POSTGRES("PostgresAdapter");

    private final String adapterName;

    ConnectionType(String adapterName) {
        this.adapterName = adapterName;
    }

    public DatabaseAdapter getAdapter() throws ReflectiveOperationException {
        Class<?> adapterClass = Class.forName("org.assimbly.sql.adapter." + adapterName);
        return (DatabaseAdapter) adapterClass.getDeclaredConstructor().newInstance();
    }
}