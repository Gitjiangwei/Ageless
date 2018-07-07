package com.ageless.controller;

import com.ageless.pojo.CategoryOne;
import com.ageless.pojo.Sort;
import com.ageless.service.CategoryOneService;
import com.ageless.service.SortService;
import com.ageless.service.SortconService;
import com.alibaba.fastjson.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/sort")
public class SortconController {
    @Autowired
    private SortconService sortconService;
    @Autowired
    private CategoryOneService categoryOneService;
    @Autowired
    private SortService sortService;

    @RequestMapping(value = "/sortcon")
    public String selectAll(@RequestParam(required = false) String name,@RequestParam(required = false)String categoryName,
                            @RequestParam(required = false)Integer categoryThree, HttpSession session){
        System.out.print(categoryThree+"------------------------------");
        if (name == "") {
            name=null;
        }

        List<CategoryOne> lg=categoryOneService.Onelist(categoryName);
        List<Sort> ls= sortconService.selectAll(name,categoryThree);
        session.setAttribute("category",lg);


        session.setAttribute("lis",ls);
        System.out.println("-----------"+ls);
        return "/backstage/sortcon";
    }

    @ResponseBody
    @RequestMapping(value = "/selects")
    public Object selects(@RequestParam(required = false)Integer categoryThree){
        List<Sort> ls= sortconService.selectAll(null,categoryThree);
        System.out.println(ls.get(0).getSortcons());
        Object ob = JSONArray.toJSONString(ls);
        return ob;
    }

    @RequestMapping(value = "/sortcon",method = RequestMethod.POST)
    public String selectAll1(@RequestParam(required = false) String name,@RequestParam(required = false)String categoryName,
                            @RequestParam(required = false)Integer categoryThree, HttpSession session){
        System.out.print(categoryThree+"------------------------------");
        if (name == "") {
            name=null;
        }

        List<CategoryOne> lg=categoryOneService.Onelist(categoryName);
        List<Sort> ls= sortconService.selectAll(name,categoryThree);
        session.setAttribute("category",lg);


        session.setAttribute("lis",ls);
        System.out.println("-----------"+ls);
        return "/backstage/sortcon";
    }
@RequestMapping(value = "/del")
@ResponseBody
    public Object del(@RequestParam(required = false)Integer id){

        boolean f=sortconService.delSortcon(id);
         boolean falg=sortconService.delSort(id);
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
  public Object add(@RequestBody Sort[] sort){


    int result=0;
     for(int i=0;i<sort.length;i++){
         Sort sort1=new Sort();
         sort1.setName(sort[i].getName());
         sort1.setCategorythreeId(sort[i].getCategorythreeId());
         int  sortId=sortconService.add(sort1);
         System.out.println(sort1.getId());
         result=sortService.addSortcon(sort[i].getSortcons(),sort1.getId());
     }
     if(result>0){
         return "true";
     }else{
         return "error";
     }

  }
}

