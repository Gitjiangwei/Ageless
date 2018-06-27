package com.ageless.pojo;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * 用户表
 */
@Data
public class User {
    private Long id;//用户编号
    private String membership;//会员名
    private String name;//用户昵称
    private String phone;//注册手机号
    private Long sex;//性别

    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date birthday;//生日
    private String loginpwd;//登录密码
    private Long dongjie;//用户是否冻结

    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date regtime;//注册时间
    private String truename;//真实姓名
    private String integral;//积分
    private Long state;//会员名状态
    private String paymentpwd;//支付密码
    private String mailbox;//邮箱注册

}
