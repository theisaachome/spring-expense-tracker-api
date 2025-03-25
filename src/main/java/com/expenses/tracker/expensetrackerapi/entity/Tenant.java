package com.expenses.tracker.expensetrackerapi.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table(name="tenants")
@Entity
public class Tenant extends BaseEntity {
    private String fullname;
    private String email;
    private String phone;
    private String emergencyContactPhone;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "bedId",nullable = false)
    private Bed bed;
    @OneToOne(mappedBy = "tenant",cascade = CascadeType.ALL,orphanRemoval = true)
    private Address address;
}
