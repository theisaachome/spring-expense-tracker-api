package com.expenses.tracker.expensetrackerapi.controller;

import com.expenses.tracker.expensetrackerapi.dto.request.BudgetRequestDto;
import com.expenses.tracker.expensetrackerapi.dto.response.BudgetResponseDto;
import com.expenses.tracker.expensetrackerapi.entity.Budget;
import com.expenses.tracker.expensetrackerapi.service.BudgetService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/budgets")
public class BudgetController extends AbstractController<Budget,Long, BudgetRequestDto, BudgetResponseDto> {

    private final BudgetService budgetService;
    public BudgetController(BudgetService budgetService) {
        super(budgetService);
        this.budgetService = budgetService;
    }

}
