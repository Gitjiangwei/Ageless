package com.ageless.mapper;

import com.ageless.pojo.CategoryOne;

import java.util.List;

public interface CategoryOneMapper {
    /**
     * 查询所有一级选项
     * @return
     */
    List<CategoryOne> Onelist();


    /**
     * 添加一级选项
     * @param cate
     * @return
     */
    int insertOne(CategoryOne cate);

    /**
     * 修改一级选项
     * @param cate
     * @return
     */
    int updateOne(CategoryOne cate);
}
