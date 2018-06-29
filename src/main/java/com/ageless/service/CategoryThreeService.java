package com.ageless.service;

import com.ageless.pojo.CategoryThree;


import java.util.List;

public interface CategoryThreeService {
    /**
     * 根据二级id查询
     * @param id
     * @return
     */
    List<CategoryThree> listThree(Integer id,String name);

    /**
     * 添加三级选项
     * @param threes
     * @return
     */
    int insertThree(List<String> threes,int id);

    /**
     * 修改三级选项
     * @param three
     * @return
     */
    int updateThree(CategoryThree three);

    /**
     * 删除三级选项
     * @param id
     * @return
     */
    int deleteThree(int id);
}
