package com.ageless.service.impl;

import com.ageless.mapper.ShangMapper;
import com.ageless.pojo.Product;
import com.ageless.service.ShangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ShangServiceImpl implements ShangService {
    @Autowired
    private ShangMapper shangmapper;
    @Override
    public int update1(List list) {
        int result = shangmapper.update1(list);
        return result;
    }


    @Override
    public List<Product> cha2() {
        List<Product> product = shangmapper.cha2();
        return product;
    }


    @Override
    public int update(List list) {
        int result = shangmapper.update(list);
        return result;
    }


    @Override
    public List<Product> cha() {
        List<Product> product = shangmapper.cha();
        return product;
    }
}
