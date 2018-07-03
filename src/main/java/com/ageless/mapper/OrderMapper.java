package com.ageless.mapper;

import com.ageless.pojo.Order;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderMapper {
    /**
     * 显示所有订单
     * @return
     */
    public List<Order> all(@Param("status") String status, @Param("id") Integer id);
}
