package com.ccsu.clouddoctor.service;

import com.ccsu.clouddoctor.pojo.ChatContent;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ChatContentService {
    //新增聊天记录
    int addChatContent(ChatContent chatContent);
    //根据聊天主题查询聊天记录
    List<ChatContent> selectChatContentByChatId(@Param("chatId") int chatId);
    //根据聊天主题id删除聊天记录(管理员)
    int deleteChatContentByChatId(@Param("chatId")int chatId);
}
