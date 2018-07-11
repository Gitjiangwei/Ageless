package com.ageless.controller;

import com.ageless.pojo.NewsType;
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


    //查询所有
    @GetMapping(value = "/select")
    @ResponseBody
    public Object select(@RequestParam(required = false) String title, @RequestParam(required = false) Integer typeId){

        List<Notice> l=noticeService.selectAll(title,typeId);

        Object obj=JSON.toJSONString(l);
        System.out.println(l);

        return obj;
    }
    //新增方法
    @GetMapping(value="/insert")
    @ResponseBody
    public Object add(@ModelAttribute Notice n){
        System.out.println(n);
        //  n.setAnnouncementTime(new Date());
        int i=noticeService.add(n);

        Object p=JSON.toJSON(i);
        return p;
    }
    //删除
    @ResponseBody
    @GetMapping(value="/delet")
    public Object delect(@RequestParam(required = false) Integer id){
        int d=noticeService.delete(id);
        Object obj=JSON.toJSON(d);
        return obj;
    }
    //修改
    @GetMapping(value ="/update")
    @ResponseBody
    public Object eidtUser(@RequestParam(required = false) Integer id,@RequestParam(required = false) String title,@RequestParam(required = false) Integer typeId,String link,@RequestParam(required = false) String announcementContent) {
        int x= noticeService.xiuGai(id,title,typeId,link,announcementContent);
        Object obj=JSON.toJSON(x);
        return obj;
    }

    //下拉查询所有
    @GetMapping(value = "/xiaLa")
    @ResponseBody
    public Object select1()  {

        List<NewsType> n= noticeService.xiaLa();

        Object obj=JSON.toJSON(n);
        return obj;
    }

    //根据Id下拉列表查
    @GetMapping(value = "/selectId")
    @ResponseBody
    public Object selectId(@RequestParam Integer id){
        Notice t=noticeService.selectId(id);
        Object obj=JSON.toJSONString(t);
        return obj;
    }

    //类型查询所有
    @GetMapping("/selectNews")
    @ResponseBody
    public Object selectNews(){
        List<NewsType> k=noticeService.selectNewsType();
        Object obj=JSON.toJSON(k);
        return obj;
    }
    //类型删除
    @GetMapping(value = "/deletNews")
    @ResponseBody
    public Object deletNews(Integer nId){
        int r=noticeService.deletNews(nId);
        Object obj=JSON.toJSON(r);
        return obj;
    }

    //类型表新增
    @GetMapping(value = "/insertNews")
    @ResponseBody
    public Object insertNews(String typeName){
        System.out.println("oooooooooooo"+typeName);
        int g=noticeService.insertNews(typeName);
        Object obj=JSON.toJSON(g);
        System.out.println("ppppppppp"+obj);
        return obj;
    }

}
