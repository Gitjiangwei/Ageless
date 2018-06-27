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

    @RequestMapping(value="cha",method = RequestMethod.GET)
    public String ll(Model model,@RequestParam(value = "id",defaultValue = "2")Integer id){
        Product product = service.selectPoroductById(id);
        List<Sku> skus = service.selectAllSkuById(id);
        List<SkuOption> options = service.selectAllSkuoptionById(id);
        List<String> optionIds = new ArrayList<String>();
        for (SkuOption opt:options) {
            optionIds.add(opt.getId().toString());
        }
        List<SkuProperty> properties = service.selectAllSkupropertyByIds(optionIds);
        List<Integer> thefirst = new ArrayList();
        for (SkuOption opt2:options) {
            for (SkuProperty pro:properties) {
                if (pro.getCategoryId() == opt2.getId()){
                    thefirst.add(pro.getId());
                    break;
                }
            }
        }
        StringBuffer skucon = new StringBuffer();
        Integer emm = 0;
        for (SkuOption skuopt:options) {
            skucon.append(skuopt.getId() + ":" + thefirst.get(emm) + ",");
           emm ++;
        }
        Sku sku = service.selectSkuByCon(skucon.toString());
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
        List<SkuOption> options = service.selectAllSkuoptionById(id);
        List<String> optionIds = new ArrayList<String>();
        for (SkuOption opt:options) {
            optionIds.add(opt.getId().toString());
        }
        List<SkuProperty> properties = service.selectAllSkupropertyByIds(optionIds);
        List<Integer> thefirst = new ArrayList();
        String[] thenext = request.getParameterValues("ary[]");
        for (int i = 0;i < thenext.length;i++){
            thefirst.add(Integer.parseInt(thenext[i]));
        }
        System.out.println("---------------+++++++++++++++++++++++++");
        System.out.println(thefirst.size());
        StringBuffer skucon = new StringBuffer();
        Integer emm = 0;
        for (SkuOption skuopt:options) {
            skucon.append(skuopt.getId() + ":" + thefirst.get(emm) + ",");
            emm ++;
        }
        Sku sku = service.selectSkuByCon(skucon.toString());
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
