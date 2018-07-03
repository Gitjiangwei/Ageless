package com.ageless.controller;

import com.ageless.pojo.Order;
import com.ageless.service.OrderService;
import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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

    //进入商品页面
    @RequestMapping("/show")
    public String show(){
        return "udai_order";
    }

    //查询所有订单
    @RequestMapping("/all")
    @ResponseBody
    public Object all(@RequestParam(required = false) String status,
        @RequestParam(required = false)Integer id){
            List<Order> all = orderService.all(status,id);
            return JSON.toJSONString(all);
        }
        //查看订单详情
        @GetMapping("/udai_order_detail.html")
        public String udaishop(Model model, @RequestParam(required = false) String status,
                @RequestParam(required = false)Integer id) {
            Order address=orderService.order_details(id);
            List<Order> allProduct=orderService.order_product(id);
            model.addAttribute("item",address);
            model.addAttribute("items",allProduct);
            return "udai_order_detail";
        }

        //订单取消（删除）
        @RequestMapping("/delorder")
        @ResponseBody
        public Object  delorder(Integer delid){
            int delOrd=orderService.delOrder(delid);
            Object json=JSON.toJSON(delOrd);
            return json;
    }

}
