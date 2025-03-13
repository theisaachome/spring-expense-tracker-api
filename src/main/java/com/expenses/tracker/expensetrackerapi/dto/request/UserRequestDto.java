package com.expenses.tracker.expensetrackerapi.dto.request;


public record UserRequestDto(
        String username,
        String password,
        String email
) {
}
