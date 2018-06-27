package com.ageless.controller;

import com.ageless.pojo.CategoryOne;
import com.ageless.service.CategoryOneService;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(value="/CateOne")
public class CategoryOneController {

    @Autowired
    private CategoryOneService categoryOneService;

    /**
     * 查询所有
     * @return
     */
    @RequestMapping(value="/index")
    public String goIndex(){
        return "/management/index";
    }

    @RequestMapping(value="/goCategory1")
    public String goCategory1(){
        return "/management/category1";
    }

    @ResponseBody
    @RequestMapping(value="/Oneadd")
    public Object OneList(){
        List<CategoryOne> onell=categoryOneService.Onelist();
        Object obj= JSON.toJSONString(onell);
        return obj;
    }

    /**
     * 添加一级选项
     * @param cate
     * @return
     */
    @ResponseBody
    @RequestMapping(value="/Oneinsert")
    public Object insertOne(CategoryOne cate){
       int jie=categoryOneService.insertOne( cate );
        Object obj= JSON.toJSONString(jie);
        return obj;
    }

    /**
     * 修改一级选项
     * @param cate
     * @return
     */
    @ResponseBody
    @RequestMapping(value="/Oneupdate")
    public Object updateOne(CategoryOne cate){
        int jie=categoryOneService.updateOne( cate );
        Object obj= JSON.toJSONString(jie);
        return obj;
    }
}
