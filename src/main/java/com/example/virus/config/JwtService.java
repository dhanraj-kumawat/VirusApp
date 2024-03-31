package com.example.virus.config;

import com.example.virus.dao.TokenDao;
import com.example.virus.model.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.function.Function;

@Service
public class JwtService {

    //1. create a secret key
    private final String SECRET_KEY = "xn2ys^gdfid729)kdghb.nvrp;-%z!yyuidpoq,ea";

    private TokenDao tokenDao;

    public JwtService(TokenDao tokenDao){
        this.tokenDao = tokenDao;
    }

    // methods

    public String extractUsername(String token){
        return extractClaim(token, Claims::getSubject);
    }

    private <T> T extractClaim(String token, Function<Claims, T> resolver){
        Claims claims = extractAllClaims(token);
        return resolver.apply(claims);
    }
    private Claims extractAllClaims(String token){
        return Jwts.parser()
                .verifyWith(getSignInKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

    private SecretKey getSignInKey(){
       byte[] keyBytes = Decoders.BASE64URL.decode(SECRET_KEY);
       return Keys.hmacShaKeyFor(keyBytes);
    }

    public boolean isValid(String token, UserDetails user){
        String username = extractUsername(token);
        boolean isTokenValid = tokenDao.findByToken(token).map((t-> !t.isLoggedOut()))
                .orElse(false);

        return (user.getUsername().equals(username) && isTokenValid && isTokenExpired(token));
    }

    private boolean isTokenExpired(String token){
        return extractExpiration(token).before(new Date());
    }

    private Date extractExpiration(String token){
        return extractClaim(token, Claims::getExpiration);
    }

    // generate token
    public String generateToken(User user){
        return Jwts.builder().setSubject(user.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 24*60*60*1000))
                .signWith(getSignInKey())
                .compact();
    }

}
