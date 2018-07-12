package com.ageless.controller;

import com.ageless.pojo.Evaluate;
import com.ageless.pojo.Product;
import com.ageless.service.EvaluateService;
import com.ageless.util.*;
import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/haha")
public class EvaluateController {
    @Resource
    private EvaluateService evaluateService;

    //跳转页面
    @RequestMapping(value = "/first")
    public String shouYe(){
        return "order_evaluate";
    }

    //新增方法
    @PostMapping(value = "/insert")
    @ResponseBody
    public Object add(HttpServletRequest request) throws IOException {
        Evaluate ep=new Evaluate();
        MultipartFile shopImg = null;
        Product product=new Product();
        product.setId(2);
          UploadUtil up=new UploadUtil();
         List<String> tupian= up.uploadPic(request,product);
        String dengJi = HttpServletRequestUtil.getString(request, "dengJi");
        String pingjia = HttpServletRequestUtil.getString(request, "pingjia");
        ep.setDengJi(dengJi);
        ep.setFile(pingjia);
      for (int i=0;i<tupian.size();i++) {
          System.out.println("我是长度"+tupian.size());
            if (tupian.get(i)!=null){
                if (i==0){
                    ep.setPhoto1(tupian.get(i));
                    System.out.println("我是第一张图片"+tupian.get(i));
                }
                if (i==1){
                    ep.setPhoto2(tupian.get(i));
                    System.out.println("我是第二张图片"+tupian.get(i));
                }
                if (i==2){
                    ep.setPhoto3(tupian.get(i));
                    System.out.println("我是第三张图片"+tupian.get(i));
                }
                if (i==3){
                    ep.setPhoto4(tupian.get(i));
                    System.out.println("我是第四张图片"+tupian.get(i));
                }
                if (i==4){
                    ep.setPhoto5(tupian.get(i));
                    System.out.println("我是第五张图片"+tupian.get(i));
                }
            }
      }




        ep.setUesrId(1);
       ep.setProductId(2);
      int i=evaluateService.add(ep);

      System.out.println("pppppp"+i);
      Object obj=JSON.toJSON(i);
      return obj;
    }
}
