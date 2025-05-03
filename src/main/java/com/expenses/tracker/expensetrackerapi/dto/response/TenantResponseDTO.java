package com.expenses.tracker.expensetrackerapi.dto.response;

public record TenantResponseDTO(
        Long id,
        String name,
        String message,
        Integer statusCode
) {
}
