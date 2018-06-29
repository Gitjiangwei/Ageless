package com.ageless.service.impl;

import com.ageless.mapper.CategoryTwoMapper;
import com.ageless.pojo.CategoryTwo;
import com.ageless.service.CategoryTwoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryTwoServiceImpl implements CategoryTwoService{

    @Autowired
    private CategoryTwoMapper categoryTwoMapper;

    @Override
    public List<CategoryTwo> Twolist(Integer id,String categoryName) {
        List<CategoryTwo> TT=categoryTwoMapper.Twolist( id ,categoryName);
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
