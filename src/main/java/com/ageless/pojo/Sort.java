package com.ageless.pojo;

import lombok.Data;

import java.util.List;
@Data
public class Sort {
    private Integer id;
    private String name;
    private Integer categorythreeId;
    private CategoryThree three;
    private List<Sortcon> sortcons;

    @Override
    public String toString() {
        return "Sort{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", categorythreeId=" + categorythreeId +
                ", three=" + three +
                ", sortcons=" + sortcons +
                '}';
    }
}
