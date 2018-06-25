package com.ageless.controller;


import com.ageless.pojo.Area;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ShopCartController {
    @GetMapping("/udai_shopcart")
    public String udai() {
        return "udai_shopcart";
    }
}
