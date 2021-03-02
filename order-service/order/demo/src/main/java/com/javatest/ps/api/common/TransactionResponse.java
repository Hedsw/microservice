package com.javatest.ps.api.common;

import com.javatest.ps.api.entity.Order;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionResponse {
    private Order order;
    private double datasize;
    // ADD
    private double filename;
    private double uploader;
    //
    private String transactionId;
    private String message;
}
