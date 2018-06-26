package com.ageless.service;

import com.ageless.pojo.CategoryTwo;


import java.util.List;

public interface CategoryTwoService {
    /**
     * 根据一级id查询
     * @param id
     * @return
     */
    List<CategoryTwo> Twolist(int id);

    /**
     * 添加二级选项
     * @param two
     * @return
     */
    int insertTwo(CategoryTwo two);

    /**
     * 修改二级选项
     * @param two
     * @return
     */
    int updateTwo(CategoryTwo two);
}
