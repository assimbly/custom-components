package org.assimbly.auth.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.slf4j.LoggerFactory;
import org.assimbly.auth.util.helper.ConfigHelper;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;

public final class JwtValidator {

    private static final org.slf4j.Logger LOG = LoggerFactory.getLogger(JwtValidator.class);

    private JwtValidator() {
        //Static class cannot be instantiated.
    }

    /**
     * Check if a JSON Web Token is valid.
     * This means that the signature is correct
     * and the current date is not before the starting date
     * and the current date is not after the expiration date.
     *
     * @param jwt to check.
     * @return true if the token is valid.
     */
    public static boolean validSession(String jwt) {
        return validJwt(jwt);
    }

    public static boolean validJwt(String jwt) {
        boolean valid;

        try {
            decode(jwt);
            valid = true;
        } catch (JwtException e) {
            LOG.warn(e.getMessage());
            valid = false;
        }

        return valid;
    }

    /**
     * Decode the JSON Web Token. The decoding process will throw exceptions
     * when something is wrong with the token.
     *
     * @param jwt to decode.
     * @return the body of the decoded token.
     * @throws JwtException when something is wrong with the token.
     */
    public static Claims decode(String jwt) throws JwtException {
        String keyString = ConfigHelper.get("secretKey");
        SecretKey key = Keys.hmacShaKeyFor(keyString.getBytes(StandardCharsets.UTF_8));

        JwtParser parser = Jwts.parser()
                .verifyWith(key)
                .build();

        return parser
                .parseSignedClaims(jwt)
                .getPayload();
    }

}