package com.ageless.controller;


import com.ageless.pojo.Product;
import com.ageless.pojo.Sku;
import com.ageless.pojo.SkuOption;
import com.ageless.pojo.SkuProperty;
import com.ageless.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/commodity")
public class ProductController {

    @Resource
    private ProductService service;

    @RequestMapping("/shopshow")
    public String shopshow(Model model,@RequestParam(value = "id",defaultValue = "2")Integer id){
        Product product = service.selectPoroductById(id);
        List<Sku> skus = service.selectAllSkuById(id);
        List<String> skuPropertyIds = new ArrayList<>();
        List<String> skuOptionIds = new ArrayList<>();
        for (int k = 0;k < skus.size();k++){
            String string = skus.get(k).getSkuCon();
            String substring = string.substring(0, string.length()-1);//截取最后一个
            System.out.println(substring);
            String[] split = substring.split(",");//以逗号分割
            Integer len = split.length;
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
                }
                if (!skuPropertyIds.contains(skucon2)){
                    skuPropertyIds.add(skucon2);
                }
            }
        }
        System.out.println("---");
        System.out.println(skuPropertyIds);
        System.out.println(skuOptionIds);
        List<SkuProperty> properties = service.selectAllSkupropertyByIds(skuPropertyIds);
        List<SkuOption> options = service.selectAllSkuoptionById(skuOptionIds);
        List<Integer> thefirst = new ArrayList();
        for (SkuProperty pro:properties) {
            for (SkuOption opt2:options) {
                if (pro.getId() == opt2.getProductId()){
                    thefirst.add(opt2.getId());
                    break;
                }
            }
        }
        System.out.println(options.toString());
        System.out.println("-=-=-=-=-=--==--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
        System.out.println(thefirst.size());
        model.addAttribute("productId",id);
        model.addAttribute("firsts",thefirst);
        model.addAttribute("product",product);
        return "item_show";
    }

    @RequestMapping("/productRight-y")
    public ModelAndView productRight(ModelAndView modelAndView, HttpServletRequest request, @RequestParam("id")Integer id){
        Product product = service.selectPoroductById(id);
        List<Sku> skus = service.selectAllSkuById(id);
        List<String> skuPropertyIds = new ArrayList<>();
        List<String> skuOptionIds = new ArrayList<>();
        for (int k = 0;k < skus.size();k++){
            String string = skus.get(k).getSkuCon();
            String substring = string.substring(0, string.length()-1);//截取最后一个
            System.out.println(substring);
            String[] split = substring.split(",");//以逗号分割
            Integer len = split.length;
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
                }
                if (!skuPropertyIds.contains(skucon2)){
                    skuPropertyIds.add(skucon2);
                }
            }
        }
        System.out.println("---");
        System.out.println(skuPropertyIds);
        System.out.println(skuOptionIds);
        List<SkuProperty> properties = service.selectAllSkupropertyByIds(skuPropertyIds);
        List<SkuOption> options = service.selectAllSkuoptionById(skuOptionIds);
        List<Integer> thefirst = new ArrayList();
        String[] thenext = request.getParameterValues("ary[]");
        for (int i = 0;i < thenext.length;i++){
            thefirst.add(Integer.parseInt(thenext[i]));
        }
        StringBuffer skucon2 = new StringBuffer();
        Integer emm = 0;
        System.out.println(thefirst.size());
        for (SkuProperty skupro:properties) {
            System.out.println("------skuproId:"+skupro.getId() + "-------------thefirst"+thefirst.get(emm)+"-----------------------------");
            skucon2.append(skupro.getId() + ":" + thefirst.get(emm) + ",");
            emm ++;
        }
        Sku sku = service.selectSkuByCon(skucon2.toString());
        modelAndView.addObject("options",options);
        modelAndView.addObject("properties",properties);
        modelAndView.addObject("product",product);
        modelAndView.addObject("thefirst",thefirst);
        modelAndView.addObject("sku",sku);
        modelAndView.setViewName("item_right");
        return modelAndView;
    }

}
