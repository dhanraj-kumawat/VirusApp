package com.example.virus.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "doctor_tb")
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String code;
    private String name;
    private String address;
    private String email;
    private String contactNo;
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Hospital> hospitals;
}
