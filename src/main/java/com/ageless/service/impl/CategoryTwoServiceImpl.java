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

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryTwoServiceImpl implements CategoryTwoService{

    @Autowired
    private CategoryTwoMapper categoryTwoMapper;
    @Autowired
    private JedisUtil.Keys jedisKeys;
    @Autowired
    private JedisUtil.Strings jedisStrings;

    private static String TWOLIST="twolist";
    @Override
    public List<CategoryTwo> Twolist(Integer id,String categoryName) {
        String key=TWOLIST;
        List<CategoryTwo> TT=null;
        ObjectMapper objectMapper=new ObjectMapper();
        if(!jedisKeys.exists(key)) {
            TT = categoryTwoMapper.Twolist(id, categoryName);
            String jsonString=null;
            try {
                jsonString=objectMapper.writeValueAsString(TT);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
            jedisStrings.set(key,jsonString);
        }else{
            String jsonString=jedisStrings.get(key);
            JavaType javaType=objectMapper.getTypeFactory().constructParametricType(ArrayList.class,CategoryTwo.class);
            try {
                TT=objectMapper.readValue(jsonString,javaType);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return TT;
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
