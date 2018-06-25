package com.ageless.service;

import com.ageless.pojo.ShopCart;

public interface ShopCartService {

    /**
     * 加入购物车
     * @param shoppingCart
     * @return
     */
    int addShoppingCart(ShopCart shoppingCart);
}
