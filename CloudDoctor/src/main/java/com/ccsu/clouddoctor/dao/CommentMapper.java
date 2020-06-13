package com.ccsu.clouddoctor.dao;

import com.ccsu.clouddoctor.pojo.Comment;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CommentMapper {
    //增加一条评论
    int addComment(Comment comment);
    //查询该医生的全部评论
    List<Comment> queryCommentByDoctorId(@Param("doctorId")int doctorId);
    //根据评论id删除评论
    int deleteCommentById(@Param("commentId")int commentId);
    //查询所有评论(管理员)
    List<Comment> queryCommentByAdmin();
    //根据用户名或者医生名模糊查询评论信息(管理员)
    List<Comment> queryCommentByKey(String key);

}
