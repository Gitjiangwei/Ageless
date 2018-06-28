package com.ageless.controller;

import com.ageless.pojo.Order;
import com.ageless.service.OrderService;
import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping(value="/Order")
public class OrderController {
    @Resource
    private OrderService orderService;
    @RequestMapping("/show")
    public String show(){
        return "udai_order";
    }
    @RequestMapping("/all")
    @ResponseBody
    public Object all(@RequestParam(required = false) String status){
        List<Order> all = orderService.all(status);
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!"+JSON.toJSONString(all));
        return JSON.toJSONString(all);
    }
}
