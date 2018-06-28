package com.ageless.service;

import com.ageless.mapper.OrderMapper;
import com.ageless.pojo.Order;

import java.util.List;

public interface OrderService {
    /**
     * 显示所有订单
     * @return
     */
    public List<Order> all(String status);
}
