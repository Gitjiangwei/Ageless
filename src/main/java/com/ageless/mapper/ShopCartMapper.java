package com.ageless.mapper;


import com.ageless.pojo.ShoppingCart;

import java.util.List;

public interface ShopCartMapper {

    /**
     * 加入购物车
     * @param shoppingCart
     * @return
     */
    int addShoppingCart(ShoppingCart shoppingCart);

    /**
     * 购物车查询
     * @param id
     * @return
     */

    public List<ShoppingCart> selshopAll(Integer id );

    /**
     *删除购物车商品
     * @param id
     * @return
     */

     public int delshop(Integer id );
}
