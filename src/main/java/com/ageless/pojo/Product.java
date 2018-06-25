package com.ageless.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class Product {
    private Integer id;
    private String productId;
    private String productName;
    private String descript;
    private Date update;
    private Date downdate;
    private Integer status;
    private Integer kucun;
    private Integer xiaoliang;
    private Integer comment;
    private Integer sendScore;
    private Integer category01;
    private String category02;
    private String category03;
    private String sortId;
    private String sortConId;


    private SkuOption skuOption;
    private SkuProperty skuProperty;

}
