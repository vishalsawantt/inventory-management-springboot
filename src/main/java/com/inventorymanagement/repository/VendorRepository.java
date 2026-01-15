package com.inventorymanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inventorymanagement.entity.Vendors;

public interface VendorRepository extends JpaRepository<Vendors, Long>{

}
