package com.inventorymanagement.servicesimpl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.inventorymanagement.entity.Product;
import com.inventorymanagement.exception.ResourceNotFoundException;
import com.inventorymanagement.repository.ProductRepository;
import com.inventorymanagement.services.ProductServices;

import java.util.List;

@Service
public class ProductServicesImpl implements ProductServices {

	@Autowired
    private ProductRepository repo;

    @Override
    public Product save(Product product) {
        return repo.save(product);
    }

    @Override
    public List<Product> getAll() {
        return repo.findAll();
    }

    @Override
    public Product getById(Long id) {
        return repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product not found with id: " + id));
    }
}

