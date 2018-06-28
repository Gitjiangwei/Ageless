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
@RequestMapping("/product")
public class ProductController {

    @Resource
    private ProductService service;

    @RequestMapping(value="cha",method = RequestMethod.GET)
    public String ll(Model model,@RequestParam(value = "id",defaultValue = "2")Integer id){
        Product product = service.selectPoroductById(id);
        List<Sku> skus = service.selectAllSkuById(id);
        System.out.println("------------------------------------------------------------------");
        String skucon = skus.get(0).getSkuCon();
        Integer len = skucon.length() / 4;
        List<String> skuPropertyIds = new ArrayList<>();
        for (int i = 0 ; i < len ; i++){
            skuPropertyIds.add(skucon.substring(4*i,(4*i)+1));
        }
        List<String> skuOptionIds = new ArrayList<>();
        for (int i = 0 ; i < skus.size() ; i++){
            for (int j = 0 ; j < len ; j++){
                String a = skus.get(i).getSkuCon().substring((4*j)+2,(4*j)+3);
                if (!skuOptionIds.contains(a)){
                    skuOptionIds.add(a);
                }
            }
        }
        List<SkuProperty> properties = service.selectAllSkupropertyByIds(skuPropertyIds);
        List<SkuOption> options = service.selectAllSkuoptionById(skuOptionIds);
        System.out.println(properties.toString());
        System.out.println(options.toString());
        System.out.println("-----------------------------skuPropertyIds:"+skuPropertyIds+"-------------------------------------");
        System.out.println("-----------------------------skuOptionIds:"+skuOptionIds+"-------------------------------------");
        List<Integer> thefirst = new ArrayList();
        for (SkuProperty pro:properties) {
            for (SkuOption opt2:options) {
                if (pro.getId() == opt2.getProductId()){
                    thefirst.add(opt2.getId());
                    break;
                }
            }
        }
        StringBuffer skucon2 = new StringBuffer();
        Integer emm = 0;
        System.out.println("++++++++++++++++++++++"+thefirst.toString()+"++++++++++++++++++++++++");
        for (SkuProperty skupro:properties) {
            System.out.println("------skuproId:"+skupro.getId() + "-------------thefirst"+thefirst.get(emm)+"-----------------------------");
            skucon2.append(skupro.getId() + ":" + thefirst.get(emm) + ",");
            emm ++;
        }
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println(skucon2.toString());
        System.out.println("================================================================");
        Sku sku = service.selectSkuByCon(skucon2.toString());
        System.out.println("------id:" + sku.getSKUId() + "------name:" + sku.getSkuCon() + "------price:" +
                sku.getPrice() + "-------kucun:" + sku.getKucun());
        model.addAttribute("options",options);
        model.addAttribute("properties",properties);
        model.addAttribute("product",product);
        model.addAttribute("thefirst",thefirst);
        model.addAttribute("sku",sku);
        return "item_show";
    }

    @RequestMapping("/productRight-y")
    public ModelAndView productRight(ModelAndView modelAndView, HttpServletRequest request, @RequestParam("id")Integer id){
        Product product = service.selectPoroductById(id);
        List<Sku> skus = service.selectAllSkuById(id);
        System.out.println("------------------------------------------------------------------");
        String skucon = skus.get(0).getSkuCon();
        Integer len = skucon.length() / 4;
        List<String> skuPropertyIds = new ArrayList<>();
        for (int i = 0 ; i < len ; i++){
            skuPropertyIds.add(skucon.substring(4*i,(4*i)+1));
        }
        List<String> skuOptionIds = new ArrayList<>();
        for (int i = 0 ; i < skus.size() ; i++){
            for (int j = 0 ; j < len ; j++){
                String a = skus.get(i).getSkuCon().substring((4*j)+2,(4*j)+3);
                if (!skuOptionIds.contains(a)){
                    skuOptionIds.add(a);
                }
            }
        }
        List<SkuProperty> properties = service.selectAllSkupropertyByIds(skuPropertyIds);
        List<SkuOption> options = service.selectAllSkuoptionById(skuOptionIds);
        System.out.println(properties.toString());
        System.out.println(options.toString());
        System.out.println("-----------------------------skuPropertyIds:"+skuPropertyIds+"-------------------------------------");
        List<Integer> thefirst = new ArrayList();
        String[] thenext = request.getParameterValues("ary[]");
        for (int i = 0;i < thenext.length;i++){
            thefirst.add(Integer.parseInt(thenext[i]));
        }
        StringBuffer skucon2 = new StringBuffer();
        Integer emm = 0;
        System.out.println("++++++++++++++++++++++"+properties.size()+"++++++++++++++++++++++++");
        for (SkuProperty skupro:properties) {
            System.out.println("------skuproId:"+skupro.getId() + "-------------thefirst"+thefirst.get(emm)+"-----------------------------");
            skucon2.append(skupro.getId() + ":" + thefirst.get(emm) + ",");
            emm ++;
        }
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println(skucon2.toString());
        System.out.println("================================================================");
        Sku sku = service.selectSkuByCon(skucon2.toString());
        System.out.println("------id:" + sku.getSKUId() + "------name:" + sku.getSkuCon() + "------price:" +
                sku.getPrice() + "-------kucun:" + sku.getKucun());

        modelAndView.addObject("options",options);
        modelAndView.addObject("properties",properties);
        modelAndView.addObject("product",product);
        modelAndView.addObject("thefirst",thefirst);
        modelAndView.addObject("sku",sku);
        modelAndView.setViewName("item_right");
        return modelAndView;
    }
}
