package com.ageless.controller;

import com.ageless.pojo.Product;
import com.ageless.pojo.Property;
import com.ageless.pojo.Sort;
import com.ageless.pojo.Sortcon;
import com.ageless.service.SortService;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * 姚毅
 */
@Controller
@RequestMapping(value = "/sort")
public class SortController {

    Logger logger = LoggerFactory.getLogger(AreaController.class);

    @Autowired
    private SortService sortService;


    @RequestMapping(value = "/qwwe", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView index(Integer categorythreeId, @RequestParam(defaultValue = "1") Integer pageIndex,String tiaojian,HttpServletRequest request) {
        ModelAndView mv = new ModelAndView();
        List<Sort> selectsanji = sortService.selectsanji(categorythreeId);
        List<Integer> list =new ArrayList<Integer>();
        list.add(0);
        list.add(0);
        list.add(0);
        request.setAttribute("selectsanji", selectsanji);


        List<Product> selectProduct = sortService.selectProduct(list,tiaojian,pageIndex);
        PageInfo<Product> info = new PageInfo<Product>(selectProduct);
        request.setAttribute("shuliang", info.getTotal());//共多少个商品

        request.setAttribute("pageIndex", pageIndex);
        request.setAttribute("pageCount", info.getPages());
        request.setAttribute("selectProduct", selectProduct);
        mv.setViewName("item_category");
        return mv;
    }

    @RequestMapping(value = "/qweqwe", method = RequestMethod.POST)
    @ResponseBody
    public ModelAndView er(Integer categorythreeId, @RequestParam(defaultValue = "1") Integer pageIndex,String tiaojian,HttpServletRequest request) {
        ModelAndView mv = new ModelAndView();
        List<Sort> selectsanji = sortService.selectsanji(categorythreeId);

        request.setAttribute("selectsanji", selectsanji);

        List<Integer> list =new ArrayList<Integer>();


        String[] lists = request.getParameterValues("list[]");
        for (int i =0;i<lists.length;i++){
            list.add(Integer.parseInt(lists[i]));
        }
        List<Product> selectProduct = sortService.selectProduct(list, tiaojian,pageIndex);
        PageInfo<Product> info = new PageInfo<Product>(selectProduct);
        request.setAttribute("shuliang", info.getTotal());//共多少个商品
        request.setAttribute("pageIndex", pageIndex);
        request.setAttribute("pageCount", info.getPages());
        request.setAttribute("selectProduct", selectProduct);

        mv.setViewName("item_category_sort");
        return mv;
    }


    /**
     * 模糊查询
     * @param
     * @param request
     * @return
     */
    @RequestMapping(value = "/selectmohu", method = RequestMethod.POST)
    @ResponseBody
    public ModelAndView selectmohu(HttpServletRequest request,@RequestParam(defaultValue = "1") Integer pageIndex,String tiaojian) {
        ModelAndView mv = new ModelAndView();
        String mohu = request.getParameter("mohu");
        System.out.println(mohu);
        List<Product> selectmohu = sortService.selectmohu(mohu, tiaojian, pageIndex);
        PageInfo<Product> info = new PageInfo<Product>(selectmohu);
        request.setAttribute("shuliang", info.getTotal());//共多少个商品
        request.setAttribute("pageindex", pageIndex);
        request.setAttribute("countpage", info.getPages());
        request.setAttribute("list1", selectmohu);
        mv.setViewName("item_sale_page");
        return mv;
    }

}