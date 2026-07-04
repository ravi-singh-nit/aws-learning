package com.example.testSetup.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Passport {

    @Id
    private Long id;

    private String passportNumber;
}