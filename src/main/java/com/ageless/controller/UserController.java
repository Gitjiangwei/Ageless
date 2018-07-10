package com.ageless.controller;

import com.ageless.pojo.User;
import com.ageless.service.UserService;
import com.ageless.util.GetSMS;
import com.ageless.util.MD5;
import com.ageless.util.RandUtil;
import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/*import com.qq.connect.QQConnectException;
import com.qq.connect.api.OpenID;
import com.qq.connect.api.qzone.UserInfo;
import com.qq.connect.javabeans.AccessToken;
import com.qq.connect.javabeans.qzone.UserInfoBean;
import com.qq.connect.oauth.Oauth;*/

/**
 * 用户
 * 用户信息 key为 user
 * 以保存该用户所用信息
 */
@Controller
@RequestMapping(value = "ageless")
public class UserController {

    Logger logger = LoggerFactory.getLogger(AreaController.class);

    @Autowired
    JavaMailSender jms;

    @Autowired
    private UserService userService;
    //private  HttpSession session;
    MD5 md5 = new MD5();

    private String rum;
    private String member;
    private Date data1;
    private Date data2;

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
     * 支付地址
     * @return
     */
    @GetMapping("/udai_shopcart_pay.html")
    public String udai_shopcart_pay() { return "udai_shopcart_pay"; }

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
          if(dongjie==2){
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
        System.out.println("1111"+u);
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
        Date dateDate =user.getBirthday();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = formatter.format(dateDate);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = dateFormat.parse(dateString);
            System.out.println(date.toLocaleString().split(" ")[0]);//切割掉不要的时分秒数据
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Map<String,Object> map=new HashMap<>();
        map.put("membership",user.getMembership());
        map.put("name",user.getName());
        map.put("sex",user.getSex());
        map.put("birthday",date.toLocaleString().split(" ")[0]);
        map.put("truename",user.getTruename());
        map.put("id",id);
        int x=userService.updateUser(map);
        if(x>0){
            return "{\"mes\":\"yes\"}";
        }else{
            return "{\"mes\":\"no\"}";
        }
    }

    /**
     * 发送短信验证码
     * @return
     */
    @RequestMapping("/sendMessage")
    @ResponseBody
    public Object sendMessage(@RequestParam(required = false) String yzNum){
        Object object =null;
        User user =new User();
        user.setPhone(yzNum);
        if(userService.selectCount(user)==1){
            object="{\"back\":\"重复\"}";
        }else {
            String randum = GetSMS.getmMssage(yzNum);
            rum = randum;
            data1=new Date();
            object="{\"back\":\"成功\"}";
        }
        /*try {
            rum =Integer.parseInt(randum);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }*/
        return object;
    }

    @RequestMapping("/sendMessage1")
    @ResponseBody
    public Object sendMessage1(@RequestParam(required = false) String yzNum){
        member=yzNum;
        Object object =null;
        User user =new User();
        user.setPhone(yzNum);
        if(userService.selectCount(user)==1){
            String randum = GetSMS.getmMssage(yzNum);
            rum = randum;
            data1=new Date();
            object="{\"back\":\"重复\"}";
        }else {
            object="{\"back\":\"成功\"}";
        }
        /*try {
            rum =Integer.parseInt(randum);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }*/
        return object;
    }
    /**
     * 添加手机号注册的用户
     * @param numBack
     * @param phoneNo
     * @param pwdNum
     * @return
     */
    @RequestMapping("/addMember")
    @ResponseBody
    public Object addMember(@RequestParam(required = false) String numBack, @RequestParam(required = false) String phoneNo, @RequestParam(required = false) String pwdNum){
        data2=new Date();
        long num = (data2.getTime()-data1.getTime())/1000;
        Object object=null;
        int name = userService.selectId()+1;
        String names ="ty"+RandUtil.getRandomNum5() +name;
        User user =new User();
        user.setMembership(names);
        user.setLoginpwd(md5.string2MD5(pwdNum));
        user.setRegtime(new Date());
        if(num>=60){
            object="{\"back\":\"超时\"}";
        }else if(numBack.equals(rum)){
            if(phoneNo.contains("@")&&phoneNo.contains(".")){
                user.setMailbox(phoneNo);
                if(userService.selectCount(user)==1){
                    object="{\"back\":\"重复\"}";
                }else {
                    userService.inserInfo1(user);
                    object="{\"back\":\"对的\"}";
                }
            }else {
                user.setPhone(phoneNo);
                if(userService.selectCount(user)==1){
                    object="{\"back\":\"重复\"}";
                }else {
                    userService.inserInfo(user);
                    object="{\"back\":\"对的\"}";
                }
            }

        }else{
            object="{\"back\":\"错的\"}";
        }
        return object;
    }
    @RequestMapping("/updateMember")
    @ResponseBody
    public Object updateMember(@RequestParam(required = false) String numBack, @RequestParam(required = false) String phoneNo, @RequestParam(required = false) String pwdNum){
        data2=new Date();
        long num = (data2.getTime()-data1.getTime())/1000;
        Object object=null;
        User user =new User();
        Map<String,Object> map= new HashMap<String,Object>();
        user.setLoginpwd(md5.string2MD5(pwdNum));
        map.put("loginpwd",user.getLoginpwd());
        if(num>=60){
            object="{\"back\":\"超时\"}";
        }else if(numBack.equals(rum)&&member.equals(phoneNo)){
            if(phoneNo.contains("@")&&phoneNo.contains(".")){
                user.setMailbox(phoneNo);
                map.put("mailbox",user.getMailbox());
                if(userService.updateUser(map)==1){
                    object="{\"back\":\"对的\"}";
                }else {
                    object="{\"back\":\"重复\"}";
                }
            }else {
                user.setPhone(phoneNo);
                map.put("phone",user.getPhone());
                if(userService.updateUser(map)==1){
                    userService.updateUser(map);
                    object="{\"back\":\"对的\"}";
                }else {
                    object="{\"back\":\"重复\"}";
                }
            }
        }else{
            object="{\"back\":\"错的\"}";
        }
        return object;
    }

    /**
     * 发送邮箱验证码
     * @param yzNum
     * @return
     */
    @RequestMapping("/sendEmail")
    @ResponseBody
    public Object send(@RequestParam(required = false)String yzNum){
        Object object =null;
        User user =new User();
        user.setMailbox(yzNum);
        if(userService.selectCount(user)==1){
            object="{\"back\":\"重复\"}";
        }else {
            data1=new Date();
            String rum = RandUtil.getRandomNum();
            SimpleMailMessage mainMessage = new SimpleMailMessage();
            //发送者
            mainMessage.setFrom("821488037@qq.com");
            //接收者
            mainMessage.setTo(yzNum);
            //发送的标题
            mainMessage.setSubject("【花想容】");
            //发送的内容
            mainMessage.setText("【花想容】您好您的验证码是："+rum+"请于1分钟内完成验证，如非本人请忽略本内容");
            jms.send(mainMessage);
            //建立邮件消息
            object="{\"back\":\"成功\"}";
        }
        return object;
    }
    /**
     * 忘记密码发送邮箱验证码
     * @param yzNum
     * @return
     */
    @RequestMapping("/sendEmail1")
    @ResponseBody
    public Object send1(@RequestParam(required = false)String yzNum){
        System.out.println("++++++++++++++++++++="+yzNum);
        member=yzNum;
        Object object =null;
        User user =new User();
        user.setMailbox(yzNum);
        if(userService.selectCount(user)==1){
            rum =RandUtil.getRandomNum();
            data1=new Date();
            //建立邮件消息
            SimpleMailMessage mainMessage = new SimpleMailMessage();
            //发送者
            mainMessage.setFrom("821488037@qq.com");
            //接收者
            mainMessage.setTo(yzNum);
            //发送的标题
            mainMessage.setSubject("【花想容】");
            //发送的内容
            mainMessage.setText("【花想容】您好您的验证码是："+rum+"请于1分钟内完成验证，如非本人请忽略本内容");
            jms.send(mainMessage);
            object="{\"back\":\"成功\"}";
        }else {
            object="{\"back\":\"未注册\"}";
        }
        return object;
    }
    /**
     * 获取登录用户基本信息
     * @return
     */
    @ResponseBody
    @RequestMapping("/getUserInfo")
    public Object getUserInfo(HttpSession session){
        Object object=null;
        User user  = (User)session.getAttribute("user");
        Object json = JSON.toJSON(user);
        System.out.println("===================="+json);
        return json;
    }
    /**
     * 生成QQ授权
     *
     * @param request
     * @return
     * @throws QQConnectException
     *//*
    @GetMapping("/authorizeUrl.html")
    public String authorizeUrl(HttpServletRequest request) {
        String authorizeUrl = null;
        try {
            authorizeUrl = new Oauth().getAuthorizeURL(request);
        } catch (QQConnectException e) {
            e.printStackTrace();
        }
        return "redirect:" + authorizeUrl;
    }

    @RequestMapping("/qqRedirect")
    public String qqRedirect(HttpServletRequest request, HttpServletResponse response) {
        String userOpenId=null;
        User userLoginOpenid=null;

        try {
            //第一步获取授权码
            AccessToken accessTokenObj = (new Oauth()).getAccessTokenByRequest(request);
            //第二部获取accesstoken
            String accesstoken=accessTokenObj.getAccessToken();

            String accessToken = null;
            String openID = null;
            Long tokenExpireIn = 0L;

            if(StringUtils.isEmpty(accesstoken)){
                logger.info("==========================未获取到用户 accessToken=========================");
            }else {
                //获取accessToken信息
                accessToken = accessTokenObj.getAccessToken();
                tokenExpireIn = accessTokenObj.getExpireIn();

                // 利用获取到的accessToken 去获取当前用的openid
                OpenID openIDObj =  new OpenID(accessToken);
                openID = openIDObj.getUserOpenID();

                //利用 accessToken 和 openID 获取用户信息
                UserInfo userInfo = new UserInfo(accessToken, openID);
                UserInfoBean userInfoBean = userInfo.getUserInfo();

                //第三方登录成功
                if(userInfoBean.getRet()==0){
                    userLoginOpenid = userService.userLoginOpenId(accessToken);
                    if(userLoginOpenid==null){
                        userLoginOpenid =new User();
                        userLoginOpenid.setMembership(userInfoBean.getNickname());
                        userLoginOpenid.setLoginpwd(userInfoBean.getGender());
                        userLoginOpenid.setDongjie(0L);
                        userLoginOpenid.setIntegral("0");
                        userLoginOpenid.setState(0L);
                        userLoginOpenid.setOpenId(accessToken);
                        userService.addQqUser(userLoginOpenid);
                    }
                    request.getSession().setAttribute("QQuser",userLoginOpenid);
                    request.getSession().setMaxInactiveInterval(tokenExpireIn.intValue());
                }else {
                    logger.info("未能正确获取到信息，原因是：" + userInfoBean.getMsg());
                }
            }

        } catch (QQConnectException e) {
            e.printStackTrace();
        }
        return "redirect:../../web/index";
    }*/
}
