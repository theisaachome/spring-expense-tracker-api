package com.expenses.tracker.expensetrackerapi.entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "categories")
public class Category extends BaseEntity{

    @Column(name = "name",nullable=false)
    private String name;
    @Column(name = "description")
    private String description;
    @ManyToOne
    @JoinColumn(name = "user_id",nullable=false)
    private User user;

    @OneToMany(mappedBy = "category")
    private List<Transaction> transactions;

}
