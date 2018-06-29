package com.ageless.service;

import com.ageless.pojo.Product;
import com.ageless.pojo.ProductAndPic;

import java.util.List;

public interface ProductAndPicService {
    /**
     * 最热商品
     * @return
     */
    public List<ProductAndPic> list();
    /**
     * 最新商品
     */
    public List<ProductAndPic> Newlist();
    /**
     * 折扣商品
     */
    /**
     * 最热商品按条件查询
     */
    public List<ProductAndPic> listbyxiaoliang(String product);

}
