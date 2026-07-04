package com.example.testSetup.controller;

import com.example.testSetup.entity.Booking;
import com.example.testSetup.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/booking")
public class BookinController {

    @Autowired
    private BookingService bookingService;

    @PostMapping("/book")
    public ResponseEntity<Booking> createBooking(@RequestBody Booking booking){
        return ResponseEntity.ok(bookingService.createBooking(booking));
    }

    @GetMapping("/fetchAll")
    ResponseEntity<List<Booking>> getAllBooking(){
        return ResponseEntity.ok(bookingService.getAllBooking());
    }
}
