package com.expenses.tracker.expensetrackerapi.dto.response;

import java.time.LocalDateTime;
import java.util.List;
public record UserResponseDto(
        Long id,
        String username,
        String email,
        LocalDateTime createdDate,
        LocalDateTime lastModifiedDate,
        String createdBy,
        String lastModifiedBy,
        Boolean isActive,
        Integer version
//        List<AccountResponseDto> accounts
//        List<BudgetResponseDto> budgets,
//        List<CategoryResponseDto> categories
) {
}
