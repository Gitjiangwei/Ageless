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

import javax.annotation.Resource;
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
    @Resource
    private ProductService productService;

    @GetMapping("/")
    public String udai() {
        return "item_show";
    }
    @GetMapping("/shopcart.html")
    public String shopcart() {
        return "udai_shopcart";
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
    public String udaishoppay(ModelAndView modelAndView, @RequestParam int totalMoney, @RequestParam String checkeItem[],@RequestParam String xinitem[]) {
        productList=new ArrayList<ShoppingCart>();     //每次进来给赋值为空
        if(checkeItem!=null) {
            ShoppingCart shoppingCart = null;
            for (int i = 0; i < checkeItem.length; i++) {
                shoppingCart = new ShoppingCart();
                shoppingCart.setId(Integer.parseInt(checkeItem[i]));
                shoppingCart.setOrderamount(Integer.parseInt(xinitem[i]));
                shopCartService.repairNumberById(shoppingCart);
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

        for (int i = 0; i < productList.size(); i++) {
            String  orderamount = productList.get(i).getSKUcon();
            String s = skuString(orderamount);                                //得到的是一个String型的数据
            System.out.println("---------------------"+s+"--------------------------------");
            productList.get(i).setOptiinName(s);
            /*productList.add(shoppingCart);*/
        }
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
        List<ShoppingCart>  productList =shopCartService.selshopAll();   //查询出来的集合
        System.out.println("-------------------------------------------" + productList.size());
        for (int i = 0; i < productList.size(); i++) {
            String  orderamount = productList.get(i).getSKUcon();
            String s = skuString(orderamount);                              //得到的是一个String型的数据
            System.out.println("---------------------"+s+"--------------------------------");
            productList.get(i).setOptiinName(s);
            /*productList.add(shoppingCart);*/
        }
        Object json = JSON.toJSON(productList);
        return json;
    }


/*    //带值进来的方法
    @RequestMapping("/daizhi")
    public String daizhiyemian(Array zi){

        System.out.println("辅导辅导辅导费/");
        System.out.println(zi.toString().length());
        //System.out.println(zi.size());
      *//*  System.out.println(zi.getLength(zi)+"*****************************************************");*//*
        return "haha";
    }*/

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

    public String skuString(String skuCon){
        StringBuffer sku = new StringBuffer();
        String substring = skuCon.substring(0, skuCon.length()-1);//截取最后一个
        System.out.println(substring);
        String[] split = substring.split(",");//以逗号分割
        Integer len = split.length;
        List<String> skuPropertyIds = new ArrayList<>();
        List<String> skuOptionIds = new ArrayList<>();
        for (String string2 : split) {
            int q = 0;
            for(int i=0;i<string2.length();i++) {
                if(string2.indexOf(":", i)!=-1){
                    q++;
                }
            }
            String skucon1 = string2.substring(q,string2.length());
            String skucon2 = string2.substring(0,q-1);

            if (!skuOptionIds.contains(skucon1)){
                skuOptionIds.add(skucon1);
            }
            if (!skuPropertyIds.contains(skucon2)){
                skuPropertyIds.add(skucon2);
            }
        }
        //service是：
        //  @Resource
        //  private ProductService service;
        List<SkuProperty> properties = productService.selectAllSkupropertyByIds(skuPropertyIds);
        List<SkuOption> options = productService.selectAllSkuoptionById(skuOptionIds);
        for (String string2 : split) {
            int q = 0;
            for(int j=0;j<string2.length();j++) {
                if(string2.indexOf(":", j)!=-1){
                    q++;
                }
            }
            String skucon1 = string2.substring(q,string2.length());
            String skucon2 = string2.substring(0,q-1);
            for (SkuProperty property:properties) {
                if (Integer.parseInt(skucon2) == property.getId()){
                    sku.append(property.getPropertyName()+":");
                }
            }
            for (SkuOption option:options) {
                if (Integer.parseInt(skucon1) == option.getId()){
                    sku.append(option.getOptionName()+",");
                }
            }
        }
        String skus = sku.toString().substring(0, sku.length()-1);//截取最后一个
        return skus;
    }

}
