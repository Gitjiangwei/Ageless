package com.ageless.service;

import com.ageless.pojo.CategoryTwo;


import java.util.List;

public interface CategoryTwoService {
    /**
     * 根据一级id查询或者二级关键字模糊查询
     * @param id
     * @return
     */
    List<CategoryTwo> Twolist(Integer id,String categoryName);
    /**
     * 查询所有的二级分类
     * @param
     * @return
     */

    List<CategoryTwo> Twolist2();

    /**
     * 添加二级选项
     * @param two
     * @return
     */
    int insertTwo(List<String> two,Integer id);

    /**
     * 修改二级选项
     * @param two
     * @return
     */
    int updateTwo(CategoryTwo two);
    /**
     *  删除二级标签
     * @param id
     * @return
     */
    int shanchu(Integer id);
    /**
     *  删除三级标签
     * @param id
     * @return
     */
    int shanchu1(Integer id);
}
