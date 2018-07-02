package com.ageless.controller;

import com.ageless.mapper.CategoryOneMapper;
import com.ageless.pojo.CategoryOne;
import com.ageless.pojo.CategoryThree;
import com.ageless.pojo.Sort;
import com.ageless.pojo.Sortcon;
import com.ageless.service.SortconService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/sort")
public class SortconController {
    @Autowired
    private SortconService sortconService;
    @Autowired
    private CategoryOneMapper categoryOneMapper;

    @RequestMapping(value = "/sortcon")
    public String selectAll(@RequestParam(required = false) String name,@RequestParam(required = false)String categoryName,
                            @RequestParam(required = false)Integer categoryThree, HttpSession session){
        System.out.print(categoryThree+"------------------------------");
        if (name == "") {
            name=null;
        }

        List<CategoryOne> lg=categoryOneMapper.Onelist(categoryName);
        List<Sort> ls= sortconService.selectAll(name,categoryThree);
        session.setAttribute("category",lg);


        session.setAttribute("lis",ls);
        System.out.print("-----------"+ls);
        return "/management/sortcon";
    }

    @RequestMapping(value = "/sortcon",method = RequestMethod.POST)
    public String selectAll1(@RequestParam(required = false) String name,@RequestParam(required = false)String categoryName,
                            @RequestParam(required = false)Integer categoryThree, HttpSession session){
        System.out.print(categoryThree+"------------------------------");
        if (name == "") {
            name=null;
        }

        List<CategoryOne> lg=categoryOneMapper.Onelist(categoryName);
        List<Sort> ls= sortconService.selectAll(name,categoryThree);
        session.setAttribute("category",lg);


        session.setAttribute("lis",ls);
        System.out.print("-----------"+ls);
        return "/management/sortcon";
    }
@RequestMapping(value = "/del")
@ResponseBody
    public Object del(@RequestParam(required = false)Integer id){
        boolean falg=sortconService.delSort(id);
        boolean f=sortconService.delSortcon(id);
        if(falg==true&&f==true){
            return "true";
        }else if(falg==false&&falg==false){
            return "false";
        }else if(falg==true&&falg==false){
            return "success";
        }else{
            return "error";
        }
    }
@RequestMapping(value = "/add")
@ResponseBody
  public Object add(@RequestBody Object obj){

        return "";
  }
}

