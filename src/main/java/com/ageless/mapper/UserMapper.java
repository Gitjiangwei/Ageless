package com.ageless.mapper;



import com.ageless.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
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

    /**
     * 数据查找OpenId是否与QQ关联
     * @param openId
     * @return
     */
    User userLoginOpenId(@Param("openId") String openId);

    /**
     * 添加QQ用户
     * @param user
     * @return
     */
    int addQqUser(User user);

 /**
  * 查询所有信息
  * @return
  */
    List<User> sellectAll(User user);
    /**
     * 除了登陆用户外的所有信息
     * @return
     */
    List<User> sellectAll1(User user);
}
