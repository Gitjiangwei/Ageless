package com.ageless.service.impl;


import com.ageless.mapper.ProductMapper;
import com.ageless.pojo.*;
import com.ageless.service.ProductService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Resource
    private ProductMapper mapper;

    @Override
    public List<Property> selectPropertyAllById(Integer id) {
        return mapper.selectPropertyAllById(id);
    }

    @Override
    public List<ProductPic> selectAllPicById(Integer id) {
        return mapper.selectAllPicById(id);
    }

    @Override
    public Sku selectSkuByCon(String skuCon,Integer id) {
        return mapper.selectSkuByCon(skuCon,id);
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

    @Override
    public int add(Product pro) {
        return mapper.add(pro);
    }

    @Override
    public int modifyProduct(Product pro) {
        return mapper.modifyProduct(pro);
    }

    @Override
    public List<Sku> selectNullSkuByOptId(List list,Integer productId) {
        return mapper.selectNullSkuByOptId(list,productId);
    }
}
