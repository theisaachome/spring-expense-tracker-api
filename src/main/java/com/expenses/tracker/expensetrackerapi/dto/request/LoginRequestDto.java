package com.expenses.tracker.expensetrackerapi.dto.request;

public record LoginRequestDto(
        String usernameOrEmail,
        String password
) {
}
