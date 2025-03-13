package com.expenses.tracker.expensetrackerapi.dto.request;
import java.math.BigDecimal;
import java.time.LocalDate;

public record BudgetRequestDto(
        String budgetName,
        String description,
        BigDecimal budgetLimit,
        LocalDate periodStart,
        LocalDate periodEnd,
        Long userId // Instead of embedding a full User entity
) {}
