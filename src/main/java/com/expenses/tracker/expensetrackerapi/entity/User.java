package com.expenses.tracker.expensetrackerapi.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinTable(name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id",referencedColumnName = "id") ,
            inverseJoinColumns = @JoinColumn(name="role_id",referencedColumnName = "id")
    )
    private Set<Roles> roles = new HashSet<>();
}
