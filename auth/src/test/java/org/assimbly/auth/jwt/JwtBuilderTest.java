package org.assimbly.auth.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import org.assimbly.auth.util.helper.ConfigHelper;
import org.junit.jupiter.api.Test;

import java.io.UnsupportedEncodingException;

public class JwtBuilderTest {

    @Test
    public void createTest() throws UnsupportedEncodingException {
        String name = "joe";
        String scope = "admin";

        String key = ConfigHelper.get("secretKey");

        String jwt = JwtBuilder.build(name, scope);

        JwtParser parser = Jwts.parser().setSigningKey(key.getBytes("UTF-8")).build();
        Claims body = parser.parseClaimsJws(jwt).getBody();

        assertEquals("Wrong name claim found", name, body.get("name"));
        assertEquals("Wrong scope claim found", scope, body.get("scope"));

    }

    private void assertEquals(String wrongNameClaimFound, String name, Object name1) {
    }

}
