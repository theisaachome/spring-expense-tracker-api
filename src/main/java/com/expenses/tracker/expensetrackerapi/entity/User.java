package com.expenses.tracker.expensetrackerapi.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "users")
public class User extends BaseEntity {

    @Column(unique = true, nullable = false)
    private String username;
    @Column(nullable = false)
    private String password;
    @Column(unique = true, nullable = false)
    private String email;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "user")
    private List<Account> accounts;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "user")
    private List<Budget> budgets;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private List<Category> categories;
}
