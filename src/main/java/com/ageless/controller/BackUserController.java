package com.ageless.controller;

import com.ageless.pojo.User;
import com.ageless.service.UserService;
import com.ageless.util.MD5;
import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Wang.sir
 * @create 2018-07-02 14:52
 * @desc
 **/
@Controller
@RequestMapping(value="backstage")
public class BackUserController {
    @Autowired
    UserService userService;

    MD5 md5 = new MD5();
    @RequestMapping("back_table.html")
    public String table(){
        return "backstage/back_table";
    }
    @RequestMapping("back_add.html")
    public String add(){
        return "backstage/back_add";
    }
    @RequestMapping("back_login.html")
    public String login(){
        return "backstage/back_login";
    }
    @RequestMapping("/blogin")
    @ResponseBody
    public String logins(@Valid User user, HttpSession session){
        Map<String,Object> map= new HashMap<String,Object>();
        map.put("membership",user.getMembership());//会员名
        map.put("phone",user.getPhone());//手机号
        map.put("mailbox",user.getMailbox());//邮箱
        String pwd =user.getLoginpwd();//密码
        String op= md5.string2MD5(pwd);
        map.put("loginpwd",op);//密码
        User u = userService.loginUser(map);
        if (u!=null){
            //用户信息 key为 user
            session.setAttribute("user",u);
            Long  id=u.getId();
            //用户ID key为 user
            session.setAttribute("uid",id);
            Long dongjie=  u.getDongjie();
            String nam =u.getMembership();
            Long state =u.getState();
            if(dongjie==2){
                return "{\"mes\":\"frozen\"}";
            }else if(state==0){
                return "{\"mes\":\"frozen1\"}";
            }else{
                return "{\"mes\":\"success\",\"num\":\""+nam+"\"}";
            }
        }
        return "{\"mes\":\"error\"}";
    }
    @GetMapping("/selectA")
    @ResponseBody
    public Object selectAll(){
        User user =new User();
        List<User> list = userService.sellectAll(user);
        Object str = JSON.toJSON(list);
        System.out.println(str);
        return str;
    }

    @RequestMapping("/dongjie")
    @ResponseBody
    public Object dongjie(@RequestParam(required = false) String member,@RequestParam(defaultValue = "1") String dong,HttpSession session){
        System.out.println("aaaaaaaaaaaaaaaaaaaaaaa"+dong);
        Map<String,Object> map= new HashMap<String,Object>();
        Integer result=0;
        if(dong.equals("2")){
            map.put("membership",member);
            map.put("dongjie",1);
            result = userService.updateUser(map);
        }else{
            map.put("membership",member);
            map.put("dongjie",2);
            result = userService.updateUser(map);
        }
        if(result>=1){
            return "{\"mes\":\"yes\"}";
        }else {
            return "{\"mes\":\"no\"}";
        }
    }

    @GetMapping("/xiangqing")
    @ResponseBody
    public Object xiangQing(@RequestParam(required = false)String member,HttpSession session){
        System.out.println("================================详情页面"+member);
        session.setAttribute("membership",member);
        User user =new User();
        user.setMembership(member);
        if(userService.sellectAll(user).size()!=0){
            return "{\"back\":\"有数据\"}";
        }else {
            return "{\"back\":\"无数据\"}";
        }
    }
    @GetMapping("/gerenInfo")
    @ResponseBody
    public Object xiangQing(HttpSession session){
        User user =new User();
        String membership =(String)session.getAttribute("membership");
        user.setMembership(membership);
        List<User>list = userService.sellectAll(user);
        Object str = JSON.toJSON(list);
        System.out.println("================================个人信息"+str);
        if(list.size()!=0){
            return str;
        }else {
            return "{\"back\":\"无数据\"}";
        }
    }
}
