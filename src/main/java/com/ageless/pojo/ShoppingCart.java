package com.ageless.pojo;

import lombok.Data;

@Data
public class ShoppingCart {

    private int id;    //购物车编号
    private int userId;   //用户编号
    private int productId;  //商品编号
    private int orderamount;   //订购数量
    private Sku  sku;           //商品sku表
    private Product product;    //商品表



    private String picPath; //商品图片地址
    private Integer price; //商品的价格
    private String productName; //商品的名称



}
