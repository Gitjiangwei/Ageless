package com.ageless.controller;

import java.util.List;

import com.alibaba.fastjson.JSON;
import com.ageless.pojo.Area;
import com.ageless.service.AreaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;


@Controller
@RequestMapping(value = "/superadmin")
public class AreaController {

	Logger logger = LoggerFactory.getLogger(AreaController.class);

	@Resource
	private AreaService areaService;

	@GetMapping("/hello")
	@ResponseBody
	public Object listArea() {
	   List<Area> areaList= areaService.seleAll();
		Object obj= JSON.toJSON(areaList);
		return obj;
	}

	@GetMapping("/index.html")
	@ResponseBody
	public ModelAndView index(ModelAndView mv) {
		mv.setViewName("index");
		return mv;
	}

	@GetMapping("/ss.html")
	public String index() {
		return "login";
	}

	@GetMapping("/test")
	@ResponseBody
	public String test(){
		createException();
		return "正常";
	}

	@GetMapping("/error.html")
	public String tests(){

		return "error/error";
	}
	private  void createException(){
		int i=5/0;
	}





}
