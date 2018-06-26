package com.ageless.service;

import com.ageless.pojo.CategoryThree;


import java.util.List;

public interface CategoryThreeService {
    /**
     * 根据二级id查询
     * @param id
     * @return
     */
    List<CategoryThree> listThree(int id);

    /**
     * 添加三级选项
     * @param three
     * @return
     */
    int insertThree(CategoryThree three);

    /**
     * 修改三级选项
     * @param three
     * @return
     */
    int updateThree(CategoryThree three);
}
