package com.ageless.service.impl;

import com.ageless.mapper.oneAndtwoAndthreeMapper;
import com.ageless.pojo.oneAndtwoAndthree;
import com.ageless.service.OneAndtwoAndthreeService;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OneAndtwoAndthreeServiceImpl implements OneAndtwoAndthreeService {
    @Autowired
    private oneAndtwoAndthreeMapper oneAndtwoAndthreeMapper;

    @Autowired
    RedisUtil redisUtil;
    @Override
    public List<oneAndtwoAndthree> lists() {
        redisUtil.setString("shouye",JSON.toJSONString(oneAndtwoAndthreeMapper.lists()),5000L);
        return oneAndtwoAndthreeMapper.lists();
    }


}
