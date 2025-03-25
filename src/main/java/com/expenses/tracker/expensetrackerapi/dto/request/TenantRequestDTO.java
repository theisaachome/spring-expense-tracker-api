package com.expenses.tracker.expensetrackerapi.dto.request;

public record TenantRequestDTO(
        String fullname,
        String email,
        String phone,
        String emergencyContactPhone,
        Integer bedId,
        String address1,
        String address2,
        String city,
        String state
) {
}
