package com.ccsu.clouddoctor.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private String username;
    private String orderId;
    private String orderDate;
    private int income;
    private int outcome;
    private int res;
    private int status;
}
