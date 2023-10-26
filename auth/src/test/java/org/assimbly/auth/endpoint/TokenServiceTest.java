package org.assimbly.auth.endpoint;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.JwtParserBuilder;
import io.jsonwebtoken.Jwts;
import org.assimbly.util.helper.Base64Helper;
import org.junit.BeforeClass;
import org.junit.Test;
import org.assimbly.auth.MongoTestHelper;
import org.assimbly.auth.domain.User;
import org.assimbly.auth.util.helper.ConfigHelper;

import jakarta.ws.rs.core.Response;
import java.io.IOException;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

public class TokenServiceTest {

    private static final String URL = "http://localhost:8181/cxf/auth/token";

    private static final String EMAIL = "joe";
    private static final String PASSWORD = "abcdefg";
    private static User user;
    private static String database;

    private static TokenService tokenService;

    @BeforeClass
    public static void initClass() {
        user = MongoTestHelper.setup();
        database = MongoTestHelper.getDb();

        tokenService = new TokenService(database);
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
        assertNotNull("Token not created", body);
        assertEquals("Wrong claims for token created", "joe", body.get("name"));
    }

    @Test
    public void testBadRequestResponseOnEmail() throws IOException {
        String header = header("", PASSWORD);
        Response response = tokenService.issueToken(header);

        assertEquals("Bad Request code 400 not received as a response", 400, response.getStatus());
    }

    @Test
    public void testBadRequestResponseOnPassword() throws IOException {
        String header = header(EMAIL, "");
        Response response = tokenService.issueToken(header);

        assertEquals("Bad Request code 400 not received as a response", 400, response.getStatus());
    }

    @Test
    public void testNotAuthorisedResponse() throws IOException {
        String header = header("steve", "zyxvwu");
        Response response = tokenService.issueToken(header);

        assertEquals("Not Authorised Request code 401 not received as a response", 401, response.getStatus());
    }

    @Test
    public void testInvalidUserNotAuthorisedResponse() throws IOException {
        String header = header(EMAIL + "2", PASSWORD + "2");
        Response response = tokenService.issueToken(header);

        assertEquals("Not Authorised Request code 401 not received as a response", 401, response.getStatus());
        assertEquals("Wrong response entity", Errors.UNAUTHORIZED, response.getEntity());
    }

    @Test
    public void testInvalidTenantNotAuthorisedResponse() throws IOException {
        String header = header(EMAIL + "3", PASSWORD + "3");
        Response response = tokenService.issueToken(header);

        assertEquals("Not Authorised Request code 401 not received as a response", 401, response.getStatus());
        assertEquals("Wrong response entity", Errors.INVALID_TENANT, response.getEntity());
    }

    private String header(String email, String password) throws IOException {
        String header = email + ":" + password;
        return Base64Helper.marshal(header);
    }
}
