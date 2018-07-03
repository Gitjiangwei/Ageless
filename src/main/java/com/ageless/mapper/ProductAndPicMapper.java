package com.ageless.mapper;

import com.ageless.pojo.ProductAndPic;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProductAndPicMapper {

    /**
     * 最热商品
     * @return
     */
    public List<ProductAndPic> list();
    /**
     * 最新商品
     */
    public List<ProductAndPic> Newlist();
    /**
     * 折扣商品
     */
    public List<ProductAndPic> discountlist();

    /**
     * 最热商品按条件查询
     */
    public List<ProductAndPic> listbyxiaoliang(@Param("products") String product);

    /**
     * 最新商品按条件查询
     */
    public List<ProductAndPic> listbyupdate(@Param("up")String upda,@Param("xiao") String xiaos);

    /**
     * 新增商品图片
     */
    int addPic(@Param("list") List<String> lp,@Param("productId")Integer productId);
}
