package com.ageless.controller;


import com.ageless.pojo.Area;
import com.ageless.pojo.ShoppingCart;
import com.ageless.service.ShopCartService;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(value="/shop")
public class ShopCartController {

    @Autowired
    private ShopCartService shopCartService;

    @GetMapping("/")
    public String udai() {
        return "item_show";
    }

    @GetMapping("/udai_shopcart.html")
    public String udaishop() {
        return "udai_shopcart";
    }

    //购物车查询
    @GetMapping("/selshopAll")
    @ResponseBody
    public Object  selShopsAll(Integer uid){
        List<ShoppingCart>  productList =shopCartService.selshopAll(uid);
        Object json=JSON.toJSON(productList);
        return json;
    }

    //删除购物车商品
    @GetMapping("/delShop")
    @ResponseBody
    public Object  delShops(Integer id){
       int delShopping=shopCartService.delshop(id);
        return JSON.toJSONString(delShopping);
    }
}
