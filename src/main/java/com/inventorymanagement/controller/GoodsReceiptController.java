package com.inventorymanagement.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.inventorymanagement.entity.GoodsReceipt;
import com.inventorymanagement.services.GoodsReceiptService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/goods-receipts")
public class GoodsReceiptController {

	@Autowired
    private GoodsReceiptService service;

    @PostMapping
    public ResponseEntity<String> receiveGoods( @RequestBody GoodsReceipt receipt) {
	        service.receiveGoods(receipt);
	        return ResponseEntity.status(HttpStatus.CREATED).body("Goods received and inventory updated successfully");
	    }
}

