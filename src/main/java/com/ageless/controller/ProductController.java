package com.ageless.controller;


import com.ageless.pojo.*;
import com.ageless.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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

    @RequestMapping("/shopshow.html")
    public String shopshow(Model model,@RequestParam(value = "id",defaultValue = "2")Integer id){
        List<ProductPic> pics = service.selectAllPicById(id);
        ProductPic firtsPic = pics.get(0);
        List<Property> propertys = service.selectPropertyAllById(id);
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
        model.addAttribute("productId",id);
        model.addAttribute("propertys",propertys);
        model.addAttribute("firsts",thefirst);
        model.addAttribute("product",product);
        model.addAttribute("firtsPic",firtsPic);
        model.addAttribute("pics",pics);
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
        List<SkuProperty> properties = service.selectAllSkupropertyByIds(skuPropertyIds);
        List<SkuOption> options = service.selectAllSkuoptionById(skuOptionIds);
        List<Integer> thefirst = new ArrayList();
        String[] thenext = request.getParameterValues("ary[]");
        for (int i = 0;i < thenext.length;i++){
            thefirst.add(Integer.parseInt(thenext[i]));
        }
        StringBuffer skucon2 = new StringBuffer();
        Integer emm = 0;
        System.out.println(thefirst);
        for (SkuProperty skupro:properties) {
            System.out.println("------skuproId:"+skupro.getId() + "-------------thefirst"+thefirst.get(emm)+"-----------------------------");
            skucon2.append(skupro.getId() + ":" + thefirst.get(emm) + ",");
            emm ++;
        }
        Sku sku = service.selectSkuByCon(skucon2.toString(),id);
        modelAndView.addObject("options",options);
        modelAndView.addObject("properties",properties);
        modelAndView.addObject("product",product);
        modelAndView.addObject("thefirst",thefirst);
        modelAndView.addObject("sku",sku);
        modelAndView.setViewName("item_right");
        return modelAndView;
    }

    @GetMapping("/goshangjia")
    public String goshangjia(){
        return "/management/category";
    }

    @GetMapping("/goxiajia")
    public String goxiajia(){
        return "/management/category";
    }

    @GetMapping("/goaddproject")
    public String goshgoaddprojectangjia(@RequestParam("context")String context,@RequestParam("oneId")Integer oneId,
                                         @RequestParam("twoId")Integer twoId,@RequestParam("threeId")Integer threeId,Model model){
        model.addAttribute("context",context);
        model.addAttribute("oneId",oneId);
        model.addAttribute("twoId",twoId);
        model.addAttribute("threeId",threeId);
        return "/management/addProject";
    }
}
