package com.expenses.tracker.expensetrackerapi.repository;

import com.expenses.tracker.expensetrackerapi.dto.CategoryExpenseSummary;
import com.expenses.tracker.expensetrackerapi.entity.Transaction;
import com.expenses.tracker.expensetrackerapi.entity.TransactionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    // Basic queries
    List<Transaction> findByUserId(Long userId);
    List<Transaction> findByUserIdAndTransactionType(Long userId, TransactionType transactionType);
    List<Transaction> findByUserIdAndTransactionDateBetween(Long userId, LocalDate startDate, LocalDate endDate);
    List<Transaction> findByUserIdAndBudgetId(Long userId, Long budgetId);
    List<Transaction> findByUserIdAndAccountId(Long userId, Long accountId);
    List<Transaction> findByUserIdAndCategoryId(Long userId, Long categoryId);

    // For budget analysis
    @Query("SELECT SUM(t.amount) FROM Transaction t WHERE t.user.id = :userId AND t.transactionType = 'EXPENSE' AND t.budget.id = :budgetId AND t.transactionDate BETWEEN :startDate AND :endDate")
    BigDecimal sumExpensesByBudgetAndDateRange(
            @Param("userId") Long userId,
            @Param("budgetId") Long budgetId,
            @Param("startDate") LocalDate startDate,
            @Param("endDate") LocalDate endDate
    );

    // For income analysis
    @Query("SELECT SUM(t.amount) FROM Transaction t WHERE t.user.id = :userId AND t.transactionType = :type AND t.transactionDate BETWEEN :startDate AND :endDate")
    BigDecimal sumByTypeAndDateRange(
            @Param("userId") Long userId,
            @Param("type") TransactionType type,
            @Param("startDate") LocalDate startDate,
            @Param("endDate") LocalDate endDate
    );

    // Budget utilization - percentage of budget used
    @Query("SELECT (SUM(t.amount) / b.budgetLimit) * 100 FROM Transaction t JOIN t.budget b WHERE t.user.id = :userId AND t.transactionType = 'EXPENSE' AND t.budget.id = :budgetId AND t.transactionDate BETWEEN :startDate AND :endDate")
    BigDecimal calculateBudgetUtilizationPercentage(
            @Param("userId") Long userId,
            @Param("budgetId") Long budgetId,
            @Param("startDate") LocalDate startDate,
            @Param("endDate") LocalDate endDate
    );

    // Transactions by category for a specific budget
    @Query("SELECT t.category.name, SUM(t.amount) FROM Transaction t WHERE t.user.id = :userId AND t.transactionType = 'EXPENSE' AND t.budget.id = :budgetId AND t.transactionDate BETWEEN :startDate AND :endDate GROUP BY t.category.name")
    List<CategoryExpenseSummary> expensesByCategoryForBudget(
            @Param("userId") Long userId,
            @Param("budgetId") Long budgetId,
            @Param("startDate") LocalDate startDate,
            @Param("endDate") LocalDate endDate
    );
}
