package com.javatest.ps.api.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="sender_TB")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Order {
    @Id
    private int id;
    private String name;
    private int qty;
    private double datasize;
    // ADD
    private String filename;
    private String uploader;
    //

}
