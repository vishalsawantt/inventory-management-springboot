package com.inventorymanagement.services;

import java.util.List;

import com.inventorymanagement.entity.Vendors;

public interface VendorService {
	Vendors save(Vendors vendor);
    List<Vendors> getAll();
}
