package com.expenses.tracker.expensetrackerapi.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

// bank, e-wallet, cash, etc.
@Getter
@Setter
@Entity
@Table(name = "accounts")
public class Account  extends BaseEntity{

    @Column(nullable = false)
    private String name;
    @Column(name = "type")
    private String type; // saving ? e-wallet etc..
    @Column(precision = 10, scale = 2)
    private BigDecimal balance;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    User user;

    @OneToMany(mappedBy = "account",cascade = CascadeType.ALL)
    List<Transaction> transactions;

}
