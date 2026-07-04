package com.example.testSetup.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class User {

    @Id
    private Long id;

    private String name;

    @OneToOne
    @JoinColumn(name = "passport_id")
    private Passport passport;
}
