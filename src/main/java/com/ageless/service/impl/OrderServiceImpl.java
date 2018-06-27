package com.ageless.service.impl;

import com.ageless.mapper.OrderMapper;
import com.ageless.pojo.Order;
import com.ageless.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class OrderServiceImpl implements OrderService{
    @Autowired
    private OrderMapper orderMapper;
    @Override
    public List<Order> all() {
        return orderMapper.all();
    }
}
