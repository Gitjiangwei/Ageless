package com.ageless.mapper;

import com.ageless.pojo.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProductMapper {

     List<ProductPic> selectAllPicById(@Param("id") Integer id);

     Sku selectSkuByCon(@Param("skuCon") String skuCon);

     List<SkuOption> selectAllSkuoptionById(List<String> list);

     List<SkuProperty> selectAllSkupropertyByIds(List<String> list);

     List<Sku> selectAllSkuById(@Param("id") Integer id);

     Product selectPoroductById(@Param("id") Integer id);

     List<Product> selectall(@Param("id") Integer id);
}
