package com.ageless.controller;

import com.ageless.pojo.User;
import com.alibaba.fastjson.JSON;
import com.alipay.api.internal.parser.json.ObjectJsonParser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * @author Wang.sir
 * @create 2018-07-17 17:56
 * @desc
 **/
@Controller
@RequestMapping("ageless")
public class NoteController {

    @ResponseBody
    @RequestMapping("udai_welcome")
    public Object udai_article1(HttpSession session){
        User user= (User) session.getAttribute("user");
        Object obj=JSON.toJSON(user);
        return obj;
    }
    @RequestMapping("udai_article1")
    public String udai_article1s(){
        return "/temp_article/udai_article1";
    }
    @RequestMapping("udai_article2.html")
    public String udai_article2(){
        return "/temp_article/udai_article2";
    }
    @RequestMapping("udai_article3.html")
    public String udai_article3(){
        return "/temp_article/udai_article3";
    }
    @RequestMapping("udai_article4.html")
    public String udai_article4(){
        return "/temp_article/udai_article4";
    }
    @RequestMapping("udai_article5.html")
    public String udai_article5(){
        return "/temp_article/udai_article5";
    }
    @RequestMapping("udai_article6.html")
    public String udai_article6(){
        return "/temp_article/udai_article6";
    }
    @RequestMapping("udai_article7.html")
    public String udai_article7(){
        return "/temp_article/udai_article7";
    }
    @RequestMapping("udai_article10.html")
    public String udai_article10(){
        return "/temp_article/udai_article10";
    }
    @RequestMapping("udai_article11.html")
    public String udai_article11(){
        return "/temp_article/udai_article11";
    }
    @RequestMapping("udai_article12.html")
    public String udai_article12(){
        return "/temp_article/udai_article12";
    }
    @RequestMapping("udai_contract.html")
    public String udai_contract(){
        return "udai_contract";
    }
}
