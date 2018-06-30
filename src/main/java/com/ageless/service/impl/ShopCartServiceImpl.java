package com.ageless.service.impl;

import com.ageless.mapper.ShopCartMapper;
import com.ageless.pojo.ShoppingCart;
import com.ageless.service.ShopCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ShopCartServiceImpl implements ShopCartService {
    @Resource
    private ShopCartMapper shopCartMapper;
    @Override
    public int addShoppingCart(ShoppingCart shoppingCart) {

        return shopCartMapper.addShoppingCart(shoppingCart);
    }

    @Override
    public List<ShoppingCart> selshopAll(Integer id) {
        return shopCartMapper.selshopAll(id);
    }

    @Override
    public int delshop(Integer id) {
        return shopCartMapper.delshop(id);
    }
}
