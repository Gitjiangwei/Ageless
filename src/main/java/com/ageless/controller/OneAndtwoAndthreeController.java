package com.ageless.controller;

import com.ageless.pojo.*;
import com.ageless.service.OneAndtwoAndthreeService;
import com.ageless.service.ProductAndPicService;
import com.ageless.service.SeckillService;
import com.ageless.service.ShopCartService;
import com.ageless.service.impl.RedisUtil;
import com.alibaba.fastjson.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "ageless")
public class OneAndtwoAndthreeController {
    @Autowired
   private OneAndtwoAndthreeService  oneAndtwoAndthreeService;

    @Autowired
    private ProductAndPicService productService;
    @Autowired
    RedisUtil redisUtil;
    @Autowired
    private SeckillService seckillService;

    @Autowired
    private ShopCartService shopCartService;

    @RequestMapping("/index.html")
    public String lists(Model model, HttpSession session){
        if (redisUtil.getStringKey("shouye") == null){
            List<oneAndtwoAndthree> list=oneAndtwoAndthreeService.lists();
            model.addAttribute("list1",list);
        }else{
            JSONArray jsonArr = JSONArray.fromObject(redisUtil.getStringKey("shouye"));
            List list = new ArrayList();
            for (int i = 0; i < jsonArr.size(); i++)
            {
                list.add(JSONObject.toBean(jsonArr.getJSONObject(i), oneAndtwoAndthree.class));
            }
            model.addAttribute("list1",list);
            System.out.println(list);
        }
       User user = (User) session.getAttribute("user");

        if(user==null){
            model.addAttribute("list7",user);
            List<ProductAndPic> list4 =productService.list();
            model.addAttribute("list4",list4);
            List<ProductAndPic> list5 =productService.Newlist();
            model.addAttribute("list5",list5);
            List<Seckill> list6 = seckillService.selectSeckill();
            model.addAttribute("list6",list6);
        }else{
            model.addAttribute("list7",user);
            List<ProductAndPic> list4 =productService.list();
            model.addAttribute("list4",list4);
            List<ProductAndPic> list5 =productService.Newlist();
            model.addAttribute("list5",list5);
            List<Seckill> list6 = seckillService.selectSeckill();
            model.addAttribute("list6",list6);
            int num= user.getId().intValue();
            int number=shopCartService.chaCart(num);
            model.addAttribute("list8",number);
        }
        return "index";
    }

}
