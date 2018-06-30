package com.ageless.service;

import com.ageless.pojo.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProductService {

    List<ProductPic> selectAllPicById(Integer id);

    Sku selectSkuByCon(String skuCon);

    List<SkuOption> selectAllSkuoptionById(List<String> list);

    List<SkuProperty> selectAllSkupropertyByIds(List<String> list);

    List<Sku> selectAllSkuById(Integer id);

    Product selectPoroductById(Integer id);

    public List<Product> selectall(Integer id);
}
