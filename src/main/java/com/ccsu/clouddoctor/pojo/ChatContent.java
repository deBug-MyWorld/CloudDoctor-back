package com.ccsu.clouddoctor.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChatContent {
    private int contentId;
    private int chatId;
    private int fromId;
    private int toId;
    private String message;
    private String createTime;
}
