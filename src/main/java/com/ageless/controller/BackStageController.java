package com.ageless.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="backstage")
public class BackStageController {
    /**
     * 公告后台
     * @return
     */
    @GetMapping("index.html")
    public String index(){
       return "backstage/index";
    }

    @GetMapping("noticeAll.html")
    public String noticeAll(){
        return "backstage/noticeAll";
    }
    @GetMapping("noticeadd.html")
    public String noticeadd(){
        return "backstage/noticeadd";
    }
    @GetMapping("noticetype.html")
    public String noticetype(){
        return "backstage/noticetype";
    }
}
