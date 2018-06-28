package com.ageless.service.impl;


import com.ageless.mapper.ProductMapper;
import com.ageless.pojo.Product;
import com.ageless.pojo.Sku;
import com.ageless.pojo.SkuOption;
import com.ageless.pojo.SkuProperty;
import com.ageless.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Resource
    private ProductMapper mapper;

    @Override
    public Sku selectSkuByCon(String skuCon) {
        return mapper.selectSkuByCon(skuCon);
    }

    @Override
    public List<SkuOption> selectAllSkuoptionById(List<String> list) {
        return mapper.selectAllSkuoptionById(list);
    }

    @Override
    public List<SkuProperty> selectAllSkupropertyByIds(List<String> list) {
        return mapper.selectAllSkupropertyByIds(list);
    }

    @Override
    public List<Sku> selectAllSkuById(Integer id) {
        return mapper.selectAllSkuById(id);
    }

    @Override
    public Product selectPoroductById(Integer id) {
        return mapper.selectPoroductById(id);
    }

    @Override
    public List<Product> selectall(Integer id) {
        return mapper.selectall(id);
    }
}
