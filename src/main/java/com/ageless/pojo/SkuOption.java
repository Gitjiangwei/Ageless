package com.ageless.pojo;

import lombok.Data;

@Data
public class SkuOption {

    private Integer id;
    private String optionName;
    private Integer productId;

    @Override
    public String toString() {
        return "SkuOption{" +
                "id=" + id +
                ", optionName='" + optionName + '\'' +
                ", productId=" + productId +
                '}';
    }
}
