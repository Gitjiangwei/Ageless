package com.ageless.service.impl;

import com.ageless.mapper.CategoryThreeMapper;
import com.ageless.pojo.CategoryThree;
import com.ageless.service.CategoryThreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoryThreeServiceImpl implements CategoryThreeService {
    @Autowired
    private CategoryThreeMapper categoryThreeMapper;
    @Override
    public List<CategoryThree> listThree(Integer id,String name) {
        List<CategoryThree> HH=categoryThreeMapper.listThree( id,name );
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
