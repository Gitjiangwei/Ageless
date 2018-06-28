package com.ageless.service;

import com.ageless.pojo.Product;
import com.ageless.pojo.Sku;
import com.ageless.pojo.SkuOption;
import com.ageless.pojo.SkuProperty;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProductService {

    Sku selectSkuByCon(String skuCon);

    List<SkuOption> selectAllSkuoptionById(List<String> list);

    List<SkuProperty> selectAllSkupropertyByIds(List<String> list);

    List<Sku> selectAllSkuById(Integer id);

    Product selectPoroductById(Integer id);

    public List<Product> selectall(Integer id);
}
