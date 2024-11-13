package com.bravebrilliant.dormregis.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="person")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @ManyToOne
    @JoinColumn(name = "room_no")
    private Room room;
}
