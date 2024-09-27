package org.assimbly.sql.service;

import org.assimbly.util.error.ValidationErrorMessage;
import org.assimbly.sql.adapter.*;
import org.assimbly.sql.domain.ConnectionType;
import org.assimbly.sql.domain.JDBCConnection;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.sql.Connection;
import java.sql.SQLException;

@Path("/")
public class JdbcValidationService {

    @GET
    @Produces("application/json")
    @Path("/validate")
    public ValidationErrorMessage validate(@QueryParam("type") String type,
                                           @QueryParam("user") String userName,
                                           @QueryParam("host") String host,
                                           @QueryParam("instance") String instance,
                                           @QueryParam("pwd") String password,
                                           @QueryParam("port") int port,
                                           @QueryParam("useSSL") boolean useSSL,
                                           @QueryParam("enabledTLSProtocols") String enabledTLSProtocols,
                                           @QueryParam("escapeChars") boolean escapeChars,
                                           @QueryParam("database") String database) {
        Connection connection = null;

        try {
            ConnectionType connectionType = ConnectionType.valueOf(type.toUpperCase());

            JDBCConnection jdbcConnection = JDBCConnection.builder()
                        .setUsername(decodeParam(userName))
                        .setPassword(decodeParam(password))
                        .setHost(decodeParam(host))
                        .setInstance(decodeParam(instance))
                        .setPort(port)
                        .setSecure(useSSL)
                        .setEnabledTLSProtocols(enabledTLSProtocols)
                        .setEscapeChars(escapeChars)
                        .setDatabase(decodeParam(database))
                    .build();

            DatabaseAdapter adapter = connectionType.getAdapter();

            connection = jdbcConnection.connect(adapter);
        } catch (SQLException | UnsupportedEncodingException | ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            return new ValidationErrorMessage(e.getMessage());
        } finally {
            close(connection);
        }

        return null;
    }

    private String decodeParam(String param) throws UnsupportedEncodingException{
        return URLDecoder.decode(param, "UTF-8");
    }

    private void close(Connection connection) {
        if(connection == null) {
            return;
        }

        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
