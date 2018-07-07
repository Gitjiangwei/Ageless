package com.ageless.controller;


import com.ageless.pojo.*;
import com.ageless.service.ProductService;
import com.ageless.service.ShangService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping(value="/shang")
public class ShangController {

    private static final SimpleDateFormat sDateFormat = new SimpleDateFormat(
            "yyyyMMdd");// 时间
    @Autowired
    private ShangService shangservice;
    /**
     * 查询所有商品（包括已上架）
     * @param
     * @return
     */
    @Resource
    private ProductService service;


    @ResponseBody
    @RequestMapping(value="/shanglist")
    public Object listTwo(){
        List<Product> product = shangservice.cha();
        Object obj= JSON.toJSONString(product);
        return obj;
    }
    /**
     * 查询所有商品（未上架）
     * @param
     * @return
     */
    @ResponseBody
    @RequestMapping(value="/shanglist2")
    public Object list(){
        List<Product> product = shangservice.cha2();
        Object obj= JSON.toJSONString(product);
        return obj;
    }
    /**
     * 修改商品状态（下架）
     * @param
     * @return
     */

    @ResponseBody
    @RequestMapping(value="/shangupdate")
    public Object updata(@RequestParam (required = false)List s){
        int result = shangservice.update(s);
        if(result>0){
            return "1";
        }else{
            return "0";
        }
    }
    /**
     * 修改商品状态（上架）
     * @param
     * @return
     */

    @ResponseBody
    @RequestMapping(value="/shangupdate1")
    public Object updata1(@RequestParam (required = false)List s){
        int result = shangservice.update1(s);
        if(result>0){
            return "1";
        }else{
            return "0";
        }
    }

    @RequestMapping("/modify")
    public String shopshow(Model model, @RequestParam(value = "id")Integer id){
        List<ProductPic> pics = service.selectAllPicById(id);
        model.addAttribute("pics",pics);
        Product product = service.selectPoroductById(id);
        model.addAttribute("product",product);
        List<Sku> skus = service.selectAllSkuById(id);
        List<String> skuPropertyIds = new ArrayList<>();
        List<String> skuOptionIds = new ArrayList<>();
        String options = "";
        for (int k = 0;k < skus.size();k++){
            String string = skus.get(k).getSkuCon();
            String substring = string.substring(0, string.length()-1);//截取最后一个
            System.out.println(substring);
            String[] split = substring.split(",");//以逗号分割
            for (String string2 : split) {
                int q = 0;
                for(int i=0;i<string2.length();i++) {
                    if(string2.indexOf(":", i)!=-1){
                        q++;
                    }
                }
                String skucon1 = string2.substring(q,string2.length());
                String skucon2 = string2.substring(0,q-1);

                if (!skuOptionIds.contains(skucon1)){
                    skuOptionIds.add(skucon1);
                    options += skucon1+",";
                }
                if (!skuPropertyIds.contains(skucon2)){
                    skuPropertyIds.add(skucon2);
                }
            }
        }
        System.out.println(options);
        model.addAttribute("productId",id);
        model.addAttribute("options",options);
        return "/backstage/modifyProject";
    }

    @ResponseBody
    @GetMapping("/chasku")
    public Object selectSkus( @RequestParam(value = "id")Integer id){
        List<Sku> skus = service.selectAllSkuById(id);
        Object obj = JSONArray.toJSONString(skus);
        return obj;
    }

    @Scheduled(cron = "0 0 2 * * *" )
    public void dingshiXiajia(){
        String nowTimeStr = sDateFormat.format(new Date());
        shangservice.updateByTime(nowTimeStr);
    }
}
