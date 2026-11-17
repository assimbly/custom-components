package org.assimbly.auth.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.assimbly.auth.util.helper.ConfigHelper;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import java.time.Instant;

public final class JwtBuilder {

    static SecureRandom random = new SecureRandom();

    private JwtBuilder() {
        //Static class cannot be instantiated.
    }

    /**
     * Build an JSON Web Token (JWT) containing the given parameters.
     *
     * @param name    claim of the token.
     * @param scope   claim of the token.
     * @return a valid signed JSON Web Token.
     */
    public static String build(String name, String scope) {
        String keyString = ConfigHelper.get("secretKey");
        int expiration = Integer.parseInt(ConfigHelper.get("expiration"));

        SecretKey key = Keys.hmacShaKeyFor(keyString.getBytes(StandardCharsets.UTF_8));

        return Jwts.builder()
                .subject(createRandomString())
                .claim(Claims.EXPIRATION, createExpiration(expiration).getEpochSecond())
                .claim("name", name)
                .claim("scope", scope)
                .signWith(key)
                .compact();
    }

    /**
     * Create an expiration instant: currentInstant + given seconds.
     *
     * @param seconds the time to add to the current instant in seconds.
     * @return the expiration as an Instant.
     */
    private static Instant createExpiration(int seconds) {
        return Instant.now().plusSeconds(seconds);
    }

    /**
     * Create a random String 10 characters long.
     *
     * @return the created String.
     */
    private static String createRandomString() {

        String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";

        char[] s = new char[10];
        for (int i = 0; i < 10; i++) {
            s[i] = characters.charAt(random.nextInt(characters.length()));
        }
        return new String(s);
    }

}