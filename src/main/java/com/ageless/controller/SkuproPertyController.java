package com.ageless.controller;

import com.ageless.pojo.SkuProperty;
import com.ageless.service.CategoryOneService;
import com.ageless.service.SkuPropertyService;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/sku")
public class SkuproPertyController {

    @Resource
    private SkuPropertyService skuPropertyService;
    @Autowired
    private CategoryOneService categoryOneService;

    @ResponseBody
    @GetMapping("/cha")
    public  Object cha(@RequestParam(value="id",required = false)Integer Fid ,@RequestParam(value = "nam",required = false)String name){
        System.out.println(name);
        List<SkuProperty> list=skuPropertyService.seleAll(Fid,name,null);
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

    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(@RequestBody SkuProperty[] sku){
System.out.println(sku[0].getPropertyName());
        int result=0;
        int  re=0;
        for(int i=0;i<sku.length;i++){
            SkuProperty sku1=new SkuProperty();
            sku1.setPropertyName(sku[0].getPropertyName());
            System.out.println(sku[0].getCategoryId());
            sku1.setCategoryId(sku[0].getCategoryId());
            re=skuPropertyService.add(sku1);

            result=skuPropertyService.addSkuOption(sku[i].getList(),sku1.getId());
        }

        if(result>0&&re>0){
            return "true";
        }else{
            return "error";
        }

    }


    @GetMapping("/xiugai")
    @ResponseBody
    public Object xiugai(@RequestParam(required=false)Integer id, HttpSession session){
        System.out.println(id);
        List<SkuProperty> list=skuPropertyService.seleAll(0,null,id);
        Object obj=JSON.toJSONString(list);
        System.out.println(obj);
        return obj;

    }

    @RequestMapping(value = "/xiu")
    @ResponseBody
    public Object xiu(@RequestParam(required = false)Integer id,@RequestParam(required = false)String name){
        System.out.println(id);
        int result=skuPropertyService.updateSku(id,name);
        if(result>0){
            return "true";
        }else{
            return "error";
        }

    }

    @RequestMapping(value = "/update")
    @ResponseBody
    public Object xiu1(@RequestParam(required = false)Integer id,@RequestParam(required = false)String name){
        System.out.println(id);
        int result=skuPropertyService.updateOption(id,name);
        if(result>0){
            return "true";
        }else{
            return "error";
        }

    }
}
