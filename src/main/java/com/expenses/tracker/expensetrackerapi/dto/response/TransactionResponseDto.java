package com.expenses.tracker.expensetrackerapi.dto.response;

import com.expenses.tracker.expensetrackerapi.entity.TransactionType;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public record TransactionResponseDto(
        Long id,
        BigDecimal amount,
        LocalDate transactionDate,
        TransactionType transactionType,
        String note,
        String description,
        Long userId,
        Long accountId,
        Long categoryId,
        Long budgetId,
        LocalDateTime createdDate,
        LocalDateTime lastModifiedDate,
        String createdBy,
        String lastModifiedBy,
        Boolean isActive,
        Integer version
) {
}
