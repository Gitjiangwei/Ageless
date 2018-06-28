package com.ageless.mapper;



import com.ageless.pojo.User;

import java.util.Map;

public interface UserMapper {

    /**
     * 用户登录
     * @param map
     * @return
     */
   User loginUser (Map<String,Object> map);

    /**
     * 修改用户信息3
     * @param map
     * @return
     */
   Integer updateUser(Map<String,Object> map);

    /**
     * 查询最大id
     * @return
     */
    public int selectId();

    /**
     * 查询用户条数用于判断用户是否重复注册
     * @param user
     * @return
     */
    public int selectCount(User user);

    /**
     * 根据手机号注册信息
     * @param user
     * @return
     */
    public int inserInfo(User user);

    /**
     * 根据邮箱注册信息
     * @param user
     * @return
     */
    public int inserInfo1(User user);
}
