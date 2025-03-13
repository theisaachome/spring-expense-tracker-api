package com.expenses.tracker.expensetrackerapi.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
@Getter
@Setter
public class CategoryExpenseSummary {
    private String categoryName;
    private BigDecimal totalAmount;

    public CategoryExpenseSummary(String categoryName, BigDecimal totalAmount) {
        this.categoryName = categoryName;
        this.totalAmount = totalAmount;
    }
}
