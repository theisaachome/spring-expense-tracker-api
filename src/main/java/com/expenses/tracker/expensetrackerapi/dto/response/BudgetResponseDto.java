package com.expenses.tracker.expensetrackerapi.dto.response;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public record BudgetResponseDto(
        String budgetName,
        String description,
        BigDecimal budgetLimit,
        LocalDate periodStart,
        LocalDate periodEnd,
        Long userId,
        LocalDateTime createdDate,
        LocalDateTime lastModifiedDate,
        String createdBy,
        String lastModifiedBy,
        Boolean isActive,
        Integer version
) {
}
