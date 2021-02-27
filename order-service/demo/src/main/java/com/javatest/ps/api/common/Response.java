package com.javatest.ps.api.common;

import com.javatest.ps.api.entity.Order;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Response {
    private Order order;
    private double amount;
    private String transactionId;
    private String message;

}
