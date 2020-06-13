package com.ccsu.clouddoctor.service.impl;

import com.ccsu.clouddoctor.dao.OrderMapper;
import com.ccsu.clouddoctor.pojo.Order;
import com.ccsu.clouddoctor.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderMapper orderMapper;
    @Override
    public int addOrder(Order order) {
        String uuid=UUID.randomUUID().toString().replaceAll("-","");
        order.setOrderId(uuid);
        SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date=dateFormat.format(new Date());
        order.setOrderDate(date);
        return orderMapper.addOrder(order);
    }

    @Override
    public List<Order> queryOrderByDate(String starDate, String endDate, String username) {
        return orderMapper.queryOrderByDate(starDate,endDate,username);
    }



}
