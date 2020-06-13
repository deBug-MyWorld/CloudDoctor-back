package com.ccsu.clouddoctor.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comment {
    private int commentId;
    private int doctorId;
    private String doctorName;
    private String username;
    private String icon;
    private String content;
    private int star;
    private String createTime;
}
