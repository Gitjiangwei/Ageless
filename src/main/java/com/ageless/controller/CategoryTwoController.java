package com.ageless.controller;

import com.ageless.pojo.CategoryTwo;
import com.ageless.service.CategoryTwoService;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
    public Object listTwo(int id){
        List<CategoryTwo> two=categoryTwoService.Twolist( id );
        System.out.println(two);
        Object obj= JSON.toJSONString(two);
        return obj;
    }

    /**
     * 添加二级选项
     * @param two
     * @return
     */
    @ResponseBody
    @RequestMapping(value="/Twoinsert")
    public Object insertTwo(CategoryTwo two){
        int jie=categoryTwoService.insertTwo( two );
        Object obj= JSON.toJSONString(two);
        return obj;
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
}
