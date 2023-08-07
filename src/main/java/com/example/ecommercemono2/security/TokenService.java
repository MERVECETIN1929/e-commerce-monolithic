package com.example.ecommercemono2.security;


import io.jsonwebtoken.Claims;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Map;
import java.util.function.Function;

public interface TokenService {
     String extractUserName(String token);
     boolean isTokenValid(String token,UserDetails userDetails);
      String generateToken(UserDetails userDetails);
     String generateToken(Map<String,Object> extraClaims, UserDetails userDetails);
     <T> T extractClaim(String token, Function<Claims,T> claimResolver);
     String extractUserId(String token);

}
