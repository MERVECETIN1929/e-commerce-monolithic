package com.example.ecommercemono2.common.security;

import jakarta.servlet.http.HttpServletRequest;

import java.util.UUID;

public interface MatchIdsService {
    public boolean matchIds(HttpServletRequest request, UUID userId);
}
