
        package com.ageless.pojo;

        import com.alibaba.fastjson.annotation.JSONField;
        import lombok.Data;

        import java.util.Date;

@Data
public class Notice {

    private Integer id; //公告编号
    private  String title;  //标题
    private  String link;   //链接
    private  String announcementContent;   //公告内容
    @JSONField(format="yyyy-MM-dd")
    private Date announcementTime; //公告时间

    private  Integer typeId;  //类型id
    @JSONField(format="yyyy-MM-dd")
    private  Date modificationDate;  //修改时间
    private  String typeName;  //标题

}





