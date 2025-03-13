package com.expenses.tracker.expensetrackerapi.mapper;

import com.expenses.tracker.expensetrackerapi.dto.request.AccountRequestDto;
import com.expenses.tracker.expensetrackerapi.dto.response.AccountResponseDto;
import com.expenses.tracker.expensetrackerapi.dto.response.BaseResponse;
import com.expenses.tracker.expensetrackerapi.entity.Account;
import org.springframework.stereotype.Component;

@Component
public class AccountMapper implements  EntityMapper<Account, AccountRequestDto,AccountResponseDto> {
    @Override
    public Account toEntity(AccountRequestDto dto) {
        var account = new Account();
        account.setName(dto.name());
        account.setType(dto.type());
        account.setBalance(dto.balance());
        return account;
    }

    @Override
    public AccountResponseDto toResponseDto(Account entity) {
        return new AccountResponseDto(
                entity.getName(),
                entity.getType(),
                entity.getBalance(),
                entity.getUser().getId(),
                        entity.getCreatedDate(),
                        entity.getLastModifiedDate(),
                        entity.getCreatedBy(),
                        entity.getLastModifiedBy(),
                        entity.getIsActive(),
                        entity.getVersion());
    }
}
