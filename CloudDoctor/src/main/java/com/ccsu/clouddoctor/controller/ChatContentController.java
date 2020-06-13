package com.ccsu.clouddoctor.controller;

import com.ccsu.clouddoctor.pojo.ChatContent;
import com.ccsu.clouddoctor.service.ChatContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/chatContent")
public class ChatContentController {
    @Autowired
    private ChatContentService chatContentService;

    @RequestMapping("/addChatContent")
    @ResponseBody
    public int addChatContent(ChatContent chatContent){
        return chatContentService.addChatContent(chatContent);
    }

    @RequestMapping("/selectChatContentByChatId")
    @ResponseBody
    public List<ChatContent> selectChatContentByChatId(@RequestParam("chatId")int chatId){
        return chatContentService.selectChatContentByChatId(chatId);
    }
    @RequestMapping("/deleteChatContentByChatId")
    @ResponseBody
    public int deleteChatContentByChatId(@RequestParam("chatId")int chatId){
        return chatContentService.deleteChatContentByChatId(chatId);
    }
}
