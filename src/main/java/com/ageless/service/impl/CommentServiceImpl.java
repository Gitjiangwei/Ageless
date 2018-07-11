package com.ageless.service.impl;

import com.ageless.mapper.CommentMapper;
import com.ageless.pojo.Comment;
import com.ageless.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentMapper commentMapper;

    @Override
    public List<Comment> seleAll(Integer CatrOne, Integer CatrTwo,
                                 Integer CatrThree,String proName) {
        return commentMapper.seleAll(CatrOne, CatrTwo,CatrThree, proName);
    }

    @Override
    public List<Integer> seleCount(Integer proId) {
        return commentMapper.seleCount(proId);
    }

    @Override
    public List<Comment> seleCommPro(Integer proId, String pinj,Integer cid) {
        return commentMapper.seleCommPro(proId,pinj,cid);
    }

    @Override
    public int deleCommById(Integer cid) {
        return commentMapper.deleCommById(cid);
    }
}
