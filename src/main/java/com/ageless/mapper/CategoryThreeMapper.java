package com.ageless.mapper;

import com.ageless.pojo.CategoryThree;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CategoryThreeMapper {
    /**
     * 根据二级id查询
     * @param id
     * @return
     */
    List<CategoryThree> listThree(@Param("id") int id);

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
