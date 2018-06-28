package com.ageless.service.impl;

import com.ageless.mapper.UserMapper;
import com.ageless.pojo.User;
import com.ageless.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

/**
 * 用户
 */
@Transactional
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    /**
     * 用户登录
     * @param map
     * @return
     */
    @Override
    public User loginUser(Map<String, Object> map) {
        return userMapper.loginUser(map);
    }

    @Override
    public Integer updateUser(Map<String, Object> map) {
        return userMapper.updateUser(map);
    }
    @Override
    public int selectId() {
        return userMapper.selectId();
    }

    @Override
    public int selectCount(User user) {
        return userMapper.selectCount(user);
    }

    @Override
    public int inserInfo(User user) {
        return userMapper.inserInfo(user);
    }

    @Override
    public int inserInfo1(User user) {
        return userMapper.inserInfo1(user);
    }

}
