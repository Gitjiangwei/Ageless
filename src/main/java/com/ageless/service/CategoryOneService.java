package com.ageless.service;

import com.ageless.pojo.CategoryOne;
import com.ageless.pojo.CategoryTwo;

import java.util.List;

public interface CategoryOneService {
    /**
     * 查询所有一级选项
     * @return
     */
    List<CategoryOne> Onelist(String categoryName);


    /**
     * 添加一级选项
     * @param cate
     * @return
     */
    int insertOne(List<String> cate);

    /**
     * 修改一级选项
     * @param cate
     * @return
     */
    int updateOne(CategoryOne cate);
    /**
     * 删除一级选项
     * @param
     * @return
     */
    int delete (Integer id);
    /**
     * 根据一级ID查询要删除的二级ID
     * @param
     * @return
     */
    List<CategoryTwo> Onelist1(Integer parentId );
    /**
     * 根据一级ID查询要删除的二级ID
     * @param
     * @return
     */
    int shanchu2( Integer parentId);
    /**
     * 三级分类的删除方法
     * 通过二级查询出来的ID
     * @param
     * @return
     */
    int shanchu3(List<CategoryTwo> list);


}
