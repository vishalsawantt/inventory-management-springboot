package com.inventorymanagement.services;

import java.util.List;

import com.inventorymanagement.entity.Product;

public interface ProductServices {

    Product save(Product product);

    List<Product> getAll();

    Product getById(Long id);
}