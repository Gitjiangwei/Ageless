package com.ageless.service.impl;

import com.ageless.mapper.SeckillMapper;
import com.ageless.pojo.Seckill;
import com.ageless.service.SeckillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SeckillServiceImpl implements SeckillService {
    @Autowired
    private SeckillMapper seckillMapper;
    @Override
    public List<Seckill> selectSeckill() {
        return seckillMapper.selectSeckill();
    }
}
