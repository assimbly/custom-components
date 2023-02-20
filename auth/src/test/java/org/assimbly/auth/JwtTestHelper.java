package org.assimbly.auth;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.io.UnsupportedEncodingException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class JwtTestHelper {

    private static Date getAfterNow(){
        LocalDateTime plus = LocalDateTime.now().plusSeconds(3600);
        return Date.from(plus.atZone(ZoneId.systemDefault()).toInstant());
    }

    private static Date getBeforeNow(){
        LocalDateTime minus = LocalDateTime.now().minusSeconds(3600);
        return Date.from(minus.atZone(ZoneId.systemDefault()).toInstant());
    }

    public static String createValidJwt(String key, String subject) throws UnsupportedEncodingException {
        return Jwts.builder()
                .setSubject(subject)
                .setNotBefore(getBeforeNow())
                .setExpiration(getAfterNow())
                .signWith(
                        SignatureAlgorithm.HS256,
                        key.getBytes("UTF-8")
                )
                .compact();
    }

    public static String createPrematureJwt(String key, String subject) throws UnsupportedEncodingException {
        return Jwts.builder()
                .setSubject(subject)
                .setNotBefore(getAfterNow())
                .signWith(
                        SignatureAlgorithm.HS256,
                        key.getBytes("UTF-8")
                )
                .compact();
    }

    public static String createExpiredJwt(String key, String subject) throws UnsupportedEncodingException {
        return Jwts.builder()
                .setSubject(subject)
                .setExpiration(getBeforeNow())
                .signWith(
                        SignatureAlgorithm.HS256,
                        key.getBytes("UTF-8")
                )
                .compact();
    }

}
