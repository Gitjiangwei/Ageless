package com.ageless.controller;

import com.ageless.pojo.User;
import com.ageless.service.UserService;
import com.ageless.util.MD5;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 用户
 * 用户信息 key为 user
 * 以保存该用户所用信息
 */
@Controller
public class UserController {

    Logger logger = LoggerFactory.getLogger(AreaController.class);

    @Autowired
    private UserService userService;
    //private  HttpSession session;
    MD5 md5 = new MD5();


    /**
     * 登录
     * @return
     */
    @GetMapping("/login.html")
    public String login() {
        return "login";
    }
    /**
     * 我的U袋
     * @return
     */
    @GetMapping("/udai_welcome.html")
    public String udai_welcome() {
        return "udai_welcome";
    }
    /**
     * 个人资料
     * @return
     */
    @GetMapping("/udai_setting.html")
    public String udai_setting() {
        return "udai_setting";
    }
    /**
     * 收货地址
     * @return
     */
    @GetMapping("/udai_address.html")
    public String udai_address() {
        return "udai_address";
    }
    /**
     * 修改支付密码
     * @return
     */
    @GetMapping("/udai_paypwd_modify.html")
    public String udai_paypwd_modify() {
        return "udai_paypwd_modify";
    }
    /**
     * 修改支付密码--直接修改
     * @return
     */
    @GetMapping("/udai_modifypay_step.html")
    public String udai_modifypay_step() {
        return "udai_modifypay_step";
    }
    /**
     * 修改支付密码--输入旧密码
     * @return
     */
    @GetMapping("/udai_modifypay_step1.html")
    public String udai_modifypay_step1() {
        return "udai_modifypay_step1";
    }
    /**
     * 修改支付密码--输入新密码
     * @return
     */
    @GetMapping("/udai_modifypay_step2.html")
    public String udai_modifypay_step2() {
        return "udai_modifypay_step2";
    }
    /**
     * 修改支付密码--完成
     * @return
     */
    @GetMapping("/udai_modifypay_step3.html")
    public String udai_modifypay_step3() {
        return "udai_modifypay_step3";
    }
    /**
     * 修改登录密码
     * @return
     */
    @GetMapping("/udai_pwd_modify.html")
    public String udai_pwd_modify() {
        return "udai_pwd_modify";
    }
    /**
     * 修改登录密码--输入旧密码
     * @return
     */
    @GetMapping("/udai_modifypwd_step1.html")
    public String udai_modifypwd_step1() { return "udai_modifypwd_step1"; }
    /**
     * 修改登录密码--输入新密码
     * @return
     */
    @GetMapping("/udai_modifypwd_step2.html")
    public String udai_modifypwd_step2() { return "udai_modifypwd_step2"; }
    /**
     * 修改登录密码--完成
     * @return
     */
    @GetMapping("/udai_modifypwd_step3.html")
    public String udai_modifypwd_step3() { return "udai_modifypwd_step3"; }
    /**
     * 商品
     * @return
     */
    @GetMapping("/item_category.html")
    public String item_category() { return "item_category"; }

    /**
     * 首页
     * 用户信息 key为 user 值为user对象
     * 用户ID key为 uid   值为用户Id
     * @return
     */
    @PostMapping(value="/user/loginUser")
    @ResponseBody
    public String loginUser(@Valid User user,HttpSession session) {
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
          if(dongjie==1){
              return "{\"mes\":\"frozen\"}";
          }else{
              return "{\"mes\":\"success\"}";
          }
        }
        return "{\"mes\":\"error\"}";
    }

    /**
     * 判断登录旧密码是否正确
     * @param opwd
     * @param session
     * @return
     */
    @ResponseBody
    @PostMapping("/udai_modifypwd_step1_opwd")
    public String udai_modifypwd_step1_opwd(String opwd,HttpSession session) {
        String op= md5.string2MD5(opwd);//获取输入的密码
        User u= (User) session.getAttribute("user");
        String  pwd=u.getLoginpwd();//获取用户密码
        if(op.equals(pwd)){
            return "{\"mes\":\"yes\"}";
        }else {
            return "{\"mes\":\"no\"}";
        }
    }

    /**
     * 修改登录密码
     * @param npwd
     * @param session
     * @return
     */
    @ResponseBody
    @PostMapping("/udai_modifypwd_step2_npwd")
    public String udai_modifypwd_step2_npwd(String npwd,HttpSession session) {
        Map<String,Object> map= new HashMap<String,Object>();
        String np= md5.string2MD5(npwd);//获取输入的密码
        map.put("loginpwd",np);
        User u= (User) session.getAttribute("user");
        Long  id=u.getId();//获取用户ID
        map.put("id",id);
        Integer result=userService.updateUser(map);
        if(result>=1){
            return "{\"mes\":\"yes\"}";
        }else {
            return "{\"mes\":\"no\"}";
        }
    }
    /**
     * 判断支付旧密码是否正确
     * @param opay
     * @param session
     * @return
     */
    @ResponseBody
    @PostMapping("/udai_modifypay_step1_opay")
    public String udai_modifypay_step1_opay(String opay,HttpSession session) {
        String op= md5.string2MD5(opay);//获取输入的密码
        User u= (User) session.getAttribute("user");
        String  pay=u.getPaymentpwd();//获取用户支付密码
        System.out.println(pay);
        if(op.equals(pay)){
            return "{\"mes\":\"yes\"}";
        }else {
            return "{\"mes\":\"no\"}";
        }
    }

    /**
     * 修改支付密码
     * @param npay
     * @param session
     * @return
     */
    @ResponseBody
    @PostMapping("/udai_modifypay_step2_opay")
    public String udai_modifypay_step2_opay(String npay,HttpSession session) {
        Map<String,Object> map= new HashMap<String,Object>();
        String np= md5.string2MD5(npay);//获取输入的密码
        map.put("paymentpwd",np);
        User u= (User) session.getAttribute("user");
        Long  id=u.getId();//获取用户ID
        map.put("id",id);
        Integer result=userService.updateUser(map);
        if(result>=1){
            return "{\"mes\":\"yes\"}";
        }else {
            return "{\"mes\":\"no\"}";
        }
    }

    /**
     * 修改個人信息
     * @param user
     * @param session
     * @return
     */
    @PostMapping("/udai_updateUser")
    @ResponseBody
    public String udai_updateUser(User user,HttpSession session){
        User u= (User) session.getAttribute("user");
        Long  id=u.getId();//获取用户ID
        user.setId(id);
        Map<String,Object> map=new HashMap<>();
        map.put("membership",user.getMembership());
        map.put("name",user.getName());
        map.put("sex",user.getSex());
        map.put("birthday",user.getBirthday());
        map.put("truename",user.getTruename());
        map.put("id",id);
        int x=userService.updateUser(map);
        if(x>0){
            return "{\"mes\":\"yes\"}";
        }else{
            return "{\"mes\":\"no\"}";
        }
    }

}
