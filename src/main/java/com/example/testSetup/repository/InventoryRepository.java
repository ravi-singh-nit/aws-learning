package com.example.testSetup.repository;

import com.example.testSetup.entity.Inventory;
import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory ,Long> {

    //Optional<Inventory> findByHotelIdAndRoomTypeAndDate(String hotelId, String roomType, LocalDate date);
   // @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query("select hi from Inventory hi where hi.hotelId =:id and hi.roomType=:roomType and hi.date=:date")
    Optional<Inventory> findHotelByIdRoomTypeAndDate(@Param("id") String hotelid, @Param("roomType") String roomType, @Param("date") LocalDate date);
}
