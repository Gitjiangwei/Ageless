package com.ageless.service.impl;

import com.ageless.mapper.EvaluateMapper;
import com.ageless.pojo.Evaluate;
import com.ageless.service.EvaluateService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class EvaluateServiceImpl implements EvaluateService {
    @Resource
    private EvaluateMapper evaluateMapper;

    @Override
    public int add(Evaluate e) {
        return evaluateMapper.add(e);
    }
}
