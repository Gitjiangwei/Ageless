package com.ageless.controller;

import com.ageless.pojo.User;
import com.ageless.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
public class AddressController {

    @Autowired
    private AddressService addressService;


    /**
     * 添加收货地址
     * @param session
     * @return
     */

    private String integerAddress(Long id,HttpSession session){
        User u= (User) session.getAttribute("user");
        Long userId=u.getId();//用户Id

        return null;
    }
}
