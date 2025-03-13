package com.expenses.tracker.expensetrackerapi.mapper;

import com.expenses.tracker.expensetrackerapi.dto.request.TransactionRequestDto;
import com.expenses.tracker.expensetrackerapi.dto.response.TransactionResponseDto;
import com.expenses.tracker.expensetrackerapi.entity.Transaction;
import org.springframework.stereotype.Component;

@Component
public class TransactionMapper implements EntityMapper<Transaction, TransactionRequestDto, TransactionResponseDto>{

    @Override
    public Transaction toEntity(TransactionRequestDto dto) {
        var transaction = new Transaction();
        transaction.setAmount(dto.amount());
        transaction.setTransactionDate(dto.transactionDate());
        transaction.setDescription(dto.description());
        transaction.setTransactionType(dto.transactionType());
        transaction.setNote(dto.note());
        return transaction;
    }

    @Override
    public TransactionResponseDto toResponseDto(Transaction entity) {
        return new TransactionResponseDto(
                entity.getId(),
                entity.getAmount(),
                entity.getTransactionDate(),
                entity.getTransactionType(),
                entity.getNote(),
                entity.getDescription(),
                entity.getUser().getId(),
                entity.getAccount().getId(),
                entity.getCategory().getId(),
                (entity.getBudget() != null) ? entity.getBudget().getId() : null,
                entity.getCreatedDate(),
                entity.getLastModifiedDate(),
                entity.getCreatedBy(),
                entity.getLastModifiedBy(),
                entity.getIsActive(),
                entity.getVersion()
        );
    }
}
