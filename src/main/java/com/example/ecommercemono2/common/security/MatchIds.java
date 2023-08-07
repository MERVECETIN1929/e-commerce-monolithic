package com.example.ecommercemono2.common.security;

import com.example.ecommercemono2.security.TokenService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MatchIds implements MatchIdsService {
    private final TokenService tokenService;
    public  boolean matchIds(HttpServletRequest request, UUID userId){
        String header=request.getHeader("Authorization");
        String token=header.substring(7);
        String tokenUserId=tokenService.extractUserId(token);
        return tokenUserId.equals(userId.toString());
    }

}
