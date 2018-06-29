package com.ageless.mapper;

import com.ageless.pojo.CategoryTwo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CategoryTwoMapper {
    /**
     * 根据一级id查询或二级关键字模糊查询
     * @param id
     * @return
     */
    List<CategoryTwo> Twolist(@Param("id") Integer id,@Param("categoryName") String categoryName);



    /**
     * 查询所有二级分类
     * @param
     * @return
     */
    List<CategoryTwo> Twolist2();

    /**
     * 添加二级选项
     * @param two
     * @return
     */
    int insertTwo(@Param("list") List<String> two ,@Param("id") Integer id);

    /**
     * 修改二级选项
     * @param two
     * @return
     */
    int updateTwo(CategoryTwo two);
    /**
     * 删除二级标签
     * @param id
     * @return
     */
    int shanchu(@Param ("id")Integer id);
    /**
     * 删除三级标签
     * @param id
     * @return
     */
    int shanchu1(@Param ("id")Integer id);
}
