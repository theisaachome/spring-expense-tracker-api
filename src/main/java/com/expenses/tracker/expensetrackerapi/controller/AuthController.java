package com.expenses.tracker.expensetrackerapi.controller;

import com.expenses.tracker.expensetrackerapi.dto.request.LoginRequestDto;
import com.expenses.tracker.expensetrackerapi.dto.request.SignupRequestDto;
import com.expenses.tracker.expensetrackerapi.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("login")
    public ResponseEntity<String> login(@RequestBody LoginRequestDto dto) {
        String result = authService.login(dto);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping(value = {"/signup","/register"})
    public ResponseEntity<String> signup(@RequestBody SignupRequestDto dto) {
        return new ResponseEntity<>(authService.signup(dto), HttpStatus.CREATED);
    }

}
