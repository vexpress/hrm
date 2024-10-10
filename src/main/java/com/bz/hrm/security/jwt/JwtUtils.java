package com.bz.hrm.security.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureException;
import org.springframework.stereotype.Component;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Date;

@Component
public class JwtUtils {

    private String jwtSecret = "your_secret_key"; // Set your secret key
    private int jwtExpirationMs = 604800000; // Example expiration time (1 week)

    // Validate the JWT Token
    public boolean validateJwtToken(String token) {
        try {
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token);
            return true;
        } catch (SignatureException e) {
            System.out.println("Invalid JWT signature: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("JWT token validation failed: " + e.getMessage());
        }
        return false;
    }

    // Get username from the JWT Token
    public String getUsernameFromJwtToken(String token) {
        Claims claims = Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody();
        return claims.getSubject();
    }

    // Generate a JWT Token
    public String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(new Date().getTime() + jwtExpirationMs))
                .signWith(SignatureAlgorithm.HS512, jwtSecret)
                .compact();
    }
}
