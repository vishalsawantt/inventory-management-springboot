package com.inventorymanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.inventorymanagement.entity.Inventory;
import com.inventorymanagement.entity.PurchaseOrder;
import com.inventorymanagement.services.PurchaseOrderService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/purchase-orders")
public class PurchaseOrderController {

    @Autowired
    private PurchaseOrderService service;

    // Create PO
    @PostMapping
    public ResponseEntity<PurchaseOrder> create(@RequestBody PurchaseOrder po) {
        return new ResponseEntity<>(service.create(po), HttpStatus.CREATED);
    }

    // Approve PO
    @PutMapping("/{id}/approve")
    public ResponseEntity<PurchaseOrder> approve(@PathVariable Long id) {
        return ResponseEntity.ok(service.approve(id));
    }

    // Get all PO
    @GetMapping
    public ResponseEntity<List<PurchaseOrder>> getAllOrders() {
        return ResponseEntity.ok(service.getAllOrders());
    }
}


