package com.eduquest.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class JwtUtil {
    @Value("${jwt.secret}")
    private String SECRET;

    @Value("${jwt.expiration}")
    private long EXPIRATION;

    private Key getSignKey(){
        return Keys.hmacShaKeyFor(SECRET.getBytes());
    }
    //Generate JWT tokens
    public  String generateToken(String email){
        return Jwts.builder()
                .setSubject(email)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() +EXPIRATION))
                .signWith(getSignKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    // Extract all claims
    private Claims extractClaims(String token) {

        return Jwts.parserBuilder()
                .setSigningKey(getSignKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
    //Extract Email
    public  String extractEmail(String token){
        return extractClaims(token).getSubject();
    }
    // Extract Expiration Date
    public Date extractExpiration(String token) {

        return extractClaims(token).getExpiration();
    }


    // Check Token Expired
    public boolean isTokenExpired(String token) {

        return extractExpiration(token).before(new Date());
    }

    //Validate Token
    public  boolean validateToken(String token ,String email){
        String extractedEmail= extractEmail(token);
        return extractedEmail.equals(email)
                && !isTokenExpired(token);

    }

}
