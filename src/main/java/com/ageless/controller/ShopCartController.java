package com.ageless.controller;


import com.ageless.pojo.Area;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ShopCartController {
    @GetMapping("/")
    public String udai() {
        return "item_show";
    }
}
