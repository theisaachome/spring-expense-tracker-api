package com.expenses.tracker.expensetrackerapi.mapper;
import com.expenses.tracker.expensetrackerapi.dto.request.AccountRequestDto;
import com.expenses.tracker.expensetrackerapi.dto.request.UserRequestDto;
import com.expenses.tracker.expensetrackerapi.dto.response.AccountResponseDto;
import com.expenses.tracker.expensetrackerapi.dto.response.UserResponseDto;
import com.expenses.tracker.expensetrackerapi.entity.Account;
import com.expenses.tracker.expensetrackerapi.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserMapper implements EntityMapper<User, UserRequestDto,UserResponseDto> {

    @Autowired
    private AccountMapper   accountMapper;
    @Override
    public User toEntity(UserRequestDto dto) {
        var userEntity = new User();
        userEntity.setUsername(dto.username());
        userEntity.setPassword(dto.password());
        userEntity.setEmail(dto.email());
        return userEntity;
    }

    @Override
    public UserResponseDto toResponseDto(User entity) {
        return new UserResponseDto(
                entity.getId(),
                entity.getUsername(),
                entity.getEmail(),
                entity.getCreatedDate(),
                entity.getLastModifiedDate(),
                entity.getCreatedBy(),
                entity.getLastModifiedBy(),
                entity.getIsActive(),
                entity.getVersion()
//                entity.getAccounts().stream().map(accountMapper::toResponseDto).collect(Collectors.toList())
//                entity.getBudgets(),
//                entity.getCategories()
        );
    }
}
