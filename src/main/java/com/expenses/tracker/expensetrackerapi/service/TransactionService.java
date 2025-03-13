package com.expenses.tracker.expensetrackerapi.service;

import com.expenses.tracker.expensetrackerapi.dto.request.TransactionRequestDto;
import com.expenses.tracker.expensetrackerapi.dto.response.TransactionResponseDto;
import com.expenses.tracker.expensetrackerapi.entity.Transaction;
import com.expenses.tracker.expensetrackerapi.exception.ResourceNotFoundException;
import com.expenses.tracker.expensetrackerapi.mapper.TransactionMapper;
import com.expenses.tracker.expensetrackerapi.repository.*;
import com.expenses.tracker.expensetrackerapi.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class TransactionService  extends BaseServiceImpl<Transaction,Long, TransactionRequestDto, TransactionResponseDto> {
    private final UserRepo userRepository;
    private final AccountRepository accountRepository;
    private final BudgetRepository budgetRepository;
    private final CategoryRepository categoryRepository;

    public TransactionService(TransactionRepository repository, TransactionMapper transactionMapper, UserRepo userRepository, AccountRepository accountRepository, BudgetRepository budgetRepository, CategoryRepository categoryRepository) {
        super(repository, transactionMapper);
        this.userRepository = userRepository;
        this.accountRepository = accountRepository;
        this.budgetRepository = budgetRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    protected void preSave(Transaction entity, TransactionRequestDto dto) {
        var user = userRepository.findById(dto.userId())
                .orElseThrow(()-> new ResourceNotFoundException("User","ID", dto.userId()));
        var account = accountRepository.findById(dto.accountId())
                .orElseThrow(()-> new ResourceNotFoundException("Account","ID", dto.accountId()));
        var budget = budgetRepository.findById(dto.budgetId())
                .orElseThrow(()-> new ResourceNotFoundException("Budget","ID", dto.budgetId()));
        var category = categoryRepository.findById(dto.categoryId())
                .orElseThrow(()-> new ResourceNotFoundException("Category","ID", dto.categoryId()));

        entity.setUser(user);
        entity.setAccount(account);
        entity.setCategory(category);
        entity.setBudget(budget);
    }

    @Override
    protected void updateEntity(Transaction existingEntity, TransactionRequestDto dto) {
        existingEntity.setAmount(dto.amount());
        existingEntity.setTransactionType(dto.transactionType());
        existingEntity.setTransactionDate(dto.transactionDate());
        existingEntity.setDescription(dto.description());
        existingEntity.setNote(dto.note());
    }
}
