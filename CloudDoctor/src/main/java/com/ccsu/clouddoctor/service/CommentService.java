package com.ccsu.clouddoctor.service;

import com.ccsu.clouddoctor.pojo.Comment;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;

public interface CommentService {
    //增加一条评论
    int addComment(Comment comment);
    //查询该医生的全部评论
    PageInfo<Comment> queryCommentByDoctorId(@Param("doctorId")int doctorId,int pageNum,int pageSize);
    //根据评论id删除评论
    int deleteCommentById(@Param("commentId")int commentId);
    //查询所有评论(管理员)
    PageInfo<Comment> queryCommentByAdmin(int pageNum,int pageSize);
    //根据用户名或者医生名模糊查询评论信息(管理员)
    PageInfo<Comment> queryCommentByKey(String key,int pageNum,int pageSize);
}
