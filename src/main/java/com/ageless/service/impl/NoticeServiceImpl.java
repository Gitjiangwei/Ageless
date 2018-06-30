package com.ageless.service.impl;

import com.ageless.mapper.NoticeMapper;
import com.ageless.pojo.Notice;
import com.ageless.service.NoticeService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class NoticeServiceImpl implements NoticeService{


    @Resource
    private NoticeMapper noticeMapper;
    @Override
    public List<Notice> selectAll( String title,Integer typeId) {
        return noticeMapper.selectAll(title,typeId);
    }

    @Override
    public int add(Notice N) {
        return noticeMapper.add(N);
    }

    @Override
    public int delete(Integer id) {
        return noticeMapper.delete(id);
    }

    @Override
    public int xiuGai(Integer id, String announcement_content) {
        return noticeMapper.xiuGai(id,announcement_content);
    }

    @Override
    public List<Notice> qianselect(Integer id, Integer typeId, String typeName) {
        return noticeMapper.qianselect(id,typeId,typeName);
    }

    @Override
    public Notice incha(Integer id) {
        return noticeMapper.incha(id);
    }


}

