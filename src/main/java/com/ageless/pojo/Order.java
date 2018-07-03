package com.ageless.pojo;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
@Data
public class Order {
    private Integer id;
    private String  number;
    private Integer addressid;
    @DateTimeFormat(pattern="yyyy-MM-dd HH-mm-ss")
    private Date createDate;
    private Integer atch;  //流水单号
    private Integer userId;
    private Integer orderNumber;//订单数量
    private Integer OrderStatus;
    private Double orderPrice;
    private Integer productid;
    private String order3;
    private String picPath;
    private String descript;
    private Double price;
    private String status;
    @DateTimeFormat(pattern="yyyy-MM-dd HH-mm-ss")
    private Date paymentTime; //支付时间
    @DateTimeFormat(pattern="yyyy-MM-dd HH-mm-ss")
    private Date transactionTime; //成交时间
    private String address;//详细地址
    private Integer count;//一件商品数量
}
