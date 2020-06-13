package com.ccsu.clouddoctor.controller;

import com.ccsu.clouddoctor.pojo.Order;
import com.ccsu.clouddoctor.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @RequestMapping("/addOrder")
    @ResponseBody
    public int addOrder(Order order){
        return orderService.addOrder(order);
    }

    @RequestMapping("/queryOrderByDate")
    @ResponseBody
    public List<Order> queryOrderByDate(@RequestParam( value = "startDate",required = false) String startDate, @RequestParam(value = "endDate",required = false) String endDate,@RequestParam(value = "username",required = false)String username){
        return  orderService.queryOrderByDate(startDate,endDate,username);
    }

}
