package world.dovetail.sql.domain;

import world.dovetail.sql.adapter.DatabaseAdapter;

public enum ConnectionType {
    DB2("DB2Adapter"),
    INFORMIX("InformixAdapter"),
    MYSQL("MysqlAdapter"),
    MYSQL8("Mysql8Adapter"),
    SQL_SERVER("SqlServerAdapter"),
    ORACLE("OracleAdapter"),
    POSTGRES("PostgresAdapter");

    String adapterName;

    ConnectionType(String adapterName) {
        this.adapterName = adapterName;
    }

    public DatabaseAdapter getAdapter() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        return (DatabaseAdapter) Class.forName("world.dovetail.sql.adapter." + adapterName).newInstance();
    }
}
