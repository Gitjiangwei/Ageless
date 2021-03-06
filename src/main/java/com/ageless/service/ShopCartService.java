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
    //根据id查询
    public ShoppingCart queryShopChecked(Integer productId);

    //根据商品id修改件数
    public int repairNumberById(ShoppingCart shoppingCart);

    /**
     * 购物车查询
     * @param id
     * @return
     */
    public List<ShoppingCart> selectCart(int id);

    /**
     *
     * 购物车查询条数
     * @param id
     * @return
     */
    public int chaCart(int id);


}
