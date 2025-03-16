package com.expenses.tracker.expensetrackerapi.security;
import com.expenses.tracker.expensetrackerapi.exception.ApplicationAPIException;
import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Component
public class JwtTokenProvider {
    @Value("${app.jwt-secrete}")
    private String secret;
    @Value("${app.jwt-issuer}")
    private String issuer;
    @Value("${app.jwt-expiration-milliseconds}")
    private long jwtExpiration;


    // generate Jwt token

    public String generateToken(Authentication authentication) {
        var username = authentication.getName();
        var currentDate = new Date();
        var expirationTime =new Date(currentDate.getTime()+jwtExpiration);

     String jwtToken=   Jwts.builder()
                .setSubject(username)
                .setIssuer(issuer)
                .setIssuedAt(currentDate) // Issued time
                .setExpiration(expirationTime) // Expiration time
                .signWith(key())
                .compact();

     return  jwtToken;
    }
    private Key key(){
       return Keys.hmacShaKeyFor(Decoders.BASE64.decode(secret));
    }
    // get username from jwtToken
    public String getUsername(String jwtToken){
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(key())
                .build()
                .parseClaimsJws(jwtToken).getBody();

        return  claims.getSubject();
    }

    public boolean validateToken(String jwtToken){
      try {
          Claims claims=  Jwts.parserBuilder()
                  .setSigningKey(key())
                  .build()
                  .parseClaimsJws(jwtToken).getBody();
          var result= claims.getExpiration().before(new Date());
          return !result;
      }
      catch (ExpiredJwtException e) {
          throw  new   ApplicationAPIException(HttpStatus.BAD_REQUEST,"Token expired: " + e.getMessage());
      } catch (UnsupportedJwtException e) {
          throw  new   ApplicationAPIException(HttpStatus.BAD_REQUEST,"Unsupported JWT: " + e.getMessage());
      } catch (MalformedJwtException e) {
          System.out.println("Malformed JWT: " + e.getMessage());
      } catch (IllegalArgumentException e) {
          throw  new   ApplicationAPIException(HttpStatus.BAD_REQUEST,"Illegal argument: " + e.getMessage());
      }
      return false;
    }

}
