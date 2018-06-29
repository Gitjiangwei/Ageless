package com.ageless.controller;

import com.ageless.pojo.CategoryTwo;
import com.ageless.service.CategoryTwoService;
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
@RequestMapping(value="/CateTwo")
public class CategoryTwoController {
    @Autowired
    private CategoryTwoService categoryTwoService;

    /**
     * 根据id查询二级选项
     * @param id
     * @return
     */

    @ResponseBody
    @RequestMapping(value="/Twolist")
    public Object listTwo(@RequestParam(required = false) Integer id, @RequestParam(required = false) String categoryName){
        List<CategoryTwo> two=categoryTwoService.Twolist( id ,categoryName);
        System.out.println(two);
        Object obj= JSON.toJSONString(two);
        return obj;
    }
    @ResponseBody
    @RequestMapping(value="/Twolist1")
    public Object listTwo1(){
        List<CategoryTwo> two=categoryTwoService.Twolist2();
        System.out.println(two);
        Object obj= JSON.toJSONString(two);
        return obj;
    }
    @RequestMapping(value="/goCategory2")
    public String goCategory2(){
        return "/management/category2";
    }
    /**
     * 添加二级选项
     * @param
     * @return
     */
    /*@ResponseBody
    @RequestMapping(value="/Twoinsert")
    public Object insertTwo(CategoryTwo two){
        int jie=categoryTwoService.insertTwo( two );
        Object obj= JSON.toJSONString(two);
        return obj;
    }*/
    @ResponseBody
    @RequestMapping(value="/Twoinsert",method = RequestMethod.POST)
    public Object insertTwo(@RequestParam(value="categoryNameList",required = false) String categoryNameList,
                            @RequestParam(value = "parentId") Integer parentId){
        System.out.println(categoryNameList);
        if(categoryNameList!=null && categoryNameList!=""){
            String[] array = categoryNameList.split(",");
            int jie=categoryTwoService.insertTwo(Arrays.asList(array),parentId );
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
     * 修改二级选项
     * @param two
     * @return
     */
    @ResponseBody
    @RequestMapping(value="/Twoupdate")
    public Object updateTwo(CategoryTwo two){
        int jie=categoryTwoService.updateTwo( two );
        Object obj= JSON.toJSONString(two);
        return obj;
    }
    /**
     * 删除二级选项
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping(value="/Twodelete")
    public Object shanchu(Integer id) {
        int jie = categoryTwoService.shanchu1(id);
        int result = categoryTwoService.shanchu(id);
        if (jie > 0) {
            return "1";

        } else if (result > 0) {
            return "2";
        }else{
            return"0";
        }

    }
    /**
     * 修改
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping(value="/xiugai")
    public Object xiugai(Integer id,String categoryName,Integer parentId) {
        CategoryTwo categorytwo = new CategoryTwo();
        categorytwo.setCategoryName(categoryName);
        categorytwo.setParentId(parentId);
        categorytwo.setId(id);
        int result = categoryTwoService.updateTwo(categorytwo);
        if(result>0){
            return "1";
        }else{
            return "0";
        }

    }
}


