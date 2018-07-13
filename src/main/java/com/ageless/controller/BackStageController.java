package com.ageless.controller;

import com.ageless.pojo.CategoryOne;
import com.ageless.pojo.Sort;
import com.ageless.pojo.User;
import com.ageless.service.CategoryOneService;
import com.ageless.service.SortconService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping(value="backstage")
public class BackStageController {

    @Autowired
    private SortconService sortconService;
    @Autowired
    private CategoryOneService categoryOneService;

    /**
     * 公告后台
     * @return
     */
    @GetMapping("index.html")
    public String index(HttpServletRequest request){
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        if(user == null){
            return "/backstage/back_login";
        }
        return "backstage/index";
    }

    @GetMapping("noticeAll.html")
    public String noticeAll(HttpServletRequest request){
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        if(user == null){
            return "/backstage/back_login";
        }
        return "backstage/noticeAll";
    }
    @GetMapping("noticeadd.html")
    public String noticeadd(HttpServletRequest request){
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        if(user == null){
            return "/backstage/back_login";
        }
        return "backstage/noticeadd";
    }
    @GetMapping("noticetype.html")
    public String noticetype(HttpServletRequest request){
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        if(user == null){
            return "/backstage/back_login";
        }
        return "backstage/noticetype";
    }

    @GetMapping("/comment.html")
    public String comment(HttpServletRequest request){
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        if(user == null){
            return "/backstage/back_login";
        }
        return "backstage/comment";
    }

    @GetMapping("/com_details.html")
    public String com_details(Integer  productId, HttpServletRequest request){
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        if(user == null){
            return "/backstage/back_login";
        }
        request.setAttribute("productId",productId);
        return "backstage/com_details";
    }

    @GetMapping(value="/goCategory1")
    public String goCategory1(HttpServletRequest request){
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        if(user == null){
            return "/backstage/back_login";
        }
        return "/backstage/category1";
    }

    @GetMapping(value="/goCategory2")
    public String goCategory2(HttpServletRequest request){
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        if(user == null){
            return "/backstage/back_login";
        }
        return "/backstage/category2";
    }

    /**
     * 进入三级分类页面
     * @return
     */
    @GetMapping(value="/goThree")
    public String GoTh(HttpServletRequest request){
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        if(user == null){
            return "/backstage/back_login";
        }
        return "/backstage/category3";
    }

    @RequestMapping(value = "/sortcon")
    public String selectAll(@RequestParam(required = false) String name, @RequestParam(required = false)String categoryName,
                            @RequestParam(required = false)Integer categoryThree, @RequestParam(required = false)Integer sortId, HttpSession session){
        User user = (User)session.getAttribute("user");
        if(user == null){
            return "/backstage/back_login";
        }
        if (name == "") {
            name=null;
        }

        List<CategoryOne> lg=categoryOneService.Onelist(categoryName);
        List<Sort> ls= sortconService.selectAll(name,categoryThree,sortId);
        session.setAttribute("category",lg);


        session.setAttribute("lis",ls);
        System.out.println("-----------"+ls);
        return "/backstage/sortcon";
    }

    @GetMapping("/su")
    public String su(ModelAndView mv, @RequestParam(required = false)String categoryName, HttpSession session){
        User user = (User)session.getAttribute("user");
        if(user == null){
            return "/backstage/back_login";
        }
        List<CategoryOne> lg=categoryOneService.Onelist(categoryName);
        session.setAttribute("category",lg);
        return "/backstage/sortcon1";

    }

    @GetMapping("/goshangjia")
    public String goshangjia(HttpServletRequest request){
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        if(user == null){
            return "/backstage/back_login";
        }
        return "/backstage/category";
    }

    @GetMapping("/goxiajia")
    public String goxiajia(HttpServletRequest request){
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        if(user == null){
            return "/backstage/back_login";
        }
        return "/backstage/shang";
    }

    //订单后台需要
    @GetMapping("/dingdanPage")
    public String dingdanPage(HttpServletRequest request){
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        if(user == null){
            return "/backstage/back_login";
        }
        return "backstage/orderAll";
    }
}
