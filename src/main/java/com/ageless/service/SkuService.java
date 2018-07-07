package com.ageless.service;

import com.ageless.pojo.Sku;

import java.util.List;

public interface SkuService {

    int addSku(List<Sku> sk, Integer productId);

    /*int modifySku(Sku sku);*/

    int deleteSku(Integer productId);
}
