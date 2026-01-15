package com.inventorymanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inventorymanagement.entity.Inventory;

public interface InventoryRepository extends JpaRepository<Inventory, Long>{

}
