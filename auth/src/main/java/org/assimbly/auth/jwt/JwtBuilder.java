package org.assimbly.auth.jwt;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.assimbly.auth.util.helper.ConfigHelper;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.Random;

public final class JwtBuilder {

    static Random random = new Random();

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
                .expiration(createExpiration(expiration))
                .claim("name", name)
                .claim("scope", scope)
                .signWith(key)
                .compact();
    }

    /**
     * Create a date used as an expiration date. Date is currentDate + given seconds.
     *
     * @param seconds the time to add to the current date in seconds.
     * @return a date represented as a Date object.
     */
    private static Date createExpiration(int seconds) {
        LocalDateTime date = LocalDateTime.now();
        date = date.plusSeconds(seconds);

        Instant instant = date.atZone(ZoneId.systemDefault()).toInstant();
        return Date.from(instant);
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