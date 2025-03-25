package com.expenses.tracker.expensetrackerapi.entity;

import jakarta.persistence.Entity;
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
}
