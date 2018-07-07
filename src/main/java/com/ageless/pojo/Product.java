package com.ageless.pojo;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.util.Date;

@Data
public class Product {
    private Integer id;
    private String productId;
    private String productName;
    private String descript;
    private String maidian;
    private Double price;
    @JSONField(format="yyyy-MM-dd")
    private Date update;
    @JSONField(format="yyyy-MM-dd")
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

    private ProductPic productPic;
    private SkuOption skuOption;
    private SkuProperty skuProperty;

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", productId='" + productId + '\'' +
                ", productName='" + productName + '\'' +
                ", descript='" + descript + '\'' +
                ", maidian='" + maidian + '\'' +
                ", price=" + price +
                ", update=" + update +
                ", downdate=" + downdate +
                ", status=" + status +
                ", kucun=" + kucun +
                ", xiaoliang=" + xiaoliang +
                ", comment=" + comment +
                ", sendScore=" + sendScore +
                ", category01=" + category01 +
                ", category02='" + category02 + '\'' +
                ", category03='" + category03 + '\'' +
                ", sortId='" + sortId + '\'' +
                ", sortConId='" + sortConId + '\'' +
                ", productPic=" + productPic +
                ", skuOption=" + skuOption +
                ", skuProperty=" + skuProperty +
                '}';
    }
}
