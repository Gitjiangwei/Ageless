package com.ageless.mapper;

import com.ageless.pojo.ShopCart;

public interface ShopCartMapper {

    /**
     * 加入购物车
     * @param shoppingCart
     * @return
     */
    int addShoppingCart(ShopCart shoppingCart);

}
