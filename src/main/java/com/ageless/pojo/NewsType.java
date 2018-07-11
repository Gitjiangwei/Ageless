package com.ageless.pojo;

import lombok.Data;

import java.io.Serializable;
@Data
public class NewsType implements Serializable {
    private Integer nId;    //类型编号
    private String typeName;    //类型名称

    @Override
    public String toString() {
        return "NewsType{" +
                "nId=" + nId +
                ", typeName='" + typeName + '\'' +
                '}';
    }
}
