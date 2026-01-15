package com.inventorymanagement.servicesimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventorymanagement.entity.GoodsReceipt;
import com.inventorymanagement.entity.Inventory;
import com.inventorymanagement.entity.Product;
import com.inventorymanagement.entity.PurchaseOrder;
import com.inventorymanagement.exception.BadRequestException;
import com.inventorymanagement.exception.ResourceNotFoundException;
import com.inventorymanagement.repository.GoodsReceiptRepository;
import com.inventorymanagement.repository.InventoryRepository;
import com.inventorymanagement.repository.PurchaseOrderRepository;
import com.inventorymanagement.services.GoodsReceiptService;

import jakarta.transaction.Transactional;

@Service
public class GoodsReceiptServiceImpl implements GoodsReceiptService {

    @Autowired
    private GoodsReceiptRepository grRepo;

    @Autowired
    private InventoryRepository inventoryRepo;

    @Autowired
    private PurchaseOrderRepository poRepo;

    @Transactional
    @Override
    public void receiveGoods(GoodsReceipt receipt) {

        // Check Purchase Order exists
        Long poId = receipt.getPurchaseOrder().getId();
        PurchaseOrder po = poRepo.findById(poId)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Purchase Order not found with id: " + poId
                        ));

        // Check Purchase Order is approved
        if (!"APPROVED".equals(po.getStatus())) {
            throw new BadRequestException(
                    "Purchase Order is not approved yet"
            );
        }

        // Save Goods Receipt
        grRepo.save(receipt);

        // Update Inventory
        Product product = receipt.getProduct();
        Long productId = product.getId();

        Inventory inventory = inventoryRepo.findById(productId).orElse(null);

        if (inventory == null) {
            inventory = new Inventory();
            inventory.setProduct(product);   
            inventory.setQuantity(receipt.getReceivedQty());
        } else {
            inventory.setQuantity(
                    inventory.getQuantity() + receipt.getReceivedQty()
            );
        }

        inventoryRepo.save(inventory);
    }
}
