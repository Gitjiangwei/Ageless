package com.ageless.controller;

import com.ageless.pojo.Notice;
import com.ageless.service.NoticeService;
import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@Controller
@RequestMapping("/er")
public class NoticeController {
    @Resource
    private NoticeService noticeService;

    //查询所有
    @ResponseBody
    @RequestMapping(value = "/select.html")
    public Object select(@RequestParam(required = false) Integer id,
                         @RequestParam(required = false) Integer typeId,
                         @RequestParam(required = false) String typeName){
        List<Notice> l=noticeService.qianselect(id,typeId, typeName);
        System.out.println(typeId);
        for (Notice item:l){
            System.out.println(item.getTypeId());
        }
        System.out.println(JSON.toJSONString(l));
        return JSON.toJSONString(l);
    }

    //id查
    @ResponseBody
    @RequestMapping(value = "/idcha.html")
    public Object idcha(@RequestParam(required = false) Integer id){
        Notice l=noticeService.incha(id);
        System.out.println("aaaaaaa"+JSON.toJSONString(l));
        return JSON.toJSONString(l);
    }
//带参数跳转
   /* @RequestMapping(value = "/getTest.html")
    public String getTestqq(@RequestParam String xid,@RequestParam String yid,HttpServletRequest request) {
        System.out.println("================="+xid);
         request.setAttribute("xid",xid);
        request.setAttribute("yid",yid);
        return  "udai_notice";
    }*/


//分页查询所有
    @RequestMapping("/probyxiao.html")
    @ResponseBody
    public ModelAndView probyxiao(@RequestParam(required = false) Integer id,
                                  @RequestParam(required = false) Integer typeId,
                                  @RequestParam(required = false) String typeName, Model model,
                                  @RequestParam(defaultValue ="1") int pageindex){
        ModelAndView modelAndView=new ModelAndView();
        PageHelper.startPage(pageindex,2,true);
        List<Notice> list= noticeService.qianselect(id,typeId, typeName);
        PageInfo info=new PageInfo(list);
        int countpage= info.getPages();
        System.out.println(countpage);
        System.out.println(id+"qqqqqq");
        System.out.println(typeId+"wwwwwwwwww");
        model.addAttribute("list1",list);
        modelAndView.setViewName("NOtice");
        model.addAttribute("pageindex",pageindex);
        model.addAttribute("countpage",countpage);

        return modelAndView;
    }
    //带参数跳转
    @RequestMapping(value = "/getTest.html")
    public String getTest(@RequestParam String xid,@RequestParam String yid,HttpServletRequest request) {
        System.out.println("================="+xid);
        request.setAttribute("xid",xid);
        request.setAttribute("yid",yid);
        return  "udai_notice";
    }

}
