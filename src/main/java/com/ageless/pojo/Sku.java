package com.ageless.pojo;

import lombok.Data;

@Data
public class Sku {
    private Integer SKUId;
    private Integer productId;
    private String skuCon;
    private Integer kucun;
    private Double price;
}
