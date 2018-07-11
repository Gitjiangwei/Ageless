package com.ageless.controller;

import com.ageless.pojo.Comment;
import com.ageless.service.CommentService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(value = "/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @GetMapping(value = "/selPro")
    @ResponseBody
    public Object seleAll(@RequestParam(required = false) Integer pageNo,@RequestParam(required = false) Integer CatrOne, @RequestParam(required = false) Integer CatrTwo,
                          @RequestParam(required = false) Integer CatrThree,@RequestParam(required = false) String proName){
        if(pageNo==null||pageNo==0){
            pageNo=1;
        }
        PageHelper.startPage(pageNo,16);
        PageInfo<Comment> commentPageInfo=new PageInfo<Comment>(commentService.seleAll(CatrOne, CatrTwo, CatrThree,proName));
        Object obj= JSON.toJSON(commentPageInfo);
        return obj;
    }

    @GetMapping(value = "/count")
    @ResponseBody
    public Object count(@RequestParam(required = false) Integer proId){

        List<Integer> integerList =commentService.seleCount(proId);
        Object obj= JSON.toJSON(integerList);
        return obj;
    }


    /**
     * 显示一件商品
     * @param proId
     * @return
     */
    @GetMapping(value = "/proCom")
    @ResponseBody
    public Object seleByPro(Integer proId, String pinj,Integer cid,@RequestParam(required = false) Integer pageNo){
        if(pageNo==null||pageNo==0){
            pageNo=1;
        }
        PageHelper.startPage(pageNo,10);
        PageInfo<Comment> commentPageInfo=new PageInfo<Comment>(commentService.seleCommPro(proId,pinj,cid));
        Object obj=JSON.toJSON(commentPageInfo);
        return obj;
    }

    @GetMapping(value = "/selectById")
    @ResponseBody
    public Object selectById(Integer cid){
        List<Comment> list = commentService.seleCommPro(null,null,cid);
        Object obj = JSONArray.toJSONString(list);
        return obj;
    }

    /**
     * 删除评论
     * @param
     * @return
     */
    @GetMapping(value = "/dele")
    @ResponseBody
    public Object deleById(Integer cid){
        int result=commentService.deleCommById(cid);
        return result;
    }
}
