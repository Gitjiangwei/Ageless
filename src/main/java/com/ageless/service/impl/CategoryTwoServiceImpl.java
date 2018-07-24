package com.ageless.service.impl;

import com.ageless.cache.JedisUtil;
import com.ageless.mapper.CategoryTwoMapper;
import com.ageless.pojo.CategoryTwo;
import com.ageless.service.CategoryTwoService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryTwoServiceImpl implements CategoryTwoService{

    @Resource
    private CategoryTwoMapper categoryTwoMapper;
    @Autowired
    private JedisUtil.Keys jedisKeys;
    @Autowired
    private JedisUtil.Strings jedisStrings;

    private static String TWOLIST="twolist";
    @Override
    public List<CategoryTwo> Twolist(Integer id,String categoryName) {
        return categoryTwoMapper.Twolist(id, categoryName);
    }
    @Override
    public List<CategoryTwo> Twolist2() {
        List<CategoryTwo> TT=categoryTwoMapper.Twolist2();
        return TT;
    }
    @Override
    public int insertTwo(List<String> two,Integer id) {
        return categoryTwoMapper.insertTwo( two,id );
    }

    @Override
    public int updateTwo(CategoryTwo two) {
        return categoryTwoMapper.updateTwo( two );
    }

    @Override
    public int shanchu(Integer id) {
        return categoryTwoMapper.shanchu( id );
    }

    @Override
    public int shanchu1(Integer id) {
         return categoryTwoMapper.shanchu1( id );
    }
}
