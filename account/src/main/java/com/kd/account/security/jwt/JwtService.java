package com.kd.account.security.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtService {

    @Value("${jwt.secret-key}")
    private String secretKey;

    @Value("${jwt.access-token-expiration}")
    private Long jwtExpiration;

    private SecretKey getSigningKey(){
        // The JWT library signs using SecretKey, not String.
        return Keys.hmacShaKeyFor(secretKey.getBytes(StandardCharsets.UTF_8));
    }

    public String generateToken(UserDetails userDetails){
        return generateToken(Map.of(),userDetails);
    }

    public String generateToken(Map<String,Object> extraClaims,UserDetails userDetails){
        return Jwts.builder()
                .claims(extraClaims)
                .subject(userDetails.getUsername()) //Who owns this token?
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis()+jwtExpiration))
                .signWith(getSigningKey()) //This generates the signature. Without signing JWT can be modified by anyone.
                .compact(); //Converts everything into xxxxx.yyyyy.zzzzz the JWT string.
    }

    public <T> T extractClaims(String token, Function<Claims,T> resolver){
        Claims claims=extractAllClaims(token);
        return resolver.apply(claims);
    }

    public String extractUserName(String token){
        return extractClaims(token,Claims::getSubject);
    }

    public Date extractExpiration(String token){
        return extractClaims(token,Claims::getExpiration);
    }

    private Claims extractAllClaims(String token){
        return Jwts.parser()
                .verifyWith(getSigningKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

    private Boolean isTokenExpired(String token){
        return extractExpiration(token).before(new Date());
    }

    public Boolean isTokenValid(String token,UserDetails userDetails){
        String userName=extractUserName(token);

        return userName.equals(userDetails.getUsername()) && !isTokenExpired(token);
    }
}
