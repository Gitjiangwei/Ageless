package com.ageless.mapper;

import com.ageless.pojo.Product;
import com.ageless.pojo.Sort;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SortMapper {
    /**
     * 根据三级列表id查询
     * 查询三级id下面的内容
     * @param categorythreeId
     * @return
     */
    List<Sort> selectsanji(@Param("categorythreeId")Integer categorythreeId);

    /**
     * 根据三级下面的内容
     * 根据价格，评论，销量
     * 查询相对应的商品信息
     * @param list
     * @param tiaojian 传过来的字符串
     * @return
     */
    List<Product> selectProduct(@Param("list") List<Integer> list,@Param("tiaojian")String tiaojian);
}
