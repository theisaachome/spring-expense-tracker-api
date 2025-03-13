package com.expenses.tracker.expensetrackerapi.dto.response;

import java.time.LocalDateTime;

public record CategoryResponseDto(
        String name,
        String description,
        Long userId,
        LocalDateTime createdDate,
        LocalDateTime lastModifiedDate,
        String createdBy,
        String lastModifiedBy,
        Boolean isActive,
        Integer version) {
}
