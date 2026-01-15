package com.inventorymanagement.servicesimpl;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventorymanagement.entity.Payments;
import com.inventorymanagement.repository.PaymentRepository;
import com.inventorymanagement.services.PaymentService;

@Service
public class PaymentServiceImpl implements PaymentService{
	
	@Autowired
	private PaymentRepository repo;

    public Payments makePayment(Payments payment) {
        payment.setPaymentDate(LocalDate.now());
        return repo.save(payment);
    }
}
