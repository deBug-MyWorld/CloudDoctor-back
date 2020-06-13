package com.ccsu.clouddoctor.service.impl;

import com.ccsu.clouddoctor.dao.ChatContentMapper;
import com.ccsu.clouddoctor.pojo.ChatContent;
import com.ccsu.clouddoctor.service.ChatContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
@Service
public class ChatContentServiceImpl implements ChatContentService {
    @Autowired
    private ChatContentMapper chatContentMapper;
    @Override
    public int addChatContent(ChatContent chatContent) {
        SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date=dateFormat.format(new Date());
        chatContent.setCreateTime(date);
        return chatContentMapper.addChatContent(chatContent);
    }

    @Override
    public List<ChatContent> selectChatContentByChatId(int chatId) {
        return chatContentMapper.selectChatContentByChatId(chatId);
    }

    @Override
    public int deleteChatContentByChatId(int chatId) {
        return chatContentMapper.deleteChatContentByChatId(chatId);
    }
}
