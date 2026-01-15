package com.inventorymanagement.services;

import java.util.List;

import com.inventorymanagement.entity.PurchaseOrder;

public interface PurchaseOrderService {
	PurchaseOrder create(PurchaseOrder po);
    PurchaseOrder approve(Long id);
    List<PurchaseOrder> getAllOrders();
}
