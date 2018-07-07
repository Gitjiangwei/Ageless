package com.ageless.controller;

import com.ageless.pojo.SkuProperty;
import com.ageless.service.SkuPropertyService;
import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/sku")
public class SkuproPertyController {

    @Resource
    private SkuPropertyService skuPropertyService;
    @GetMapping("/su")
    public String su(ModelAndView mv){


            return "/backstage/sortcon1";

    }
    @ResponseBody
    @GetMapping("/cha")
    public  Object cha(@RequestParam(value="id",required = false)int id ,@RequestParam(value = "nam",required = false)String name){

        System.out.println("id======"+id);
        System.out.println("nam======="+name);
        System.out.println();
        List<SkuProperty> list=skuPropertyService.seleAll(id,name);
        System.out.println(list);
        Object obj= JSON.toJSONString(list);
        System.out.println(obj);
        return obj;
    }

    @GetMapping("/shan")
    @ResponseBody
    public Object shanchu(int id ){
        int i=skuPropertyService.shan(id);
        int b=0;
        if(i>0){
            b= skuPropertyService.shan1(id);
        }
        System.out.println("shuji========"+b);

        return  JSON.toJSON(b);
    }

}
