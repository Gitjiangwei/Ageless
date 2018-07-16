package com.ageless.service.impl;

import com.ageless.cache.JedisUtil;
import com.ageless.mapper.CommentMapper;
import com.ageless.pojo.Comment;
import com.ageless.service.CommentService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentMapper commentMapper;
    @Autowired
    private JedisUtil.Keys jedisKeys;
    @Autowired
    private JedisUtil.Strings jedisStrings;

    private static String COMMENTLIST="commentlist";
    private static String COMMPRODUCT="commproduct";
    @Override
    public List<Comment> seleAll(Integer CatrOne, Integer CatrTwo,
                                 Integer CatrThree,String proName) {
        String key=COMMENTLIST;
        List<Comment> commentList=null;
        ObjectMapper objectMapper=new ObjectMapper();
        if(!jedisKeys.exists(key)){
            commentList=commentMapper.seleAll(CatrOne,CatrTwo,CatrThree,proName);
            String jsonString = null;
            try {
                jsonString=objectMapper.writeValueAsString(commentList);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
            jedisStrings.set(key,jsonString);
        }else{
            String jsonString =jedisStrings.get(key);
            JavaType javaType=objectMapper.getTypeFactory().constructParametricType(ArrayList.class,Comment.class);
            try {
                commentList=objectMapper.readValue(jsonString,javaType);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return commentList;
    }

    @Override
    public List<Integer> seleCount(Integer proId) {
        return commentMapper.seleCount(proId);
    }

    @Override
    public List<Comment> seleCommPro(Integer proId, String pinj,Integer cid) {
        String key=COMMPRODUCT;
        List<Comment> commentList=null;
        ObjectMapper objectMapper=new ObjectMapper();
        if(!jedisKeys.exists(key)) {
            commentList = commentMapper.seleCommPro(proId, pinj, cid);
            String jsonString=null;
            try {
                jsonString=objectMapper.writeValueAsString(commentList);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
            jedisStrings.set(key,jsonString);
        }else {
            String jsonString=jedisStrings.get(key);
            JavaType javaType=objectMapper.getTypeFactory().constructParametricType(ArrayList.class,Comment.class);
            try {
                commentList=objectMapper.readValue(jsonString,javaType);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return commentList;
    }

    @Override
    public int deleCommById(Integer cid) {
        return commentMapper.deleCommById(cid);
    }
}
