package com.ageless.service.impl;

import com.ageless.mapper.ShopCartMapper;
import com.ageless.pojo.ShopCart;
import com.ageless.service.ShopCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShopCartServiceImpl implements ShopCartService {
    @Autowired
    private ShopCartMapper shoppingCartMapper;
    @Override
    public int addShoppingCart(ShopCart shoppingCart) {
        return shoppingCartMapper.addShoppingCart(shoppingCart);
    }
}
