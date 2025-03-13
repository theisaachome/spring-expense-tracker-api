package com.expenses.tracker.expensetrackerapi.service;

import com.expenses.tracker.expensetrackerapi.dto.request.BudgetRequestDto;
import com.expenses.tracker.expensetrackerapi.dto.response.BudgetResponseDto;
import com.expenses.tracker.expensetrackerapi.entity.Budget;
import com.expenses.tracker.expensetrackerapi.exception.ResourceNotFoundException;
import com.expenses.tracker.expensetrackerapi.mapper.BudgetMapper;
import com.expenses.tracker.expensetrackerapi.repository.BudgetRepository;
import com.expenses.tracker.expensetrackerapi.repository.UserRepo;
import com.expenses.tracker.expensetrackerapi.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class BudgetService extends BaseServiceImpl<Budget,Long, BudgetRequestDto, BudgetResponseDto> {

    private final UserRepo userRepo;
    public BudgetService(BudgetRepository budgetRepository, BudgetMapper budgetMapper,UserRepo userRepo) {
        super(budgetRepository, budgetMapper);
        this.userRepo = userRepo;
    }

    @Override
    protected void preSave(Budget entity, BudgetRequestDto dto) {
        // find user
        var user = userRepo.findById(dto.userId())
                .orElseThrow(() -> new ResourceNotFoundException("User","ID", dto.userId()));
        entity.setUser(user);
    }

    @Override
    protected void updateEntity(Budget existingEntity, BudgetRequestDto dto) {
        existingEntity.setName(dto.budgetName());
        existingEntity.setDescription(dto.description());
        existingEntity.setBudgetLimit(dto.budgetLimit());
        existingEntity.setPeriodStart(dto.periodStart());
        existingEntity.setPeriodEnd(dto.periodEnd());
    }
}
