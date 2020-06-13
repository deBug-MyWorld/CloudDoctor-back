package com.ccsu.clouddoctor.service.impl;

import com.ccsu.clouddoctor.dao.CommentMapper;
import com.ccsu.clouddoctor.pojo.Comment;
import com.ccsu.clouddoctor.service.CommentService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentMapper commentMapper;
    @Override
    public int addComment(Comment comment) {
        SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date=dateFormat.format(new Date());
        comment.setCreateTime(date);
        return commentMapper.addComment(comment);
    }

    @Override
    public PageInfo<Comment> queryCommentByDoctorId(int doctorId, int pageNum, int pageSize) {
        Page<Object>page=PageHelper.startPage(pageNum,pageSize);
        List<Comment>list=commentMapper.queryCommentByDoctorId(doctorId);
        PageInfo<Comment>info=new PageInfo<>(list);
        return info;
    }

    @Override
    public int deleteCommentById(int commentId) {
        return commentMapper.deleteCommentById(commentId);
    }

    @Override
    public PageInfo<Comment> queryCommentByAdmin(int pageNum, int pageSize) {
        Page<Object>page=PageHelper.startPage(pageNum,pageSize);
        List<Comment> list =commentMapper.queryCommentByAdmin();
        PageInfo<Comment>info=new PageInfo<>(list);
        return info;
    }

    @Override
    public PageInfo<Comment> queryCommentByKey(String key, int pageNum, int pageSize) {
        Page<Object>page=PageHelper.startPage(pageNum,pageSize);
        List<Comment> list =commentMapper.queryCommentByKey(key);
        PageInfo<Comment>info=new PageInfo<>(list);
        return info;
    }
}
