package com.expenses.tracker.expensetrackerapi.service;

import com.expenses.tracker.expensetrackerapi.dto.request.AccountRequestDto;
import com.expenses.tracker.expensetrackerapi.dto.response.AccountResponseDto;
import com.expenses.tracker.expensetrackerapi.entity.Account;
import com.expenses.tracker.expensetrackerapi.exception.ResourceNotFoundException;
import com.expenses.tracker.expensetrackerapi.mapper.AccountMapper;
import com.expenses.tracker.expensetrackerapi.repository.AccountRepository;
import com.expenses.tracker.expensetrackerapi.repository.UserRepo;
import com.expenses.tracker.expensetrackerapi.service.impl.BaseServiceImpl;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

@Service
public class AccountService extends BaseServiceImpl<Account,Long, AccountRequestDto, AccountResponseDto> {

    private final AccountMapper accountMapper;
    private final UserRepo userRepo;

    public AccountService(AccountRepository accountRepository,AccountMapper accountMapper,
                          UserRepo userRepo) {
        super(accountRepository, accountMapper);
        this.accountMapper = accountMapper;
        this.userRepo = userRepo;
    }

    @PreAuthorize("hasRole('ADMIN')")
    @Override
    public AccountResponseDto save(AccountRequestDto dto) {
        var user = userRepo.findById(dto.userId())
                .orElseThrow(()->new ResourceNotFoundException("User ","ID", dto.userId()));
        var account = accountMapper.toEntity(dto);
        account.setUser(user);
        return accountMapper.toResponseDto(repository.save(account));
    }

    @Override
    protected void updateEntity(Account existingAccount, AccountRequestDto dto) {
        // Find the user first
        var user = userRepo.findById(dto.userId())
                .orElseThrow(() -> new ResourceNotFoundException("User not found", "ID", dto.userId()));
        // Update only the fields that can be changed
        existingAccount.setName(dto.name());
        existingAccount.setType(dto.type());
        existingAccount.setBalance(dto.balance());
        existingAccount.setUser(user); // Assign the user
    }
}
