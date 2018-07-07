package com.ageless.controller;


import com.ageless.pojo.*;
import com.ageless.service.ProductAndPicService;
import com.ageless.service.ProductService;
import com.ageless.service.SkuService;
import com.ageless.util.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@RequestMapping("/commodity")
public class ProductController {

    private static final SimpleDateFormat sDateFormat = new SimpleDateFormat(
            "yyyyMMdd");// 时间
    private static final Random r = new Random();// 随机数

    @Resource
    private ProductService service;
    @Autowired
    private SkuService skuService;

    @Autowired
    private ProductAndPicService picService;

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
        return "/backstage/category";
    }

    @GetMapping("/goxiajia")
    public String goxiajia(){
        return "/backstage/shang";
    }

    @GetMapping("/goaddproject")
    public String goshgoaddprojectangjia(@RequestParam("context")String context,@RequestParam("oneId")Integer oneId,
                                         @RequestParam("twoId")Integer twoId,@RequestParam("threeId")Integer threeId,Model model){
        model.addAttribute("context",context);
        model.addAttribute("oneId",oneId);
        model.addAttribute("twoId",twoId);
        model.addAttribute("threeId",threeId);
        return "/backstage/addProject";
    }

    @ResponseBody
    @PostMapping("/addproject")
    public Object addproject(HttpServletRequest request) throws IOException, ParseException {
        ObjectMapper mapper = new ObjectMapper();
        String shopStr = HttpServletRequestUtil.getString(request, "shopStr");// shopStr为前台传入的值
        Product pro = mapper.readValue(shopStr,Product.class);

        String propid = HttpServletRequestUtil.getString(request, "propid");
        String propvals = HttpServletRequestUtil.getString(request, "propvals");
        int rannum = r.nextInt(89) + 10;
        String nowTimeStr = sDateFormat.format(new Date());
        pro.setProductId(nowTimeStr + rannum);
        pro.setUpdate(new Date());
        String down = addMonth(nowTimeStr,1);
        Date date = sDateFormat.parse(down);
        pro.setDowndate(date);
        pro.setStatus(1);

        String[] prop = propid.split(",");
        String[] propval = propvals.split("-");
        String[] nums = propval[0].split(",");
        pro.setPrice(Double.parseDouble(nums[2]));
        int res = service.add(pro);
        List<Sku> list = new ArrayList<Sku>();
        for (int i = 0 ; i<propval.length;i++) {
            Sku ssku = new Sku();
            String[] pval = propval[i].split(",");
            String sku = "";
            for (int j = 0; j < prop.length; j++) {
                sku += prop[j] + ":" + pval[j] + ",";
            }
            ssku.setSkuCon(sku);
            ssku.setPrice(Double.parseDouble(pval[2]));
            ssku.setKucun(Integer.parseInt(pval[3]));
            list.add(ssku);

        }
        int res2 = skuService.addSku(list,pro.getId());
        List<String> li = new UploadUtil().uploadPic(request,pro);
        if(li!=null){
            picService.addPic(li,pro.getId());
            if(res >0 && res2 >0){
                return "1";
            }else {
                return "0";
            }
        }
        return "0";
    }

    public String addMonth(String date, int month) {
        String nowDate = null;
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        try {
            Date parse = format.parse(date);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(parse);
            calendar.add(Calendar.MONTH, month);
            nowDate = format.format(calendar.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return nowDate;
    }

    @ResponseBody
    @PostMapping("/modifyproject")
    public Object modifyproject(HttpServletRequest request) throws IOException, ParseException {
        ObjectMapper mapper = new ObjectMapper();
        String shopStr = HttpServletRequestUtil.getString(request, "shopStr");// shopStr为前台传入的值
        Product pro = mapper.readValue(shopStr,Product.class);
        System.out.println(pro);
        String propid = HttpServletRequestUtil.getString(request, "propid");
        String propvals = HttpServletRequestUtil.getString(request, "propvals");
        String nowTimeStr = sDateFormat.format(new Date());
        pro.setUpdate(new Date());
        String down = addMonth(nowTimeStr,1);
        Date date = sDateFormat.parse(down);
        pro.setDowndate(date);
        pro.setStatus(1);

        String[] prop = propid.split(",");
        String[] propval = propvals.split("-");
        String[] nums = propval[0].split(",");
        pro.setPrice(Double.parseDouble(nums[2]));
        System.out.println(pro);
        int res = service.modifyProduct(pro);

        int result = skuService.deleteSku(pro.getId());
        List<Sku> list = new ArrayList<Sku>();
        for (int i = 0 ; i<propval.length;i++) {
            Sku ssku = new Sku();
            String[] pval = propval[i].split(",");
            String sku = "";
            for (int j = 0; j < prop.length; j++) {
                sku += prop[j] + ":" + pval[j] + ",";
            }
            ssku.setSkuCon(sku);
            ssku.setPrice(Double.parseDouble(pval[2]));
            ssku.setKucun(Integer.parseInt(pval[3]));
            list.add(ssku);
        }
        int res2 = skuService.addSku(list,pro.getId());
        MultipartFile shopImg = null;
        CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver(
                request.getSession().getServletContext());// 图片解析器
        if (commonsMultipartResolver.isMultipart(request)) {
            MultipartHttpServletRequest multipartHttpServletRequest =(MultipartHttpServletRequest)request;
            for (int i = 1; i<= Contants.imgNums ; i++){
                String name = "shopImg"+i;
                shopImg =multipartHttpServletRequest.getFile(name);
                if(shopImg != null){
                    picService.deletePic(pro.getId());
                    ImagesUtil.deleteFileOrPath(PathUtil.getShopImagePath(pro.getId()));
                    List<String> li = new UploadUtil().uploadPic(request,pro);
                    if(li!=null){
                        picService.addPic(li,pro.getId());
                    }
                }
            }

        }
        if(res >0 && result > 0 && res2 >0){
            return "1";
        }else {
            return "0";
        }
    }
}
