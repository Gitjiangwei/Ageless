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
import java.util.List;

@Controller

public class IntegralController {

    @Resource
    private IntegrralService service;

    @RequestMapping(value = "lai",method = RequestMethod.GET)
    public String jinqu(){

        return  "udai_welcome";
    }




    @RequestMapping(value = "chafen",method = RequestMethod.GET)
    public  String jifen(Integer id, Model model){
        System.out.println("chafenchanef_________________________");
        User uu=service.selectjifen(1);

        System.out.println("完成");
        System.out.println(uu);
        model.addAttribute("list",uu);
        return "udai_integral";
    }


    @RequestMapping(value="shangpin",method = RequestMethod.POST)
     public ModelAndView chajifen(HttpServletRequest request, Integer PageIndex, String  hhhh,ModelAndView mm, Model model,String membership,String phone,String mailbox){
        System.out.println("llllllllllllllllllllllllllllllllllllllllllllllllllllllllll");
      /* System.out.println(hhhh);
        User u=new User();
       boolean huiyaun=false;
        if(hhhh.indexOf("@")!=-1){
            huiyaun=true;
            u.setMailbox(hhhh);
        }else{
            huiyaun=false;
        }

        int num=0;
        for(int i=0;i<hhhh.length();i++){
            char x=hhhh.charAt(i);
            if((x>'a' &&x<'z' )||(x>'A'&&x<'Z') ){
                num++;
            }
        }
       if(num<=0){
            u.setPhone(hhhh);
       }

        char a1 = hhhh.charAt(0);//第一个元素
        char a2 = hhhh.charAt(1);//第二个元素
         if(a1=='t'&&a2=='y'){
            u.setMembership(hhhh);
         }

         User o= service.selectUserId(membership,phone,mailbox);
        Long id=o.getId();
        String sR=Long.toString(id);
        int ooo=Integer.parseInt(sR);*/
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
    public Object duihaun(@RequestParam(required = false) Integer ji,String hhhh,String membership,String phone,String mailbox){
       /* User u=new User();
        boolean huiyaun=false;
        if(hhhh.indexOf("@")!=-1){
            huiyaun=true;
            u.setMailbox(hhhh);
        }else{
            huiyaun=false;
        }

        int num=0;
        for(int i=0;i<hhhh.length();i++){
            char x=hhhh.charAt(i);
            if((x>'a' &&x<'z' )||(x>'A'&&x<'Z') ){
                num++;
            }
        }
        if(num<=0){
            u.setPhone(hhhh);
        }

        char a1 = hhhh.charAt(0);//第一个元素
        char a2 = hhhh.charAt(1);//第二个元素
        if(a1=='t'&&a2=='y'){
            u.setMembership(hhhh);
        }

        User o= service.selectUserId(membership,phone,mailbox);
        Long id=o.getId();
        String sR=Long.toString(id);
        int ooo=Integer.parseInt(sR);*/
        User uu=service.selectjifen(1);

        String oo=uu.getIntegral();
        System.out.println("-----------------------------------------------"+oo);
         int pp=Integer.parseInt(oo);
        System.out.println(ji+"llll");

         int ll=pp-ji;
        System.out.println(ll);
        String kk=Integer.toString(ll);
        int result=service.update(kk,1);
        return JSON.toJSONString(result);
    }
}
