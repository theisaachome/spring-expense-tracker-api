package com.expenses.tracker.expensetrackerapi.dto.request;

public record SignupRequestDto(
        String username,
        String email,
        String password
) {
}
