package org.assimbly.auth.jwt;

import org.assimbly.auth.JwtTestHelper;
import org.assimbly.auth.util.helper.ConfigHelper;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.UnsupportedEncodingException;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class JwtValidatorTest {

    private static String key;

    @BeforeClass
    public static void init() {
        key = ConfigHelper.get("secretKey");
    }

    @Test
    public void testValidSession() throws UnsupportedEncodingException {
        String jwt = JwtTestHelper.createValidJwt(key, "user/1");

        assertTrue(JwtValidator.validSession(jwt));
    }

    @Test
    public void testValidJwt() throws UnsupportedEncodingException {
        String jwt = JwtTestHelper.createValidJwt(key, "user/1");

        assertTrue(JwtValidator.validJwt(jwt));
    }

    @Test
    public void testPrematureJwtException() throws UnsupportedEncodingException {
        String jwt = JwtTestHelper.createPrematureJwt(key, "user/1");

        assertFalse(JwtValidator.validJwt(jwt));
    }

    @Test
    public void testExpiredException() throws UnsupportedEncodingException {
        String jwt = JwtTestHelper.createExpiredJwt(key, "user/1");

        assertFalse(JwtValidator.validJwt(jwt));
    }

    @Test
    public void testMalformedException() throws UnsupportedEncodingException {
        assertFalse(JwtValidator.validJwt("abcdefg"));
    }

    @Test
    public void testSignatureException() throws UnsupportedEncodingException {
        String jwt = JwtTestHelper.createValidJwt("abcdefghijklmnopqrstuvwxyz012345", "user/1");

        assertFalse(JwtValidator.validJwt(jwt));
    }

}
