package com.inventorymanagement.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.inventorymanagement.entity.Payments;
import com.inventorymanagement.services.PaymentService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/payments")
public class PaymentController {

	@Autowired
    private PaymentService service;

    @PostMapping
    public ResponseEntity<Payments> makePayment(@RequestBody Payments payment) {
        Payments savedPayment = service.makePayment(payment);
        return new ResponseEntity<>(savedPayment, HttpStatus.CREATED);
    }
}
