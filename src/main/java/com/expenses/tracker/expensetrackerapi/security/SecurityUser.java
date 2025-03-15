package com.expenses.tracker.expensetrackerapi.security;

import com.expenses.tracker.expensetrackerapi.entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class SecurityUser implements UserDetails {
    private final User user;

    public SecurityUser(User user) {
        this.user = user;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // If you have roles/permissions, map them here
       return   user.getRoles()
                 .stream()
                 .map((role) -> new SimpleGrantedAuthority(role.getName()))
               .collect(Collectors.toSet());
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true; // Customize this if needed
    }

    @Override
    public boolean isAccountNonLocked() {
        return true; // Customize this if needed
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true; // Customize this if needed
    }

    @Override
    public boolean isEnabled() {
        return user.getIsActive(); // Assume your User entity has an enabled flag
    }

    public User getUser() {
        return user;
    }
}
