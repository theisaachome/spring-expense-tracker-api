package com.expenses.tracker.expensetrackerapi.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "units")
public class Unit extends BaseEntity {

    @Column(nullable = false, unique = true)
    private String name; // Example: "House A" or "Apartment 101"
    @Column(nullable = false)
    private String address1;
    private String address2;

    @OneToMany(mappedBy = "unit",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Room> rooms = new ArrayList<>();
}
