package com.inventorymanagement.servicesimpl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.inventorymanagement.entity.PurchaseOrder;
import com.inventorymanagement.exception.BadRequestException;
import com.inventorymanagement.exception.ResourceNotFoundException;
import com.inventorymanagement.repository.PurchaseOrderRepository;
import com.inventorymanagement.services.PurchaseOrderService;

@Service
public class PurchaseOrderServiceImpl implements PurchaseOrderService {

    @Autowired
    private PurchaseOrderRepository repo;

    @Override
    public PurchaseOrder create(PurchaseOrder po) {
        if (po.getVendor() == null ||po.getProduct() == null ||po.getQuantity() == null ||po.getQuantity() <= 0) {
            throw new BadRequestException("Vendor, product and valid quantity are required");
        }
        po.setStatus("CREATED");
        po.setOrderDate(LocalDate.now());
        return repo.save(po);
    }

    @Override
    public PurchaseOrder approve(Long id) {
        PurchaseOrder po = repo.findById(id).orElseThrow(() ->new ResourceNotFoundException("Purchase Order not found with id: " + id));
        if ("APPROVED".equals(po.getStatus())) {
            throw new BadRequestException("Purchase Order already approved");
        }
        po.setStatus("APPROVED");
        return repo.save(po);
    }

    @Override
    public List<PurchaseOrder> getAllOrders() {
        return repo.findAll();
    }
}

