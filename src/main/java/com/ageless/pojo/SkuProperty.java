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

    @Override
    public String toString() {
        return "SkuProperty{" +
                "id=" + id +
                ", propertyName='" + propertyName + '\'' +
                ", categoryId=" + categoryId +
                ", list=" + list +
                ", categoryName='" + categoryName + '\'' +
                '}';
    }
}
