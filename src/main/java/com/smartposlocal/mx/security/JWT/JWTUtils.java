package com.smartposlocal.mx.security.JWT;

import java.nio.charset.StandardCharsets;
import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.stereotype.Component;

import com.smartposlocal.mx.config.JwtProperties;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Component
public class JWTUtils {
    private final SecretKey secretKey;
    private final long expirationMs;

    public JWTUtils(JwtProperties properties) {
        this.secretKey = Keys.hmacShaKeyFor(properties.getSecret().getBytes(StandardCharsets.UTF_8));
        this.expirationMs = properties.getExpirationMs();
    }

    /**
     * Method to encode the new token for user
     * @param username
     * @return String
     */

    public String generateAccessToken(String username) {
        return Jwts.builder()
            .subject(username)
            .issuedAt(new Date())
            .expiration(new Date(System.currentTimeMillis() + expirationMs))
            .signWith(secretKey, SignatureAlgorithm.HS256)
            .compact();
    }

    /**
     * Get username from token
     * @param token
     * @return String
     */

    public String extractUsername(String token) {
        return Jwts.parser().verifyWith(secretKey).build().parseSignedClaims(token).getPayload().getSubject();
    }
}
