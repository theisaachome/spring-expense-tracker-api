package com.expenses.tracker.expensetrackerapi.repository;

import com.expenses.tracker.expensetrackerapi.entity.Budget;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BudgetRepository extends JpaRepository<Budget, Long> {
    List<Budget> findByUserId(Long userId);
    void deleteByUserId(Long userId);
}
