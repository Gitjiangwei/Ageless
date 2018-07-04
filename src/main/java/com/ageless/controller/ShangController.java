package com.ageless.controller;


import com.ageless.pojo.Product;
import com.ageless.service.ShangService;
import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(value="/shang")
public class ShangController {
    @Autowired
    private ShangService shangservice;
    /**
     * 查询所有商品（包括已上架）
     * @param
     * @return
     */

    @ResponseBody
    @RequestMapping(value="/shanglist")
    public Object listTwo(){
        List<Product> product = shangservice.cha();
        Object obj= JSON.toJSONString(product);
        return obj;
    }
    /**
     * 查询所有商品（未上架）
     * @param
     * @return
     */
    @ResponseBody
    @RequestMapping(value="/shanglist2")
    public Object list(){
        List<Product> product = shangservice.cha2();
        Object obj= JSON.toJSONString(product);
        return obj;
    }
    /**
     * 修改商品状态（下架）
     * @param
     * @return
     */

    @ResponseBody
    @RequestMapping(value="/shangupdate")
    public Object updata(@RequestParam (required = false)List s){
        int result = shangservice.update(s);
        if(result>0){
            return "1";
        }else{
            return "0";
        }
    }
    /**
     * 修改商品状态（上架）
     * @param
     * @return
     */

    @ResponseBody
    @RequestMapping(value="/shangupdate1")
    public Object updata1(@RequestParam (required = false)List s){
        int result = shangservice.update1(s);
        if(result>0){
            return "1";
        }else{
            return "0";
        }
    }

}
