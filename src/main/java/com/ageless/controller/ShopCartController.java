package com.ageless.controller;


import com.ageless.pojo.Area;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/shop")
public class ShopCartController {
    @GetMapping("/")
    public String udai() {
        return "item_show";
    }
}
