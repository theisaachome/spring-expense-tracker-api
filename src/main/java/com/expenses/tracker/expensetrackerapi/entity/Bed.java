package com.expenses.tracker.expensetrackerapi.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "beds")
public class Bed extends BaseEntity{
    @Column(nullable = false)
    private Integer bedNumber;// Example: 1, 2, 3 (for shared rooms)
    @Column(name = "bed_number_str")
    private String bedNoStr; // // Example: bed-101, bed-202, bed-303 (for shared rooms) optional

    @ManyToOne
    @JoinColumn(name = "room_id", nullable = false)
    private Room room;

}
