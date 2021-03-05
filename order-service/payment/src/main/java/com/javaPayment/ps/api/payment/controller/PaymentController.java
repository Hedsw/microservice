package com.javaPayment.ps.api.payment.controller;

import com.javaPayment.ps.api.payment.entity.Payment;
import com.javaPayment.ps.api.payment.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{orderId")
    public Payment findPaymentHistoryByOrderId(int orderId) {
        return service.findPaymentHistoryByOrderId(orderId);
    }


}
