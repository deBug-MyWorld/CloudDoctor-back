package com.ccsu.clouddoctor.controller;

import com.ccsu.clouddoctor.pojo.Comment;
import com.ccsu.clouddoctor.service.CommentService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    private CommentService commentService;

    @RequestMapping("/addComment")
    @ResponseBody
    public int addComment(Comment comment){
        return commentService.addComment(comment);
    }
    @RequestMapping("/queryCommentByDoctorId")
    @ResponseBody
    public PageInfo<Comment> queryCommentByDoctorId(@RequestParam("doctorId")int doctorId, @RequestParam("pageNum") int pageNum, @RequestParam("pageSize") int pageSize){
        return commentService.queryCommentByDoctorId(doctorId,pageNum,pageSize);
    }

    @RequestMapping("/deleteCommentById")
    @ResponseBody
    public int deleteCommentById(@RequestParam("commentId")int commentId){
            return commentService.deleteCommentById(commentId);
    }

    @RequestMapping("/queryCommentByAdmin")
    @ResponseBody
    public PageInfo<Comment>queryCommentByAdmin(@RequestParam("pageNum") int pageNum, @RequestParam("pageSize") int pageSize){
        return commentService.queryCommentByAdmin(pageNum, pageSize);
    }
    @RequestMapping("/queryCommentByKey")
    @ResponseBody
    public PageInfo<Comment>queryCommentByKey(@RequestParam("key")String key,@RequestParam("pageNum") int pageNum, @RequestParam("pageSize") int pageSize){
        return commentService.queryCommentByKey(key, pageNum, pageSize);
    }
}
