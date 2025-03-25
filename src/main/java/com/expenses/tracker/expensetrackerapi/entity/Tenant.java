package com.expenses.tracker.expensetrackerapi.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
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
}
