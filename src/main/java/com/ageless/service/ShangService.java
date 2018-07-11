package com.ageless.service;

import com.ageless.pojo.Product;

import java.util.List;

public interface ShangService {
    /**
     * 查询所有商品（已上架）
     * @param
     * @return
     */
   public List<Product> cha();
    /**
     *对商品状态的修改（下架）
     * @param
     * @return
     */
    public int update(List list);
    /**
     * 查询所有商品（未上架）
     * @param
     * @return
     */
   public List<Product> cha2();
    /**
     *对商品状态的修改（上架）
     * @param
     * @return
     */
    public int update1(List list);

    public int updateByTime(String date);
}
