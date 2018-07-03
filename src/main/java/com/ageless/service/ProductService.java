package com.ageless.service;

import com.ageless.pojo.*;

import java.util.List;

public interface ProductService {

    List<Property> selectPropertyAllById(Integer id);

    List<ProductPic> selectAllPicById(Integer id);

    Sku selectSkuByCon(String skuCon);

    List<SkuOption> selectAllSkuoptionById(List<String> list);

    List<SkuProperty> selectAllSkupropertyByIds(List<String> list);

    List<Sku> selectAllSkuById(Integer id);

    Product selectPoroductById(Integer id);

    public List<Product> selectall(Integer id);

    int add(Product pro);
}
