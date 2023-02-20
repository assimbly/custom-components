package world.dovetail.sql.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import world.dovetail.sql.domain.JDBCConnection;

import org.mockito.MockedStatic;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;


public class JdbcValidationServiceTest {
    private static JdbcValidationService service;

    @BeforeEach
    public void setup() { service = new JdbcValidationService(); }

    @Test
    public void testDecodeQueryParams() throws UnsupportedEncodingException {

        String username = "User/&$@*";
        String host = "176.10.10.10";
        String password = "Pass/&$@*";
        String database = "database/&$@*";
        int port = 3306;
        boolean ssl = true;
        String tlsVersion = "TLSv1,TLSv1.1,TLSv1.2";
        boolean escapedChars = false;

        String usernameEncoded = URLEncoder.encode(username, "utf-8");
        String hostEncoded = URLEncoder.encode(host, "utf-8");
        String passwordEncoded = URLEncoder.encode(password, "utf-8");
        String databaseEncoded = URLEncoder.encode(database, "utf-8");

        JDBCConnection.Builder builderMock = Mockito.mock(JDBCConnection.Builder.class);
        JDBCConnection connectionMock = Mockito.mock(JDBCConnection.class);

        try (MockedStatic<JDBCConnection> mocked = Mockito.mockStatic(JDBCConnection.class)) {
            mocked.when( () -> JDBCConnection.builder()).thenReturn(builderMock);
            mocked.when( () -> builderMock.build()).thenReturn(connectionMock);
            mocked.when(() -> builderMock.setUsername(username)).thenReturn(builderMock);
            mocked.when(() ->  builderMock.setPassword(password)).thenReturn(builderMock);
            mocked.when(() -> builderMock.setHost(host)).thenReturn(builderMock);
            mocked.when(() -> builderMock.setPort(port)).thenReturn(builderMock);
            mocked.when(() -> builderMock.setSecure(ssl)).thenReturn(builderMock);
            mocked.when(() -> builderMock.setEnabledTLSProtocols(tlsVersion)).thenReturn(builderMock);
            mocked.when(() -> builderMock.setEscapeChars(escapedChars)).thenReturn(builderMock);
            mocked.when(() -> builderMock.setDatabase(database)).thenReturn(builderMock);
        }

        service.validate("mysql", usernameEncoded, hostEncoded, passwordEncoded, 3306, true, "TLSv1,TLSv1.1,TLSv1.2", false, databaseEncoded);
    }
}
