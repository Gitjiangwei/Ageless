package com.ageless.controller;

import com.ageless.pojo.CategoryThree;
import com.ageless.service.CategoryThreeService;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping(value="/CateThree")
public class CategoryThreeController {
    @Autowired
    private CategoryThreeService categoryThreeService;

    /**
     * 根据二级id查询三级选项
     * @param id,name
     * @return
     */
    @ResponseBody
    @RequestMapping(value="/Threelist")
    public Object listThree(@RequestParam(required = false) Integer id,@RequestParam(required = false) String name){
        List<CategoryThree> three=categoryThreeService.listThree( id,name );
        Object obj= JSON.toJSONString(three);
        return obj;
    }

    /**
     * 添加三级选项
     * @param names
     * @return
     */
    @ResponseBody
    @RequestMapping(value="/Threeinsert")
    public String insertThree(String names,int id) {
        System.out.println( names );
        if (names != null && names != "") {
            String[] array = names.split( "," );

            int jie = categoryThreeService.insertThree( Arrays.asList( array ), id );
            if (jie > 0) {
                return "{\"result\":\"success\"}";
            }else {
                return "{\"result\":\"添加失败\"}";
            }
        } else {
            return "0";
        }
    }

    /**
     * 修改三级选项
     * @param id,name
     * @return
     */
    @ResponseBody
    @RequestMapping(value="/Threeupdate")
    public String upadteThree(int id,String name){
        CategoryThree three=new CategoryThree();
        three.setCategoryName( name );
        three.setId( id );
        int jie=categoryThreeService.updateThree( three );
        if(jie>0){
            return "1";
        }else {
            return "0";
        }
    }



    /**
     * 删除三级选项
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping(value="/Threedelete")
    public String deleteThree(int id){

        int jie=categoryThreeService.deleteThree( id );
        if(jie>0){
            return "1";
        }else {
            return "0";
        }
    }
}
