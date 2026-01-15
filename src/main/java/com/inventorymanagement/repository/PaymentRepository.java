package com.inventorymanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inventorymanagement.entity.Payments;

public interface PaymentRepository extends JpaRepository<Payments, Long>{

}
