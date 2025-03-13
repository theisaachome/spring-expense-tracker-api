package com.expenses.tracker.expensetrackerapi.mapper;

import com.expenses.tracker.expensetrackerapi.dto.request.BudgetRequestDto;
import com.expenses.tracker.expensetrackerapi.dto.response.BudgetResponseDto;
import com.expenses.tracker.expensetrackerapi.entity.Budget;
import org.springframework.stereotype.Component;

@Component
public class BudgetMapper implements EntityMapper<Budget,BudgetRequestDto, BudgetResponseDto>{


    @Override
    public Budget toEntity(BudgetRequestDto dto) {
        var entity = new Budget();
        entity.setName(dto.budgetName());
        entity.setDescription(dto.description());
        entity.setBudgetLimit(dto.budgetLimit());
        entity.setPeriodStart(dto.periodStart());
        entity.setPeriodEnd(dto.periodEnd());
        return entity;
    }

    @Override
    public BudgetResponseDto toResponseDto(Budget entity) {
        return new BudgetResponseDto(
                entity.getName(),
                entity.getDescription(),
                entity.getBudgetLimit(),
                entity.getPeriodStart(),
                entity.getPeriodEnd(),
                entity.getUser().getId(),
                entity.getCreatedDate(),
                entity.getLastModifiedDate(),
                entity.getCreatedBy(),
                entity.getLastModifiedBy(),
                entity.getIsActive(),
                entity.getVersion()
        );
    }
}
