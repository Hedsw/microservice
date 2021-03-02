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
    private double datasize;
    // ADD
    private String filename;
    private String uploader;
    //
    private String transactionId;
    private String message;


}
