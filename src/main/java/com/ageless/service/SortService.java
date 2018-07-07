package com.ageless.service;

import com.ageless.pojo.Product;
import com.ageless.pojo.Sort;
import com.ageless.pojo.Sortcon;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SortService {

    /**yy
     * 根据三级列表id查询
     * 查询三级id下面的内容
     * @return
     */
    List<Sort> selectsanji(Integer categorythreeId);


    /**
     * 根据三级下面的内容
     * 根据价格，评论，销量
     * 查询相对应的商品信息
     * @param list
     * @param tiaojian 传过来的字符串
     * @return
     */
    List<Product> selectProduct(List<Integer> list, String tiaojian,Integer pageIndex);



    /**
     * 根据三级下面的内容
     * 根据价格，评论，销量
     * 查询相对应的商品信息
     * @param mo 模糊差的字符串
     * @param tiaojian 传过来的字符串
     * @return
     */
    List<Product> selectmohu(String mo,String tiaojian,Integer pageIndex);


    /**
     * 添加多条属性选项
     * @param ls
     * @return
     */
    int addSortcon(List<Sortcon> ls,Integer id);


    int update(Integer sortconid,String sortconname);
}
