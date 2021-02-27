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
        payment.setPaymentStatus((paymentProcessing()));
        payment.setTransactionId(UUID.randomUUID().toString());
        return repository.save(payment);
    }


    public String paymentProcessing() {
        //api should be 3rd party payment gateway (paypal, payt..)
        return new Random().nextBoolean()?"success":"false";
    }
}
