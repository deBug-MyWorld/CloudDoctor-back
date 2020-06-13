package com.ccsu.clouddoctor.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Doctor {
    private int doctorId;
    private String doctorName;
    private String departmentBig;
    private String departmentSmall;
    private String icon;
    private String description;
    private String goodAt;
    private String createTime;
    private String createName;
    private int tag;
    private double price;
    private int isFree;
    private double rate;
    private int recommend;
}
