package com.ageless.pojo;

import java.util.List;

import lombok.Data;

@Data
public class Sort {
    private Integer id;
    private String name;
    private Integer categorythreeId;

    private List<Sortcon> sortcons;
}
