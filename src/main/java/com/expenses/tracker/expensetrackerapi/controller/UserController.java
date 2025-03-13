package com.expenses.tracker.expensetrackerapi.controller;

import com.expenses.tracker.expensetrackerapi.dto.request.UserRequestDto;
import com.expenses.tracker.expensetrackerapi.dto.response.UserResponseDto;
import com.expenses.tracker.expensetrackerapi.entity.User;
import com.expenses.tracker.expensetrackerapi.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users")
public class UserController extends AbstractController<User,Long, UserRequestDto,UserResponseDto> {
    public UserController(UserService userService) {
        super(userService);
    }
}
