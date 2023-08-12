package com.example.nichefood.Configurations.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Component
public class JwtService {

    private static final String secret = "PaM08si54JLuDw6vQBl2GfocJvwMlz7rWiTlO6YXh0XhywmOWirrexcV1wc8MKSwNDGo4gRD0KMiLE" +
            "cb2q5zeVrv0OgVR8BwX0c9jJtAUDg0rzeewimgpnMZvBxjB6TyCBlv0a7wxFmhVre8c3gJrOERlpLaEj6mj2Bf2qA4m1S/YvtDkTCjNRdLK" +
            "LjVWVW6Vwu8yC4Yzw6M1QpgIpPMQdDLqamRnmi7yT05k6KIvxL4myAnLjTPAFKjfAI3UxogUfNAFVEVdS58Wi4JkjJ2ZciftKnfhxcrZrfL" +
            "lsMW0FD7kI2rV5soGdwMTaVhPxnS7+u3T+H3k5Ljd5M31Y42Ccjb7f1gsAxIy5Po7h+PGT8=";

    public String getSecret() {
        return secret;
    }

    public String extractUsername(String token){
        return extractClaim(token, Claims::getSubject);// getSubject -> Username
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver){
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    public String generateToken(UserDetails userDetails){
        Map<String, Object> Claims = new HashMap<>(); 
        return generateToken(Claims ,userDetails);
    }

    public String generateToken(Map<String, Object> extraClaims, UserDetails userDetails){
        return Jwts.builder()
                .setClaims(extraClaims)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + (1000 * 60 * 24 * 90) ))
                .signWith(getSigningKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    public boolean isTokenValid(String token, UserDetails userDetails) {
        return (userDetails.getUsername().equals(extractUsername(token)) && !isTokenExpired(token));
    }

    private boolean isTokenExpired(String token) {
        return extractClaim(token, Claims::getExpiration).before(new Date());
    }

    private Claims extractAllClaims(String token){
        return Jwts
                .parserBuilder()
                .setSigningKey(getSigningKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    private Key getSigningKey() {
        byte[] KeyBytes = Decoders.BASE64.decode(secret);
        return Keys.hmacShaKeyFor(KeyBytes);
    }
}
