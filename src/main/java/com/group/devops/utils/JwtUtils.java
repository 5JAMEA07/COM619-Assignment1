package com.group.devops.utils;

import com.group.devops.model.user.User;
import io.jsonwebtoken.*;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Utility class for handling JWT (JSON Web Token) operations including token generation and validation.
 */
@Component
public class JwtUtils {

    private static final String secret = "@@Kryptonite@@";

    /**
     * Generates a JWT token for a given user.
     *
     * @param user The user for whom the token is to be generated.
     * @return A JWT token as a String.
     */
    public String generateToken(User user) {
        long expirationTime = 604800000; // 1 week in milliseconds
        return Jwts.builder()
                .setSubject(user.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + expirationTime))
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }

    /**
     * Validates a JWT token.
     *
     * @param token The JWT token to validate.
     * @return True if the token is valid, false otherwise.
     */
    public static boolean validateToken(String token) {
        try {
            Jws<Claims> claims = Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token);
            return !claims.getBody().getExpiration().before(new Date());
        } catch (ExpiredJwtException | MalformedJwtException | UnsupportedJwtException | SignatureException e) {
            // Log the exception details (e.g., using a logger) for debugging purposes
            return false;
        }
    }

    /**
     * Checks if the Authorization header contains a valid JWT token.
     *
     * @param authHeader The Authorization header from the request.
     * @return True if the header contains a valid JWT token, false otherwise.
     */
    public static boolean isTokenValid(String authHeader) {
        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            String token = authHeader.substring(7); // Remove 'Bearer ' prefix
            return validateToken(token);
        }
        return false;
    }
}
