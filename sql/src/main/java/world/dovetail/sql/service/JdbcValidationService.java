package world.dovetail.sql.service;

import org.assimbly.util.error.ValidationErrorMessage;
import world.dovetail.sql.adapter.*;
import world.dovetail.sql.domain.ConnectionType;
import world.dovetail.sql.domain.JDBCConnection;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
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
                                           @QueryParam("pwd") String password,
                                           @QueryParam("port") int port,
                                           @QueryParam("useSSL") boolean useSSL,
                                           @QueryParam("enabledTLSProtocols") String enabledTLSProtocols,
                                           @QueryParam("escapedChars") boolean escapedChars,
                                           @QueryParam("database") String database) {
        Connection connection = null;

        try {
            ConnectionType connectionType = ConnectionType.valueOf(type.toUpperCase());
            host = URLDecoder.decode(host, "UTF-8");
            userName = URLDecoder.decode(userName, "UTF-8");
            password = URLDecoder.decode(password, "UTF-8");
            database = URLDecoder.decode(database, "UTF-8");

            JDBCConnection jdbcConnection = JDBCConnection.builder()
                        .setUsername(userName)
                        .setPassword(password)
                        .setHost(host)
                        .setPort(port)
                        .setSecure(useSSL)
                        .setEnabledTLSProtocols(enabledTLSProtocols)
                        .setEscapeChars(escapedChars)
                        .setDatabase(database)
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
