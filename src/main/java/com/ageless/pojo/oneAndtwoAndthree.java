package com.ageless.pojo;

import lombok.Data;

import java.util.List;

@Data
public class oneAndtwoAndthree extends CategoryOne {

    private List<twoAndthree> categoryTwo;

}
