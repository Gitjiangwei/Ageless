package com.ageless.service.impl;

import com.ageless.cache.JedisUtil;
import com.ageless.mapper.CategoryOneMapper;
import com.ageless.pojo.CategoryOne;
import com.ageless.pojo.CategoryTwo;
import com.ageless.service.CategoryOneService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
@Service
@Transactional
public class CategoryOneServiceImpl implements CategoryOneService {
    @Resource
    private CategoryOneMapper categoryOneMapper;
    @Autowired
    private JedisUtil.Keys jedisKeys;
    @Autowired
    private JedisUtil.Strings jedisStrings;


    private static String ONELIST="onelist";
    @Override
    public List<CategoryOne> Onelist(String categoryName) {
            ;
        return categoryOneMapper.Onelist(categoryName);
    }

    @Override
    public int insertOne(List<String> cate) {
        return categoryOneMapper.insertOne( cate );
    }

    @Override
    public int updateOne(CategoryOne cate) {
        return categoryOneMapper.updateOne( cate );
    }

    @Override
    public int delete(Integer id) {
        int result=categoryOneMapper.delete(id);
        return result;
    }

    @Override
    public List<CategoryTwo> Onelist1(Integer parentId) {
        List<CategoryTwo> cc=categoryOneMapper.Onelist1(parentId);
        return cc;
    }

    @Override
    public int shanchu2(Integer parentId) {
        int result=categoryOneMapper.shanchu2(parentId);
        return result;
    }

    @Override
    public int shanchu3(List<CategoryTwo> list) {
        int result=categoryOneMapper.shanchu3(list);
        return result;
    }
}
