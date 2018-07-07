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
    public int updateByTime(String date) {
        return shangmapper.updateByTime(date);
    }


    @Override
    public  List<Product> cha2() {
        List<Product>  xia= shangmapper.cha2();
        return xia;
    }


    @Override
    public int update(List list) {
        int result = shangmapper.update(list);
        return result;
    }


    @Override
    public List<Product>  cha() {
        List<Product>  shang = shangmapper.cha();
        return shang;
    }
}
