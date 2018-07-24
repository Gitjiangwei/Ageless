package com.ageless.controller;

import com.ageless.pojo.Product;
import com.ageless.pojo.User;
import com.ageless.service.IntegrralService;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller

public class IntegralController {

    @Resource
    private IntegrralService service;

    @RequestMapping(value = "lai",method = RequestMethod.GET)
    public String jinqu(){

        return  "udai_welcome";
    }



/*    @ResponseBody
    @RequestMapping(value = "chafen",method = RequestMethod.GET)
    public  Object jifen(HttpSession session){
        User user= (User) session.getAttribute("user");
        Object obj=JSON.toJSON(user);
        return obj;
    }*/
    @RequestMapping(value = "chafen",method = RequestMethod.GET)
    public  String jifens(Model model){

        System.out.println("chafenchanef_________________________");
        User uu=service.selectjifen(1);

        System.out.println("完成");
        System.out.println(uu);
        model.addAttribute("list",uu);
        return "udai_integral";

    }



    @RequestMapping(value="shangpin",method = RequestMethod.POST)
    public ModelAndView chajifen(HttpSession session,HttpServletRequest request, Integer PageIndex,  ModelAndView mm, Model model){
        System.out.println("llllllllllllllllllllllllllllllllllllllllllllllllllllllllll");

        User uu=service.selectjifen(1);
        List<Product> lll=service.selectproductjifen(PageIndex);
        System.out.println(lll.size());
        PageInfo<Product> info = new PageInfo<Product>(lll);
        request.setAttribute("shuliang", info.getTotal());//共多少个商品
        request.setAttribute("pageIndex", PageIndex);
        request.setAttribute("pageCount", info.getPages());
        request.setAttribute("selectProduct", lll);
        model.addAttribute("list",uu);


        mm.setViewName("integral_jifen");

        return mm;
    }


    @ResponseBody
    @RequestMapping(value="gai",method = RequestMethod.GET)
    public Object duihaun(@RequestParam(required = false) double ji, Integer id,  HttpSession session){
        System.out.println("000");
       /* User u=(User) session.getAttribute("user");
        Long idi=u.getId();
        String sR=Long.toString(idi);
        int ooo=Integer.parseInt(sR);*/
        User uu=service.selectjifen(1);
        System.out.println("1");
        String oo=uu.getIntegral();

        System.out.println("-----------------------------------------------"+oo);
        int pp=Integer.parseInt(oo);
        System.out.println(ji+"llll");


        //根据商品ID查询出商品的所有属性




        int ll=(int)(pp-ji);
        System.out.println(ll);
        String kk=Integer.toString(ll);

        int result=service.update(kk,1);


        return JSON.toJSONString(result);
    }
}
