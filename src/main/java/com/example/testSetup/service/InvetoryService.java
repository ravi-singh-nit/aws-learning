package com.example.testSetup.service;

import com.example.testSetup.entity.Inventory;
import com.example.testSetup.repository.InventoryRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class InvetoryService {

    @Autowired
    private InventoryRepository inventoryRepository;

    public Inventory updateInventory(Inventory inventory){
        Optional<Inventory> inventory1=inventoryRepository.findHotelByIdRoomTypeAndDate(inventory.getHotelId(),inventory.getRoomType(),inventory.getDate());
        if(inventory1.isPresent()){
            Inventory existing = inventory1.get();
            existing.setAvailableRooms(inventory.getAvailableRooms());
            inventoryRepository.save(existing);
            return existing;
        }

        return inventoryRepository.save(inventory);
    }

    public boolean checkAndReduceInventory(String hotelId, String roomType, LocalDate date, int roomsToBook){
        Optional<Inventory>  inventory= inventoryRepository.findHotelByIdRoomTypeAndDate(hotelId,roomType,date);
        if(inventory.isPresent()){
            Inventory existing = inventory.get();
            existing.setAvailableRooms(existing.getAvailableRooms()-roomsToBook);
            inventoryRepository.save(existing);
            return true;
        }

        return false;

    }

   // @PostConstruct
    public void init() throws IOException {
        List<String> lines = Files.readAllLines(Path.of("/Users/ravikumarsingh/Downloads/testSetup/src/main/resources/static/myText.txt"));
        for(String s: lines){
            System.out.println(s);
        }

        Files.writeString(Path.of("/Users/ravikumarsingh/Downloads/testSetup/src/main/resources/static/myText.txt"),"\ndhaksd  234", StandardOpenOption.APPEND);
        Files.writeString(Path.of("/Users/ravikumarsingh/Downloads/testSetup/src/main/resources/static/myText.txt"),"\nsinravk  123",StandardOpenOption.APPEND);
        Files.writeString(Path.of("/Users/ravikumarsingh/Downloads/testSetup/src/main/resources/static/myText.txt"),"\nbhasour  567",StandardOpenOption.APPEND);
        Files.writeString(Path.of("/Users/ravikumarsingh/Downloads/testSetup/src/main/resources/static/myText2.txt"),"\nhello mr ravi");

    }
}
