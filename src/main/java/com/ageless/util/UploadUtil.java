package com.ageless.util;

import com.ageless.pojo.Product;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class UploadUtil {

    public List<String> uploadPic(HttpServletRequest request, Product pro) throws IOException {
        MultipartFile shopImg = null;
        CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver(
                request.getSession().getServletContext());// 图片解析器

        if (commonsMultipartResolver.isMultipart(request)) {
            MultipartHttpServletRequest multipartHttpServletRequest =(MultipartHttpServletRequest)request;
            List<String> li = new ArrayList<>();
            for (int i = 1 ; i<=Contants.imgNums ; i++){
                String name = "shopImg"+i;
                shopImg =multipartHttpServletRequest.getFile(name);
                if(shopImg == null){
                    break;
                }
                String img = addImg(pro,shopImg.getInputStream(),shopImg.getOriginalFilename());
                li.add(img);
            }
            return li;
        }
        return null;
    }

    private String addImg(Product product, InputStream shopImg, String imgName) {
        // 获取shop图片目录的相对值路径
        String dest = PathUtil.getShopImagePath(product.getId());
        String shopImgAddr = ImagesUtil
                .generateThumbnail(shopImg, imgName, dest);
        return shopImgAddr;
    }
}
