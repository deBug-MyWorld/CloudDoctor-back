package com.ccsu.clouddoctor.service;

import com.ccsu.clouddoctor.pojo.ChatSubject;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ChatSubjectService {
    //增加一条聊天主题信息
    int addChatSubject(ChatSubject chatSubject);
    //根据用户id（fromId）和医生（toId）查询最近一条主题信息
    ChatSubject selectChatSubject(@Param("fromId") int fromId, @Param("toId") int toId);
    //根据医生id(toId)查询该医生处理的图文信息
    List<ChatSubject> selectChatSubjectBytoId(@Param("toId")int toId);
    //查询全部聊天主题信息（管理员）
    PageInfo<ChatSubject> queryAllChatSubject(String key,int pageNum,int pageSize);
    //根据聊天主题id删除聊天主题信息(管理员)
    int deleteChatSubjectById(int chatId);
}
