package com.expenses.tracker.expensetrackerapi.security;

import com.expenses.tracker.expensetrackerapi.exception.ResourceNotFoundException;
import com.expenses.tracker.expensetrackerapi.repository.UserRepo;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepo userRepository;
    public CustomUserDetailsService(UserRepo userRepository) {
        this.userRepository = userRepository;
    }
    @Override
    public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException {
        var user = userRepository.findByUsernameOrEmail(usernameOrEmail,usernameOrEmail)
                .orElseThrow(()->new ResourceNotFoundException("User not found with email Or username "+usernameOrEmail));
        Set<GrantedAuthority> grantedAuthorities =
                user.getRoles()
                        .stream()
                        .map((role)->new SimpleGrantedAuthority(role.getName()))
                        .collect(Collectors.toSet());

        return  new SecurityUser(user);
    }
}
