package com.ageless.controller;

import com.ageless.pojo.SkuOption;
import com.ageless.pojo.SkuProperty;
import com.ageless.service.ProductService;
import com.ageless.pojo.ShoppingCart;
import com.ageless.service.ShopCartService;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import lombok.Builder;
import org.apache.commons.collections.bag.SynchronizedSortedBag;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping(value="/shop")
public class ShopCartController {

    List<ShoppingCart> productList=new ArrayList<ShoppingCart>();
    int totalAllMoney=0;
    @Autowired
    private ShopCartService shopCartService;
    private ProductService productService;

    @GetMapping("/")
    public String udai() {
        return "item_show";
    }

    @PostMapping("/udai_shopcart.html")
    @ResponseBody
    public Integer udaishop(@RequestParam("skuId") Integer skuId,@RequestParam("id") Integer id) {

        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setUserId(1);
        shoppingCart.setProductId(id);
        shoppingCart.setOrderamount(1);
        shoppingCart.setSkuid(skuId);
        Integer index = shopCartService.addShoppingCart(shoppingCart);

        return index;
    }

    @RequestMapping("/udai_shopcart_pay")
    public String udaishoppay(ModelAndView modelAndView, @RequestParam int totalMoney, @RequestParam String checkeItem[]) {
        productList=new ArrayList<ShoppingCart>();
        /*System.out.println("要结算的商品的produceid" + checkeItem[0] + "结算的价钱：" + totalMoney);*/
        if(checkeItem!=null) {
            for (int i = 0; i < checkeItem.length; i++) {
                Integer productId = Integer.parseInt(checkeItem[i]);
                productList.add(shopCartService.queryShopChecked(productId));
            }
        }
        totalAllMoney=totalMoney;
        System.out.println(productList.size()+"******"+totalMoney);

        return "udai_shopcart_pay";
    }
    //获取list集合
    @RequestMapping("/getList")
    @ResponseBody
    public Object getData(){
        return   JSON.toJSONString(productList);
    }
    //获取总金额
    @GetMapping("/getTotalMoney")
    @ResponseBody
    public Object getTotalMoney(){
        System.out.println(totalAllMoney+"/////////////////////////////////");
        return JSON.toJSONString(totalAllMoney);
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
