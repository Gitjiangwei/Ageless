package com.ageless.controller;

import com.ageless.pojo.ProductAndPic;
import com.ageless.service.ProductAndPicService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ProductAreaController  {

        @Autowired
        private ProductAndPicService productAndPicService;

        @RequestMapping("/proxiao.html")
        public String proxiao( String product,Model model,@RequestParam(defaultValue ="1") int pageindex){
            PageHelper.startPage(pageindex,4,true);
            List<ProductAndPic> list= productAndPicService.listbyxiaoliang(product);
            PageInfo info=new PageInfo(list);
            int countpage= info.getPages();
            model.addAttribute("count",info.getTotal());
            model.addAttribute("list1",list);
            model.addAttribute("pageindex",pageindex);
            model.addAttribute("countpage",countpage);
             return "item_sale_page";
        }

        @RequestMapping("/probyxiao.html")
        @ResponseBody
        public ModelAndView probyxiao(String product, Model model, @RequestParam(defaultValue ="1") int pageindex){
            ModelAndView modelAndView=new ModelAndView();
            PageHelper.startPage(pageindex,4,true);
            List<ProductAndPic> list= productAndPicService.listbyxiaoliang(product);
            PageInfo info=new PageInfo(list);
            int countpage= info.getPages();
            model.addAttribute("list1",list);
            modelAndView.setViewName("item_sale_page_s");
            model.addAttribute("pageindex",pageindex);
            model.addAttribute("countpage",countpage);
            return modelAndView;
        }

    @RequestMapping("/proupdate.html")
    public String proupdate( String up,Model model,@RequestParam(defaultValue ="1") int pageindex){
        PageHelper.startPage(pageindex,4,true);
        List<ProductAndPic> list= productAndPicService.listbyupdate(up);
        PageInfo info=new PageInfo(list);
        int countpage= info.getPages();
        model.addAttribute("counts",info.getTotal());
        model.addAttribute("list1",list);
        model.addAttribute("pageindex",pageindex);
        model.addAttribute("countpage",countpage);
        return "item_sale_page_new";
    }


    @RequestMapping("/probyupdate.html")
    @ResponseBody
    public ModelAndView probyupdate(String up, Model model, @RequestParam(defaultValue ="1") int pageindex){
        ModelAndView modelAndView=new ModelAndView();
        PageHelper.startPage(pageindex,4,true);
        List<ProductAndPic> list= productAndPicService.listbyupdate(up);
        PageInfo info=new PageInfo(list);
        int countpage= info.getPages();
        model.addAttribute("list1",list);
        modelAndView.setViewName("item_sale_page_new_s");
        model.addAttribute("pageindex",pageindex);
        model.addAttribute("countpage",countpage);
        return modelAndView;
    }


}
