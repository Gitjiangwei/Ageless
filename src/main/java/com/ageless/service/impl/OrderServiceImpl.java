package com.ageless.service.impl;

import com.ageless.mapper.OrderMapper;
import com.ageless.pojo.Order;
import com.ageless.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrderServiceImpl implements OrderService{
    @Autowired
    private OrderMapper orderMapper;
    @Override
    public List<Order> all(String status,Integer id) {
        return orderMapper.all(status, id);
    }

    @Override
    public int delOrder(Integer id) {
        return orderMapper.delOrder(id);
    }

    @Override
    public Order order_details(Integer id) {
        return orderMapper.order_details(id);
    }

    @Override
    public List<Order> order_product(Integer id) {
        return orderMapper.order_product(id);
    }

}
