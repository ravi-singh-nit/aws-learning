package com.example.testSetup.controller;

import com.example.testSetup.entity.Inventory;
import com.example.testSetup.service.InvetoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/v1/inventory")
public class InentoryController {

    @Autowired
    private InvetoryService invetoryService;


    @PostMapping("/setup")
    public ResponseEntity<Inventory>  setupInventory(@RequestBody Inventory inventory){
        return ResponseEntity.ok(invetoryService.updateInventory(inventory));
    }


}
