package com.ageless.pojo;

import lombok.Data;

import java.util.Date;
@Data
public class Order {
    private Integer id;
    private Integer number;
    private Integer addressid;
    private Date createDate;
    private Integer atch;
    private Integer userId;
    private Integer orderNumber;
    private Integer OrderStatus;
    private Double order_price;
    private Integer productid;
    private String Order3;
    private String picPath;
    private String descript;
    private Double price;
    private String status;
}
