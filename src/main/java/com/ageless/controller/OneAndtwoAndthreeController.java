package com.ageless.controller;

import com.ageless.pojo.ProductAndPic;
import com.ageless.pojo.Seckill;
import com.ageless.pojo.oneAndtwoAndthree;
import com.ageless.service.OneAndtwoAndthreeService;
import com.ageless.service.ProductAndPicService;
import com.ageless.service.SeckillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(value = "ageless")
public class OneAndtwoAndthreeController {
    @Autowired
   private OneAndtwoAndthreeService  oneAndtwoAndthreeService;

    @Autowired
    private ProductAndPicService productService;
    @Autowired
    private SeckillService seckillService;



    @RequestMapping("/index.html")
    public String lists(Model model){
        List<oneAndtwoAndthree> list=oneAndtwoAndthreeService.lists();
        model.addAttribute("list1",list);
        List<ProductAndPic> list4 =productService.list();
        model.addAttribute("list4",list4);
        List<ProductAndPic> list5 =productService.Newlist();
        model.addAttribute("list5",list5);
        List<Seckill> list6 = seckillService.selectSeckill();
        model.addAttribute("list6",list6);
        return "index";
    }
}
