package com.expenses.tracker.expensetrackerapi.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="addresses")
public class Address extends  BaseEntity{

    private String address1;
    private String address2;
    private String city;
    private String state;
    @OneToOne
    @JoinColumn(name = "tenant_id",nullable = false)
    private Tenant tenant;
}
