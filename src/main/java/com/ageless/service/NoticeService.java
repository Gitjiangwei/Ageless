
        package com.ageless.service;

import com.ageless.pojo.Notice;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface NoticeService {
    //查询所有方法
    public List<Notice> selectAll( String title,Integer typeId);
    //新增
    public int add(Notice N);
    //删除
    public int delete(Integer id);
    //修改
    public int xiuGai(Integer id,String announcement_content);
    //页面查
    public List<Notice> qianselect( Integer id,  Integer typeId, String typeName) ;
    //id查
    public Notice incha(Integer id) ;

}

