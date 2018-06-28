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
}
