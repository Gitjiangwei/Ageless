
        package com.ageless.service;

        import com.ageless.pojo.NewsType;
        import com.ageless.pojo.Notice;

        import java.util.List;

public interface NoticeService {
    //查询所有方法
    public List<Notice> selectAll( String title,Integer typeId);
    //新增
    public int add(Notice N);
    //删除
    public int delete(Integer id);
    //修改
    public int xiuGai(Integer id, String title, Integer typeId, String link, String announcementContent);
    //页面查
    public List<Notice> qianselect( Integer id,  Integer typeId, String typeName) ;
    //id查
    public Notice incha(Integer id) ;

    //后台需要
    //下拉列表查询
    public List<NewsType> xiaLa();
    //根据ID查询
    public Notice selectId(Integer id);
    //类型查询所有
    public  List<NewsType> selectNewsType();
    //类型删除
    public int deletNews(Integer nId);
    //类型新增方法
    public int insertNews(String typeName);

}

