package com.ageless.pojo;

import lombok.Data;

import java.util.List;

@Data
public class twoAndthree extends CategoryTwo {

    private List<CategoryThree> categoryThree;
}
