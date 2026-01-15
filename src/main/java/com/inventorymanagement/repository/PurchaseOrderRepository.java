package com.inventorymanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inventorymanagement.entity.PurchaseOrder;

public interface PurchaseOrderRepository extends JpaRepository<PurchaseOrder, Long>{

}
