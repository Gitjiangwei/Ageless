package com.ageless.service.impl;

import com.ageless.mapper.ShopCartMapper;
import com.ageless.pojo.ShopCart;
import com.ageless.pojo.ShoppingCart;
import com.ageless.service.ShopCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopCartServiceImpl implements ShopCartService{
    @Autowired
    private ShopCartMapper shoppingCartMapper;
    @Override
    public int addShoppingCart(ShoppingCart shoppingCart) {

        return shoppingCartMapper.addShoppingCart(shoppingCart);
    }

    @Override
    public List<ShoppingCart> selshopAll() {
        return shoppingCartMapper.selshopAll();
    }

    @Override
    public int delshop(Integer id) {
        return shoppingCartMapper.delshop(id);
    }

    @Override
    public ShoppingCart queryShopChecked(Integer productId) {
        return shoppingCartMapper.queryShopChecked(productId);
    }

    @Override
    public int repairNumberById(ShoppingCart shoppingCart) {
        return shoppingCartMapper.repairNumberById(shoppingCart);
    }


}
