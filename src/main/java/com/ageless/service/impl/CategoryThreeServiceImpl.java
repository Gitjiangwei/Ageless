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

import javax.annotation.Resource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
@Service
public class CategoryThreeServiceImpl implements CategoryThreeService {
    @Resource
    private CategoryThreeMapper categoryThreeMapper;
    @Autowired
    private JedisUtil.Keys jedisKeys;
    @Autowired
    private JedisUtil.Strings jedisStrings;

    private static String THREELIST="threelist";
    @Override
    public List<CategoryThree> listThree(Integer id,String name) {
        return categoryThreeMapper.listThree(id, name);
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
