package com.ageless.service.impl;

import com.ageless.mapper.SkuMapper;
import com.ageless.pojo.Sku;
import com.ageless.service.SkuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SkuServiceImpl implements SkuService {

    @Resource
    private SkuMapper mapper;
    @Override
    public int addSku(List<Sku> sk, Integer productId) {
        return mapper.addSku(sk,productId);
    }
}
