package com.example.testSetup.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name ="bookings")
@Data
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "mandatory field hotel id missing")
    private String hotelId;
    private LocalDate checkingDate;
    private String guestName;
    private String roomType;
    private double price;
    @Min(value = 1, message = "room ki minimum value 1 honi chahiye")
    private int numOfRooms;
    private String status;
}
