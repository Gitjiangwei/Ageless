package com.ageless.service.impl;

import com.ageless.mapper.oneAndtwoAndthreeMapper;
import com.ageless.pojo.oneAndtwoAndthree;
import com.ageless.service.OneAndtwoAndthreeService;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class OneAndtwoAndthreeServiceImpl implements OneAndtwoAndthreeService {
    @Resource
    private oneAndtwoAndthreeMapper oneAndtwoAndthreeMapper;

    @Autowired
    RedisUtil redisUtil;
    @Override
    public List<oneAndtwoAndthree> lists() {
        redisUtil.setString("shouye",JSON.toJSONString(oneAndtwoAndthreeMapper.lists()));
        return oneAndtwoAndthreeMapper.lists();
    }


}
