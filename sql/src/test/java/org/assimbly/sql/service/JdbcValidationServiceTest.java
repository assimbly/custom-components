package org.assimbly.sql.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.assimbly.sql.domain.JDBCConnection;

import org.mockito.MockedStatic;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import static org.mockito.Mockito.mock;


class JdbcValidationServiceTest {
    private static JdbcValidationService service;

    @BeforeEach
    void setup() { service = new JdbcValidationService(); }

    @Test
    void testDecodeQueryParams() {

        String username = "User/&$@*";
        String host = "176.10.10.10";
        String password = "Pass/&$@*";
        String database = "database/&$@*";
        int port = 3306;
        boolean ssl = true;
        String tlsVersion = "TLSv1,TLSv1.1,TLSv1.2";

        String usernameEncoded = URLEncoder.encode(username, StandardCharsets.UTF_8);
        String hostEncoded = URLEncoder.encode(host, StandardCharsets.UTF_8);
        String passwordEncoded = URLEncoder.encode(password, StandardCharsets.UTF_8);
        String databaseEncoded = URLEncoder.encode(database, StandardCharsets.UTF_8);

        JDBCConnection.Builder builderMock = mock(JDBCConnection.Builder.class);
        JDBCConnection connectionMock = mock(JDBCConnection.class);

        try (MockedStatic<JDBCConnection> mocked = Mockito.mockStatic(JDBCConnection.class)) {
            mocked.when(JDBCConnection::builder).thenReturn(builderMock);
            mocked.when(builderMock::build).thenReturn(connectionMock);
            mocked.when(() -> builderMock.setUsername(username)).thenReturn(builderMock);
            mocked.when(() ->  builderMock.setPassword(password)).thenReturn(builderMock);
            mocked.when(() -> builderMock.setHost(host)).thenReturn(builderMock);
            mocked.when(() -> builderMock.setPort(port)).thenReturn(builderMock);
            mocked.when(() -> builderMock.setSecure(ssl)).thenReturn(builderMock);
            mocked.when(() -> builderMock.setEnabledTLSProtocols(tlsVersion)).thenReturn(builderMock);
            mocked.when(() -> builderMock.setDatabase(database)).thenReturn(builderMock);
        }

        service.validate("mysql", usernameEncoded, hostEncoded, null, passwordEncoded, 3306, true, "TLSv1,TLSv1.1,TLSv1.2", databaseEncoded);
    }
}
