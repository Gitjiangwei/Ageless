package com.ageless.service;

import com.ageless.pojo.User;

import java.util.Map;

public interface UserService {
    /**
     * 用户登录
     * @param map
     * @return
     */
    User loginUser (Map<String,Object> map);

    /**
     * 修改用户信息
     * @param map
     * @return
     */
    Integer updateUser(Map<String,Object> map);

    /**
     * 查询Id用于拼接用户的默认用户名
     * @return
     */
    public int selectId();

    /**
     * 查询条数用于判断用户是否重复注册
     * @param user
     * @return
     */
    public int selectCount(User user);

    /**
     * 添加用户信息（手机注册）
     * @param user
     * @return
     */
    public int inserInfo(User user);

    /**
     * 添加用户信息（邮箱注册）
     * @param user
     * @return
     */
    public int inserInfo1(User user);
}
