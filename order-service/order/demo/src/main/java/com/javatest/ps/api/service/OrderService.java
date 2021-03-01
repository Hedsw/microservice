package com.javatest.ps.api.service;

import com.javatest.ps.api.common.Payment;
import com.javatest.ps.api.common.Response;
import com.javatest.ps.api.common.TransactionRequest;
import com.javatest.ps.api.common.TransactionResponse;
import com.javatest.ps.api.entity.Order;
import com.javatest.ps.api.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repository;

    @Autowired
    private RestTemplate template;

    public Response saveOrder(TransactionRequest request) {
        String response ="";
        Order order = request.getOrder();
        Payment payment = request.getPayment();
        payment.setOrderId(order.getId());
        payment.setAmount(order.getPrice());

        //rest call
        Payment paymentResponse = template.postForObject("http://localhost:9194/payment/doPayment", payment, Payment.class);

        response = paymentResponse.getPaymentStatus().equals("success")?"payment processing successful and order placed" : "there is a failure in payment api, order added to cart";

        repository.save(order);
        return new Response(order, paymentResponse.getAmount(), paymentResponse.getTransactionId(), response);
    }
}
