package com.ccsu.clouddoctor.dao;

import com.ccsu.clouddoctor.pojo.ChatContent;

import java.util.List;

public interface ChatContentMapper {
    //新增聊天记录
    int addChatContent(ChatContent chatContent);
    //根据聊天主题查询聊天记录(管理员)
    List<ChatContent>selectChatContentByChatId(int chatId);
    //根据聊天主题id删除聊天记录(管理员)
    int deleteChatContentByChatId(int chatId);
}

