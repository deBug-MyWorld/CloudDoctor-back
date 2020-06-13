package com.ccsu.clouddoctor.dao;

import com.ccsu.clouddoctor.pojo.Order;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderMapper {
    //增加一条流水信息
    int addOrder(Order order);
    //根据日期查询明细
    List<Order> queryOrderByDate(@Param("startDate") String starDate, @Param("endDate") String endDate,@Param("username")String username);
}
