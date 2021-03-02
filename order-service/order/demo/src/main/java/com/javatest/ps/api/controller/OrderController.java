package com.javatest.ps.api.controller;


import com.javatest.ps.api.common.Payment;
import com.javatest.ps.api.common.Response;
import com.javatest.ps.api.common.TransactionRequest;
import com.javatest.ps.api.entity.Order;
import com.javatest.ps.api.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
@RequestMapping("/1stservice")
public class OrderController {

    @Autowired
    private OrderService service;

    @PostMapping("/sender")
    public Response bookOrder(@RequestBody TransactionRequest request) {

        return service.saveOrder(request);
    }
}
