package com.expenses.tracker.expensetrackerapi.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "transactions")
public class Transaction  extends  BaseEntity {

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal amount;

    @Column(name = "transaction_date",nullable = false)
    private LocalDate transactionDate;
    @Column(name = "transaction_type",nullable = false)
    @Enumerated(EnumType.STRING)
    private TransactionType transactionType;

    @Column(nullable = false)
    private String note;
    @Column(columnDefinition = "TEXT")
    private String description;

    @ManyToOne()
    @JoinColumn(nullable = false,name = "user_id")
    private User user;

    @ManyToOne()
    @JoinColumn(name = "account_id",nullable = false)
    private Account account;

    @ManyToOne()
    @JoinColumn(name = "category_id",nullable = false)
    private Category category;

    @ManyToOne()
    @JoinColumn(name = "budget_id",nullable = false)
    private Budget budget;

}
