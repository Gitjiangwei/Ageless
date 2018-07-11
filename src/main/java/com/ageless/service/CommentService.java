package com.ageless.service;

import com.ageless.pojo.Comment;

import java.util.List;

public interface CommentService {

    /**
     * 显示所有评论商品
     * @return
     */
    List<Comment> seleAll(Integer CatrOne, Integer CatrTwo,
                          Integer CatrThree, String proName);

    /**
     * 总评论数
     * @return
     */
    List<Integer> seleCount(Integer proId);


    /**
     * 显示一件商品的评论
     * @param proId
     * @return
     */
    List<Comment> seleCommPro(Integer proId, String pinj, Integer cid);

    /**
     * 根据Id删除评论
     * @param cid
     * @return
     */
    int deleCommById(Integer cid);
}
