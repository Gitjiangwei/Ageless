package com.ageless.controller;

import com.ageless.pojo.ProductAndPic;
import com.ageless.pojo.oneAndtwoAndthree;
import com.ageless.service.OneAndtwoAndthreeService;
import com.ageless.service.ProductAndPicService;
import com.ageless.service.impl.RedisUtil;
import com.alibaba.fastjson.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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

    @RequestMapping("/index.html")
    public String lists(Model model){
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
        List<ProductAndPic> list4 =productService.list();
        model.addAttribute("list4",list4);
        List<ProductAndPic> list5 =productService.Newlist();
        model.addAttribute("list5",list5);
        return "index";
    }

}
