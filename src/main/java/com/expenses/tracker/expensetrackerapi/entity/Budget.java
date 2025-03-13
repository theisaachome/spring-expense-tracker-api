package com.expenses.tracker.expensetrackerapi.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "budgets")
public class Budget  extends   BaseEntity{
    @Column(name = "name",nullable = false)
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "budget_limit",nullable = false, precision = 10, scale = 2)
    private BigDecimal budgetLimit;
    @Column(name = "period_start")
    private LocalDate periodStart;
    @Column(name = "period_end")
    private LocalDate periodEnd;

    @ManyToOne
    @JoinColumn(name = "user_id",nullable = false)
    User user;

    @OneToMany(mappedBy = "budget")
    List<Transaction> transactions;

    public Budget(String name, String description, BigDecimal budgetLimit, LocalDate periodStart, LocalDate periodEnd, User user) {
        this.name = name;
        this.description = description;
        this.budgetLimit = budgetLimit;
        this.periodStart = periodStart;
        this.periodEnd = periodEnd;
        this.user = user;
    }
}
