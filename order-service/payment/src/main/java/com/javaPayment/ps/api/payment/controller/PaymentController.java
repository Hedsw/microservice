package com.javaPayment.ps.api.payment.controller;

import com.javaPayment.ps.api.payment.entity.Payment;
import com.javaPayment.ps.api.payment.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
@RequestMapping("/2ndservice")
public class PaymentController {

    @Autowired
    private PaymentService service;

    @PostMapping("/receiver")
    public Payment doPayment(@RequestBody Payment payment) {
        return service.doPayment(payment);
    }

    public String paymentProcessing() {
        //api should be 3rd party payment gateway (paype
        return new Random().nextBoolean()?"success":"false";
    }

}
