package com.ageless.mapper;

import com.ageless.pojo.NewsType;
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
    public int xiuGai(@Param("id") Integer id, @Param("title") String title, @Param("typeId") Integer typeId, @Param("link") String link, @Param("announcementContent") String announcementContent);
    //页面查
    public List<Notice> qianselect(@Param("id") Integer id, @Param("typeId") Integer typeId,@Param("typeName") String typeName) ;
    //id查
    public Notice incha(@Param("id") Integer id) ;
    //下拉列表查询
    public List<NewsType> xiaLa();

    //类型查询所有
    public  List<NewsType> selectNewsType();
    //根据ID查询
    public Notice selectId(@Param("id") Integer id);
    //类型删除
    public int deletNews(@Param("nId") Integer nId);
    //类型新增方法
    public int insertNews(@Param("typeName") String typeName);


}

