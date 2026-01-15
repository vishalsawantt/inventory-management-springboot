package com.inventorymanagement.servicesimpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.inventorymanagement.entity.Inventory;
import com.inventorymanagement.exception.ResourceNotFoundException;
import com.inventorymanagement.repository.InventoryRepository;
import com.inventorymanagement.services.InventoryService;

@Service
public class InventoryServiceImpl implements InventoryService {

    @Autowired
    private InventoryRepository repo;

    @Override
    public List<Inventory> getAllInventory() {
        List<Inventory> inventoryList = repo.findAll();
        if (inventoryList.isEmpty()) {
            throw new ResourceNotFoundException("Inventory is empty");
        }
        return inventoryList;
    }
}
