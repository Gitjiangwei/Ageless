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

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
@Service
@Transactional
public class CategoryOneServiceImpl implements CategoryOneService {
    @Autowired
    private CategoryOneMapper categoryOneMapper;
    @Autowired
    private JedisUtil.Keys jedisKeys;
    @Autowired
    private JedisUtil.Strings jedisStrings;


    private static String ONELIST="onelist";
    @Override
    public List<CategoryOne> Onelist(String categoryName) {
        String key=ONELIST;
        List<CategoryOne> oneList=null;
        ObjectMapper objectMapper=new ObjectMapper();
        if(!jedisKeys.exists(key)) {
            oneList = categoryOneMapper.Onelist(categoryName);
            String jsonString=null;
            try {
                jsonString=objectMapper.writeValueAsString(oneList);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
            jedisStrings.set(key,jsonString);
        }else{
            String jsonString=jedisStrings.get(key);
            JavaType javaType=objectMapper.getTypeFactory().constructParametricType(ArrayList.class,CategoryOne.class);
            try {
                oneList=objectMapper.readValue(jsonString,javaType);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return oneList;
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
