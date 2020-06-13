package com.ccsu.clouddoctor.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Illness {
    private int illnessId;
    private String illness;
    private String img;
    private String summarize;
    private String causeDisease;
    private String symptoms;
    private String illnessCheck;
    private String treatment;
    private String complications;
    private String prevention;
    private String diet;
    private String createTime;
    private String createName;
    private int tag;
}
