package com.ageless.mapper;

import com.ageless.pojo.Product;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ShangMapper {
    /**
     * 查询所有商品（已上架）
     * @param
     * @return
     */
   public List<Product>  cha();
    /**
     *对商品状态的修改（下架）
     * @param
     * @return
     */
   public int update(@Param("list")List list);
    /**
     * 查询所有商品（未上架）
     * @param
     * @return
     */
    public List<Product>  cha2();
    /**
     *对商品状态的修改（上架）
     * @param
     * @return
     */
    public int update1(@Param("list")List list);

    public int updateByTime(String date);
}
