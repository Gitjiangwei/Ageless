package com.ageless.pojo;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class Comment implements Serializable {

    private Integer pingId;
    private String dengji;
    private String file;
    private String photo1;
    private String photo2;
    private String photo3;
    private String photo4;
    private String photo5;
    private Integer userId;
    private Integer productId;
    private String productName;
    private String descript;
    private String picPath;
    @JSONField(format = "yyyy-MM-dd")
    private Date createTime;
    private String name;
}
