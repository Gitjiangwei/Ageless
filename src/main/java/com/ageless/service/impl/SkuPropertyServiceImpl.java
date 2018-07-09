package com.ageless.service.impl;

import com.ageless.mapper.SkuPropertyMapper;
import com.ageless.pojo.SkuOption;
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
    public List<SkuProperty> seleAll(Integer id,String name, Integer Pid) {
        return skuPropertyMapper.seleAll(id,name,Pid);
    }

    @Override
    public int shan(int id) {
        return skuPropertyMapper.shan(id);
    }

    @Override
    public int shan1(int id) {
        return skuPropertyMapper.shan1(id);
    }

    @Override
    public int add(SkuProperty sku) {
        return skuPropertyMapper.add(sku);
    }

    @Override
    public int addSkuOption(List<SkuOption> ls, Integer id) {
        return skuPropertyMapper.addSkuOption(ls,id);
    }

    @Override
    public int updateSku(Integer id, String name) {
        return skuPropertyMapper.updateSku(id,name);
    }

    @Override
    public int updateOption(Integer id, String name) {
        return skuPropertyMapper.updateOption(id,name);
    }
}
