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
        payment.setDatasize(order.getDatasize());
        payment.setUploader(order.getUploader());
        payment.setFilename(order.getFilename());

        //rest call
        Payment paymentResponse = template.postForObject("http://localhost:9194/2ndservice/receiver", payment, Payment.class);
        // We can switch the First MicroService URL to below like this when we use Eureka
        //Payment paymentResponse = template.postForObject("http://SECONDMICROSERVICE/2ndservice/receiver", payment, Payment.class);


        response = paymentResponse.getPaymentStatus().equals("success")?"payment processing successful and file is placed" : "Successfully sent the file to second MicroService ";

        repository.save(order);
        return new Response(order, paymentResponse.getDatasize(), paymentResponse.getFilename(), paymentResponse.getUploader(), paymentResponse.getTransactionId(), response);
        //ADD
        //return new Response(order, paymentResponse.getAmount(), paymentResponse.getTransactionId(), response);

    }
}
