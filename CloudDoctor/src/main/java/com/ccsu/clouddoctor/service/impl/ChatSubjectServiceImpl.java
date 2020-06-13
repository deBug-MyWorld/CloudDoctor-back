package com.ccsu.clouddoctor.service.impl;

import com.ccsu.clouddoctor.dao.ChatSubjectMapper;
import com.ccsu.clouddoctor.pojo.ChatSubject;
import com.ccsu.clouddoctor.service.ChatSubjectService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
@Service
public class ChatSubjectServiceImpl implements ChatSubjectService {
    @Autowired
    private ChatSubjectMapper chatSubjectMapper;
    @Override
    public int addChatSubject(ChatSubject chatSubject) {
        SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date=dateFormat.format(new Date());
        chatSubject.setCreateTime(date);
        return chatSubjectMapper.addChatSubject(chatSubject);
    }

    @Override
    public ChatSubject selectChatSubject(int fromId, int toId) {
        return chatSubjectMapper.selectChatSubject(fromId,toId);
    }

    @Override
    public List<ChatSubject> selectChatSubjectBytoId(int toId) {
        return chatSubjectMapper.selectChatSubjectBytoId(toId);
    }

    @Override
    public PageInfo<ChatSubject> queryAllChatSubject(String key,int pageNum,int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<ChatSubject> list= chatSubjectMapper.queryAllChatSubject(key);
        PageInfo<ChatSubject> info=new PageInfo<>(list);
        return info;
    }

    @Override
    public int deleteChatSubjectById(int chatId) {
        return chatSubjectMapper.deleteChatSubjectById(chatId);
    }
}
