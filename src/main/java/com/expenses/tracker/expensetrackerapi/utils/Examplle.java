package com.expenses.tracker.expensetrackerapi.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Examplle {
    public static void main(String[] args) {
        System.out.println(new BCryptPasswordEncoder().encode("password"));
    }
}
