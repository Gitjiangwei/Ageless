package com.ageless.controller;

import java.util.Date;


import com.ageless.pojo.Shop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;



@Controller
@RequestMapping(value = "/shop")
public class ShopController {

	@Autowired
//	private ShopService shopService;

	/**
	 * 添加
	 * 
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/insertshop")
	public Object insertShop() {
		Shop shop = new Shop();

		shop.setShopName("咖啡店");
		shop.setShopDesc("test");
		shop.setShopAddr("test");
		shop.setPhone("test");
		shop.setShopImg("test");
		shop.setCreateTime(new Date());
		shop.setEnableStatus(1);
		shop.setAdvice("审核中");
	/*	int result = shopService.addShop()*/
		return null;
	}

	/**
	 * 更新店铺
	 * 
	 * @return
	 */
//	@ResponseBody
//	@RequestMapping(value = "/updateshop")
//	public Object updateShop() {
//		Shop shop = new Shop();
//		shop.setShopId(3L);
//		shop.setShopName("奶茶店");
//		shop.setShopDesc("非常好喝！");
//		shop.setLastEditTime(new Date());
//		int result = shopService.updateShop(shop);
//		return result;
//	}

}
