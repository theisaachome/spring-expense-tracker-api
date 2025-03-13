package com.expenses.tracker.expensetrackerapi.controller;

import com.expenses.tracker.expensetrackerapi.dto.request.AccountRequestDto;
import com.expenses.tracker.expensetrackerapi.dto.response.AccountResponseDto;
import com.expenses.tracker.expensetrackerapi.entity.Account;
import com.expenses.tracker.expensetrackerapi.service.AccountService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/accounts")
public class AccountController extends AbstractController<Account,Long, AccountRequestDto, AccountResponseDto> {

    private final AccountService accountService;
    public AccountController(AccountService accountService) {
        super(accountService);
        this.accountService = accountService;
    }
}
