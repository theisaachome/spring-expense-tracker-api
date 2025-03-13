package com.expenses.tracker.expensetrackerapi.dto.request;

import com.expenses.tracker.expensetrackerapi.entity.Transaction;
import com.expenses.tracker.expensetrackerapi.entity.TransactionType;

import java.math.BigDecimal;
import java.time.LocalDate;

public record TransactionRequestDto(
        BigDecimal amount,
        LocalDate transactionDate,
        TransactionType transactionType,
        String note,
        String description,
        Long userId,
        Long accountId,
        Long categoryId,
        Long budgetId
) {

    public static TransactionRequestDto fromEntity(Transaction transaction) {
        return new TransactionRequestDto(
                transaction.getAmount(),
                transaction.getTransactionDate(),
                transaction.getTransactionType(),
                transaction.getNote(),
                transaction.getDescription(),
                transaction.getUser().getId(),
                transaction.getAccount().getId(),
                transaction.getCategory().getId(),
                transaction.getBudget().getId()
        );
    }
}
