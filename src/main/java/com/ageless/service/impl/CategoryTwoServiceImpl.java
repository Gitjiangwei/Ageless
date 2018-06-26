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
    public List<CategoryTwo> Twolist(int id) {
        List<CategoryTwo> TT=categoryTwoMapper.Twolist( id );
        return TT;
    }

    @Override
    public int insertTwo(CategoryTwo two) {
        return categoryTwoMapper.insertTwo( two );
    }

    @Override
    public int updateTwo(CategoryTwo two) {
        return categoryTwoMapper.updateTwo( two );
    }
}
