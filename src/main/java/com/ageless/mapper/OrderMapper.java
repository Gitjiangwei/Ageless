package com.ageless.mapper;

import com.ageless.pojo.Order;

import java.util.List;

public interface OrderMapper {
    /**
     * 显示所有订单
     * @return
     */
    public List<Order> all();
}
