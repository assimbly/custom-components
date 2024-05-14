package org.assimbly.auth.endpoint;

import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import org.assimbly.auth.mongo.MongoClientProvider;
import org.assimbly.auth.mongo.MongoDao;
import org.assimbly.util.helper.Base64Helper;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.assimbly.auth.MongoTestHelper;
import org.assimbly.auth.domain.User;
import org.assimbly.auth.util.helper.ConfigHelper;

import jakarta.ws.rs.core.Response;
import org.mockito.Mockito;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class TokenServiceTest {

    private static final String URL = "http://localhost:8181/cxf/auth/token";

    private static final String EMAIL = "joe";
    private static final String PASSWORD = "abcdefg";
    private static User user;
    private static String database;

    private static TokenService tokenService;

    @BeforeAll
    public static void initClass() {
        user = MongoTestHelper.setup();
        database = MongoTestHelper.getDb();

        MongoDatabase mongoDatabase = MongoClients.create().getDatabase(database);

        tokenService = new TokenService(mongoDatabase);
    }

    @Test
    public void testTokenCreation() throws IOException {

        String key = ConfigHelper.get("secretKey");

        String header = header(EMAIL, PASSWORD);
        Response response = tokenService.issueToken(header);
        String token = response.getEntity().toString();

        JwtParser parser = Jwts.parser().setSigningKey(key.getBytes("UTF-8")).build();
        Claims body = parser.parseClaimsJws(token).getBody();

        assertNotEquals("Returned token is an empty string", "", token);
        assertNotNull(body, "Token not created");
        assertEquals("joe", body.get("name"), "Wrong claims for token created");
    }

    @Test
    public void testBadRequestResponseOnEmail() throws IOException {
        String header = header("", PASSWORD);
        Response response = tokenService.issueToken(header);

        assertEquals(400, response.getStatus(), "Bad Request code 400 not received as a response");
    }

    @Test
    public void testBadRequestResponseOnPassword() throws IOException {
        String header = header(EMAIL, "");
        Response response = tokenService.issueToken(header);

        assertEquals(400, response.getStatus(), "Bad Request code 400 not received as a response");
    }

    @Test
    public void testNotAuthorisedResponse() throws IOException {
        String header = header("steve", "zyxvwu");
        Response response = tokenService.issueToken(header);

        assertEquals(401, response.getStatus(), "Not Authorised Request code 401 not received as a response");
    }

    @Test
    public void testInvalidUserNotAuthorisedResponse() throws IOException {
        String header = header(EMAIL + "2", PASSWORD + "2");
        Response response = tokenService.issueToken(header);

        assertEquals(401, response.getStatus(), "Not Authorised Request code 401 not received as a response");
        assertEquals(Errors.UNAUTHORIZED, response.getEntity(), "Wrong response entity");
    }

    @Test
    public void testInvalidTenantNotAuthorisedResponse() throws IOException {
        String header = header(EMAIL + "3", PASSWORD + "3");
        Response response = tokenService.issueToken(header);

        assertEquals(401, response.getStatus(), "Not Authorised Request code 401 not received as a response");
        assertEquals(Errors.INVALID_TENANT, response.getEntity(), "Wrong response entity");
    }

    private String header(String email, String password) throws IOException {
        String header = email + ":" + password;
        return Base64Helper.marshal(header);
    }
}
