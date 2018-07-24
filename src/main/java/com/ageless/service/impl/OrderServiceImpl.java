package com.ageless.service.impl;

import com.ageless.cache.JedisUtil;
import com.ageless.mapper.OrderMapper;
import com.ageless.pojo.Order;
import com.ageless.service.OrderService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

import java.util.Date;
import java.util.List;
@Service
public class OrderServiceImpl implements OrderService{
    @Autowired
    private OrderMapper orderMapper;

    public static Jedis jedis;


    private static String CREATEDATE="createDate";
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


    //订单后台需要
    @Override
    public List<Order> seleAll(String number, int id, String createDate) {

        return orderMapper.seleAll(number,id,createDate);
    }
    public List<Order> selenid(String number) {

        return orderMapper.selenid(number);
    }
    public int delete(String number){
        return orderMapper.delete(number);
    }
    public int dall(List<String> number){
        return orderMapper.dall(number);
    }

    @Override
    public int addOrder(Order order) {
        return orderMapper.addOrder(order);
    }

    @Override
    public int addOrderdet(Order order) {
        return orderMapper.addOrderdet(order);
    }

    @Override
    public int updataOrder(Integer id,Integer OrderStatus) {
        return orderMapper.updataOrder(id,OrderStatus);
    }

}
