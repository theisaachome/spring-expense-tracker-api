package com.expenses.tracker.expensetrackerapi.dto.response;

public record JWTAuthResponse(String accessToken, String tokenType) {
    public JWTAuthResponse(String accessToken) {
        this(accessToken, "Bearer");
    }
}
