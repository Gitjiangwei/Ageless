package com.ageless.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class Seckill {
    private int sid;
    private int productId;
    private Date start_time;
    private Date end_time;
    private Date create_time;
    private int count;
    private String productName;
    private double price;
    private String picPath;

}
