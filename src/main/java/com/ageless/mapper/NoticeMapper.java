package com.ageless.mapper;

import com.ageless.pojo.Notice;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface NoticeMapper {

    //查询所有方法
    public List<Notice> selectAll(@Param("title") String title, @Param("typeId") Integer typeId);

    //新增
    public int add(Notice N);

    //删除
    public int delete(@Param("id") Integer id);

    //修改
    public int xiuGai(@Param("id") Integer id, @Param("announcement_content") String announcement_content);
    //页面查
    public List<Notice> qianselect(@Param("id") Integer id, @Param("typeId") Integer typeId,@Param("typeName") String typeName) ;
    //id查
    public Notice incha(@Param("id") Integer id) ;
}

