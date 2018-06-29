package com.ageless.mapper;

import com.ageless.pojo.Product;
import com.ageless.pojo.Sku;
import com.ageless.pojo.SkuOption;
import com.ageless.pojo.SkuProperty;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProductMapper {

     Sku selectSkuByCon(@Param("skuCon") String skuCon);

     List<SkuOption> selectAllSkuoptionById(List<String> list);

     List<SkuProperty> selectAllSkupropertyByIds(List<String> list);

     List<Sku> selectAllSkuById(@Param("id") Integer id);

     Product selectPoroductById(@Param("id") Integer id);

     List<Product> selectall(@Param("id") Integer id);
}
