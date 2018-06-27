package com.ageless.controller;

import com.ageless.pojo.Order;
import com.ageless.service.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping(value="/Order")
public class OrderController {
    @Resource
    private OrderService orderService;
    @RequestMapping("/all")
    public String all(){
        List<Order> all = orderService.all();
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!"+all);
        if(all!=null){
            return "{\"hh\":\"ok\"}";
        }else{
            return "{\"hh\":\"no\"}";
        }
    }
}
