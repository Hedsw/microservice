package com.javaPayment.ps.api.payment.service;

import com.javaPayment.ps.api.payment.entity.Payment;
import com.javaPayment.ps.api.payment.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.UUID;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository repository;

    public Payment doPayment(Payment payment) {
        payment.setTransactionId(UUID.randomUUID().toString());
        payment.setPaymentStatus(paymentProcessing());
        return repository.save(payment);
    }

    public String paymentProcessing() {
        return new Random().nextBoolean()?"success":"success"; // Success or Fail
    }

    public Payment findPaymentHistoryByOrderId(int orderId) {
        return repository.findByOrderId(orderId);
    }
}