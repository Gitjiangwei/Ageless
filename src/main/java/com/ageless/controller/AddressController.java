package com.ageless.controller;

import com.ageless.pojo.Address;
import com.ageless.pojo.User;
import com.ageless.service.AddressService;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class AddressController {

    @Autowired
    private AddressService addressService;

    /**
     * 显示该用户收货地址
     * @param id
     * @param session
     * @return
     */
    @PostMapping(value = "/showAdd")
    @ResponseBody
    private String showAddress(Long id,HttpSession session){
        Long userId= (Long) session.getAttribute("uid");
        /*Long userId= Long.valueOf(1);//用户Id*/
        List<Address> userList=addressService.getListAddress(userId);
        return JSON.toJSONString(userList);
    }

    /**
     * 删除收货地址
     * @param id
     * @param session
     * @return
     */
    @PostMapping(value = "/delAdd")
    @ResponseBody
    private Object delAddress(Long id,HttpSession session){
        int i=addressService.deleteAddress(id);
        Object obj="";
        if (i>0){
            obj= "{\"del\":\"OK\"}";
        }else{
            obj= "{\"del\":\"NO\"}";
        }
        return obj;
    }

    /**
     * 添加收货地址
     * @param session
     * @return
     */
    @PostMapping(value = "/insertAdd")
    @ResponseBody
    private Object integerAddress(Address address,HttpSession session){
        User u= (User) session.getAttribute("user");
        Long userId=u.getId();//用户Id
        /*Long userId= Long.valueOf(1);//用户Id*/
        address.setNameId(userId);
        System.out.println(address.toString());


        Integer count=addressService.count(address.getNameId());
        Object obj="";
        if(count<6){
            if(address.getState()==1){
                addressService.updatenameId(address.getNameId());
            }
            Integer i=addressService.insertAddress(address);
            if(i>0){
                obj= "{\"add\":\"OK\"}";
            }else{
                obj= "{\"add\":\"NO\"}";
            }
        }else{
            obj= "{\"add\":\"DOT\"}";
        }

        return obj;
    }



    /**
     * 修改收货地址
     * @param session
     * @return
     */
    @PostMapping(value = "/updateAdd")
    @ResponseBody
    private Object updateAddress(Address address,HttpSession session){
        Integer i=addressService.updateAddress(address);
        Object obj="";
        if(i>0){
            obj= "{\"upd\":\"OK\"}";
        }else{
            obj= "{\"upd\":\"NO\"}";
        }
        return obj;
    }

    /**
     * 修改收货地址状态
     * @param address
     * @param session
     * @return
     */
    @PostMapping(value = "/updateState")
    @ResponseBody
    private Object updateState(Address address,HttpSession session){
        System.out.println(address);
        Integer a=addressService.updatenameId(address.getNameId());
        Integer b=addressService.updateId(address.getId());
        Object obj="";
        if(a>0 && b>0){
            obj= "{\"sta\":\"OK\"}";
        }else{
            obj= "{\"sta\":\"NO\"}";
        }
        return obj;
    }
}
