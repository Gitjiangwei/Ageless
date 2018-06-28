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
     * 显示收货地址
     * @param id
     * @param session
     * @return
     */
    @PostMapping(value = "/showAdd")
    @ResponseBody
    private String showAddress(Long id,HttpSession session){
        User u= (User) session.getAttribute("user");
        /*Long userId=u.getId();//用户Id*/
        Long userId= Long.valueOf(1);//用户Id
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
        /*Long userId=u.getId();//用户Id*/
        Long userId= Long.valueOf(1);//用户Id
        address.setNameId(userId);
        Integer i=addressService.insertAddress(address);
        Object obj="";
        if(i>0){
            obj= "{\"add\":\"OK\"}";
        }else{
            obj= "{\"add\":\"NO\"}";
        }
        return obj;
    }

    /**
     * 根据id查询地址
     * @param model
     * @return
     */
    @GetMapping(value = "/udai_address_edit.html")
    private String selectAdd(@RequestParam Long id, Model model){
        Address address=addressService.selectAddress(id);
        model.addAttribute("address",address);
        return "udai_address_edit";
    }

    /**
     * 修改收货地址
     * @param session
     * @return
     */
    @PostMapping(value = "/updateAdd")
    @ResponseBody
    private Object updateAddress(Address address,HttpSession session){
        System.out.println(address);
        Integer i=addressService.updateAddress(address);
        Object obj="";
        if(i>0){
            obj= "{\"upd\":\"OK\"}";
        }else{
            obj= "{\"upd\":\"NO\"}";
        }
        return obj;
    }
}
