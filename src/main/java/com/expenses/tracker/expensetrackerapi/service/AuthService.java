package com.expenses.tracker.expensetrackerapi.service;

import com.expenses.tracker.expensetrackerapi.dto.request.LoginRequestDto;
import com.expenses.tracker.expensetrackerapi.dto.request.SignupRequestDto;
import com.expenses.tracker.expensetrackerapi.entity.Roles;
import com.expenses.tracker.expensetrackerapi.entity.User;
import com.expenses.tracker.expensetrackerapi.exception.ApplicationAPIException;
import com.expenses.tracker.expensetrackerapi.repository.RoleRepository;
import com.expenses.tracker.expensetrackerapi.repository.UserRepo;
import com.expenses.tracker.expensetrackerapi.security.CustomUserDetailsService;
import com.expenses.tracker.expensetrackerapi.service.impl.BaseServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class AuthService  {
    private  final CustomUserDetailsService customUserDetailsService;

    private final AuthenticationManager authenticationManager;
    private final UserRepo userRepo;
    private final UserService userService;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthService(CustomUserDetailsService customUserDetailsService,
                       AuthenticationManager authenticationManager,
                       UserRepo userRepo,
                       UserService userService,
                       RoleRepository roleRepository,
                       PasswordEncoder passwordEncoder) {
        this.customUserDetailsService = customUserDetailsService;
        this.authenticationManager = authenticationManager;
        this.userRepo = userRepo;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
        this.userService = userService;
    }

    public String login(LoginRequestDto dto){
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            dto.usernameOrEmail(),
                            dto.password())
            );
            SecurityContextHolder.getContext().setAuthentication(authentication);
            return "User logged in Successfully!";
        } catch (Exception e) {
            return "Login failed: " + e.getMessage(); // Log or return a proper error response
        }
    }
    public String signup(SignupRequestDto dto){
        // find user with given email
        if(userRepo.existsByEmail(dto.email())){
            throw new ApplicationAPIException(HttpStatus.BAD_REQUEST,"User already exist with " + dto.email());
        }
        User user = new User();
        user.setUsername(dto.username());
        user.setEmail(dto.email());
        user.setPassword(passwordEncoder.encode(dto.password())); // 🔥 Encode password before saving
        var role = roleRepository.findByName("ROLE_USER")
                .orElseThrow(() -> new ApplicationAPIException(HttpStatus.BAD_REQUEST,"Role not found"));
        user.setRoles(Set.of(role));
        var entity= userRepo.save(user);
        userService.createSampleDataForUser(entity);
        return "User registered successfully!";
    }
}
