package com.inventorymanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inventorymanagement.entity.GoodsReceipt;

public interface GoodsReceiptRepository extends JpaRepository<GoodsReceipt, Long>{

}
