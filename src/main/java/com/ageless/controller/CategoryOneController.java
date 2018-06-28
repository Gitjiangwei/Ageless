package com.ageless.controller;

import com.ageless.pojo.CategoryOne;
import com.ageless.pojo.CategoryTwo;
import com.ageless.service.CategoryOneService;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
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
    @RequestMapping(value="/getcategory1list",method = RequestMethod.POST)
    public Object OneList(@RequestParam String name){
        List<CategoryOne> onell=categoryOneService.Onelist(name);
        Object obj= JSON.toJSONString(onell);
        return obj;
    }

    /**
     * 添加一级选项
     * @param
     * @return
     */
    @ResponseBody
    @RequestMapping(value="/Oneinsert",method = RequestMethod.POST)
    public Object insertOne(String categoryNameList){
        System.out.println(categoryNameList);
       if(categoryNameList!=null && categoryNameList!=""){
           String[] array = categoryNameList.split(",");
           int jie=categoryOneService.insertOne(Arrays.asList(array) );
           if (jie>0){
               return "{\"result\":\"success\"}";
           }else{
               return "{\"result\":\"添加失败\"}";
           }
       }else{
           return "{\"result\":\"List不能为空\"}";
       }

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
    /**
     * 删除
     * @param
     * @return
     */
    @ResponseBody
    @RequestMapping(value="/shanchu")
    public String delete(Integer id){
        List<CategoryTwo> cc = categoryOneService.Onelist1(id);
        int result = 0;
        int result2 = 0;
        if(cc.size()>0){
            result = categoryOneService.shanchu3(cc);
            result2 = categoryOneService.shanchu2(id);
        }
        int result1 =categoryOneService.delete(id);
        if(result>0){
            return "1";
        }else if(result2>0){
            return "2";
        }else if(result1>0){
            return "3";
        }else{
            return "0";
        }

    }
    /**
     * 修改
     * @param
     * @return
     */
    @ResponseBody
    @RequestMapping(value="/xiugai")
    public String updata(Integer id,String categoryName){
        CategoryOne categoryone = new CategoryOne();
        categoryone.setId(id);
        categoryone.setCategoryName(categoryName);
        int result = categoryOneService.updateOne(categoryone);
        if(result>0){
            return "1";
        }else{
            return "0";
        }

    }
}
