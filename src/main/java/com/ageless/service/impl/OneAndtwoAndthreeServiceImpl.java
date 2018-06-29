package com.ageless.service.impl;

import com.ageless.mapper.oneAndtwoAndthreeMapper;
import com.ageless.pojo.oneAndtwoAndthree;
import com.ageless.service.OneAndtwoAndthreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OneAndtwoAndthreeServiceImpl implements OneAndtwoAndthreeService {
    @Autowired
    private oneAndtwoAndthreeMapper oneAndtwoAndthreeMapper;
    @Override
    public List<oneAndtwoAndthree> lists() {
        return oneAndtwoAndthreeMapper.lists();
    }
}
