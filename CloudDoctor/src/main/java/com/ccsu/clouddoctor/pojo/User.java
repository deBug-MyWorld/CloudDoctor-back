package com.ccsu.clouddoctor.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private int id;
    private String username;
    private String password;
    private String icon;
    private double money;
    private String place;
    private int age;
    private String sex;
    private String birthday;
    private String phone;
    private String email;
    private int isDoctor;
    private int isAdmin;
}
