package com.ageless.pojo;

public class ShoppingCart {

    private int id;    //购物车编号
    private int userId;   //用户编号
    private int productId;  //商品编号
    private int orderamount;   //订购数量

    public ShoppingCart(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getOrderamount() {
        return orderamount;
    }

    public void setOrderamount(int orderamount) {
        this.orderamount = orderamount;
    }

    @Override
    public String toString() {
        return "ShoppingCart{" +
                "id=" + id +
                ", userId=" + userId +
                ", productId=" + productId +
                ", orderamount=" + orderamount +
                '}';
    }
}
