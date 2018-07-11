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

    /**
     * 取消（删除）订单
     * @return
     */

    public int  delOrder(@Param("id") Integer id);

    /**
     * 订单详情
     * @param id
     * @return
     */
    Order order_details(@Param("id") Integer id);

    /**
     * 订单商品详情
     * @param id
     * @return
     */
    List<Order> order_product(@Param("id") Integer id);

    //订单后台需要
    List<Order> seleAll(@Param("number")String number, @Param("id") int id, @Param("createDate") String createDate);
    List<Order> selenid(@Param("number")String number);
    int delete(@Param("number")String number);
    int dall(List<String> number);

    /**
     * 支付确认生成订单---添加订单
     */
    public int addOrder(Order order);
    public int addOrderdet(Order order);
}
