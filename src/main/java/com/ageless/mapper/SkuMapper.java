package com.ageless.mapper;

import com.ageless.pojo.Sku;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SkuMapper {
//sku添加
    int addSku(@Param("list")List<Sku> sk, @Param("productId") Integer productId);

    /*int modifySku(Sku sku);*/

    int deleteSku(Integer productId);
}
