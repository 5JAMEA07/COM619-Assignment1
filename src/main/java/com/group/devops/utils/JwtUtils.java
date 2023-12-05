package com.group.devops.utils;

import com.group.devops.model.user.User;
import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtUtils {

    private static final String secret = "@@Kryptonite@@";

    public String generateToken(User user) {
        long expirationTime = 604800000;
        return Jwts.builder()
                .setSubject(user.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + expirationTime))
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }

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

    public static boolean isTokenValid(String authHeader) {
        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            String token = authHeader.substring(7); // Remove 'Bearer ' prefix
            return validateToken(token);
        }
        return false;
    }
}