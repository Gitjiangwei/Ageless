package com.ageless.service.impl;

import com.ageless.mapper.ProductAndPicMapper;
import com.ageless.pojo.ProductAndPic;
import com.ageless.service.ProductAndPicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductAndPicServiceImpl implements ProductAndPicService {

    @Autowired
    private ProductAndPicMapper productMapper;


    @Override
    public List<ProductAndPic> list() {
        return productMapper.list();
    }

    @Override
    public List<ProductAndPic> Newlist() {
        return productMapper.Newlist();
    }

    @Override
    public List<ProductAndPic> listbyxiaoliang(String  product) {
        return productMapper.listbyxiaoliang(product);
    }

    @Override
    public List<ProductAndPic> listbyupdate(String upda) {
        return productMapper.listbyupdate(upda);
    }

    @Override
    public int addPic(List<String> lp, Integer productId) {
        return productMapper.addPic(lp,productId);
    }
}
