package com.ageless.service.impl;

import com.ageless.mapper.CategoryOneMapper;
import com.ageless.pojo.CategoryOne;
import com.ageless.service.CategoryOneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoryOneServiceImpl implements CategoryOneService {
    @Autowired
    private CategoryOneMapper categoryOneMapper;
    @Override
    public List<CategoryOne> Onelist() {
        List<CategoryOne> oneList=categoryOneMapper.Onelist();
        return oneList;
    }

    @Override
    public int insertOne(CategoryOne cate) {
        return categoryOneMapper.insertOne( cate );
    }

    @Override
    public int updateOne(CategoryOne cate) {
        return categoryOneMapper.updateOne( cate );
    }
}
