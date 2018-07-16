package com.ageless.service.impl;

import com.ageless.cache.JedisUtil;
import com.ageless.mapper.CategoryThreeMapper;
import com.ageless.pojo.CategoryThree;
import com.ageless.service.CategoryThreeService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
@Service
public class CategoryThreeServiceImpl implements CategoryThreeService {
    @Autowired
    private CategoryThreeMapper categoryThreeMapper;
    @Autowired
    private JedisUtil.Keys jedisKeys;
    @Autowired
    private JedisUtil.Strings jedisStrings;

    private static String THREELIST="threelist";
    @Override
    public List<CategoryThree> listThree(Integer id,String name) {
        String key=THREELIST;
        List<CategoryThree> HH=null;
        ObjectMapper objectMapper=new ObjectMapper();
        if(!jedisKeys.exists(key)) {
            HH = categoryThreeMapper.listThree(id, name);
            String jsonStrings=null;
            try {
                jsonStrings=objectMapper.writeValueAsString(HH);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
            jedisStrings.set(key,jsonStrings);
        }else {
            String jsonString=jedisStrings.get(key);
            JavaType javaType=objectMapper.getTypeFactory().constructParametricType(ArrayList.class,CategoryThree.class);
            try {
                HH=objectMapper.readValue(jsonString,javaType);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return HH;
    }

    @Override
    public int insertThree(List<String> threes,int id) {
        return categoryThreeMapper.insertThree( threes,id );
    }

    @Override
    public int updateThree(CategoryThree three) {
        return categoryThreeMapper.updateThree( three );
    }

    @Override
    public int deleteThree(int id) {
        return categoryThreeMapper.deleteThree( id );
    }
}
