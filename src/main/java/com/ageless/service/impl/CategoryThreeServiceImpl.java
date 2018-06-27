package com.ageless.service.impl;

import com.ageless.mapper.CategoryThreeMapper;
import com.ageless.pojo.CategoryThree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoryThreeServiceImpl implements CategoryThreeMapper {
    @Autowired
    private CategoryThreeMapper categoryThreeMapper;
    @Override
    public List<CategoryThree> listThree(int id) {
        List<CategoryThree> HH=categoryThreeMapper.listThree( id );
        return HH;
    }

    @Override
    public int insertThree(CategoryThree three) {
        return categoryThreeMapper.insertThree( three );
    }

    @Override
    public int updateThree(CategoryThree three) {
        return categoryThreeMapper.updateThree( three );
    }
}
