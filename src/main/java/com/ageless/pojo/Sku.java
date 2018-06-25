package com.ageless.pojo;

import lombok.Data;

@Data
public class Sku {
    private Integer id;
    private Integer productId;
    private String skuCon;
    private Integer kucun;
    private Double price;
}
