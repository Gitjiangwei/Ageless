package com.ageless.service;

import com.ageless.mapper.OrderMapper;
import com.ageless.pojo.Order;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderService {
    /**
     * 显示所有订单
     * @return
     */
    public List<Order> all(String status, Integer id);
    /**
     * 取消（删除）订单
     * @return
     */

    public int  delOrder(Integer id);

    /**
     * 订单详情
     * @param id
     * @return
     */
    Order order_details(Integer id);

    /**
     * 订单商品详情
     * @param id
     * @return
     */
    List<Order> order_product(Integer id);
}
