package com.example.testSetup.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;

import java.time.LocalDate;

@Data
@Getter
@Entity
@Table(name = "hotel_inventory")
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String hotelId;
    private String roomType;
    private LocalDate date;
    private Integer availableRooms;
}
