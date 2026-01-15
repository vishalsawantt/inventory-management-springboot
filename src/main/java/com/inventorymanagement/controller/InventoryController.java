package com.inventorymanagement.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.inventorymanagement.entity.Inventory;
import com.inventorymanagement.services.InventoryService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/inventory")
public class InventoryController {

    @Autowired
    private InventoryService service;

    // Fetch all inventory data
    @GetMapping
    public ResponseEntity<List<Inventory>> getAllInventory() {
        return ResponseEntity.ok(service.getAllInventory());
    }
}

