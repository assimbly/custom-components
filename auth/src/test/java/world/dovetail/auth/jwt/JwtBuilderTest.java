package world.dovetail.auth.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import world.dovetail.auth.util.helper.ConfigHelper;
import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class JwtBuilderTest {

    @Test
    public void createTest() throws UnsupportedEncodingException {
        String name = "joe";
        String scope = "admin";

        String key = ConfigHelper.get("secretKey");

        String jwt = JwtBuilder.build(name, scope);

        JwtParser parser = Jwts.parser().setSigningKey(key.getBytes("UTF-8"));
        Claims body = parser.parseClaimsJws(jwt).getBody();

        assertEquals("Wrong name claim found", name, body.get("name"));
        assertEquals("Wrong scope claim found", scope, body.get("scope"));
        assertTrue("Expiration wrongly set", body.getExpiration().after(new Date()));
    }

}
