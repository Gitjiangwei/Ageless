package com.ageless.service;

import com.ageless.dto.ShopExecution;
import com.ageless.pojo.Shop;
import org.springframework.web.multipart.commons.CommonsMultipartFile;



public interface ShopService {
	/**
	 * 新增店铺
	 * 
	 * @param shop
	 * @return
	 */
	ShopExecution addShop(Shop shop, CommonsMultipartFile shopImg);

	/**
	 * 更新店铺信息
	 * 
	 * @param shop
	 * @return
	 */
	int updateShop(Shop shop);
}
