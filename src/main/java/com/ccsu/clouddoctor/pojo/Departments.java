package com.ccsu.clouddoctor.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Departments {
    private int departmentId;
    private String department;
    private String departmentSmall;
    private String createTime;
    private String createName;
    private int tag;
}
