package com.ageless.mapper;

import com.ageless.pojo.Comment;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CommentMapper {

    /**
     * 显示所有评论商品
     * @return
     */
    List<Comment> seleAll(@Param("CatrOne") Integer CatrOne, @Param("CatrTwo") Integer CatrTwo,
                          @Param("CatrThree") Integer CatrThree, @Param("proName") String proName);

    /**
     * 总评论数
     * @return
     */
    List<Integer> seleCount(@Param("proId") Integer proId);


    /**
     * 显示一件商品的评论
     * @param proId
     * @return
     */
    List<Comment> seleCommPro(@Param("proId") Integer proId, @Param("pinj") String pinj, @Param("id") Integer cid);


    /**
     * 根据Id删除评论
     * @param cid
     * @return
     */
    int deleCommById(@Param("cid") Integer cid);
}
