package com.inventorymanagement.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.inventorymanagement.entity.Vendors;
import com.inventorymanagement.services.VendorService;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/vendors")

public class VendorController {

	@Autowired
    private VendorService service;

    @PostMapping
    public ResponseEntity<Vendors> createVendor(@RequestBody Vendors vendor) {
        Vendors savedVendor = service.save(vendor);
        return new ResponseEntity<>(savedVendor, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Vendors>> getAllVendors() {
        return ResponseEntity.ok(service.getAll());
    }
}

