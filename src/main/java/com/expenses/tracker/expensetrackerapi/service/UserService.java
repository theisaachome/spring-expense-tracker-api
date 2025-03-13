package com.expenses.tracker.expensetrackerapi.service;

import com.expenses.tracker.expensetrackerapi.dto.request.UserRequestDto;
import com.expenses.tracker.expensetrackerapi.dto.response.UserResponseDto;
import com.expenses.tracker.expensetrackerapi.entity.User;
import com.expenses.tracker.expensetrackerapi.mapper.UserMapper;
import com.expenses.tracker.expensetrackerapi.repository.UserRepo;
import com.expenses.tracker.expensetrackerapi.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class UserService extends BaseServiceImpl<User,Long, UserRequestDto,UserResponseDto> {

    private final UserRepo userRepo;
    private final UserMapper userMapper;
    public UserService(UserRepo userRepo, UserMapper userMapper){
        super(userRepo,userMapper);
        this.userMapper=userMapper;
        this.userRepo = userRepo;
    }


    @Override
    protected void updateEntity(User existingUser, UserRequestDto dto) {
        existingUser.setUsername(dto.username());
        existingUser.setPassword(dto.password());
        existingUser.setEmail(dto.email());
    }
}
