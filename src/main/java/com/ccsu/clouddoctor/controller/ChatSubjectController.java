package com.ccsu.clouddoctor.controller;


import com.ccsu.clouddoctor.pojo.ChatSubject;
import com.ccsu.clouddoctor.service.ChatSubjectService;
import com.ccsu.clouddoctor.utils.SavePic;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/chatSubject")
public class ChatSubjectController {
    @Autowired
    private ChatSubjectService chatSubjectService;
    @RequestMapping("/PicsUpload")
    @ResponseBody
    public String PicsUpload(@RequestParam( value = "file",required = false)MultipartFile[] files, @RequestParam("title")String title,@RequestParam("message")String message,@RequestParam("fromId")int fromId,@RequestParam("fromName")String fromName,@RequestParam("toId")int toId,@RequestParam("toName")String toName) throws IOException {
        String img="";
        for (int i=0;i<files.length;i++){
            String path = "D:\\vue2\\cloudDoctor\\static\\PicsUpload";
            SavePic.savePic(files[i].getInputStream(),files[i].getOriginalFilename(),path);
            String imgTmp="http://localhost:8082/static/PicsUpload/"+files[i].getOriginalFilename();
            img=imgTmp+"|"+img;
        }
        ChatSubject chatSubject = new ChatSubject();
        chatSubject.setTitle(title);
        chatSubject.setFromId(fromId);
        chatSubject.setFromName(fromName);
        chatSubject.setImg(img);
        chatSubject.setMessage(message);
        chatSubject.setToId(toId);
        chatSubject.setToName(toName);
        chatSubjectService.addChatSubject(chatSubject);
        return "ok";
    }

    @RequestMapping("/selectChatSubject")
    @ResponseBody
    public ChatSubject selectChatSubject(@RequestParam("fromId")int fromId,@RequestParam("toId")int toId){
        return chatSubjectService.selectChatSubject(fromId,toId);
    }

    @RequestMapping("/selectChatSubjectBytoId")
    @ResponseBody
    public List<ChatSubject> selectChatSubjectBytoId(@RequestParam("toId")int toId){
        return chatSubjectService.selectChatSubjectBytoId(toId);
    }

    @RequestMapping("/queryAllChatSubject")
    @ResponseBody
    public PageInfo<ChatSubject> queryAllChatSubject(@RequestParam("key")String key,@RequestParam("pageNum") int pageNum, @RequestParam("pageSize") int pageSize){
        return chatSubjectService.queryAllChatSubject(key, pageNum, pageSize);
    }

    @RequestMapping("/deleteChatSubjectById")
    @ResponseBody
    public int deleteChatSubjectById(@RequestParam("chatId")int chatId){
        return chatSubjectService.deleteChatSubjectById(chatId);
    }
}
