package com.ccsu.clouddoctor.dao;

import com.ccsu.clouddoctor.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    //增加一个用户
    int addUser(User user);
    //根据用户名查询用户
    User queryUserByUname(String username);
    //根据用户名修改用户信息
    int updateUserByUname(User user);
    //上传头像
    int updateIcon(@Param("url")String url,@Param("username") String username);
    //修改密码
    int updatePassWord(@Param("password") String password,@Param("username") String username);
    //余额充值
    int updateMoney(@Param("username")String username,@Param("money")double money);
    //查询所有用户（管理员）
    List<User> queryAllUser();
    //修改用户信息(管理员)
    int updateUserByAdmin(User user);
    //根据用户id删除用户信息（管理员）
    int deleteUserByAdmin(@Param("id")int id);
}
