package com.ageless.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class Evaluate {
    private Integer pingId; //评价ID
    private String dengJi;  //评价等级
    private String file;    //评价内容
    private String photo1;  //照片1
    private String photo2;  //照片2
    private String photo3;  //照片3
    private String photo4;  //照片4
    private String photo5;  //照片5
    private Integer uesrId; //用户的id
    private Integer productId;  //商品ID
    private Date createTime;    //创建时间

}
