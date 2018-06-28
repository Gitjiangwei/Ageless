package com.ageless.service.impl;

import com.ageless.mapper.SkuPropertyMapper;
import com.ageless.pojo.SkuProperty;
import com.ageless.service.SkuPropertyService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SkuPropertyServiceImpl implements SkuPropertyService {


    @Resource
    private SkuPropertyMapper skuPropertyMapper;
    @Override
    public List<SkuProperty> seleAll(int id,String name) {
        return skuPropertyMapper.seleAll(id,name);
    }

    @Override
    public int shan(int id) {
        return skuPropertyMapper.shan(id);
    }

    @Override
    public int shan1(int id) {
        return skuPropertyMapper.shan1(id);
    }
}
