package com.ageless.controller;

import com.ageless.pojo.CategoryThree;
import com.ageless.service.impl.CategoryThreeServiceImpl;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(value="/CateThree")
public class CategoryThreeController {
    @Autowired
    private CategoryThreeServiceImpl categoryThreeService;

    /**
     * 根据二级id查询三级选项
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping(value="/Threelist")
    public Object listThree(int id){
        List<CategoryThree> three=categoryThreeService.listThree( id );
        Object obj= JSON.toJSONString(three);
        return obj;
    }

    /**
     * 添加三级选项
     * @param three
     * @return
     */
    @ResponseBody
    @RequestMapping(value="/Threeinsert")
    public Object insertThree(CategoryThree three){
        int jie=categoryThreeService.insertThree( three );
        Object obj= JSON.toJSONString(jie);
        return obj;
    }
    @ResponseBody
    @RequestMapping(value="/Threeupdate")
    public Object upadteThree(CategoryThree three){
        int jie=categoryThreeService.insertThree( three );
        Object obj= JSON.toJSONString(jie);
        return obj;
    }
}
