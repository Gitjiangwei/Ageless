package com.ageless.service;


import com.ageless.pojo.ShoppingCart;

import java.util.List;

public interface ShopCartService {

    /**
     * 加入购物车
     * @param shoppingCart
     * @return
     */
    int addShoppingCart(ShoppingCart shoppingCart);
    /**
     * 购物车查询
     * @param
     * @return
     */

    public List<ShoppingCart> selshopAll();

    /**
     *删除购物车商品
     * @param id
     * @return
     */

    public int delshop(Integer id );
    public ShoppingCart queryShopChecked(Integer productId);

}
