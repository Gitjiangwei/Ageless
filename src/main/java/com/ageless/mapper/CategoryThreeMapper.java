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
    List<CategoryThree> listThree(@Param("id") Integer id,@Param( "name" )String name);

    /**
     * 添加三级选项
     * @param threes
     * @return
     */
    int insertThree(@Param( "list" ) List<String> threes,@Param( "id" )int id);

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
    int deleteThree(@Param( "id" )int id);
}
