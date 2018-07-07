package com.ageless.mapper;

import com.ageless.pojo.Sort;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SortconMapper {
    /**
     *
     * @param name
     * @param categoryThree
     * @return
     */
    public List<Sort> selectAll(@Param("name")String name,
                                @Param("categoryThree")Integer categoryThree,
                                 @Param("sortId")Integer sortId);

    /**
     *
     * @param id
     * @return
     */
    public int delSort(@Param("id")Integer id);

    /**
     *
     * @param id
     * @return
     */
    public int delSortcon(@Param("id")Integer id);

    /**
     *
     * @param s
     * @return
     */
   int add(Sort s);


   int update(@Param("id")Integer id,@Param("name")String name);





}
