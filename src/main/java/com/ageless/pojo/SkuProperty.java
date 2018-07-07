package com.ageless.pojo;

import lombok.Data;

import java.util.List;

@Data
public class SkuProperty {

    private Integer id;
    private String propertyName;
    private Integer categoryId;
    private List<SkuOption> list;
    private  String categoryName;


}
