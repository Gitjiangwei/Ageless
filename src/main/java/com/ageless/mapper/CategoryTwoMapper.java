package com.ageless.mapper;

import com.ageless.pojo.CategoryTwo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CategoryTwoMapper {
    /**
     * 根据一级id查询
     * @param id
     * @return
     */
    List<CategoryTwo> Twolist(@Param("id") int id);

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
