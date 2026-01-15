package com.inventorymanagement.entity;

import java.time.LocalDate;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class PurchaseOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Vendors vendor;

    @ManyToOne
    private Product product;

    private Integer quantity;

    private String status; // CREATED, APPROVED

    private LocalDate orderDate;
}
