package com.inventorymanagement.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.inventorymanagement.entity.Product;
import com.inventorymanagement.services.ProductServices;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
    private ProductServices service;

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        Product saved = service.save(product);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(
            @PathVariable Long id) {

        return ResponseEntity.ok(service.getById(id));
    }
}

