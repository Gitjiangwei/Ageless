
        package com.ageless.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class Notice {

    private Integer id; //公告编号
    private  String title;  //标题
    private  String link;   //链接
    private  String announcementContent;   //公告内容
    private Date announcementTime; //公告时间

    private  Integer typeId;  //类型id
    private  Date modificationDate;  //修改时间
    private  String typeName;  //标题

}





