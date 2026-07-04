package com.example.testSetup.service;

import com.example.testSetup.entity.Booking;
import com.example.testSetup.repository.BookingRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {

    @Autowired
    BookingRepository bookingRepository;

    @Autowired
    InvetoryService invetoryService;

    @Transactional
    public Booking createBooking(Booking booking){
        boolean isInventoryUpdated = invetoryService.checkAndReduceInventory(booking.getHotelId(),booking.getRoomType(),booking.getCheckingDate(),booking.getNumOfRooms());

        if(isInventoryUpdated){
            booking.setStatus("Confimred");
        }else{
            booking.setStatus("Sorry requested rooms are not available");
        }
        return bookingRepository.save(booking);
    }

    public List<Booking> getAllBooking(){
        return bookingRepository.findAll();
    }

}
