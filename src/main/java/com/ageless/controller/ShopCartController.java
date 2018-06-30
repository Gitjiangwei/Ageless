package com.ageless.controller;


import com.ageless.pojo.Area;
import com.ageless.pojo.ShoppingCart;
import com.ageless.service.ShopCartService;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;
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

    @RequestMapping("/udai_shopcart_pay")
    public String udaishoppay(String zhi){
        System.out.println(zhi);
        return "udai_shopcart_pay";
    }


    //购物车查询
    @GetMapping("/selshopAll")
    @ResponseBody
    public Object  selShopsAll(){
        List<ShoppingCart>  productList =shopCartService.selshopAll();
        System.out.println(productList.size());
        Object json = JSON.toJSON(productList);
        return json;
    }


    //带值进来的方法
    @RequestMapping("/daizhi")
    public String daizhiyemian(Array zi){

        System.out.println("辅导辅导辅导费/");
        System.out.println(zi.toString().length());
        //System.out.println(zi.size());
      /*  System.out.println(zi.getLength(zi)+"*****************************************************");*/
        return "haha";
    }

/*购物车查询post方式
    @PostMapping("/selshopAll")
    @ResponseBody
    public Object selShopAll(){

    }*/

  //删除购物车商品
    @GetMapping("/delShop")
    @ResponseBody
    public Object  delShops(Integer id){
       int delShopping=shopCartService.delshop(id);
        return JSON.toJSONString(delShopping);
    }
}
