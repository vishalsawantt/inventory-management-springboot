package com.inventorymanagement.servicesimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventorymanagement.entity.Vendors;
import com.inventorymanagement.exception.ResourceNotFoundException;
import com.inventorymanagement.repository.VendorRepository;
import com.inventorymanagement.services.VendorService;

@Service
public class VendorServiceImpl implements VendorService{
	
	@Autowired
	private VendorRepository repo;

    public Vendors save(Vendors vendor) {
        return repo.save(vendor);
    }

    public List<Vendors> getAll() {
        List<Vendors> vendors = repo.findAll();
        if (vendors.isEmpty() ) {throw new ResourceNotFoundException("No vendors found");
        }
        return vendors;
    }
}
