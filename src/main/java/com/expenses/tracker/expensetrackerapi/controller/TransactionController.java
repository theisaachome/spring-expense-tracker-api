package com.expenses.tracker.expensetrackerapi.controller;

import com.expenses.tracker.expensetrackerapi.dto.request.TransactionRequestDto;
import com.expenses.tracker.expensetrackerapi.dto.response.TransactionResponseDto;
import com.expenses.tracker.expensetrackerapi.entity.Transaction;
import com.expenses.tracker.expensetrackerapi.service.TransactionService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/transactions")
public class TransactionController extends AbstractController<Transaction,Long, TransactionRequestDto, TransactionResponseDto> {
    public TransactionController(TransactionService transactionService) {
        super(transactionService);
    }
}
