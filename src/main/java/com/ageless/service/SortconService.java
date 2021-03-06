package com.ageless.service;

import com.ageless.pojo.Sort;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SortconService {
    /**
     *
     * @param name
     * @param categoryThree
     * @return
     */
    public List<Sort> selectAll(String name,Integer categoryThree,Integer sortId);

    /**
     *
     * @param id
     * @return
     */
    public Boolean delSort(Integer id);

    /**
     *
     * @param id
     * @return
     */
    public Boolean delSortcon(Integer id);

    /**
     * 返回添加属性的主键
     * @param s
     * @return
     */
    public int add(Sort s);

    int update(Integer id,String name);
}
