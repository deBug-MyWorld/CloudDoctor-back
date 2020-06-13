package com.ccsu.clouddoctor.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChatSubject {
    private int chatId;
    private int fromId;
    private String fromName;
    private int toId;
    private String toName;
    private String img;
    private String title;
    private String message;
    private String createTime;
}
